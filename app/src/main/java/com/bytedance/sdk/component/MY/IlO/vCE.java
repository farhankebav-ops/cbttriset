package com.bytedance.sdk.component.MY.IlO;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class vCE {
    private final String[] IlO;

    public vCE(String[] strArr) {
        this.IlO = strArr;
    }

    public int IlO() {
        return this.IlO.length / 2;
    }

    public String MY(int i2) {
        return this.IlO[(i2 * 2) + 1];
    }

    public String IlO(int i2) {
        return this.IlO[i2 * 2];
    }
}
