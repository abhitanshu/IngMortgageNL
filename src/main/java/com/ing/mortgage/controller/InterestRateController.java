package com.ing.mortgage.controller;

import com.ing.mortgage.model.InterestRate;
import com.ing.mortgage.model.MortgageCheckRequest;
import com.ing.mortgage.model.MortgageCheckResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
/**
 * The InterestRateController class is a REST controller that handles requests related to interest rates and mortgage checks.
 */
@RestController
@RequestMapping("/api")
public class InterestRateController {
    private List<InterestRate> interestRates;

    /**
     * Constructs a new instance of InterestRateController and initializes the interest rates.
     */
    public InterestRateController() {
        // Initialize the interest rates (in-memory)
        interestRates = new ArrayList<>();
        interestRates.add(new InterestRate(5, new BigDecimal("2.5"), LocalDateTime.now()));
        interestRates.add(new InterestRate(10, new BigDecimal("3.0"), LocalDateTime.now()));
        interestRates.add(new InterestRate(15, new BigDecimal("3.5"), LocalDateTime.now()));
    }

    /**
     * Retrieves the list of interest rates.
     *
     * @return The list of interest rates.
     */
    @GetMapping("/interest-rates")
    public List<InterestRate> getInterestRates() {
        return interestRates;
    }

    /**
     * Performs a mortgage check based on the provided request.
     *
     * @param request The MortgageCheckRequest object containing the mortgage details.
     * @return The MortgageCheckResponse object containing the feasibility and monthly costs.
     */
    @PostMapping("/mortgage-check")
    public MortgageCheckResponse performMortgageCheck(@RequestBody MortgageCheckRequest request) {
        BigDecimal maxLoanValue = request.getIncome().multiply(new BigDecimal("4"));
        BigDecimal homeValue = request.getHomeValue();

        boolean feasible = request.getLoanValue().compareTo(maxLoanValue) <= 0 && request.getLoanValue().compareTo(homeValue) <= 0;

        // Calculate monthly costs
        BigDecimal monthlyCosts = calculateMonthlyCosts(request.getLoanValue(), request.getMaturityPeriod(), request.getInterestRate());

        return new MortgageCheckResponse(feasible, monthlyCosts);
    }

    /**
     * Calculates the monthly costs for a mortgage.
     *
     * @param loanValue      The loan value.
     * @param maturityPeriod The maturity period in years.
     * @param interestRate   The interest rate.
     * @return The monthly payment amount.
     */
    private BigDecimal calculateMonthlyCosts(BigDecimal loanValue, int maturityPeriod, BigDecimal interestRate) {
        // Convert the interest rate from percentage to decimal
        BigDecimal decimalInterestRate = interestRate.divide(BigDecimal.valueOf(100));

        // Calculate the monthly interest rate
        BigDecimal monthlyInterestRate = decimalInterestRate.divide(BigDecimal.valueOf(12), 8, RoundingMode.HALF_UP);

        // Calculate the number of payments (months)
        int numberOfPayments = maturityPeriod * 12;

        // Calculate the numerator: (1 + r)^n
        BigDecimal numerator = BigDecimal.ONE.add(monthlyInterestRate).pow(numberOfPayments);

        // Calculate the denominator: (1 + r)^n - 1
        BigDecimal denominator = numerator.subtract(BigDecimal.ONE);

        // Calculate the monthly payment amount
        BigDecimal monthlyPayment = loanValue
                .multiply(monthlyInterestRate)
                .multiply(numerator)
                .divide(denominator, 2, RoundingMode.HALF_UP);

        return monthlyPayment;
    }
}
