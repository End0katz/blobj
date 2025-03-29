package com.end0katz.blobj;

/**
 * Class to simulate a mutable variable, like length-1 arrays. Can be final.
 * This is useful for using records and not caring about how records are meant
 * to be non-mutable.
 *
 * @param <T> the type of object you are mutating.
 */
public class Mutable<T> implements Blobject {

    private T value;

    public Mutable(T value) {
        this.value = value;
    }

    public T get() {
        return value;
    }

    public T set(T val) {
        T result = value;
        value = val;
        return result;
    }
}
