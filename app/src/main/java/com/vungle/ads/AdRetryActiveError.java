package com.vungle.ads;

import com.vungle.ads.internal.protos.Sdk;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class AdRetryActiveError extends VungleError {
    public AdRetryActiveError() {
        super(Sdk.SDKError.Reason.AD_LOAD_FAIL_RETRY_AFTER, "Ads: Server Retry Error active", null);
    }
}
