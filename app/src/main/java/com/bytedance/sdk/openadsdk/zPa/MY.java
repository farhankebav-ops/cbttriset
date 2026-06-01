package com.bytedance.sdk.openadsdk.zPa;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class MY {
    public static int Cc = 3;
    public static int EO = 1;
    public static int IlO = -1;
    public static int MY = 0;
    public static int tV = 2;
    private int vCE = IlO;
    private long Bc = 0;
    private long lEW = 0;
    private final List<EO> DmF = new ArrayList();
    private long NV = 0;

    public void EO(long j) {
        int i2;
        int i8 = this.vCE;
        if (i8 == IlO || i8 == (i2 = tV) || i8 == Cc) {
            return;
        }
        this.vCE = i2;
        this.NV = j;
    }

    public void IlO(long j) {
        this.vCE = MY;
        this.Bc = j;
    }

    public void MY(long j) {
        int i2;
        int i8 = this.vCE;
        if (i8 == IlO || i8 == (i2 = Cc)) {
            return;
        }
        this.vCE = i2;
        this.lEW = j;
    }

    public void tV(long j) {
        int i2 = this.vCE;
        if (i2 == IlO || i2 != tV) {
            return;
        }
        this.vCE = EO;
        this.DmF.add(new EO(this.NV, j));
        this.NV = 0L;
    }

    public long IlO(long j, long j3) {
        long j8;
        long j9;
        long jMY;
        long j10 = this.lEW;
        if (j10 != 0 && j > j10) {
            return 0L;
        }
        int i2 = 0;
        for (EO eo : this.DmF) {
            if (eo.MY() > j) {
                if (j < eo.IlO()) {
                    j9 = i2;
                    jMY = eo.MY() - eo.IlO();
                } else {
                    j9 = i2;
                    jMY = eo.MY() - j;
                }
                i2 = (int) (jMY + j9);
            }
        }
        long j11 = this.Bc;
        if (j11 < j) {
            long j12 = this.NV;
            if (j12 == 0) {
                j12 = this.lEW;
                if (j12 == 0) {
                    j8 = j3 - j;
                }
            } else if (j12 <= j) {
                return 0L;
            }
            return (j12 - j) - ((long) i2);
        }
        long j13 = this.NV;
        if (j13 == 0) {
            j13 = this.lEW;
            if (j13 == 0) {
                j8 = j3 - j11;
            }
        } else if (j13 <= j11) {
            return 0L;
        }
        return (j13 - j11) - ((long) i2);
        return j8 - ((long) i2);
    }

    public int IlO() {
        return this.vCE;
    }
}
