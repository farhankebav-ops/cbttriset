package com.vungle.ads;

import android.content.Context;
import com.vungle.ads.internal.omsdk.OMTracker;
import kotlin.jvm.internal.l;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class BannerView$special$$inlined$inject$2 extends l implements e6.a {
    final /* synthetic */ Context $context;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BannerView$special$$inlined$inject$2(Context context) {
        super(0);
        this.$context = context;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.vungle.ads.internal.omsdk.OMTracker$Factory, java.lang.Object] */
    @Override // e6.a
    public final OMTracker.Factory invoke() {
        return ServiceLocator.Companion.getInstance(this.$context).getService(OMTracker.Factory.class);
    }
}
