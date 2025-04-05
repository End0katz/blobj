package com.end0katz.blobj.misc.encrypt;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class CaesarCipherTest {

    @Test
    void testAlphabetic() {
        assertEquals(
                "BcD.eAa",
                new CaesarCipher(1, CaesarCipher.CaesarCipherMethod.ALPHABETIC_ONLY)
                        .encrypt("AbC.dZz")
        );
        assertEquals(
                "AbC.dZz",
                new CaesarCipher(1, CaesarCipher.CaesarCipherMethod.ALPHABETIC_ONLY)
                        .decrypt("BcD.eAa")
        );
        assertEquals(
                "BcD,eAa",
                new CaesarCipher(27, CaesarCipher.CaesarCipherMethod.ALPHABETIC_ONLY)
                        .encrypt("AbC,dZz")
        );
    }

    @Test
    void testAlphanumeric() {
        assertEquals(
                "9A a0",
                new CaesarCipher(1, CaesarCipher.CaesarCipherMethod.ALPHANUMERIC_ONLY)
                        .encrypt("89 Zz")
        );
    }

    @Test
    void testAscii() {
        assertEquals(
                "!\"£",
                new CaesarCipher(1, CaesarCipher.CaesarCipherMethod.ASCII_ONLY)
                        .encrypt(" !£")
        );
    }

    @Test
    void testSameBlock() {
        assertEquals(
                "ӽӾ─ӿЀ",
                new CaesarCipher(1, CaesarCipher.CaesarCipherMethod.IN_BLOCK_ONLY)
                        .encrypt("Ӽӽ╿Ӿӿ")
        );
    }
}
