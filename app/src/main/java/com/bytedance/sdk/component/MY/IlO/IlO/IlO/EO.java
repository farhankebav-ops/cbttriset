package com.bytedance.sdk.component.MY.IlO.IlO.IlO;

import com.bytedance.sdk.component.MY.IlO.bWL;
import com.bytedance.sdk.component.MY.IlO.lEW;
import com.bytedance.sdk.component.MY.IlO.rp;
import java.io.IOException;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class EO implements lEW.IlO {
    int EO = 0;
    List<com.bytedance.sdk.component.MY.IlO.lEW> IlO;
    rp MY;

    public EO(List<com.bytedance.sdk.component.MY.IlO.lEW> list, rp rpVar) {
        this.IlO = list;
        this.MY = rpVar;
    }

    @Override // com.bytedance.sdk.component.MY.IlO.lEW.IlO
    public rp IlO() {
        return this.MY;
    }

    @Override // com.bytedance.sdk.component.MY.IlO.lEW.IlO
    public bWL IlO(rp rpVar) throws IOException {
        this.MY = rpVar;
        int i2 = this.EO + 1;
        this.EO = i2;
        if (i2 >= this.IlO.size()) {
            return null;
        }
        return this.IlO.get(this.EO).IlO(this);
    }
}
