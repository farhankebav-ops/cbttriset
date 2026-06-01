package com.google.android.gms.internal.ads;

import com.ironsource.C2300e4;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.LockSupport;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
abstract class zzgup extends AtomicReference implements Runnable {
    private static final Runnable zza = new zzguo(null);
    private static final Runnable zzb = new zzguo(null);

    private final void zzb(Thread thread) {
        Runnable runnable = (Runnable) get();
        zzgun zzgunVar = null;
        boolean z2 = false;
        int i2 = 0;
        while (true) {
            if (!(runnable instanceof zzgun)) {
                if (runnable != zzb) {
                    break;
                }
            } else {
                zzgunVar = (zzgun) runnable;
            }
            i2++;
            if (i2 > 1000) {
                Runnable runnable2 = zzb;
                if (runnable == runnable2 || compareAndSet(runnable, runnable2)) {
                    z2 = Thread.interrupted() || z2;
                    LockSupport.park(zzgunVar);
                }
            } else {
                Thread.yield();
            }
            runnable = (Runnable) get();
        }
        if (z2) {
            thread.interrupt();
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        Thread threadCurrentThread = Thread.currentThread();
        Object objZza = null;
        if (compareAndSet(null, threadCurrentThread)) {
            boolean zZzd = zzd();
            if (!zZzd) {
                try {
                    objZza = zza();
                } catch (Throwable th) {
                    try {
                        zzgva.zza(th);
                        if (!compareAndSet(threadCurrentThread, zza)) {
                            zzb(threadCurrentThread);
                        }
                        zzg(th);
                        return;
                    } catch (Throwable th2) {
                        if (!compareAndSet(threadCurrentThread, zza)) {
                            zzb(threadCurrentThread);
                        }
                        zzf(null);
                        throw th2;
                    }
                }
            }
            if (!compareAndSet(threadCurrentThread, zza)) {
                zzb(threadCurrentThread);
            }
            if (zZzd) {
                return;
            }
            zzf(objZza);
        }
    }

    @Override // java.util.concurrent.atomic.AtomicReference
    public final String toString() {
        String strS;
        Runnable runnable = (Runnable) get();
        if (runnable == zza) {
            strS = "running=[DONE]";
        } else if (runnable instanceof zzgun) {
            strS = "running=[INTERRUPTED]";
        } else if (runnable instanceof Thread) {
            String name = ((Thread) runnable).getName();
            strS = a1.a.s(new StringBuilder(String.valueOf(name).length() + 21), "running=[RUNNING ON ", name, C2300e4.i.e);
        } else {
            strS = "running=[NOT STARTED YET]";
        }
        String strZzc = zzc();
        return a1.a.s(new StringBuilder(strS.length() + 2 + String.valueOf(strZzc).length()), strS, ", ", strZzc);
    }

    public abstract Object zza() throws Exception;

    public abstract String zzc();

    public abstract boolean zzd();

    public abstract void zzf(Object obj);

    public abstract void zzg(Throwable th);

    public final void zzh() {
        Runnable runnable = (Runnable) get();
        if (runnable instanceof Thread) {
            zzgun zzgunVar = new zzgun(this, null);
            zzgunVar.zza(Thread.currentThread());
            if (compareAndSet(runnable, zzgunVar)) {
                try {
                    Thread thread = (Thread) runnable;
                    thread.interrupt();
                    if (((Runnable) getAndSet(zza)) == zzb) {
                        LockSupport.unpark(thread);
                    }
                } catch (Throwable th) {
                    if (((Runnable) getAndSet(zza)) == zzb) {
                        LockSupport.unpark((Thread) runnable);
                    }
                    throw th;
                }
            }
        }
    }
}
