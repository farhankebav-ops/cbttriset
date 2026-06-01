package com.unity3d.ads.core.data.model;

import androidx.camera.core.processing.util.a;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class AdDataRefreshToken {
    private final String data;

    private /* synthetic */ AdDataRefreshToken(String str) {
        this.data = str;
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ AdDataRefreshToken m3192boximpl(String str) {
        return new AdDataRefreshToken(str);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static String m3193constructorimpl(String data) {
        k.e(data, "data");
        return data;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m3194equalsimpl(String str, Object obj) {
        return (obj instanceof AdDataRefreshToken) && k.a(str, ((AdDataRefreshToken) obj).m3198unboximpl());
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m3195equalsimpl0(String str, String str2) {
        return k.a(str, str2);
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m3196hashCodeimpl(String str) {
        return str.hashCode();
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m3197toStringimpl(String str) {
        return a.f(')', "AdDataRefreshToken(data=", str);
    }

    public boolean equals(Object obj) {
        return m3194equalsimpl(this.data, obj);
    }

    public final String getData() {
        return this.data;
    }

    public int hashCode() {
        return m3196hashCodeimpl(this.data);
    }

    public String toString() {
        return m3197toStringimpl(this.data);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ String m3198unboximpl() {
        return this.data;
    }
}
