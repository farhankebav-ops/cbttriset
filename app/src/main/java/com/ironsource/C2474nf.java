package com.ironsource;

import com.ironsource.InterfaceC2568t7;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: renamed from: com.ironsource.nf, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class C2474nf implements InterfaceC2568t7, InterfaceC2568t7.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final InterfaceC2565t4 f9519a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final T8 f9520b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Map<String, C2418kf> f9521c;

    /* JADX INFO: renamed from: com.ironsource.nf$a */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f9522a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private long f9523b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Long f9524c;

        public a(int i2, long j, Long l) {
            this.f9522a = i2;
            this.f9523b = j;
            this.f9524c = l;
        }

        public final int a() {
            return this.f9522a;
        }

        public final long b() {
            return this.f9523b;
        }

        public final Long c() {
            return this.f9524c;
        }

        public final int d() {
            return this.f9522a;
        }

        public final long e() {
            return this.f9523b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.f9522a == aVar.f9522a && this.f9523b == aVar.f9523b && kotlin.jvm.internal.k.a(this.f9524c, aVar.f9524c);
        }

        public final Long f() {
            return this.f9524c;
        }

        public int hashCode() {
            int i2 = this.f9522a * 31;
            long j = this.f9523b;
            int i8 = (i2 + ((int) (j ^ (j >>> 32)))) * 31;
            Long l = this.f9524c;
            return i8 + (l == null ? 0 : l.hashCode());
        }

        public String toString() {
            return "ShowCountCappingInfo(currentNumberOfShows=" + this.f9522a + ", currentTime=" + this.f9523b + ", currentTimeThreshold=" + this.f9524c + ")";
        }

        public final a a(int i2, long j, Long l) {
            return new a(i2, j, l);
        }

        public static /* synthetic */ a a(a aVar, int i2, long j, Long l, int i8, Object obj) {
            if ((i8 & 1) != 0) {
                i2 = aVar.f9522a;
            }
            if ((i8 & 2) != 0) {
                j = aVar.f9523b;
            }
            if ((i8 & 4) != 0) {
                l = aVar.f9524c;
            }
            return aVar.a(i2, j, l);
        }

        public final void a(int i2) {
            this.f9522a = i2;
        }

        public final void a(long j) {
            this.f9523b = j;
        }

        public final void a(Long l) {
            this.f9524c = l;
        }
    }

    public C2474nf(InterfaceC2565t4 currentTimeProvider, T8 serviceDataRepository) {
        kotlin.jvm.internal.k.e(currentTimeProvider, "currentTimeProvider");
        kotlin.jvm.internal.k.e(serviceDataRepository, "serviceDataRepository");
        this.f9519a = currentTimeProvider;
        this.f9520b = serviceDataRepository;
        this.f9521c = new LinkedHashMap();
    }

    private final a c(String str) {
        return new a(this.f9520b.a(str), this.f9519a.a(), this.f9520b.b(str));
    }

    public final Map<String, C2418kf> a() {
        return this.f9521c;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0030  */
    @Override // com.ironsource.InterfaceC2568t7.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void b(java.lang.String r9) {
        /*
            r8 = this;
            java.lang.String r0 = "identifier"
            kotlin.jvm.internal.k.e(r9, r0)
            java.util.Map<java.lang.String, com.ironsource.kf> r0 = r8.f9521c
            java.lang.Object r0 = r0.get(r9)
            com.ironsource.kf r0 = (com.ironsource.C2418kf) r0
            if (r0 != 0) goto L10
            return
        L10:
            com.ironsource.nf$a r1 = r8.c(r9)
            int r2 = r1.d()
            r3 = 1
            if (r2 == 0) goto L30
            long r4 = r1.e()
            java.lang.Long r2 = r1.f()
            if (r2 == 0) goto L2a
            long r6 = r2.longValue()
            goto L2c
        L2a:
            r6 = 0
        L2c:
            int r2 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r2 < 0) goto L47
        L30:
            long r4 = r1.e()
            com.ironsource.P3 r0 = r0.b()
            r2 = 0
            long r6 = com.ironsource.P3.a(r0, r2, r3, r2)
            long r6 = r6 + r4
            com.ironsource.T8 r0 = r8.f9520b
            r0.a(r6, r9)
            r0 = 0
            r1.a(r0)
        L47:
            int r0 = r1.d()
            int r0 = r0 + r3
            r1.a(r0)
            com.ironsource.T8 r0 = r8.f9520b
            int r1 = r1.d()
            r0.a(r1, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.C2474nf.b(java.lang.String):void");
    }

    @Override // com.ironsource.InterfaceC2568t7
    public O3 a(String identifier) {
        kotlin.jvm.internal.k.e(identifier, "identifier");
        C2418kf c2418kf = this.f9521c.get(identifier);
        return c2418kf == null ? new O3(false, null, 2, null) : a(c2418kf, identifier) ? new O3(true, Q3.ShowCount) : new O3(false, null, 2, null);
    }

    private final boolean a(C2418kf c2418kf, String str) {
        a aVarC = c(str);
        Long lF = aVarC.f();
        if (lF != null) {
            long jLongValue = lF.longValue();
            if (aVarC.d() >= c2418kf.a() && this.f9519a.a() < jLongValue) {
                return true;
            }
        }
        return false;
    }

    @Override // com.ironsource.InterfaceC2568t7.a
    public Object a(String identifier, Q3 cappingType, InterfaceC2534r7 cappingConfig) {
        kotlin.jvm.internal.k.e(identifier, "identifier");
        kotlin.jvm.internal.k.e(cappingType, "cappingType");
        kotlin.jvm.internal.k.e(cappingConfig, "cappingConfig");
        Object objC = cappingConfig.c();
        boolean z2 = objC instanceof q5.j;
        q5.x xVar = q5.x.f13520a;
        if (z2) {
            Throwable thA = q5.k.a(objC);
            if (thA != null) {
                return r2.q.M(thA);
            }
        } else {
            C2418kf c2418kf = (C2418kf) objC;
            if (c2418kf != null) {
                this.f9521c.put(identifier, c2418kf);
                return xVar;
            }
        }
        return xVar;
    }
}
