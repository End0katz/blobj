package com.end0katz.blobj.vec;

/**
 * Vector containing 3 {@link Integer}s
 *
 * @param x
 *     the x component of this vector
 * @param y
 *     the y component of this vector
 * @param z
 *     the z component of this vector
 * @see Vec3
 * @see Int2
 * @see Int4
 */
public record Int3(Integer x, Integer y, Integer z) implements Vec3<Integer, Int2, Int3> {

    @Override
    public Int2 _createNew(Integer x, Integer y) {
        return new Int2(x, y);
    }

    @Override
    public Int3 _createNew(Integer x, Integer y, Integer z) {
        return new Int3(x, y, z);
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
