package com.end0katz.blobj.vec;

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
