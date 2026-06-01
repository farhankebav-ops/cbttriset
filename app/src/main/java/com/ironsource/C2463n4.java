package com.ironsource;

/* JADX INFO: renamed from: com.ironsource.n4, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class C2463n4 implements InterfaceC2408k5<C8> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final InterfaceC2248b6 f9485a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f9486b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final C7 f9487c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final e6.l f9488d;
    private C8 e;

    public C2463n4(InterfaceC2248b6 fileUrl, String destinationPath, C7 downloadManager, e6.l onFinish) {
        kotlin.jvm.internal.k.e(fileUrl, "fileUrl");
        kotlin.jvm.internal.k.e(destinationPath, "destinationPath");
        kotlin.jvm.internal.k.e(downloadManager, "downloadManager");
        kotlin.jvm.internal.k.e(onFinish, "onFinish");
        this.f9485a = fileUrl;
        this.f9486b = destinationPath;
        this.f9487c = downloadManager;
        this.f9488d = onFinish;
        this.e = new C8(c());
    }

    @Override // com.ironsource.Pc
    public void a(C8 file) {
        kotlin.jvm.internal.k.e(file, "file");
        i().invoke(new q5.k(file));
    }

    @Override // com.ironsource.InterfaceC2408k5
    public void b(C8 c8) {
        kotlin.jvm.internal.k.e(c8, "<set-?>");
        this.e = c8;
    }

    @Override // com.ironsource.InterfaceC2408k5
    public String c() {
        return this.f9486b;
    }

    @Override // com.ironsource.InterfaceC2408k5
    public InterfaceC2248b6 d() {
        return this.f9485a;
    }

    @Override // com.ironsource.InterfaceC2408k5
    public e6.l i() {
        return this.f9488d;
    }

    @Override // com.ironsource.InterfaceC2408k5
    public final /* synthetic */ boolean j() {
        return ji.a(this);
    }

    @Override // com.ironsource.InterfaceC2408k5
    public C8 k() {
        return this.e;
    }

    @Override // com.ironsource.InterfaceC2408k5
    public C7 l() {
        return this.f9487c;
    }

    @Override // com.ironsource.InterfaceC2408k5
    public final /* synthetic */ void m() {
        ji.b(this);
    }

    @Override // com.ironsource.Pc
    public void a(C8 c8, C2586u8 error) {
        kotlin.jvm.internal.k.e(error, "error");
        i().invoke(new q5.k(r2.q.M(new Exception(a1.a.l("Unable to download mobileController.html: ", error.b())))));
    }
}
