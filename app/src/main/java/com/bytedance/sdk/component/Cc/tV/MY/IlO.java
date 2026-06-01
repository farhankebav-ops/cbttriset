package com.bytedance.sdk.component.Cc.tV.MY;

import android.graphics.Bitmap;
import com.bytedance.sdk.component.Cc.xF;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class IlO<T> implements vCE {
    @Override // com.bytedance.sdk.component.Cc.tV.MY.vCE
    public boolean IlO(com.bytedance.sdk.component.Cc.tV.EO.EO eo, xF xFVar, com.bytedance.sdk.component.Cc.tV.EO.IlO ilO) {
        Bitmap bitmapIlO;
        String strNV = eo.NV();
        eo.IlO();
        com.bytedance.sdk.component.Cc.MY myCL = eo.cL();
        com.bytedance.sdk.component.Cc.tV.EO.vCE vceCl = eo.cl();
        if (myCL == null || vceCl == null || !myCL.Cc() || !IlO(eo) || (bitmapIlO = vceCl.IlO(myCL).IlO(strNV)) == null) {
            return true;
        }
        eo.IlO();
        ilO.IlO(new com.bytedance.sdk.component.Cc.tV.EO.tV().IlO(eo, bitmapIlO, null, false));
        return false;
    }

    private boolean IlO(com.bytedance.sdk.component.Cc.tV.EO.EO eo) {
        int iRp = eo.rp();
        return iRp == 1 || iRp == 2;
    }

    @Override // com.bytedance.sdk.component.Cc.tV.MY.vCE
    public String IlO() {
        return "bitmap_cache";
    }
}
