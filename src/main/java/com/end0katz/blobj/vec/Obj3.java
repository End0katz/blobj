package com.end0katz.blobj.vec;

/**
 * Vector containing 2 custom {@link Object}s
 *
 * @param x the x component of this vector
 * @param y the y component of this vector
 * @param z the z component of this vector
 * @param <T> the type of object in this vector.
 *
 * @see Vec3
 * @see Obj2
 * @see Obj4
 */
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
