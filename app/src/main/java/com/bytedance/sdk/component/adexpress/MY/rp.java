package com.bytedance.sdk.component.adexpress.MY;

import androidx.annotation.NonNull;
import com.bytedance.sdk.component.adexpress.MY.NV;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class rp implements NV.IlO {
    private DmF EO;
    ea IlO;

    @NonNull
    private List<NV> MY;
    private AtomicBoolean tV = new AtomicBoolean(false);

    public rp(List<NV> list, DmF dmF) {
        this.MY = list;
        this.EO = dmF;
    }

    @Override // com.bytedance.sdk.component.adexpress.MY.NV.IlO
    public boolean EO() {
        return this.tV.get();
    }

    @Override // com.bytedance.sdk.component.adexpress.MY.NV.IlO
    public void IlO() {
        this.EO.tV();
        Iterator<NV> it = this.MY.iterator();
        while (it.hasNext() && !it.next().IlO(this)) {
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.MY.NV.IlO
    public boolean MY(NV nv) {
        int iIndexOf = this.MY.indexOf(nv);
        return iIndexOf < this.MY.size() - 1 && iIndexOf >= 0;
    }

    @Override // com.bytedance.sdk.component.adexpress.MY.NV.IlO
    public ea MY() {
        return this.IlO;
    }

    @Override // com.bytedance.sdk.component.adexpress.MY.NV.IlO
    public void IlO(NV nv) {
        int iIndexOf = this.MY.indexOf(nv);
        if (iIndexOf < 0) {
            return;
        }
        do {
            iIndexOf++;
            if (iIndexOf >= this.MY.size()) {
                return;
            }
        } while (!this.MY.get(iIndexOf).IlO(this));
    }

    @Override // com.bytedance.sdk.component.adexpress.MY.NV.IlO
    public void IlO(ea eaVar) {
        this.IlO = eaVar;
    }

    @Override // com.bytedance.sdk.component.adexpress.MY.NV.IlO
    public void IlO(boolean z2) {
        this.tV.getAndSet(z2);
    }
}
