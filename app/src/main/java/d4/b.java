package d4;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.media.g;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.query.QueryInfo;
import u3.d;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class b extends a.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b4.a f11050b;

    @Override // a.a
    public final void E(Context context, String str, d dVar, com.unity3d.scar.adapter.common.a aVar, g gVar) {
        AdRequest.Builder requestAgent = new AdRequest.Builder().setRequestAgent(this.f11050b.f4145a.f11230b);
        Bundle bundle = new Bundle();
        bundle.putString("query_info_type", "requester_type_5");
        AdRequest adRequestBuild = requestAgent.addNetworkExtrasBundle(AdMobAdapter.class, bundle).build();
        g gVar2 = new g(26, aVar, gVar);
        a aVar2 = new a(0);
        aVar2.f11048b = str;
        aVar2.f11049c = gVar2;
        int iOrdinal = dVar.ordinal();
        QueryInfo.generate(context, iOrdinal != 2 ? iOrdinal != 3 ? AdFormat.INTERSTITIAL : AdFormat.BANNER : AdFormat.REWARDED, adRequestBuild, aVar2);
    }

    @Override // a.a
    public final void F(Context context, d dVar, com.unity3d.scar.adapter.common.a aVar, g gVar) {
        int iOrdinal = dVar.ordinal();
        E(context, iOrdinal != 1 ? iOrdinal != 2 ? iOrdinal != 3 ? "" : "gmaScarBiddingBannerSignal" : "gmaScarBiddingRewardedSignal" : "gmaScarBiddingInterstitialSignal", dVar, aVar, gVar);
    }
}
