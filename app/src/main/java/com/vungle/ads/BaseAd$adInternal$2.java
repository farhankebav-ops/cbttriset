package com.vungle.ads;

import com.vungle.ads.internal.AdInternal;
import kotlin.jvm.internal.l;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class BaseAd$adInternal$2 extends l implements e6.a {
    final /* synthetic */ BaseAd this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseAd$adInternal$2(BaseAd baseAd) {
        super(0);
        this.this$0 = baseAd;
    }

    @Override // e6.a
    public final AdInternal invoke() {
        BaseAd baseAd = this.this$0;
        AdInternal adInternalConstructAdInternal$vungle_ads_release = baseAd.constructAdInternal$vungle_ads_release(baseAd.getContext());
        adInternalConstructAdInternal$vungle_ads_release.setLogEntry$vungle_ads_release(this.this$0.getLogEntry$vungle_ads_release());
        return adInternalConstructAdInternal$vungle_ads_release;
    }
}
