package com.bytedance.sdk.component.adexpress.dynamic.EO;

import android.content.Context;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.vCE.vAh;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class Cc extends cl<com.bytedance.sdk.component.adexpress.vCE.Bc> {
    public Cc(Context context, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.Cc cc, com.bytedance.sdk.component.adexpress.dynamic.tV.Bc bc) {
        super(context, cc, bc);
        IlO(bc);
    }

    private void IlO(com.bytedance.sdk.component.adexpress.dynamic.tV.Bc bc) {
        this.IlO = new com.bytedance.sdk.component.adexpress.vCE.lEW(this.MY);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 81;
        this.IlO.setLayoutParams(layoutParams);
        vAh vah = this.IlO;
        if (vah instanceof com.bytedance.sdk.component.adexpress.vCE.lEW) {
            ((com.bytedance.sdk.component.adexpress.vCE.lEW) vah).setButtonText(this.tV.fdM());
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.EO.cl, com.bytedance.sdk.component.adexpress.dynamic.EO.Bc
    public void MY() {
        this.IlO.MY();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.EO.cl, com.bytedance.sdk.component.adexpress.dynamic.EO.Bc
    public void IlO() {
        this.IlO.IlO();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.EO.cl
    public void tV() {
    }
}
