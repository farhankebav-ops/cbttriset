package com.vungle.ads;

import com.vungle.ads.internal.protos.Sdk;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class PlacementAdTypeMismatchError extends VungleError {
    public PlacementAdTypeMismatchError(String str) {
        super(Sdk.SDKError.Reason.PLACEMENT_AD_TYPE_MISMATCH, a1.a.C(str, " Ad type does not match with placement type"), null);
    }
}
