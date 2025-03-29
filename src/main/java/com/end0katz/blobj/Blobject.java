package com.end0katz.blobj;

/**
 * Base class for all classes added by blobj.
 */
public interface Blobject {

    /**
     * Base class for all builder objects for blobjects.
     *
     * @param <T>
     *     the class this is a builder for.
     */
    public static interface Builder<T extends Blobject> {

        /**
         * Build, perform any init methods, and return, the blobject.
         *
         * @return a new instance of {@code T} with data from the builder.
         */
        public T build();
    }
}
