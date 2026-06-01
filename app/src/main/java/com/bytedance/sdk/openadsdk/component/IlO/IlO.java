package com.bytedance.sdk.openadsdk.component.IlO;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.core.MY.EO;
import com.bytedance.sdk.openadsdk.core.model.oeT;
import com.bytedance.sdk.openadsdk.kBB.MY.Cc;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class IlO extends com.bytedance.sdk.openadsdk.core.MY.IlO {
    private final com.bytedance.sdk.openadsdk.component.lEW.IlO IlO;

    public IlO(@NonNull Context context, @NonNull oeT oet, @NonNull String str, int i2, com.bytedance.sdk.openadsdk.component.lEW.IlO ilO) {
        super(context, oet, str, i2);
        this.IlO = ilO;
    }

    @Override // com.bytedance.sdk.openadsdk.core.MY.IlO, com.bytedance.sdk.openadsdk.core.MY.MY, com.bytedance.sdk.openadsdk.core.MY.EO
    public void IlO(View view, float f4, float f8, float f9, float f10, SparseArray<EO.IlO> sparseArray, boolean z2) {
        if (view.getTag() == "open_ad_click_button_tag") {
            IlO("click_bar");
        } else {
            IlO("click_material");
        }
        HashMap map = new HashMap();
        map.put("duration", Long.valueOf(this.IlO.EO()));
        IlO(map);
        super.IlO(view, f4, f8, f9, f10, sparseArray, z2);
        Cc.IlO(((com.bytedance.sdk.openadsdk.core.MY.MY) this).vCE, 9);
    }
}
