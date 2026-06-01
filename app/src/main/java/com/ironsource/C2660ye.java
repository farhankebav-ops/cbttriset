package com.ironsource;

/* JADX INFO: renamed from: com.ironsource.ye, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class C2660ye {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final C2473ne f10581a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final C2592ue f10582b;

    public C2660ye(C2473ne error) {
        kotlin.jvm.internal.k.e(error, "error");
        this.f10581a = error;
        this.f10582b = null;
    }

    public final C2473ne a() {
        return this.f10581a;
    }

    public final C2592ue b() {
        return this.f10582b;
    }

    public final boolean c() {
        C2592ue c2592ue;
        if (this.f10581a == null && (c2592ue = this.f10582b) != null) {
            return c2592ue.c().p();
        }
        return false;
    }

    public C2660ye(C2592ue sdkInitResponse) {
        kotlin.jvm.internal.k.e(sdkInitResponse, "sdkInitResponse");
        this.f10582b = sdkInitResponse;
        this.f10581a = null;
    }
}
