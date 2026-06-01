package e1;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import r2.q;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class d extends q {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f11214b;

    @Override // r2.q
    public final int c0(View view, ViewGroup.MarginLayoutParams marginLayoutParams) {
        int measuredHeight;
        int i2;
        switch (this.f11214b) {
            case 0:
                measuredHeight = view.getMeasuredHeight();
                i2 = marginLayoutParams.bottomMargin;
                break;
            case 1:
                measuredHeight = view.getMeasuredWidth();
                i2 = marginLayoutParams.leftMargin;
                break;
            default:
                measuredHeight = view.getMeasuredWidth();
                i2 = marginLayoutParams.rightMargin;
                break;
        }
        return measuredHeight + i2;
    }

    @Override // r2.q
    public final int d0() {
        switch (this.f11214b) {
            case 0:
                return 1;
            case 1:
                return 2;
            default:
                return 0;
        }
    }

    @Override // r2.q
    public final ViewPropertyAnimator e0(View view, int i2) {
        switch (this.f11214b) {
            case 0:
                return view.animate().translationY(i2);
            case 1:
                return view.animate().translationX(-i2);
            default:
                return view.animate().translationX(i2);
        }
    }
}
