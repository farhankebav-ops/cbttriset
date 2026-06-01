package com.bytedance.sdk.openadsdk.component.reward.MY;

import android.widget.FrameLayout;
import com.bytedance.sdk.openadsdk.component.reward.MY.MY;
import com.bytedance.sdk.openadsdk.core.model.oeT;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class DmF extends MY {
    private com.bytedance.sdk.openadsdk.component.reward.view.IlO ea;

    public DmF(com.bytedance.sdk.openadsdk.component.reward.IlO.IlO ilO) {
        super(ilO);
    }

    private boolean vSq() {
        return oeT.Cc(this.MY);
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.MY.MY
    public void Bc() {
        this.vCE.EO(8);
        this.vCE.MY(8);
        if (this.MY.oc() == 2) {
            this.lEW.IlO(false);
            this.lEW.EO(false);
            this.lEW.tV(false);
            this.vCE.Cc(8);
            return;
        }
        this.lEW.IlO(this.MY.uF());
        this.lEW.EO(vSq());
        this.lEW.tV(vSq());
        if (vSq()) {
            this.vCE.Cc(8);
        } else {
            this.lEW.Cc();
            this.vCE.Cc(0);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.MY.MY
    public boolean Cc() {
        return vSq();
    }

    public FrameLayout oc() {
        com.bytedance.sdk.openadsdk.component.reward.view.IlO ilO = this.ea;
        if (ilO != null) {
            return ilO.getVideoContainer();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.MY.MY
    public MY.IlO tV() {
        return new MY.IlO() { // from class: com.bytedance.sdk.openadsdk.component.reward.MY.DmF.1
            @Override // com.bytedance.sdk.openadsdk.component.reward.MY.MY.IlO
            public void IlO(boolean z2) {
                if (DmF.this.ea != null) {
                    DmF.this.ea.setIsMute(z2);
                }
            }
        };
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.MY.MY
    public boolean vCE() {
        return vSq();
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.MY.MY
    public void IlO(FrameLayout frameLayout) {
        com.bytedance.sdk.openadsdk.component.reward.view.IlO ilO = new com.bytedance.sdk.openadsdk.component.reward.view.IlO(this.IlO.BS, this.EV);
        this.ea = ilO;
        ilO.setDownloadListener(this.rp);
        com.bytedance.sdk.openadsdk.component.reward.view.IlO ilO2 = this.ea;
        oeT oet = this.MY;
        com.bytedance.sdk.openadsdk.component.reward.IlO.IlO ilO3 = this.IlO;
        ilO2.IlO(oet, ilO3.hL, ilO3.fdM, this.EO, this.tV);
        frameLayout.addView(this.ea.getInteractionStyleRootView());
    }

    public static boolean IlO(oeT oet) {
        return (oet.EJ() || oet.La() == 100.0f) ? false : true;
    }
}
