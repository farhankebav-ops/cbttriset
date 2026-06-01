package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.text.TextUtils;
import androidx.camera.core.processing.util.a;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class ea extends vCE {
    String IlO;
    com.bytedance.sdk.component.adexpress.dynamic.tV.lEW MY;

    public ea(Context context, DynamicRootView dynamicRootView, com.bytedance.sdk.component.adexpress.dynamic.tV.lEW lew, String str) {
        super(context, dynamicRootView, lew);
        this.IlO = str;
        this.MY = lew;
        com.bytedance.sdk.component.adexpress.vCE.NV lottieView = getLottieView();
        if (lottieView != null) {
            addView(lottieView, getWidgetLayoutParams());
        }
    }

    private com.bytedance.sdk.component.adexpress.vCE.NV getLottieView() {
        com.bytedance.sdk.component.adexpress.dynamic.tV.lEW lew = this.hp;
        if (lew == null || lew.NV() == null || this.EV == null || TextUtils.isEmpty(this.IlO)) {
            return null;
        }
        com.bytedance.sdk.component.adexpress.dynamic.tV.vCE vceCc = this.hp.NV().Cc();
        String strQz = vceCc != null ? vceCc.qz() : "";
        if (TextUtils.isEmpty(strQz)) {
            return null;
        }
        String strN = a.n(new StringBuilder(), this.IlO, "static/lotties/", strQz, ".json");
        com.bytedance.sdk.component.adexpress.vCE.NV nv = new com.bytedance.sdk.component.adexpress.vCE.NV(this.EV);
        nv.setImageLottieTosPath(strN);
        nv.lEW();
        return nv;
    }
}
