package com.end0katz.blobj.event;

import java.lang.annotation.*;

/**
 * Annotation to indicate a method to be subscribed to an event.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Subscribe {

    /**
     * The name of the {@link Event}(s) to subscribe to. This is a java regex.
     *
     * @return the regex to determine if this will subscribe to an event or not.
     */
    String value() default ".*";
}
