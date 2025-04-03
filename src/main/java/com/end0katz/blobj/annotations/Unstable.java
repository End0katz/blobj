package com.end0katz.blobj.annotations;

import java.lang.annotation.*;

/**
 * Annotation to signify this code, package, etc, is in beta - It may change
 * suddenly with no notice, and should not be relied on. Use with caution!
 *
 * &commat;Unstable should be avoided out of snapshot builds.
 *
 * <p>
 * If an IDE/compiler that supports blobj encounters:
 * <ul>
 * <li>Usage of &commat;Unstable code in stable environments</li>
 * <li>Usage of &commat;Unstable annotation outside of snapshot builds</li>
 * </ul>
 * it should give a warning.
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface Unstable {
}
