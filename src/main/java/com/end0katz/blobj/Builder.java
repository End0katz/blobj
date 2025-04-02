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
     * @return the built Object.
     * @implNote Unless not possible or not applicable, the builder should be
     * reusable. Aside from if the class keeping a record of all instances, this
     * builder should be the same as before the build if possible.
     */
    T build();
}
