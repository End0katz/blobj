package com.end0katz.blobj.nio;

import com.end0katz.blobj.annotations.*;

import java.io.*;

/**
 * A collection of various writers for various purposes
 *
 * <ul>
 * <li>{@link Voider} discards any data given to it</li>
 * <li>{@link StringWriter} writes to an internal readable String</li>
 * </ul>
 */
@Group
public enum Writers {
    ;

    /**
     * Writer subclass that simply discards any information given to it.
     * Closing, Flushing, And Writing all just simply do nothing. (As in, they
     * have empty function bodies)
     *
     * This class does not throw IOExceptions
     */
    public static class Voider extends Writer {

        /**
         * Construct a voider.
         */
        public Voider() {
        }

        @Override
        public void write(char[] cbuf, int off, int len) {
        }

        @Override
        public void flush() {
        }

        @Override
        public void close() {
        }

        @Override
        public Voider append(char c) {
            return this;
        }

        @Override
        public Voider append(CharSequence cs) {
            return this;
        }

        @Override
        public Voider append(CharSequence cs, int start, int end) {
            return this;
        }

        @Override
        public void write(char[] cbuf) {
        }

        @Override
        public void write(int c) {
        }

        @Override
        public void write(String s) {
        }

        @Override
        public void write(String s, int off, int len) {
        }
    }

    /**
     * Writer subclass that adds all writes to an internal string accesable
     * through {@code data()}
     *
     * This class does not throw IOExceptions
     */
    public static class StringWriter extends Writer {

        /**
         * The accumulated string.
         */
        protected StringBuilder str = new StringBuilder();

        /**
         * Construct a StringWriter with initial content.
         *
         * @param s the initial content.
         */
        public StringWriter(String s) {
            str = new StringBuilder(s);
        }

        /**
         * Construct an empty StringWriter
         */
        public StringWriter() {
            this("");
        }

        @Override
        public void write(char[] cbuf, int off, int len) {
            char[] cs = new char[len];
            System.arraycopy(cbuf, off, cs, 0, len);
            str.append(cs);
        }

        @Override
        public void flush() {
        }

        @Override
        public void close() {
        }

        @Override
        public StringWriter append(char c) {
            str.append(c);
            return this;
        }

        @Override
        public StringWriter append(CharSequence cs) {
            str.append(cs);
            return this;
        }

        @Override
        public StringWriter append(CharSequence cs, int off, int end) {
            str.append(String.valueOf(cs).substring(off, off + end));
            return this;
        }

        @Override
        public void write(char[] cbuf) {
            str.append(cbuf);
        }

        @Override
        public void write(int c) {
            str.append(c);
        }

        @Override
        public void write(String s) {
            str.append(s);
        }

        @Override
        public void write(String s, int off, int len) {
            str.append(s.substring(off, off + len));
        }

        /**
         * Return the accumulation of the writes.
         *
         * @return the result of writing all the operations.
         */
        public String data() {
            return str.toString();
        }
    }

    /**
     * Writer modifier that takes in a writer and, after each writing operation,
     * writes a set delimiter
     *
     * @param <T> the type of writer to delimit.
     */
    public static class Delimited<T extends Writer> extends Writer {

        /**
         * The wrapped writer.
         */
        protected T wr;
        /**
         * The delimiter.
         */
        protected String delimiter;

        /**
         * Wrap writer, with {@code " "} as the delimiter.
         *
         * @param writer the writer to wrap.
         */
        public Delimited(T writer) {
            this(writer, " ");
        }

        /**
         * Wrap a writer with a custom delimiter.
         *
         * @param writer the writer to wrap.
         * @param delimiter the custom delimiter.
         */
        public Delimited(T writer, String delimiter) {
            wr = writer;
            this.delimiter = delimiter;
        }

        @Override
        public void write(char[] cbuf, int off, int len) throws IOException {
            wr.write(cbuf, off, len);
            wr.write(delimiter);
        }

        @Override
        public void write(char[] cbuf) throws IOException {
            wr.write(cbuf);
            wr.write(delimiter);
        }

        @Override
        public void write(int c) throws IOException {
            wr.write(c);
            wr.write(delimiter);
        }

        @Override
        public void write(String str) throws IOException {
            wr.write(str);
            wr.write(delimiter);
        }

        @Override
        public void write(String str, int off, int len) throws IOException {
            wr.write(str, off, len);
            wr.write(delimiter);
        }

        @Override
        public void flush() throws IOException {
            wr.flush();
        }

        @Override
        public Delimited<T> append(char c) throws IOException {
            wr.append(c);
            wr.write(delimiter);
            return this;
        }

        @Override
        public Delimited<T> append(CharSequence cs) throws IOException {
            wr.append(cs);
            wr.write(delimiter);
            return this;
        }

        @Override
        public Delimited<T> append(CharSequence cs, int off, int len) throws IOException {
            wr.append(cs, off, len);
            wr.write(delimiter);
            return this;
        }

        @Override
        public void close() throws IOException {
            wr.close();
        }

        /**
         * Get the underlying writer for queries (see {@link StringWriter}) and
         * non-delimited writing.
         *
         * @return the underlying writer.
         */
        public T writer() {
            return wr;
        }
    }
}
