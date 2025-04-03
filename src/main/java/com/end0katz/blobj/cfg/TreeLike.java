package com.end0katz.blobj.cfg;

import java.util.*;

import org.jsoup.*;
import org.jsoup.nodes.*;

import com.end0katz.blobj.annotations.Placeholder;
import com.end0katz.blobj.containers.Container;

/**
 * Interface for the nested tree structure. Also contains static methods for
 * parsing various config file formats.
 */
public interface TreeLike {

    /**
     * TreeLike to contain an integer value.
     *
     * @param get the value of this TreeLike.
     */
    public static record IntValue(Integer get) implements TreeLike, Container<Integer> {

    }

    /**
     * TreeLike to contain a floating-point value
     *
     * @param get the value of this TreeLike.
     */
    public static record FloatValue(Double get) implements TreeLike, Container<Double> {

    }

    /**
     * TreeLike to contain a String value
     *
     * @param get the value of this TreeLike.
     */
    public static record StringValue(String get) implements TreeLike, Container<String> {

    }

    /**
     * TreeLike to contain an array of other TreeLikes
     *
     * @param get the value of this TreeLike.
     * @param <T> the type of TreeLike in this list
     */
    public static record ListValue<T extends TreeLike>(T[] get) implements TreeLike, Container<T[]> {

    }

    /**
     * TreeLike to contain a mapping of other TreeLikes.
     *
     * @param get the value of this TreeLike.
     * @param <T> the type of TreeLike in this map
     */
    public static record MapValue<T extends TreeLike>(Map<String, T> get)
            implements TreeLike, Container<Map<String, T>> {

    }

    /**
     * A parser for XML into a TreeLike.
     */
    @Placeholder
    public static final Parser<TreeLike> XML = (String s) -> {
        Document d = Jsoup.parse(s, org.jsoup.parser.Parser.xmlParser());
        return null;
    };

    /**
     * A parser for YAML into a TreeLike.
     */
    @Placeholder
    public static final Parser<TreeLike> YAML = (String _) -> {
        return null;
    };

    /**
     * A parser for JSON into a TreeLike.
     */
    @Placeholder
    public static final Parser<TreeLike> JSON = (String _) -> {
        return null;
    };

    /**
     * A parser for TOML into a TreeLike.
     */
    @Placeholder
    public static final Parser<TreeLike> TOML = (String _) -> {
        return null;
    };
}
