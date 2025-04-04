package com.end0katz.blobj.vec;

/**
 * Vector containing 2 {@link Double}s
 *
 * @param x
 *     the x component of this vector
 * @param y
 *     the y component of this vector
 * @see Vec2
 * @see Float3
 * @see Float4
 */
public record Float2(Double x, Double y) implements Vec2<Double, Float2> {

    @Override
    public Float2 _createNew(Double x, Double y) {
        return new Float2(x, y);
    }

    /**
     * Calculate and return the magnitude of this vector.
     *
     * @return the caclulated magnitude.
     */
    public double magnitude() {
        double result = 0.0;
        for (Double d : asArray()) {
            result += d * d;
        }
        return Math.sqrt(result);
    }

    /**
     * Calculate and return the taxicab magnitude of this vector.
     *
     * @return the calculated magnitude.
     *
     * @see <a href="https://en.wikipedia.org/wiki/Taxicab_geometry">The
     * wikipedia article on taxicab distance/magnitude</a>
     */
    public double taxicab_magnitude() {
        double result = 0.0;
        for (Double d : asArray()) {
            result += Math.abs(d);
        }
        return result;
    }
}
