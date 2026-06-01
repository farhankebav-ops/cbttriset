package com.bytedance.sdk.component.Cc.tV.MY;

import com.bytedance.sdk.component.Cc.es;
import com.bytedance.sdk.component.Cc.xF;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class EO implements vCE {
    private void MY(final com.bytedance.sdk.component.Cc.MY my, final com.bytedance.sdk.component.Cc.tV.EO.vCE vce, final String str, final byte[] bArr) {
        if (my == null || !my.Bc()) {
            return;
        }
        vce.lEW().submit(new Runnable() { // from class: com.bytedance.sdk.component.Cc.tV.MY.EO.1
            @Override // java.lang.Runnable
            public void run() {
                vce.EO(my).IlO(str, bArr);
            }
        });
    }

    @Override // com.bytedance.sdk.component.Cc.tV.MY.vCE
    public boolean IlO(com.bytedance.sdk.component.Cc.tV.EO.EO eo, xF xFVar, com.bytedance.sdk.component.Cc.tV.EO.IlO ilO) {
        com.bytedance.sdk.component.Cc.MY myCL = eo.cL();
        com.bytedance.sdk.component.Cc.tV.EO.vCE vceCl = eo.cl();
        if (myCL != null && vceCl != null) {
            if (myCL.vCE()) {
                if (xFVar != null) {
                    xFVar.IlO("data_cache", eo);
                }
                es esVarMY = vceCl.MY(myCL);
                bArrIlO = esVarMY != null ? esVarMY.IlO(eo.DmF()) : null;
                if (xFVar != null) {
                    xFVar.MY("data_cache", eo);
                }
                eo.DmF();
                eo.IlO();
            }
            if (myCL.Bc() && bArrIlO == null) {
                if (xFVar != null) {
                    xFVar.IlO("disk_cache", eo);
                }
                byte[] bArrIlO = IlO(myCL, vceCl, eo.DmF());
                if (bArrIlO != null) {
                    IlO(eo.cL(), vceCl, eo.DmF(), bArrIlO);
                }
                if (xFVar != null) {
                    xFVar.MY("disk_cache", eo);
                }
                eo.DmF();
                eo.IlO();
                bArrIlO = bArrIlO;
            }
        }
        if (vceCl != null && bArrIlO == null) {
            if (xFVar != null) {
                xFVar.IlO("net_request", eo);
            }
            bArrIlO = IlO(vceCl, eo, ilO);
            eo.DmF();
            eo.IlO();
            if (xFVar != null) {
                xFVar.MY("net_request", eo);
            }
        }
        if (bArrIlO != null) {
            eo.IlO(bArrIlO);
            return true;
        }
        eo.DmF();
        eo.IlO();
        return false;
    }

    @Override // com.bytedance.sdk.component.Cc.tV.MY.vCE
    public String IlO() {
        return "data_intercept";
    }

    private byte[] IlO(com.bytedance.sdk.component.Cc.tV.EO.vCE vce, com.bytedance.sdk.component.Cc.tV.EO.EO eo, com.bytedance.sdk.component.Cc.tV.EO.IlO ilO) {
        com.bytedance.sdk.component.Cc.tV tVVarTV = vce.tV();
        eo.IlO(false);
        try {
            com.bytedance.sdk.component.Cc.vCE vceIlO = tVVarTV.IlO(new com.bytedance.sdk.component.Cc.MY.MY(eo.IlO(), false, false, eo.es()));
            if (vceIlO == null) {
                ilO.IlO(1004, "call is empty", new Exception("call is empty"));
                return null;
            }
            int iMY = vceIlO.MY();
            if (iMY == 200) {
                byte[] bArr = (byte[]) vceIlO.EO();
                if (bArr == null) {
                    ilO.IlO(iMY, vceIlO.tV(), new Exception("net data is empty"));
                    return null;
                }
                IlO(eo.cL(), vce, eo.DmF(), bArr);
                MY(eo.cL(), vce, eo.DmF(), bArr);
                return bArr;
            }
            Object objEO = vceIlO.EO();
            ilO.IlO(iMY, vceIlO.tV(), objEO instanceof Throwable ? (Throwable) objEO : null);
            return null;
        } catch (Throwable th) {
            ilO.IlO(1004, "net request failed!", th);
            return null;
        }
    }

    private byte[] IlO(com.bytedance.sdk.component.Cc.MY my, com.bytedance.sdk.component.Cc.tV.EO.vCE vce, String str) {
        vce.EO(my);
        Collection<com.bytedance.sdk.component.Cc.EO> collectionEO = vce.EO();
        if (collectionEO == null) {
            return null;
        }
        Iterator<com.bytedance.sdk.component.Cc.EO> it = collectionEO.iterator();
        while (it.hasNext()) {
            byte[] bArrIlO = it.next().IlO(str);
            if (bArrIlO != null) {
                return bArrIlO;
            }
        }
        return null;
    }

    private void IlO(com.bytedance.sdk.component.Cc.MY my, com.bytedance.sdk.component.Cc.tV.EO.vCE vce, String str, byte[] bArr) {
        if (my == null || !my.vCE()) {
            return;
        }
        vce.MY(my).IlO(str, bArr);
    }
}
