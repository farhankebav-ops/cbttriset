package com.bytedance.sdk.component.lEW;

import com.bytedance.sdk.component.lEW.IlO;
import com.ironsource.C2300e4;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class vCE extends Cc {
    private static volatile ThreadPoolExecutor Bc;
    private static volatile ThreadPoolExecutor Cc;
    private static volatile ThreadPoolExecutor DmF;
    private static volatile ScheduledExecutorService EV;
    public static EO MY;
    private static volatile ThreadPoolExecutor NV;
    private static volatile ThreadPoolExecutor lEW;
    private static volatile ThreadPoolExecutor vCE;
    public static final int IlO = Runtime.getRuntime().availableProcessors();
    public static int EO = 120;
    public static boolean tV = true;

    public static boolean Bc() {
        return tV;
    }

    public static ExecutorService Cc() {
        if (NV == null) {
            synchronized (vCE.class) {
                try {
                    if (NV == null) {
                        IlO IlO2 = new IlO.C0057IlO().IlO("aidl").MY(10).IlO(2).IlO(30L).IlO(TimeUnit.SECONDS).IlO(new PriorityBlockingQueue()).IlO(lEW()).IlO(Cc.IlO().createThreadFactory(10, "aidl")).IlO();
                        NV = IlO2;
                        IlO2.allowCoreThreadTimeOut(true);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return NV;
    }

    public static EO DmF() {
        return MY;
    }

    public static ExecutorService EO() {
        return IlO(10);
    }

    public static void IlO(lEW lew) {
        if (Cc == null) {
            MY();
        }
        if (lew == null || Cc == null) {
            return;
        }
        Cc.execute(lew);
    }

    public static ExecutorService MY() {
        if (Cc == null) {
            synchronized (vCE.class) {
                try {
                    if (Cc == null) {
                        Cc = new IlO.C0057IlO().IlO(C2300e4.a.f8295f).IlO(0).MY(10).IlO(5L).IlO(TimeUnit.SECONDS).IlO(new SynchronousQueue()).IlO(lEW()).IlO(Cc.IlO().createThreadFactory(10, C2300e4.a.f8295f)).IlO();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return Cc;
    }

    public static ExecutorService NV() {
        if (DmF == null) {
            synchronized (vCE.class) {
                try {
                    if (DmF == null) {
                        IlO IlO2 = new IlO.C0057IlO().IlO("computation").IlO(3).MY(10).IlO(20L).IlO(TimeUnit.SECONDS).IlO(new PriorityBlockingQueue()).IlO(lEW()).IlO(Cc.IlO().createThreadFactory(10, "computation")).IlO();
                        DmF = IlO2;
                        IlO2.allowCoreThreadTimeOut(true);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return DmF;
    }

    public static RejectedExecutionHandler lEW() {
        return new RejectedExecutionHandler() { // from class: com.bytedance.sdk.component.lEW.vCE.1
            @Override // java.util.concurrent.RejectedExecutionHandler
            public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            }
        };
    }

    public static ExecutorService tV() {
        if (lEW == null) {
            synchronized (vCE.class) {
                try {
                    if (lEW == null) {
                        IlO IlO2 = new IlO.C0057IlO().IlO("log").MY(10).IlO(4).IlO(20L).IlO(TimeUnit.SECONDS).IlO(new PriorityBlockingQueue()).IlO(lEW()).IlO(Cc.IlO().createThreadFactory(10, "log")).IlO();
                        lEW = IlO2;
                        IlO2.allowCoreThreadTimeOut(true);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return lEW;
    }

    public static ScheduledExecutorService vCE() {
        if (EV == null) {
            synchronized (vCE.class) {
                try {
                    if (EV == null) {
                        EV = Executors.newSingleThreadScheduledExecutor(Cc.IlO().createThreadFactory(5, "scheduled"));
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return EV;
    }

    public static void EO(lEW lew) {
        if (lEW == null) {
            tV();
        }
        if (lew == null || lEW == null) {
            return;
        }
        lEW.execute(lew);
    }

    public static ExecutorService IlO(int i2) {
        if (vCE == null) {
            synchronized (vCE.class) {
                try {
                    if (vCE == null) {
                        IlO IlO2 = new IlO.C0057IlO().IlO("io").IlO(2).MY(i2).IlO(20L).IlO(TimeUnit.SECONDS).IlO(new LinkedBlockingQueue()).IlO(lEW()).IlO(Cc.IlO().createThreadFactory(i2, "io")).IlO();
                        vCE = IlO2;
                        IlO2.allowCoreThreadTimeOut(true);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return vCE;
    }

    public static void EO(lEW lew, int i2) {
        if (lew != null) {
            lew.setPriority(i2);
        }
        tV(lew);
    }

    public static void EO(int i2) {
        EO = i2;
    }

    public static void MY(lEW lew) {
        if (vCE == null) {
            EO();
        }
        if (vCE != null) {
            vCE.execute(lew);
        }
    }

    public static void Cc(lEW lew) {
        if (Bc == null) {
            MY(5);
        }
        if (lew == null || Bc == null) {
            return;
        }
        Bc.execute(lew);
    }

    public static void tV(lEW lew) {
        if (NV == null) {
            Cc();
        }
        if (lew == null || NV == null) {
            return;
        }
        NV.execute(lew);
    }

    public static void MY(lEW lew, int i2) {
        if (lew != null) {
            lew.setPriority(i2);
        }
        EO(lew);
    }

    public static void IlO(lEW lew, int i2) {
        MY(lew);
    }

    public static void IlO(lEW lew, int i2, int i8) {
        if (vCE == null) {
            IlO(i8);
        }
        if (lew == null || vCE == null) {
            return;
        }
        lew.setPriority(i2);
        vCE.execute(lew);
    }

    public static ExecutorService MY(int i2) {
        if (Bc == null) {
            synchronized (vCE.class) {
                try {
                    if (Bc == null) {
                        IlO IlO2 = new IlO.C0057IlO().IlO("ad").IlO(2).MY(i2).IlO(20L).IlO(TimeUnit.SECONDS).IlO(new LinkedBlockingQueue()).IlO(lEW()).IlO(Cc.IlO().createThreadFactory(i2, "ad")).IlO();
                        Bc = IlO2;
                        IlO2.allowCoreThreadTimeOut(true);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return Bc;
    }

    public static void IlO(boolean z2) {
        tV = z2;
    }

    public static void IlO(EO eo) {
        MY = eo;
    }
}
