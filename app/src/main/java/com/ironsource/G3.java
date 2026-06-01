package com.ironsource;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class G3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f6788a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f6789b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f6790c;

    public G3(String cachedAppKey, String cachedUserId, String cachedSettings) {
        kotlin.jvm.internal.k.e(cachedAppKey, "cachedAppKey");
        kotlin.jvm.internal.k.e(cachedUserId, "cachedUserId");
        kotlin.jvm.internal.k.e(cachedSettings, "cachedSettings");
        this.f6788a = cachedAppKey;
        this.f6789b = cachedUserId;
        this.f6790c = cachedSettings;
    }

    public final String a() {
        return this.f6788a;
    }

    public final String b() {
        return this.f6789b;
    }

    public final String c() {
        return this.f6790c;
    }

    public final String d() {
        return this.f6788a;
    }

    public final String e() {
        return this.f6790c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof G3)) {
            return false;
        }
        G3 g3 = (G3) obj;
        return kotlin.jvm.internal.k.a(this.f6788a, g3.f6788a) && kotlin.jvm.internal.k.a(this.f6789b, g3.f6789b) && kotlin.jvm.internal.k.a(this.f6790c, g3.f6790c);
    }

    public final String f() {
        return this.f6789b;
    }

    public int hashCode() {
        return this.f6790c.hashCode() + androidx.camera.core.processing.util.a.b(this.f6788a.hashCode() * 31, 31, this.f6789b);
    }

    public String toString() {
        String str = this.f6788a;
        String str2 = this.f6789b;
        return a1.a.r(a1.a.z("CachedResponse(cachedAppKey=", str, ", cachedUserId=", str2, ", cachedSettings="), this.f6790c, ")");
    }

    public final G3 a(String cachedAppKey, String cachedUserId, String cachedSettings) {
        kotlin.jvm.internal.k.e(cachedAppKey, "cachedAppKey");
        kotlin.jvm.internal.k.e(cachedUserId, "cachedUserId");
        kotlin.jvm.internal.k.e(cachedSettings, "cachedSettings");
        return new G3(cachedAppKey, cachedUserId, cachedSettings);
    }

    public final void b(String str) {
        kotlin.jvm.internal.k.e(str, "<set-?>");
        this.f6790c = str;
    }

    public final void c(String str) {
        kotlin.jvm.internal.k.e(str, "<set-?>");
        this.f6789b = str;
    }

    public static /* synthetic */ G3 a(G3 g3, String str, String str2, String str3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = g3.f6788a;
        }
        if ((i2 & 2) != 0) {
            str2 = g3.f6789b;
        }
        if ((i2 & 4) != 0) {
            str3 = g3.f6790c;
        }
        return g3.a(str, str2, str3);
    }

    public final void a(String str) {
        kotlin.jvm.internal.k.e(str, "<set-?>");
        this.f6788a = str;
    }
}
