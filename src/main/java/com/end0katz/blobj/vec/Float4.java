package com.end0katz.blobj.vec;

/**
 * Vector containing 4 {@link Double}s
 *
 * @param x the x component of this vector
 * @param y the y component of this vector
 * @param z the z component of this vector
 * @param w the w component of this vector
 * @see Vec4
 * @see Float2
 * @see Float3
 */
public record Float4(Double x, Double y, Double z, Double w) implements Vec4<Double, Float2, Float3, Float4> {

    @Override
    public Float2 _createNew(Double x, Double y) {
        return new Float2(x, y);
    }

    @Override
    public Float3 _createNew(Double x, Double y, Double z) {
        return new Float3(x, y, z);
    }

    @Override
    public Float4 _createNew(Double x, Double y, Double z, Double w) {
        return new Float4(x, y, z, w);
    }
}
