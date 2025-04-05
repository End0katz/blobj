package com.end0katz.blobj;

import java.util.function.*;

import com.end0katz.blobj.annotations.*;

/**
 * Class to contain constants and methods related to strings.
 */
@Group
public enum StringConsts {
    ;

    /**
     * The number of code points in unicode.
     * Code points are zero-indexed, so the biggest code point is this minus 1
     */
    public static final int codePoints = 1_114_112;

    /**
     * String containing every single unicode code point.
     */
    public static final String allUnicodeChars = allUnicodeChars((_) -> true);

    /**
     * String containing all defined code points.
     */
    public static final String allDefinedChars = allUnicodeChars(Character::isDefined);

    /**
     * List of all ASCII characters
     */
    public static final String allAsciiChars = allUnicodeChars((c) -> c < 128);

    /**
     * Return all unicode chars matching a filter.
     *
     * @param filter filter to determine if the character gets in.
     * @return the filtered list of unicode chars.
     *
     * @see StringConsts#allUnicodeChars
     */
    public static String allUnicodeChars(Function<Character, Boolean> filter) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < codePoints; i++) {
            if (filter.apply((char) i)) {
                result.append((char) i);
            }
        }
        return result.toString();
    }

    /**
     * Return a string consisting of all the code points in a
     * {@link Character.UnicodeBlock}.
     *
     * @param block the UnicodeBlock to list the characters of.
     * @return a string consisting of all the code points.
     */
    public static String codePointsOfBlock(Character.UnicodeBlock block) {
        return allUnicodeChars((c) -> Character.UnicodeBlock.of(c) == block);
    }
}
