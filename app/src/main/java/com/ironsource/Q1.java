package com.ironsource;

import com.ironsource.C3;
import com.ironsource.Q1;
import com.ironsource.mediationsdk.adunit.adapter.internal.AdapterBaseInterface;
import com.ironsource.mediationsdk.adunit.adapter.internal.BaseAdAdapter;
import com.ironsource.mediationsdk.adunit.adapter.utility.AdData;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.logger.IronSourceLoggerManager;
import com.ironsource.mediationsdk.model.NetworkSettings;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class Q1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final V0 f7402a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AbstractC2595v0 f7403b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Map<String, G> f7404c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final C2316f2 f7405d;
    private final List<CallableC2666z3> e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f7406f;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class a extends AbstractRunnableC2382ie {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ C3 f7407b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Q1 f7408c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ C3.b f7409d;

        public a(C3 c32, Q1 q12, C3.b bVar) {
            this.f7407b = c32;
            this.f7408c = q12;
            this.f7409d = bVar;
        }

        @Override // com.ironsource.AbstractRunnableC2382ie
        public void a() {
            this.f7407b.a(this.f7408c.e(), this.f7409d, this.f7408c.f7403b.f(), TimeUnit.MILLISECONDS);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class c implements C3.b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ d f7412b;

        public c(d dVar) {
            this.f7412b = dVar;
        }

        @Override // com.ironsource.C3.b
        public void a(final List<? extends D3> biddingDataList, final long j, final List<String> reachedTimeout) {
            kotlin.jvm.internal.k.e(biddingDataList, "biddingDataList");
            kotlin.jvm.internal.k.e(reachedTimeout, "reachedTimeout");
            V0 v02 = Q1.this.f7402a;
            final Q1 q12 = Q1.this;
            final d dVar = this.f7412b;
            v02.a(new Runnable() { // from class: com.ironsource.ph
                @Override // java.lang.Runnable
                public final void run() {
                    Q1.c.a(q12, j, biddingDataList, reachedTimeout, dVar);
                }
            });
        }

        @Override // com.ironsource.C3.b
        public void onFailure(String error) {
            kotlin.jvm.internal.k.e(error, "error");
            Q1.this.f7402a.a(new androidx.camera.core.processing.c(Q1.this, error, this.f7412b, 13));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void a(Q1 this$0, long j, List biddingDataList, List reachedTimeout, d biddingDataListener) {
            kotlin.jvm.internal.k.e(this$0, "this$0");
            kotlin.jvm.internal.k.e(biddingDataList, "$biddingDataList");
            kotlin.jvm.internal.k.e(reachedTimeout, "$reachedTimeout");
            kotlin.jvm.internal.k.e(biddingDataListener, "$biddingDataListener");
            this$0.a(j, biddingDataList, reachedTimeout, biddingDataListener);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void a(Q1 this$0, String error, d biddingDataListener) {
            kotlin.jvm.internal.k.e(this$0, "this$0");
            kotlin.jvm.internal.k.e(error, "$error");
            kotlin.jvm.internal.k.e(biddingDataListener, "$biddingDataListener");
            this$0.f7402a.e().g().a(error);
            biddingDataListener.a(this$0, error);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface d {
        void a(Q1 q12);

        void a(Q1 q12, String str);
    }

    public Q1(V0 adTools, AbstractC2595v0 adUnitData) {
        kotlin.jvm.internal.k.e(adTools, "adTools");
        kotlin.jvm.internal.k.e(adUnitData, "adUnitData");
        this.f7402a = adTools;
        this.f7403b = adUnitData;
        this.f7404c = a();
        this.f7405d = new C2316f2(adUnitData);
        this.e = new ArrayList();
        this.f7406f = adUnitData.e().q();
        b bVarB = b();
        Hf hfG = adUnitData.b().g();
        for (NetworkSettings networkSettings : adUnitData.m()) {
            if (hfG == null || hfG.a(networkSettings, this.f7403b.b().a())) {
                AdData adDataA = this.f7403b.a(networkSettings);
                if (networkSettings.isBidder(this.f7403b.b().a())) {
                    Object objB = this.f7406f ? b(networkSettings.getProviderName()) : a(networkSettings);
                    if (objB instanceof B3) {
                        this.e.add(new CallableC2666z3(networkSettings.getInstanceType(this.f7403b.b().a()), networkSettings.getProviderInstanceName(), adDataA, (B3) objB, bVarB, networkSettings));
                    } else {
                        this.f7402a.e().h().g(objB == null ? a1.a.l("prepareAuctionCandidates - could not load network adapter ", networkSettings.getProviderName()) : a1.a.m("network adapter ", networkSettings.getProviderName(), " does not implementing BiddingDataInterface"));
                    }
                } else {
                    this.f7405d.a(networkSettings);
                }
            }
        }
    }

    public final Map<String, G> c() {
        return this.f7404c;
    }

    public final C2316f2 d() {
        return this.f7405d;
    }

    public final List<CallableC2666z3> e() {
        return this.e;
    }

    public final boolean f() {
        return !this.e.isEmpty();
    }

    public final boolean g() {
        return this.f7405d.d();
    }

    public final boolean h() {
        return this.f7406f;
    }

    private final b b() {
        return new b();
    }

    private final C3.b b(d dVar) {
        return new c(dVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final BaseAdAdapter<?, ?> b(String str) {
        G g = this.f7404c.get(str);
        if (g != null) {
            return g.b();
        }
        return null;
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class b implements A3 {
        public b() {
        }

        @Override // com.ironsource.A3
        public void a(NetworkSettings networkSettings) {
            AdapterBaseInterface adapterBaseInterfaceA;
            if (Q1.this.h()) {
                adapterBaseInterfaceA = null;
                BaseAdAdapter baseAdAdapterB = Q1.this.b(networkSettings != null ? networkSettings.getProviderName() : null);
                if (baseAdAdapterB != null) {
                    adapterBaseInterfaceA = baseAdAdapterB.getNetworkAdapter();
                }
            } else {
                adapterBaseInterfaceA = Q1.this.a(networkSettings);
            }
            if (adapterBaseInterfaceA != null) {
                Q1.this.f7402a.e().g().a(Q1.this.a(networkSettings, adapterBaseInterfaceA));
            }
        }

        @Override // com.ironsource.A3
        public void a(String str) {
            Q1.this.f7402a.e().h().g(str);
        }
    }

    private final Map<String, G> a() {
        List<NetworkSettings> listM = this.f7403b.m();
        int iD0 = r5.x.d0(r5.n.L0(listM, 10));
        if (iD0 < 16) {
            iD0 = 16;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(iD0);
        Iterator<T> it = listM.iterator();
        while (it.hasNext()) {
            G g = new G(this.f7402a, this.f7403b, (NetworkSettings) it.next());
            linkedHashMap.put(g.c(), g);
        }
        return linkedHashMap;
    }

    public final void a(d biddingDataListener) {
        kotlin.jvm.internal.k.e(biddingDataListener, "biddingDataListener");
        C3 c32 = new C3();
        C3.b bVarB = b(biddingDataListener);
        this.f7402a.e().g().a();
        this.f7402a.c((AbstractRunnableC2382ie) new a(c32, this, bVarB));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(long j, List<? extends D3> list, List<String> list2, d dVar) {
        this.f7402a.e().g().a(j);
        for (D3 d32 : list) {
            String strC = d32.c();
            kotlin.jvm.internal.k.d(strC, "biddingResponse.instanceName");
            Map<String, Object> mapA = a(strC);
            if (d32.a() != null) {
                this.f7405d.a(d32);
                this.f7402a.e().g().a(mapA, d32.e());
            } else {
                this.f7402a.e().g().a(mapA, d32.e(), d32.b());
            }
        }
        Iterator<String> it = list2.iterator();
        while (it.hasNext()) {
            this.f7402a.e().g().b(a(it.next()), j);
        }
        dVar.a(this);
    }

    private final Map<String, Object> a(String str) {
        AdapterBaseInterface adapterBaseInterfaceA;
        NetworkSettings networkSettingsA = this.f7403b.a(str);
        if (this.f7406f) {
            BaseAdAdapter<?, ?> baseAdAdapterB = b(str);
            adapterBaseInterfaceA = baseAdAdapterB != null ? baseAdAdapterB.getNetworkAdapter() : null;
        } else {
            adapterBaseInterfaceA = a(networkSettingsA);
        }
        return a(networkSettingsA, adapterBaseInterfaceA);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Map<String, Object> a(NetworkSettings networkSettings, AdapterBaseInterface adapterBaseInterface) {
        String providerDefaultInstance;
        HashMap map = new HashMap();
        if (networkSettings != null) {
            try {
                providerDefaultInstance = networkSettings.getProviderDefaultInstance();
            } catch (Exception e) {
                C2531r4.d().a(e);
                IronSourceLoggerManager.getLogger().logException(IronSourceLogger.IronSourceTag.INTERNAL, "getProviderEventData " + (networkSettings != null ? networkSettings.getProviderDefaultInstance() : null), e);
                return map;
            }
        } else {
            providerDefaultInstance = null;
        }
        map.put(IronSourceConstants.EVENTS_PROVIDER, providerDefaultInstance);
        map.put(IronSourceConstants.EVENTS_PROVIDER_ADAPTER_VERSION, adapterBaseInterface != null ? adapterBaseInterface.getAdapterVersion() : null);
        map.put(IronSourceConstants.EVENTS_PROVIDER_SDK_VERSION, adapterBaseInterface != null ? adapterBaseInterface.getNetworkSDKVersion() : null);
        map.put("spId", networkSettings != null ? networkSettings.getSubProviderId() : null);
        map.put(IronSourceConstants.EVENTS_PROGRAMMATIC, 1);
        map.put("instanceType", networkSettings != null ? Integer.valueOf(networkSettings.getInstanceType(this.f7403b.b().a())) : null);
        return map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AdapterBaseInterface a(NetworkSettings networkSettings) {
        return com.ironsource.mediationsdk.c.b().b(networkSettings, this.f7403b.b().a(), this.f7403b.b().b());
    }
}
