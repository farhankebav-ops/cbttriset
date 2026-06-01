package com.ironsource;

import com.ironsource.AbstractC2388j3;
import com.ironsource.mediationsdk.logger.IronLog;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class Za {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Za f7916a = new Za();

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f7917a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f7918b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final long f7919c;

        public a(boolean z2, long j, long j3) {
            this.f7917a = z2;
            this.f7918b = j;
            this.f7919c = j3;
        }

        public final boolean a() {
            return this.f7917a;
        }

        public final long b() {
            return this.f7918b;
        }

        public final long c() {
            return this.f7919c;
        }

        public final long d() {
            return this.f7918b;
        }

        public final long e() {
            return this.f7919c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.f7917a == aVar.f7917a && this.f7918b == aVar.f7918b && this.f7919c == aVar.f7919c;
        }

        public final boolean f() {
            return this.f7917a;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v6 */
        /* JADX WARN: Type inference failed for: r0v7 */
        public int hashCode() {
            boolean z2 = this.f7917a;
            ?? r02 = z2;
            if (z2) {
                r02 = 1;
            }
            long j = this.f7918b;
            int i2 = ((r02 * 31) + ((int) (j ^ (j >>> 32)))) * 31;
            long j3 = this.f7919c;
            return i2 + ((int) (j3 ^ (j3 >>> 32)));
        }

        public String toString() {
            return "BannerStrategyConfig(isAutoRefreshEnabled=" + this.f7917a + ", refreshInterval=" + this.f7918b + ", visibilityCheckerInterval=" + this.f7919c + ")";
        }

        public final a a(boolean z2, long j, long j3) {
            return new a(z2, j, j3);
        }

        public static /* synthetic */ a a(a aVar, boolean z2, long j, long j3, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                z2 = aVar.f7917a;
            }
            if ((i2 & 2) != 0) {
                j = aVar.f7918b;
            }
            if ((i2 & 4) != 0) {
                j3 = aVar.f7919c;
            }
            return aVar.a(z2, j, j3);
        }
    }

    private Za() {
    }

    public final Ba a(C2459n0 adTools, X2 bannerContainer, a config, K2 bannerAdProperties, Ca strategyListener, O2 bannerAdUnitFactory, InterfaceC2565t4 timeProvider) {
        kotlin.jvm.internal.k.e(adTools, "adTools");
        kotlin.jvm.internal.k.e(bannerContainer, "bannerContainer");
        kotlin.jvm.internal.k.e(config, "config");
        kotlin.jvm.internal.k.e(bannerAdProperties, "bannerAdProperties");
        kotlin.jvm.internal.k.e(strategyListener, "strategyListener");
        kotlin.jvm.internal.k.e(bannerAdUnitFactory, "bannerAdUnitFactory");
        kotlin.jvm.internal.k.e(timeProvider, "timeProvider");
        boolean zC = Mb.f7131s.d().g().c();
        IronLog.INTERNAL.verbose("Creating banner strategy - useLegacyStrategy: " + zC + ", isAutoRefreshEnabled: " + config.f() + ", refreshInterval: " + config.d());
        if (zC) {
            return a(adTools, bannerContainer, config, bannerAdProperties, strategyListener, bannerAdUnitFactory, config.f() && config.d() > 0);
        }
        if (config.f()) {
            return new Ga(adTools, bannerContainer, config.d(), config.e(), bannerAdProperties, strategyListener, bannerAdUnitFactory, null, timeProvider, 128, null);
        }
        Sa sa = new Sa(adTools, bannerContainer, bannerAdUnitFactory);
        sa.a(strategyListener);
        return sa;
    }

    private final Ba a(C2459n0 c2459n0, X2 x2, a aVar, K2 k22, Ca ca, O2 o2, boolean z2) {
        return new Ea(new Uf(c2459n0, x2, new AbstractC2388j3.b(aVar.d(), z2), k22, new Ya(ca), o2), ca);
    }
}
