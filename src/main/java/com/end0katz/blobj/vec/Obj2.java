package com.end0katz.blobj.vec;

public record Obj2<T>(T x, T y) implements Vec2<T, Obj2<T>> {

    @Override
    public Obj2<T> _createNew(T x, T y) {
        return new Obj2<>(x, y);
    }
}
