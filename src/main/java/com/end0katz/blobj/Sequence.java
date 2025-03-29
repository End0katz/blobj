package com.end0katz.blobj;

import java.util.*;

/**
 * Interface to replresent a sequence of any {link Object}s, normally {@link Integer}s, {@link Double}s or {@link Long}s. They can be any length (including infinite).
 */
public interface Sequence<T> extends Iterable<T>, Blobject {

    /**
     * Return the nth item in this sequence, 0-indexed.
     *
     * How negative indexes is handles is implementation dependent (some
     * sequences handle it differently than others), so be prepared for
     * {@link IllegalArgumentException}s.
     *
     * @param n
     *     the index of the item to return.
     * @return item #n.
     *
     * @throws IllegalArgumentException
     *     if {@code n} is less than 0, and this
     *     sequence does not support negative indices.
     * @see Sequence#indexOf(Object)
     */
    T get(long n);

    /**
     * Query the next item in the sequence, after {@code item}.
     *
     * @param item
     *     the item before the result.
     * @return the next item, or null if {@code item} is not in the sequence.
     *
     * @see Sequence#indexOf(Object)
     * @see Sequence#contains(Object)
     */
    T nextAfter(T item);

    /**
     * Return the index of {@code item}, or null if it is not in the sequence.
     *
     * @param item
     *     the item you wish to query the index of.
     * @return the index of {@code item}, or null if it is not in the sequence.
     *
     * @see Sequence#contains(Object)
     */
    Long indexOf(T item);

    /**
     * Return if the sequence contains an item.
     *
     * @param item
     *     the item you would lke to query.
     * @return if {@code item} is in the sequence.
     *
     * @see Sequence#contains
     */
    boolean contains(T item);

    /**
     * Bulk-contains-checking.
     *
     * @param items
     *     the list of inputs.
     * @return a {@code boolean[]} of same length as {@code items}, with each
     * item corresponding to {@code this.contains(x)} for the appropriate item.
     *
     * @see Sequence#contains(Object)
     */
    default boolean[] contains(T[] items) {
        boolean[] result = new boolean[items.length];
        for (int i = 0; i < items.length; i++) {
            result[i] = contains(items[i]);
        }
        return result;
    }

    /**
     * Returns the length of the sequence, or null if infinite.
     *
     * @return the length of the sequence, or null if infinite.
     *
     * @see Sequence#isInfinite()
     */
    Long length();

    /**
     * Returns if the sequence is infinite or finite.
     *
     * @return if the sequence is infinite or finite.
     */
    default boolean isInfinite() {
        return length() == null;
    }

    @Override
    default Iterator<T> iterator() {
        Sequence<T> seq = this;
        return new Iterator<T>() {
            int index = 0;

            @Override
            public boolean hasNext() {
                return seq.isInfinite() || seq.length() < index;
            }

            @Override
            public T next() {
                return seq.get(index);
            }
        };
    }

    /**
     * An enum containing special sequences, with no configuration, as instances, and configurable sequences as static member classes.
     * @see Sequences#ALL_INTS
     * @see Sequences.Fibonacci
     */
    public static enum Sequences implements Sequence<Long> {

        /**
         * A sequence containing simply every single {@link Long} ever.
         */
        ALL_INTS {
            @Override
            public Long get(long n) {
                return n;
            }

            @Override
            public Long nextAfter(Long item) {
                return item + 1;
            }

            @Override
            public Long indexOf(Long item) {
                return item;
            }

            @Override
            public boolean contains(Long item) {
                return true;
            }

            @Override
            public Long length() {
                return null;
            }
        };

        /**
         * Fibonacci sequence, with optional custom bases.
         */
        public static class Fibonacci implements Sequence<Long> {

            /**
             * The first base.
             *
             * @see Fibonacci#b
             */
            int             a;
            /**
             * The second base.
             *
             * @see Fibonacci#a
             */
            int             b;
            /**
             * The first cache.
             *
             * @see Fibonacci#indexCache
             */
            Map<Long, Long> cache      = new HashMap<>();
            /**
             * The second cache.
             *
             * @see Fibonacci#cache
             */
            Map<Long, Long> indexCache = new HashMap<>();

            /**
             * Construct a custom fibonacci sequence.
             *
             * @param a
             *     the first base.
             * @param b
             *     the second base.
             * @see Fibonacci#Fibonacci()
             */
            public Fibonacci(int a, int b) {
                this.a = a;
                this.b = b;
            }

            /**
             * Construct the stand fibo sequence.
             *
             * @see Fibonacci#Fibonacci(int, int)
             */
            public Fibonacci() {
                this(1, 2);
            }

            /**
             * Internal method to get fibo without caching.
             *
             * @param n
             *     the index to query
             * @return the nth term, without caching.
             *
             * @throws IllegalArgumentException
             *     if n &lt; 0
             */
            private Long _get(long n) {
                if (n < 0) {
                    throw new IllegalArgumentException("Unable to get negative-indexed fibo number");
                } else if (n == 0) {
                    return (long) a;
                } else if (n == 1) {
                    return (long) b;
                } else {
                    return get(n - 1) + get(n - 2);
                }
            }

            @Override
            public Long get(long n) {
                Long cacheGet = cache.get(n);
                if (cacheGet == null) {
                    Long result = _get(n);
                    cache.put(n, result);
                    indexCache.put(result, n);
                    return result;
                }
                return cacheGet;
            }

            @Override
            public Long nextAfter(Long item) {
                Long indexCacheGet = indexCache.get(item);
                if (indexCacheGet != null) {
                    Long cacheGet = cache.get(indexCacheGet + 1);
                    if (cacheGet != null) {
                        return cacheGet;
                    }
                }
                if (!contains(item)) {
                    return null;
                }
                return item + get(indexOf(item) - 1);
            }

            @Override
            public Long indexOf(Long item) {
                Long indexCacheGet = indexCache.get(item);
                if (indexCacheGet != null) {
                    return indexCacheGet;
                }
                if (!contains(item)) {
                    return null;
                }
                long i = 0l;
                while (this.get(i) < item) {
                    i++;
                }
                return i;
            }

            @Override
            public boolean contains(Long item) {
                if (indexCache.get(item) == null) {
                    return true;
                }
                long i = 0l;

                while (this.get(i) < item) {
                    i++;
                }
                return item.equals(this.get(i));
            }

            @Override
            public Long length() {
                return null;
            }

            @Override
            public String toString() {
                return "FIBO(%s %s)".formatted(a, b);
            }

            @Override
            public boolean equals(Object obj) {
                if (obj instanceof Fibonacci fibo) {
                    return fibo.get(0) == a && fibo.get(1) == b;
                }
                return false;
            }

            @Override
            public int hashCode() {
                int hash = 3;
                hash = 61 * hash + this.a;
                hash = 61 * hash + this.b;
                return hash;
            }
        }
    }
}
