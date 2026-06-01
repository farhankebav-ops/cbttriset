package com.onesignal.core.internal.http.impl;

import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class OptionalHeaders {
    private final String cacheKey;
    private final Integer retryCount;
    private final String rywToken;
    private final Long sessionDuration;

    public OptionalHeaders() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ OptionalHeaders copy$default(OptionalHeaders optionalHeaders, String str, String str2, Integer num, Long l, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = optionalHeaders.cacheKey;
        }
        if ((i2 & 2) != 0) {
            str2 = optionalHeaders.rywToken;
        }
        if ((i2 & 4) != 0) {
            num = optionalHeaders.retryCount;
        }
        if ((i2 & 8) != 0) {
            l = optionalHeaders.sessionDuration;
        }
        return optionalHeaders.copy(str, str2, num, l);
    }

    public final String component1() {
        return this.cacheKey;
    }

    public final String component2() {
        return this.rywToken;
    }

    public final Integer component3() {
        return this.retryCount;
    }

    public final Long component4() {
        return this.sessionDuration;
    }

    public final OptionalHeaders copy(String str, String str2, Integer num, Long l) {
        return new OptionalHeaders(str, str2, num, l);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OptionalHeaders)) {
            return false;
        }
        OptionalHeaders optionalHeaders = (OptionalHeaders) obj;
        return k.a(this.cacheKey, optionalHeaders.cacheKey) && k.a(this.rywToken, optionalHeaders.rywToken) && k.a(this.retryCount, optionalHeaders.retryCount) && k.a(this.sessionDuration, optionalHeaders.sessionDuration);
    }

    public final String getCacheKey() {
        return this.cacheKey;
    }

    public final Integer getRetryCount() {
        return this.retryCount;
    }

    public final String getRywToken() {
        return this.rywToken;
    }

    public final Long getSessionDuration() {
        return this.sessionDuration;
    }

    public int hashCode() {
        String str = this.cacheKey;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.rywToken;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        Integer num = this.retryCount;
        int iHashCode3 = (iHashCode2 + (num == null ? 0 : num.hashCode())) * 31;
        Long l = this.sessionDuration;
        return iHashCode3 + (l != null ? l.hashCode() : 0);
    }

    public String toString() {
        return "OptionalHeaders(cacheKey=" + this.cacheKey + ", rywToken=" + this.rywToken + ", retryCount=" + this.retryCount + ", sessionDuration=" + this.sessionDuration + ')';
    }

    public OptionalHeaders(String str, String str2, Integer num, Long l) {
        this.cacheKey = str;
        this.rywToken = str2;
        this.retryCount = num;
        this.sessionDuration = l;
    }

    public /* synthetic */ OptionalHeaders(String str, String str2, Integer num, Long l, int i2, f fVar) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : str2, (i2 & 4) != 0 ? null : num, (i2 & 8) != 0 ? null : l);
    }
}
