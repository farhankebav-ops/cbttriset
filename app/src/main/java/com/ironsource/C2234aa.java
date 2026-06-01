package com.ironsource;

import com.ironsource.mediationsdk.logger.IronLog;

/* JADX INFO: renamed from: com.ironsource.aa, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class C2234aa {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C2234aa f7982a = new C2234aa();

    private C2234aa() {
    }

    public static final <T> T a(T t3, T t7) {
        return t3 == null ? t7 : t3;
    }

    public static final boolean a(Object obj) {
        return a(obj, null, false, 6, null);
    }

    public static final boolean a(Object obj, String errorMessage) {
        kotlin.jvm.internal.k.e(errorMessage, "errorMessage");
        return a(obj, errorMessage, false, 4, null);
    }

    public static /* synthetic */ boolean a(Object obj, String str, boolean z2, int i2, Object obj2) {
        if ((i2 & 2) != 0) {
            str = "reference is null";
        }
        if ((i2 & 4) != 0) {
            z2 = false;
        }
        return a(obj, str, z2);
    }

    public static final boolean a(Object obj, String errorMessage, boolean z2) {
        kotlin.jvm.internal.k.e(errorMessage, "errorMessage");
        if (obj != null) {
            return true;
        }
        if (z2) {
            throw new NullPointerException(errorMessage);
        }
        if (!z2) {
            IronLog.API.error(errorMessage);
            return false;
        }
        throw new e2.s(3);
    }
}
