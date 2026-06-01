package com.ironsource;

import java.util.Calendar;
import java.util.Map;

/* JADX INFO: renamed from: com.ironsource.f1, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class C2315f1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final EnumC2311ef f8510a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final W7 f8511b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f8512c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f8513d;

    public C2315f1(EnumC2311ef recordType, W7 adProvider, String adInstanceId) {
        kotlin.jvm.internal.k.e(recordType, "recordType");
        kotlin.jvm.internal.k.e(adProvider, "adProvider");
        kotlin.jvm.internal.k.e(adInstanceId, "adInstanceId");
        this.f8510a = recordType;
        this.f8511b = adProvider;
        this.f8512c = adInstanceId;
        this.f8513d = Calendar.getInstance().getTimeInMillis() / ((long) 1000);
    }

    public final String a() {
        return this.f8512c;
    }

    public final W7 b() {
        return this.f8511b;
    }

    public final Map<String, Object> c() {
        return r5.x.f0(new q5.i(C2605va.f10441c, Integer.valueOf(this.f8511b.b())), new q5.i("ts", String.valueOf(this.f8513d)));
    }

    public final Map<String, Object> d() {
        return r5.x.f0(new q5.i(C2605va.f10440b, this.f8512c), new q5.i(C2605va.f10441c, Integer.valueOf(this.f8511b.b())), new q5.i("ts", String.valueOf(this.f8513d)), new q5.i("rt", Integer.valueOf(this.f8510a.ordinal())));
    }

    public final EnumC2311ef e() {
        return this.f8510a;
    }

    public final long f() {
        return this.f8513d;
    }
}
