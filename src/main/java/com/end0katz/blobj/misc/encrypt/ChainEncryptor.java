package com.end0katz.blobj.misc.encrypt;

import java.util.*;

/**
 * Class for chaining together multiple {@link Encryptor}s
 */
public class ChainEncryptor implements Encryptor {

    /**
     * The list of encryptors.
     */
    List<Encryptor> chain = new ArrayList<>();

    /**
     * Add {@link Encryptor}(s) to the chain.
     *
     * @param e the group of encryptors to add.
     * @return {@code this}
     */
    public ChainEncryptor add(Encryptor... e) {
        return this.add(Arrays.asList(e));
    }

    /**
     * Add {@link Encryptor}s to the chain.
     *
     * @param e the {@link Collection} of encryptors to add.
     * @return {@code this}
     */
    public ChainEncryptor add(Collection<Encryptor> es) {
        chain.addAll(es);
        return this;
    }

    @Override
    public String encrypt(String target) {
        String result = target;
        for (Encryptor e : chain) {
            result = e.encrypt(result);
        }
        return result;
    }

    @Override
    public String decrypt(String target) {
        String result = target;
        for (Encryptor e : chain.reversed()) {
            result = e.decrypt(result);
        }
        return result;
    }
}
