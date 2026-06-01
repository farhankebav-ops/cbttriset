package com.bytedance.adsdk.MY.IlO.MY;

import android.graphics.Path;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class lEW {
    private final List<com.bytedance.adsdk.MY.EO.MY.lEW> EO;
    private final List<IlO<com.bytedance.adsdk.MY.EO.MY.bWL, Path>> IlO;
    private final List<IlO<Integer, Integer>> MY;

    public lEW(List<com.bytedance.adsdk.MY.EO.MY.lEW> list) {
        this.EO = list;
        this.IlO = new ArrayList(list.size());
        this.MY = new ArrayList(list.size());
        for (int i2 = 0; i2 < list.size(); i2++) {
            this.IlO.add(list.get(i2).MY().IlO());
            this.MY.add(list.get(i2).EO().IlO());
        }
    }

    public List<IlO<Integer, Integer>> EO() {
        return this.MY;
    }

    public List<com.bytedance.adsdk.MY.EO.MY.lEW> IlO() {
        return this.EO;
    }

    public List<IlO<com.bytedance.adsdk.MY.EO.MY.bWL, Path>> MY() {
        return this.IlO;
    }
}
