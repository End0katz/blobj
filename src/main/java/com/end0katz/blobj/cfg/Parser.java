package com.end0katz.blobj.cfg;

import java.io.*;
import java.nio.file.*;
import java.util.*;

/**
 * Interface for a language parser
 *
 * @param <T> the output of parsing this language
 */
public interface Parser<T> {

    /**
     * Parse the data from an input stream.
     *
     * @param is the input stream to parse.
     * @return the parsed object.
     * @throws IOException if an I/O error occurs.
     */
    default T parse(InputStream is) throws IOException {
        return parse(new String(is.readAllBytes()));
    }

    /**
     * Parse the file at the specified path.
     *
     * @param path the path of the file.
     * @return the parsed object.
     * @throws IOException if there is an I/O error.
     */
    default T parse(Path path) throws IOException {
        return parse(path.toFile());
    }

    /**
     * Parse a file.
     *
     * @param file the file to parse.
     * @return the parsed object.
     * @throws IOException if an IO error occurs.
     */
    default T parse(File file) throws IOException {
        StringBuilder result = new StringBuilder();
        try (FileReader reader = new FileReader(file)) {
            reader.transferTo(new Writer() {

                @Override
                public void write(char[] cbuf, int off, int len) throws IOException {
                    result.append(Arrays.copyOfRange(cbuf, off, off + len));
                }

                @Override
                public void flush() throws IOException {
                }

                @Override
                public void close() throws IOException {
                }

            });
        }
        return parse(result.toString());
    }

    /**
     * Parse the contents of a string.
     *
     * @param content the string to parse.
     * @return the parsed object.
     */
    T parse(String content);
}
