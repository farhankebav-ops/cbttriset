package com.apm.insight.runtime;

import com.apm.insight.MonitorCrash;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static MonitorCrash f4642a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static int f4643b = -1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static int f4644c;

    public static MonitorCrash a() {
        if (f4642a == null) {
            MonitorCrash monitorCrashInitSDK = MonitorCrash.initSDK(com.apm.insight.e.g(), "239017", 20079L, "2007-20250613121539", "com.apm.insight");
            f4642a = monitorCrashInitSDK;
            monitorCrashInitSDK.config().setChannel("release");
        }
        return f4642a;
    }

    public static void a(Throwable th, String str) {
        if (com.apm.insight.e.g() == null) {
            return;
        }
        if (f4643b == -1) {
            f4643b = 5;
        }
        int i2 = f4644c;
        if (i2 < f4643b) {
            f4644c = i2 + 1;
            a().reportCustomErr(str, "INNER", th);
        }
    }
}
