package com.bytedance.sdk.openadsdk.component.reward.MY;

import android.widget.FrameLayout;
import com.bytedance.sdk.openadsdk.core.model.OOq;
import com.bytedance.sdk.openadsdk.core.model.oeT;
import com.bytedance.sdk.openadsdk.utils.DeviceUtils;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class NV extends MY {
    public NV(com.bytedance.sdk.openadsdk.component.reward.IlO.IlO ilO) {
        super(ilO);
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.MY.MY
    public void AXM() {
        super.AXM();
        if (OOq.cL(this.IlO.MY)) {
            this.NV.removeMessages(600);
            this.IlO.pP.EO("go_background");
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.MY.MY
    public boolean Cc() {
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.MY.MY
    public void IlO(FrameLayout frameLayout) {
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.MY.MY
    public void cl() {
        if (OOq.lEW(this.MY) && this.IlO.lMM.zLG() && !this.IlO.lMM.gQ()) {
            cL();
        }
        if (OOq.Bc(this.IlO.MY)) {
            if (DeviceUtils.Bc() == 0) {
                this.IlO.uvo = true;
            }
            com.bytedance.sdk.openadsdk.component.reward.IlO.IlO ilO = this.IlO;
            if (ilO.uvo) {
                ilO.YA.MY(true);
                this.IlO.pP.Cc(true);
            }
        }
        this.IlO.ts.IlO();
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.MY.MY
    public void es() {
        if (this.IlO.pP.lEW(com.bytedance.sdk.openadsdk.component.reward.IlO.lEW.EO) && OOq.cL(this.IlO.MY)) {
            this.IlO.pP.EO("return_foreground");
            com.bytedance.sdk.openadsdk.core.widget.MY my = this.hp;
            if ((my == null || !my.isShowing()) && this.IlO.pP.MY() >= 0.0f) {
                this.IlO.pP.Cc(0);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.MY.MY
    public boolean vCE() {
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.MY.MY
    public void xF() {
        super.xF();
        if (OOq.cL(this.IlO.MY)) {
            this.NV.removeMessages(600);
            this.IlO.pP.EO("go_background");
        }
    }

    public static boolean IlO(oeT oet) {
        return OOq.Bc(oet) || OOq.cL(oet);
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.MY.MY
    public void Bc() {
    }
}
