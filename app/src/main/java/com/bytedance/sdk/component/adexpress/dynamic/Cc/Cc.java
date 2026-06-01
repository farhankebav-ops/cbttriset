package com.bytedance.sdk.component.adexpress.dynamic.Cc;

import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.sdk.component.adexpress.MY.hp;
import com.bytedance.sdk.component.adexpress.dynamic.Cc.MY;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class Cc {
    private com.bytedance.sdk.component.adexpress.dynamic.tV.lEW EO;
    public com.bytedance.sdk.component.adexpress.dynamic.tV.MY IlO;
    protected MY MY;
    private IlO tV;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class IlO {
        float EO;
        float IlO;
        float MY;
    }

    public Cc(double d8, int i2, double d9, String str, hp hpVar) {
        this.MY = new MY(d8, i2, d9, str, hpVar);
    }

    public void IlO(IlO ilO) {
        this.tV = ilO;
    }

    public void IlO() {
        this.MY.IlO();
    }

    public void IlO(com.bytedance.sdk.component.adexpress.dynamic.tV.lEW lew, float f4, float f8) {
        if (lew != null) {
            this.EO = lew;
        }
        com.bytedance.sdk.component.adexpress.dynamic.tV.lEW lew2 = this.EO;
        float fLEW = lew2.lEW();
        float fDmF = lew2.DmF();
        float f9 = TextUtils.equals(lew2.NV().Cc().OOq(), "fixed") ? fDmF : 65536.0f;
        this.MY.IlO();
        this.MY.EO(lew2, fLEW, f9);
        MY.EO eoIlO = this.MY.IlO(lew2);
        com.bytedance.sdk.component.adexpress.dynamic.tV.MY my = new com.bytedance.sdk.component.adexpress.dynamic.tV.MY();
        my.IlO = f4;
        my.MY = f8;
        if (eoIlO != null) {
            fLEW = eoIlO.IlO;
        }
        my.EO = fLEW;
        if (eoIlO != null) {
            fDmF = eoIlO.MY;
        }
        my.tV = fDmF;
        my.Cc = "root";
        my.DmF = 1280.0f;
        my.vCE = lew2;
        lew2.EO(f4);
        my.vCE.tV(my.MY);
        my.vCE.Cc(my.EO);
        my.vCE.vCE(my.tV);
        com.bytedance.sdk.component.adexpress.dynamic.tV.MY myIlO = IlO(my, 0.0f);
        this.IlO = myIlO;
        IlO(myIlO);
    }

    public void IlO(com.bytedance.sdk.component.adexpress.dynamic.tV.MY my) {
        if (my == null) {
            return;
        }
        my.vCE.NV().MY();
        List<List<com.bytedance.sdk.component.adexpress.dynamic.tV.MY>> list = my.Bc;
        if (list == null || list.size() <= 0) {
            return;
        }
        for (List<com.bytedance.sdk.component.adexpress.dynamic.tV.MY> list2 : list) {
            if (list2 != null && list2.size() > 0) {
                Iterator<com.bytedance.sdk.component.adexpress.dynamic.tV.MY> it = list2.iterator();
                while (it.hasNext()) {
                    IlO(it.next());
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:144:0x0340  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00e8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.bytedance.sdk.component.adexpress.dynamic.tV.MY IlO(com.bytedance.sdk.component.adexpress.dynamic.tV.MY r37, float r38) {
        /*
            Method dump skipped, instruction units count: 1009
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.adexpress.dynamic.Cc.Cc.IlO(com.bytedance.sdk.component.adexpress.dynamic.tV.MY, float):com.bytedance.sdk.component.adexpress.dynamic.tV.MY");
    }

    private com.bytedance.sdk.component.adexpress.dynamic.tV.DmF IlO(com.bytedance.sdk.component.adexpress.dynamic.tV.vCE vce, MY.EO eo, MY.EO eo2) {
        float fAa = vce.aa();
        float fPTq = vce.PTq();
        float fED = vce.ED();
        float fVH = vce.VH();
        boolean zHTA = vce.HTA();
        boolean zTx = vce.Tx();
        boolean zPFe = vce.pFe();
        boolean zHg = vce.Hg();
        if (!zHTA) {
            if (zTx) {
                float f4 = this.tV.IlO;
                fAa = ((f4 != 0.0f ? Math.min(f4, eo.IlO) : eo.IlO) - fED) - eo2.IlO;
            } else {
                fAa = 0.0f;
            }
        }
        if (!zPFe) {
            if (zHg) {
                float f8 = this.tV.MY;
                if (f8 == 0.0f) {
                    f8 = eo.MY;
                }
                fPTq = (f8 - fVH) - eo2.MY;
            } else {
                fPTq = 0.0f;
            }
        }
        return new com.bytedance.sdk.component.adexpress.dynamic.tV.DmF(fAa, fPTq);
    }

    private com.bytedance.sdk.component.adexpress.dynamic.tV.DmF IlO(com.bytedance.sdk.component.adexpress.dynamic.tV.MY my, com.bytedance.sdk.component.adexpress.dynamic.tV.vCE vce, float f4, float f8) {
        float f9;
        float f10;
        float f11 = my.IlO;
        float f12 = my.MY;
        float fAa = vce.aa();
        float fPTq = vce.PTq();
        float fED = vce.ED();
        float fVH = vce.VH();
        boolean zHTA = vce.HTA();
        boolean zTx = vce.Tx();
        boolean zPFe = vce.pFe();
        boolean zHg = vce.Hg();
        String strIi = vce.ii();
        float f13 = my.EO;
        float f14 = my.tV;
        if (TextUtils.equals(strIi, "0")) {
            if (zHTA) {
                f11 = my.IlO + fAa;
            } else if (zTx) {
                f11 = ((my.IlO + f13) - fED) - f4;
            }
            if (zPFe) {
                f10 = my.MY;
                f12 = f10 + fPTq;
            } else if (zHg) {
                f9 = my.MY;
                f12 = ((f9 + f14) - fVH) - f8;
            }
        } else if (TextUtils.equals(strIi, "1")) {
            f11 = my.IlO + ((f13 - f4) / 2.0f);
            if (zPFe) {
                f10 = my.MY;
                f12 = f10 + fPTq;
            } else if (zHg) {
                f9 = my.MY;
                f12 = ((f9 + f14) - fVH) - f8;
            }
        } else if (TextUtils.equals(strIi, "2")) {
            f12 = my.MY + ((f14 - f8) / 2.0f);
            if (zHTA) {
                f11 = my.IlO + fAa;
            } else if (zTx) {
                f11 = ((my.IlO + f13) - fED) - f4;
            }
        } else if (TextUtils.equals(strIi, ExifInterface.GPS_MEASUREMENT_3D)) {
            f11 = my.IlO + ((f13 - f4) / 2.0f);
            f12 = ((f14 - f8) / 2.0f) + my.MY;
        }
        return new com.bytedance.sdk.component.adexpress.dynamic.tV.DmF(f11, f12);
    }
}
