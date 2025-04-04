package com.end0katz.blobj.nio;

import static org.junit.jupiter.api.Assertions.*;

import java.io.*;

import org.junit.jupiter.api.*;

import com.end0katz.blobj.nio.Readers.*;

public class TestReaders {

    @Test
    void testLoopingReader() throws IOException {
        String msg = "Now is the time for all good men to come to the aid of their party. "; // Because why not
        int times = 1;

        LoopedReader<StringReader> lr = LoopedReader.from(msg);

        char[] cbuf = new char[msg.length() * times];
        lr.read(cbuf);

        assertEquals(msg.repeat(times), String.valueOf(cbuf));
    }
}
