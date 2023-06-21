package com.ing.mortgage.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
/**
 * The InterestRate class represents an interest rate with its maturity period, value, and last update time.
 */
public class InterestRate {
    private int maturityPeriod;
    private BigDecimal interestRate;
    private LocalDateTime lastUpdate;

    /**
     * Constructs a new instance of InterestRate with the specified maturity period, interest rate, and last update time.
     *
     * @param maturityPeriod The maturity period in years.
     * @param interestRate   The interest rate.
     * @param lastUpdate     The last update time of the interest rate.
     */
    public InterestRate(int maturityPeriod, BigDecimal interestRate, LocalDateTime lastUpdate) {
        this.maturityPeriod = maturityPeriod;
        this.interestRate = interestRate;
        this.lastUpdate = lastUpdate;
    }

    /**
     * Retrieves the maturity period of the interest rate.
     *
     * @return The maturity period in years.
     */
    public int getMaturityPeriod() {
        return maturityPeriod;
    }

    /**
     * Sets the maturity period of the interest rate.
     *
     * @param maturityPeriod The maturity period in years.
     */
    public void setMaturityPeriod(int maturityPeriod) {
        this.maturityPeriod = maturityPeriod;
    }

    /**
     * Retrieves the interest rate value.
     *
     * @return The interest rate.
     */
    public BigDecimal getInterestRate() {
        return interestRate;
    }

    /**
     * Sets the interest rate value.
     *
     * @param interestRate The interest rate.
     */
    public void setInterestRate(BigDecimal interestRate) {
        this.interestRate = interestRate;
    }

    /**
     * Retrieves the last update time of the interest rate.
     *
     * @return The last update time.
     */
    public LocalDateTime getLastUpdate() {
        return lastUpdate;
    }

    /**
     * Sets the last update time of the interest rate.
     *
     * @param lastUpdate The last update time.
     */
    public void setLastUpdate(LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}
