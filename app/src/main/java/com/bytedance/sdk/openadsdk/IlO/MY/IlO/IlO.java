package com.bytedance.sdk.openadsdk.IlO.MY.IlO;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.core.lEW.xF;
import com.bytedance.sdk.openadsdk.core.model.bWL;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class IlO extends com.bytedance.sdk.openadsdk.core.lEW.IlO {
    private xF IlO;
    private com.bytedance.sdk.openadsdk.IlO.MY.IlO hp;

    public IlO(@NonNull Context context) {
        super(context);
    }

    @Override // com.bytedance.sdk.openadsdk.core.lEW.IlO
    public void IlO(View view, int i2, bWL bwl) {
        xF xFVar = this.IlO;
        if (xFVar != null) {
            xFVar.IlO(view, i2, bwl);
        }
    }

    public void setExtraFuncationHelper(com.bytedance.sdk.openadsdk.IlO.MY.IlO ilO) {
        this.hp = ilO;
    }

    public void IlO(xF xFVar) {
        this.IlO = xFVar;
        xFVar.addView(this, new FrameLayout.LayoutParams(-1, -1));
    }
}
