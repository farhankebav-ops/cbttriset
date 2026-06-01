package com.bytedance.sdk.component.adexpress.dynamic.EO;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.vCE.AXM;
import com.bytedance.sdk.component.adexpress.vCE.vAh;
import com.bytedance.sdk.component.adexpress.vCE.xF;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class vCE extends cl<com.bytedance.sdk.component.adexpress.vCE.vCE> {
    public vCE(Context context, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.Cc cc, com.bytedance.sdk.component.adexpress.dynamic.tV.Bc bc, int i2, int i8, int i9, JSONObject jSONObject) {
        super(context, cc, bc);
        this.MY = context;
        this.tV = bc;
        this.EO = cc;
        IlO(i2, i8, i9, jSONObject, bc);
    }

    private void IlO(int i2, int i8, int i9, JSONObject jSONObject, com.bytedance.sdk.component.adexpress.dynamic.tV.Bc bc) {
        this.IlO = new com.bytedance.sdk.component.adexpress.vCE.vCE(this.MY, i2, i8, i9, jSONObject);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, (int) com.bytedance.sdk.component.adexpress.tV.Bc.IlO(this.MY, 300.0f));
        layoutParams.gravity = 81;
        layoutParams.bottomMargin = (int) com.bytedance.sdk.component.adexpress.tV.Bc.IlO(this.MY, bc.uvo() > 0 ? bc.uvo() : com.bytedance.sdk.component.adexpress.tV.MY() ? 0 : 120);
        this.IlO.setLayoutParams(layoutParams);
        this.IlO.setClipChildren(false);
        this.IlO.setSlideText(this.tV.fdM());
        vAh vah = this.IlO;
        if (vah instanceof com.bytedance.sdk.component.adexpress.vCE.vCE) {
            ((com.bytedance.sdk.component.adexpress.vCE.vCE) vah).setShakeText(this.tV.Jz());
            final AXM shakeView = ((com.bytedance.sdk.component.adexpress.vCE.vCE) this.IlO).getShakeView();
            if (shakeView != null) {
                shakeView.setOnShakeViewListener(new xF.IlO() { // from class: com.bytedance.sdk.component.adexpress.dynamic.EO.vCE.1
                });
                shakeView.setOnClickListener((View.OnClickListener) this.EO.getDynamicClickListener());
            }
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.EO.cl
    public void tV() {
    }
}
