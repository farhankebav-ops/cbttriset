package com.ironsource;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class Tc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f7634a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f7635b;

    public Tc(String url, String str) {
        kotlin.jvm.internal.k.e(url, "url");
        this.f7634a = url;
        this.f7635b = str;
    }

    public final String a() {
        return this.f7634a;
    }

    public final String b() {
        return this.f7635b;
    }

    public final String c() {
        return this.f7635b;
    }

    public final String d() {
        return this.f7634a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Tc)) {
            return false;
        }
        Tc tc = (Tc) obj;
        return kotlin.jvm.internal.k.a(this.f7634a, tc.f7634a) && kotlin.jvm.internal.k.a(this.f7635b, tc.f7635b);
    }

    public int hashCode() {
        int iHashCode = this.f7634a.hashCode() * 31;
        String str = this.f7635b;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return a1.a.o("OpenUrl(url=", this.f7634a, ", packageName=", this.f7635b, ")");
    }

    public /* synthetic */ Tc(String str, String str2, int i2, kotlin.jvm.internal.f fVar) {
        this(str, (i2 & 2) != 0 ? "" : str2);
    }

    public final Tc a(String url, String str) {
        kotlin.jvm.internal.k.e(url, "url");
        return new Tc(url, str);
    }

    public static /* synthetic */ Tc a(Tc tc, String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = tc.f7634a;
        }
        if ((i2 & 2) != 0) {
            str2 = tc.f7635b;
        }
        return tc.a(str, str2);
    }
}
