package com.ironsource;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class Y1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Y1 f7804a = new Y1();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f7805b = "trials_fail";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f7806c = "parsing";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f7807d = "other";
    public static final String e = "disabled";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f7808f = "-1";

    private Y1() {
    }

    public final String a(boolean z2) {
        return !z2 ? f7808f : androidx.camera.core.processing.util.a.j("fallback_", System.currentTimeMillis());
    }

    public static /* synthetic */ String a(Y1 y12, boolean z2, Integer num, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            num = null;
        }
        return y12.a(z2, num);
    }

    public final String a(boolean z2, Integer num) {
        if (z2) {
            return (num != null && num.intValue() == 1003) ? f7806c : (num != null && num.intValue() == 1008) ? f7806c : (num != null && num.intValue() == 1002) ? f7806c : (num != null && num.intValue() == 1006) ? f7805b : (num != null && num.intValue() == 1001) ? f7805b : f7807d;
        }
        return e;
    }
}
