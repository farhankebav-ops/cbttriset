package com.bytedance.sdk.component.adexpress.dynamic.EO;

import android.content.Context;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.vCE.vAh;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class tV extends cl<com.bytedance.sdk.component.adexpress.vCE.Bc> {
    public tV(Context context, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.Cc cc, com.bytedance.sdk.component.adexpress.dynamic.tV.Bc bc) {
        super(context, cc, bc);
        IlO(bc);
    }

    private void IlO(com.bytedance.sdk.component.adexpress.dynamic.tV.Bc bc) {
        this.IlO = new com.bytedance.sdk.component.adexpress.vCE.Bc(this.MY);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 81;
        layoutParams.bottomMargin = (int) com.bytedance.sdk.component.adexpress.tV.Bc.IlO(this.MY, bc.uvo());
        this.IlO.setLayoutParams(layoutParams);
        this.IlO.setSlideText(this.tV.fdM());
        vAh vah = this.IlO;
        if (vah instanceof com.bytedance.sdk.component.adexpress.vCE.Bc) {
            ((com.bytedance.sdk.component.adexpress.vCE.Bc) vah).setButtonText(this.tV.NV());
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
