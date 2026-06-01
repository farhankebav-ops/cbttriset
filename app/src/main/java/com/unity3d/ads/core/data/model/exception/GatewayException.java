package com.unity3d.ads.core.data.model.exception;

import androidx.camera.core.processing.util.a;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class GatewayException extends UnityAdsNetworkException {
    public static final Companion Companion = new Companion(null);
    public static final String GATEWAY_RESPONSE_DEPTH_INITIALIZATION = "initialization";
    public static final String GATEWAY_RESPONSE_DEPTH_UNIVERSAL = "universal";
    private final String message;
    private final String reason;
    private final String reasonDebug;
    private final Throwable throwable;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        private Companion() {
        }
    }

    public /* synthetic */ GatewayException(String str, Throwable th, String str2, String str3, int i2, f fVar) {
        this(str, (i2 & 2) != 0 ? null : th, (i2 & 4) != 0 ? "gateway" : str2, (i2 & 8) != 0 ? null : str3);
    }

    public static /* synthetic */ GatewayException copy$default(GatewayException gatewayException, String str, Throwable th, String str2, String str3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = gatewayException.getMessage();
        }
        if ((i2 & 2) != 0) {
            th = gatewayException.throwable;
        }
        if ((i2 & 4) != 0) {
            str2 = gatewayException.reason;
        }
        if ((i2 & 8) != 0) {
            str3 = gatewayException.reasonDebug;
        }
        return gatewayException.copy(str, th, str2, str3);
    }

    public final String component1() {
        return getMessage();
    }

    public final Throwable component2() {
        return this.throwable;
    }

    public final String component3() {
        return this.reason;
    }

    public final String component4() {
        return this.reasonDebug;
    }

    public final GatewayException copy(String message, Throwable th, String reason, String str) {
        k.e(message, "message");
        k.e(reason, "reason");
        return new GatewayException(message, th, reason, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GatewayException)) {
            return false;
        }
        GatewayException gatewayException = (GatewayException) obj;
        return k.a(getMessage(), gatewayException.getMessage()) && k.a(this.throwable, gatewayException.throwable) && k.a(this.reason, gatewayException.reason) && k.a(this.reasonDebug, gatewayException.reasonDebug);
    }

    @Override // com.unity3d.ads.core.data.model.exception.UnityAdsNetworkException, java.lang.Throwable
    public String getMessage() {
        return this.message;
    }

    public final String getReason() {
        return this.reason;
    }

    public final String getReasonDebug() {
        return this.reasonDebug;
    }

    public final Throwable getThrowable() {
        return this.throwable;
    }

    public int hashCode() {
        int iHashCode = getMessage().hashCode() * 31;
        Throwable th = this.throwable;
        int iB = a.b((iHashCode + (th == null ? 0 : th.hashCode())) * 31, 31, this.reason);
        String str = this.reasonDebug;
        return iB + (str != null ? str.hashCode() : 0);
    }

    @Override // java.lang.Throwable
    public String toString() {
        StringBuilder sb = new StringBuilder("GatewayException(message=");
        sb.append(getMessage());
        sb.append(", throwable=");
        sb.append(this.throwable);
        sb.append(", reason=");
        sb.append(this.reason);
        sb.append(", reasonDebug=");
        return a1.a.e(')', this.reasonDebug, sb);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GatewayException(String message, Throwable th, String reason, String str) {
        super(message, null, null, null, null, null, null, 126, null);
        k.e(message, "message");
        k.e(reason, "reason");
        this.message = message;
        this.throwable = th;
        this.reason = reason;
        this.reasonDebug = str;
    }
}
