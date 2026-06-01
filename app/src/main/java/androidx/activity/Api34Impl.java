package androidx.activity;

import android.window.BackEvent;
import androidx.annotation.RequiresApi;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
@RequiresApi(34)
public final class Api34Impl {
    public static final Api34Impl INSTANCE = new Api34Impl();

    private Api34Impl() {
    }

    public final BackEvent createOnBackEvent(float f4, float f8, float f9, int i2) {
        return new BackEvent(f4, f8, f9, i2);
    }

    public final float progress(BackEvent backEvent) {
        kotlin.jvm.internal.k.e(backEvent, "backEvent");
        return backEvent.getProgress();
    }

    public final int swipeEdge(BackEvent backEvent) {
        kotlin.jvm.internal.k.e(backEvent, "backEvent");
        return backEvent.getSwipeEdge();
    }

    public final float touchX(BackEvent backEvent) {
        kotlin.jvm.internal.k.e(backEvent, "backEvent");
        return backEvent.getTouchX();
    }

    public final float touchY(BackEvent backEvent) {
        kotlin.jvm.internal.k.e(backEvent, "backEvent");
        return backEvent.getTouchY();
    }
}
