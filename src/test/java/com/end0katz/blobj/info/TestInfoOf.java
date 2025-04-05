package com.end0katz.blobj.info;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

import com.end0katz.blobj.*;

public class TestInfoOf {

    @Test
    void testNull() {
        assertEquals("null", Info.of(null));
    }

    @Test
    void testNested() {
        assertEquals("CEBinfo:TestInfoOf.TestClass customToString", Info.of(new TestClass()));
    }

    @Test
    void testAnonymous() {
        assertEquals("?0:TestInfoOf$1#; Foo Bar", Info.of(new Object() {
            @Override
            public String toString() {
                return "Foo Bar";
            }
        }));
    }

    private static class TestClass {

        @Override
        public String toString() {
            return "customToString";
        }
    }
}
