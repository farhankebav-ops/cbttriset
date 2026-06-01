package com.vungle.ads;

import com.vungle.ads.internal.protos.Sdk;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class AdRetryError extends VungleError {
    public AdRetryError() {
        super(Sdk.SDKError.Reason.AD_RESPONSE_RETRY_AFTER, "Ads retry-after: Server is busy", null);
    }
}
