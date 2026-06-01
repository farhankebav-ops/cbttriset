package com.ironsource;

import com.ironsource.L8;

/* JADX INFO: renamed from: com.ironsource.me, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class C2453me implements L8, L8.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private C2435le f8971a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f8972b;

    @Override // com.ironsource.L8
    public C2235ab a() {
        C2435le c2435le = this.f8971a;
        if (c2435le != null) {
            return new C2235ab(c2435le);
        }
        return null;
    }

    @Override // com.ironsource.L8
    public O9 b() {
        C2435le c2435le = this.f8971a;
        if (c2435le != null) {
            return new O9(c2435le);
        }
        return null;
    }

    @Override // com.ironsource.L8
    public boolean c() {
        return this.f8972b;
    }

    @Override // com.ironsource.L8.a
    public void d() {
        this.f8972b = true;
    }

    @Override // com.ironsource.L8.a
    public void a(C2435le sdkConfig) {
        kotlin.jvm.internal.k.e(sdkConfig, "sdkConfig");
        this.f8971a = sdkConfig;
    }
}
