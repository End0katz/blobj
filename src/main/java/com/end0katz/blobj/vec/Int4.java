package com.end0katz.blobj.vec;

/**
 * Vector containing 4 {@link Integer}s
 *
 * @param x
 *     the x component of this vector
 * @param y
 *     the y component of this vector
 * @param z
 *     the z component of this vector
 * @param w
 *     the w component of this vector
 * @see Vec4
 * @see Int2
 * @see Int3
 */
public record Int4(Integer x, Integer y, Integer z, Integer w) implements Vec4<Integer, Int2, Int3, Int4> {

    @Override
    public Int2 _createNew(Integer x, Integer y) {
        return new Int2(x, y);
    }

    @Override
    public Int3 _createNew(Integer x, Integer y, Integer z) {
        return new Int3(x, y, z);
    }

    @Override
    public Int4 _createNew(Integer x, Integer y, Integer z, Integer w) {
        return new Int4(x, y, z, w);
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
