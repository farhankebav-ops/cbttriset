package androidx.savedstate.serialization;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class ClassDiscriminatorMode {
    public static final int ALL_OBJECTS = 1;
    public static final ClassDiscriminatorMode INSTANCE = new ClassDiscriminatorMode();
    public static final int POLYMORPHIC = 2;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface Definition {
    }

    private ClassDiscriminatorMode() {
    }
}
