package com.end0katz.blobj.info;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

import org.apache.commons.lang3.*;
import org.junit.jupiter.api.*;

import com.end0katz.blobj.*;

public class TestObjectToStringMethod {

    @Test
    void testNull() {
        assertEquals("null", Info.convertObjectToString(null));
    }

    void testCharSequenceForMessage(String msg) {
        assertEquals(msg, Info.convertObjectToString(msg));
        assertEquals(msg, Info.convertObjectToString(new StringBuilder(msg)));
        assertEquals(msg, Info.convertObjectToString(new StringBuffer(msg)));
    }

    @Test
    void testCharSequence() {
        testCharSequenceForMessage("foo");
        testCharSequenceForMessage("bar");
        testCharSequenceForMessage("foo:bar");
        testCharSequenceForMessage("quxquz");
        testCharSequenceForMessage("yeet");
        testCharSequenceForMessage("\0");
        testCharSequenceForMessage("");
    }

    void testCharArrayForMessage(String msg) {
        assertEquals(msg, Info.convertObjectToString(msg.toCharArray()));
        assertEquals(msg, Info.convertObjectToString(ArrayUtils.toObject(msg.toCharArray())));
    }

    @Test
    void testCharArray() {
        testCharArrayForMessage("foo");
        testCharArrayForMessage("bar");
        testCharArrayForMessage("foo:bar");
        testCharArrayForMessage("quxquz");
        testCharArrayForMessage("yeet");
        testCharArrayForMessage("\0");
        testCharArrayForMessage("");
    }

    @Test
    void testIterable() {
        assertEquals(
                "[string, c, h, a, r, [nested]]",
                Info.convertObjectToString(
                        Arrays.asList("string", 'c', 'h', 'a', 'r', Arrays.asList("nested"))
                )
        );
    }
}
