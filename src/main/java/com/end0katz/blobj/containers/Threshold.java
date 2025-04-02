package com.end0katz.blobj.containers;

/**
 * A threshold is a {@link Container} that contains a boolean. The boolean is
 * modified through testing if various numbers exceed certain thresholds.
 */
public class Threshold implements Container<Boolean> {

    /**
     * The current value of this threshold.
     */
    private boolean active = false;

    /**
     * The lower bound of this threshold.
     */
    double boundLower;
    /**
     * The upper bound of this threshold.
     */
    double boundUpper;

    /**
     * If {@code <} or {@code <=} is used for boundLower.
     */
    boolean lowerInclusive;
    /**
     * If {@code <} or {@code <=} is used for boundUpper.
     */
    boolean upperInclusive;

    /**
     * Construct a new threshold with both sides inclusive.
     *
     * @param lowerBound the lower bound of this threshold. (inclusive)
     * @param upperBound the upper bound of this threshold. (inclusive)
     */
    public Threshold(double lowerBound, double upperBound) {
        this(lowerBound, upperBound, true);
    }

    /**
     * Construct a new threshold with both sides of the same
     * inclusive/exclusiveness
     *
     * @param lowerBound the lower bound of this threshold.
     * @param upperBound the upper bound of this threshold.
     * @param inclusive if {@code lowerBound} and {@code upperBound} are
     * inclusive (true) or exclusive (false)
     */
    public Threshold(double lowerBound, double upperBound, boolean inclusive) {
        this(lowerBound, inclusive, upperBound, inclusive);
    }

    /**
     * Construct a new threshold.
     *
     * @param lowerBound the lower bound of this threshold.
     * @param lowerBoundInclusive if {@code <} or {@code <=} is used for
     * {@code lowerBound}
     * @param upperBound the upper bound of this threshold.
     * @param upperBoundInclusive if {@code <} or {@code <=} is used for
     * {@code upperBound}
     */
    public Threshold(double lowerBound, boolean lowerBoundInclusive, double upperBound, boolean upperBoundInclusive) {
        this.boundLower = lowerBound;
        this.boundUpper = upperBound;

        this.lowerInclusive = lowerBoundInclusive;
        this.upperInclusive = upperBoundInclusive;
    }

    @Override
    public Boolean get() {
        return active;
    }

    /**
     * Tests {@code i}, and:
     * <ul><li>If it exceeds the upper boundary, store {@code true} in
     * container</li>
     * <li>If it exceeds the lower boundary, store {@code false} in
     * container</li>
     * <li>If it exceeds neither boundary, leave the container
     * unchanged</li></ul>
     *
     * @param i the value to test.
     * @return if {@code i} exceeds either threshold.
     */
    public boolean test(double i) {
        if (i < boundLower || (lowerInclusive && (i == boundLower))) {
            active = false;
            return true;
        } else if (i > boundUpper || (upperInclusive && (i == boundUpper))) {
            active = true;
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        long temp;
        temp = Double.doubleToLongBits(boundLower);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(boundUpper);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        result = prime * result + (lowerInclusive ? 1231 : 1237);
        result = prime * result + (upperInclusive ? 1231 : 1237);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Threshold other = (Threshold) obj;
        return upperInclusive == other.upperInclusive
                && lowerInclusive == other.lowerInclusive
                && boundLower == other.boundLower
                && boundUpper == other.boundUpper;
    }

}
