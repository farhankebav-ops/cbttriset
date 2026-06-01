package com.bytedance.sdk.openadsdk.tV.Cc.MY;

import com.bykv.vk.openvk.IlO.IlO.IlO.EO.a;
import com.bykv.vk.openvk.IlO.IlO.IlO.EO.b;
import com.bytedance.sdk.openadsdk.core.model.oeT;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class ea {
    private oeT Cc;
    private int EO;
    private long IlO;
    private String MY;
    private a tV;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class IlO {
        private int Bc;
        private int DmF;
        private int NV;
        private int lEW;
        private b rp;
        private int vCE;
        private long IlO = 0;
        private long MY = 0;
        private long EO = 0;
        private long tV = 0;
        private boolean Cc = false;
        private boolean EV = false;

        private void bWL() {
            long j = this.EO;
            if (j > 0) {
                long j3 = this.IlO;
                if (j3 > j) {
                    long j8 = j3 % j;
                    this.IlO = j8;
                    if (j8 == 0) {
                        this.IlO = j;
                    }
                }
            }
        }

        public int Bc() {
            long j = this.EO;
            if (j <= 0) {
                return 0;
            }
            return Math.min((int) ((this.IlO * 100) / j), 100);
        }

        public int Cc() {
            return this.vCE;
        }

        public int DmF() {
            return this.DmF;
        }

        public long EO() {
            return this.MY;
        }

        public boolean EV() {
            return this.EV;
        }

        public long IlO() {
            return this.tV;
        }

        public long MY() {
            return this.IlO;
        }

        public int NV() {
            return this.NV;
        }

        public b hp() {
            return this.rp;
        }

        public int lEW() {
            return this.lEW;
        }

        public boolean rp() {
            return this.Cc;
        }

        public long tV() {
            return this.EO;
        }

        public int vCE() {
            return this.Bc;
        }

        public void EO(long j) {
            this.MY = j;
        }

        public void IlO(long j) {
            this.tV = j;
        }

        public void MY(long j) {
            this.IlO = j;
            bWL();
        }

        public void tV(long j) {
            this.EO = j;
            bWL();
        }

        public void EO(int i2) {
            this.lEW = i2;
        }

        public void IlO(int i2) {
            this.vCE = i2;
        }

        public void IlO(boolean z2) {
            this.Cc = z2;
        }

        public void MY(int i2) {
            this.Bc = i2;
        }

        public void tV(int i2) {
            this.NV = i2;
        }

        public void IlO(b bVar) {
            this.rp = bVar;
        }
    }

    public ea(long j, String str, int i2, a aVar, oeT oet) {
        this.IlO = j;
        this.MY = str;
        this.EO = i2;
        this.tV = aVar;
        this.Cc = oet;
    }

    public oeT Cc() {
        return this.Cc;
    }

    public int EO() {
        return this.EO;
    }

    public long IlO() {
        return this.IlO;
    }

    public String MY() {
        return this.MY;
    }

    public a tV() {
        return this.tV;
    }
}
