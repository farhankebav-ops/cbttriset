package sg.bigo.ads.ad.interstitial.c;

import android.view.ViewGroup;
import androidx.annotation.NonNull;
import sg.bigo.ads.ad.d.f;
import sg.bigo.ads.ad.interstitial.AdCountDownButton;

/* JADX INFO: loaded from: classes6.dex */
public class y extends w {
    public y(@NonNull sg.bigo.ads.ad.b.c cVar, sg.bigo.ads.api.a.m mVar) {
        super(cVar, mVar);
    }

    @Override // sg.bigo.ads.ad.interstitial.c.w, sg.bigo.ads.ad.d.f
    public final void a(AdCountDownButton adCountDownButton, ViewGroup viewGroup, f.a aVar) {
        if (viewGroup == null) {
            return;
        }
        if (this.f14128o == null) {
            this.f14128o = new sg.bigo.ads.ad.d.d();
        }
        this.f14128o.a();
        this.f14128o.a(viewGroup, m(), aVar);
    }
}
