package com.onesignal.core.internal.http;

import kotlin.jvm.internal.f;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class HttpResponse {
    private final String payload;
    private final Integer retryAfterSeconds;
    private final Integer retryLimit;
    private final int statusCode;
    private final Throwable throwable;

    public HttpResponse(int i2, String str, Throwable th, Integer num, Integer num2) {
        this.statusCode = i2;
        this.payload = str;
        this.throwable = th;
        this.retryAfterSeconds = num;
        this.retryLimit = num2;
    }

    public final String getPayload() {
        return this.payload;
    }

    public final Integer getRetryAfterSeconds() {
        return this.retryAfterSeconds;
    }

    public final Integer getRetryLimit() {
        return this.retryLimit;
    }

    public final int getStatusCode() {
        return this.statusCode;
    }

    public final Throwable getThrowable() {
        return this.throwable;
    }

    public final boolean isSuccess() {
        int i2 = this.statusCode;
        return i2 == 200 || i2 == 202 || i2 == 304 || i2 == 201;
    }

    public /* synthetic */ HttpResponse(int i2, String str, Throwable th, Integer num, Integer num2, int i8, f fVar) {
        this(i2, str, (i8 & 4) != 0 ? null : th, (i8 & 8) != 0 ? null : num, (i8 & 16) != 0 ? null : num2);
    }
}
