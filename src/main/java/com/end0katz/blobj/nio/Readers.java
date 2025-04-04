package com.end0katz.blobj.nio;

import java.io.*;

import com.end0katz.blobj.annotations.*;

/**
 * A collection of various readers for various purposes.
 *
 * <ul>
 * <li>{@link LoopedReader} repeats a reader indefinitely.
 * </ul>
 */
@Group
public enum Readers {
    ;

    /**
     * Loops a character or string repeatedly.
     *
     * @param <T> the type of {@link Reader} this wraps.
     */
    public static class LoopedReader<T extends Reader> extends Reader {

        /**
         * The wrapped reader.
         */
        T rd;
        /**
         * The buffer of all known characters.
         */
        String data = "";
        /**
         * The index into the buffer.
         */
        int index = 0;

        /**
         * Construct a {@link LoopedReader} looping over a string.
         *
         * @param s the string to loop.
         * @return a {@link LoopedReader} over a {@link StringReader} reading
         * {@code s}.
         */
        public static LoopedReader<StringReader> from(String s) {
            return new LoopedReader<>(new StringReader(s));
        }

        /**
         * Construct a reader wrapping another reader.
         *
         * @param reader the reader to wrap.
         */
        public LoopedReader(T reader) {
            this.rd = reader;
        }

        @Override
        public int read(char[] cbuf, int off, int len) throws IOException {
            for (int i = off; i < len; i++) {
                int chr = -1;
                if (rd.ready()) {
                    chr = rd.read();
                }
                if (rd.ready() && !(chr == -1)) {
                    cbuf[i] = (char) chr;
                    data += cbuf[i];
                } else {
                    cbuf[i] = data.charAt(index++);
                    index %= data.length();
                }
            }
            return len;
        }

        @Override
        public void close() throws IOException {
            rd.close();
        }

    }
}
