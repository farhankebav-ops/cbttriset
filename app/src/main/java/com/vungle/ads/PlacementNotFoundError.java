package com.vungle.ads;

import com.vungle.ads.internal.protos.Sdk;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class PlacementNotFoundError extends VungleError {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PlacementNotFoundError(String placementId) {
        super(Sdk.SDKError.Reason.INVALID_PLACEMENT_ID, a1.a.m("Placement '", placementId, "' is invalid"), null);
        k.e(placementId, "placementId");
    }
}
