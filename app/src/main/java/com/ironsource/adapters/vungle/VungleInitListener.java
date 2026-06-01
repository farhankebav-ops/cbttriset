package com.ironsource.adapters.vungle;

import com.ironsource.adapters.vungle.VungleAdapter;
import com.ironsource.mediationsdk.INetworkInitCallbackListener;
import com.ironsource.mediationsdk.logger.IronLog;
import com.vungle.ads.InitializationListener;
import com.vungle.ads.VungleError;
import java.util.Iterator;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class VungleInitListener implements InitializationListener {
    @Override // com.vungle.ads.InitializationListener
    public void onError(VungleError vungleError) {
        k.e(vungleError, "vungleError");
        IronLog.ADAPTER_CALLBACK.verbose("Failed to initialize SDK");
        VungleAdapter.Companion companion = VungleAdapter.Companion;
        companion.setMInitState$vungleadapter_release(VungleAdapter.Companion.InitState.INIT_STATE_FAILED);
        Iterator<T> it = companion.getInitCallbackListeners$vungleadapter_release().iterator();
        while (it.hasNext()) {
            ((INetworkInitCallbackListener) it.next()).onNetworkInitCallbackFailed(vungleError.getMessage());
        }
        VungleAdapter.Companion.getInitCallbackListeners$vungleadapter_release().clear();
    }

    @Override // com.vungle.ads.InitializationListener
    public void onSuccess() {
        IronLog.ADAPTER_CALLBACK.verbose("Succeeded to initialize SDK");
        VungleAdapter.Companion companion = VungleAdapter.Companion;
        companion.setMInitState$vungleadapter_release(VungleAdapter.Companion.InitState.INIT_STATE_SUCCESS);
        Iterator<T> it = companion.getInitCallbackListeners$vungleadapter_release().iterator();
        while (it.hasNext()) {
            ((INetworkInitCallbackListener) it.next()).onNetworkInitCallbackSuccess();
        }
        VungleAdapter.Companion.getInitCallbackListeners$vungleadapter_release().clear();
    }
}
