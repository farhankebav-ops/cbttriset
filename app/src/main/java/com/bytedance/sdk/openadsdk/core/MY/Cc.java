package com.bytedance.sdk.openadsdk.core.MY;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.core.MY.EO;
import com.bytedance.sdk.openadsdk.core.model.oeT;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class Cc extends IlO {
    public Cc(@NonNull Context context, @NonNull oeT oet, @NonNull String str, int i2) {
        super(context, oet, str, i2);
    }

    public abstract void IlO(View view, float f4, float f8, float f9, float f10, SparseArray<EO.IlO> sparseArray, int i2, int i8, int i9, boolean z2);

    @Override // com.bytedance.sdk.openadsdk.core.MY.IlO, com.bytedance.sdk.openadsdk.core.MY.MY, com.bytedance.sdk.openadsdk.core.MY.EO
    public void IlO(View view, float f4, float f8, float f9, float f10, SparseArray<EO.IlO> sparseArray, boolean z2) {
        if (IlO(view, z2)) {
            IlO(view, f4, f8, f9, f10, sparseArray, this.oc, this.OOq, this.wPn, z2);
        }
        super.IlO(view, f4, f8, f9, f10, sparseArray, z2);
    }
}
