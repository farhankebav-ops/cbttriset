package com.ironsource;

import android.text.TextUtils;
import com.ironsource.mediationsdk.adunit.adapter.internal.AdapterBaseInterface;
import com.ironsource.mediationsdk.adunit.adapter.internal.BaseAdAdapter;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class B implements C0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final V0 f6349a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final A f6350b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final BaseAdAdapter<?, ?> f6351c;

    public B(V0 adTools, A instanceData, BaseAdAdapter<?, ?> baseAdAdapter) {
        kotlin.jvm.internal.k.e(adTools, "adTools");
        kotlin.jvm.internal.k.e(instanceData, "instanceData");
        this.f6349a = adTools;
        this.f6350b = instanceData;
        this.f6351c = baseAdAdapter;
    }

    @Override // com.ironsource.C0
    public Map<String, Object> a(A0 event) {
        String adapterVersion;
        kotlin.jvm.internal.k.e(event, "event");
        HashMap map = new HashMap();
        try {
            BaseAdAdapter<?, ?> baseAdAdapter = this.f6351c;
            String networkSDKVersion = "";
            if (baseAdAdapter != null) {
                AdapterBaseInterface networkAdapter = baseAdAdapter.getNetworkAdapter();
                kotlin.jvm.internal.k.b(networkAdapter);
                adapterVersion = networkAdapter.getAdapterVersion();
            } else {
                adapterVersion = "";
            }
            kotlin.jvm.internal.k.d(adapterVersion, "if (adapter != null) ada…!!.adapterVersion else \"\"");
            map.put(IronSourceConstants.EVENTS_PROVIDER_ADAPTER_VERSION, adapterVersion);
            BaseAdAdapter<?, ?> baseAdAdapter2 = this.f6351c;
            if (baseAdAdapter2 != null) {
                AdapterBaseInterface networkAdapter2 = baseAdAdapter2.getNetworkAdapter();
                kotlin.jvm.internal.k.b(networkAdapter2);
                networkSDKVersion = networkAdapter2.getNetworkSDKVersion();
            }
            kotlin.jvm.internal.k.b(networkSDKVersion);
            map.put(IronSourceConstants.EVENTS_PROVIDER_SDK_VERSION, networkSDKVersion);
        } catch (Exception e) {
            C2531r4.d().a(e);
            IronLog.INTERNAL.error(C2459n0.a(this.f6349a, a1.a.l("could not get adapter version for event data ", this.f6350b.w()), (String) null, 2, (Object) null));
        }
        String strI = this.f6350b.j().i();
        kotlin.jvm.internal.k.d(strI, "instanceData.adapterConfig.subProviderId");
        map.put("spId", strI);
        String strA = this.f6350b.j().a();
        kotlin.jvm.internal.k.d(strA, "instanceData.adapterConfig.adSourceNameForEvents");
        map.put(IronSourceConstants.EVENTS_PROVIDER, strA);
        map.put("instanceType", Integer.valueOf(this.f6350b.s()));
        String serverData = this.f6350b.n().k();
        V0 v02 = this.f6349a;
        kotlin.jvm.internal.k.d(serverData, "serverData");
        String strE = v02.e(serverData);
        if (!TextUtils.isEmpty(strE)) {
            map.put("dynamicDemandSource", strE);
        }
        map.put("sessionDepth", Integer.valueOf(this.f6350b.v()));
        if (!TextUtils.isEmpty(this.f6350b.u().getCustomNetwork())) {
            String customNetwork = this.f6350b.u().getCustomNetwork();
            kotlin.jvm.internal.k.d(customNetwork, "instanceData.providerSettings.customNetwork");
            map.put(IronSourceConstants.EVENTS_CUSTOM_NETWORK_FIELD, customNetwork);
        }
        return map;
    }
}
