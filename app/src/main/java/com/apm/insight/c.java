package com.apm.insight;

import com.apm.insight.l.g;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static com.apm.insight.b.a f4346a = new com.apm.insight.b.a();

    public static com.apm.insight.b.a a() {
        return f4346a;
    }

    public static void a(Throwable th, String str) {
        if (!e.i().isEnsureEnable() || g.a(th)) {
            return;
        }
        com.apm.insight.f.b.a(th, str, "core_exception_monitor");
    }
}
