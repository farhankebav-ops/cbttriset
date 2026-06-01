package g1;

import android.view.View;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f11556a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f11557b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ BottomSheetBehavior f11558c;

    public a(BottomSheetBehavior bottomSheetBehavior, View view, int i2) {
        this.f11558c = bottomSheetBehavior;
        this.f11556a = view;
        this.f11557b = i2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f11558c.n(this.f11556a, this.f11557b, false);
    }
}
