package com.end0katz.blobj.vec;

/**
 * Utility class for vectors of any object. NOT INTENDED FOR USE AS GENERIC
 * OBJECT VECTOR, USE {@code Obj3}
 *
 * @param <T> - the object this a vector of
 * @param <V2> - the object to return for vec2-returning methods
 * @param <V3> - the object to return for vec3-returning methods
 * @param <V4> - the object to return for this-returning methods
 * @see Vec2
 * @see Vec3
 *
 * @see Float4
 * @see Int4
 * @see Obj4
 */
public interface Vec4<T, V2 extends Vec2<T, V2>, V3 extends Vec3<T, V2, V3>, V4 extends Vec4<T, V2, V3, V4>>
        extends Vec3<T, V2, V3> {

    /**
     * Returns the w component of this vector.
     *
     * @return the w component of this vector.
     */
    public T w();

    /**
     * this is an internal method. override in Vec4 subclasses, but DO NOT CALL
     * YOURSELF.
     *
     * @param x the x component.
     * @param y the y component.
     * @param z the z component.
     * @param w the w component.
     * @return {@code new <thisType>(x, y, z, w);}
     */
    public V4 _createNew(T x, T y, T z, T w);

    /**
     * Swizzle method.
     *
     * @return the xw swizzle of this vector.
     */
    public default V2 xw() {
        return _createNew(x(), z());
    }

    /**
     * Swizzle method.
     *
     * @return the yw swizzle of this vector.
     */
    public default V2 yw() {
        return _createNew(y(), z());
    }

    /**
     * Swizzle method.
     *
     * @return the zw swizzle of this vector.
     */
    public default V2 zw() {
        return _createNew(z(), w());
    }

    /**
     * Swizzle method.
     *
     * @return the wx swizzle of this vector.
     */
    public default V2 wx() {
        return xw().yx();
    }

    /**
     * Swizzle method.
     *
     * @return the wy swizzle of this vector.
     */
    public default V2 wy() {
        return yw().yx();
    }

    /**
     * Swizzle method.
     *
     * @return the wz swizzle of this vector.
     */
    public default V2 wz() {
        return zw().yx();
    }

    /**
     * Swizzle method.
     *
     * @return the xyw swizzle of this vector.
     */
    public default V3 xyw() {
        return _createNew(x(), y(), w());
    }

    /**
     * Swizzle method.
     *
     * @return the xzw swizzle of this vector.
     */
    public default V3 xzw() {
        return _createNew(x(), z(), w());
    }

    /**
     * Swizzle method.
     *
     * @return the yzw swizzle of this vector.
     */
    public default V3 yzw() {
        return _createNew(y(), z(), w());
    }

    /**
     * Swizzle method.
     *
     * @return the yxw swizzle of this vector.
     */
    public default V3 yxw() {
        return _createNew(y(), x(), w());
    }

    /**
     * Swizzle method.
     *
     * @return the zxw swizzle of this vector.
     */
    public default V3 zxw() {
        return _createNew(z(), x(), w());
    }

    /**
     * Swizzle method.
     *
     * @return the zyw swizzle of this vector.
     */
    public default V3 zyw() {
        return _createNew(z(), y(), w());
    }

    /**
     * Swizzle method.
     *
     * @return the xwy swizzle of this vector.
     */
    public default V3 xwy() {
        return _createNew(x(), w(), y());
    }

    /**
     * Swizzle method.
     *
     * @return the xwz swizzle of this vector.
     */
    public default V3 xwz() {
        return _createNew(x(), w(), z());
    }

    /**
     * Swizzle method.
     *
     * @return the ywz swizzle of this vector.
     */
    public default V3 ywz() {
        return _createNew(y(), w(), z());
    }

    /**
     * Swizzle method.
     *
     * @return the ywx swizzle of this vector.
     */
    public default V3 ywx() {
        return _createNew(y(), w(), x());
    }

    /**
     * Swizzle method.
     *
     * @return the zwx swizzle of this vector.
     */
    public default V3 zwx() {
        return _createNew(z(), w(), x());
    }

    /**
     * Swizzle method.
     *
     * @return the zwy swizzle of this vector.
     */
    public default V3 zwy() {
        return _createNew(z(), w(), y());
    }

    /**
     * Swizzle method.
     *
     * @return the wxy swizzle of this vector.
     */
    public default V3 wxy() {
        return _createNew(w(), x(), y());
    }

    /**
     * Swizzle method.
     *
     * @return the wxz swizzle of this vector.
     */
    public default V3 wxz() {
        return _createNew(w(), x(), z());
    }

    /**
     * Swizzle method.
     *
     * @return the wyz swizzle of this vector.
     */
    public default V3 wyz() {
        return _createNew(w(), y(), z());
    }

    /**
     * Swizzle method.
     *
     * @return the wyx swizzle of this vector.
     */
    public default V3 wyx() {
        return _createNew(w(), y(), x());
    }

    /**
     * Swizzle method.
     *
     * @return the wzx swizzle of this vector.
     */
    public default V3 wzx() {
        return _createNew(w(), z(), x());
    }

    /**
     * Swizzle method.
     *
     * @return the wzy swizzle of this vector.
     */
    public default V3 wzy() {
        return _createNew(w(), z(), y());
    }

    /**
     * Swizzle method.
     *
     * @return the xyzw swizzle of this vector.
     */
    public default V4 xyzw() {
        return _createNew(x(), y(), z(), w());
    }

    /**
     * Swizzle method.
     *
     * @return the xywz swizzle of this vector.
     */
    public default V4 xywz() {
        return _createNew(x(), y(), w(), z());
    }

    /**
     * Swizzle method.
     *
     * @return the xzyw swizzle of this vector.
     */
    public default V4 xzyw() {
        return _createNew(x(), z(), y(), w());
    }

    /**
     * Swizzle method.
     *
     * @return the xzwy swizzle of this vector.
     */
    public default V4 xzwy() {
        return _createNew(x(), z(), w(), y());
    }

    /**
     * Swizzle method.
     *
     * @return the xwyz swizzle of this vector.
     */
    public default V4 xwyz() {
        return _createNew(x(), w(), y(), z());
    }

    /**
     * Swizzle method.
     *
     * @return the xwzy swizzle of this vector.
     */
    public default V4 xwzy() {
        return _createNew(x(), w(), z(), y());
    }

    /**
     * Swizzle method.
     *
     * @return the yxzw swizzle of this vector.
     */
    public default V4 yxzw() {
        return _createNew(y(), x(), z(), w());
    }

    /**
     * Swizzle method.
     *
     * @return the yxwz swizzle of this vector.
     */
    public default V4 yxwz() {
        return _createNew(y(), x(), w(), z());
    }

    /**
     * Swizzle method.
     *
     * @return the yzxw swizzle of this vector.
     */
    public default V4 yzxw() {
        return _createNew(y(), z(), x(), w());
    }

    /**
     * Swizzle method.
     *
     * @return the yzwx swizzle of this vector.
     */
    public default V4 yzwx() {
        return _createNew(y(), z(), w(), x());
    }

    /**
     * Swizzle method.
     *
     * @return the ywxz swizzle of this vector.
     */
    public default V4 ywxz() {
        return _createNew(y(), w(), x(), z());
    }

    /**
     * Swizzle method.
     *
     * @return the ywzx swizzle of this vector.
     */
    public default V4 ywzx() {
        return _createNew(y(), w(), z(), x());
    }

    /**
     * Swizzle method.
     *
     * @return the zxyw swizzle of this vector.
     */
    public default V4 zxyw() {
        return _createNew(z(), x(), y(), w());
    }

    /**
     * Swizzle method.
     *
     * @return the zxwy swizzle of this vector.
     */
    public default V4 zxwy() {
        return _createNew(z(), x(), w(), y());
    }

    /**
     * Swizzle method.
     *
     * @return the zyxw swizzle of this vector.
     */
    public default V4 zyxw() {
        return _createNew(z(), y(), x(), w());
    }

    /**
     * Swizzle method.
     *
     * @return the zywx swizzle of this vector.
     */
    public default V4 zywx() {
        return _createNew(z(), y(), w(), x());
    }

    /**
     * Swizzle method.
     *
     * @return the zwxy swizzle of this vector.
     */
    public default V4 zwxy() {
        return _createNew(z(), w(), x(), y());
    }

    /**
     * Swizzle method.
     *
     * @return the zwyx swizzle of this vector.
     */
    public default V4 zwyx() {
        return _createNew(z(), w(), y(), x());
    }

    /**
     * Swizzle method.
     *
     * @return the wxyz swizzle of this vector.
     */
    public default V4 wxyz() {
        return _createNew(w(), x(), y(), z());
    }

    /**
     * Swizzle method.
     *
     * @return the wxzy swizzle of this vector.
     */
    public default V4 wxzy() {
        return _createNew(w(), x(), z(), y());
    }

    /**
     * Swizzle method.
     *
     * @return the wyxz swizzle of this vector.
     */
    public default V4 wyxz() {
        return _createNew(w(), y(), x(), z());
    }

    /**
     * Swizzle method.
     *
     * @return the wyzx swizzle of this vector.
     */
    public default V4 wyzx() {
        return _createNew(w(), y(), z(), x());
    }

    /**
     * Swizzle method.
     *
     * @return the wzxy swizzle of this vector.
     */
    public default V4 wzxy() {
        return _createNew(w(), z(), x(), y());
    }

    /**
     * Swizzle method.
     *
     * @return the wzyx swizzle of this vector.
     */
    public default V4 wzyx() {
        return _createNew(w(), z(), y(), x());
    }

    @SuppressWarnings("unchecked")
    @Override
    public default T[] asArray() {
        return (T[]) new Object[]{x(), y(), z(), w()};
    }
}
