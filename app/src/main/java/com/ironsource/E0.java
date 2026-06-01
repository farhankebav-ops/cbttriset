package com.ironsource;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class E0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final EnumC2311ef f6646a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f6647b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f6648c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final W7 f6649d;
    private final String e;

    public E0(EnumC2311ef recordType, String advertiserBundleId, String networkInstanceId, W7 adProvider, String adInstanceId) {
        kotlin.jvm.internal.k.e(recordType, "recordType");
        kotlin.jvm.internal.k.e(advertiserBundleId, "advertiserBundleId");
        kotlin.jvm.internal.k.e(networkInstanceId, "networkInstanceId");
        kotlin.jvm.internal.k.e(adProvider, "adProvider");
        kotlin.jvm.internal.k.e(adInstanceId, "adInstanceId");
        this.f6646a = recordType;
        this.f6647b = advertiserBundleId;
        this.f6648c = networkInstanceId;
        this.f6649d = adProvider;
        this.e = adInstanceId;
    }

    public final String a() {
        return this.e;
    }

    public final W7 b() {
        return this.f6649d;
    }

    public final String c() {
        return this.f6647b;
    }

    public final String d() {
        return this.f6648c;
    }

    public final EnumC2311ef e() {
        return this.f6646a;
    }

    public final C2556sc a(Lb<E0, C2556sc> mapper) {
        kotlin.jvm.internal.k.e(mapper, "mapper");
        return mapper.a(this);
    }
}
