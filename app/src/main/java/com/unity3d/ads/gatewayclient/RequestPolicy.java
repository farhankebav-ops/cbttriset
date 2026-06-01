package com.unity3d.ads.gatewayclient;

import a1.a;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class RequestPolicy {
    private final int connectTimeout;
    private final int maxDuration;
    private final int overallTimeout;
    private final int readTimeout;
    private final float retryJitterPct;
    private final int retryMaxInterval;
    private final float retryScalingFactor;
    private final int retryWaitBase;
    private final boolean shouldStoreLocally;
    private final int writeTimeout;

    public RequestPolicy(int i2, int i8, int i9, float f4, float f8, int i10, int i11, int i12, int i13, boolean z2) {
        this.maxDuration = i2;
        this.retryMaxInterval = i8;
        this.retryWaitBase = i9;
        this.retryJitterPct = f4;
        this.retryScalingFactor = f8;
        this.connectTimeout = i10;
        this.readTimeout = i11;
        this.writeTimeout = i12;
        this.overallTimeout = i13;
        this.shouldStoreLocally = z2;
    }

    public static /* synthetic */ RequestPolicy copy$default(RequestPolicy requestPolicy, int i2, int i8, int i9, float f4, float f8, int i10, int i11, int i12, int i13, boolean z2, int i14, Object obj) {
        if ((i14 & 1) != 0) {
            i2 = requestPolicy.maxDuration;
        }
        if ((i14 & 2) != 0) {
            i8 = requestPolicy.retryMaxInterval;
        }
        if ((i14 & 4) != 0) {
            i9 = requestPolicy.retryWaitBase;
        }
        if ((i14 & 8) != 0) {
            f4 = requestPolicy.retryJitterPct;
        }
        if ((i14 & 16) != 0) {
            f8 = requestPolicy.retryScalingFactor;
        }
        if ((i14 & 32) != 0) {
            i10 = requestPolicy.connectTimeout;
        }
        if ((i14 & 64) != 0) {
            i11 = requestPolicy.readTimeout;
        }
        if ((i14 & 128) != 0) {
            i12 = requestPolicy.writeTimeout;
        }
        if ((i14 & 256) != 0) {
            i13 = requestPolicy.overallTimeout;
        }
        if ((i14 & 512) != 0) {
            z2 = requestPolicy.shouldStoreLocally;
        }
        int i15 = i13;
        boolean z7 = z2;
        int i16 = i11;
        int i17 = i12;
        float f9 = f8;
        int i18 = i10;
        return requestPolicy.copy(i2, i8, i9, f4, f9, i18, i16, i17, i15, z7);
    }

    public final int component1() {
        return this.maxDuration;
    }

    public final boolean component10() {
        return this.shouldStoreLocally;
    }

    public final int component2() {
        return this.retryMaxInterval;
    }

    public final int component3() {
        return this.retryWaitBase;
    }

    public final float component4() {
        return this.retryJitterPct;
    }

    public final float component5() {
        return this.retryScalingFactor;
    }

    public final int component6() {
        return this.connectTimeout;
    }

    public final int component7() {
        return this.readTimeout;
    }

    public final int component8() {
        return this.writeTimeout;
    }

    public final int component9() {
        return this.overallTimeout;
    }

    public final RequestPolicy copy(int i2, int i8, int i9, float f4, float f8, int i10, int i11, int i12, int i13, boolean z2) {
        return new RequestPolicy(i2, i8, i9, f4, f8, i10, i11, i12, i13, z2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RequestPolicy)) {
            return false;
        }
        RequestPolicy requestPolicy = (RequestPolicy) obj;
        return this.maxDuration == requestPolicy.maxDuration && this.retryMaxInterval == requestPolicy.retryMaxInterval && this.retryWaitBase == requestPolicy.retryWaitBase && Float.compare(this.retryJitterPct, requestPolicy.retryJitterPct) == 0 && Float.compare(this.retryScalingFactor, requestPolicy.retryScalingFactor) == 0 && this.connectTimeout == requestPolicy.connectTimeout && this.readTimeout == requestPolicy.readTimeout && this.writeTimeout == requestPolicy.writeTimeout && this.overallTimeout == requestPolicy.overallTimeout && this.shouldStoreLocally == requestPolicy.shouldStoreLocally;
    }

    public final int getConnectTimeout() {
        return this.connectTimeout;
    }

    public final int getMaxDuration() {
        return this.maxDuration;
    }

    public final int getOverallTimeout() {
        return this.overallTimeout;
    }

    public final int getReadTimeout() {
        return this.readTimeout;
    }

    public final float getRetryJitterPct() {
        return this.retryJitterPct;
    }

    public final int getRetryMaxInterval() {
        return this.retryMaxInterval;
    }

    public final float getRetryScalingFactor() {
        return this.retryScalingFactor;
    }

    public final int getRetryWaitBase() {
        return this.retryWaitBase;
    }

    public final boolean getShouldStoreLocally() {
        return this.shouldStoreLocally;
    }

    public final int getWriteTimeout() {
        return this.writeTimeout;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v11, types: [int] */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v13 */
    public int hashCode() {
        int iFloatToIntBits = (((((((((Float.floatToIntBits(this.retryScalingFactor) + ((Float.floatToIntBits(this.retryJitterPct) + (((((this.maxDuration * 31) + this.retryMaxInterval) * 31) + this.retryWaitBase) * 31)) * 31)) * 31) + this.connectTimeout) * 31) + this.readTimeout) * 31) + this.writeTimeout) * 31) + this.overallTimeout) * 31;
        boolean z2 = this.shouldStoreLocally;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        return iFloatToIntBits + r1;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("RequestPolicy(maxDuration=");
        sb.append(this.maxDuration);
        sb.append(", retryMaxInterval=");
        sb.append(this.retryMaxInterval);
        sb.append(", retryWaitBase=");
        sb.append(this.retryWaitBase);
        sb.append(", retryJitterPct=");
        sb.append(this.retryJitterPct);
        sb.append(", retryScalingFactor=");
        sb.append(this.retryScalingFactor);
        sb.append(", connectTimeout=");
        sb.append(this.connectTimeout);
        sb.append(", readTimeout=");
        sb.append(this.readTimeout);
        sb.append(", writeTimeout=");
        sb.append(this.writeTimeout);
        sb.append(", overallTimeout=");
        sb.append(this.overallTimeout);
        sb.append(", shouldStoreLocally=");
        return a.t(sb, this.shouldStoreLocally, ')');
    }
}
