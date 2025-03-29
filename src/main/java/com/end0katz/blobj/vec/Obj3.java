package com.end0katz.blobj.vec;

public record Obj3<T>(T x, T y, T z) implements Vec3<T, Obj2<T>, Obj3<T>> {

    @Override
    public Obj2<T> _createNew(T x, T y) {
        return new Obj2<>(x, y);
    }

    @Override
    public Obj3<T> _createNew(T x, T y, T z) {
        return new Obj3<>(x, y, z);
    }
}
