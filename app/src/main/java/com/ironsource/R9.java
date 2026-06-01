package com.ironsource;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class R9 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f7553a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f7554b;

    public R9(String advId, String advIdType) {
        kotlin.jvm.internal.k.e(advId, "advId");
        kotlin.jvm.internal.k.e(advIdType, "advIdType");
        this.f7553a = advId;
        this.f7554b = advIdType;
    }

    public final String a() {
        return this.f7553a;
    }

    public final String b() {
        return this.f7554b;
    }

    public final String c() {
        return this.f7553a;
    }

    public final String d() {
        return this.f7554b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof R9)) {
            return false;
        }
        R9 r9 = (R9) obj;
        return kotlin.jvm.internal.k.a(this.f7553a, r9.f7553a) && kotlin.jvm.internal.k.a(this.f7554b, r9.f7554b);
    }

    public int hashCode() {
        return this.f7554b.hashCode() + (this.f7553a.hashCode() * 31);
    }

    public String toString() {
        return a1.a.o("IronSourceAdvId(advId=", this.f7553a, ", advIdType=", this.f7554b, ")");
    }

    public final R9 a(String advId, String advIdType) {
        kotlin.jvm.internal.k.e(advId, "advId");
        kotlin.jvm.internal.k.e(advIdType, "advIdType");
        return new R9(advId, advIdType);
    }

    public static /* synthetic */ R9 a(R9 r9, String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = r9.f7553a;
        }
        if ((i2 & 2) != 0) {
            str2 = r9.f7554b;
        }
        return r9.a(str, str2);
    }
}
