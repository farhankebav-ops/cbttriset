package com.ironsource;

/* JADX INFO: renamed from: com.ironsource.ng, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class C2475ng implements InterfaceC2248b6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final C2309ed f9525a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f9526b;

    public C2475ng(C2309ed folderRootUrl, String version) {
        kotlin.jvm.internal.k.e(folderRootUrl, "folderRootUrl");
        kotlin.jvm.internal.k.e(version, "version");
        this.f9525a = folderRootUrl;
        this.f9526b = version;
    }

    public final String a() {
        return this.f9526b;
    }

    @Override // com.ironsource.InterfaceC2248b6
    public String value() {
        return androidx.camera.core.processing.util.a.l(this.f9525a.a(), "/versions/", this.f9526b, "/mobileController.html");
    }
}
