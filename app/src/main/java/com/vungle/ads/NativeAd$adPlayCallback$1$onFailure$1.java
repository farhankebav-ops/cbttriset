package com.vungle.ads;

import kotlin.jvm.internal.l;
import q5.x;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class NativeAd$adPlayCallback$1$onFailure$1 extends l implements e6.a {
    final /* synthetic */ VungleError $error;
    final /* synthetic */ NativeAd this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NativeAd$adPlayCallback$1$onFailure$1(NativeAd nativeAd, VungleError vungleError) {
        super(0);
        this.this$0 = nativeAd;
        this.$error = vungleError;
    }

    @Override // e6.a
    public /* bridge */ /* synthetic */ Object invoke() {
        m3273invoke();
        return x.f13520a;
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m3273invoke() {
        BaseAdListener adListener = this.this$0.getAdListener();
        if (adListener != null) {
            adListener.onAdFailedToPlay(this.this$0, this.$error);
        }
    }
}
