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
public final class Td extends AbstractC2595v0 {

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final a f7636z = new a(null);

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final C2314f0 f7637t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final boolean f7638u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final C2578u0 f7639v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private final Zd f7640w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final String f7641x;
    private final String y;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }

        public final Td a(C2314f0 adProperties, C2235ab c2235ab, boolean z2) {
            List<C2675zc> listD;
            Me meD;
            kotlin.jvm.internal.k.e(adProperties, "adProperties");
            AbstractC2595v0.a aVar = AbstractC2595v0.f10418r;
            V3 v3C = (c2235ab == null || (meD = c2235ab.d()) == null) ? null : meD.c();
            Zd zdF = v3C != null ? v3C.f() : null;
            if (zdF == null) {
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
            return new Td(adProperties, z2, new C2578u0(strF, arrayList, c2469naB), zdF);
        }

        private a() {
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public Td(C2314f0 adProperties, boolean z2, C2578u0 adUnitCommonData, Zd configs) {
        kotlin.jvm.internal.k.e(adProperties, "adProperties");
        kotlin.jvm.internal.k.e(adUnitCommonData, "adUnitCommonData");
        kotlin.jvm.internal.k.e(configs, "configs");
        String strF = adUnitCommonData.f();
        List<NetworkSettings> listD = adUnitCommonData.d();
        C2469na c2469naE = adUnitCommonData.e();
        C2496p2 c2496p2K = configs.k();
        kotlin.jvm.internal.k.d(c2496p2K, "configs.rewardedVideoAuctionSettings");
        super(adProperties, z2, strF, listD, c2469naE, c2496p2K, configs.g(), configs.h(), configs.j(), configs.b(), configs.c(), new N0(N0.a.MANUAL, configs.k().j(), configs.k().b(), -1L), configs.l(), configs.f(), configs.o(), configs.n(), false, 65536, null);
        this.f7637t = adProperties;
        this.f7638u = z2;
        this.f7639v = adUnitCommonData;
        this.f7640w = configs;
        this.f7641x = IronSourceConstants.REWARDED_VIDEO_EVENT_TYPE;
        this.y = C2253bb.f8065b;
    }

    public final C2578u0 A() {
        return this.f7639v;
    }

    public final Zd B() {
        return this.f7640w;
    }

    public final Td a(C2314f0 adProperties, boolean z2, C2578u0 adUnitCommonData, Zd configs) {
        kotlin.jvm.internal.k.e(adProperties, "adProperties");
        kotlin.jvm.internal.k.e(adUnitCommonData, "adUnitCommonData");
        kotlin.jvm.internal.k.e(configs, "configs");
        return new Td(adProperties, z2, adUnitCommonData, configs);
    }

    @Override // com.ironsource.AbstractC2595v0
    public C2314f0 b() {
        return this.f7637t;
    }

    @Override // com.ironsource.AbstractC2595v0
    public String c() {
        return this.f7641x;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Td)) {
            return false;
        }
        Td td = (Td) obj;
        return kotlin.jvm.internal.k.a(this.f7637t, td.f7637t) && this.f7638u == td.f7638u && kotlin.jvm.internal.k.a(this.f7639v, td.f7639v) && kotlin.jvm.internal.k.a(this.f7640w, td.f7640w);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7 */
    public int hashCode() {
        int iHashCode = this.f7637t.hashCode() * 31;
        boolean z2 = this.f7638u;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        return this.f7640w.hashCode() + ((this.f7639v.hashCode() + ((iHashCode + r1) * 31)) * 31);
    }

    @Override // com.ironsource.AbstractC2595v0
    public String j() {
        return this.y;
    }

    public String toString() {
        return "RewardedAdUnitData(adProperties=" + this.f7637t + ", isPublisherLoad=" + this.f7638u + ", adUnitCommonData=" + this.f7639v + ", configs=" + this.f7640w + ")";
    }

    @Override // com.ironsource.AbstractC2595v0
    public boolean u() {
        return this.f7638u;
    }

    public final C2314f0 w() {
        return this.f7637t;
    }

    public final boolean x() {
        return this.f7638u;
    }

    public final C2578u0 y() {
        return this.f7639v;
    }

    public final Zd z() {
        return this.f7640w;
    }

    public static /* synthetic */ Td a(Td td, C2314f0 c2314f0, boolean z2, C2578u0 c2578u0, Zd zd, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            c2314f0 = td.f7637t;
        }
        if ((i2 & 2) != 0) {
            z2 = td.f7638u;
        }
        if ((i2 & 4) != 0) {
            c2578u0 = td.f7639v;
        }
        if ((i2 & 8) != 0) {
            zd = td.f7640w;
        }
        return td.a(c2314f0, z2, c2578u0, zd);
    }

    @Override // com.ironsource.AbstractC2595v0
    public JSONObject b(NetworkSettings providerSettings) {
        kotlin.jvm.internal.k.e(providerSettings, "providerSettings");
        JSONObject rewardedVideoSettings = providerSettings.getRewardedVideoSettings();
        kotlin.jvm.internal.k.d(rewardedVideoSettings, "providerSettings.rewardedVideoSettings");
        return rewardedVideoSettings;
    }
}
