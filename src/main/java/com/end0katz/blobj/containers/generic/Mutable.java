package com.end0katz.blobj.containers.generic;

/**
 * Class to simulate a mutable variable, like length-1 arrays. Can be final.
 * This is useful for using records and not caring about how records are meant
 * to be non-mutable.
 *
 * @param <T> the type of object you are mutating.
 */
public class Mutable<T> {

    /**
     * The value. Note that it is not final.
     */
    private T value;

    /**
     * Construct a Mutable with a starting value.
     *
     * @param value the initial value
     * @see Mutable#Mutable()
     */
    public Mutable(T value) {
        this.value = value;
    }

    /**
     * Construct a mutable with null as the starting value.
     *
     * @see Mutable#Mutable(Object)
     */
    public Mutable() {
        this(null);
    }

    /**
     * Query the value of this mutable.
     *
     * @return the value of this mutable.
     */
    public T get() {
        return value;
    }

    /**
     * Set the value of this mutable.
     *
     * @param val the new value.
     * @return the old value.
     */
    public T set(T val) {
        T result = value;
        value = val;
        return result;
    }
}
