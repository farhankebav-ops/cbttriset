package com.vungle.ads;

import com.vungle.ads.internal.protos.Sdk;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class InvalidAdStateError extends VungleError {
    public /* synthetic */ InvalidAdStateError(Sdk.SDKError.Reason reason, String str, int i2, f fVar) {
        this(reason, (i2 & 2) != 0 ? "Ad state is invalid" : str);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InvalidAdStateError(Sdk.SDKError.Reason loggableReason, String errorMessage) {
        super(loggableReason, errorMessage, null);
        k.e(loggableReason, "loggableReason");
        k.e(errorMessage, "errorMessage");
    }
}
