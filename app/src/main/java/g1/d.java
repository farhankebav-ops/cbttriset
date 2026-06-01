package g1;

import android.os.SystemClock;
import android.view.View;
import androidx.core.math.MathUtils;
import androidx.customview.widget.ViewDragHelper;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class d extends ViewDragHelper.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BottomSheetBehavior f11563a;

    public d(BottomSheetBehavior bottomSheetBehavior) {
        this.f11563a = bottomSheetBehavior;
    }

    @Override // androidx.customview.widget.ViewDragHelper.Callback
    public final int clampViewPositionHorizontal(View view, int i2, int i8) {
        return view.getLeft();
    }

    @Override // androidx.customview.widget.ViewDragHelper.Callback
    public final int clampViewPositionVertical(View view, int i2, int i8) {
        return MathUtils.clamp(i2, this.f11563a.g(), getViewVerticalDragRange(view));
    }

    @Override // androidx.customview.widget.ViewDragHelper.Callback
    public final int getViewVerticalDragRange(View view) {
        BottomSheetBehavior bottomSheetBehavior = this.f11563a;
        return bottomSheetBehavior.I ? bottomSheetBehavior.V : bottomSheetBehavior.G;
    }

    @Override // androidx.customview.widget.ViewDragHelper.Callback
    public final void onViewDragStateChanged(int i2) {
        if (i2 == 1) {
            BottomSheetBehavior bottomSheetBehavior = this.f11563a;
            if (bottomSheetBehavior.K) {
                bottomSheetBehavior.l(1);
            }
        }
    }

    @Override // androidx.customview.widget.ViewDragHelper.Callback
    public final void onViewPositionChanged(View view, int i2, int i8, int i9, int i10) {
        this.f11563a.d(i8);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:6:0x000d  */
    @Override // androidx.customview.widget.ViewDragHelper.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void onViewReleased(android.view.View r6, float r7, float r8) {
        /*
            Method dump skipped, instruction units count: 233
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: g1.d.onViewReleased(android.view.View, float, float):void");
    }

    @Override // androidx.customview.widget.ViewDragHelper.Callback
    public final boolean tryCaptureView(View view, int i2) {
        BottomSheetBehavior bottomSheetBehavior = this.f11563a;
        int i8 = bottomSheetBehavior.N;
        if (i8 == 1 || bottomSheetBehavior.f5276c0) {
            return false;
        }
        if (i8 == 3 && bottomSheetBehavior.f5272a0 == i2) {
            WeakReference weakReference = bottomSheetBehavior.X;
            View view2 = weakReference != null ? (View) weakReference.get() : null;
            if (view2 != null && view2.canScrollVertically(-1)) {
                return false;
            }
        }
        SystemClock.uptimeMillis();
        WeakReference weakReference2 = bottomSheetBehavior.W;
        return weakReference2 != null && weakReference2.get() == view;
    }
}
