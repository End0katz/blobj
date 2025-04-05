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

    public CaesarCipher(int amount, CaesarCipherMethod method) {
        this.amount = amount;
        this.method = method;
    }

    public static enum CaesarCipherMethod {
        ALPHABETIC_ONLY,
        ALPHANUMERIC_ONLY,
        ASCII_ONLY,
        IN_BLOCK_ONLY,
        UNICODE_EXISTS,
        UNRESTRICTED_UNICODE;
    }

    @Override
    public String encrypt(String target) {
        StringBuilder result = new StringBuilder();
        for (char c : target.toCharArray()) {
            switch (method) {
                case ALPHABETIC_ONLY -> {
                    if (Character.toString(c).matches("[A-Za-z]")) {
                        if (Character.isUpperCase(c)) {
                            result.append((char) (((c - 'A' + amount) % 26) + 'A'));
                        } else {
                            result.append((char) (((c - 'a' + amount) % 26) + 'a'));
                        }
                    } else {
                        result.append(c);
                    }
                }

                case ASCII_ONLY -> {
                    if (c < 128) {
                        result.append((char) ((c + amount) % 128));
                    } else {
                        result.append(c);
                    }
                }

                case ALPHANUMERIC_ONLY -> {
                    if (Character.toString(c).matches("[A-Za-z0-9]")) {
                        String chrs = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
                        result.append(chrs.codePointAt((chrs.indexOf(c) + amount) % chrs.length()));
                    } else {
                        result.append(c);
                    }
                }

                case IN_BLOCK_ONLY -> {
                    String chrs = StringConsts.codePointsOfBlock(Character.UnicodeBlock.of(c));
                    result.append(chrs.codePointAt((chrs.indexOf(c) + amount) % chrs.length()));
                }
                case UNICODE_EXISTS -> {
                    if (Character.isDefined(c)) {
                        int ch = c;
                        for (int i = 0; i < amount; i++) {
                            do {
                                ch++;
                                ch %= StringConsts.codePoints;
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
                    ch %= StringConsts.codePoints;
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
