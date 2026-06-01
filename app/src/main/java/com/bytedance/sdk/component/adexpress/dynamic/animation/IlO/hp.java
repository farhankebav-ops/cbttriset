package com.bytedance.sdk.component.adexpress.dynamic.animation.IlO;

import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class hp extends tV {
    public hp(View view, com.bytedance.sdk.component.adexpress.dynamic.tV.IlO ilO) {
        super(view, ilO);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.IlO.tV
    public List<ObjectAnimator> IlO() {
        View view = this.EO;
        if ((view instanceof ImageView) && (view.getParent() instanceof com.bytedance.sdk.component.adexpress.dynamic.dynamicview.EV)) {
            View view2 = (View) this.EO.getParent();
            this.EO = view2;
            ((ViewGroup) view2).setClipChildren(true);
            ((ViewGroup) this.EO.getParent()).setClipChildren(true);
        }
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.EO, "stretchValue", 0.0f, 1.0f).setDuration((int) (this.MY.NV() * 1000.0d));
        ArrayList arrayList = new ArrayList();
        arrayList.add(IlO(duration));
        return arrayList;
    }
}
