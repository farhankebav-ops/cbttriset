package androidx.constraintlayout.core.motion.utils;

import androidx.constraintlayout.core.motion.MotionWidget;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public class ViewState {
    public int bottom;
    public int left;
    public int right;
    public float rotation;
    public int top;

    public void getState(MotionWidget motionWidget) {
        this.left = motionWidget.getLeft();
        this.top = motionWidget.getTop();
        this.right = motionWidget.getRight();
        this.bottom = motionWidget.getBottom();
        this.rotation = (int) motionWidget.getRotationZ();
    }

    public int height() {
        return this.bottom - this.top;
    }

    public int width() {
        return this.right - this.left;
    }
}
