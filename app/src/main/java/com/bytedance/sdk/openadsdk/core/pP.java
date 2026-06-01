package com.bytedance.sdk.openadsdk.core;

import androidx.annotation.MainThread;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class pP {
    private static pP IlO;
    private com.bytedance.sdk.openadsdk.IlO.EO.MY Cc;
    private com.bytedance.sdk.openadsdk.core.model.oeT EO;
    private com.bytedance.sdk.openadsdk.core.model.IlO MY;
    private com.bytedance.sdk.openadsdk.IlO.Cc.IlO tV;
    private com.bytedance.sdk.openadsdk.IlO.tV.MY vCE;

    private pP() {
    }

    @MainThread
    public static pP IlO() {
        if (IlO == null) {
            IlO = new pP();
        }
        return IlO;
    }

    public com.bytedance.sdk.openadsdk.core.model.IlO Bc() {
        return this.MY;
    }

    public com.bytedance.sdk.openadsdk.IlO.tV.MY Cc() {
        return this.vCE;
    }

    public com.bytedance.sdk.openadsdk.IlO.Cc.IlO EO() {
        return this.tV;
    }

    public com.bytedance.sdk.openadsdk.core.model.oeT MY() {
        return this.EO;
    }

    public com.bytedance.sdk.openadsdk.IlO.EO.MY tV() {
        return this.Cc;
    }

    public void vCE() {
        this.EO = null;
        this.MY = null;
        this.tV = null;
        this.Cc = null;
        this.vCE = null;
    }

    public void IlO(com.bytedance.sdk.openadsdk.core.model.oeT oet) {
        this.EO = oet;
    }

    public void IlO(com.bytedance.sdk.openadsdk.IlO.EO.MY my) {
        this.Cc = my;
    }

    public void IlO(com.bytedance.sdk.openadsdk.IlO.Cc.IlO ilO) {
        this.tV = ilO;
    }

    public void IlO(com.bytedance.sdk.openadsdk.IlO.tV.MY my) {
        this.vCE = my;
    }

    public void IlO(com.bytedance.sdk.openadsdk.core.model.IlO ilO) {
        this.MY = ilO;
    }
}
