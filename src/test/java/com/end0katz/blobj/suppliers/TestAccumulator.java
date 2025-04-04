package com.end0katz.blobj.suppliers;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

public class TestAccumulator {

    @Test
    void testStandardAccumulator() {
        Accumulator acc = new Accumulator();
        assertEquals(0, acc.get(), "#1");
        assertEquals(1, acc.get(), "#2");
        assertEquals(2, acc.get(), "#3");
        assertEquals(3, acc.get(), "#4");
        assertEquals(4, acc.get(), "#5");
    }

    @Test
    void testCustomStartAccumulator() {
        Accumulator acc = new Accumulator(100, 1);
        assertEquals(100, acc.get(), "#1");
        assertEquals(101, acc.get(), "#2");
        assertEquals(102, acc.get(), "#3");
        assertEquals(103, acc.get(), "#4");
        assertEquals(104, acc.get(), "#5");
    }

    @Test
    void testCustomAccAccumulator() {
        Accumulator acc = new Accumulator(5);
        assertEquals(0, acc.get(), "#1");
        assertEquals(5, acc.get(), "#2");
        assertEquals(10, acc.get(), "#3");
        assertEquals(15, acc.get(), "#4");
        assertEquals(20, acc.get(), "#5");
    }

    @Test
    void testCustomAllAccumulator() {
        Accumulator acc = new Accumulator(100, 5);
        assertEquals(100, acc.get(), "#1");
        assertEquals(105, acc.get(), "#2");
        assertEquals(110, acc.get(), "#3");
        assertEquals(115, acc.get(), "#4");
        assertEquals(120, acc.get(), "#5");
    }
}
