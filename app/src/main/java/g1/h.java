package g1;

import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.sidesheet.SideSheetBehavior;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f11571a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f11572b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f11573c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Runnable f11574d;
    public final /* synthetic */ CoordinatorLayout.Behavior e;

    public h(SideSheetBehavior sideSheetBehavior) {
        this.f11571a = 1;
        this.e = sideSheetBehavior;
        this.f11574d = new com.vungle.ads.internal.omsdk.a(this, 13);
    }

    public final void a(int i2) {
        switch (this.f11571a) {
            case 0:
                BottomSheetBehavior bottomSheetBehavior = (BottomSheetBehavior) this.e;
                WeakReference weakReference = bottomSheetBehavior.W;
                if (weakReference != null && weakReference.get() != null) {
                    this.f11572b = i2;
                    if (!this.f11573c) {
                        ((View) bottomSheetBehavior.W.get()).postOnAnimation((a4.c) this.f11574d);
                        this.f11573c = true;
                    }
                    break;
                }
                break;
            default:
                SideSheetBehavior sideSheetBehavior = (SideSheetBehavior) this.e;
                WeakReference weakReference2 = sideSheetBehavior.p;
                if (weakReference2 != null && weakReference2.get() != null) {
                    this.f11572b = i2;
                    if (!this.f11573c) {
                        ((View) sideSheetBehavior.p.get()).postOnAnimation((com.vungle.ads.internal.omsdk.a) this.f11574d);
                        this.f11573c = true;
                    }
                    break;
                }
                break;
        }
    }

    public h(BottomSheetBehavior bottomSheetBehavior) {
        this.f11571a = 0;
        this.e = bottomSheetBehavior;
        this.f11574d = new a4.c(this, 1);
    }
}
