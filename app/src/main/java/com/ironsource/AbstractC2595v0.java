package com.ironsource;

import com.ironsource.mediationsdk.adunit.adapter.utility.AdData;
import com.ironsource.mediationsdk.model.NetworkSettings;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.ironsource.v0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class AbstractC2595v0 {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final a f10418r = new a(null);

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final int f10419s = -1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final C2314f0 f10420a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f10421b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f10422c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final List<NetworkSettings> f10423d;
    private final C2469na e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final C2496p2 f10424f;
    private int g;
    private final int h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f10425i;
    private final int j;
    private final int k;
    private final N0 l;
    private final long m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final boolean f10426n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final boolean f10427o;
    private final boolean p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f10428q;

    /* JADX INFO: renamed from: com.ironsource.v0$a */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }

        public final <AdFormatConfig, AdUnitData> AdUnitData a(C2314f0 adProperties, C2235ab c2235ab, e6.l getAdFormatConfig, e6.p createAdUnitData) {
            List<C2675zc> listD;
            Me meD;
            kotlin.jvm.internal.k.e(adProperties, "adProperties");
            kotlin.jvm.internal.k.e(getAdFormatConfig, "getAdFormatConfig");
            kotlin.jvm.internal.k.e(createAdUnitData, "createAdUnitData");
            Object objInvoke = getAdFormatConfig.invoke((c2235ab == null || (meD = c2235ab.d()) == null) ? null : meD.c());
            if (objInvoke == null) {
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
            return (AdUnitData) createAdUnitData.invoke(new C2578u0(strF, arrayList, c2469naB), objInvoke);
        }

        private a() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AbstractC2595v0(C2314f0 adProperties, boolean z2, String str, List<? extends NetworkSettings> providerList, C2469na publisherDataHolder, C2496p2 auctionSettings, int i2, int i8, boolean z7, int i9, int i10, N0 loadingData, long j, boolean z8, boolean z9, boolean z10, boolean z11) {
        kotlin.jvm.internal.k.e(adProperties, "adProperties");
        kotlin.jvm.internal.k.e(providerList, "providerList");
        kotlin.jvm.internal.k.e(publisherDataHolder, "publisherDataHolder");
        kotlin.jvm.internal.k.e(auctionSettings, "auctionSettings");
        kotlin.jvm.internal.k.e(loadingData, "loadingData");
        this.f10420a = adProperties;
        this.f10421b = z2;
        this.f10422c = str;
        this.f10423d = providerList;
        this.e = publisherDataHolder;
        this.f10424f = auctionSettings;
        this.g = i2;
        this.h = i8;
        this.f10425i = z7;
        this.j = i9;
        this.k = i10;
        this.l = loadingData;
        this.m = j;
        this.f10426n = z8;
        this.f10427o = z9;
        this.p = z10;
        this.f10428q = z11;
    }

    public final void a(int i2) {
        this.g = i2;
    }

    public C2314f0 b() {
        return this.f10420a;
    }

    public abstract JSONObject b(NetworkSettings networkSettings);

    public abstract String c();

    public final boolean d() {
        return this.f10425i;
    }

    public final C2496p2 e() {
        return this.f10424f;
    }

    public final long f() {
        return this.m;
    }

    public final int g() {
        return this.j;
    }

    public final int h() {
        return this.h;
    }

    public final N0 i() {
        return this.l;
    }

    public abstract String j();

    public final int k() {
        return this.g;
    }

    public final String l() {
        String strC;
        C2434ld c2434ldF = b().f();
        return (c2434ldF == null || (strC = c2434ldF.c()) == null) ? "" : strC;
    }

    public final List<NetworkSettings> m() {
        return this.f10423d;
    }

    public final boolean n() {
        return this.f10426n;
    }

    public final C2469na o() {
        return this.e;
    }

    public final boolean p() {
        return this.p;
    }

    public final boolean q() {
        return this.f10428q;
    }

    public final String r() {
        return this.f10422c;
    }

    public final boolean s() {
        return this.f10427o;
    }

    public final boolean t() {
        return this.f10424f.g() > 0;
    }

    public boolean u() {
        return this.f10421b;
    }

    public final String v() {
        return String.format(Locale.getDefault(), "%s: %d, %s: %b, %s: %b", com.ironsource.mediationsdk.d.f9048x, Integer.valueOf(this.g), com.ironsource.mediationsdk.d.y, Boolean.valueOf(this.f10425i), com.ironsource.mediationsdk.d.f9049z, Boolean.valueOf(this.f10428q));
    }

    public final void a(boolean z2) {
        this.f10425i = z2;
    }

    public final void b(boolean z2) {
        this.f10428q = z2;
    }

    public final int a() {
        return this.k;
    }

    public final NetworkSettings a(String instanceName) {
        Object next;
        kotlin.jvm.internal.k.e(instanceName, "instanceName");
        Iterator<T> it = this.f10423d.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (((NetworkSettings) next).getProviderInstanceName().equals(instanceName)) {
                break;
            }
        }
        return (NetworkSettings) next;
    }

    public AdData a(NetworkSettings providerSettings) {
        kotlin.jvm.internal.k.e(providerSettings, "providerSettings");
        AdData adDataCreateAdDataForNetworkAdapter = AdData.createAdDataForNetworkAdapter(b(providerSettings), b().a(), this.f10422c);
        kotlin.jvm.internal.k.d(adDataCreateAdDataForNetworkAdapter, "createAdDataForNetworkAd…perties.adFormat, userId)");
        return adDataCreateAdDataForNetworkAdapter;
    }

    public /* synthetic */ AbstractC2595v0(C2314f0 c2314f0, boolean z2, String str, List list, C2469na c2469na, C2496p2 c2496p2, int i2, int i8, boolean z7, int i9, int i10, N0 n02, long j, boolean z8, boolean z9, boolean z10, boolean z11, int i11, kotlin.jvm.internal.f fVar) {
        this(c2314f0, z2, str, list, c2469na, c2496p2, i2, i8, z7, i9, i10, n02, j, z8, z9, z10, (i11 & 65536) != 0 ? false : z11);
    }
}
