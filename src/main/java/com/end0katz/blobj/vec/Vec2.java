package com.end0katz.blobj.vec;

import com.end0katz.blobj.*;

/**
 * Utility class for vectors of any object. NOT INTENDED FOR USE AS GENERIC
 * OBJECT VECTOR, USE {@code Obj2}
 *
 * @param <T>
 *     - the object this a vector of
 * @param <V2>
 *     - the object to return for this-returning methods
 */
public interface Vec2<T, V2 extends Vec2<T, V2>> extends Blobject {

    /**
     * @return the x component of this vector.
     */
    public T x();

    /**
     * @return the y component of this vector.
     */
    public T y();

    /**
     * This is an internal method. override in Vec2 subclasses, but DO NOT CALL
     * YOURSELF.
     *
     * @return {@code new <thisType>(x, y);}
     */
    public V2 _createNew(T x, T y);

    /**
     * Swizzle method.
     *
     * @return the yx swizzle of this vector.
     */
    public default V2 yx() {
        return _createNew(y(), x());
    }

    /**
     * Swizzle method.
     *
     * @return the xy swizzle of this vector.
     */
    public default V2 xy() {
        return yx().yx();
    }

    /**
     * @return an array with all the components of the Vec2/
     */
    @SuppressWarnings("unchecked")
    public default T[] asArray() {
        return (T[]) new Object[] {x(), y()};
    }
}
