package com.end0katz.blobj.annotations;

import java.lang.annotation.*;

/**
 * Annotation to indicate that the class below is designed only to hold static
 * variables, methods and classes: it should not be subclassed, nor
 * instantiated.
 *
 * Usage: {@snippet id="annotation-group-usage":
 *  @Group
 *  public enum MyGroup {
 *      // No Members
 *
 *      public static String yeet(Foo bar) {return "In this world, it's yeet or be yote";}
 * } }
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Group {

}
