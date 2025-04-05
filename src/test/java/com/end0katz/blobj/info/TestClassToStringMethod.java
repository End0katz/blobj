package com.end0katz.blobj.info;

import java.io.*;
import java.lang.reflect.*;
import java.util.*;
import java.util.function.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

import com.end0katz.blobj.*;

public class TestClassToStringMethod {

    @Test
    void testNull() {
        assertEquals(
                "Cannot get class description of null; null is not a class",
                assertThrowsExactly(
                        NullPointerException.class,
                        () -> Info.classToString(null)
                ).getMessage(),
                "Incorrect error msg"
        );
    }

    @Test
    void testPrimitives() {
        assertEquals("void", Info.classToString(Void.TYPE));
        assertEquals("byte", Info.classToString(Byte.TYPE));
        assertEquals("short", Info.classToString(Short.TYPE));
        assertEquals("int", Info.classToString(Integer.TYPE));
        assertEquals("long", Info.classToString(Long.TYPE));
        assertEquals("float", Info.classToString(Float.TYPE));
        assertEquals("double", Info.classToString(Double.TYPE));
        assertEquals("bool", Info.classToString(Boolean.TYPE));
        assertEquals("char", Info.classToString(Character.TYPE));
    }

    @Test
    void testObject() {
        assertEquals("java:Object", Info.classToString(Object.class));
    }

    @Test
    void testJavaLang() {
        assertEquals("javaref:Method", Info.classToString(Method.class));
    }

    @Test
    void testJavaUtil() {
        assertEquals("Jutil:List", Info.classToString(List.class));
    }

    @Test
    void testJavaIO() {
        assertEquals("Jio:Writer", Info.classToString(Writer.class));
    }

    @Test
    void testNestedNonJLang() {
        assertEquals("JUfunction:Function", Info.classToString(Function.class));
    }

    @Test
    void testAnonymousClass() {
        assertEquals(
                "?0:TestClassToStringMethod$1#;",
                Info.classToString(new Object() {
                }.getClass())
        );
    }
}
