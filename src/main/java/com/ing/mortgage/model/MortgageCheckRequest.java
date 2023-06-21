package com.ing.mortgage.model;

import java.math.BigDecimal;
/**
 * The MortgageCheckRequest class represents a request for mortgage check, including the borrower's income, maturity period,
 * loan value, home value, and interest rate.
 */
public class MortgageCheckRequest {
    private BigDecimal income;
    private int maturityPeriod;
    private BigDecimal loanValue;
    private BigDecimal homeValue;
    private BigDecimal interestRate;

    /**
     * Constructs a new instance of MortgageCheckRequest with the specified income, maturity period, loan value, home value,
     * and interest rate.
     *
     * @param income         The borrower's income.
     * @param maturityPeriod The maturity period in years.
     * @param loanValue      The loan value.
     * @param homeValue      The home value.
     * @param interestRate   The interest rate.
     */
    public MortgageCheckRequest(BigDecimal income, int maturityPeriod, BigDecimal loanValue, BigDecimal homeValue, BigDecimal interestRate) {
        this.income = income;
        this.maturityPeriod = maturityPeriod;
        this.loanValue = loanValue;
        this.homeValue = homeValue;
        this.interestRate = interestRate;
    }

    /**
     * Retrieves the borrower's income.
     *
     * @return The income.
     */
    public BigDecimal getIncome() {
        return income;
    }

    /**
     * Sets the borrower's income.
     *
     * @param income The income.
     */
    public void setIncome(BigDecimal income) {
        this.income = income;
    }

    /**
     * Retrieves the maturity period of the mortgage.
     *
     * @return The maturity period in years.
     */
    public int getMaturityPeriod() {
        return maturityPeriod;
    }

    /**
     * Sets the maturity period of the mortgage.
     *
     * @param maturityPeriod The maturity period in years.
     */
    public void setMaturityPeriod(int maturityPeriod) {
        this.maturityPeriod = maturityPeriod;
    }

    /**
     * Retrieves the loan value.
     *
     * @return The loan value.
     */
    public BigDecimal getLoanValue() {
        return loanValue;
    }

    /**
     * Sets the loan value.
     *
     * @param loanValue The loan value.
     */
    public void setLoanValue(BigDecimal loanValue) {
        this.loanValue = loanValue;
    }

    /**
     * Retrieves the home value.
     *
     * @return The home value.
     */
    public BigDecimal getHomeValue() {
        return homeValue;
    }

    /**
     * Sets the home value.
     *
     * @param homeValue The home value.
     */
    public void setHomeValue(BigDecimal homeValue) {
        this.homeValue = homeValue;
    }

    /**
     * Retrieves the interest rate.
     *
     * @return The interest rate.
     */
    public BigDecimal getInterestRate() {
        return interestRate;
    }

    /**
     * Sets the interest rate.
     *
     * @param interestRate The interest rate.
     */
    public void setInterestRate(BigDecimal interestRate) {
        this.interestRate = interestRate;
    }
}
