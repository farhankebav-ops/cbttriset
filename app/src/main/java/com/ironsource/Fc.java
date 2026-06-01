package com.ironsource;

import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.model.NetworkSettings;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class Fc extends Ag {
    private final V0 e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final AbstractC2595v0 f6766f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Fc(V0 tools, AbstractC2595v0 adUnitData) {
        super(tools, adUnitData);
        kotlin.jvm.internal.k.e(tools, "tools");
        kotlin.jvm.internal.k.e(adUnitData, "adUnitData");
        this.e = tools;
        this.f6766f = adUnitData;
    }

    private final C2405k2 b() {
        return new C2405k2("", new JSONObject(), null, 0, "");
    }

    private final Map<String, G> c() {
        Hf hfG = this.f6766f.b().g();
        List<NetworkSettings> listM = this.f6766f.m();
        ArrayList arrayList = new ArrayList();
        for (Object obj : listM) {
            NetworkSettings networkSettings = (NetworkSettings) obj;
            if (hfG == null || hfG.a(networkSettings, this.f6766f.b().a())) {
                if (!networkSettings.isBidder(this.f6766f.b().a())) {
                    arrayList.add(obj);
                }
            }
        }
        int iD0 = r5.x.d0(r5.n.L0(arrayList, 10));
        if (iD0 < 16) {
            iD0 = 16;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(iD0);
        int size = arrayList.size();
        int i2 = 0;
        while (i2 < size) {
            Object obj2 = arrayList.get(i2);
            i2++;
            NetworkSettings networkSettings2 = (NetworkSettings) obj2;
            linkedHashMap.put(networkSettings2.getProviderInstanceName(), new G(this.e, this.f6766f, networkSettings2));
        }
        return linkedHashMap;
    }

    private final List<C2461n2> d() {
        Hf hfG = this.f6766f.b().g();
        List<NetworkSettings> listM = this.f6766f.m();
        ArrayList arrayList = new ArrayList();
        for (Object obj : listM) {
            NetworkSettings networkSettings = (NetworkSettings) obj;
            if (hfG == null || hfG.a(networkSettings, this.f6766f.b().a())) {
                if (!networkSettings.isBidder(this.f6766f.b().a())) {
                    arrayList.add(obj);
                }
            }
        }
        ArrayList arrayList2 = new ArrayList(r5.n.L0(arrayList, 10));
        int size = arrayList.size();
        int i2 = 0;
        while (i2 < size) {
            Object obj2 = arrayList.get(i2);
            i2++;
            arrayList2.add(new C2461n2(((NetworkSettings) obj2).getProviderInstanceName()));
        }
        return arrayList2;
    }

    @Override // com.ironsource.Ag
    public void a(C adInstanceFactory, Bg waterfallFetcherListener) {
        kotlin.jvm.internal.k.e(adInstanceFactory, "adInstanceFactory");
        kotlin.jvm.internal.k.e(waterfallFetcherListener, "waterfallFetcherListener");
        IronLog.INTERNAL.verbose(C2459n0.a(this.e, "auction disabled", (String) null, 2, (Object) null));
        a(waterfallFetcherListener, b(), adInstanceFactory);
    }

    public final void a(Bg waterfallFetcherListener, int i2, String auctionFallback, String auctionId, C adInstanceFactory) {
        kotlin.jvm.internal.k.e(waterfallFetcherListener, "waterfallFetcherListener");
        kotlin.jvm.internal.k.e(auctionFallback, "auctionFallback");
        kotlin.jvm.internal.k.e(auctionId, "auctionId");
        kotlin.jvm.internal.k.e(adInstanceFactory, "adInstanceFactory");
        a(waterfallFetcherListener, new C2405k2(auctionId, new JSONObject(), null, i2, auctionFallback), adInstanceFactory);
    }

    private final void a(Bg bg, C2405k2 c2405k2, C c7) {
        IronLog.INTERNAL.verbose(C2459n0.a(this.e, (String) null, (String) null, 3, (Object) null));
        bg.a(a(d(), c(), c2405k2, c7));
    }
}
