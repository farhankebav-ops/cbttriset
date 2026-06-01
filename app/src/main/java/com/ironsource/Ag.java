package com.ironsource;

import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.model.NetworkSettings;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class Ag {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f6345d = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final V0 f6346a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AbstractC2595v0 f6347b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Xc f6348c;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }

        public final Ag a(V0 adTools, AbstractC2595v0 adUnitData) {
            kotlin.jvm.internal.k.e(adTools, "adTools");
            kotlin.jvm.internal.k.e(adUnitData, "adUnitData");
            return adUnitData.t() ? new C2513q2(adTools, adUnitData) : new Fc(adTools, adUnitData);
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class b implements Xc {
        @Override // com.ironsource.Xc
        public final /* synthetic */ void a(AbstractC2662z abstractC2662z, String str, C2469na c2469na) {
            xh.a(this, abstractC2662z, str, c2469na);
        }

        @Override // com.ironsource.Xc
        public final /* synthetic */ void a(List list, AbstractC2662z abstractC2662z) {
            xh.b(this, list, abstractC2662z);
        }
    }

    public Ag(V0 adTools, AbstractC2595v0 adUnitData) {
        kotlin.jvm.internal.k.e(adTools, "adTools");
        kotlin.jvm.internal.k.e(adUnitData, "adUnitData");
        this.f6346a = adTools;
        this.f6347b = adUnitData;
        this.f6348c = new b();
    }

    public Xc a() {
        return this.f6348c;
    }

    public abstract void a(C c7, Bg bg);

    public final Cg a(List<? extends C2461n2> waterfallItems, Map<String, G> adInstancePayloads, C2405k2 auctionData, C adInstanceFactory) {
        kotlin.jvm.internal.k.e(waterfallItems, "waterfallItems");
        kotlin.jvm.internal.k.e(adInstancePayloads, "adInstancePayloads");
        kotlin.jvm.internal.k.e(auctionData, "auctionData");
        kotlin.jvm.internal.k.e(adInstanceFactory, "adInstanceFactory");
        IronLog.INTERNAL.verbose(C2459n0.a(this.f6346a, a1.a.g(waterfallItems.size(), "waterfall.size() = "), (String) null, 2, (Object) null));
        ArrayList arrayList = new ArrayList();
        int size = waterfallItems.size();
        for (int i2 = 0; i2 < size; i2++) {
            C2461n2 c2461n2 = waterfallItems.get(i2);
            AbstractC2662z abstractC2662zA = a(c2461n2, auctionData, adInstanceFactory, adInstancePayloads.get(c2461n2.c()));
            if (abstractC2662zA != null && abstractC2662zA.g() != null) {
                arrayList.add(abstractC2662zA);
            }
        }
        Cg cg = new Cg(arrayList);
        IronLog.INTERNAL.verbose(C2459n0.a(this.f6346a, "updateWaterfall() - next waterfall is " + cg + ".toWaterfallString()", (String) null, 2, (Object) null));
        return cg;
    }

    private final AbstractC2662z a(C2461n2 c2461n2, C2405k2 c2405k2, C c7, G g) {
        AbstractC2595v0 abstractC2595v0 = this.f6347b;
        String strC = c2461n2.c();
        kotlin.jvm.internal.k.d(strC, "item.instanceName");
        NetworkSettings networkSettingsA = abstractC2595v0.a(strC);
        if (networkSettingsA == null) {
            String strC2 = c2461n2.c();
            kotlin.jvm.internal.k.d(strC2, "item.instanceName");
            a("Could not find matching provider settings for auction response item", strC2);
            return null;
        }
        if (g == null) {
            String strC3 = c2461n2.c();
            kotlin.jvm.internal.k.d(strC3, "item.instanceName");
            a("Could not find matching adInstancePayload for auction response item", strC3);
            return null;
        }
        com.ironsource.mediationsdk.c.b().b(networkSettingsA, this.f6347b.b().a(), this.f6347b.b().b());
        int iF = this.f6346a.f();
        AbstractC2595v0 abstractC2595v02 = this.f6347b;
        return c7.a(new A(abstractC2595v02, networkSettingsA, c2405k2, new C2243b1(networkSettingsA, abstractC2595v02.b(networkSettingsA), this.f6347b.b().a()), c2461n2, iF), g);
    }

    private final void a(String str, String str2) {
        String strD = a1.a.D(str, " - item = ", str2);
        IronLog.INTERNAL.error(C2459n0.a(this.f6346a, strD, (String) null, 2, (Object) null));
        this.f6346a.e().h().i(strD);
    }
}
