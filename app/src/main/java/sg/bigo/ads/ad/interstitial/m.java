package sg.bigo.ads.ad.interstitial;

import android.app.Activity;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.annotation.CallSuper;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import sg.bigo.ads.R;
import sg.bigo.ads.ad.interstitial.AdCountDownButton;

/* JADX INFO: loaded from: classes6.dex */
public class m extends i<o> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public sg.bigo.ads.common.utils.n f14832a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private RelativeLayout f14833b;

    public m(@NonNull Activity activity) {
        super(activity);
    }

    @Override // sg.bigo.ads.ad.interstitial.i, sg.bigo.ads.api.core.BaseAdActivityImpl
    public void D() {
        super.D();
        RelativeLayout relativeLayout = this.f14833b;
        if (relativeLayout != null) {
            relativeLayout.removeAllViews();
        }
        sg.bigo.ads.common.utils.n nVar = this.f14832a;
        if (nVar != null) {
            nVar.b();
            this.f14832a = null;
        }
    }

    @Override // sg.bigo.ads.ad.interstitial.i
    public int R() {
        return R.layout.bigo_ad_activity_interstitial_banner;
    }

    @Override // sg.bigo.ads.ad.interstitial.i
    public final boolean S() {
        return false;
    }

    public void a() {
        n nVarC;
        T t3 = this.y;
        if (t3 == 0 || (nVarC = ((o) t3).C()) == null) {
            return;
        }
        int iMax = Math.max(nVarC.f14928b, 0);
        this.A.setTakeoverTickEvent(true);
        this.A.a(iMax, (AdCountDownButton.b) null);
        sg.bigo.ads.common.utils.n nVar = new sg.bigo.ads.common.utils.n(sg.bigo.ads.common.utils.r.f16034a.a(Math.max(nVarC.e, 0))) { // from class: sg.bigo.ads.ad.interstitial.m.2
            @Override // sg.bigo.ads.common.utils.n
            public final void a() {
                AdCountDownButton adCountDownButton = m.this.A;
                if (adCountDownButton != null) {
                    adCountDownButton.d();
                    m.this.A.setTakeoverTickEvent(false);
                }
            }

            @Override // sg.bigo.ads.common.utils.n
            public final void a(long j) {
                AdCountDownButton adCountDownButton = m.this.A;
                if (adCountDownButton != null) {
                    adCountDownButton.a(j);
                }
            }
        };
        this.f14832a = nVar;
        nVar.c();
    }

    @Override // sg.bigo.ads.ad.interstitial.i
    public final boolean f() {
        return false;
    }

    @Override // sg.bigo.ads.ad.interstitial.i
    public void g(@LayoutRes int i2) {
        T t3 = this.y;
        if (t3 == 0) {
            a("Illegal InterstitialAd.");
            return;
        }
        ((o) t3).A = new sg.bigo.ads.ad.banner.h() { // from class: sg.bigo.ads.ad.interstitial.m.1
            @Override // sg.bigo.ads.ad.banner.h
            public final void a() {
                m.this.d(true);
            }

            @Override // sg.bigo.ads.ad.banner.h
            public final void a(String str) {
            }

            @Override // sg.bigo.ads.ad.banner.h
            public final void a(sg.bigo.ads.common.i iVar, sg.bigo.ads.api.core.e eVar) {
            }

            @Override // sg.bigo.ads.ad.banner.h
            public final void b() {
            }
        };
        this.f14833b = (RelativeLayout) this.f14800z.findViewById(R.id.inter_banner_container);
        ((o) this.y).a(this.A, o(R.id.click_proxy));
        o oVar = (o) this.y;
        if (!sg.bigo.ads.common.n.d.b()) {
            sg.bigo.ads.common.utils.t.a("adView() must run on UI thread");
        }
        View viewC = oVar.f14931z.c();
        oVar.a(viewC, false);
        if (viewC != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(13);
            sg.bigo.ads.common.utils.u.a(viewC, this.f14833b, layoutParams, 0);
        }
        a();
    }

    @Override // sg.bigo.ads.ad.interstitial.i
    @CallSuper
    public final void h() {
        super.h();
        sg.bigo.ads.common.utils.n nVar = this.f14832a;
        if (nVar == null || !nVar.e()) {
            return;
        }
        this.f14832a.c();
    }

    @Override // sg.bigo.ads.ad.interstitial.i
    @CallSuper
    public final void j() {
        super.j();
        sg.bigo.ads.common.utils.n nVar = this.f14832a;
        if (nVar != null) {
            nVar.d();
        }
    }

    @Override // sg.bigo.ads.ad.interstitial.i
    public final void m() {
    }
}
