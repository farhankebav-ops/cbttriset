package com.bytedance.sdk.openadsdk.core.NV.MY;

import android.content.Context;
import android.widget.FrameLayout;
import com.bytedance.sdk.openadsdk.core.widget.PAGLogoView;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class tV extends com.bytedance.adsdk.ugeno.MY.EO<FrameLayout> {
    public tV(Context context) {
        super(context);
    }

    @Override // com.bytedance.adsdk.ugeno.MY.EO
    /* JADX INFO: renamed from: EO, reason: merged with bridge method [inline-methods] */
    public FrameLayout IlO() {
        FrameLayout frameLayout = new FrameLayout(this.MY);
        com.bytedance.sdk.openadsdk.core.model.MY my = new com.bytedance.sdk.openadsdk.core.model.MY();
        my.IlO(true);
        PAGLogoView pAGLogoView = new PAGLogoView(this.MY);
        pAGLogoView.initData(my);
        frameLayout.addView(pAGLogoView);
        return frameLayout;
    }

    @Override // com.bytedance.adsdk.ugeno.MY.EO
    public void MY() {
        super.MY();
    }
}
