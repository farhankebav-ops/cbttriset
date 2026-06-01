package com.bytedance.sdk.openadsdk.component.reward.view;

import android.graphics.Color;
import android.widget.FrameLayout;
import com.bytedance.sdk.openadsdk.core.cl;
import com.bytedance.sdk.openadsdk.core.model.oeT;
import com.bytedance.sdk.openadsdk.utils.BS;
import com.bytedance.sdk.openadsdk.utils.zPa;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class DmF extends NV {
    public DmF(com.bytedance.sdk.openadsdk.component.reward.IlO.IlO ilO) {
        super(ilO);
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.view.NV
    public boolean IlO() {
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.view.NV
    public void IlO(int i2, int i8) {
        super.IlO(i2, i8);
        if (oeT.Cc(this.tV) && this.tV.DM() == 3 && this.tV.zLG() == 0) {
            try {
                FrameLayout frameLayout = (FrameLayout) this.EO.zLG.findViewById(zPa.NV);
                frameLayout.setBackgroundColor(Color.parseColor("#000000"));
                if (this.tV.BES() == 1) {
                    int iMY = BS.MY(cl.IlO(), 90.0f);
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) frameLayout.getLayoutParams();
                    layoutParams.bottomMargin = iMY;
                    frameLayout.setLayoutParams(layoutParams);
                }
            } catch (Throwable unused) {
            }
        }
    }
}
