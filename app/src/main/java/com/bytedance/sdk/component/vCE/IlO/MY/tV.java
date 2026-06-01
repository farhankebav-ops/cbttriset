package com.bytedance.sdk.component.vCE.IlO.MY;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.sdk.component.vCE.IlO.Cc;
import com.bytedance.sdk.component.vCE.IlO.lEW;
import java.util.Comparator;
import java.util.concurrent.Executor;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class tV {
    private volatile com.bytedance.sdk.component.vCE.IlO.MY.EO.EO DmF;
    private final Comparator<com.bytedance.sdk.component.vCE.IlO.tV.IlO> EV;
    private volatile Handler NV;
    private final PriorityBlockingQueue<com.bytedance.sdk.component.vCE.IlO.tV.IlO> rp;
    public static final tV IlO = new tV();
    public static final com.bytedance.sdk.component.vCE.IlO.MY.IlO.IlO tV = new com.bytedance.sdk.component.vCE.IlO.MY.IlO.IlO();
    public static final AtomicLong Cc = new AtomicLong(0);
    public static final AtomicLong vCE = new AtomicLong(0);
    public static final long Bc = System.currentTimeMillis();
    public static long lEW = 0;
    public volatile boolean MY = false;
    public volatile boolean EO = false;

    private tV() {
        Comparator<com.bytedance.sdk.component.vCE.IlO.tV.IlO> comparator = new Comparator<com.bytedance.sdk.component.vCE.IlO.tV.IlO>() { // from class: com.bytedance.sdk.component.vCE.IlO.MY.tV.1
            @Override // java.util.Comparator
            /* JADX INFO: renamed from: IlO, reason: merged with bridge method [inline-methods] */
            public int compare(com.bytedance.sdk.component.vCE.IlO.tV.IlO ilO, com.bytedance.sdk.component.vCE.IlO.tV.IlO ilO2) {
                return tV.this.IlO(ilO, ilO2);
            }
        };
        this.EV = comparator;
        this.rp = new PriorityBlockingQueue<>(8, comparator);
    }

    public void Cc() {
        com.bytedance.sdk.component.vCE.IlO.EO.MY.IlO(tV.YA(), 1);
        final com.bytedance.sdk.component.vCE.IlO.MY.EO.EO eo = this.DmF;
        if (Looper.myLooper() != Looper.getMainLooper()) {
            if (eo != null) {
                eo.EO(2);
                return;
            }
            return;
        }
        Cc ccZPa = lEW.Bc().zPa();
        if (ccZPa != null) {
            Executor executorTV = ccZPa.tV();
            if (executorTV == null) {
                executorTV = ccZPa.Cc();
            }
            if (executorTV != null) {
                executorTV.execute(new com.bytedance.sdk.component.vCE.IlO.Cc.Cc("flush") { // from class: com.bytedance.sdk.component.vCE.IlO.MY.tV.3
                    @Override // java.lang.Runnable
                    public void run() {
                        com.bytedance.sdk.component.vCE.IlO.MY.EO.EO eo2 = eo;
                        if (eo2 != null) {
                            eo2.EO(2);
                        }
                    }
                });
            }
        }
    }

    public void EO() {
        if (this.DmF == null || !this.DmF.isAlive()) {
            return;
        }
        synchronized (this) {
            try {
                if (this.DmF != null && this.DmF.isAlive()) {
                    if (this.NV != null) {
                        this.NV.removeCallbacksAndMessages(null);
                    }
                    this.DmF.IlO(false);
                    this.DmF.quitSafely();
                    this.DmF = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void MY() {
        tV();
        Cc();
    }

    public boolean tV() {
        try {
            if (this.DmF != null || com.bytedance.sdk.component.vCE.IlO.MY.MY()) {
                return false;
            }
            synchronized (this) {
                if (this.DmF != null) {
                    return false;
                }
                this.DmF = new com.bytedance.sdk.component.vCE.IlO.MY.EO.EO(this.rp);
                this.DmF.start();
                return true;
            }
        } catch (Throwable th) {
            th.getMessage();
            return false;
        }
    }

    public PriorityBlockingQueue<com.bytedance.sdk.component.vCE.IlO.tV.IlO> IlO() {
        return this.rp;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int IlO(com.bytedance.sdk.component.vCE.IlO.tV.IlO ilO, com.bytedance.sdk.component.vCE.IlO.tV.IlO ilO2) {
        long jIlO;
        long jMY;
        long jMY2;
        long jIlO2;
        if (ilO == null) {
            return ilO2 == null ? 0 : -1;
        }
        if (ilO2 == null) {
            return 1;
        }
        if (ilO.Cc() == ilO2.Cc()) {
            if (ilO.IlO() != null) {
                jIlO = ilO.IlO().IlO();
                jMY = ilO.IlO().MY();
            } else {
                jIlO = 0;
                jMY = 0;
            }
            if (ilO2.IlO() != null) {
                jIlO2 = ilO2.IlO().IlO();
                jMY2 = ilO2.IlO().MY();
            } else {
                jMY2 = 0;
                jIlO2 = 0;
            }
            if (jIlO == 0 || jIlO2 == 0) {
                return 0;
            }
            long j = jIlO - jIlO2;
            if (Math.abs(j) > 2147483647L) {
                return 0;
            }
            if (j != 0) {
                return (int) j;
            }
            if (jMY == 0 || jMY2 == 0) {
                return 0;
            }
            return (int) (jMY - jMY2);
        }
        return ilO.Cc() - ilO2.Cc();
    }

    public void IlO(Handler handler) {
        this.NV = handler;
    }

    public void IlO(com.bytedance.sdk.component.vCE.IlO.tV.IlO ilO, int i2) {
        tV();
        Cc ccZPa = lEW.Bc().zPa();
        com.bytedance.sdk.component.vCE.IlO.MY.EO.EO eo = this.DmF;
        if (eo != null) {
            IlO(ccZPa, ilO);
            eo.IlO(ilO, ilO.Cc() == 4);
        }
    }

    private void IlO(final Cc cc, com.bytedance.sdk.component.vCE.IlO.tV.IlO ilO) {
        if (cc != null) {
            try {
                if (cc.Bc()) {
                    final long jMY = (ilO == null || ilO.IlO() == null) ? 0L : ilO.IlO().MY();
                    if (jMY == 1) {
                        lEW = System.currentTimeMillis();
                    }
                    AtomicLong atomicLongIi = tV.ii();
                    com.bytedance.sdk.component.vCE.IlO.EO.MY.IlO(atomicLongIi, 1);
                    if (atomicLongIi.get() == 200) {
                        try {
                            if (Looper.getMainLooper() == Looper.myLooper()) {
                                Executor executorTV = cc.tV();
                                if (executorTV == null) {
                                    executorTV = cc.Cc();
                                }
                                if (executorTV != null) {
                                    executorTV.execute(new com.bytedance.sdk.component.vCE.IlO.Cc.Cc("report") { // from class: com.bytedance.sdk.component.vCE.IlO.MY.tV.2
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            tV.this.IlO(cc, jMY);
                                        }
                                    });
                                }
                            } else {
                                IlO(cc, jMY);
                            }
                        } catch (Exception unused) {
                        }
                    }
                }
            } catch (Exception unused2) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IlO(Cc cc, long j) {
        com.bytedance.sdk.component.vCE.IlO.MY.EO.EO eo = this.DmF;
        if (cc == null || eo == null) {
            return;
        }
        com.bytedance.sdk.component.vCE.IlO.MY.IlO.IlO ilO = tV;
        eo.IlO(cc.IlO(ilO.MY(j)), true);
        ilO.AK();
    }
}
