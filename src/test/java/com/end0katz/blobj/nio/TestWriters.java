package com.end0katz.blobj.nio;

import static org.junit.jupiter.api.Assertions.*;

import java.io.*;

import org.junit.jupiter.api.*;

public class TestWriters {

    @Test
    void testStringWriter() {
        try (Writers.StringWriter writer = new Writers.StringWriter("Initial Text;")) {
            writer.append('c');
            writer.append("haracters");
            writer.append(" ;", 1, 1);

            writer.write("cbuf;".toCharArray());
            writer.write("cbuf2;".toCharArray(), 1, 5);
            writer.write("str;");
            writer.write("String2;err", 0, 8);
            writer.write(0x20);

            assertEquals("Initial Text;characters;cbuf;buf2;str;String2; ", writer.data());
        }
    }

    @Test
    void testDelimited() throws IOException {
        try (
                Writers.Delimited<Writers.StringWriter> wr
                = new Writers.Delimited<>(new Writers.StringWriter(), "\n")) {
            wr.write("Line1");
            wr.append('2');
            assertEquals("Line1\n2\n", wr.writer().data());
        }
    }
}
