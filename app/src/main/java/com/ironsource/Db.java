package com.ironsource;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class Db {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final EnumC2468n9 f6618a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f6619b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f6620c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f6621d;
    private final boolean e;

    public Db(EnumC2468n9 instanceType, String adSourceNameForEvents, long j, boolean z2, boolean z7) {
        kotlin.jvm.internal.k.e(instanceType, "instanceType");
        kotlin.jvm.internal.k.e(adSourceNameForEvents, "adSourceNameForEvents");
        this.f6618a = instanceType;
        this.f6619b = adSourceNameForEvents;
        this.f6620c = j;
        this.f6621d = z2;
        this.e = z7;
    }

    public final EnumC2468n9 a() {
        return this.f6618a;
    }

    public final String b() {
        return this.f6619b;
    }

    public final long c() {
        return this.f6620c;
    }

    public final boolean d() {
        return this.f6621d;
    }

    public final boolean e() {
        return this.e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Db)) {
            return false;
        }
        Db db = (Db) obj;
        return this.f6618a == db.f6618a && kotlin.jvm.internal.k.a(this.f6619b, db.f6619b) && this.f6620c == db.f6620c && this.f6621d == db.f6621d && this.e == db.e;
    }

    public final String f() {
        return this.f6619b;
    }

    public final EnumC2468n9 g() {
        return this.f6618a;
    }

    public final long h() {
        return this.f6620c;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v5, types: [int] */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public int hashCode() {
        int iB = androidx.camera.core.processing.util.a.b(this.f6618a.hashCode() * 31, 31, this.f6619b);
        long j = this.f6620c;
        int i2 = (iB + ((int) (j ^ (j >>> 32)))) * 31;
        boolean z2 = this.f6621d;
        ?? r22 = z2;
        if (z2) {
            r22 = 1;
        }
        int i8 = (i2 + r22) * 31;
        boolean z7 = this.e;
        return i8 + (z7 ? 1 : z7);
    }

    public final boolean i() {
        return this.e;
    }

    public final boolean j() {
        return this.f6621d;
    }

    public String toString() {
        return "LoadTaskConfig(instanceType=" + this.f6618a + ", adSourceNameForEvents=" + this.f6619b + ", loadTimeoutInMills=" + this.f6620c + ", isOneFlow=" + this.f6621d + ", isMultipleAdObjects=" + this.e + ")";
    }

    public final Db a(EnumC2468n9 instanceType, String adSourceNameForEvents, long j, boolean z2, boolean z7) {
        kotlin.jvm.internal.k.e(instanceType, "instanceType");
        kotlin.jvm.internal.k.e(adSourceNameForEvents, "adSourceNameForEvents");
        return new Db(instanceType, adSourceNameForEvents, j, z2, z7);
    }

    public static /* synthetic */ Db a(Db db, EnumC2468n9 enumC2468n9, String str, long j, boolean z2, boolean z7, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            enumC2468n9 = db.f6618a;
        }
        if ((i2 & 2) != 0) {
            str = db.f6619b;
        }
        if ((i2 & 4) != 0) {
            j = db.f6620c;
        }
        if ((i2 & 8) != 0) {
            z2 = db.f6621d;
        }
        if ((i2 & 16) != 0) {
            z7 = db.e;
        }
        long j3 = j;
        return db.a(enumC2468n9, str, j3, z2, z7);
    }

    public /* synthetic */ Db(EnumC2468n9 enumC2468n9, String str, long j, boolean z2, boolean z7, int i2, kotlin.jvm.internal.f fVar) {
        this(enumC2468n9, str, j, z2, (i2 & 16) != 0 ? true : z7);
    }
}
