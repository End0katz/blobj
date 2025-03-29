package com.end0katz.blobj.vec;

/**
 * Vector containing 2 {@link Double}s
 *
 * @param x the x component of this vector
 * @param y the y component of this vector
 *
 * @see Vec2
 * @see Float3
 * @see Float4
 */
public record Float2(Double x, Double y) implements Vec2<Double, Float2> {

    @Override
    public Float2 _createNew(Double x, Double y) {
        return new Float2(x, y);
    }

    public double magnitude() {
        double result = 0.0;
        for (Double d : asArray()) {
            result += d * d;
        }
        return Math.sqrt(result);
    }
}
