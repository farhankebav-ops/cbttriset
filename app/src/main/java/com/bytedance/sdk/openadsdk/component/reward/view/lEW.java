package com.bytedance.sdk.openadsdk.component.reward.view;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.api.PAGExpressAdWrapperListener;
import com.bytedance.sdk.openadsdk.core.cl;
import com.bytedance.sdk.openadsdk.core.lEW.bWL;
import com.bytedance.sdk.openadsdk.core.model.es;
import com.bytedance.sdk.openadsdk.core.model.oeT;
import com.bytedance.sdk.openadsdk.utils.BS;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class lEW {
    private final oeT Bc;
    private MY DmF;
    private boolean EV;
    com.bytedance.sdk.openadsdk.es.IlO.IlO.vCE IlO;
    Handler MY;
    private final com.bytedance.sdk.openadsdk.component.reward.IlO.IlO NV;
    private final String lEW;
    private final Activity vCE;
    boolean EO = false;
    boolean tV = false;
    boolean Cc = false;

    public lEW(com.bytedance.sdk.openadsdk.component.reward.IlO.IlO ilO) {
        this.NV = ilO;
        this.vCE = ilO.BS;
        this.Bc = ilO.MY;
        this.lEW = ilO.Cc;
    }

    public void Bc() {
        MY my = this.DmF;
        if (my != null) {
            my.ea();
        }
    }

    public Handler Cc() {
        if (this.MY == null) {
            this.MY = new Handler(Looper.getMainLooper());
        }
        return this.MY;
    }

    public int DmF() {
        MY my = this.DmF;
        if (my != null) {
            return my.getDynamicShowType();
        }
        return 0;
    }

    public boolean EO() {
        return this.EO;
    }

    public void EV() {
        MY my = this.DmF;
        if (my == null) {
            return;
        }
        my.bWL();
        this.DmF.ea();
    }

    public void IlO(AdSlot adSlot, es esVar) {
        if (this.Cc) {
            return;
        }
        this.Cc = true;
        MY my = new MY(this.NV, adSlot, this.lEW);
        this.DmF = my;
        esVar.IlO(my, my.getVideoFrameLayout());
    }

    public FrameLayout MY() {
        MY my = this.DmF;
        if (my == null) {
            return null;
        }
        FrameLayout videoFrameLayout = my.getVideoFrameLayout();
        if (this.DmF.cL()) {
            rp();
        }
        return videoFrameLayout;
    }

    public void NV() {
        MY my = this.DmF;
        if (my == null) {
            return;
        }
        my.hp();
    }

    public boolean lEW() {
        MY my = this.DmF;
        if (my == null) {
            return false;
        }
        return my.cL();
    }

    public void rp() {
        if (oeT.Cc(this.Bc) && this.Bc.DM() == 3 && this.Bc.zLG() == 0) {
            try {
                if (this.Bc.BES() == 1) {
                    int iMY = BS.MY(cl.IlO(), 90.0f);
                    FrameLayout frameLayout = (FrameLayout) this.DmF.getBackupContainerBackgroundView();
                    if (frameLayout != null) {
                        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) frameLayout.getLayoutParams();
                        layoutParams.bottomMargin = iMY;
                        frameLayout.setLayoutParams(layoutParams);
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    public boolean tV() {
        return this.tV;
    }

    public void vCE() {
        if (this.EV) {
            return;
        }
        this.EV = true;
        MY my = this.DmF;
        if (my != null) {
            my.zPa();
        }
        Handler handler = this.MY;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }

    public MY IlO() {
        return this.DmF;
    }

    public void MY(boolean z2) {
        this.tV = z2;
    }

    public void IlO(boolean z2) {
        this.EO = z2;
    }

    public void IlO(com.bytedance.sdk.openadsdk.core.lEW.DmF dmF, com.bytedance.sdk.openadsdk.core.lEW.lEW lew) {
        oeT oet;
        if (this.DmF == null || (oet = this.Bc) == null) {
            return;
        }
        this.IlO = IlO(oet);
        dmF.IlO(this.DmF);
        dmF.IlO(this.IlO);
        this.DmF.setClickListener(dmF);
        lew.IlO((View) this.DmF);
        lew.IlO(this.IlO);
        this.DmF.setClickCreativeListener(lew);
    }

    private com.bytedance.sdk.openadsdk.es.IlO.IlO.vCE IlO(oeT oet) {
        if (oet.Jz() == 4) {
            return com.bytedance.sdk.openadsdk.es.IlO.IlO.Bc.IlO(this.vCE, oet, this.lEW);
        }
        return null;
    }

    public void IlO(bWL bwl) {
        MY my = this.DmF;
        if (my == null) {
            return;
        }
        my.setExpressVideoListenerProxy(bwl);
    }

    public void IlO(PAGExpressAdWrapperListener pAGExpressAdWrapperListener) {
        MY my = this.DmF;
        if (my == null) {
            return;
        }
        my.setExpressInteractionListener(pAGExpressAdWrapperListener);
    }

    public JSONObject IlO(JSONObject jSONObject) {
        MY my = this.DmF;
        if (my != null) {
            return my.IlO(jSONObject, this.NV.MY);
        }
        return null;
    }

    public void IlO(int i2, boolean z2) {
        MY my = this.DmF;
        if (my != null) {
            my.IlO(i2, z2, false);
        }
    }

    public void IlO(int i2, String str) {
        MY my = this.DmF;
        if (my != null) {
            my.MY(i2, str);
        }
    }
}
