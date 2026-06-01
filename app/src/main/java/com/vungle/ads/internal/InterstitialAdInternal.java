package com.vungle.ads.internal;

import android.content.Context;
import com.vungle.ads.internal.model.Placement;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class InterstitialAdInternal extends FullscreenAdInternal {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InterstitialAdInternal(Context context) {
        super(context);
        k.e(context, "context");
    }

    @Override // com.vungle.ads.internal.AdInternal
    public boolean isValidAdTypeForPlacement(Placement placement) {
        k.e(placement, "placement");
        return placement.isInterstitial() || placement.isAppOpen();
    }
}
