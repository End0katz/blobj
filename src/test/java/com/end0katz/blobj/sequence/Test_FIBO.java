package com.end0katz.blobj.sequence;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

import com.end0katz.blobj.Sequence.Sequences.*;

public class Test_FIBO {

    Fibonacci stdFibo    = new Fibonacci();
    Fibonacci customFibo = new Fibonacci(1, 10);


    void testFirst5(Fibonacci fibo, int _0, int _1, int _2, int _3, int _4) {
        assertEquals(_0, (int) (long) fibo.get(0));
        assertEquals(_1, (int) (long) fibo.get(1));
        assertEquals(_2, (int) (long) fibo.get(2));
        assertEquals(_3, (int) (long) fibo.get(3));
        assertEquals(_4, (int) (long) fibo.get(4));
    }

    @Test
    void testFirst5OfStd() {
        testFirst5(stdFibo, 1, 2, 3, 5, 8);
    }

    @Test
    void testFirst5OfCustom() {
        testFirst5(customFibo, 1, 10, 11, 21, 32);
    }


    void testIndexOf(Fibonacci fibo, int _0, int _1, int _2, int _3, int _4) {
        assertEquals((Long) 0l, fibo.indexOf((long) _0));
        assertEquals((Long) 1l, fibo.indexOf((long) _1));
        assertEquals((Long) 2l, fibo.indexOf((long) _2));
        assertEquals((Long) 3l, fibo.indexOf((long) _3));
        assertEquals((Long) 4l, fibo.indexOf((long) _4));
    }

    @Test
    void testIndexOfStd() {
        testIndexOf(stdFibo, 1, 2, 3, 5, 8);
    }

    @Test
    void testIndexOfCustom() {
        testIndexOf(customFibo, 1, 10, 11, 21, 32);
    }

    @Test
    void testEquals() {
        assertEquals(stdFibo, stdFibo);
        assertEquals(customFibo, customFibo);
        assertNotEquals(customFibo, stdFibo);
        assertNotEquals(stdFibo, customFibo);
    }
}
