package com.ironsource;

/* JADX INFO: renamed from: com.ironsource.m9, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class C2448m9 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f8955a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f8956b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f8957c;

    public C2448m9() {
        this(null, 0, null, 7, null);
    }

    public final String a() {
        return this.f8955a;
    }

    public final int b() {
        return this.f8956b;
    }

    public final String c() {
        return this.f8957c;
    }

    public final String d() {
        return this.f8957c;
    }

    public final String e() {
        return this.f8955a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C2448m9)) {
            return false;
        }
        C2448m9 c2448m9 = (C2448m9) obj;
        return kotlin.jvm.internal.k.a(this.f8955a, c2448m9.f8955a) && this.f8956b == c2448m9.f8956b && kotlin.jvm.internal.k.a(this.f8957c, c2448m9.f8957c);
    }

    public final int f() {
        return this.f8956b;
    }

    public int hashCode() {
        int iHashCode = ((this.f8955a.hashCode() * 31) + this.f8956b) * 31;
        String str = this.f8957c;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        String str = this.f8955a;
        int i2 = this.f8956b;
        return a1.a.r(androidx.camera.core.processing.util.a.s("InstanceInformation(instanceId=", i2, str, ", instanceType=", ", dynamicDemandSourceId="), this.f8957c, ")");
    }

    public C2448m9(String instanceId, int i2, String str) {
        kotlin.jvm.internal.k.e(instanceId, "instanceId");
        this.f8955a = instanceId;
        this.f8956b = i2;
        this.f8957c = str;
    }

    public final C2448m9 a(String instanceId, int i2, String str) {
        kotlin.jvm.internal.k.e(instanceId, "instanceId");
        return new C2448m9(instanceId, i2, str);
    }

    public static /* synthetic */ C2448m9 a(C2448m9 c2448m9, String str, int i2, String str2, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            str = c2448m9.f8955a;
        }
        if ((i8 & 2) != 0) {
            i2 = c2448m9.f8956b;
        }
        if ((i8 & 4) != 0) {
            str2 = c2448m9.f8957c;
        }
        return c2448m9.a(str, i2, str2);
    }

    public /* synthetic */ C2448m9(String str, int i2, String str2, int i8, kotlin.jvm.internal.f fVar) {
        this((i8 & 1) != 0 ? "" : str, (i8 & 2) != 0 ? 0 : i2, (i8 & 4) != 0 ? "" : str2);
    }
}
