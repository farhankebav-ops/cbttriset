package com.bytedance.sdk.component.vCE.IlO;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class IlO {
    private com.bytedance.sdk.component.vCE.IlO.tV.MY.IlO Bc;
    private com.bytedance.sdk.component.vCE.IlO.tV.MY.IlO Cc;
    private Cc DmF;
    private com.bytedance.sdk.component.vCE.IlO.tV.MY.IlO EO;
    private int EV;
    private com.bytedance.sdk.component.vCE.IlO.IlO.Cc IlO;
    private com.bytedance.sdk.component.vCE.IlO.MY.EO MY;
    private boolean NV;
    private long hp;
    private boolean lEW;
    private int rp;
    private com.bytedance.sdk.component.vCE.IlO.tV.MY.IlO tV;
    private com.bytedance.sdk.component.vCE.IlO.tV.MY.IlO vCE;

    /* JADX INFO: renamed from: com.bytedance.sdk.component.vCE.IlO.IlO$IlO, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class C0061IlO {
        private Cc Bc;
        private com.bytedance.sdk.component.vCE.IlO.tV.MY.IlO Cc;
        private boolean DmF;
        private com.bytedance.sdk.component.vCE.IlO.tV.MY.IlO EO;
        private com.bytedance.sdk.component.vCE.IlO.MY.EO IlO;
        private com.bytedance.sdk.component.vCE.IlO.tV.MY.IlO MY;
        private com.bytedance.sdk.component.vCE.IlO.IlO.Cc lEW;
        private long rp;
        private com.bytedance.sdk.component.vCE.IlO.tV.MY.IlO tV;
        private boolean vCE;
        private int NV = 5000;
        private int EV = 10;

        public C0061IlO EO(com.bytedance.sdk.component.vCE.IlO.tV.MY.IlO ilO) {
            this.tV = ilO;
            return this;
        }

        public C0061IlO IlO(long j) {
            this.rp = j;
            return this;
        }

        public C0061IlO MY(com.bytedance.sdk.component.vCE.IlO.tV.MY.IlO ilO) {
            this.EO = ilO;
            return this;
        }

        public C0061IlO IlO(com.bytedance.sdk.component.vCE.IlO.IlO.Cc cc) {
            this.lEW = cc;
            return this;
        }

        public C0061IlO MY(int i2) {
            this.EV = i2;
            return this;
        }

        public C0061IlO IlO(Cc cc) {
            this.Bc = cc;
            return this;
        }

        public C0061IlO IlO(boolean z2) {
            this.vCE = z2;
            return this;
        }

        public C0061IlO IlO(com.bytedance.sdk.component.vCE.IlO.tV.MY.IlO ilO) {
            this.MY = ilO;
            return this;
        }

        public C0061IlO IlO(com.bytedance.sdk.component.vCE.IlO.MY.EO eo) {
            this.IlO = eo;
            return this;
        }

        public C0061IlO IlO(int i2) {
            this.NV = i2;
            return this;
        }

        public IlO IlO() {
            IlO ilO = new IlO();
            ilO.MY = this.IlO;
            ilO.EO = this.MY;
            ilO.tV = this.EO;
            ilO.Cc = this.tV;
            ilO.vCE = this.Cc;
            ilO.lEW = this.vCE;
            ilO.DmF = this.Bc;
            ilO.IlO = this.lEW;
            ilO.NV = this.DmF;
            ilO.rp = this.EV;
            ilO.EV = this.NV;
            ilO.hp = this.rp;
            return ilO;
        }
    }

    public com.bytedance.sdk.component.vCE.IlO.tV.MY.IlO Bc() {
        return this.EO;
    }

    public long Cc() {
        return this.hp;
    }

    public com.bytedance.sdk.component.vCE.IlO.tV.MY.IlO DmF() {
        return this.Cc;
    }

    public boolean EV() {
        return this.lEW;
    }

    public com.bytedance.sdk.component.vCE.IlO.MY.EO NV() {
        return this.MY;
    }

    public int hp() {
        return this.rp;
    }

    public com.bytedance.sdk.component.vCE.IlO.tV.MY.IlO lEW() {
        return this.tV;
    }

    public int rp() {
        return this.EV;
    }

    public com.bytedance.sdk.component.vCE.IlO.tV.MY.IlO vCE() {
        return this.Bc;
    }

    private IlO() {
        this.EV = 200;
        this.rp = 10;
    }

    public boolean EO() {
        return this.NV;
    }

    public Cc tV() {
        return this.DmF;
    }

    public com.bytedance.sdk.component.vCE.IlO.tV.MY.IlO MY() {
        return this.vCE;
    }

    public com.bytedance.sdk.component.vCE.IlO.IlO.Cc IlO() {
        return this.IlO;
    }
}
