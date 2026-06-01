package com.bytedance.sdk.openadsdk.component.reward.IlO;

import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import com.bytedance.sdk.openadsdk.core.model.OOq;
import com.bytedance.sdk.openadsdk.core.model.oeT;
import com.bytedance.sdk.openadsdk.core.vSq;
import com.bytedance.sdk.openadsdk.tV.MY;
import com.bytedance.sdk.openadsdk.utils.BS;
import com.bytedance.sdk.openadsdk.utils.vAh;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class Cc {
    private IlO EO;
    private final com.bytedance.sdk.openadsdk.component.reward.IlO.IlO IlO;
    private final com.bytedance.sdk.openadsdk.component.reward.view.vCE MY;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface IlO {
        void IlO(boolean z2, boolean z7, boolean z8, com.bytedance.sdk.openadsdk.component.reward.MY.MY my, int i2);

        void zPa();
    }

    public Cc(com.bytedance.sdk.openadsdk.component.reward.IlO.IlO ilO) {
        this.IlO = ilO;
        this.MY = new com.bytedance.sdk.openadsdk.component.reward.view.vCE(ilO);
    }

    private void DmF() {
        if (OOq.es(this.IlO.MY)) {
            com.bytedance.sdk.openadsdk.component.reward.IlO.IlO ilO = this.IlO;
            if (ilO.uvo) {
                ilO.YA.MY(true);
                this.IlO.pP.Cc(true);
            }
        }
    }

    private int lEW() {
        int iBC = this.IlO.MY.BC();
        if (iBC <= 5000 && iBC >= 0) {
            if (iBC < 1000) {
                iBC += 1000;
            }
            int iIlO = com.bytedance.sdk.openadsdk.core.cl.tV().IlO(this.IlO.MY.hFV());
            if (iIlO <= 5000 && iIlO >= 0) {
                if (iIlO < 1000) {
                    iIlO += 1000;
                }
                return Math.min(iBC, iIlO);
            }
        }
        return -1;
    }

    public boolean Bc() {
        return this.MY.vCE();
    }

    public boolean Cc() {
        com.bytedance.sdk.openadsdk.component.reward.view.vCE vce = this.MY;
        if (vce != null) {
            return vce.Cc();
        }
        return false;
    }

    public boolean EO(com.bytedance.sdk.openadsdk.component.reward.MY.MY my) {
        boolean z2;
        com.bytedance.sdk.openadsdk.activity.vCE vce;
        this.IlO.lEW = lEW();
        com.bytedance.sdk.openadsdk.component.reward.IlO.IlO ilO = this.IlO;
        int i2 = ilO.lEW;
        if (ilO.MY.EV()) {
            return false;
        }
        com.bytedance.sdk.openadsdk.component.reward.IlO.IlO ilO2 = this.IlO;
        int i8 = ilO2.lEW;
        if (i8 == -1) {
            if (OOq.lEW(ilO2.MY) && this.IlO.lMM.cL()) {
                my.kBB();
            } else if (OOq.NV(this.IlO.MY) && this.IlO.lMM.cL()) {
                my.kBB();
            } else {
                my.ea();
                z2 = true;
            }
            z2 = false;
        } else {
            if (i8 >= 0) {
                ilO2.AXM.set(false);
                Message messageObtain = Message.obtain();
                messageObtain.what = 700;
                com.bytedance.sdk.openadsdk.component.reward.IlO.IlO ilO3 = this.IlO;
                messageObtain.arg1 = ilO3.lEW;
                ilO3.HSR.sendMessage(messageObtain);
                if (!OOq.DmF(this.IlO.MY)) {
                    z2 = true;
                }
            }
            z2 = false;
        }
        if (this.IlO.lMM.tl() ? false : z2) {
            com.bytedance.sdk.openadsdk.component.reward.IlO.IlO ilO4 = this.IlO;
            if (ilO4.ts == null || !(!ilO4.tV() || (vce = this.IlO.ED) == null || vce.kBB())) {
                return true;
            }
            this.IlO.ts.IlO(r6.lEW);
        }
        return true;
    }

    public void IlO() {
        this.MY.IlO();
    }

    public void MY() {
        this.MY.EO();
    }

    public void tV() {
        IlO(true);
    }

    public IlO vCE() {
        return this.EO;
    }

    public void IlO(com.bytedance.sdk.openadsdk.core.MY.Cc cc) {
        this.MY.IlO(cc);
    }

    public void MY(com.bytedance.sdk.openadsdk.component.reward.MY.MY my) {
        int iIRy = this.IlO.MY.IRy();
        if (OOq.cL(this.IlO.MY)) {
            iIRy = (this.IlO.MY.XvI() + 1) * 1000;
        }
        if (iIRy == -1) {
            if (OOq.lEW(this.IlO.MY)) {
                if (OOq.vAh(this.IlO.MY) && this.IlO.pP.Bc()) {
                    my.ea();
                    return;
                } else {
                    my.kBB();
                    return;
                }
            }
            my.ea();
        } else {
            if (iIRy < 0) {
                return;
            }
            this.IlO.YA.tV(false);
            if (!OOq.lEW(this.IlO.MY)) {
                this.IlO.HSR.sendEmptyMessageDelayed(600, iIRy);
            } else {
                if (!OOq.vAh(this.IlO.MY) || !this.IlO.pP.Bc()) {
                    this.IlO.HSR.sendEmptyMessageDelayed(1, iIRy);
                    return;
                }
                this.IlO.HSR.sendEmptyMessageDelayed(600, iIRy);
            }
        }
        com.bytedance.sdk.openadsdk.utils.bWL bwl = this.IlO.ts;
        if (bwl != null) {
            bwl.IlO(iIRy);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:67:0x012d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void IlO(boolean r10, boolean r11, boolean r12, com.bytedance.sdk.openadsdk.component.reward.MY.MY r13, int r14) {
        /*
            Method dump skipped, instruction units count: 520
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.component.reward.IlO.Cc.IlO(boolean, boolean, boolean, com.bytedance.sdk.openadsdk.component.reward.MY.MY, int):void");
    }

    private boolean MY(boolean z2) {
        com.bytedance.sdk.openadsdk.component.reward.view.MY myIlO;
        if (!com.bytedance.sdk.openadsdk.core.model.es.EO(this.IlO.MY) || (myIlO = this.IlO.tl.IlO()) == null || myIlO.tV != 0 || z2) {
            return true;
        }
        this.IlO.YA.EO(false);
        return false;
    }

    public void EO() {
        this.MY.tV();
    }

    public void IlO(boolean z2, com.bytedance.sdk.openadsdk.component.reward.MY.MY my) {
        ea eaVar;
        if (OOq.cL(this.IlO.MY)) {
            return;
        }
        this.IlO.cL.set(z2);
        my.bWL();
        if (this.IlO.MY.xJ()) {
            this.IlO.YA.tV(false);
        } else {
            com.bytedance.sdk.openadsdk.component.reward.IlO.IlO ilO = this.IlO;
            ilO.YA.tV(OOq.cL(ilO.MY));
        }
        com.bytedance.sdk.openadsdk.component.reward.IlO.IlO ilO2 = this.IlO;
        ilO2.YA.EO(OOq.Bc(ilO2.MY));
        if (this.IlO.MY.vCE() && OOq.Bc(this.IlO.MY) && z2) {
            this.IlO.YA.tV(true);
        }
        this.IlO.lMM.oc();
        com.bytedance.sdk.openadsdk.core.model.es esVar = this.IlO.DM.ea;
        if (esVar != null) {
            esVar.Cc();
        }
        this.IlO.DM.EO();
        com.bytedance.sdk.openadsdk.component.reward.view.lEW lew = this.IlO.tl;
        if (lew != null) {
            lew.vCE();
        }
        lEW lew2 = this.IlO.pP;
        if (lew2 != null) {
            lew2.Bc(lEW.MY);
        }
        com.bytedance.sdk.openadsdk.component.reward.IlO.IlO ilO3 = this.IlO;
        if (!TextUtils.isEmpty(oeT.IlO(ilO3.gQ, ilO3.MY))) {
            com.bytedance.sdk.openadsdk.component.reward.IlO.IlO ilO4 = this.IlO;
            vAh.IlO(ilO4.BS, OOq.hp(ilO4.MY), this.IlO.MY, MY.IlO.EO);
            return;
        }
        if (oeT.EO(this.IlO.MY) && (eaVar = this.IlO.nvX) != null) {
            eaVar.vCE();
        }
        if (!oeT.IlO(this.IlO.MY) && (oeT.EO(this.IlO.MY) || !this.IlO.lMM.BS())) {
            com.bytedance.sdk.openadsdk.component.reward.IlO.IlO ilO5 = this.IlO;
            if (oeT.IlO(ilO5.MY, ilO5.lMM.cL(), this.IlO.lMM.HSR(), this.IlO.nvX.rp(), this.IlO.lMM.vSq()) || OOq.Bc(this.IlO.MY)) {
                if (!oeT.tV(this.IlO.MY) && !OOq.Bc(this.IlO.MY) && !oeT.EO(this.IlO.MY)) {
                    this.IlO.lMM.IlO(true, 0, (String) null);
                }
                if (OOq.Bc(this.IlO.MY)) {
                    if (OOq.vAh(this.IlO.MY) && !this.IlO.lMM.DM()) {
                        if (!this.IlO.lMM.cL()) {
                            if (this.IlO.pP.tV() != null) {
                                this.IlO.pP.tV().IlO(2);
                            }
                            this.IlO.pP.Cc();
                            return;
                        } else {
                            if (this.IlO.pP.tV() != null) {
                                this.IlO.pP.tV().IlO(-1);
                            }
                            this.IlO.pP.vCE();
                            this.IlO.YA.tV(false);
                            com.bytedance.sdk.openadsdk.component.reward.IlO.IlO ilO6 = this.IlO;
                            ilO6.pP.IlO(ilO6.wPn.Cc());
                            return;
                        }
                    }
                    if (this.IlO.lMM.DM() && this.IlO.pP.tV() != null) {
                        this.IlO.pP.tV().IlO(1);
                    }
                    MY(my);
                } else {
                    EO(my);
                }
                IlO(my);
                return;
            }
        }
        tV();
    }

    public void IlO(com.bytedance.sdk.openadsdk.component.reward.MY.MY my) {
        this.IlO.lMM.IlO(0.0f);
        this.IlO.DM.IlO(0.0f);
        if (!oeT.EO(this.IlO.MY)) {
            this.IlO.nvX.IlO(8);
            this.IlO.lMM.IlO(0);
            this.IlO.lMM.ssS();
        } else {
            this.IlO.lMM.IlO(8);
            this.IlO.nvX.IlO(0);
            this.IlO.nvX.Bc();
        }
        if (this.IlO.Bc) {
            BS.IlO((View) my.bWL, 0);
            this.IlO.DM.Cc(8);
        }
        this.IlO.DM.EO(8);
        this.IlO.DM.Bc();
        if (oeT.EO(this.IlO.MY)) {
            this.IlO.HSR.sendEmptyMessageDelayed(800, 100L);
            return;
        }
        this.IlO.HSR.sendEmptyMessageDelayed(500, 100L);
        com.bytedance.sdk.openadsdk.component.reward.IlO.IlO ilO = this.IlO;
        ilO.lMM.IlO(ilO.uvo, true);
        this.IlO.lMM.EO(true);
        this.IlO.lMM.MY(true);
        vSq vsqRp = this.IlO.lMM.rp();
        if (vsqRp != null) {
            vsqRp.IlO("prerender_page_show", (JSONObject) null);
        }
    }

    public void IlO(boolean z2) {
        if (!oeT.tV(this.IlO.MY)) {
            this.IlO.lMM.IlO(false, 408, "end_card_timeout");
        }
        this.IlO.lMM.dY();
        this.IlO.lMM.IlO(8);
        this.IlO.nvX.IlO(8);
        com.bytedance.sdk.openadsdk.component.reward.IlO.IlO ilO = this.IlO;
        if (ilO.Bc) {
            BS.IlO((View) ilO.qz.bWL, 8);
            this.IlO.DM.Cc(0);
        }
        this.IlO.DM.EO(8);
        if (this.IlO.MY.xJ()) {
            if (!this.MY.IlO(this.IlO.vAh)) {
                this.IlO.BS.finish();
            }
        } else {
            com.bytedance.sdk.openadsdk.activity.vCE vce = this.IlO.ED;
            if (vce != null) {
                this.MY.IlO(vce.pP().DmF());
            }
            this.MY.MY();
        }
        this.IlO.DM.Bc();
        if (z2) {
            EO(this.IlO.qz);
        }
        this.IlO.YA.EO(false);
        com.bytedance.sdk.openadsdk.component.reward.IlO.IlO ilO2 = this.IlO;
        ilO2.wPn.IlO(ilO2.MY.EJ());
    }

    public void IlO(IlO ilO) {
        this.EO = ilO;
    }
}
