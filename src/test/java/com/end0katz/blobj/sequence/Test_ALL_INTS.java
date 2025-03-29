package com.end0katz.blobj.sequence;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

import com.end0katz.blobj.Sequence.*;

public class Test_ALL_INTS {

    @Test
    void test() {
        for (long i = 0l; i < Integer.MAX_VALUE * 2l; i++) {
            assertTrue(Sequences.ALL_INTS.contains(i));
            assertEquals(i, Sequences.ALL_INTS.indexOf(i));
        }
    }
}
