package com.ironsource;

/* JADX INFO: renamed from: com.ironsource.sc, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class C2556sc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final EnumC2311ef f9825a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f9826b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final W7 f9827c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f9828d;

    public C2556sc(EnumC2311ef recordType, String advertiserBundleId, W7 adProvider, String adInstanceId) {
        kotlin.jvm.internal.k.e(recordType, "recordType");
        kotlin.jvm.internal.k.e(advertiserBundleId, "advertiserBundleId");
        kotlin.jvm.internal.k.e(adProvider, "adProvider");
        kotlin.jvm.internal.k.e(adInstanceId, "adInstanceId");
        this.f9825a = recordType;
        this.f9826b = advertiserBundleId;
        this.f9827c = adProvider;
        this.f9828d = adInstanceId;
    }

    public final String a() {
        return this.f9828d;
    }

    public final W7 b() {
        return this.f9827c;
    }

    public final String c() {
        return this.f9826b;
    }

    public final EnumC2311ef d() {
        return this.f9825a;
    }

    public final C2315f1 a(Lb<C2556sc, C2315f1> mapper) {
        kotlin.jvm.internal.k.e(mapper, "mapper");
        return mapper.a(this);
    }
}
