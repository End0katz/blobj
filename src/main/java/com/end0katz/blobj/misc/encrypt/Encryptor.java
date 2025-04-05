package com.end0katz.blobj.misc.encrypt;

/**
 * Base class for all encryptors. Provides methods to encrypt and decrypt
 * strings.
 */
public interface Encryptor {

    /**
     * Encode a string.
     *
     * @param target the string to encrypt.
     * @return the encoded string.
     *
     * @future.implSpec a call to encrypt then decrypt with the same state
     * should always return the same value.
     */
    String encrypt(String target);

    /**
     * Decode a string.
     *
     * @param target the string to decrypt.
     * @return the decrypted note.
     *
     * @future.implSpec a call to encrypt then decrypt with the same state
     * should always return the same value.
     */
    String decrypt(String target);
}
