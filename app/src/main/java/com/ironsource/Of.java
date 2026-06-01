package com.ironsource;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class Of {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f7358a;

    public Of() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public final String a() {
        return this.f7358a;
    }

    public final String b() {
        return this.f7358a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof Of) && kotlin.jvm.internal.k.a(this.f7358a, ((Of) obj).f7358a);
    }

    public int hashCode() {
        String str = this.f7358a;
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }

    public String toString() {
        return a1.a.m("TestSuiteSettings(controllerUrl=", this.f7358a, ")");
    }

    public Of(String str) {
        this.f7358a = str;
    }

    public final Of a(String str) {
        return new Of(str);
    }

    public final void b(String str) {
        this.f7358a = str;
    }

    public /* synthetic */ Of(String str, int i2, kotlin.jvm.internal.f fVar) {
        this((i2 & 1) != 0 ? null : str);
    }

    public static /* synthetic */ Of a(Of of, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = of.f7358a;
        }
        return of.a(str);
    }
}
