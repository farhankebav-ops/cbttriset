package sg.bigo.ads.ad.e;

import android.app.Activity;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import sg.bigo.ads.ad.interstitial.AdCountDownButton;
import sg.bigo.ads.ad.interstitial.x;

/* JADX INFO: loaded from: classes6.dex */
public class f extends sg.bigo.ads.ad.interstitial.j.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    protected h f14158c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f14159d;
    private boolean e;

    public f(@NonNull Activity activity) {
        super(activity);
        this.f14159d = true;
        this.e = false;
    }

    @Override // sg.bigo.ads.ad.interstitial.i, sg.bigo.ads.controller.e.b, sg.bigo.ads.api.core.BaseAdActivityImpl
    public final void N() {
        super.N();
        T t3 = this.y;
        if (t3 == 0) {
            return;
        }
        if (t3 instanceof h) {
            this.f14158c = (h) t3;
        }
        if (this.f14158c == null || !ac()) {
            a("Illegal VPAID content.");
        }
    }

    @Override // sg.bigo.ads.ad.interstitial.i, sg.bigo.ads.controller.e.b, sg.bigo.ads.api.core.BaseAdActivityImpl
    public final void W() {
        if (this.f14159d) {
            d(true);
        }
    }

    @Override // sg.bigo.ads.ad.interstitial.r
    public final int Y() {
        return 2;
    }

    @Override // sg.bigo.ads.ad.interstitial.j.a
    public final void a() {
        AdCountDownButton adCountDownButton = this.A;
        if (adCountDownButton != null) {
            adCountDownButton.setShowCloseButtonInCountdown(false);
        }
        super.a();
    }

    @Override // sg.bigo.ads.ad.interstitial.i
    public final void d(boolean z2) {
        if (this.A.getVisibility() == 0) {
            AdCountDownButton adCountDownButton = this.A;
            if (adCountDownButton.f14166c) {
                if (!this.e) {
                    adCountDownButton.d();
                    h hVar = this.f14158c;
                    if (hVar != null) {
                        this.e = true;
                        hVar.H();
                    }
                }
                super.d(true);
            }
        }
    }

    @Override // sg.bigo.ads.ad.interstitial.j.a, sg.bigo.ads.ad.interstitial.r, sg.bigo.ads.ad.interstitial.i
    public final void m() {
        super.m();
        x xVar = ((sg.bigo.ads.ad.interstitial.j.a) this).f14813a;
        if (xVar != null) {
            xVar.f15196c = 15;
            xVar.f15198f = true;
            xVar.g = false;
        }
    }
}
