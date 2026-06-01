package com.bytedance.sdk.openadsdk.kBB.MY;

import android.view.View;
import com.bytedance.sdk.openadsdk.core.model.oeT;
import com.bytedance.sdk.openadsdk.kBB.MY.Cc;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class lEW extends MY {
    private int tV;

    public lEW(Integer num, View view, oeT oet, Cc.IlO ilO) {
        super(num, view, oet, 2000, ilO);
        this.tV = 0;
    }

    @Override // com.bytedance.sdk.openadsdk.kBB.MY.MY
    public boolean EO() {
        return vCE.IlO(this.IlO.get(), this.MY.fHv()) && this.tV == 1;
    }

    @Override // com.bytedance.sdk.openadsdk.kBB.MY.MY
    public void IlO() {
        if (this.tV != 1) {
            return;
        }
        super.IlO();
    }

    @Override // com.bytedance.sdk.openadsdk.kBB.MY.MY
    public void MY(int i2) {
        if (DmF()) {
            return;
        }
        if (i2 == 6 || i2 == 5) {
            this.tV = 0;
            lEW();
        }
        if (i2 == 3 || i2 == 2) {
            this.tV = 2;
            lEW();
        }
        if (this.tV == 1 || i2 != 0) {
            return;
        }
        this.tV = 1;
        IlO();
    }

    @Override // com.bytedance.sdk.openadsdk.kBB.MY.MY
    public boolean rp() {
        int i2 = this.tV;
        boolean z2 = i2 == 2 || i2 == 0;
        if (z2) {
            this.EO.set(false);
        }
        return !z2 || super.rp();
    }

    @Override // com.bytedance.sdk.openadsdk.kBB.MY.MY
    public void tV() {
        super.tV();
    }

    @Override // com.bytedance.sdk.openadsdk.kBB.MY.MY
    public int vCE() {
        return 200;
    }
}
