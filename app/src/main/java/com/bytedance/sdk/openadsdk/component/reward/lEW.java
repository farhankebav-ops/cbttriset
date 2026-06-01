package com.bytedance.sdk.openadsdk.component.reward;

import android.content.Context;
import android.os.RemoteException;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.oeT;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.IListenerManager;
import com.bytedance.sdk.openadsdk.api.reward.PAGRewardedAd;
import com.bytedance.sdk.openadsdk.api.reward.PAGRewardedAdInteractionCallback;
import com.bytedance.sdk.openadsdk.api.reward.PAGRewardedAdInteractionListener;
import com.bytedance.sdk.openadsdk.core.model.es;
import com.bytedance.sdk.openadsdk.utils.mmj;
import com.bytedance.sdk.openadsdk.utils.pP;
import com.bytedance.sdk.openadsdk.utils.vSq;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
class lEW extends PAGRewardedAd {
    private boolean Cc;
    private boolean DmF;
    private final AdSlot EO;
    private final Context IlO;
    private final com.bytedance.sdk.openadsdk.core.model.IlO MY;
    private boolean lEW;
    private com.bytedance.sdk.openadsdk.IlO.Cc.IlO tV;
    private final AtomicBoolean vCE = new AtomicBoolean(false);
    private final String Bc = pP.IlO();

    public lEW(Context context, com.bytedance.sdk.openadsdk.core.model.IlO ilO, AdSlot adSlot) {
        this.IlO = context;
        this.MY = ilO;
        this.EO = adSlot;
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
            oeT.EO("TTRewardVideoAdImpl", th.getMessage());
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

    @Override // com.bytedance.sdk.openadsdk.api.reward.PAGRewardedAd
    public void setAdInteractionCallback(PAGRewardedAdInteractionCallback pAGRewardedAdInteractionCallback) {
        this.tV = new DmF(pAGRewardedAdInteractionCallback);
        IlO(0);
    }

    @Override // com.bytedance.sdk.openadsdk.api.reward.PAGRewardedAd
    public void setAdInteractionListener(PAGRewardedAdInteractionListener pAGRewardedAdInteractionListener) {
        this.tV = new DmF(pAGRewardedAdInteractionListener);
        IlO(0);
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:65:? A[RETURN, SYNTHETIC] */
    @Override // com.bytedance.sdk.openadsdk.api.reward.PAGRewardedAd
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void show(@androidx.annotation.Nullable android.app.Activity r12) {
        /*
            Method dump skipped, instruction units count: 291
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.component.reward.lEW.show(android.app.Activity):void");
    }

    @Override // com.bytedance.sdk.openadsdk.api.PAGClientBidding
    public void win(Double d8) {
        if (this.lEW) {
            return;
        }
        vSq.IlO(this.MY.vCE(), d8);
        this.lEW = true;
    }

    public void IlO() {
        if (this.vCE.get()) {
            return;
        }
        this.Cc = true;
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
            mmj.EO(new com.bytedance.sdk.component.lEW.lEW("Reward_registerMultiProcessListener") { // from class: com.bytedance.sdk.openadsdk.component.reward.lEW.3
                @Override // java.lang.Runnable
                public void run() {
                    com.bytedance.sdk.openadsdk.multipro.aidl.IlO IlO = com.bytedance.sdk.openadsdk.multipro.aidl.IlO.IlO();
                    if (i2 != 0 || lEW.this.tV == null) {
                        return;
                    }
                    com.bytedance.sdk.openadsdk.multipro.aidl.MY.tV tVVar = new com.bytedance.sdk.openadsdk.multipro.aidl.MY.tV(lEW.this.tV);
                    IListenerManager iListenerManagerAsInterface = IListenerManager.Stub.asInterface(IlO.IlO(0));
                    if (iListenerManagerAsInterface != null) {
                        try {
                            iListenerManagerAsInterface.registerRewardVideoListener(lEW.this.Bc, tVVar);
                        } catch (RemoteException e) {
                            oeT.EO("TTRewardVideoAdImpl", e.getMessage());
                        }
                    }
                }
            }, 5);
        }
    }

    public static boolean IlO(com.bytedance.sdk.openadsdk.core.model.IlO ilO) {
        com.bytedance.sdk.openadsdk.core.model.oeT oetVCE;
        if (ilO == null || (oetVCE = ilO.vCE()) == null || es.EO(oetVCE)) {
            return false;
        }
        if (oetVCE.WIv()) {
            return true;
        }
        try {
            String strIlO = com.bytedance.sdk.openadsdk.AXM.IlO.IlO("rviv_new_arch", (String) null);
            if (TextUtils.isEmpty(strIlO)) {
                return false;
            }
            JSONArray jSONArray = new JSONArray(strIlO);
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                if (oetVCE.vAh() == jSONArray.getInt(i2)) {
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }
}
