package com.unity3d.ads.core.data.model.exception;

import com.unity3d.ads.core.data.model.OperationType;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class NetworkTimeoutException extends UnityAdsNetworkException {
    public /* synthetic */ NetworkTimeoutException(String str, OperationType operationType, Integer num, String str2, String str3, Integer num2, String str4, int i2, f fVar) {
        this(str, (i2 & 2) != 0 ? OperationType.UNKNOWN : operationType, (i2 & 4) != 0 ? null : num, (i2 & 8) != 0 ? null : str2, (i2 & 16) != 0 ? null : str3, (i2 & 32) != 0 ? null : num2, (i2 & 64) != 0 ? null : str4);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NetworkTimeoutException(String message, OperationType type, Integer num, String str, String str2, Integer num2, String str3) {
        super(message, type, num, str, str2, num2, str3);
        k.e(message, "message");
        k.e(type, "type");
    }
}
