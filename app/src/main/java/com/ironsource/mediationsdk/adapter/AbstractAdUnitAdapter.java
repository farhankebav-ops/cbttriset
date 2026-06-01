package com.ironsource.mediationsdk.adapter;

import com.ironsource.environment.thread.IronSourceThreadManager;
import com.ironsource.mediationsdk.INetworkInitCallbackListener;
import kotlin.jvm.internal.k;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class AbstractAdUnitAdapter<AdNetworkAdapter> implements INetworkInitCallbackListener {
    private final AdNetworkAdapter adapter;

    public AbstractAdUnitAdapter(AdNetworkAdapter adnetworkadapter) {
        this.adapter = adnetworkadapter;
    }

    public final String getAdUnitIdMissingErrorString(String key) {
        k.e(key, "key");
        return "Missing params - ".concat(key);
    }

    public final AdNetworkAdapter getAdapter() {
        return this.adapter;
    }

    public final String getConfigStringValueFromKey(JSONObject config, String key) {
        k.e(config, "config");
        k.e(key, "key");
        String strOptString = config.optString(key);
        k.d(strOptString, "config.optString(key)");
        return strOptString;
    }

    public final void postBackgroundThread(Runnable runnable) {
        k.e(runnable, "runnable");
        IronSourceThreadManager.postAdapterBackgroundTask$default(IronSourceThreadManager.INSTANCE, runnable, 0L, 2, null);
    }

    public final void postOnUIThread(Runnable runnable) {
        k.e(runnable, "runnable");
        IronSourceThreadManager.postOnUiThreadTask$default(IronSourceThreadManager.INSTANCE, runnable, 0L, 2, null);
    }

    @Override // com.ironsource.mediationsdk.INetworkInitCallbackListener
    public void onNetworkInitCallbackSuccess() {
    }

    @Override // com.ironsource.mediationsdk.INetworkInitCallbackListener
    public void onNetworkInitCallbackFailed(String str) {
    }
}
