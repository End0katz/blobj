package com.end0katz.blobj.containers;

/**
 * Base class for all containers.
 *
 * @param <T> the type of object this is a container for.
 * @see Mutable
 */
public interface Container<T> {

    /**
     * Query the value of the container. The value may change.
     *
     * @return the current value of the container.
     */
    public T get();
}
