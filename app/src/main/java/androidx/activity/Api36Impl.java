package androidx.activity;

import android.window.BackEvent;
import androidx.annotation.RequiresApi;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
@RequiresApi(36)
public final class Api36Impl {
    public static final Api36Impl INSTANCE = new Api36Impl();

    private Api36Impl() {
    }

    public final BackEvent createOnBackEvent(float f4, float f8, float f9, int i2, long j) {
        return new BackEvent(f4, f8, f9, i2, j);
    }

    public final long frameTimeMillis(BackEvent backEvent) {
        kotlin.jvm.internal.k.e(backEvent, "backEvent");
        return backEvent.getFrameTimeMillis();
    }
}
