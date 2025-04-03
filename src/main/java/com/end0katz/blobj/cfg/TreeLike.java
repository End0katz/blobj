package com.end0katz.blobj.cfg;

import com.end0katz.blobj.annotations.*;

/**
 * Interface for the nested tree structure. Also contains static methods for
 * parsing various config file formats.
 */
public interface TreeLike {

    /**
     * A parser for XML into a TreeLike.
     */
    @Placeholder
    public static final Parser<TreeLike> XML = (String _) -> {
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
