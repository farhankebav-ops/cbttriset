package com.ironsource;

/* JADX INFO: renamed from: com.ironsource.d, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class C2277d implements InterfaceC2248b6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final C2309ed f8170a;

    public C2277d(C2309ed folderRootUrl) {
        kotlin.jvm.internal.k.e(folderRootUrl, "folderRootUrl");
        this.f8170a = folderRootUrl;
    }

    @Override // com.ironsource.InterfaceC2248b6
    public String value() {
        return a1.a.C(this.f8170a.a(), "/abTestMap.json");
    }
}
