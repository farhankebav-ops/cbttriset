package com.bytedance.sdk.component.MY.IlO.MY;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
final class vCE {
    static Cc IlO;
    static long MY;

    private vCE() {
    }

    public static Cc IlO() {
        synchronized (vCE.class) {
            Cc cc = IlO;
            if (cc == null) {
                return new Cc();
            }
            IlO = cc.vCE;
            cc.vCE = null;
            MY -= 8192;
            return cc;
        }
    }

    public static void IlO(Cc cc) {
        if (cc.vCE == null && cc.Bc == null) {
            if (cc.tV) {
                return;
            }
            synchronized (vCE.class) {
                try {
                    long j = MY;
                    if (j + 8192 > 65536) {
                        return;
                    }
                    MY = j + 8192;
                    cc.vCE = IlO;
                    cc.EO = 0;
                    cc.MY = 0;
                    IlO = cc;
                    return;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        throw new IllegalArgumentException();
    }
}
