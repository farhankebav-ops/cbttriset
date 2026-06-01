package com.bytedance.sdk.openadsdk.component.Cc;

import com.bytedance.sdk.openadsdk.core.model.oeT;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class MY {
    private boolean Bc;
    private int Cc;
    private oeT EO;
    private int IlO;
    private int MY;
    private com.bytedance.sdk.openadsdk.core.model.IlO tV;
    private String vCE;

    public MY(int i2, int i8, oeT oet, com.bytedance.sdk.openadsdk.core.model.IlO ilO) {
        this.IlO = i2;
        this.MY = i8;
        this.EO = oet;
        this.tV = ilO;
    }

    public String Bc() {
        return this.vCE;
    }

    public oeT Cc() {
        return this.EO;
    }

    public int EO() {
        return this.IlO;
    }

    public com.bytedance.sdk.openadsdk.core.model.IlO IlO() {
        return this.tV;
    }

    public boolean MY() {
        return this.Bc;
    }

    public int tV() {
        return this.MY;
    }

    public int vCE() {
        return this.Cc;
    }

    public void IlO(boolean z2) {
        this.Bc = z2;
    }

    public MY(int i2, int i8, int i9, String str) {
        this.IlO = i2;
        this.MY = i8;
        this.Cc = i9;
        this.vCE = str;
    }
}
