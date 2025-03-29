package com.end0katz.blobj.vec;

public record Obj4<T>(T x, T y, T z, T w) implements Vec4<T, Obj2<T>, Obj3<T>, Obj4<T>> {

    @Override
    public Obj2<T> _createNew(T x, T y) {
        return new Obj2<>(x, y);
    }

    @Override
    public Obj3<T> _createNew(T x, T y, T z) {
        return new Obj3<>(x, y, z);
    }

    @Override
    public Obj4<T> _createNew(T x, T y, T z, T w) {
        return new Obj4<>(x, y, z, w);
    }
}
