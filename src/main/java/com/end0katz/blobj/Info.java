package com.end0katz.blobj;

import java.util.*;

import com.end0katz.blobj.annotations.*;

/**
 * A collection of methods to get {@link String} descriptions of an object.
 */
@Group
public enum Info {
    ;

    /**
     * Return the string description of a class.
     *
     * @param cls the class to return the description of.
     * @return the class description.
     * 
     * @see Info#convertObjectToString(Object)
     * @see Info#of(Object)
     */
    public static String classToString(Class<?> cls) {
        if (cls == null) {
            throw new NullPointerException("Cannot get class description of null; null is not a class");
        } else if (cls.isArray()) {
            return classToString(cls.componentType()) + "[]";
        } else if (cls.isPrimitive()) {
            if (cls == Integer.TYPE) {
                return "int";
            } else if (cls == Byte.TYPE) {
                return "byte";
            } else if (cls == Short.TYPE) {
                return "short";
            } else if (cls == Long.TYPE) {
                return "long";
            } else if (cls == Float.TYPE) {
                return "float";
            } else if (cls == Double.TYPE) {
                return "double";
            } else if (cls == Boolean.TYPE) {
                return "bool";
            } else if (cls == Character.TYPE) {
                return "char";
            } else if (cls == Void.TYPE) {
                return "void";
            } else {
                return "UNKNOWN PRIMITIVE";
            }
        } else {
            if (cls.getCanonicalName() == null) {
                return "?%s:%s#%s;".formatted(
                        Integer.toHexString(cls.getModifiers()),
                        cls.getName().substring(cls.getPackage().getName().length() + 1),
                        cls.getSimpleName()
                );
            } else if (cls.getPackageName().startsWith("java.lang")) {
                StringBuilder result = new StringBuilder("java");

                for (String s : cls.getPackage().getName()
                        .substring("java.lang".length())
                        .replaceFirst("^\\.", "")
                        .split("\\.")) {
                    if ("".equals(s)) {
                        continue;
                    }
                    result.append((s + "___").substring(0, 3));
                }

                result.append(":");
                result.append(cls.getPackageName().substring(cls.getPackage().getName().length()));
                result.append(".");
                result.append(Arrays.<String>asList(cls.getCanonicalName().split("\\.")).getLast());

                if (result.indexOf(":.") > -1) {
                    result.replace(
                            result.indexOf(":."),
                            result.indexOf(":.") + 2,
                            ":"
                    );
                }

                return result.toString();
            } else {
                List<String> pkg = Arrays.asList(cls.getPackage().getName().split("\\."));
                StringBuilder result = new StringBuilder();

                for (String s : pkg.subList(0, pkg.size() - 1)) {
                    result.append(s.substring(0, 1).toUpperCase(Locale.ROOT));
                }
                result.append(pkg.getLast());
                result.append(":");

                if (cls.getDeclaringClass() != null) {
                    Class<?> decl = cls.getDeclaringClass();
                    result.append(decl.getCanonicalName().substring(decl.getPackageName().length() + 1));
                }

                result.append(".");
                result.append(Arrays.<String>asList(cls.getCanonicalName().split("\\.")).getLast());

                if (result.indexOf(":.") > -1) {
                    result.replace(
                            result.indexOf(":."),
                            result.indexOf(":.") + 2,
                            ":"
                    );
                }

                return result.toString();
            }
        }
    }

    /**
     * Convert an object to a {@link String}.
     *
     * @param obj the object to convert.
     * @return a string representation of {@code obj}.
     *
     * @see Info#classToString(Class)
     * @see Info#of(Object)
     */
    public static String convertObjectToString(Object obj) {
        if (obj == null) {
            return "null";
        } else if (obj instanceof CharSequence cs) {
            return cs.toString();
        } else if (obj instanceof char[] chrs) {
            return String.valueOf(chrs);
        } else if (obj instanceof Character[] chrs) {
            StringBuilder result = new StringBuilder();
            for (Character c : chrs) {
                result.append((char) c);
            }
            return result.toString();
        } else if (obj instanceof Iterable iter) {
            StringBuilder result = new StringBuilder("[");
            for (Object o : iter) {
                result.append(convertObjectToString(o));
                result.append(", ");
            }
            return result.toString().substring(0, result.length() - 2) + "]";
        }

        return obj.toString();
    }

    /**
     * Get a description of an object.
     *
     * @param obj the object to obtain a description of.
     * @return the description
     *
     * @see Info#classToString(Class)
     * @see Info#convertObjectToString(Object)
     */
    public static String of(Object obj) {
        if (obj == null) {
            return "null";
        }
        return classToString(obj.getClass()) + " " + convertObjectToString(obj);
    }
}
