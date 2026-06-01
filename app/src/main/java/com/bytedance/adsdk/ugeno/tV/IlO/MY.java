package com.bytedance.adsdk.ugeno.tV.IlO;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class MY implements EO {
    private List<tV> IlO = new CopyOnWriteArrayList();

    @Override // com.bytedance.adsdk.ugeno.tV.IlO.EO
    public void IlO(tV tVVar) {
        this.IlO.add(tVVar);
    }

    @Override // com.bytedance.adsdk.ugeno.tV.IlO.EO
    public void IlO(String str) {
        if (this.IlO.isEmpty()) {
            return;
        }
        Iterator<tV> it = this.IlO.iterator();
        while (it.hasNext()) {
            it.next().IlO(str);
        }
    }
}
