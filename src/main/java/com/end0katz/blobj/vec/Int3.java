package com.end0katz.blobj.vec;

/**
 * Vector containing 3 {@link Integer}s
 *
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
}
