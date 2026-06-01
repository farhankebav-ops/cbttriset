package com.bytedance.sdk.openadsdk.core.model;

import com.bytedance.sdk.openadsdk.utils.DM;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class vSq {
    private long Bc;
    private long Cc;
    private long DmF;
    private int EV;
    public boolean IlO;
    public long MY;
    private long NV;
    private long lEW;
    private long vCE;
    private DM EO = DM.EO();
    private DM tV = DM.EO();

    public long Bc() {
        return this.NV;
    }

    public long Cc() {
        return this.lEW;
    }

    public long EO() {
        return this.vCE;
    }

    public void IlO(DM dm, DM dm2, int i2, DM dm3) {
        this.Cc = dm.IlO(this.EO);
        this.vCE = dm2.IlO(dm);
        this.Bc = i2;
        this.lEW = dm3.IlO(dm2);
    }

    public void MY(DM dm) {
        this.tV = dm;
        this.DmF = dm.IlO(this.EO);
    }

    public int lEW() {
        return this.EV;
    }

    public long tV() {
        return this.Bc;
    }

    public long vCE() {
        return this.DmF;
    }

    public long MY() {
        return this.Cc;
    }

    public void IlO(DM dm) {
        this.EO = dm;
    }

    public DM IlO() {
        return this.EO;
    }

    public void IlO(long j) {
        this.NV = j;
    }

    public void IlO(int i2) {
        this.EV = i2;
    }
}
