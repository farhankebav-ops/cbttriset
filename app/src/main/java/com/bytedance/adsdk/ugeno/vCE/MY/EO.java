package com.bytedance.adsdk.ugeno.vCE.MY;

import android.text.TextUtils;
import android.view.View;
import com.bytedance.adsdk.ugeno.lEW.EO;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class EO implements EO.Cc {
    private String IlO;

    public void IlO(String str) {
        this.IlO = str;
    }

    @Override // com.bytedance.adsdk.ugeno.lEW.EO.Cc
    public void IlO(View view, float f4) {
        if (f4 < -1.0f || f4 > 1.0f) {
            view.setAlpha(0.0f);
        } else {
            view.setAlpha(1.0f);
            view.setTranslationX(view.getWidth() * (-f4));
            view.setTranslationY(view.getHeight() * f4);
        }
        if (TextUtils.equals(this.IlO, "cube")) {
            float height = f4 < 0.0f ? view.getHeight() : 0.0f;
            view.setPivotX(view.getWidth() * 0.5f);
            view.setPivotY(height);
            view.setRotationX(f4 * (-90.0f));
        }
    }
}
