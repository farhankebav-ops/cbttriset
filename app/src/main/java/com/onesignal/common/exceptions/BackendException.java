package com.onesignal.common.exceptions;

import kotlin.jvm.internal.f;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class BackendException extends Exception {
    private final String response;
    private final Integer retryAfterSeconds;
    private final int statusCode;

    public /* synthetic */ BackendException(int i2, String str, Integer num, int i8, f fVar) {
        this(i2, (i8 & 2) != 0 ? null : str, (i8 & 4) != 0 ? null : num);
    }

    public final String getResponse() {
        return this.response;
    }

    public final Integer getRetryAfterSeconds() {
        return this.retryAfterSeconds;
    }

    public final int getStatusCode() {
        return this.statusCode;
    }

    public BackendException(int i2, String str, Integer num) {
        this.statusCode = i2;
        this.response = str;
        this.retryAfterSeconds = num;
    }
}
