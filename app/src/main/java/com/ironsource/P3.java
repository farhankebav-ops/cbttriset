package com.ironsource;

import com.vungle.ads.internal.signals.SignalManager;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public enum P3 {
    Day("d", SignalManager.TWENTY_FOUR_HOURS_MILLIS),
    Hour("h", 3600000),
    Second("s", 1000);


    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f7368c = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f7371a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f7372b;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }

        public final P3 a(String str) {
            for (P3 p3 : P3.values()) {
                if (kotlin.jvm.internal.k.a(p3.f7371a, str)) {
                    return p3;
                }
            }
            return null;
        }

        private a() {
        }
    }

    P3(String str, long j) {
        this.f7371a = str;
        this.f7372b = j;
    }

    public final long a(Integer num) {
        return ((long) (num != null ? num.intValue() : 1)) * this.f7372b;
    }

    public static /* synthetic */ long a(P3 p3, Integer num, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: inMilliseconds");
        }
        if ((i2 & 1) != 0) {
            num = 1;
        }
        return p3.a(num);
    }
}
