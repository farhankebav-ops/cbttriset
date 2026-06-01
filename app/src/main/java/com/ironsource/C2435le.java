package com.ironsource;

import com.ironsource.Me;

/* JADX INFO: renamed from: com.ironsource.le, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class C2435le {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final C2592ue f8921a;

    public C2435le(C2592ue sdkInitResponse) {
        kotlin.jvm.internal.k.e(sdkInitResponse, "sdkInitResponse");
        this.f8921a = sdkInitResponse;
    }

    public final K1 a() {
        return this.f8921a.a().b().c();
    }

    public final D1 b() {
        return this.f8921a.a().b().b();
    }

    public final Q5 c() {
        return this.f8921a.b();
    }

    public final Me d() {
        return this.f8921a.c();
    }

    public final Hb e() {
        return this.f8921a.a().b().e();
    }

    public final Me.a f() {
        Me.a aVarH = this.f8921a.c().h();
        kotlin.jvm.internal.k.d(aVarH, "sdkInitResponse.fullResponse.origin");
        return aVarH;
    }

    public final C2592ue g() {
        return this.f8921a;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public C2435le(C2435le sdkConfig) {
        this(sdkConfig.f8921a);
        kotlin.jvm.internal.k.e(sdkConfig, "sdkConfig");
    }
}
