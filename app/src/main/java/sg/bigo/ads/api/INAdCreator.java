package sg.bigo.ads.api;

import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import sg.bigo.ads.ad.d.e;
import sg.bigo.ads.ad.interstitial.k;
import sg.bigo.ads.ad.interstitial.t;
import sg.bigo.ads.api.core.g;

/* JADX INFO: loaded from: classes6.dex */
@Keep
public class INAdCreator implements k.a<t> {
    @Override // sg.bigo.ads.ad.interstitial.k.a
    public t getAdInstance(@NonNull g gVar) {
        return gVar.f15496a.x() == 20 ? new e(gVar) : new t(gVar);
    }
}
