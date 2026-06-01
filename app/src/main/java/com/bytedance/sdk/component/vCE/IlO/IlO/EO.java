package com.bytedance.sdk.component.vCE.IlO.IlO;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.component.vCE.IlO.IlO.IlO.IlO.Bc;
import com.bytedance.sdk.component.vCE.IlO.lEW;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class EO implements tV {
    private com.bytedance.sdk.component.vCE.IlO.tV.MY.IlO Bc;
    private com.bytedance.sdk.component.vCE.IlO.IlO.IlO.IlO.vCE Cc;
    private com.bytedance.sdk.component.vCE.IlO.tV.MY.IlO DmF;
    private com.bytedance.sdk.component.vCE.IlO.IlO.IlO.IlO.MY EO;
    private com.bytedance.sdk.component.vCE.IlO.tV.MY.IlO EV;
    private com.bytedance.sdk.component.vCE.IlO.IlO.IlO.IlO.tV IlO;
    private com.bytedance.sdk.component.vCE.IlO.IlO.IlO.IlO.IlO MY;
    private com.bytedance.sdk.component.vCE.IlO.tV.MY.IlO NV;
    private com.bytedance.sdk.component.vCE.IlO.tV.MY.IlO lEW;
    private com.bytedance.sdk.component.vCE.IlO.tV.MY.IlO rp;
    private Bc tV;
    private com.bytedance.sdk.component.vCE.IlO.IlO.IlO.IlO.Cc vCE;

    public EO() {
        Context contextVCE = lEW.Bc().vCE();
        if (com.bytedance.sdk.component.vCE.IlO.MY.IlO.IlO()) {
            this.Bc = lEW.Bc().rp();
            this.IlO = new com.bytedance.sdk.component.vCE.IlO.IlO.IlO.IlO.tV(contextVCE, this.Bc);
        }
        if (com.bytedance.sdk.component.vCE.IlO.MY.IlO.Cc()) {
            if (lEW.Bc().NV() != null) {
                this.DmF = lEW.Bc().NV();
            } else {
                this.DmF = lEW.Bc().hp();
            }
            this.EO = new com.bytedance.sdk.component.vCE.IlO.IlO.IlO.IlO.MY(contextVCE, this.DmF);
        }
        if (com.bytedance.sdk.component.vCE.IlO.MY.IlO.MY()) {
            this.lEW = lEW.Bc().hp();
            this.MY = new com.bytedance.sdk.component.vCE.IlO.IlO.IlO.IlO.IlO(contextVCE, this.lEW);
        }
        if (com.bytedance.sdk.component.vCE.IlO.MY.IlO.EO()) {
            this.NV = lEW.Bc().hp();
            this.tV = new Bc(contextVCE, this.NV);
        }
        if (com.bytedance.sdk.component.vCE.IlO.MY.IlO.tV()) {
            this.EV = lEW.Bc().bWL();
            this.Cc = new com.bytedance.sdk.component.vCE.IlO.IlO.IlO.IlO.vCE(contextVCE, this.EV);
        }
        if (com.bytedance.sdk.component.vCE.IlO.MY.IlO.vCE()) {
            this.rp = lEW.Bc().ea();
            this.vCE = new com.bytedance.sdk.component.vCE.IlO.IlO.IlO.IlO.Cc(contextVCE, this.rp);
        }
    }

    @Override // com.bytedance.sdk.component.vCE.IlO.IlO.tV
    public void IlO(com.bytedance.sdk.component.vCE.IlO.tV.IlO ilO, int i2) {
        if (ilO == null) {
            return;
        }
        try {
            ilO.MY(System.currentTimeMillis());
            if (ilO.tV() == 0 && ilO.Cc() == 1) {
                if (com.bytedance.sdk.component.vCE.IlO.MY.IlO.IlO()) {
                    this.IlO.IlO(ilO);
                    return;
                }
                return;
            }
            if (ilO.tV() == 3 && ilO.Cc() == 2) {
                if (com.bytedance.sdk.component.vCE.IlO.MY.IlO.Cc()) {
                    this.EO.IlO(ilO);
                    return;
                }
                return;
            }
            if (ilO.tV() == 0 && ilO.Cc() == 2) {
                if (com.bytedance.sdk.component.vCE.IlO.MY.IlO.MY()) {
                    this.MY.IlO(ilO);
                    return;
                }
                return;
            }
            if (ilO.tV() == 1 && ilO.Cc() == 2) {
                if (com.bytedance.sdk.component.vCE.IlO.MY.IlO.EO()) {
                    this.tV.IlO(ilO);
                }
            } else if (ilO.tV() == 1 && ilO.Cc() == 3) {
                if (com.bytedance.sdk.component.vCE.IlO.MY.IlO.tV()) {
                    this.Cc.IlO(ilO);
                }
            } else if (ilO.tV() == 2 && ilO.Cc() == 3 && com.bytedance.sdk.component.vCE.IlO.MY.IlO.vCE()) {
                this.vCE.IlO(ilO);
            }
        } catch (Throwable unused) {
            com.bytedance.sdk.component.vCE.IlO.EO.MY.IlO(com.bytedance.sdk.component.vCE.IlO.MY.tV.tV.nvX(), 1);
        }
    }

    public List<com.bytedance.sdk.component.vCE.IlO.tV.IlO> MY(com.bytedance.sdk.component.vCE.IlO.tV.IlO ilO, int i2) {
        if (ilO.tV() == 0 && ilO.Cc() == 1 && com.bytedance.sdk.component.vCE.IlO.MY.IlO.IlO()) {
            if (this.Bc.MY() <= i2) {
                return null;
            }
            List<com.bytedance.sdk.component.vCE.IlO.tV.IlO> listIlO = this.IlO.IlO(this.Bc.MY() - i2, "_id");
            if (listIlO != null && listIlO.size() != 0) {
                com.bytedance.sdk.component.vCE.IlO.EO.MY.IlO(com.bytedance.sdk.component.vCE.IlO.MY.tV.tV.OOq(), 1);
            }
            return listIlO;
        }
        if (ilO.tV() == 3 && ilO.Cc() == 2 && com.bytedance.sdk.component.vCE.IlO.MY.IlO.Cc()) {
            if (this.DmF.MY() > i2) {
                return this.EO.IlO(this.DmF.MY() - i2, "_id");
            }
        } else if (ilO.tV() == 0 && ilO.Cc() == 2 && com.bytedance.sdk.component.vCE.IlO.MY.IlO.MY()) {
            if (this.lEW.MY() > i2) {
                List<com.bytedance.sdk.component.vCE.IlO.tV.IlO> listIlO2 = this.MY.IlO(this.lEW.MY() - i2, "_id");
                if (listIlO2 != null && listIlO2.size() != 0) {
                    com.bytedance.sdk.component.vCE.IlO.EO.MY.IlO(com.bytedance.sdk.component.vCE.IlO.MY.tV.tV.wPn(), 1);
                }
                return listIlO2;
            }
        } else if (ilO.tV() == 1 && ilO.Cc() == 2 && com.bytedance.sdk.component.vCE.IlO.MY.IlO.EO()) {
            if (this.NV.MY() > i2) {
                List<com.bytedance.sdk.component.vCE.IlO.tV.IlO> listIlO3 = this.tV.IlO(this.NV.MY() - i2, "_id");
                if (listIlO3 != null && listIlO3.size() != 0) {
                    com.bytedance.sdk.component.vCE.IlO.EO.MY.IlO(com.bytedance.sdk.component.vCE.IlO.MY.tV.tV.oc(), 1);
                }
                return listIlO3;
            }
        } else if (ilO.tV() == 1 && ilO.Cc() == 3 && com.bytedance.sdk.component.vCE.IlO.MY.IlO.tV()) {
            if (this.EV.MY() > i2) {
                List<com.bytedance.sdk.component.vCE.IlO.tV.IlO> listIlO4 = this.Cc.IlO(this.EV.MY() - i2, "_id");
                if (listIlO4 != null && listIlO4.size() != 0) {
                    com.bytedance.sdk.component.vCE.IlO.EO.MY.IlO(com.bytedance.sdk.component.vCE.IlO.MY.tV.tV.vSq(), 1);
                }
                return listIlO4;
            }
        } else if (ilO.tV() == 2 && ilO.Cc() == 3 && com.bytedance.sdk.component.vCE.IlO.MY.IlO.vCE() && this.rp.MY() > i2) {
            return this.vCE.IlO(this.rp.MY() - i2, "_id");
        }
        return null;
    }

    @Override // com.bytedance.sdk.component.vCE.IlO.IlO.tV
    public void IlO(int i2, List<com.bytedance.sdk.component.vCE.IlO.tV.IlO> list) {
        if (list == null || list.size() == 0 || list.get(0) == null) {
            return;
        }
        com.bytedance.sdk.component.vCE.IlO.tV.IlO ilO = list.get(0);
        if (i2 == 200 || i2 == -1) {
            com.bytedance.sdk.component.vCE.IlO.MY.IlO.IlO ilO2 = com.bytedance.sdk.component.vCE.IlO.MY.tV.tV;
            com.bytedance.sdk.component.vCE.IlO.EO.MY.IlO(ilO2.Jz(), list.size());
            if (i2 != 200) {
                com.bytedance.sdk.component.vCE.IlO.EO.MY.IlO(ilO2.nm(), list.size());
            }
            if (ilO.tV() == 0 && ilO.Cc() == 1) {
                if (com.bytedance.sdk.component.vCE.IlO.MY.IlO.IlO()) {
                    this.IlO.MY(list);
                    return;
                }
                return;
            }
            if (ilO.tV() == 3 && ilO.Cc() == 2) {
                if (com.bytedance.sdk.component.vCE.IlO.MY.IlO.Cc()) {
                    this.EO.MY(list);
                    return;
                }
                return;
            }
            if (ilO.tV() == 0 && ilO.Cc() == 2) {
                if (com.bytedance.sdk.component.vCE.IlO.MY.IlO.MY()) {
                    this.MY.MY(list);
                    return;
                }
                return;
            }
            if (ilO.tV() == 1 && ilO.Cc() == 2) {
                if (com.bytedance.sdk.component.vCE.IlO.MY.IlO.EO()) {
                    this.tV.MY(list);
                }
            } else if (ilO.tV() == 1 && ilO.Cc() == 3) {
                if (com.bytedance.sdk.component.vCE.IlO.MY.IlO.tV()) {
                    this.Cc.MY(list);
                }
            } else if (ilO.tV() == 2 && ilO.Cc() == 3 && com.bytedance.sdk.component.vCE.IlO.MY.IlO.vCE()) {
                this.vCE.MY(list);
            }
        }
    }

    @Override // com.bytedance.sdk.component.vCE.IlO.IlO.tV
    public List<com.bytedance.sdk.component.vCE.IlO.tV.IlO> IlO(int i2, int i8, List<String> list) {
        if (com.bytedance.sdk.component.vCE.IlO.MY.IlO.IlO()) {
            List<com.bytedance.sdk.component.vCE.IlO.tV.IlO> listIlO = this.IlO.IlO("_id");
            if (IlO(listIlO, list)) {
                listIlO.size();
                com.bytedance.sdk.component.vCE.IlO.EO.MY.IlO(com.bytedance.sdk.component.vCE.IlO.MY.tV.tV.vAh(), 1);
                return listIlO;
            }
        }
        if (com.bytedance.sdk.component.vCE.IlO.MY.IlO.Cc()) {
            List<com.bytedance.sdk.component.vCE.IlO.tV.IlO> listIlO2 = this.EO.IlO("_id");
            if (IlO(listIlO2, list)) {
                listIlO2.size();
                return listIlO2;
            }
        }
        if (com.bytedance.sdk.component.vCE.IlO.MY.IlO.MY()) {
            List<com.bytedance.sdk.component.vCE.IlO.tV.IlO> listIlO3 = this.MY.IlO("_id");
            if (IlO(listIlO3, list)) {
                listIlO3.size();
                com.bytedance.sdk.component.vCE.IlO.EO.MY.IlO(com.bytedance.sdk.component.vCE.IlO.MY.tV.tV.kBB(), 1);
                return listIlO3;
            }
        }
        if (com.bytedance.sdk.component.vCE.IlO.MY.IlO.EO()) {
            List<com.bytedance.sdk.component.vCE.IlO.tV.IlO> listMY = this.tV.MY("_id");
            if (IlO(listMY, list)) {
                listMY.size();
                com.bytedance.sdk.component.vCE.IlO.EO.MY.IlO(com.bytedance.sdk.component.vCE.IlO.MY.tV.tV.pP(), 1);
                return listMY;
            }
        }
        if (com.bytedance.sdk.component.vCE.IlO.MY.IlO.tV()) {
            List<com.bytedance.sdk.component.vCE.IlO.tV.IlO> listMY2 = this.Cc.MY("_id");
            if (IlO(listMY2, list)) {
                listMY2.size();
                com.bytedance.sdk.component.vCE.IlO.EO.MY.IlO(com.bytedance.sdk.component.vCE.IlO.MY.tV.tV.tl(), 1);
                return listMY2;
            }
        }
        if (!com.bytedance.sdk.component.vCE.IlO.MY.IlO.vCE()) {
            return null;
        }
        List<com.bytedance.sdk.component.vCE.IlO.tV.IlO> listMY3 = this.vCE.MY("_id");
        if (!IlO(listMY3, list)) {
            return null;
        }
        listMY3.size();
        return listMY3;
    }

    private boolean IlO(List<com.bytedance.sdk.component.vCE.IlO.tV.IlO> list, List<String> list2) {
        if (list != null && !list.isEmpty() && list2 != null && !list2.isEmpty()) {
            try {
                Iterator<com.bytedance.sdk.component.vCE.IlO.tV.IlO> it = list.iterator();
                while (it.hasNext()) {
                    com.bytedance.sdk.component.vCE.IlO.tV.IlO next = it.next();
                    if (next != null) {
                        String strEO = next.EO();
                        if (!TextUtils.isEmpty(strEO) && list2.contains(strEO)) {
                            it.remove();
                        }
                    }
                }
            } catch (Throwable th) {
                th.getMessage();
            }
        }
        return (list == null || list.isEmpty()) ? false : true;
    }

    @Override // com.bytedance.sdk.component.vCE.IlO.IlO.tV
    public boolean IlO(int i2, boolean z2) {
        com.bytedance.sdk.component.vCE.IlO.IlO.IlO.IlO.Cc cc;
        com.bytedance.sdk.component.vCE.IlO.IlO.IlO.IlO.vCE vce;
        Bc bc;
        com.bytedance.sdk.component.vCE.IlO.IlO.IlO.IlO.IlO ilO;
        com.bytedance.sdk.component.vCE.IlO.IlO.IlO.IlO.MY my;
        com.bytedance.sdk.component.vCE.IlO.IlO.IlO.IlO.tV tVVar;
        if (com.bytedance.sdk.component.vCE.IlO.MY.IlO.IlO() && (tVVar = this.IlO) != null && tVVar.IlO(i2)) {
            com.bytedance.sdk.component.vCE.IlO.EO.MY.IlO(com.bytedance.sdk.component.vCE.IlO.MY.tV.tV.bWL(), 1);
            return true;
        }
        if (com.bytedance.sdk.component.vCE.IlO.MY.IlO.Cc() && (my = this.EO) != null && my.IlO(i2)) {
            return true;
        }
        if (com.bytedance.sdk.component.vCE.IlO.MY.IlO.MY() && (ilO = this.MY) != null && ilO.IlO(i2)) {
            com.bytedance.sdk.component.vCE.IlO.EO.MY.IlO(com.bytedance.sdk.component.vCE.IlO.MY.tV.tV.ea(), 1);
            return true;
        }
        if (com.bytedance.sdk.component.vCE.IlO.MY.IlO.EO() && (bc = this.tV) != null && bc.IlO(i2)) {
            com.bytedance.sdk.component.vCE.IlO.EO.MY.IlO(com.bytedance.sdk.component.vCE.IlO.MY.tV.tV.zPa(), 1);
            return true;
        }
        if (!com.bytedance.sdk.component.vCE.IlO.MY.IlO.tV() || (vce = this.Cc) == null || !vce.IlO(i2)) {
            return com.bytedance.sdk.component.vCE.IlO.MY.IlO.vCE() && (cc = this.vCE) != null && cc.IlO(i2);
        }
        com.bytedance.sdk.component.vCE.IlO.EO.MY.IlO(com.bytedance.sdk.component.vCE.IlO.MY.tV.tV.cl(), 1);
        return true;
    }

    @Override // com.bytedance.sdk.component.vCE.IlO.IlO.tV
    public void IlO(int i2, long j) {
        com.bytedance.sdk.component.vCE.IlO.IlO.IlO.IlO.tV tVVar = this.IlO;
        if (tVVar != null) {
            tVVar.IlO(i2, j);
        }
        com.bytedance.sdk.component.vCE.IlO.IlO.IlO.IlO.MY my = this.EO;
        if (my != null) {
            my.IlO(i2, j);
        }
        com.bytedance.sdk.component.vCE.IlO.IlO.IlO.IlO.IlO ilO = this.MY;
        if (ilO != null) {
            ilO.IlO(i2, j);
        }
        Bc bc = this.tV;
        if (bc != null) {
            bc.IlO(i2, j);
        }
        com.bytedance.sdk.component.vCE.IlO.IlO.IlO.IlO.vCE vce = this.Cc;
        if (vce != null) {
            vce.IlO(i2, j);
        }
        com.bytedance.sdk.component.vCE.IlO.IlO.IlO.IlO.Cc cc = this.vCE;
        if (cc != null) {
            cc.IlO(i2, j);
        }
    }
}
