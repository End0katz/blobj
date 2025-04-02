package com.end0katz.blobj.containers;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

public class ThresholdTest {

    @Test
    void testConstructors() {
        Threshold _0 = new Threshold(-1, 1);
        Threshold _1 = new Threshold(-1, 1, true);
        Threshold _2 = new Threshold(-1, true, 1, true);

        assertEquals(_1, _0, "equality / constructor test failed");
        assertEquals(_2, _0, "equality / constructor test failed");
        assertEquals(_0, _1, "equality / constructor test failed");
        assertEquals(_2, _1, "equality / constructor test failed");
        assertEquals(_0, _2, "equality / constructor test failed");
        assertEquals(_1, _2, "equality / constructor test failed");
    }

    @Test
    void testFlipping() {
        Threshold x = new Threshold(-1, 1);

        assertEquals(false, x.get(), "Initial status incorrect");

        assertEquals(true, x.test(5), "Threshold exceeding test failed");
        assertEquals(true, x.get(), "Setting test failed");

        assertEquals(true, x.test(5), "Repeated exceeding test failed");
        assertEquals(true, x.get(), "Repeated setting test failed");

        assertEquals(false, x.test(0), "Neutral exceeding test failed");
        assertEquals(true, x.get(), "Neutral not setting test failed");

        assertEquals(true, x.test(-5), "Threshold lower exceeding test failed");
        assertEquals(false, x.get(), "Negative setting test failed");

        assertEquals(false, x.test(0), "Threshold neutral-on-negative exceeding test failed");
        assertEquals(false, x.get(), "Threshold neutral-on-negative setting test failed");
    }

    @Test
    void testStatusDoesNotEffectEqual() {
        Threshold unflipped = new Threshold(-1, 1);
        Threshold flipped = new Threshold(-1, 1);

        flipped.test(5);

        assertEquals(unflipped, flipped, "Status ignorance tets failed");
    }

    @Test
    void testInclusativity() {
        Threshold x = new Threshold(-1, false, 1, true);

        assertEquals(false, x.test(0.9), "0.9");
        assertEquals(true, x.test(1), "1.0");
        assertEquals(true, x.test(1.1), "1.1");

        assertEquals(false, x.test(-0.9), "-0.9");
        assertEquals(false, x.test(-1), "-1.0");
        assertEquals(true, x.test(-1.1), "-1.1");
    }
}
