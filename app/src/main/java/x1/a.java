package x1;

import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.sidesheet.SideSheetBehavior;
import r2.q;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class a extends q {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f17785b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SideSheetBehavior f17786c;

    public /* synthetic */ a(SideSheetBehavior sideSheetBehavior, int i2) {
        this.f17785b = i2;
        this.f17786c = sideSheetBehavior;
    }

    @Override // r2.q
    public final void E0(ViewGroup.MarginLayoutParams marginLayoutParams, int i2, int i8) {
        switch (this.f17785b) {
            case 0:
                if (i2 <= this.f17786c.m) {
                    marginLayoutParams.leftMargin = i8;
                }
                break;
            default:
                int i9 = this.f17786c.m;
                if (i2 <= i9) {
                    marginLayoutParams.rightMargin = i9 - i2;
                }
                break;
        }
    }

    @Override // r2.q
    public final int U() {
        switch (this.f17785b) {
            case 0:
                SideSheetBehavior sideSheetBehavior = this.f17786c;
                return Math.max(0, sideSheetBehavior.f5431n + sideSheetBehavior.f5432o);
            default:
                SideSheetBehavior sideSheetBehavior2 = this.f17786c;
                return Math.max(0, (sideSheetBehavior2.m - sideSheetBehavior2.l) - sideSheetBehavior2.f5432o);
        }
    }

    @Override // r2.q
    public final int V() {
        switch (this.f17785b) {
            case 0:
                SideSheetBehavior sideSheetBehavior = this.f17786c;
                return (-sideSheetBehavior.l) - sideSheetBehavior.f5432o;
            default:
                return this.f17786c.m;
        }
    }

    @Override // r2.q
    public final int W() {
        switch (this.f17785b) {
            case 0:
                return this.f17786c.f5432o;
            default:
                return this.f17786c.m;
        }
    }

    @Override // r2.q
    public final int X() {
        switch (this.f17785b) {
            case 0:
                return -this.f17786c.l;
            default:
                return U();
        }
    }

    @Override // r2.q
    public final int Z(View view) {
        switch (this.f17785b) {
            case 0:
                return view.getRight() + this.f17786c.f5432o;
            default:
                return view.getLeft() - this.f17786c.f5432o;
        }
    }

    @Override // r2.q
    public final int a0(CoordinatorLayout coordinatorLayout) {
        switch (this.f17785b) {
            case 0:
                return coordinatorLayout.getLeft();
            default:
                return coordinatorLayout.getRight();
        }
    }

    @Override // r2.q
    public final int b0() {
        switch (this.f17785b) {
            case 0:
                return 1;
            default:
                return 0;
        }
    }

    @Override // r2.q
    public final boolean f0(float f4) {
        switch (this.f17785b) {
            case 0:
                if (f4 > 0.0f) {
                }
                break;
            default:
                if (f4 < 0.0f) {
                }
                break;
        }
        return false;
    }

    @Override // r2.q
    public final boolean g0(View view) {
        switch (this.f17785b) {
            case 0:
                if (view.getRight() < (U() - V()) / 2) {
                }
                break;
            default:
                if (view.getLeft() > (U() + this.f17786c.m) / 2) {
                }
                break;
        }
        return false;
    }

    @Override // r2.q
    public final boolean h0(float f4, float f8) {
        switch (this.f17785b) {
            case 0:
                if (Math.abs(f4) <= Math.abs(f8) || Math.abs(f4) <= 500) {
                }
                break;
            default:
                if (Math.abs(f4) <= Math.abs(f8) || Math.abs(f4) <= 500) {
                }
                break;
        }
        return false;
    }

    @Override // r2.q
    public final int t(ViewGroup.MarginLayoutParams marginLayoutParams) {
        switch (this.f17785b) {
            case 0:
                return marginLayoutParams.leftMargin;
            default:
                return marginLayoutParams.rightMargin;
        }
    }

    @Override // r2.q
    public final float u(int i2) {
        switch (this.f17785b) {
            case 0:
                float fV = V();
                return (i2 - fV) / (U() - fV);
            default:
                float f4 = this.f17786c.m;
                return (f4 - i2) / (f4 - U());
        }
    }

    @Override // r2.q
    public final boolean v0(View view, float f4) {
        switch (this.f17785b) {
            case 0:
                float left = view.getLeft();
                SideSheetBehavior sideSheetBehavior = this.f17786c;
                float fAbs = Math.abs((f4 * sideSheetBehavior.k) + left);
                sideSheetBehavior.getClass();
                if (fAbs > 0.5f) {
                }
                break;
            default:
                float right = view.getRight();
                SideSheetBehavior sideSheetBehavior2 = this.f17786c;
                float fAbs2 = Math.abs((f4 * sideSheetBehavior2.k) + right);
                sideSheetBehavior2.getClass();
                if (fAbs2 > 0.5f) {
                }
                break;
        }
        return false;
    }
}
