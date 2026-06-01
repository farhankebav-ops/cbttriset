package com.bytedance.sdk.openadsdk.component;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.os.RemoteException;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import com.bytedance.sdk.component.lEW.lEW;
import com.bytedance.sdk.component.utils.MY;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.IListenerManager;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.activity.TTAppOpenAdActivity;
import com.bytedance.sdk.openadsdk.api.open.PAGAppOpenAd;
import com.bytedance.sdk.openadsdk.api.open.PAGAppOpenAdInteractionCallback;
import com.bytedance.sdk.openadsdk.api.open.PAGAppOpenAdInteractionListener;
import com.bytedance.sdk.openadsdk.core.bWL;
import com.bytedance.sdk.openadsdk.core.cl;
import com.bytedance.sdk.openadsdk.core.model.oeT;
import com.bytedance.sdk.openadsdk.core.settings.hp;
import com.bytedance.sdk.openadsdk.oem.IPMiBroadcastReceiver;
import com.bytedance.sdk.openadsdk.utils.mmj;
import com.bytedance.sdk.openadsdk.utils.pP;
import com.bytedance.sdk.openadsdk.utils.vSq;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class tV extends PAGAppOpenAd {
    private final boolean Bc;
    private boolean DmF;
    private final AdSlot EO;
    private final Context IlO;
    private final oeT MY;
    private boolean lEW;
    private com.bytedance.sdk.openadsdk.IlO.tV.MY tV;
    private final AtomicBoolean Cc = new AtomicBoolean(false);
    private final String vCE = pP.IlO();

    public tV(Context context, @NonNull oeT oet, boolean z2, AdSlot adSlot) {
        this.IlO = context;
        this.MY = oet;
        this.Bc = z2;
        this.EO = adSlot;
    }

    @Override // com.bytedance.sdk.openadsdk.api.PangleAd
    public Object getExtraInfo(String str) {
        oeT oet = this.MY;
        if (oet == null || oet.tN() == null) {
            return null;
        }
        try {
            return this.MY.tN().get(str);
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.oeT.EO("TTAppOpenAdImpl", th.getMessage());
            return null;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.api.PangleAd
    public Map<String, Object> getMediaExtraInfo() {
        oeT oet = this.MY;
        if (oet != null) {
            return oet.tN();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.api.PAGClientBidding
    public void loss(Double d8, String str, String str2) {
        if (this.DmF) {
            return;
        }
        vSq.IlO(this.MY, d8, str, str2);
        this.DmF = true;
    }

    @Override // com.bytedance.sdk.openadsdk.api.open.PAGAppOpenAd
    public void setAdInteractionCallback(PAGAppOpenAdInteractionCallback pAGAppOpenAdInteractionCallback) {
        this.tV = new Cc(pAGAppOpenAdInteractionCallback);
        IlO();
    }

    @Override // com.bytedance.sdk.openadsdk.api.open.PAGAppOpenAd
    public void setAdInteractionListener(PAGAppOpenAdInteractionListener pAGAppOpenAdInteractionListener) {
        this.tV = new Cc(pAGAppOpenAdInteractionListener);
        IlO();
    }

    @Override // com.bytedance.sdk.openadsdk.api.open.PAGAppOpenAd
    public void show(Activity activity) {
        int rotation;
        if (activity != null && activity.isFinishing()) {
            activity = null;
        }
        if (this.Cc.getAndSet(true)) {
            return;
        }
        if (Looper.getMainLooper() != Looper.myLooper()) {
            throw new IllegalStateException("Cannot be called in a child thread ---- TTAppOpenAdImpl.showAppOpenAd");
        }
        IPMiBroadcastReceiver.IlO(this.IlO, this.MY);
        Context contextIlO = activity != null ? activity : this.IlO;
        if (contextIlO == null) {
            contextIlO = cl.IlO();
        }
        try {
            rotation = activity.getWindowManager().getDefaultDisplay().getRotation();
        } catch (Exception unused) {
            rotation = 0;
        }
        Intent intent = new Intent(contextIlO, (Class<?>) TTAppOpenAdActivity.class);
        intent.putExtra("orientation_angle", rotation);
        intent.putExtra(FirebaseAnalytics.Param.AD_SOURCE, this.Bc ? 1 : 2);
        if (com.bytedance.sdk.openadsdk.multipro.MY.EO()) {
            intent.putExtra(TTAdConstant.MULTI_PROCESS_MATERIALMETA, this.MY.eDn().toString());
            intent.putExtra(TTAdConstant.MULTI_PROCESS_META_MD5, this.vCE);
        } else {
            com.bytedance.sdk.openadsdk.core.pP.IlO().vCE();
            com.bytedance.sdk.openadsdk.core.pP.IlO().IlO(this.MY);
            com.bytedance.sdk.openadsdk.core.pP.IlO().IlO(this.tV);
            this.tV = null;
        }
        intent.putExtra("start_show_time", SystemClock.elapsedRealtime());
        com.bytedance.sdk.component.utils.MY.IlO(contextIlO, intent, new MY.InterfaceC0060MY() { // from class: com.bytedance.sdk.openadsdk.component.tV.2
            @Override // com.bytedance.sdk.component.utils.MY.InterfaceC0060MY
            public void IlO() {
            }

            @Override // com.bytedance.sdk.component.utils.MY.InterfaceC0060MY
            public void IlO(Throwable th) {
            }
        });
        bWL.MY().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.component.tV.3
            @Override // java.lang.Runnable
            public void run() {
                if (tV.this.EO != null) {
                    try {
                        if (hp.aP().kBB(tV.this.EO.getCodeId()) != 1 || oeT.Bc(tV.this.MY) || tV.this.MY.uAj()) {
                            return;
                        }
                        vCE vceIlO = vCE.IlO(tV.this.IlO);
                        vceIlO.Bc(Integer.parseInt(tV.this.EO.getCodeId()));
                        vceIlO.IlO(tV.this.EO);
                    } catch (Throwable unused2) {
                    }
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.api.PAGClientBidding
    public void win(Double d8) {
        if (this.lEW) {
            return;
        }
        vSq.IlO(this.MY, d8);
        this.lEW = true;
    }

    private void IlO() {
        if (com.bytedance.sdk.openadsdk.multipro.MY.EO()) {
            mmj.EO(new lEW("AppOpenAd_registerMultiProcessListener") { // from class: com.bytedance.sdk.openadsdk.component.tV.1
                @Override // java.lang.Runnable
                public void run() {
                    IListenerManager iListenerManagerAsInterface;
                    com.bytedance.sdk.openadsdk.multipro.aidl.IlO IlO = com.bytedance.sdk.openadsdk.multipro.aidl.IlO.IlO();
                    if (tV.this.tV == null || (iListenerManagerAsInterface = IListenerManager.Stub.asInterface(IlO.IlO(7))) == null) {
                        return;
                    }
                    try {
                        iListenerManagerAsInterface.registerAppOpenAdListener(tV.this.vCE, new com.bytedance.sdk.openadsdk.multipro.aidl.MY.IlO(tV.this.tV));
                        tV.this.tV = null;
                    } catch (RemoteException e) {
                        com.bytedance.sdk.component.utils.oeT.EO("TTAppOpenAdImpl", e.getMessage());
                    }
                }
            }, 5);
        }
    }
}
