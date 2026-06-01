package com.ironsource;

import com.ironsource.AbstractC2595v0;
import com.ironsource.N0;
import com.ironsource.mediationsdk.model.NetworkSettings;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.ironsource.gc, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class C2344gc extends AbstractC2595v0 {
    public static final a y = new a(null);

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final C2314f0 f8612t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final C2578u0 f8613u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final Rb f8614v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private final String f8615w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final String f8616x;

    /* JADX INFO: renamed from: com.ironsource.gc$a */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }

        public final C2344gc a(C2314f0 adProperties, C2235ab c2235ab) {
            List<C2675zc> listD;
            Me meD;
            kotlin.jvm.internal.k.e(adProperties, "adProperties");
            AbstractC2595v0.a aVar = AbstractC2595v0.f10418r;
            V3 v3C = (c2235ab == null || (meD = c2235ab.d()) == null) ? null : meD.c();
            Rb rbE = v3C != null ? v3C.e() : null;
            if (rbE == null) {
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
            return new C2344gc(adProperties, new C2578u0(strF, arrayList, c2469naB), rbE);
        }

        private a() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2344gc(C2314f0 adProperties, C2578u0 adUnitCommonData, Rb configs) {
        super(adProperties, true, adUnitCommonData.f(), adUnitCommonData.d(), adUnitCommonData.e(), configs.d(), configs.b(), (int) (configs.c() / ((long) 1000)), configs.a(), configs.f(), -1, new N0(N0.a.MANUAL, configs.d().j(), configs.d().b(), -1L), configs.h(), configs.i(), configs.k(), configs.j(), false, 65536, null);
        kotlin.jvm.internal.k.e(adProperties, "adProperties");
        kotlin.jvm.internal.k.e(adUnitCommonData, "adUnitCommonData");
        kotlin.jvm.internal.k.e(configs, "configs");
        this.f8612t = adProperties;
        this.f8613u = adUnitCommonData;
        this.f8614v = configs;
        this.f8615w = "NA";
        this.f8616x = C2253bb.e;
    }

    public final Rb A() {
        return this.f8614v;
    }

    public final C2344gc a(C2314f0 adProperties, C2578u0 adUnitCommonData, Rb configs) {
        kotlin.jvm.internal.k.e(adProperties, "adProperties");
        kotlin.jvm.internal.k.e(adUnitCommonData, "adUnitCommonData");
        kotlin.jvm.internal.k.e(configs, "configs");
        return new C2344gc(adProperties, adUnitCommonData, configs);
    }

    @Override // com.ironsource.AbstractC2595v0
    public C2314f0 b() {
        return this.f8612t;
    }

    @Override // com.ironsource.AbstractC2595v0
    public String c() {
        return this.f8615w;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C2344gc)) {
            return false;
        }
        C2344gc c2344gc = (C2344gc) obj;
        return kotlin.jvm.internal.k.a(this.f8612t, c2344gc.f8612t) && kotlin.jvm.internal.k.a(this.f8613u, c2344gc.f8613u) && kotlin.jvm.internal.k.a(this.f8614v, c2344gc.f8614v);
    }

    public int hashCode() {
        return this.f8614v.hashCode() + ((this.f8613u.hashCode() + (this.f8612t.hashCode() * 31)) * 31);
    }

    @Override // com.ironsource.AbstractC2595v0
    public String j() {
        return this.f8616x;
    }

    public String toString() {
        return "NativeAdUnitData(adProperties=" + this.f8612t + ", adUnitCommonData=" + this.f8613u + ", configs=" + this.f8614v + ")";
    }

    public final C2314f0 w() {
        return this.f8612t;
    }

    public final C2578u0 x() {
        return this.f8613u;
    }

    public final Rb y() {
        return this.f8614v;
    }

    public final C2578u0 z() {
        return this.f8613u;
    }

    public static /* synthetic */ C2344gc a(C2344gc c2344gc, C2314f0 c2314f0, C2578u0 c2578u0, Rb rb, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            c2314f0 = c2344gc.f8612t;
        }
        if ((i2 & 2) != 0) {
            c2578u0 = c2344gc.f8613u;
        }
        if ((i2 & 4) != 0) {
            rb = c2344gc.f8614v;
        }
        return c2344gc.a(c2314f0, c2578u0, rb);
    }

    @Override // com.ironsource.AbstractC2595v0
    public JSONObject b(NetworkSettings providerSettings) {
        kotlin.jvm.internal.k.e(providerSettings, "providerSettings");
        JSONObject nativeAdSettings = providerSettings.getNativeAdSettings();
        kotlin.jvm.internal.k.d(nativeAdSettings, "providerSettings.nativeAdSettings");
        return nativeAdSettings;
    }
}
