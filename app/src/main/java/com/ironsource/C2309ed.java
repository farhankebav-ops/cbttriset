package com.ironsource;

/* JADX INFO: renamed from: com.ironsource.ed, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class C2309ed {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f8460a;

    public C2309ed(String baseControllerUrl) {
        kotlin.jvm.internal.k.e(baseControllerUrl, "baseControllerUrl");
        this.f8460a = baseControllerUrl;
    }

    public final String a() {
        String str = this.f8460a;
        String strSubstring = str.substring(0, n6.m.C0("/", str, 6));
        kotlin.jvm.internal.k.d(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return strSubstring;
    }
}
