package com.end0katz.blobj.annotations;

import java.lang.annotation.*;

/**
 * Annotation to indicate that the class below is designed only be instantiated
 * once: no other times.
 *
 * Usage: {@snippet id="annotation-singleton-usage":
 *  @Singleton
 *  public enum MyGroup {
 *      INSTANCE;
 *
 *      public String yeet(Foo bar) {return "In this world, it's yeet or be yote";} }
 * }
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Singleton {

}
