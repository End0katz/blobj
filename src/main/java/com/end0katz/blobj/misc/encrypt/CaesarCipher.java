package com.end0katz.blobj.misc.encrypt;

import com.end0katz.blobj.*;

/**
 * Caesar cipher. simple as
 */
public class CaesarCipher implements Encryptor {

    /**
     * The amount to shift by
     */
    int amount;

    /**
     * How To Shift
     */
    CaesarCipherMethod method;

    /**
     * Construct a Caesar Cipher that shifts a certain amount with a certain
     * method.
     *
     * @param amount the amount to shift. use negative values to shift
     * backwards.
     * @param method the {@link CaesarCipherMethod} explaining how to shift.
     */
    public CaesarCipher(int amount, CaesarCipherMethod method) {
        this.amount = amount;
        this.method = method;
    }

    /**
     * Method to explain which characters to shift and to what
     */
    public static enum CaesarCipherMethod {
        /**
         * Shift A-Z to other A-Z and vice-versa for lowercase.
         */
        ALPHABETIC_ONLY,
        /**
         * Shift using pattern: 0-9A-Za-z.
         */
        ALPHANUMERIC_ONLY,
        /**
         * Shift ascii characters.
         */
        ASCII_ONLY,
        /**
         * Shift to other characters in same unicode block.
         */
        IN_BLOCK_ONLY,
        /**
         * Shift to any other existing unicode character.
         */
        UNICODE_EXISTS,
        /**
         * Shift to other unicode characters, regardless of if they exist or
         * not.
         */
        UNRESTRICTED_UNICODE;
    }

    @Override
    public String encrypt(String target) {
        StringBuilder result = new StringBuilder();
        for (char c : target.toCharArray()) {
            switch (method) {
                case ALPHABETIC_ONLY -> {
                    if (Character.toString(c).matches("[A-Za-z]")) {
                        String chrs;
                        if (Character.isUpperCase(c)) {
                            chrs = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
                        } else {
                            chrs = "abcdefghijklmnopqrstuvwxyz";
                        }
                        result.append(chrs.charAt(
                                Math.floorMod(chrs.indexOf(c) + amount, 26))
                        );
                    } else {
                        result.append(c);
                    }
                }

                case ASCII_ONLY -> {
                    if (c < 128) {
                        result.append((char) Math.floorMod((c + amount), 128));
                    } else {
                        result.append(c);
                    }
                }

                case ALPHANUMERIC_ONLY -> {
                    if (Character.toString(c).matches("[A-Za-z0-9]")) {
                        String chrs = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
                        result.append(chrs.charAt(Math.floorMod((chrs.indexOf(c) + amount), chrs.length())));
                    } else {
                        result.append(c);
                    }
                }

                case IN_BLOCK_ONLY -> {
                    String chrs = StringConsts.codePointsOfBlock(Character.UnicodeBlock.of(c));
                    result.append(chrs.charAt(Math.floorMod((chrs.indexOf(c) + amount), chrs.length())));
                }
                case UNICODE_EXISTS -> {
                    if (Character.isDefined(c)) {
                        int ch = c;
                        for (int i = 0; i < amount; i++) {
                            do {
                                ch++;
                                ch = Math.floorMod(ch, StringConsts.codePoints);
                            } while (Character.isDefined(ch));
                        }
                        result.append((char) ch);
                    } else {
                        result.append(c);
                    }
                }

                case UNRESTRICTED_UNICODE -> {
                    int ch = c;
                    ch += amount;
                    ch = Math.floorMod(ch, StringConsts.codePoints);
                    result.append((char) ch);
                }

                default ->
                    throw new UnsupportedOperationException("TODO CaeserCipherMethod %s".formatted(method));
            }
        }
        return result.toString();
    }

    @Override
    public String decrypt(String target) {
        return new CaesarCipher(-amount, method).encrypt(target);
    }
}
