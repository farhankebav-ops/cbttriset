package com.bytedance.sdk.openadsdk.component.reward;

import android.content.Context;
import android.os.RemoteException;
import com.bytedance.sdk.component.utils.oeT;
import com.bytedance.sdk.openadsdk.IListenerManager;
import com.bytedance.sdk.openadsdk.api.interstitial.PAGInterstitialAd;
import com.bytedance.sdk.openadsdk.api.interstitial.PAGInterstitialAdInteractionCallback;
import com.bytedance.sdk.openadsdk.api.interstitial.PAGInterstitialAdInteractionListener;
import com.bytedance.sdk.openadsdk.utils.mmj;
import com.bytedance.sdk.openadsdk.utils.pP;
import com.bytedance.sdk.openadsdk.utils.vSq;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
class vCE extends PAGInterstitialAd {
    private boolean DmF;
    private com.bytedance.sdk.openadsdk.IlO.EO.MY EO;
    private final Context IlO;
    private final com.bytedance.sdk.openadsdk.core.model.IlO MY;
    private boolean lEW;
    private final AtomicBoolean Cc = new AtomicBoolean(false);
    private boolean vCE = false;
    private boolean tV = false;
    private final String Bc = pP.IlO();

    public vCE(Context context, com.bytedance.sdk.openadsdk.core.model.IlO ilO) {
        this.IlO = context;
        this.MY = ilO;
    }

    @Override // com.bytedance.sdk.openadsdk.api.PangleAd
    public Object getExtraInfo(String str) {
        com.bytedance.sdk.openadsdk.core.model.IlO ilO = this.MY;
        if (ilO == null || ilO.vCE() == null || this.MY.vCE().tN() == null) {
            return null;
        }
        try {
            return this.MY.vCE().tN().get(str);
        } catch (Throwable th) {
            oeT.EO("TTFullScreenVideoAdImpl", th.getMessage());
            return null;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.api.PangleAd
    public Map<String, Object> getMediaExtraInfo() {
        com.bytedance.sdk.openadsdk.core.model.IlO ilO = this.MY;
        if (ilO == null || ilO.vCE() == null) {
            return null;
        }
        return this.MY.vCE().tN();
    }

    @Override // com.bytedance.sdk.openadsdk.api.PAGClientBidding
    public void loss(Double d8, String str, String str2) {
        if (this.DmF) {
            return;
        }
        vSq.IlO(this.MY.vCE(), d8, str, str2);
        this.DmF = true;
    }

    @Override // com.bytedance.sdk.openadsdk.api.interstitial.PAGInterstitialAd
    public void setAdInteractionCallback(PAGInterstitialAdInteractionCallback pAGInterstitialAdInteractionCallback) {
        this.EO = new com.bytedance.sdk.openadsdk.component.EO.IlO(pAGInterstitialAdInteractionCallback);
        IlO(1);
    }

    @Override // com.bytedance.sdk.openadsdk.api.interstitial.PAGInterstitialAd
    public void setAdInteractionListener(PAGInterstitialAdInteractionListener pAGInterstitialAdInteractionListener) {
        this.EO = new com.bytedance.sdk.openadsdk.component.EO.IlO(pAGInterstitialAdInteractionListener);
        IlO(1);
    }

    /* JADX WARN: Removed duplicated region for block: B:57:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:74:? A[RETURN, SYNTHETIC] */
    @Override // com.bytedance.sdk.openadsdk.api.interstitial.PAGInterstitialAd
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void show(android.app.Activity r12) {
        /*
            Method dump skipped, instruction units count: 315
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.component.reward.vCE.show(android.app.Activity):void");
    }

    @Override // com.bytedance.sdk.openadsdk.api.PAGClientBidding
    public void win(Double d8) {
        if (this.lEW) {
            return;
        }
        vSq.IlO(this.MY.vCE(), d8);
        this.lEW = true;
    }

    public void IlO(boolean z2) {
        this.vCE = z2;
    }

    public void IlO() {
        if (this.Cc.get()) {
            return;
        }
        this.tV = true;
    }

    private static boolean IlO(com.bytedance.sdk.openadsdk.core.model.oeT oet) {
        if (oet == null) {
            return false;
        }
        int iVAh = oet.vAh();
        return (oet.oc() != 2 || iVAh == 5 || iVAh == 33 || iVAh == 6 || iVAh == 19 || iVAh == 12) ? false : true;
    }

    private void IlO(final int i2) {
        if (com.bytedance.sdk.openadsdk.multipro.MY.EO()) {
            mmj.EO(new com.bytedance.sdk.component.lEW.lEW("FullScreen_registerMultiProcessListener") { // from class: com.bytedance.sdk.openadsdk.component.reward.vCE.3
                @Override // java.lang.Runnable
                public void run() {
                    com.bytedance.sdk.openadsdk.multipro.aidl.IlO IlO = com.bytedance.sdk.openadsdk.multipro.aidl.IlO.IlO();
                    if (i2 != 1 || vCE.this.EO == null) {
                        return;
                    }
                    com.bytedance.sdk.openadsdk.multipro.aidl.MY.EO eo = new com.bytedance.sdk.openadsdk.multipro.aidl.MY.EO(vCE.this.EO);
                    IListenerManager iListenerManagerAsInterface = IListenerManager.Stub.asInterface(IlO.IlO(1));
                    if (iListenerManagerAsInterface != null) {
                        try {
                            iListenerManagerAsInterface.registerFullVideoListener(vCE.this.Bc, eo);
                        } catch (RemoteException e) {
                            oeT.EO("TTFullScreenVideoAdImpl", e.getMessage());
                        }
                    }
                }
            }, 5);
        }
    }
}
