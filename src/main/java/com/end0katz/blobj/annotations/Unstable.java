package com.end0katz.blobj.annotations;

import java.lang.annotation.*;

/**
 * Annotation to signify this code/package is in beta - It may change suddenly
 * with no notice, and should not be relied on. Use with caution!
 *
 * &commat;Unstable should be avoided out of snapshot builds.
 */
@Documented
public @interface Unstable { }
