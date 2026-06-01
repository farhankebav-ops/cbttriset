package com.bytedance.sdk.openadsdk.component.reward.MY;

import android.widget.FrameLayout;
import com.bytedance.sdk.component.utils.vSq;
import com.bytedance.sdk.openadsdk.component.reward.IlO.bWL;
import com.bytedance.sdk.openadsdk.component.reward.IlO.cl;
import com.bytedance.sdk.openadsdk.component.reward.IlO.es;
import com.bytedance.sdk.openadsdk.core.model.OOq;
import com.bytedance.sdk.openadsdk.core.model.oeT;
import com.bytedance.sdk.openadsdk.utils.DeviceUtils;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class IlO {
    protected final es Bc;
    protected final cl Cc;
    protected com.bytedance.sdk.openadsdk.core.rp.tV.MY DmF;
    protected int EO;
    protected com.bytedance.sdk.openadsdk.component.reward.IlO.IlO IlO;
    protected oeT MY;
    protected vSq NV;
    protected final bWL lEW;
    protected int tV;
    protected final com.bytedance.sdk.openadsdk.component.reward.view.NV vCE;

    public IlO(com.bytedance.sdk.openadsdk.component.reward.IlO.IlO ilO) {
        this.IlO = ilO;
        this.MY = ilO.MY;
        this.EO = ilO.Jz;
        this.tV = ilO.wD;
        this.Cc = ilO.vAh;
        this.vCE = ilO.DM;
        this.Bc = ilO.lMM;
        this.lEW = ilO.YA;
    }

    public void EO() {
        if (OOq.MY(this.IlO.MY) && DeviceUtils.Bc() == 0) {
            this.IlO.uvo = true;
        }
        com.bytedance.sdk.openadsdk.component.reward.IlO.IlO ilO = this.IlO;
        ilO.YA.MY(ilO.uvo);
    }

    public void IlO(com.bytedance.sdk.openadsdk.core.rp.tV.MY my, vSq vsq) {
        this.DmF = my;
        this.NV = vsq;
    }

    public boolean MY() {
        if (!com.bytedance.sdk.openadsdk.core.model.es.MY(this.IlO.MY) || !this.IlO.es.get()) {
            return (this.IlO.NV.get() || this.IlO.EV.get() || OOq.cL(this.IlO.MY)) ? false : true;
        }
        FrameLayout frameLayoutVCE = this.IlO.DM.vCE();
        frameLayoutVCE.setVisibility(4);
        frameLayoutVCE.setVisibility(0);
        return false;
    }

    public boolean IlO() {
        return this.IlO.MY.xJ() || this.IlO.MY.uI() == 15 || this.IlO.MY.uI() == 5 || this.IlO.MY.uI() == 50;
    }

    public void IlO(boolean z2) {
        if (this.IlO.NV.get()) {
            return;
        }
        oeT oet = this.MY;
        if (oet != null && oet.pS()) {
            this.lEW.EO(false);
            this.lEW.IlO(true);
            this.IlO.DM.MY(8);
            this.IlO.DM.EO(8);
            return;
        }
        if (!z2) {
            this.lEW.EO(false);
            this.lEW.IlO(false);
            this.lEW.tV(false);
            this.IlO.DM.Cc(8);
        } else {
            this.lEW.IlO(this.IlO.MY.uF());
            if (OOq.cL(this.IlO.MY) || IlO()) {
                this.lEW.EO(true);
            }
            if (!IlO() && (!(this instanceof lEW) || !this.IlO.MY.vCE())) {
                this.lEW.Cc();
                this.IlO.DM.Cc(0);
            } else {
                this.lEW.tV(true);
            }
        }
        if (z2) {
            com.bytedance.sdk.openadsdk.component.reward.IlO.IlO ilO = this.IlO;
            if (ilO.hL != com.bytedance.sdk.openadsdk.component.reward.view.MY.IlO) {
                ilO.DM.MY(8);
                this.IlO.DM.EO(8);
                return;
            } else {
                ilO.DM.MY(0);
                this.IlO.DM.EO(0);
                return;
            }
        }
        this.IlO.DM.MY(4);
        this.IlO.DM.EO(8);
    }
}
