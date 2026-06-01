package com.vungle.ads;

import com.vungle.ads.internal.protos.Sdk;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class HeartbeatMissingError extends VungleError {
    public HeartbeatMissingError() {
        super(Sdk.SDKError.Reason.AD_CLOSED_MISSING_HEARTBEAT, "Ad closed without receiving heartbeat", null);
    }
}
