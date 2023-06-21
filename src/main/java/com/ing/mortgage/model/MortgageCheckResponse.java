package com.ing.mortgage.model;

import java.math.BigDecimal;
/**
 * The MortgageCheckResponse class represents a response to a mortgage check, including the feasibility of the mortgage
 * and the monthly costs.
 */
public class MortgageCheckResponse {
    private boolean feasible;
    private BigDecimal monthlyCosts;

    /**
     * Constructs a new instance of MortgageCheckResponse with the specified feasibility and monthly costs.
     *
     * @param feasible     The feasibility of the mortgage.
     * @param monthlyCosts The monthly costs.
     */
    public MortgageCheckResponse(boolean feasible, BigDecimal monthlyCosts) {
        this.feasible = feasible;
        this.monthlyCosts = monthlyCosts;
    }

    /**
     * Retrieves the feasibility of the mortgage.
     *
     * @return The feasibility.
     */
    public boolean isFeasible() {
        return feasible;
    }

    /**
     * Sets the feasibility of the mortgage.
     *
     * @param feasible The feasibility.
     */
    public void setFeasible(boolean feasible) {
        this.feasible = feasible;
    }

    /**
     * Retrieves the monthly costs.
     *
     * @return The monthly costs.
     */
    public BigDecimal getMonthlyCosts() {
        return monthlyCosts;
    }

    /**
     * Sets the monthly costs.
     *
     * @param monthlyCosts The monthly costs.
     */
    public void setMonthlyCosts(BigDecimal monthlyCosts) {
        this.monthlyCosts = monthlyCosts;
    }
}
