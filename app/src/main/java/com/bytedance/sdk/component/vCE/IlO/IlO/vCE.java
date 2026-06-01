package com.bytedance.sdk.component.vCE.IlO.IlO;

import com.bytedance.sdk.component.vCE.IlO.IlO.MY.Bc;
import com.bytedance.sdk.component.vCE.IlO.lEW;
import java.util.List;
import java.util.Queue;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class vCE implements tV {
    private com.bytedance.sdk.component.vCE.IlO.IlO.MY.vCE Bc;
    private Bc Cc;
    private com.bytedance.sdk.component.vCE.IlO.tV.MY.IlO DmF;
    private com.bytedance.sdk.component.vCE.IlO.IlO.MY.IlO EO;
    private com.bytedance.sdk.component.vCE.IlO.tV.MY.IlO EV;
    Cc IlO = lEW.Bc().tV();
    private com.bytedance.sdk.component.vCE.IlO.IlO.MY.Cc MY;
    private com.bytedance.sdk.component.vCE.IlO.tV.MY.IlO NV;
    private Queue<String> bWL;
    private com.bytedance.sdk.component.vCE.IlO.tV.MY.IlO hp;
    private com.bytedance.sdk.component.vCE.IlO.tV.MY.IlO lEW;
    private com.bytedance.sdk.component.vCE.IlO.tV.MY.IlO rp;
    private com.bytedance.sdk.component.vCE.IlO.IlO.MY.MY tV;
    private com.bytedance.sdk.component.vCE.IlO.IlO.MY.EO vCE;

    public vCE(Queue<String> queue) {
        this.bWL = queue;
        if (com.bytedance.sdk.component.vCE.IlO.MY.IlO.IlO()) {
            com.bytedance.sdk.component.vCE.IlO.tV.MY.IlO ilORp = lEW.Bc().rp();
            this.lEW = ilORp;
            this.MY = new com.bytedance.sdk.component.vCE.IlO.IlO.MY.Cc(ilORp, queue);
        }
        if (com.bytedance.sdk.component.vCE.IlO.MY.IlO.Cc()) {
            if (lEW.Bc().NV() != null) {
                this.NV = lEW.Bc().NV();
            } else {
                this.NV = lEW.Bc().hp();
            }
            this.tV = new com.bytedance.sdk.component.vCE.IlO.IlO.MY.MY(this.NV, queue);
        }
        if (com.bytedance.sdk.component.vCE.IlO.MY.IlO.MY()) {
            com.bytedance.sdk.component.vCE.IlO.tV.MY.IlO ilOHp = lEW.Bc().hp();
            this.DmF = ilOHp;
            this.EO = new com.bytedance.sdk.component.vCE.IlO.IlO.MY.IlO(ilOHp, queue);
        }
        if (com.bytedance.sdk.component.vCE.IlO.MY.IlO.EO()) {
            com.bytedance.sdk.component.vCE.IlO.tV.MY.IlO ilOHp2 = lEW.Bc().hp();
            this.EV = ilOHp2;
            this.Cc = new Bc(ilOHp2, queue);
        }
        if (com.bytedance.sdk.component.vCE.IlO.MY.IlO.tV()) {
            com.bytedance.sdk.component.vCE.IlO.tV.MY.IlO ilOBWL = lEW.Bc().bWL();
            this.rp = ilOBWL;
            this.vCE = new com.bytedance.sdk.component.vCE.IlO.IlO.MY.EO(ilOBWL, queue);
        }
        if (com.bytedance.sdk.component.vCE.IlO.MY.IlO.vCE()) {
            com.bytedance.sdk.component.vCE.IlO.tV.MY.IlO ilOEa = lEW.Bc().ea();
            this.hp = ilOEa;
            this.Bc = new com.bytedance.sdk.component.vCE.IlO.IlO.MY.vCE(ilOEa, queue);
        }
    }

    @Override // com.bytedance.sdk.component.vCE.IlO.IlO.tV
    public void IlO(int i2, long j) {
    }

    @Override // com.bytedance.sdk.component.vCE.IlO.IlO.tV
    public void IlO(com.bytedance.sdk.component.vCE.IlO.tV.IlO ilO, int i2) {
        try {
            byte bTV = ilO.tV();
            byte bCc = ilO.Cc();
            if (bTV == 0 && bCc == 1 && com.bytedance.sdk.component.vCE.IlO.MY.IlO.IlO()) {
                this.MY.IlO(ilO);
                return;
            }
            if (bTV == 3 && bCc == 2 && com.bytedance.sdk.component.vCE.IlO.MY.IlO.Cc()) {
                this.tV.IlO(ilO);
                return;
            }
            if (bTV == 0 && bCc == 2 && com.bytedance.sdk.component.vCE.IlO.MY.IlO.MY()) {
                this.EO.IlO(ilO);
                return;
            }
            if (bTV == 1 && bCc == 2 && com.bytedance.sdk.component.vCE.IlO.MY.IlO.EO()) {
                this.Cc.IlO(ilO);
                return;
            }
            if (bTV == 1 && bCc == 3 && com.bytedance.sdk.component.vCE.IlO.MY.IlO.tV()) {
                this.vCE.IlO(ilO);
            } else if (bTV == 2 && bCc == 3 && com.bytedance.sdk.component.vCE.IlO.MY.IlO.vCE()) {
                this.Bc.IlO(ilO);
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.bytedance.sdk.component.vCE.IlO.IlO.tV
    public void IlO(int i2, List<com.bytedance.sdk.component.vCE.IlO.tV.IlO> list) {
        if (list == null || list.size() == 0 || list.get(0) == null) {
            return;
        }
        com.bytedance.sdk.component.vCE.IlO.tV.IlO ilO = list.get(0);
        byte bCc = ilO.Cc();
        byte bTV = ilO.tV();
        if (bTV == 0 && bCc == 1 && com.bytedance.sdk.component.vCE.IlO.MY.IlO.IlO()) {
            this.MY.IlO(i2, list);
            return;
        }
        if (bTV == 3 && bCc == 2 && com.bytedance.sdk.component.vCE.IlO.MY.IlO.Cc()) {
            this.tV.IlO(i2, list);
            return;
        }
        if (bTV == 0 && bCc == 2 && com.bytedance.sdk.component.vCE.IlO.MY.IlO.MY()) {
            this.EO.IlO(i2, list);
            return;
        }
        if (bTV == 1 && bCc == 2 && com.bytedance.sdk.component.vCE.IlO.MY.IlO.EO()) {
            this.Cc.IlO(i2, list);
            return;
        }
        if (bTV == 1 && bCc == 3 && com.bytedance.sdk.component.vCE.IlO.MY.IlO.tV()) {
            this.vCE.IlO(i2, list);
        } else if (bTV == 2 && bCc == 3 && com.bytedance.sdk.component.vCE.IlO.MY.IlO.vCE()) {
            this.Bc.IlO(i2, list);
        }
    }

    @Override // com.bytedance.sdk.component.vCE.IlO.IlO.tV
    public List<com.bytedance.sdk.component.vCE.IlO.tV.IlO> IlO(int i2, int i8, List<String> list) {
        List<com.bytedance.sdk.component.vCE.IlO.tV.IlO> listIlO;
        List<com.bytedance.sdk.component.vCE.IlO.tV.IlO> listIlO2;
        List<com.bytedance.sdk.component.vCE.IlO.tV.IlO> listIlO3;
        List<com.bytedance.sdk.component.vCE.IlO.tV.IlO> listIlO4;
        List<com.bytedance.sdk.component.vCE.IlO.tV.IlO> listIlO5;
        List<com.bytedance.sdk.component.vCE.IlO.tV.IlO> listIlO6;
        if (com.bytedance.sdk.component.vCE.IlO.MY.IlO.IlO() && this.MY.MY(i2, i8) && (listIlO6 = this.MY.IlO(i2, i8)) != null && listIlO6.size() != 0) {
            com.bytedance.sdk.component.vCE.IlO.EO.MY.IlO(com.bytedance.sdk.component.vCE.IlO.MY.tV.tV.cL(), 1);
            return listIlO6;
        }
        if (com.bytedance.sdk.component.vCE.IlO.MY.IlO.Cc() && this.tV.MY(i2, i8) && (listIlO5 = this.tV.IlO(i2, i8)) != null && listIlO5.size() != 0) {
            return listIlO5;
        }
        if (com.bytedance.sdk.component.vCE.IlO.MY.IlO.MY() && this.EO.MY(i2, i8) && (listIlO4 = this.EO.IlO(i2, i8)) != null && listIlO4.size() != 0) {
            com.bytedance.sdk.component.vCE.IlO.EO.MY.IlO(com.bytedance.sdk.component.vCE.IlO.MY.tV.tV.es(), 1);
            return listIlO4;
        }
        if (com.bytedance.sdk.component.vCE.IlO.MY.IlO.EO() && this.Cc.MY(i2, i8) && (listIlO3 = this.Cc.IlO(i2, i8)) != null && listIlO3.size() != 0) {
            com.bytedance.sdk.component.vCE.IlO.EO.MY.IlO(com.bytedance.sdk.component.vCE.IlO.MY.tV.tV.xF(), 1);
            return listIlO3;
        }
        if (com.bytedance.sdk.component.vCE.IlO.MY.IlO.tV() && this.vCE.MY(i2, i8) && (listIlO2 = this.vCE.IlO(i2, i8)) != null && listIlO2.size() != 0) {
            com.bytedance.sdk.component.vCE.IlO.EO.MY.IlO(com.bytedance.sdk.component.vCE.IlO.MY.tV.tV.AXM(), 1);
            return listIlO2;
        }
        if (!com.bytedance.sdk.component.vCE.IlO.MY.IlO.vCE() || !this.Bc.MY(i2, i8) || (listIlO = this.Bc.IlO(i2, i8)) == null || listIlO.size() == 0) {
            return null;
        }
        return listIlO;
    }

    @Override // com.bytedance.sdk.component.vCE.IlO.IlO.tV
    public boolean IlO(int i2, boolean z2) {
        com.bytedance.sdk.component.vCE.IlO.IlO.MY.vCE vce;
        com.bytedance.sdk.component.vCE.IlO.tV.MY.IlO ilO;
        com.bytedance.sdk.component.vCE.IlO.IlO.MY.EO eo;
        com.bytedance.sdk.component.vCE.IlO.tV.MY.IlO ilO2;
        Bc bc;
        com.bytedance.sdk.component.vCE.IlO.tV.MY.IlO ilO3;
        com.bytedance.sdk.component.vCE.IlO.IlO.MY.IlO ilO4;
        com.bytedance.sdk.component.vCE.IlO.tV.MY.IlO ilO5;
        com.bytedance.sdk.component.vCE.IlO.IlO.MY.MY my;
        com.bytedance.sdk.component.vCE.IlO.tV.MY.IlO ilO6;
        com.bytedance.sdk.component.vCE.IlO.IlO.MY.Cc cc;
        com.bytedance.sdk.component.vCE.IlO.tV.MY.IlO ilO7;
        if (com.bytedance.sdk.component.vCE.IlO.MY.IlO.IlO() && (cc = this.MY) != null && (ilO7 = this.lEW) != null && cc.MY(i2, ilO7.IlO())) {
            return true;
        }
        if (com.bytedance.sdk.component.vCE.IlO.MY.IlO.Cc() && (my = this.tV) != null && (ilO6 = this.NV) != null && my.MY(i2, ilO6.IlO())) {
            return true;
        }
        if (com.bytedance.sdk.component.vCE.IlO.MY.IlO.MY() && (ilO4 = this.EO) != null && (ilO5 = this.DmF) != null && ilO4.MY(i2, ilO5.IlO())) {
            return true;
        }
        if (com.bytedance.sdk.component.vCE.IlO.MY.IlO.EO() && (bc = this.Cc) != null && (ilO3 = this.EV) != null && bc.MY(i2, ilO3.IlO())) {
            return true;
        }
        if (!com.bytedance.sdk.component.vCE.IlO.MY.IlO.tV() || (eo = this.vCE) == null || (ilO2 = this.rp) == null || !eo.MY(i2, ilO2.IlO())) {
            return com.bytedance.sdk.component.vCE.IlO.MY.IlO.vCE() && (vce = this.Bc) != null && (ilO = this.hp) != null && vce.MY(i2, ilO.IlO());
        }
        return true;
    }
}
