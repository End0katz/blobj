package com.end0katz.blobj.vec;

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
