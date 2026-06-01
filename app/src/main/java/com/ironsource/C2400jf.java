package com.ironsource;

/* JADX INFO: renamed from: com.ironsource.jf, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class C2400jf {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f8807a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f8808b;

    public C2400jf(String identifier, String baseConst) {
        kotlin.jvm.internal.k.e(identifier, "identifier");
        kotlin.jvm.internal.k.e(baseConst, "baseConst");
        this.f8807a = identifier;
        this.f8808b = baseConst;
    }

    public final String a() {
        return a1.a.D(this.f8807a, "_", this.f8808b);
    }
}
