package com.bumptech.glide.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.CLASS)
public @interface GlideOption {
    public static final int OVERRIDE_EXTEND = 1;
    public static final int OVERRIDE_NONE = 0;
    public static final int OVERRIDE_REPLACE = 2;

    boolean memoizeStaticMethod() default false;

    int override() default 0;

    boolean skipStaticMethod() default false;

    String staticMethodName() default "";
}
