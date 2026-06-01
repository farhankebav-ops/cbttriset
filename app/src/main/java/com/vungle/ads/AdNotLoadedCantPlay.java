package com.vungle.ads;

import com.vungle.ads.internal.protos.Sdk;
import kotlin.jvm.internal.f;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class AdNotLoadedCantPlay extends VungleError {
    public AdNotLoadedCantPlay() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public /* synthetic */ AdNotLoadedCantPlay(String str, int i2, f fVar) {
        this((i2 & 1) != 0 ? null : str);
    }

    public AdNotLoadedCantPlay(String str) {
        super(Sdk.SDKError.Reason.AD_NOT_LOADED, a1.a.l("Failed to retrieve the ad object: ", str), null);
    }
}
