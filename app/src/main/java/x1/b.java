package x1;

import android.view.View;
import android.view.ViewGroup;
import androidx.core.math.MathUtils;
import androidx.customview.widget.ViewDragHelper;
import com.google.android.material.sidesheet.SideSheetBehavior;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class b extends ViewDragHelper.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SideSheetBehavior f17787a;

    public b(SideSheetBehavior sideSheetBehavior) {
        this.f17787a = sideSheetBehavior;
    }

    @Override // androidx.customview.widget.ViewDragHelper.Callback
    public final int clampViewPositionHorizontal(View view, int i2, int i8) {
        SideSheetBehavior sideSheetBehavior = this.f17787a;
        return MathUtils.clamp(i2, sideSheetBehavior.f5425a.X(), sideSheetBehavior.f5425a.W());
    }

    @Override // androidx.customview.widget.ViewDragHelper.Callback
    public final int clampViewPositionVertical(View view, int i2, int i8) {
        return view.getTop();
    }

    @Override // androidx.customview.widget.ViewDragHelper.Callback
    public final int getViewHorizontalDragRange(View view) {
        SideSheetBehavior sideSheetBehavior = this.f17787a;
        return sideSheetBehavior.l + sideSheetBehavior.f5432o;
    }

    @Override // androidx.customview.widget.ViewDragHelper.Callback
    public final void onViewDragStateChanged(int i2) {
        if (i2 == 1) {
            SideSheetBehavior sideSheetBehavior = this.f17787a;
            if (sideSheetBehavior.g) {
                sideSheetBehavior.a(1);
            }
        }
    }

    @Override // androidx.customview.widget.ViewDragHelper.Callback
    public final void onViewPositionChanged(View view, int i2, int i8, int i9, int i10) {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        SideSheetBehavior sideSheetBehavior = this.f17787a;
        WeakReference weakReference = sideSheetBehavior.f5433q;
        View view2 = weakReference != null ? (View) weakReference.get() : null;
        if (view2 != null && (marginLayoutParams = (ViewGroup.MarginLayoutParams) view2.getLayoutParams()) != null) {
            sideSheetBehavior.f5425a.E0(marginLayoutParams, view.getLeft(), view.getRight());
            view2.setLayoutParams(marginLayoutParams);
        }
        LinkedHashSet linkedHashSet = sideSheetBehavior.f5437u;
        if (linkedHashSet.isEmpty()) {
            return;
        }
        sideSheetBehavior.f5425a.u(i2);
        Iterator it = linkedHashSet.iterator();
        if (it.hasNext()) {
            it.next().getClass();
            throw new ClassCastException();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0053  */
    @Override // androidx.customview.widget.ViewDragHelper.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void onViewReleased(android.view.View r3, float r4, float r5) {
        /*
            r2 = this;
            com.google.android.material.sidesheet.SideSheetBehavior r0 = r2.f17787a
            r2.q r1 = r0.f5425a
            boolean r1 = r1.f0(r4)
            if (r1 == 0) goto Lb
            goto L53
        Lb:
            r2.q r1 = r0.f5425a
            boolean r1 = r1.v0(r3, r4)
            if (r1 == 0) goto L24
            r2.q r1 = r0.f5425a
            boolean r4 = r1.h0(r4, r5)
            if (r4 != 0) goto L55
            r2.q r4 = r0.f5425a
            boolean r4 = r4.g0(r3)
            if (r4 == 0) goto L53
            goto L55
        L24:
            r1 = 0
            int r1 = (r4 > r1 ? 1 : (r4 == r1 ? 0 : -1))
            if (r1 == 0) goto L36
            float r4 = java.lang.Math.abs(r4)
            float r5 = java.lang.Math.abs(r5)
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 <= 0) goto L36
            goto L55
        L36:
            int r4 = r3.getLeft()
            r2.q r5 = r0.f5425a
            int r5 = r5.U()
            int r5 = r4 - r5
            int r5 = java.lang.Math.abs(r5)
            r2.q r1 = r0.f5425a
            int r1 = r1.V()
            int r4 = r4 - r1
            int r4 = java.lang.Math.abs(r4)
            if (r5 >= r4) goto L55
        L53:
            r4 = 3
            goto L56
        L55:
            r4 = 5
        L56:
            r5 = 1
            r0.c(r3, r4, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: x1.b.onViewReleased(android.view.View, float, float):void");
    }

    @Override // androidx.customview.widget.ViewDragHelper.Callback
    public final boolean tryCaptureView(View view, int i2) {
        WeakReference weakReference;
        SideSheetBehavior sideSheetBehavior = this.f17787a;
        return (sideSheetBehavior.h == 1 || (weakReference = sideSheetBehavior.p) == null || weakReference.get() != view) ? false : true;
    }
}
