package sg.bigo.ads.ad.interstitial.g;

import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import sg.bigo.ads.R;
import sg.bigo.ads.ad.interstitial.r;
import sg.bigo.ads.api.a.m;
import sg.bigo.ads.common.p;

/* JADX INFO: loaded from: classes6.dex */
public final class b extends a {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    protected TextView f14773s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    protected TextView f14774t;

    public b(@NonNull sg.bigo.ads.ad.b.c cVar, @NonNull m mVar, @NonNull p pVar) {
        super(cVar, mVar, pVar);
    }

    @Override // sg.bigo.ads.ad.interstitial.g.a
    public final void d(@NonNull r rVar) {
        ViewGroup viewGroup = this.k;
        if (viewGroup == null || rVar == null) {
            return;
        }
        this.f14773s = (TextView) viewGroup.findViewById(R.id.inter_title);
        this.f14774t = (TextView) this.k.findViewById(R.id.inter_description);
        sg.bigo.ads.ad.interstitial.d.a(this.f14773s, -234881024);
        sg.bigo.ads.ad.interstitial.d.a(this.f14774t, -234881024);
    }

    @Override // sg.bigo.ads.ad.interstitial.g.a
    public final boolean g() {
        p pVar = ((a) this).h;
        return pVar != null && pVar.f15850c > 960;
    }

    @Override // sg.bigo.ads.ad.interstitial.g.a
    public final int h() {
        return R.layout.bigo_ad_view_click_guide_1;
    }

    @Override // sg.bigo.ads.ad.interstitial.v
    public final boolean d() {
        return false;
    }
}
