package com.bytedance.adsdk.MY.EO.IlO;

import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
abstract class bWL<V, O> implements hp<V, O> {
    final List<com.bytedance.adsdk.MY.Bc.IlO<V>> IlO;

    public bWL(List<com.bytedance.adsdk.MY.Bc.IlO<V>> list) {
        this.IlO = list;
    }

    @Override // com.bytedance.adsdk.MY.EO.IlO.hp
    public List<com.bytedance.adsdk.MY.Bc.IlO<V>> EO() {
        return this.IlO;
    }

    @Override // com.bytedance.adsdk.MY.EO.IlO.hp
    public boolean MY() {
        return this.IlO.isEmpty() || (this.IlO.size() == 1 && this.IlO.get(0).Cc());
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (!this.IlO.isEmpty()) {
            sb.append("values=");
            sb.append(Arrays.toString(this.IlO.toArray()));
        }
        return sb.toString();
    }
}
