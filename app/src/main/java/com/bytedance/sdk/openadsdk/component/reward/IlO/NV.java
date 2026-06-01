package com.bytedance.sdk.openadsdk.component.reward.IlO;

import android.app.Activity;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.core.model.OOq;
import com.bytedance.sdk.openadsdk.core.model.oeT;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class NV {
    protected volatile boolean Bc;

    @NonNull
    protected final oeT DmF;
    protected final IlO EV;
    protected final String NV;
    protected boolean bWL;
    protected AtomicBoolean cL = new AtomicBoolean(false);
    protected com.bytedance.sdk.openadsdk.xF.IlO.IlO cl;
    protected boolean ea;
    protected boolean hp;
    protected final Activity lEW;
    protected boolean rp;
    protected FrameLayout zPa;

    public NV(IlO ilO) {
        this.EV = ilO;
        this.lEW = ilO.BS;
        this.NV = ilO.Cc;
        oeT oet = ilO.MY;
        this.DmF = oet;
        this.hp = OOq.Cc(oet);
    }

    private void Bc() {
        int iIRy = this.DmF.IRy();
        if (iIRy == -1) {
            if (OOq.DmF(this.DmF)) {
                com.bytedance.sdk.openadsdk.xF.IlO.IlO ilO = this.cl;
                if (ilO == null || !ilO.Cc()) {
                    this.EV.qz.kBB();
                    return;
                } else {
                    this.EV.es.set(true);
                    this.EV.qz.ea();
                }
            } else {
                this.EV.es.set(true);
                this.EV.qz.ea();
            }
        } else {
            if (iIRy < 0) {
                return;
            }
            this.EV.YA.tV(false);
            if (OOq.DmF(this.DmF)) {
                com.bytedance.sdk.openadsdk.xF.IlO.IlO ilO2 = this.cl;
                if (ilO2 == null || !ilO2.Cc()) {
                    this.EV.HSR.sendEmptyMessageDelayed(1, iIRy);
                    return;
                }
                this.EV.HSR.sendEmptyMessageDelayed(600, iIRy);
            } else {
                this.EV.HSR.sendEmptyMessageDelayed(600, iIRy);
            }
        }
        com.bytedance.sdk.openadsdk.utils.bWL bwl = this.EV.ts;
        if (bwl != null) {
            bwl.IlO(iIRy);
        }
    }

    public void Cc() {
        com.bytedance.sdk.openadsdk.xF.IlO.IlO ilO;
        if (!this.hp || this.cL.get() || (ilO = this.cl) == null) {
            return;
        }
        ilO.EO();
    }

    public boolean DmF() {
        return false;
    }

    public void EO() {
        if (this.hp) {
            this.Bc = true;
            EO(this.EV.uvo);
            this.cl.IlO();
            Bc();
            if (OOq.NV(this.DmF)) {
                this.EV.lMM.vCE();
            }
        }
    }

    public void EV() {
        if (!this.cL.compareAndSet(false, true)) {
            this.EV.lMM.DmF();
            return;
        }
        com.bytedance.sdk.openadsdk.xF.IlO.IlO ilO = this.cl;
        if (ilO != null) {
            ilO.IlO(true);
        }
        this.EV.lMM.Bc(true);
        IlO ilO2 = this.EV;
        ilO2.mmj.IlO(true, ilO2.qz);
        if (this.EV.mmj.Bc()) {
            this.EV.ts.IlO(r0.lEW);
            return;
        }
        IlO ilO3 = this.EV;
        ilO3.lMM.IlO(ilO3.uvo, true);
        this.EV.lMM.EO(true);
        this.EV.lMM.MY(true);
        this.EV.HSR.removeMessages(600);
    }

    public void IlO(int i2) {
    }

    public void MY(boolean z2) {
        if (this.hp) {
            IlO ilO = this.EV;
            if (ilO.AK) {
                this.zPa = (FrameLayout) ilO.zLG.findViewById(com.bytedance.sdk.openadsdk.utils.zPa.bYL);
                IlO(z2);
            }
        }
    }

    public boolean NV() {
        return this.Bc;
    }

    public void tV() {
        com.bytedance.sdk.openadsdk.xF.IlO.IlO ilO;
        if (!this.hp || this.cL.get() || (ilO = this.cl) == null) {
            return;
        }
        ilO.MY();
    }

    public void vCE() {
        if (this.hp && !this.ea) {
            this.ea = true;
            com.bytedance.sdk.openadsdk.xF.IlO.IlO ilO = this.cl;
            if (ilO != null) {
                ilO.tV();
            }
            FrameLayout frameLayout = this.zPa;
            if (frameLayout != null) {
                frameLayout.setVisibility(8);
            }
        }
    }

    public void IlO(long j) {
    }

    public void IlO() {
        if (this.hp && !this.rp) {
            this.rp = true;
        }
    }

    public com.bytedance.sdk.openadsdk.rp.vCE MY() {
        return new com.bytedance.sdk.openadsdk.rp.vCE() { // from class: com.bytedance.sdk.openadsdk.component.reward.IlO.NV.1
            @Override // com.bytedance.sdk.openadsdk.rp.vCE
            public void IlO() {
                NV.this.EV.ssS.IlO(false);
            }
        };
    }

    public void IlO(boolean z2) {
        FrameLayout frameLayout = this.zPa;
        if (frameLayout != null) {
            IlO ilO = this.EV;
            com.bytedance.sdk.openadsdk.xF.IlO.IlO ilO2 = new com.bytedance.sdk.openadsdk.xF.IlO.IlO(ilO.gQ, this.DmF, ilO.fdM, z2, frameLayout);
            this.cl = ilO2;
            ilO2.IlO(this.EV.ssS);
            this.cl.IlO(true, MY());
        }
    }

    public void EO(boolean z2) {
        if (this.hp && this.cl != null && this.Bc) {
            this.cl.IlO(z2);
        }
    }

    public void IlO(com.bytedance.sdk.openadsdk.core.MY.Cc cc) {
        com.bytedance.sdk.openadsdk.xF.IlO.IlO ilO;
        if (this.hp && (ilO = this.cl) != null) {
            ilO.IlO(cc);
        }
    }

    public void lEW() {
    }
}
