package com.end0katz.blobj.event;

import java.lang.annotation.*;

/**
 * Annotation to indicate a method to be subscsribed to an event.
 *
 * @param event the name of the event(s) to subscribe to. This is a java regex.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Subscribe {

    String value() default ".*";
}
