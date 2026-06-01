package com.vungle.ads;

import android.content.Context;
import com.vungle.ads.internal.ImpressionTracker;
import kotlin.jvm.internal.l;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class VungleBannerView$impressionTracker$2 extends l implements e6.a {
    final /* synthetic */ Context $context;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VungleBannerView$impressionTracker$2(Context context) {
        super(0);
        this.$context = context;
    }

    @Override // e6.a
    public final ImpressionTracker invoke() {
        return new ImpressionTracker(this.$context);
    }
}
