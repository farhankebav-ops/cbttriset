package com.ironsource.adapters.ironsource.nativeAd;

import a1.a;
import android.app.Activity;
import com.ironsource.C2300e4;
import com.ironsource.C2531r4;
import com.ironsource.E8;
import com.ironsource.adapters.ironsource.IronSourceAdapter;
import com.ironsource.environment.ContextProvider;
import com.ironsource.mediationsdk.adapter.AbstractNativeAdAdapter;
import com.ironsource.mediationsdk.ads.nativead.interfaces.NativeAdSmashListener;
import com.ironsource.mediationsdk.d;
import com.ironsource.mediationsdk.logger.IronSourceError;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.k;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class IronSourceNativeAdAdapter extends AbstractNativeAdAdapter<IronSourceAdapter> {
    private E8 nativeAd;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IronSourceNativeAdAdapter(IronSourceAdapter adapter) {
        super(adapter);
        k.e(adapter, "adapter");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void loadNativeAdForBidding$lambda$0(IronSourceNativeAdAdapter this$0, JSONObject config, NativeAdSmashListener listener, String str) {
        k.e(this$0, "this$0");
        k.e(config, "$config");
        k.e(listener, "$listener");
        try {
            E8 e8A = E8.j.a();
            e8A.a(new IronSourceNativeAdListener(new IronSourceNativeAdViewBinder(e8A, this$0.getNativeAdProperties(config)), listener));
            Activity activity = ContextProvider.getInstance().getCurrentActiveActivity();
            JSONObject jSONObjectPrepareLoadParams = this$0.prepareLoadParams(config, str);
            k.d(activity, "activity");
            e8A.a(activity, jSONObjectPrepareLoadParams);
            this$0.nativeAd = e8A;
        } catch (Exception e) {
            C2531r4.d().a(e);
            listener.onNativeAdLoadFailed(new IronSourceError(510, a.l("IronSourceAdapter loadNativeAd exception ", e.getMessage())));
        }
    }

    private final JSONObject prepareLoadParams(JSONObject jSONObject, String str) throws JSONException {
        JSONObject loadParams = new JSONObject().put("demandSourceName", getAdapter().getDemandSourceName(jSONObject)).put(C2300e4.f8285r, "2").put("inAppBidding", true).put(getAdapter().ADM_KEY, d.b().a(str));
        HashMap<String, String> extraParams = getAdapter().getInitParams();
        k.d(extraParams, "extraParams");
        for (Map.Entry<String, String> entry : extraParams.entrySet()) {
            loadParams.put(entry.getKey(), entry.getValue());
        }
        k.d(loadParams, "loadParams");
        return loadParams;
    }

    @Override // com.ironsource.mediationsdk.adapter.AbstractNativeAdAdapter, com.ironsource.mediationsdk.ads.nativead.interfaces.NativeAdAdapterInterface
    public void destroyNativeAd(JSONObject config) {
        k.e(config, "config");
        E8 e8 = this.nativeAd;
        if (e8 != null) {
            e8.a();
        }
    }

    @Override // com.ironsource.mediationsdk.adapter.AbstractNativeAdAdapter, com.ironsource.mediationsdk.ads.nativead.interfaces.NativeAdAdapterInterface
    public Map<String, Object> getNativeAdBiddingData(JSONObject config, JSONObject jSONObject) {
        k.e(config, "config");
        return new HashMap();
    }

    @Override // com.ironsource.mediationsdk.adapter.AbstractNativeAdAdapter, com.ironsource.mediationsdk.ads.nativead.interfaces.NativeAdAdapterInterface
    public void initNativeAdForBidding(String str, String str2, JSONObject config, NativeAdSmashListener listener) {
        k.e(config, "config");
        k.e(listener, "listener");
        getAdapter().initSDK(str, config);
        listener.onNativeAdInitSuccess();
    }

    @Override // com.ironsource.mediationsdk.adapter.AbstractNativeAdAdapter, com.ironsource.mediationsdk.ads.nativead.interfaces.NativeAdAdapterInterface
    public void loadNativeAdForBidding(JSONObject config, JSONObject jSONObject, String str, NativeAdSmashListener listener) {
        k.e(config, "config");
        k.e(listener, "listener");
        postOnUIThread(new a3.d(this, config, listener, str, 12));
    }
}
