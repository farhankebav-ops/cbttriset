package com.bytedance.sdk.openadsdk.component.lEW;

import com.ironsource.C2300e4;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class IlO {
    private boolean EO;
    private float IlO;
    private long MY;
    private long tV;

    public long EO() {
        return this.MY;
    }

    public void IlO(boolean z2) {
        this.EO = z2;
    }

    public float MY() {
        return this.IlO;
    }

    public long IlO() {
        return this.tV;
    }

    public void MY(long j) {
        this.MY = j;
    }

    public void IlO(long j) {
        this.tV = j;
    }

    public void IlO(float f4) {
        StringBuilder sb = new StringBuilder("setTotalTime() called with: time = [");
        sb.append(f4);
        sb.append(C2300e4.i.e);
        this.IlO = f4;
    }
}
