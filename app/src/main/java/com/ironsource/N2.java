package com.ironsource;

import com.ironsource.AbstractC2595v0;
import com.ironsource.N0;
import com.ironsource.environment.ContextProvider;
import com.ironsource.mediationsdk.adunit.adapter.utility.AdData;
import com.ironsource.mediationsdk.model.NetworkSettings;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class N2 extends AbstractC2595v0 {

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final a f7262z = new a(null);

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final K2 f7263t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final boolean f7264u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final C2578u0 f7265v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private final V2 f7266w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final String f7267x;
    private final String y;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }

        public final N2 a(K2 adProperties, C2235ab c2235ab, boolean z2) {
            List<C2675zc> listD;
            Me meD;
            kotlin.jvm.internal.k.e(adProperties, "adProperties");
            AbstractC2595v0.a aVar = AbstractC2595v0.f10418r;
            V3 v3C = (c2235ab == null || (meD = c2235ab.d()) == null) ? null : meD.c();
            V2 v2C = v3C != null ? v3C.c() : null;
            if (v2C == null) {
                throw new IllegalStateException("Error getting " + adProperties.a() + " configurations");
            }
            if (c2235ab == null || (listD = c2235ab.d(adProperties.e(), adProperties.c())) == null) {
                listD = r5.r.f13638a;
            }
            String strF = IronSourceUtils.f();
            ArrayList arrayList = new ArrayList(r5.n.L0(listD, 10));
            Iterator<T> it = listD.iterator();
            while (it.hasNext()) {
                arrayList.add(((C2675zc) it.next()).f());
            }
            C2469na c2469naB = C2469na.b();
            kotlin.jvm.internal.k.d(c2469naB, "getInstance()");
            return new N2(adProperties, z2, new C2578u0(strF, arrayList, c2469naB), v2C);
        }

        private a() {
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public N2(K2 adProperties, boolean z2, C2578u0 adUnitCommonData, V2 configs) {
        kotlin.jvm.internal.k.e(adProperties, "adProperties");
        kotlin.jvm.internal.k.e(adUnitCommonData, "adUnitCommonData");
        kotlin.jvm.internal.k.e(configs, "configs");
        String strF = adUnitCommonData.f();
        List<NetworkSettings> listD = adUnitCommonData.d();
        C2469na c2469naE = adUnitCommonData.e();
        C2496p2 c2496p2D = configs.d();
        kotlin.jvm.internal.k.d(c2496p2D, "configs.bannerAuctionSettings");
        super(adProperties, z2, strF, listD, c2469naE, c2496p2D, configs.a(), (int) (configs.b() / ((long) 1000)), configs.c(), configs.f(), -1, new N0(N0.a.MANUAL_WITH_AUTOMATIC_RELOAD, configs.d().j(), configs.d().b(), 1000 * ((long) configs.h())), configs.e(), configs.l(), configs.n(), configs.m(), false, 65536, null);
        this.f7263t = adProperties;
        this.f7264u = z2;
        this.f7265v = adUnitCommonData;
        this.f7266w = configs;
        this.f7267x = "BN";
        this.y = C2253bb.f8067d;
    }

    @Override // com.ironsource.AbstractC2595v0
    /* JADX INFO: renamed from: A, reason: merged with bridge method [inline-methods] */
    public K2 b() {
        return this.f7263t;
    }

    public final C2578u0 B() {
        return this.f7265v;
    }

    public final V2 C() {
        return this.f7266w;
    }

    public final N2 a(K2 adProperties, boolean z2, C2578u0 adUnitCommonData, V2 configs) {
        kotlin.jvm.internal.k.e(adProperties, "adProperties");
        kotlin.jvm.internal.k.e(adUnitCommonData, "adUnitCommonData");
        kotlin.jvm.internal.k.e(configs, "configs");
        return new N2(adProperties, z2, adUnitCommonData, configs);
    }

    @Override // com.ironsource.AbstractC2595v0
    public String c() {
        return this.f7267x;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof N2)) {
            return false;
        }
        N2 n2 = (N2) obj;
        return kotlin.jvm.internal.k.a(this.f7263t, n2.f7263t) && this.f7264u == n2.f7264u && kotlin.jvm.internal.k.a(this.f7265v, n2.f7265v) && kotlin.jvm.internal.k.a(this.f7266w, n2.f7266w);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7 */
    public int hashCode() {
        int iHashCode = this.f7263t.hashCode() * 31;
        boolean z2 = this.f7264u;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        return this.f7266w.hashCode() + ((this.f7265v.hashCode() + ((iHashCode + r1) * 31)) * 31);
    }

    @Override // com.ironsource.AbstractC2595v0
    public String j() {
        return this.y;
    }

    public String toString() {
        return "BannerAdUnitData(adProperties=" + this.f7263t + ", isPublisherLoad=" + this.f7264u + ", adUnitCommonData=" + this.f7265v + ", configs=" + this.f7266w + ")";
    }

    @Override // com.ironsource.AbstractC2595v0
    public boolean u() {
        return this.f7264u;
    }

    public final K2 w() {
        return this.f7263t;
    }

    public final boolean x() {
        return this.f7264u;
    }

    public final C2578u0 y() {
        return this.f7265v;
    }

    public final V2 z() {
        return this.f7266w;
    }

    public static /* synthetic */ N2 a(N2 n2, K2 k22, boolean z2, C2578u0 c2578u0, V2 v2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            k22 = n2.f7263t;
        }
        if ((i2 & 2) != 0) {
            z2 = n2.f7264u;
        }
        if ((i2 & 4) != 0) {
            c2578u0 = n2.f7265v;
        }
        if ((i2 & 8) != 0) {
            v2 = n2.f7266w;
        }
        return n2.a(k22, z2, c2578u0, v2);
    }

    @Override // com.ironsource.AbstractC2595v0
    public JSONObject b(NetworkSettings providerSettings) {
        kotlin.jvm.internal.k.e(providerSettings, "providerSettings");
        JSONObject bannerSettings = providerSettings.getBannerSettings();
        kotlin.jvm.internal.k.d(bannerSettings, "providerSettings.bannerSettings");
        return bannerSettings;
    }

    @Override // com.ironsource.AbstractC2595v0
    public AdData a(NetworkSettings providerSettings) {
        kotlin.jvm.internal.k.e(providerSettings, "providerSettings");
        AdData adDataCreateAdDataForNetworkAdapter = AdData.createAdDataForNetworkAdapter(b(providerSettings), b().a(), r(), new com.ironsource.mediationsdk.q(ContextProvider.getInstance().getApplicationContext(), new C2403k0().b(b().h())));
        kotlin.jvm.internal.k.d(adDataCreateAdDataForNetworkAdapter, "createAdDataForNetworkAd…ze(adProperties.adSize)))");
        return adDataCreateAdDataForNetworkAdapter;
    }
}
