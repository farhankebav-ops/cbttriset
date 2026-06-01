package com.bytedance.sdk.openadsdk.core.widget;

import android.content.Context;
import android.view.View;
import com.bytedance.sdk.openadsdk.core.model.oeT;
import com.bytedance.sdk.openadsdk.utils.BS;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class EO extends com.bytedance.sdk.openadsdk.core.Cc.tV {
    public EO(Context context) {
        super(context);
        IlO();
    }

    private void IlO() {
        setVisibility(8);
        setId(com.bytedance.sdk.openadsdk.utils.zPa.fHv);
    }

    public void IlO(int i2, oeT oet) {
        if (oet.xJ() || (oet.Os() && oet.bWL())) {
            BS.IlO((View) this, 0);
            com.bytedance.sdk.openadsdk.cL.Bc.IlO().IlO((int) BS.IlO(getContext(), i2, true), this, oet);
        }
    }
}
