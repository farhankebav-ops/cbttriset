package androidx.resourceinspection.annotation;

import androidx.annotation.NonNull;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.SOURCE)
public @interface Attribute {

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @Target({})
    @Retention(RetentionPolicy.SOURCE)
    public @interface IntMap {
        int mask() default 0;

        @NonNull
        String name();

        int value();
    }

    @NonNull
    IntMap[] intMapping() default {};

    @NonNull
    String value();
}
