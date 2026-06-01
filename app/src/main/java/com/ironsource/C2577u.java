package com.ironsource;

/* JADX INFO: renamed from: com.ironsource.u, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class C2577u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final EnumC2311ef f10317a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f10318b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f10319c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f10320d;
    private final W7 e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f10321f;

    public C2577u(EnumC2311ef recordType, String advertiserBundleId, String networkInstanceId, String adUnitId, W7 adProvider, String adInstanceId) {
        kotlin.jvm.internal.k.e(recordType, "recordType");
        kotlin.jvm.internal.k.e(advertiserBundleId, "advertiserBundleId");
        kotlin.jvm.internal.k.e(networkInstanceId, "networkInstanceId");
        kotlin.jvm.internal.k.e(adUnitId, "adUnitId");
        kotlin.jvm.internal.k.e(adProvider, "adProvider");
        kotlin.jvm.internal.k.e(adInstanceId, "adInstanceId");
        this.f10317a = recordType;
        this.f10318b = advertiserBundleId;
        this.f10319c = networkInstanceId;
        this.f10320d = adUnitId;
        this.e = adProvider;
        this.f10321f = adInstanceId;
    }

    public final String a() {
        return this.f10321f;
    }

    public final W7 b() {
        return this.e;
    }

    public final String c() {
        return this.f10320d;
    }

    public final String d() {
        return this.f10318b;
    }

    public final String e() {
        return this.f10319c;
    }

    public final EnumC2311ef f() {
        return this.f10317a;
    }

    public final E0 a(Lb<C2577u, E0> mapper) {
        kotlin.jvm.internal.k.e(mapper, "mapper");
        return mapper.a(this);
    }
}
