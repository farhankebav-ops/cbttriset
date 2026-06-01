package com.ironsource;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class V3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Zd f7717a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final F9 f7718b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final V2 f7719c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Rb f7720d;
    private final A1 e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Of f7721f;
    private final com.ironsource.mediationsdk.adquality.a g;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Zd f7722a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private F9 f7723b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private V2 f7724c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private Rb f7725d;
        private A1 e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private Of f7726f;
        private com.ironsource.mediationsdk.adquality.a g;

        public a() {
            this(null, null, null, null, null, null, null, 127, null);
        }

        public final a a(Zd zd, F9 f9, V2 v2, Rb rb, A1 a12, Of of, com.ironsource.mediationsdk.adquality.a aVar) {
            return new a(zd, f9, v2, rb, a12, of, aVar);
        }

        public final Zd b() {
            return this.f7722a;
        }

        public final F9 c() {
            return this.f7723b;
        }

        public final V2 d() {
            return this.f7724c;
        }

        public final Rb e() {
            return this.f7725d;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return kotlin.jvm.internal.k.a(this.f7722a, aVar.f7722a) && kotlin.jvm.internal.k.a(this.f7723b, aVar.f7723b) && kotlin.jvm.internal.k.a(this.f7724c, aVar.f7724c) && kotlin.jvm.internal.k.a(this.f7725d, aVar.f7725d) && kotlin.jvm.internal.k.a(this.e, aVar.e) && kotlin.jvm.internal.k.a(this.f7726f, aVar.f7726f) && kotlin.jvm.internal.k.a(this.g, aVar.g);
        }

        public final A1 f() {
            return this.e;
        }

        public final Of g() {
            return this.f7726f;
        }

        public final com.ironsource.mediationsdk.adquality.a h() {
            return this.g;
        }

        public int hashCode() {
            Zd zd = this.f7722a;
            int iHashCode = (zd == null ? 0 : zd.hashCode()) * 31;
            F9 f9 = this.f7723b;
            int iHashCode2 = (iHashCode + (f9 == null ? 0 : f9.hashCode())) * 31;
            V2 v2 = this.f7724c;
            int iHashCode3 = (iHashCode2 + (v2 == null ? 0 : v2.hashCode())) * 31;
            Rb rb = this.f7725d;
            int iHashCode4 = (iHashCode3 + (rb == null ? 0 : rb.hashCode())) * 31;
            A1 a12 = this.e;
            int iHashCode5 = (iHashCode4 + (a12 == null ? 0 : a12.hashCode())) * 31;
            Of of = this.f7726f;
            int iHashCode6 = (iHashCode5 + (of == null ? 0 : of.hashCode())) * 31;
            com.ironsource.mediationsdk.adquality.a aVar = this.g;
            return iHashCode6 + (aVar != null ? aVar.hashCode() : 0);
        }

        public final com.ironsource.mediationsdk.adquality.a i() {
            return this.g;
        }

        public final A1 j() {
            return this.e;
        }

        public final V2 k() {
            return this.f7724c;
        }

        public final F9 l() {
            return this.f7723b;
        }

        public final Rb m() {
            return this.f7725d;
        }

        public final Zd n() {
            return this.f7722a;
        }

        public final Of o() {
            return this.f7726f;
        }

        public String toString() {
            return "Builder(rewardedVideoConfigurations=" + this.f7722a + ", interstitialConfigurations=" + this.f7723b + ", bannerConfigurations=" + this.f7724c + ", nativeAdConfigurations=" + this.f7725d + ", applicationConfigurations=" + this.e + ", testSuiteSettings=" + this.f7726f + ", adQualityConfigurations=" + this.g + ")";
        }

        public a(Zd zd, F9 f9, V2 v2, Rb rb, A1 a12, Of of, com.ironsource.mediationsdk.adquality.a aVar) {
            this.f7722a = zd;
            this.f7723b = f9;
            this.f7724c = v2;
            this.f7725d = rb;
            this.e = a12;
            this.f7726f = of;
            this.g = aVar;
        }

        public static /* synthetic */ a a(a aVar, Zd zd, F9 f9, V2 v2, Rb rb, A1 a12, Of of, com.ironsource.mediationsdk.adquality.a aVar2, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                zd = aVar.f7722a;
            }
            if ((i2 & 2) != 0) {
                f9 = aVar.f7723b;
            }
            if ((i2 & 4) != 0) {
                v2 = aVar.f7724c;
            }
            if ((i2 & 8) != 0) {
                rb = aVar.f7725d;
            }
            if ((i2 & 16) != 0) {
                a12 = aVar.e;
            }
            if ((i2 & 32) != 0) {
                of = aVar.f7726f;
            }
            if ((i2 & 64) != 0) {
                aVar2 = aVar.g;
            }
            Of of2 = of;
            com.ironsource.mediationsdk.adquality.a aVar3 = aVar2;
            A1 a13 = a12;
            V2 v22 = v2;
            return aVar.a(zd, f9, v22, rb, a13, of2, aVar3);
        }

        public final void b(Zd zd) {
            this.f7722a = zd;
        }

        public final void a(Of of) {
            this.f7726f = of;
        }

        public final void b(F9 f9) {
            this.f7723b = f9;
        }

        public final a a(Zd zd) {
            this.f7722a = zd;
            return this;
        }

        public final void b(V2 v2) {
            this.f7724c = v2;
        }

        public final a a(F9 f9) {
            this.f7723b = f9;
            return this;
        }

        public final void b(Rb rb) {
            this.f7725d = rb;
        }

        public final a a(V2 v2) {
            this.f7724c = v2;
            return this;
        }

        public final void b(A1 a12) {
            this.e = a12;
        }

        public final a a(Rb rb) {
            this.f7725d = rb;
            return this;
        }

        public final void b(com.ironsource.mediationsdk.adquality.a aVar) {
            this.g = aVar;
        }

        public final a a(A1 a12) {
            this.e = a12;
            return this;
        }

        public final a b(Of of) {
            this.f7726f = of;
            return this;
        }

        public final a a(com.ironsource.mediationsdk.adquality.a aVar) {
            this.g = aVar;
            return this;
        }

        public /* synthetic */ a(Zd zd, F9 f9, V2 v2, Rb rb, A1 a12, Of of, com.ironsource.mediationsdk.adquality.a aVar, int i2, kotlin.jvm.internal.f fVar) {
            this((i2 & 1) != 0 ? null : zd, (i2 & 2) != 0 ? null : f9, (i2 & 4) != 0 ? null : v2, (i2 & 8) != 0 ? null : rb, (i2 & 16) != 0 ? null : a12, (i2 & 32) != 0 ? null : of, (i2 & 64) != 0 ? null : aVar);
        }

        public final V3 a() {
            return new V3(this.f7722a, this.f7723b, this.f7724c, this.f7725d, this.e, this.f7726f, this.g, null);
        }
    }

    public /* synthetic */ V3(Zd zd, F9 f9, V2 v2, Rb rb, A1 a12, Of of, com.ironsource.mediationsdk.adquality.a aVar, kotlin.jvm.internal.f fVar) {
        this(zd, f9, v2, rb, a12, of, aVar);
    }

    public final com.ironsource.mediationsdk.adquality.a a() {
        return this.g;
    }

    public final A1 b() {
        return this.e;
    }

    public final V2 c() {
        return this.f7719c;
    }

    public final F9 d() {
        return this.f7718b;
    }

    public final Rb e() {
        return this.f7720d;
    }

    public final Zd f() {
        return this.f7717a;
    }

    public final Of g() {
        return this.f7721f;
    }

    public String toString() {
        return "configurations(\n" + this.f7717a + "\n" + this.f7718b + "\n" + this.f7719c + "\n" + this.f7720d + ")";
    }

    private V3(Zd zd, F9 f9, V2 v2, Rb rb, A1 a12, Of of, com.ironsource.mediationsdk.adquality.a aVar) {
        this.f7717a = zd;
        this.f7718b = f9;
        this.f7719c = v2;
        this.f7720d = rb;
        this.e = a12;
        this.f7721f = of;
        this.g = aVar;
    }
}
