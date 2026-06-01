package com.vungle.ads.internal;

import com.vungle.ads.BaseAdListener;
import kotlin.jvm.internal.l;
import q5.x;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class BannerAdImpl$adPlayCallback$1$onAdClick$1 extends l implements e6.a {
    final /* synthetic */ BannerAdImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BannerAdImpl$adPlayCallback$1$onAdClick$1(BannerAdImpl bannerAdImpl) {
        super(0);
        this.this$0 = bannerAdImpl;
    }

    @Override // e6.a
    public /* bridge */ /* synthetic */ Object invoke() {
        m3286invoke();
        return x.f13520a;
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m3286invoke() {
        BaseAdListener adListener = this.this$0.getAdListener();
        if (adListener != null) {
            adListener.onAdClicked(this.this$0);
        }
    }
}
