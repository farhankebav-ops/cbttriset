package e1;

import android.view.View;
import android.view.ViewParent;
import androidx.customview.widget.ViewDragHelper;
import com.google.android.material.behavior.SwipeDismissBehavior;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class e extends ViewDragHelper.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f11215a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f11216b = -1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ SwipeDismissBehavior f11217c;

    public e(SwipeDismissBehavior swipeDismissBehavior) {
        this.f11217c = swipeDismissBehavior;
    }

    @Override // androidx.customview.widget.ViewDragHelper.Callback
    public final int clampViewPositionHorizontal(View view, int i2, int i8) {
        int width;
        int width2;
        int width3;
        boolean z2 = view.getLayoutDirection() == 1;
        int i9 = this.f11217c.f5269d;
        if (i9 == 0) {
            if (z2) {
                width = this.f11215a - view.getWidth();
                width2 = this.f11215a;
            } else {
                width = this.f11215a;
                width3 = view.getWidth();
                width2 = width3 + width;
            }
        } else if (i9 != 1) {
            width = this.f11215a - view.getWidth();
            width2 = view.getWidth() + this.f11215a;
        } else if (z2) {
            width = this.f11215a;
            width3 = view.getWidth();
            width2 = width3 + width;
        } else {
            width = this.f11215a - view.getWidth();
            width2 = this.f11215a;
        }
        return Math.min(Math.max(width, i2), width2);
    }

    @Override // androidx.customview.widget.ViewDragHelper.Callback
    public final int clampViewPositionVertical(View view, int i2, int i8) {
        return view.getTop();
    }

    @Override // androidx.customview.widget.ViewDragHelper.Callback
    public final int getViewHorizontalDragRange(View view) {
        return view.getWidth();
    }

    @Override // androidx.customview.widget.ViewDragHelper.Callback
    public final void onViewCaptured(View view, int i2) {
        this.f11216b = i2;
        this.f11215a = view.getLeft();
        ViewParent parent = view.getParent();
        if (parent != null) {
            SwipeDismissBehavior swipeDismissBehavior = this.f11217c;
            swipeDismissBehavior.f5268c = true;
            parent.requestDisallowInterceptTouchEvent(true);
            swipeDismissBehavior.f5268c = false;
        }
    }

    @Override // androidx.customview.widget.ViewDragHelper.Callback
    public final void onViewDragStateChanged(int i2) {
        this.f11217c.getClass();
    }

    @Override // androidx.customview.widget.ViewDragHelper.Callback
    public final void onViewPositionChanged(View view, int i2, int i8, int i9, int i10) {
        float width = view.getWidth();
        SwipeDismissBehavior swipeDismissBehavior = this.f11217c;
        float f4 = width * swipeDismissBehavior.f5270f;
        float width2 = view.getWidth() * swipeDismissBehavior.g;
        float fAbs = Math.abs(i2 - this.f11215a);
        if (fAbs <= f4) {
            view.setAlpha(1.0f);
        } else if (fAbs >= width2) {
            view.setAlpha(0.0f);
        } else {
            view.setAlpha(Math.min(Math.max(0.0f, 1.0f - ((fAbs - f4) / (width2 - f4))), 1.0f));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0065  */
    @Override // androidx.customview.widget.ViewDragHelper.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void onViewReleased(android.view.View r9, float r10, float r11) {
        /*
            r8 = this;
            r11 = -1
            r8.f11216b = r11
            int r11 = r9.getWidth()
            r0 = 0
            int r1 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            r2 = 0
            com.google.android.material.behavior.SwipeDismissBehavior r3 = r8.f11217c
            r4 = 1
            if (r1 == 0) goto L37
            int r5 = r9.getLayoutDirection()
            if (r5 != r4) goto L18
            r5 = r4
            goto L19
        L18:
            r5 = r2
        L19:
            int r6 = r3.f5269d
            r7 = 2
            if (r6 != r7) goto L1f
            goto L50
        L1f:
            if (r6 != 0) goto L2b
            if (r5 == 0) goto L28
            int r1 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r1 >= 0) goto L65
            goto L50
        L28:
            if (r1 <= 0) goto L65
            goto L50
        L2b:
            if (r6 != r4) goto L65
            if (r5 == 0) goto L32
            if (r1 <= 0) goto L65
            goto L50
        L32:
            int r1 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r1 >= 0) goto L65
            goto L50
        L37:
            int r1 = r9.getLeft()
            int r5 = r8.f11215a
            int r1 = r1 - r5
            int r5 = r9.getWidth()
            float r5 = (float) r5
            float r6 = r3.e
            float r5 = r5 * r6
            int r5 = java.lang.Math.round(r5)
            int r1 = java.lang.Math.abs(r1)
            if (r1 < r5) goto L65
        L50:
            int r10 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r10 < 0) goto L5f
            int r10 = r9.getLeft()
            int r0 = r8.f11215a
            if (r10 >= r0) goto L5d
            goto L5f
        L5d:
            int r0 = r0 + r11
            goto L63
        L5f:
            int r10 = r8.f11215a
            int r0 = r10 - r11
        L63:
            r2 = r4
            goto L67
        L65:
            int r0 = r8.f11215a
        L67:
            androidx.customview.widget.ViewDragHelper r10 = r3.f5266a
            int r11 = r9.getTop()
            boolean r10 = r10.settleCapturedViewAt(r0, r11)
            if (r10 == 0) goto L7c
            e1.g r10 = new e1.g
            r11 = 0
            r10.<init>(r11, r3, r9, r2)
            r9.postOnAnimation(r10)
        L7c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: e1.e.onViewReleased(android.view.View, float, float):void");
    }

    @Override // androidx.customview.widget.ViewDragHelper.Callback
    public final boolean tryCaptureView(View view, int i2) {
        int i8 = this.f11216b;
        return (i8 == -1 || i8 == i2) && this.f11217c.a(view);
    }
}
