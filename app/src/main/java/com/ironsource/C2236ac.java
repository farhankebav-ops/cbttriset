package com.ironsource;

import android.text.TextUtils;
import com.ironsource.AbstractC2497p3;
import com.ironsource.environment.ContextProvider;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.ads.nativead.internal.InternalNativeAdListener;
import com.ironsource.mediationsdk.adunit.adapter.internal.BaseAdAdapter;
import com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdListener;
import com.ironsource.mediationsdk.adunit.adapter.utility.AdInfo;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.model.NetworkSettings;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.ironsource.ac, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class C2236ac extends AbstractC2497p3<C2308ec, AdapterAdListener> implements Q0 {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2236ac(List<? extends NetworkSettings> list, Rb configs, String str, C2469na publisherDataHolder, C2270ca c2270ca) {
        super(new C2254bc(str, list, configs), publisherDataHolder, c2270ca);
        kotlin.jvm.internal.k.e(configs, "configs");
        kotlin.jvm.internal.k.e(publisherDataHolder, "publisherDataHolder");
    }

    @Override // com.ironsource.AbstractC2497p3
    public boolean H() {
        return false;
    }

    public final void M() {
        C2294dg c2294dg;
        Ab ab;
        IronLog.INTERNAL.verbose();
        try {
            C2308ec c2308ec = (C2308ec) this.f9589a.d();
            if (c2308ec != null) {
                Integer numR = c2308ec.r();
                int iA = numR == null ? this.C.a(this.f9596o.b()) : numR.intValue();
                D0 d0 = this.f9599s;
                if (d0 != null && (ab = d0.f6419f) != null) {
                    ab.a(iA);
                }
                c2308ec.P();
                this.f9589a.a(null);
                this.f9589a.b(null);
            }
            this.f9594i = null;
            a(AbstractC2497p3.f.NONE);
        } catch (Throwable th) {
            C2531r4.d().a(th);
            String strL = a1.a.l("destroyNativeAd - exception = ", th.getLocalizedMessage());
            IronLog.INTERNAL.error(b(strL));
            D0 d02 = this.f9599s;
            if (d02 == null || (c2294dg = d02.j) == null) {
                return;
            }
            c2294dg.g(strL);
        }
    }

    @Override // com.ironsource.AbstractC2497p3
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public C2308ec a(NetworkSettings providerSettings, BaseAdAdapter<?, AdapterAdListener> adapter, int i2, String currentAuctionId, C2461n2 item) {
        kotlin.jvm.internal.k.e(providerSettings, "providerSettings");
        kotlin.jvm.internal.k.e(adapter, "adapter");
        kotlin.jvm.internal.k.e(currentAuctionId, "currentAuctionId");
        kotlin.jvm.internal.k.e(item, "item");
        return new C2308ec(this, new C2421l0(IronSource.a.NATIVE_AD, this.f9596o.o(), i2, this.g, currentAuctionId, this.e, this.f9593f, providerSettings, this.f9596o.n()), adapter, this.f9594i, item, this);
    }

    @Override // com.ironsource.AbstractC2497p3
    public K0 g() {
        return new C2444m5();
    }

    @Override // com.ironsource.AbstractC2497p3
    public String l() {
        return "NA";
    }

    @Override // com.ironsource.AbstractC2497p3
    public String o() {
        return IronSourceConstants.OPW_NT_MANAGER_NAME;
    }

    @Override // com.ironsource.AbstractC2497p3
    public boolean v() {
        return false;
    }

    public final void a(C2434ld c2434ld) {
        String str;
        int iB;
        IronLog.INTERNAL.verbose("placement = " + c2434ld);
        if (c2434ld == null || TextUtils.isEmpty(c2434ld.c())) {
            str = String.format("can't load native ad - %s", Arrays.copyOf(new Object[]{c2434ld == null ? "placement is null" : "placement name is empty"}, 1));
            iB = C2663z0.b(this.f9596o.b());
        } else if (this.E.c(ContextProvider.getInstance().getApplicationContext(), c2434ld, this.f9596o.b())) {
            str = String.format("placement %s is capped", Arrays.copyOf(new Object[]{c2434ld.c()}, 1));
            iB = C2663z0.f(this.f9596o.b());
        } else {
            str = null;
            iB = 510;
        }
        if (TextUtils.isEmpty(str)) {
            this.f9594i = c2434ld;
            A();
        } else {
            IronLog.API.error(b(str));
            a(iB, str, false);
        }
    }

    @Override // com.ironsource.AbstractC2497p3
    public JSONObject b(NetworkSettings providerSettings) {
        kotlin.jvm.internal.k.e(providerSettings, "providerSettings");
        JSONObject nativeAdSettings = providerSettings.getNativeAdSettings();
        kotlin.jvm.internal.k.d(nativeAdSettings, "providerSettings.nativeAdSettings");
        return nativeAdSettings;
    }

    @Override // com.ironsource.AbstractC2497p3
    public void G() {
    }

    public final void a(InternalNativeAdListener nativeAdListener) {
        kotlin.jvm.internal.k.e(nativeAdListener, "nativeAdListener");
        a(new Zb(nativeAdListener));
    }

    @Override // com.ironsource.AbstractC2497p3
    public void a(AbstractC2547s3<?> abstractC2547s3, AdInfo adInfo) {
        if (abstractC2547s3 instanceof C2308ec) {
            C2308ec c2308ec = (C2308ec) abstractC2547s3;
            this.f9600t.a(c2308ec.Q(), c2308ec.R(), adInfo);
        }
    }

    @Override // com.ironsource.AbstractC2497p3
    public void a(IronSourceError ironSourceError) {
        this.f9600t.a(ironSourceError);
    }

    @Override // com.ironsource.AbstractC2497p3, com.ironsource.C0
    public Map<String, Object> a(A0 event) {
        kotlin.jvm.internal.k.e(event, "event");
        Map<String, Object> data = super.a(event);
        C2434ld c2434ld = this.f9594i;
        if (c2434ld != null) {
            kotlin.jvm.internal.k.d(data, "data");
            data.put("placement", c2434ld.c());
        }
        UUID uuid = this.f9603w;
        if (uuid != null) {
            kotlin.jvm.internal.k.d(data, "data");
            data.put("objectId", uuid);
        }
        kotlin.jvm.internal.k.d(data, "data");
        return data;
    }
}
