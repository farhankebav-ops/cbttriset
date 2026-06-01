package com.ironsource;

import com.ironsource.sdk.utils.IronSourceStorageUtils;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.ironsource.c, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class C2259c implements InterfaceC2408k5<JSONObject> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final InterfaceC2248b6 f8098a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f8099b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final C7 f8100c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final e6.l f8101d;
    private C8 e;

    public C2259c(InterfaceC2248b6 fileUrl, String destinationPath, C7 downloadManager, e6.l onFinish) {
        kotlin.jvm.internal.k.e(fileUrl, "fileUrl");
        kotlin.jvm.internal.k.e(destinationPath, "destinationPath");
        kotlin.jvm.internal.k.e(downloadManager, "downloadManager");
        kotlin.jvm.internal.k.e(onFinish, "onFinish");
        this.f8098a = fileUrl;
        this.f8099b = destinationPath;
        this.f8100c = downloadManager;
        this.f8101d = onFinish;
        this.e = new C8(c(), C2300e4.h);
    }

    @Override // com.ironsource.Pc
    public void a(C8 file) {
        kotlin.jvm.internal.k.e(file, "file");
        if (kotlin.jvm.internal.k.a(file.getName(), C2300e4.h)) {
            try {
                i().invoke(new q5.k(c(file)));
            } catch (Exception e) {
                C2531r4.d().a(e);
                i().invoke(new q5.k(r2.q.M(e)));
            }
        }
    }

    @Override // com.ironsource.InterfaceC2408k5
    public void b(C8 c8) {
        kotlin.jvm.internal.k.e(c8, "<set-?>");
        this.e = c8;
    }

    @Override // com.ironsource.InterfaceC2408k5
    public String c() {
        return this.f8099b;
    }

    @Override // com.ironsource.InterfaceC2408k5
    public InterfaceC2248b6 d() {
        return this.f8098a;
    }

    @Override // com.ironsource.InterfaceC2408k5
    public e6.l i() {
        return this.f8101d;
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
        return this.f8100c;
    }

    @Override // com.ironsource.InterfaceC2408k5
    public final /* synthetic */ void m() {
        ji.b(this);
    }

    private final JSONObject c(C8 c8) {
        return new JSONObject(IronSourceStorageUtils.readFile(c8));
    }

    @Override // com.ironsource.Pc
    public void a(C8 c8, C2586u8 error) {
        kotlin.jvm.internal.k.e(error, "error");
        i().invoke(new q5.k(r2.q.M(new Exception(a1.a.l("Unable to download abTestMap.json: ", error.b())))));
    }
}
