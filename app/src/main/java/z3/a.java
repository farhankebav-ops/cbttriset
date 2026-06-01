package z3;

import android.content.Context;
import android.support.v4.media.g;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.query.QueryInfo;
import u3.d;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class a extends a.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public x3.a f17979b;

    @Override // a.a
    public final void E(Context context, String str, d dVar, com.unity3d.scar.adapter.common.a aVar, g gVar) {
        AdRequest adRequestBuild = this.f17979b.b().build();
        g gVar2 = new g(26, aVar, gVar);
        d4.a aVar2 = new d4.a(1);
        aVar2.f11048b = str;
        aVar2.f11049c = gVar2;
        QueryInfo.generate(context, b0(dVar), adRequestBuild, aVar2);
    }

    @Override // a.a
    public final void F(Context context, d dVar, com.unity3d.scar.adapter.common.a aVar, g gVar) {
        int iOrdinal = dVar.ordinal();
        E(context, iOrdinal != 1 ? iOrdinal != 2 ? iOrdinal != 3 ? "" : "gmaScarBiddingBannerSignal" : "gmaScarBiddingRewardedSignal" : "gmaScarBiddingInterstitialSignal", dVar, aVar, gVar);
    }

    public final AdFormat b0(d dVar) {
        int iOrdinal = dVar.ordinal();
        return iOrdinal != 1 ? iOrdinal != 2 ? iOrdinal != 3 ? AdFormat.UNKNOWN : AdFormat.BANNER : AdFormat.REWARDED : AdFormat.INTERSTITIAL;
    }
}
