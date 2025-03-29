package com.end0katz.blobj.vec;

/**
 * Utility class for vectors of any object. NOT INTENDED FOR USE AS GENERIC
 * OBJECT VECTOR, USE {@code Obj3}
 *
 * @param <T> - the object this a vector of
 * @param <V2> - the object to return for vec2-returning methods
 * @param <V3> - the object to return for this-returning methods
 * @see Vec2
 * @see Vec4
 *
 * @see Float3
 * @see Int3
 * @see Obj3
 */
public interface Vec3<T, V2 extends Vec2<T, V2>, V3 extends Vec3<T, V2, V3>> extends Vec2<T, V2> {

    /**
     * Returns the z component of this vector.
     *
     * @return the z component of this vector.
     */
    public T z();

    /**
     * this is an internal method. override in Vec3 subclasses, but DO NOT CALL
     * YOURSELF.
     *
     * @param x the x component.
     * @param y the y component.
     * @param z the z component.
     * @return {@code new <thisType>(x, y, z);}
     */
    public V3 _createNew(T x, T y, T z);

    @SuppressWarnings("unchecked")
    @Override
    public default T[] asArray() {
        return (T[]) new Object[]{x(), y(), z()};
    }

    /**
     * Swizzle method.
     *
     * @return the zx swizzle of this vector.
     */
    public default V2 zx() {
        return _createNew(x(), z());
    }

    /**
     * Swizzle method.
     *
     * @return the xz swizzle of this vector.
     */
    public default V2 xz() {
        return zx().yx();
    }

    /**
     * Swizzle method.
     *
     * @return the yz swizzle of this vector.
     */
    public default V2 yz() {
        return _createNew(y(), z());
    }

    /**
     * Swizzle method.
     *
     * @return the zy swizzle of this vector.
     */
    public default V2 zy() {
        return yz().yx();
    }

    /**
     * Swizzle method.
     *
     * @return the xyz swizzle of this vector.
     */
    public default V3 xyz() {
        return zyx().zyx();
    }

    /**
     * Swizzle method.
     *
     * @return the xzy swizzle of this vector.
     */
    public default V3 xzy() {
        return _createNew(x(), z(), y());
    }

    /**
     * Swizzle method.
     *
     * @return the zyx swizzle of this vector.
     */
    public default V3 zyx() {
        return _createNew(z(), y(), x());
    }

    /**
     * Swizzle method.
     *
     * @return the yzx swizzle of this vector.
     */
    public default V3 yzx() {
        return xzy().zyx();
    }

    /**
     * Swizzle method.
     *
     * @return the zxy swizzle of this vector.
     */
    public default V3 zxy() {
        return zyx().xzy();
    }

    /**
     * Swizzle method.
     *
     * @return the yxz swizzle of this vector.
     */
    public default V3 yxz() {
        return zxy().zyx();
    }
}
