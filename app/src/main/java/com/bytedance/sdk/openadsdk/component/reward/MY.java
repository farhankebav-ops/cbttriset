package com.bytedance.sdk.openadsdk.component.reward;

import com.bytedance.sdk.component.utils.xF;
import com.bytedance.sdk.openadsdk.core.cl;
import com.bytedance.sdk.openadsdk.utils.mmj;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class MY extends com.bytedance.sdk.component.lEW.lEW {
    private final List<? extends com.bytedance.sdk.component.lEW.lEW> IlO;

    public MY(String str, List<? extends com.bytedance.sdk.component.lEW.lEW> list) {
        super(str);
        this.IlO = list;
    }

    @Override // java.lang.Runnable
    public void run() {
        List<? extends com.bytedance.sdk.component.lEW.lEW> list;
        if (xF.EO(cl.IlO()) != 0 && (list = this.IlO) != null) {
            Iterator<? extends com.bytedance.sdk.component.lEW.lEW> it = list.iterator();
            while (it.hasNext()) {
                mmj.IlO(it.next(), 1);
                it.remove();
            }
        }
        try {
            com.bytedance.sdk.component.utils.DmF.IlO().removeCallbacks(this);
        } catch (Exception unused) {
        }
    }
}
