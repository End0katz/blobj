package com.end0katz.blobj;

/**
 * An interface for all classes designed to build another class
 *
 * @param <T> the class this builder builds.
 */
public interface Builder<T> {

    /**
     * Build the object.
     *
     * @return the build Object
     * @implNote unless not possible or not applicable, the builder should be
     * reusable. Aside from if the class
     */
    T build();
}
