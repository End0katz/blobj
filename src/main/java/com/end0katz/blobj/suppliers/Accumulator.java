package com.end0katz.blobj.suppliers;

import java.util.function.*;

/**
 * {@link IntSupplier} that increments a value by a certain amount each time.
 */
public class Accumulator implements IntSupplier, Supplier<Integer> {

    /**
     * Construct a basic accumulator: starts at 0, increasing by 1 each time.
     */
    public Accumulator() {
        this(1);
    }

    /**
     * Construct an accumulator with custom accumulation value.
     *
     * @param acc the amount to change by each time.
     */
    public Accumulator(int acc) {
        this(0, acc);
    }

    /**
     * An accumulator starting at, and incrementing by, a custom value.
     *
     * @param start the initial value, and first return value of
     * {@link Accumulator#get()} &amp; {@link Accumulator#getAsInt()}.
     * @param acc the amount to change by each time.
     */
    public Accumulator(int start, int acc) {
        this.i = start;
        this.acc = acc;
    }

    /**
     * The current value
     */
    private int i;
    /**
     * The amount to change by
     */
    private int acc;

    /**
     * Get the next return value of {@link Accumulator#get()} without
     * incrementing.
     *
     * @return {@link Accumulator#i}.
     */
    public int peek() {
        return i;
    }

    @Override
    public int getAsInt() {
        i += acc;
        return i - acc;
    }

    @Override
    public Integer get() {
        return getAsInt();
    }

}
