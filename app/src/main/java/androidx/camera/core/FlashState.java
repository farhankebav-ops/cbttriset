package androidx.camera.core;

import androidx.annotation.RestrictTo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class FlashState {
    public static final int FIRED = 1;
    public static final FlashState INSTANCE = new FlashState();
    public static final int NOT_FIRED = 3;
    public static final int UNAVAILABLE = 2;
    public static final int UNKNOWN = 0;

    /* JADX INFO: renamed from: androidx.camera.core.FlashState$FlashState, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface InterfaceC0001FlashState {
    }

    private FlashState() {
    }
}
