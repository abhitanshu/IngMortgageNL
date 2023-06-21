package com.ing.mortgage;

import com.ing.mortgage.controller.InterestRateController;
import com.ing.mortgage.model.InterestRate;
import com.ing.mortgage.model.MortgageCheckRequest;
import com.ing.mortgage.model.MortgageCheckResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
/**
 * This class contains the unit tests for the {@link InterestRateController} class.
 */
public class InterestRateControllerTest {

    private InterestRateController interestRateController;

    /**
     * Sets up the test environment before each test case.
     */
    @BeforeEach
    public void setup() {
        interestRateController = new InterestRateController();
    }

    /**
     * Tests the getInterestRates method of the InterestRateController class.
     */
    @Test
    public void testGetInterestRates() {
        // Invoke the getInterestRates method
        List<InterestRate> interestRates = interestRateController.getInterestRates();

        // Assert the size of the interestRates list
        assertEquals(3, interestRates.size());
    }

    /**
     * Tests the performMortgageCheck method of the InterestRateController class
     * when the mortgage is infeasible.
     */
    @Test
    public void testPerformMortgageCheck_InFeasible() {
        // Create a mortgage check request
        MortgageCheckRequest request = new MortgageCheckRequest(
                new BigDecimal("5000"),
                10,
                new BigDecimal("200000"),
                new BigDecimal("300000"),
                new BigDecimal("4.0")
        );

        // Perform the mortgage check
        MortgageCheckResponse response = interestRateController.performMortgageCheck(request);

        // Assert the feasibility and monthly costs
        assertEquals(false, response.isFeasible());
        assertEquals(new BigDecimal("2024.90"), response.getMonthlyCosts());
    }

    /**
     * Tests the performMortgageCheck method of the InterestRateController class
     * when the mortgage is feasible.
     */
    @Test
    public void testPerformMortgageCheck_Feasible() {
        // Create a mortgage check request
        MortgageCheckRequest request = new MortgageCheckRequest(
                new BigDecimal("10000"),
                5,
                new BigDecimal("10000"),
                new BigDecimal("100000"),
                new BigDecimal("10")
        );

        // Perform the mortgage check
        MortgageCheckResponse response = interestRateController.performMortgageCheck(request);

        // Assert the feasibility
        assertEquals(true, response.isFeasible());
    }
}
