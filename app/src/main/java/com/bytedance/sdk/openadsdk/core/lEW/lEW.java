package com.bytedance.sdk.openadsdk.core.lEW;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.core.MY.EO;
import com.bytedance.sdk.openadsdk.core.model.NV;
import com.bytedance.sdk.openadsdk.utils.BS;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class lEW extends com.bytedance.sdk.openadsdk.core.MY.IlO {
    public lEW(@NonNull Context context, @NonNull com.bytedance.sdk.openadsdk.core.model.oeT oet, @NonNull String str, int i2) {
        super(context, oet, str, i2);
    }

    @Override // com.bytedance.sdk.openadsdk.core.MY.MY
    public com.bytedance.sdk.openadsdk.core.model.NV IlO(float f4, float f8, float f9, float f10, SparseArray<EO.IlO> sparseArray, long j, long j3, View view, View view2, String str, float f11, int i2, float f12, int i8, JSONObject jSONObject, JSONObject jSONObject2) {
        float fMY;
        float fMY2;
        float fMY3;
        float fMY4;
        int i9;
        int i10;
        int i11;
        long j8;
        long j9;
        int iMY;
        int iMY2;
        int[] iArrIlO = BS.IlO(view);
        int i12 = 0;
        if (iArrIlO == null || iArrIlO.length != 2) {
            fMY = f4;
            fMY2 = f8;
            fMY3 = f9;
            fMY4 = f10;
            i9 = 0;
            i10 = 0;
        } else {
            i9 = iArrIlO[0];
            i10 = iArrIlO[1];
            if (this.xF == 0) {
                fMY4 = (BS.MY(this.tV, f10) + i10) - 0.5f;
                fMY3 = (BS.MY(this.tV, f9) + i9) - 0.5f;
                fMY = (BS.MY(this.tV, f4) + i9) - 0.5f;
                fMY2 = (BS.MY(this.tV, f8) + i10) - 0.5f;
            } else {
                fMY = f4;
                fMY2 = f8;
                fMY3 = f9;
                fMY4 = f10;
            }
        }
        int[] iArrIlO2 = new int[2];
        int[] iArrEO = new int[2];
        com.bytedance.sdk.openadsdk.core.model.bWL bwl = this.Cc;
        if (bwl != null) {
            j8 = bwl.Cc;
            i11 = 1;
            j9 = bwl.vCE;
            if (this.xF == 0) {
                iArrIlO2[0] = BS.MY(this.tV, bwl.Bc) + i9;
                iArrIlO2[1] = BS.MY(this.tV, this.Cc.lEW) + i10;
                iMY = BS.MY(this.tV, this.Cc.DmF);
                iMY2 = BS.MY(this.tV, this.Cc.NV);
            } else {
                iArrIlO2[0] = bwl.Bc;
                iArrIlO2[1] = bwl.lEW;
                iMY = bwl.DmF;
                iMY2 = bwl.NV;
            }
            iArrEO[0] = iMY;
            iArrEO[1] = iMY2;
            if (iMY == 0 && iMY2 == 0 && view2 != null) {
                iArrIlO2 = BS.IlO(view2);
                iArrEO = BS.EO(view2);
            }
            i12 = 0;
        } else {
            i11 = 1;
            j8 = j;
            j9 = j3;
        }
        this.xF = i12;
        return new NV.IlO().vCE(fMY).Cc(fMY2).tV(fMY3).EO(fMY4).MY(j8).IlO(j9).MY(iArrIlO).IlO(iArrIlO2).EO(BS.EO(view)).tV(iArrEO).tV(this.OOq).Cc(this.wPn).vCE(this.oc).MY(com.bytedance.sdk.openadsdk.core.DmF.MY().IlO() ? i11 : 2).IlO(sparseArray).IlO(str).IlO(f11).EO(i2).MY(f12).IlO(i8).IlO(jSONObject).MY(jSONObject2).IlO();
    }

    public void IlO(com.bytedance.sdk.openadsdk.core.model.bWL bwl) {
        this.Cc = bwl;
    }
}
