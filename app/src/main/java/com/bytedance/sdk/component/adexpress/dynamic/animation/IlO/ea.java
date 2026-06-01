package com.bytedance.sdk.component.adexpress.dynamic.animation.IlO;

import android.animation.ObjectAnimator;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class ea extends tV {
    public ea(View view, com.bytedance.sdk.component.adexpress.dynamic.tV.IlO ilO) {
        super(view, ilO);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.IlO.tV
    public List<ObjectAnimator> IlO() {
        float f4;
        float fIlO = com.bytedance.sdk.component.adexpress.tV.Bc.IlO(com.bytedance.sdk.component.adexpress.tV.IlO(), this.MY.vCE());
        float fIlO2 = com.bytedance.sdk.component.adexpress.tV.Bc.IlO(com.bytedance.sdk.component.adexpress.tV.IlO(), this.MY.Bc());
        float f8 = 0.0f;
        if ("reverse".equals(this.MY.zPa())) {
            f4 = fIlO2;
            fIlO2 = 0.0f;
            f8 = fIlO;
            fIlO = 0.0f;
        } else {
            f4 = 0.0f;
        }
        if (com.bytedance.sdk.component.adexpress.tV.MY.IlO(this.EO.getContext())) {
            fIlO = -fIlO;
            f8 = -f8;
        }
        this.EO.setTranslationX(fIlO);
        this.EO.setTranslationY(fIlO2);
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.EO, "translationX", fIlO, f8).setDuration((int) (this.MY.NV() * 1000.0d));
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.EO, "translationY", fIlO2, f4).setDuration((int) (this.MY.NV() * 1000.0d));
        ArrayList arrayList = new ArrayList();
        arrayList.add(IlO(duration));
        arrayList.add(IlO(duration2));
        return arrayList;
    }
}
