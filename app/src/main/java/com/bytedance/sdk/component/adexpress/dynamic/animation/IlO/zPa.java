package com.bytedance.sdk.component.adexpress.dynamic.animation.IlO;

import android.animation.ObjectAnimator;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class zPa extends tV {
    public zPa(View view, com.bytedance.sdk.component.adexpress.dynamic.tV.IlO ilO) {
        super(view, ilO);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.IlO.tV
    public List<ObjectAnimator> IlO() {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.EO, "translationX", 0.0f, com.bytedance.sdk.component.adexpress.tV.Bc.IlO(com.bytedance.sdk.component.adexpress.tV.IlO(), 20.0f), 0.0f, -com.bytedance.sdk.component.adexpress.tV.Bc.IlO(com.bytedance.sdk.component.adexpress.tV.IlO(), 20.0f), 0.0f).setDuration((int) (this.MY.NV() * 1000.0d));
        ArrayList arrayList = new ArrayList();
        arrayList.add(IlO(duration));
        return arrayList;
    }
}
