package androidx.camera.view;

import android.graphics.PointF;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class TapToFocusInfo {
    private final int focusState;
    private final PointF tapPoint;

    public TapToFocusInfo(int i2, PointF pointF) {
        this.focusState = i2;
        this.tapPoint = pointF;
    }

    public final int getFocusState() {
        return this.focusState;
    }

    public final PointF getTapPoint() {
        return this.tapPoint;
    }
}
