package com.ironsource.sdk.controller;

import android.webkit.JavascriptInterface;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private s f10065a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f10066b = false;

    public r(s sVar) {
        this.f10065a = sVar;
    }

    @JavascriptInterface
    public String getTokenForMessaging() {
        if (this.f10066b) {
            return "";
        }
        this.f10066b = true;
        return this.f10065a.b();
    }
}
