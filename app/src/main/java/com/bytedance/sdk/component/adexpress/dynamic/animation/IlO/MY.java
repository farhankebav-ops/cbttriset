package com.bytedance.sdk.component.adexpress.dynamic.animation.IlO;

import android.view.View;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.mmj;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class MY implements mmj {
    List<tV> IlO = new ArrayList();

    public MY(View view, List<com.bytedance.sdk.component.adexpress.dynamic.tV.IlO> list) {
        Iterator<com.bytedance.sdk.component.adexpress.dynamic.tV.IlO> it = list.iterator();
        while (it.hasNext()) {
            tV tVVarIlO = EO.IlO().IlO(view, it.next());
            if (tVVarIlO != null) {
                this.IlO.add(tVVarIlO);
            }
        }
    }

    public void IlO() {
        Iterator<tV> it = this.IlO.iterator();
        while (it.hasNext()) {
            try {
                it.next().EO();
            } catch (Exception unused) {
            }
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.mmj
    public void MY() {
        Iterator<tV> it = this.IlO.iterator();
        while (it.hasNext()) {
            try {
                it.next().MY();
            } catch (Exception unused) {
            }
        }
    }
}
