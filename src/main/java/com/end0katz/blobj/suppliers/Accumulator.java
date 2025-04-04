package com.end0katz.blobj.suppliers;

import java.util.function.*;

public class Accumulator implements IntSupplier, Supplier<Integer> {

    public Accumulator() {
        this(1);
    }

    public Accumulator(int acc) {
        this(0, acc);
    }

    public Accumulator(int start, int acc) {
        this.i = start;
        this.acc = acc;
    }

    private int i;
    private int acc;

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
