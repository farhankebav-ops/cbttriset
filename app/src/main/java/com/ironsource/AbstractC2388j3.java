package com.ironsource;

/* JADX INFO: renamed from: com.ironsource.j3, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class AbstractC2388j3 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f8761c = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final b f8762a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final K2 f8763b;

    /* JADX INFO: renamed from: com.ironsource.j3$a */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }

        public final AbstractC2388j3 a(C2459n0 adTools, X2 bannerContainer, b config, K2 bannerAdProperties, InterfaceC2424l3 bannerStrategyListener, O2 createBannerAdUnitFactory) {
            kotlin.jvm.internal.k.e(adTools, "adTools");
            kotlin.jvm.internal.k.e(bannerContainer, "bannerContainer");
            kotlin.jvm.internal.k.e(config, "config");
            kotlin.jvm.internal.k.e(bannerAdProperties, "bannerAdProperties");
            kotlin.jvm.internal.k.e(bannerStrategyListener, "bannerStrategyListener");
            kotlin.jvm.internal.k.e(createBannerAdUnitFactory, "createBannerAdUnitFactory");
            return new Uf(adTools, bannerContainer, config, bannerAdProperties, bannerStrategyListener, createBannerAdUnitFactory);
        }

        private a() {
        }
    }

    /* JADX INFO: renamed from: com.ironsource.j3$b */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f8764a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f8765b;

        public b(long j, boolean z2) {
            this.f8764a = j;
            this.f8765b = z2;
        }

        public final long a() {
            return this.f8764a;
        }

        public final boolean b() {
            return this.f8765b;
        }

        public final long c() {
            return this.f8764a;
        }

        public final boolean d() {
            return this.f8765b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return this.f8764a == bVar.f8764a && this.f8765b == bVar.f8765b;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v1, types: [int] */
        /* JADX WARN: Type inference failed for: r1v2 */
        /* JADX WARN: Type inference failed for: r1v3 */
        public int hashCode() {
            long j = this.f8764a;
            int i2 = ((int) (j ^ (j >>> 32))) * 31;
            boolean z2 = this.f8765b;
            ?? r1 = z2;
            if (z2) {
                r1 = 1;
            }
            return i2 + r1;
        }

        public String toString() {
            return "Config(refreshInterval=" + this.f8764a + ", isAutoRefreshEnabled=" + this.f8765b + ")";
        }

        public final b a(long j, boolean z2) {
            return new b(j, z2);
        }

        public static /* synthetic */ b a(b bVar, long j, boolean z2, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                j = bVar.f8764a;
            }
            if ((i2 & 2) != 0) {
                z2 = bVar.f8765b;
            }
            return bVar.a(j, z2);
        }
    }

    public AbstractC2388j3(b config, K2 bannerAdProperties) {
        kotlin.jvm.internal.k.e(config, "config");
        kotlin.jvm.internal.k.e(bannerAdProperties, "bannerAdProperties");
        this.f8762a = config;
        this.f8763b = bannerAdProperties;
    }

    public abstract void b();

    public abstract void c();

    public abstract void d();

    public abstract void e();

    public final long g() {
        Long lJ = this.f8763b.j();
        return lJ != null ? lJ.longValue() : this.f8762a.c();
    }

    public final boolean h() {
        Boolean boolI = this.f8763b.i();
        return boolI != null ? boolI.booleanValue() : this.f8762a.d();
    }
}
