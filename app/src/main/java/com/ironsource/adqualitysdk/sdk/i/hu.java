package com.ironsource.adqualitysdk.sdk.i;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class hu {

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private static hu f2395;

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private final hn f2396 = new hn();

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private final hy f2397 = new hy();

    private hu() {
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    public static synchronized hu m2386() {
        try {
            if (f2395 == null) {
                f2395 = new hu();
            }
        } catch (Throwable th) {
            throw th;
        }
        return f2395;
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    public static synchronized void m2387() {
        f2395 = null;
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    public final hy m2388() {
        return this.f2397;
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    public final hn m2389() {
        return this.f2396;
    }
}
