package com.bytedance.sdk.component.MY.IlO.MY;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
final class Cc {
    Cc Bc;
    boolean Cc;
    int EO;
    final byte[] IlO;
    int MY;
    boolean tV;
    Cc vCE;

    public Cc() {
        this.IlO = new byte[8192];
        this.Cc = true;
        this.tV = false;
    }

    public final Cc IlO() {
        this.tV = true;
        return new Cc(this.IlO, this.MY, this.EO, true, false);
    }

    public final Cc MY() {
        Cc cc = this.vCE;
        Cc cc2 = cc != this ? cc : null;
        Cc cc3 = this.Bc;
        if (cc3 != null) {
            cc3.vCE = cc;
        }
        Cc cc4 = this.vCE;
        if (cc4 != null) {
            cc4.Bc = cc3;
        }
        this.vCE = null;
        this.Bc = null;
        return cc2;
    }

    public final Cc IlO(Cc cc) {
        cc.Bc = this;
        cc.vCE = this.vCE;
        this.vCE.Bc = cc;
        this.vCE = cc;
        return cc;
    }

    public Cc(byte[] bArr, int i2, int i8, boolean z2, boolean z7) {
        this.IlO = bArr;
        this.MY = i2;
        this.EO = i8;
        this.tV = z2;
        this.Cc = z7;
    }
}
