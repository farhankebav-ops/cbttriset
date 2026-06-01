package com.bytedance.sdk.openadsdk.core.NV.MY.IlO;

import android.content.Context;
import com.bytedance.adsdk.MY.vCE;
import com.bytedance.adsdk.ugeno.tV;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class MY extends vCE {
    private tV IlO;

    public MY(Context context) {
        super(context);
    }

    public void IlO(tV tVVar) {
        this.IlO = tVVar;
    }

    @Override // com.bytedance.adsdk.MY.vCE, android.widget.ImageView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        tV tVVar = this.IlO;
        if (tVVar != null) {
            tVVar.Bc();
        }
    }

    @Override // com.bytedance.adsdk.MY.vCE, android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        tV tVVar = this.IlO;
        if (tVVar != null) {
            tVVar.lEW();
        }
    }
}
