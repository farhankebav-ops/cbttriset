package com.ironsource;

import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.logger.IronSourceLoggerManager;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
class K5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final String f7045a = "ironbeast";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final String f7046b = "outcome";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static final int f7047c = 4;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static final int f7048d = 3;
    static final int e = 2;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static final int f7049f = 0;

    public static AbstractC2295e a(String str, int i2) {
        if (f7045a.equals(str)) {
            return new C2378ia(i2);
        }
        if ("outcome".equals(str)) {
            return new Wc(i2);
        }
        if (i2 == 2) {
            return new C2378ia(i2);
        }
        if (i2 == 3) {
            return new Wc(i2);
        }
        IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.NATIVE, "EventsFormatterFactory failed to instantiate a formatter (type: " + str + ", adUnit: " + i2 + ")", 2);
        return null;
    }
}
