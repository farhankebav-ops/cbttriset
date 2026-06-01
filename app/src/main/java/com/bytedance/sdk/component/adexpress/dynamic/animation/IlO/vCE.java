package com.bytedance.sdk.component.adexpress.dynamic.animation.IlO;

import android.animation.ObjectAnimator;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class vCE extends tV {
    public vCE(View view, com.bytedance.sdk.component.adexpress.dynamic.tV.IlO ilO) {
        super(view, ilO);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.IlO.tV
    public List<ObjectAnimator> IlO() {
        float f4 = this.EO.getLayoutParams().width;
        this.EO.setTranslationX(f4);
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.EO, "translationX", f4, 0.0f).setDuration((int) (this.MY.NV() * 1000.0d));
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.EO, "alpha", 0.0f, 1.0f).setDuration((int) (this.MY.NV() * 1000.0d));
        ArrayList arrayList = new ArrayList();
        arrayList.add(IlO(duration));
        arrayList.add(IlO(duration2));
        return arrayList;
    }
}
