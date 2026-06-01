package com.ironsource;

/* JADX INFO: renamed from: com.ironsource.l4, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class C2425l4 implements InterfaceC2653y7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f8908a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f8909b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f8910c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final C2309ed f8911d;

    public C2425l4() {
        this(null, null, false, null, 15, null);
    }

    @Override // com.ironsource.InterfaceC2653y7
    public String a() {
        return this.f8908a;
    }

    @Override // com.ironsource.InterfaceC2653y7
    public boolean b() {
        return this.f8910c;
    }

    @Override // com.ironsource.InterfaceC2653y7
    public C2309ed c() {
        return this.f8911d;
    }

    @Override // com.ironsource.InterfaceC2653y7
    public String d() {
        return this.f8909b;
    }

    public C2425l4(String controllerUrl, String cacheFolder, boolean z2, C2309ed rootFolder) {
        kotlin.jvm.internal.k.e(controllerUrl, "controllerUrl");
        kotlin.jvm.internal.k.e(cacheFolder, "cacheFolder");
        kotlin.jvm.internal.k.e(rootFolder, "rootFolder");
        this.f8908a = controllerUrl;
        this.f8909b = cacheFolder;
        this.f8910c = z2;
        this.f8911d = rootFolder;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ C2425l4(String str, String str2, boolean z2, C2309ed c2309ed, int i2, kotlin.jvm.internal.f fVar) {
        str = (i2 & 1) != 0 ? "" : str;
        this(str, (i2 & 2) != 0 ? "" : str2, (i2 & 4) != 0 ? false : z2, (i2 & 8) != 0 ? new C2309ed(str) : c2309ed);
    }
}
