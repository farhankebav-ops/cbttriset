package com.bytedance.sdk.component.adexpress.dynamic.animation.IlO;

import android.animation.ObjectAnimator;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class rp extends tV {
    public rp(View view, com.bytedance.sdk.component.adexpress.dynamic.tV.IlO ilO) {
        super(view, ilO);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.IlO.tV
    public List<ObjectAnimator> IlO() {
        int i2;
        int i8;
        this.EO.setTag(2097610711, Integer.valueOf(this.MY.tV()));
        View view = this.EO;
        if (view == null || !com.bytedance.sdk.component.adexpress.tV.MY.IlO(view.getContext())) {
            i2 = 0;
            i8 = 1;
        } else {
            i8 = 0;
            i2 = 1;
        }
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.EO, "shineValue", i2, i8).setDuration((int) (this.MY.NV() * 1000.0d));
        ArrayList arrayList = new ArrayList();
        arrayList.add(IlO(duration));
        return arrayList;
    }
}
