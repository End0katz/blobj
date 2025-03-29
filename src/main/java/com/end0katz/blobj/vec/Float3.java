package com.end0katz.blobj.vec;

/**
 * Vector containing 3 {@link Double}s
 *
 * @param x the x component of this vector
 * @param y the y component of this vector
 * @param z the z component of this vector
 * @see Vec3
 * @see Float2
 * @see Float4
 */
public record Float3(Double x, Double y, Double z) implements Vec3<Double, Float2, Float3> {

    @Override
    public Float2 _createNew(Double x, Double y) {
        return new Float2(x, y);
    }

    @Override
    public Float3 _createNew(Double x, Double y, Double z) {
        return new Float3(x, y, z);
    }
}
