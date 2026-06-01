package sg.bigo.ads.ad.d;

import android.app.Activity;
import android.view.ViewGroup;
import androidx.annotation.CallSuper;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import sg.bigo.ads.R;
import sg.bigo.ads.ad.d.f;
import sg.bigo.ads.ad.interstitial.d.w;
import sg.bigo.ads.ad.interstitial.q;
import sg.bigo.ads.ad.interstitial.y;
import sg.bigo.ads.api.MediaView;
import sg.bigo.ads.common.utils.n;

/* JADX INFO: loaded from: classes6.dex */
public class g extends y implements f.a {
    private w H;

    public g(@NonNull Activity activity) {
        super(activity);
        activity.overridePendingTransition(0, 0);
    }

    private w ae() {
        if (this.H == null) {
            this.H = sg.bigo.ads.ad.interstitial.d.a.a(this.C, ((sg.bigo.ads.ad.interstitial.a) this).f14181c, n());
        }
        return this.H;
    }

    @Override // sg.bigo.ads.ad.interstitial.i
    public final boolean O() {
        return true;
    }

    @Override // sg.bigo.ads.ad.interstitial.y, sg.bigo.ads.ad.interstitial.i
    public final int R() {
        int iN = n();
        return iN != 2 ? iN != 3 ? iN != 4 ? iN != 5 ? iN != 6 ? R.layout.bigo_ad_activity_pop_up_style_1 : R.layout.bigo_ad_activity_pop_up_style_6 : R.layout.bigo_ad_activity_pop_up_style_5 : R.layout.bigo_ad_activity_pop_up_style_4 : R.layout.bigo_ad_activity_pop_up_style_3 : R.layout.bigo_ad_activity_pop_up_style_2;
    }

    @Override // sg.bigo.ads.ad.interstitial.i, sg.bigo.ads.controller.e.b, sg.bigo.ads.api.core.BaseAdActivityImpl
    @CallSuper
    public final void X() {
        super.X();
        this.I.overridePendingTransition(0, 0);
    }

    @Override // sg.bigo.ads.ad.interstitial.a
    public final void a(@NonNull ViewGroup viewGroup) {
        ae().c(viewGroup);
    }

    @Override // sg.bigo.ads.ad.interstitial.y
    public final void ad() {
        MediaView mediaView;
        ViewGroup viewGroup = this.D;
        if (viewGroup == null || (mediaView = (MediaView) viewGroup.findViewById(R.id.inter_media)) == null) {
            return;
        }
        if (!((y) this).G) {
            mediaView.setMediaAreaClickable(false);
        }
        ae().a((ViewGroup) mediaView);
    }

    @Override // sg.bigo.ads.ad.d.f.a
    public final void d_() {
        e(true);
    }

    @Override // sg.bigo.ads.ad.interstitial.y, sg.bigo.ads.ad.interstitial.a
    public final boolean f(boolean z2) {
        b(true);
        return true;
    }

    @Override // sg.bigo.ads.ad.interstitial.y, sg.bigo.ads.ad.interstitial.a, sg.bigo.ads.ad.interstitial.r, sg.bigo.ads.ad.interstitial.i
    public final void g(@LayoutRes int i2) {
        super.g(i2);
        if (this.D == null) {
            return;
        }
        q qVar = this.f14188r;
        if (qVar != null) {
            qVar.b();
        }
        ae().g(this.D);
        ae().h(this.D);
        ae().d(this.D);
        ae().a(o(R.id.inter_container), this.D.findViewById(R.id.media_layout));
    }

    @Override // sg.bigo.ads.ad.interstitial.y, sg.bigo.ads.ad.interstitial.a, sg.bigo.ads.ad.interstitial.r, sg.bigo.ads.ad.interstitial.i
    public final void h() {
        super.h();
        if (this.A == null) {
            ae().q();
        }
    }

    @Override // sg.bigo.ads.ad.interstitial.y, sg.bigo.ads.ad.interstitial.a, sg.bigo.ads.ad.interstitial.r, sg.bigo.ads.ad.interstitial.i
    public final void j() {
        super.j();
        if (this.A == null) {
            ae().p();
        }
    }

    @Override // sg.bigo.ads.ad.interstitial.y
    public final void k(int i2) {
        ae();
        w.a(this.D, this.l);
        n nVarE = ae().e(this.D);
        this.f14191u = nVarE;
        if (nVarE == null) {
            ae().f(this.D);
        } else {
            nVarE.c();
        }
    }

    @Override // sg.bigo.ads.ad.interstitial.a
    public final void p() {
        ae().a(this.A, this.D, this);
    }

    @Override // sg.bigo.ads.ad.interstitial.a
    public final void a(boolean z2) {
    }

    @Override // sg.bigo.ads.ad.interstitial.a
    public final void u() {
    }
}
