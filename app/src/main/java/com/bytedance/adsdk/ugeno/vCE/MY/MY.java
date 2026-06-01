package com.bytedance.adsdk.ugeno.vCE.MY;

import android.view.View;
import com.bytedance.adsdk.ugeno.lEW.EO;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class MY implements EO.Cc {
    final float IlO = 0.8f;
    final float MY = 0.5f;

    @Override // com.bytedance.adsdk.ugeno.lEW.EO.Cc
    public void IlO(View view, float f4) {
        float f8 = ((f4 < 0.0f ? 0.19999999f : -0.19999999f) * f4) + 1.0f;
        float f9 = (f4 * (f4 < 0.0f ? 0.5f : -0.5f)) + 1.0f;
        if (f4 < 0.0f) {
            view.setPivotX(view.getWidth());
            view.setPivotY(view.getHeight() / 2);
        } else {
            view.setPivotX(0.0f);
            view.setPivotY(view.getHeight() / 2);
        }
        view.setScaleX(f8);
        view.setScaleY(f8);
        view.setAlpha(Math.abs(f9));
    }
}
