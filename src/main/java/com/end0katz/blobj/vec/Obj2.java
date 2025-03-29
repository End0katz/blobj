package com.end0katz.blobj.vec;

/**
 * Vector containing 2 custom {@link Object}s
 *
 * @param <T> the type of object in this vector.
 *
 * @see Vec2
 * @see Obj3
 * @see Obj4
 */
public record Obj2<T>(T x, T y) implements Vec2<T, Obj2<T>> {

    @Override
    public Obj2<T> _createNew(T x, T y) {
        return new Obj2<>(x, y);
    }
}
