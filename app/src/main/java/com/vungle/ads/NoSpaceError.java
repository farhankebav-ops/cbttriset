package com.vungle.ads;

import com.vungle.ads.internal.protos.Sdk;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class NoSpaceError extends VungleError {
    public NoSpaceError() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public /* synthetic */ NoSpaceError(String str, int i2, f fVar) {
        this((i2 & 1) != 0 ? "No space left on device" : str);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NoSpaceError(String msg) {
        super(Sdk.SDKError.Reason.ASSET_FAILED_INSUFFICIENT_SPACE, msg, null);
        k.e(msg, "msg");
    }
}
