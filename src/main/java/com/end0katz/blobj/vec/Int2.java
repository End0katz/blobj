package com.end0katz.blobj.vec;

/**
 * Vector containing 2 {@link Integer}s
 *
 * @param x
 *     the x component of this vector
 * @param y
 *     the y component of this vector
 * @see Vec2
 * @see Int3
 * @see Int4
 */
public record Int2(Integer x, Integer y) implements Vec2<Integer, Int2> {

    @Override
    public Int2 _createNew(Integer x, Integer y) {
        return new Int2(x, y);
    }

    /**
     * Calculate and return the magnitude of this vector.
     *
     * @return the calculated magnitude.
     */
    public double magnitude() {
        double result = 0.0;
        for (Integer d : asArray()) {
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
    public int taxicab_magnitude() {
        int result = 0;
        for (Integer d : asArray()) {
            result += Math.absExact(d);
        }
        return result;
    }
}
