package com.bytedance.sdk.component.adexpress.dynamic.animation.IlO;

import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class EV extends tV {
    public EV(View view, com.bytedance.sdk.component.adexpress.dynamic.tV.IlO ilO) {
        super(view, ilO);
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        if (viewGroup != null) {
            viewGroup.setClipChildren(false);
            viewGroup.setClipToPadding(false);
            ViewGroup viewGroup2 = (ViewGroup) viewGroup.getParent();
            if (viewGroup2 == null || !(viewGroup2 instanceof com.bytedance.sdk.component.adexpress.dynamic.dynamicview.Cc)) {
                return;
            }
            viewGroup2.setClipChildren(false);
            viewGroup2.setClipToPadding(false);
            ViewGroup viewGroup3 = (ViewGroup) viewGroup2.getParent();
            if (viewGroup3 == null || !(viewGroup3 instanceof com.bytedance.sdk.component.adexpress.dynamic.dynamicview.Cc)) {
                return;
            }
            viewGroup3.setClipChildren(false);
            viewGroup3.setClipToPadding(false);
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.IlO.tV
    public List<ObjectAnimator> IlO() {
        float f4;
        float fEV = (float) this.MY.EV();
        float fRp = (float) this.MY.rp();
        String strZPa = this.MY.zPa();
        float f8 = 1.0f;
        if ("reverse".equals(strZPa) || "alternate-reverse".equals(strZPa)) {
            f4 = 1.0f;
        } else {
            f4 = fRp;
            fRp = 1.0f;
            f8 = fEV;
            fEV = 1.0f;
        }
        this.EO.setTag(2097610710, this.MY.MY());
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.EO, "scaleX", fEV, f8).setDuration((int) (this.MY.NV() * 1000.0d));
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.EO, "scaleY", fRp, f4).setDuration((int) (this.MY.NV() * 1000.0d));
        ArrayList arrayList = new ArrayList();
        arrayList.add(IlO(duration));
        arrayList.add(IlO(duration2));
        return arrayList;
    }
}
