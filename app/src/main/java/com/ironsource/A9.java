package com.ironsource;

import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.adunit.adapter.internal.BaseAdAdapter;
import com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdInteractionListener;
import com.ironsource.mediationsdk.model.NetworkSettings;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class A9 extends AbstractC2462n3<C9, AdapterAdInteractionListener> {
    public A9(List<NetworkSettings> list, F9 f9, String str, C2469na c2469na, C2270ca c2270ca) {
        super(new B9(str, list, f9), c2469na, c2270ca);
    }

    @Override // com.ironsource.AbstractC2497p3
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public C9 a(NetworkSettings networkSettings, BaseAdAdapter<?, AdapterAdInteractionListener> baseAdAdapter, int i2, String str, C2461n2 c2461n2) {
        return new C9(this, new C2421l0(IronSource.a.INTERSTITIAL, this.f9596o.o(), i2, this.g, str, this.e, this.f9593f, networkSettings, this.f9596o.n()), baseAdAdapter, c2461n2, this);
    }

    @Override // com.ironsource.AbstractC2497p3
    public K0 g() {
        return new J9();
    }

    @Override // com.ironsource.AbstractC2497p3
    public String l() {
        return IronSourceConstants.INTERSTITIAL_EVENT_TYPE;
    }

    @Override // com.ironsource.AbstractC2497p3
    public String o() {
        return IronSourceConstants.OPW_IS_MANAGER_NAME;
    }

    public A9(L7 l72, K7 k72, List<NetworkSettings> list, F9 f9, String str, C2469na c2469na, C2270ca c2270ca) {
        super(l72, k72, new B9(str, list, f9), c2469na, c2270ca);
    }

    @Override // com.ironsource.AbstractC2497p3
    public JSONObject b(NetworkSettings networkSettings) {
        return networkSettings.getInterstitialSettings();
    }
}
