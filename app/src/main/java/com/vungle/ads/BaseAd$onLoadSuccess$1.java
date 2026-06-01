package com.vungle.ads;

import kotlin.jvm.internal.l;
import q5.x;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class BaseAd$onLoadSuccess$1 extends l implements e6.a {
    final /* synthetic */ BaseAd this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseAd$onLoadSuccess$1(BaseAd baseAd) {
        super(0);
        this.this$0 = baseAd;
    }

    @Override // e6.a
    public /* bridge */ /* synthetic */ Object invoke() {
        m3257invoke();
        return x.f13520a;
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m3257invoke() {
        BaseAdListener adListener = this.this$0.getAdListener();
        if (adListener != null) {
            adListener.onAdLoaded(this.this$0);
        }
    }
}
