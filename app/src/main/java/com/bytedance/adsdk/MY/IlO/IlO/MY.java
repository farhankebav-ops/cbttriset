package com.bytedance.adsdk.MY.IlO.IlO;

import android.graphics.Path;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class MY {
    private final List<oeT> IlO = new ArrayList();

    public void IlO(oeT oet) {
        this.IlO.add(oet);
    }

    public void IlO(Path path) {
        for (int size = this.IlO.size() - 1; size >= 0; size--) {
            com.bytedance.adsdk.MY.vCE.vCE.IlO(path, this.IlO.get(size));
        }
    }
}
