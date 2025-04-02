package com.end0katz.blobj;

/**
 * An interface for all classes designed to build another class
 *
 * @param <T> the class this builder builds.
 */
public interface Builder<T> {

    T build();
}
