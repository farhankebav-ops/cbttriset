package com.ironsource;

import android.webkit.JavascriptInterface;

/* JADX INFO: renamed from: com.ironsource.m8, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class C2447m8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private C2502p8 f8954a;

    public C2447m8(C2502p8 c2502p8) {
        this.f8954a = c2502p8;
    }

    @JavascriptInterface
    public void receiveMessageFromExternal(String str) {
        this.f8954a.handleMessageFromAd(str);
    }
}
