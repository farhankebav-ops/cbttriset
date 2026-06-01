package com.unity3d.ads.core.extensions;

import java.net.URLConnection;
import java.util.Arrays;
import kotlin.jvm.internal.k;
import l7.m;
import n6.a;
import r4.c;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class StringExtensionsKt {
    public static final String getSHA256Hash(String str) {
        k.e(str, "<this>");
        byte[] bytes = str.getBytes(a.f13073a);
        k.d(bytes, "this as java.lang.String).getBytes(charset)");
        byte[] bArrCopyOf = Arrays.copyOf(bytes, bytes.length);
        m mVar = m.f12880d;
        String strE = c.f(bArrCopyOf).c("SHA-256").e();
        k.d(strE, "bytes.sha256().hex()");
        return strE;
    }

    public static final String guessMimeType(String str) {
        k.e(str, "<this>");
        return URLConnection.guessContentTypeFromName(str);
    }
}
