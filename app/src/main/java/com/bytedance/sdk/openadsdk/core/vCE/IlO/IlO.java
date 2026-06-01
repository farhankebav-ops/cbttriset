package com.bytedance.sdk.openadsdk.core.vCE.IlO;

import android.util.SparseArray;
import android.view.View;
import com.bytedance.sdk.component.adexpress.MY.EV;
import com.bytedance.sdk.openadsdk.core.MY.EO;
import com.bytedance.sdk.openadsdk.core.model.bWL;
import com.bytedance.sdk.openadsdk.utils.BS;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class IlO extends EO implements com.bytedance.sdk.component.adexpress.dynamic.vCE.IlO {
    private EV EO;
    protected WeakReference<View> IlO;
    protected WeakReference<View> MY;

    @Override // com.bytedance.sdk.component.adexpress.dynamic.vCE.IlO
    public void IlO(EV ev) {
        this.EO = ev;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.vCE.IlO
    public void MY(View view) {
        this.MY = new WeakReference<>(view);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.vCE.IlO
    public void IlO(View view) {
        this.IlO = new WeakReference<>(view);
    }

    @Override // com.bytedance.sdk.openadsdk.core.MY.EO
    public void IlO(View view, float f4, float f8, float f9, float f10, SparseArray<EO.IlO> sparseArray, boolean z2) {
        IlO(view, ((Integer) view.getTag()).intValue(), f4, f8, f9, f10, sparseArray);
    }

    private void IlO(View view, int i2, float f4, float f8, float f9, float f10, SparseArray<EO.IlO> sparseArray) {
        if (this.EO != null) {
            int[] iArr = new int[2];
            int[] iArr2 = new int[2];
            WeakReference<View> weakReference = this.MY;
            if (weakReference != null) {
                int[] iArrIlO = BS.IlO(weakReference.get());
                if (iArrIlO != null) {
                    iArr = iArrIlO;
                }
                int[] iArrEO = BS.EO(this.MY.get());
                if (iArrEO != null) {
                    iArr2 = iArrEO;
                }
            }
            String strValueOf = "";
            try {
                int i8 = com.bytedance.sdk.component.adexpress.dynamic.IlO.AXM;
                if (view.getTag(i8) != null) {
                    strValueOf = String.valueOf(view.getTag(i8));
                }
            } catch (Exception unused) {
            }
            this.EO.IlO(view, i2, new bWL.IlO().tV(f4).EO(f8).MY(f9).IlO(f10).MY(this.pP).IlO(this.tl).tV(iArr[0]).Cc(iArr[1]).vCE(iArr2[0]).Bc(iArr2[1]).IlO(sparseArray).IlO(this.dY).IlO(strValueOf).IlO());
        }
    }
}
