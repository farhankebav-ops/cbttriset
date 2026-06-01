package com.bytedance.adsdk.ugeno.vCE.MY;

import android.view.View;
import com.bytedance.adsdk.ugeno.lEW.EO;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class IlO implements EO.Cc {
    @Override // com.bytedance.adsdk.ugeno.lEW.EO.Cc
    public void IlO(View view, float f4) {
        view.setPivotX(f4 < 0.0f ? view.getWidth() : 0.0f);
        view.setPivotY(view.getHeight() * 0.5f);
        view.setRotationY(f4 * 90.0f);
    }
}
