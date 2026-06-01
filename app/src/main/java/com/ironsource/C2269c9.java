package com.ironsource;

/* JADX INFO: renamed from: com.ironsource.c9, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class C2269c9 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f8124a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f8125b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private V f8126c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f8127d;
    private String e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f8128f;

    public C2269c9(String appKey, String userId) {
        kotlin.jvm.internal.k.e(appKey, "appKey");
        kotlin.jvm.internal.k.e(userId, "userId");
        this.f8124a = appKey;
        this.f8125b = userId;
    }

    public final String a() {
        return this.f8124a;
    }

    public final String b() {
        return this.f8125b;
    }

    public final boolean c() {
        return this.f8127d;
    }

    public final String d() {
        return this.f8124a;
    }

    public final V e() {
        return this.f8126c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C2269c9)) {
            return false;
        }
        C2269c9 c2269c9 = (C2269c9) obj;
        return kotlin.jvm.internal.k.a(this.f8124a, c2269c9.f8124a) && kotlin.jvm.internal.k.a(this.f8125b, c2269c9.f8125b);
    }

    public final String f() {
        return this.f8128f;
    }

    public final String g() {
        return this.e;
    }

    public final String h() {
        return this.f8125b;
    }

    public int hashCode() {
        return this.f8125b.hashCode() + (this.f8124a.hashCode() * 31);
    }

    public String toString() {
        return a1.a.o("InitConfig(appKey=", this.f8124a, ", userId=", this.f8125b, ")");
    }

    public final C2269c9 a(String appKey, String userId) {
        kotlin.jvm.internal.k.e(appKey, "appKey");
        kotlin.jvm.internal.k.e(userId, "userId");
        return new C2269c9(appKey, userId);
    }

    public final void b(String str) {
        this.e = str;
    }

    public static /* synthetic */ C2269c9 a(C2269c9 c2269c9, String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = c2269c9.f8124a;
        }
        if ((i2 & 2) != 0) {
            str2 = c2269c9.f8125b;
        }
        return c2269c9.a(str, str2);
    }

    public final void a(V v2) {
        this.f8126c = v2;
    }

    public final void a(boolean z2) {
        this.f8127d = z2;
    }

    public final void a(String str) {
        this.f8128f = str;
    }

    public final <T> T a(Lb<C2269c9, T> mapper) {
        kotlin.jvm.internal.k.e(mapper, "mapper");
        return mapper.a(this);
    }
}
