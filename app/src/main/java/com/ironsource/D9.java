package com.ironsource;

import com.ironsource.AbstractC2595v0;
import com.ironsource.N0;
import com.ironsource.mediationsdk.model.NetworkSettings;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class D9 extends AbstractC2595v0 {

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final a f6605z = new a(null);

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final C2314f0 f6606t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final boolean f6607u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final C2578u0 f6608v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private final F9 f6609w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final String f6610x;
    private final String y;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }

        public final D9 a(C2314f0 adProperties, C2235ab c2235ab, boolean z2) {
            List<C2675zc> listD;
            Me meD;
            kotlin.jvm.internal.k.e(adProperties, "adProperties");
            AbstractC2595v0.a aVar = AbstractC2595v0.f10418r;
            V3 v3C = (c2235ab == null || (meD = c2235ab.d()) == null) ? null : meD.c();
            F9 f9D = v3C != null ? v3C.d() : null;
            if (f9D == null) {
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
            return new D9(adProperties, z2, new C2578u0(strF, arrayList, c2469naB), f9D);
        }

        private a() {
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public D9(C2314f0 adProperties, boolean z2, C2578u0 adUnitCommonData, F9 configs) {
        kotlin.jvm.internal.k.e(adProperties, "adProperties");
        kotlin.jvm.internal.k.e(adUnitCommonData, "adUnitCommonData");
        kotlin.jvm.internal.k.e(configs, "configs");
        String strF = adUnitCommonData.f();
        List<NetworkSettings> listD = adUnitCommonData.d();
        C2469na c2469naE = adUnitCommonData.e();
        C2496p2 c2496p2G = configs.g();
        kotlin.jvm.internal.k.d(c2496p2G, "configs.interstitialAuctionSettings");
        super(adProperties, z2, strF, listD, c2469naE, c2496p2G, configs.c(), configs.d(), configs.f(), configs.b(), -1, new N0(N0.a.MANUAL, configs.g().j(), configs.g().b(), -1L), configs.h(), configs.k(), configs.m(), configs.l(), false, 65536, null);
        this.f6606t = adProperties;
        this.f6607u = z2;
        this.f6608v = adUnitCommonData;
        this.f6609w = configs;
        this.f6610x = IronSourceConstants.INTERSTITIAL_EVENT_TYPE;
        this.y = C2253bb.f8066c;
    }

    public final C2578u0 A() {
        return this.f6608v;
    }

    public final F9 B() {
        return this.f6609w;
    }

    public final D9 a(C2314f0 adProperties, boolean z2, C2578u0 adUnitCommonData, F9 configs) {
        kotlin.jvm.internal.k.e(adProperties, "adProperties");
        kotlin.jvm.internal.k.e(adUnitCommonData, "adUnitCommonData");
        kotlin.jvm.internal.k.e(configs, "configs");
        return new D9(adProperties, z2, adUnitCommonData, configs);
    }

    @Override // com.ironsource.AbstractC2595v0
    public C2314f0 b() {
        return this.f6606t;
    }

    @Override // com.ironsource.AbstractC2595v0
    public String c() {
        return this.f6610x;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof D9)) {
            return false;
        }
        D9 d9 = (D9) obj;
        return kotlin.jvm.internal.k.a(this.f6606t, d9.f6606t) && this.f6607u == d9.f6607u && kotlin.jvm.internal.k.a(this.f6608v, d9.f6608v) && kotlin.jvm.internal.k.a(this.f6609w, d9.f6609w);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7 */
    public int hashCode() {
        int iHashCode = this.f6606t.hashCode() * 31;
        boolean z2 = this.f6607u;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        return this.f6609w.hashCode() + ((this.f6608v.hashCode() + ((iHashCode + r1) * 31)) * 31);
    }

    @Override // com.ironsource.AbstractC2595v0
    public String j() {
        return this.y;
    }

    public String toString() {
        return "InterstitialAdUnitData(adProperties=" + this.f6606t + ", isPublisherLoad=" + this.f6607u + ", adUnitCommonData=" + this.f6608v + ", configs=" + this.f6609w + ")";
    }

    @Override // com.ironsource.AbstractC2595v0
    public boolean u() {
        return this.f6607u;
    }

    public final C2314f0 w() {
        return this.f6606t;
    }

    public final boolean x() {
        return this.f6607u;
    }

    public final C2578u0 y() {
        return this.f6608v;
    }

    public final F9 z() {
        return this.f6609w;
    }

    public static /* synthetic */ D9 a(D9 d9, C2314f0 c2314f0, boolean z2, C2578u0 c2578u0, F9 f9, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            c2314f0 = d9.f6606t;
        }
        if ((i2 & 2) != 0) {
            z2 = d9.f6607u;
        }
        if ((i2 & 4) != 0) {
            c2578u0 = d9.f6608v;
        }
        if ((i2 & 8) != 0) {
            f9 = d9.f6609w;
        }
        return d9.a(c2314f0, z2, c2578u0, f9);
    }

    @Override // com.ironsource.AbstractC2595v0
    public JSONObject b(NetworkSettings providerSettings) {
        kotlin.jvm.internal.k.e(providerSettings, "providerSettings");
        JSONObject interstitialSettings = providerSettings.getInterstitialSettings();
        kotlin.jvm.internal.k.d(interstitialSettings, "providerSettings.interstitialSettings");
        return interstitialSettings;
    }
}
