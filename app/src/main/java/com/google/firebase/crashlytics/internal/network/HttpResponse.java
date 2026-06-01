package com.google.firebase.crashlytics.internal.network;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public class HttpResponse {
    private final String body;
    private final int code;

    public HttpResponse(int i2, String str) {
        this.code = i2;
        this.body = str;
    }

    public String body() {
        return this.body;
    }

    public int code() {
        return this.code;
    }
}
