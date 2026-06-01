package androidx.core.widget;

import android.content.Context;
import android.view.animation.Interpolator;
import android.widget.OverScroller;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public final class ScrollerCompat {
    OverScroller mScroller;

    public ScrollerCompat(Context context, Interpolator interpolator) {
        this.mScroller = interpolator != null ? new OverScroller(context, interpolator) : new OverScroller(context);
    }

    @Deprecated
    public static ScrollerCompat create(Context context) {
        return create(context, null);
    }

    @Deprecated
    public void abortAnimation() {
        this.mScroller.abortAnimation();
    }

    @Deprecated
    public boolean computeScrollOffset() {
        return this.mScroller.computeScrollOffset();
    }

    @Deprecated
    public void fling(int i2, int i8, int i9, int i10, int i11, int i12, int i13, int i14) {
        this.mScroller.fling(i2, i8, i9, i10, i11, i12, i13, i14);
    }

    @Deprecated
    public float getCurrVelocity() {
        return this.mScroller.getCurrVelocity();
    }

    @Deprecated
    public int getCurrX() {
        return this.mScroller.getCurrX();
    }

    @Deprecated
    public int getCurrY() {
        return this.mScroller.getCurrY();
    }

    @Deprecated
    public int getFinalX() {
        return this.mScroller.getFinalX();
    }

    @Deprecated
    public int getFinalY() {
        return this.mScroller.getFinalY();
    }

    @Deprecated
    public boolean isFinished() {
        return this.mScroller.isFinished();
    }

    @Deprecated
    public boolean isOverScrolled() {
        return this.mScroller.isOverScrolled();
    }

    @Deprecated
    public void notifyHorizontalEdgeReached(int i2, int i8, int i9) {
        this.mScroller.notifyHorizontalEdgeReached(i2, i8, i9);
    }

    @Deprecated
    public void notifyVerticalEdgeReached(int i2, int i8, int i9) {
        this.mScroller.notifyVerticalEdgeReached(i2, i8, i9);
    }

    @Deprecated
    public boolean springBack(int i2, int i8, int i9, int i10, int i11, int i12) {
        return this.mScroller.springBack(i2, i8, i9, i10, i11, i12);
    }

    @Deprecated
    public void startScroll(int i2, int i8, int i9, int i10) {
        this.mScroller.startScroll(i2, i8, i9, i10);
    }

    @Deprecated
    public static ScrollerCompat create(Context context, Interpolator interpolator) {
        return new ScrollerCompat(context, interpolator);
    }

    @Deprecated
    public void fling(int i2, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, int i16) {
        this.mScroller.fling(i2, i8, i9, i10, i11, i12, i13, i14, i15, i16);
    }

    @Deprecated
    public void startScroll(int i2, int i8, int i9, int i10, int i11) {
        this.mScroller.startScroll(i2, i8, i9, i10, i11);
    }
}
