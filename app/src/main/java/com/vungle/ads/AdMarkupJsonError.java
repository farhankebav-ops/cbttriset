package com.vungle.ads;

import com.vungle.ads.internal.protos.Sdk;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class AdMarkupJsonError extends VungleError {
    public AdMarkupJsonError(String str) {
        super(Sdk.SDKError.Reason.INVALID_JSON_BID_PAYLOAD, a1.a.l("Unable to decode payload into BidPayload object. Error: ", str), null);
    }
}
