package q6;

import androidx.core.location.LocationRequestCompat;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class d0 extends v0 implements Runnable {
    private static volatile Thread _thread;
    private static volatile int debugStatus;
    public static final d0 h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final long f13541i;

    static {
        Long l;
        d0 d0Var = new d0();
        h = d0Var;
        d0Var.r(false);
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        try {
            l = Long.getLong("kotlinx.coroutines.DefaultExecutor.keepAlive", 1000L);
        } catch (SecurityException unused) {
            l = 1000L;
        }
        f13541i = timeUnit.toNanos(l.longValue());
    }

    public final synchronized void X() {
        int i2 = debugStatus;
        if (i2 == 2 || i2 == 3) {
            debugStatus = 3;
            v0.e.set(this, null);
            v0.f13595f.set(this, null);
            notifyAll();
        }
    }

    @Override // q6.v0, q6.h0
    public final o0 e(long j, Runnable runnable, v5.h hVar) {
        long j3 = j > 0 ? j >= 9223372036854L ? LocationRequestCompat.PASSIVE_INTERVAL : 1000000 * j : 0L;
        if (j3 >= 4611686018427387903L) {
            return r1.f13582a;
        }
        long jNanoTime = System.nanoTime();
        s0 s0Var = new s0(j3 + jNanoTime, runnable);
        W(jNanoTime, s0Var);
        return s0Var;
    }

    @Override // q6.w0
    public final Thread q() {
        Thread thread;
        Thread thread2 = _thread;
        if (thread2 != null) {
            return thread2;
        }
        synchronized (this) {
            thread = _thread;
            if (thread == null) {
                thread = new Thread(this, "kotlinx.coroutines.DefaultExecutor");
                _thread = thread;
                thread.setContextClassLoader(h.getClass().getClassLoader());
                thread.setDaemon(true);
                thread.start();
            }
        }
        return thread;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean zY;
        x1.f13601a.set(this);
        try {
            synchronized (this) {
                int i2 = debugStatus;
                if (i2 == 2 || i2 == 3) {
                    if (zY) {
                        return;
                    } else {
                        return;
                    }
                }
                debugStatus = 1;
                notifyAll();
                long j = Long.MAX_VALUE;
                while (true) {
                    Thread.interrupted();
                    long jS = s();
                    if (jS == LocationRequestCompat.PASSIVE_INTERVAL) {
                        long jNanoTime = System.nanoTime();
                        if (j == LocationRequestCompat.PASSIVE_INTERVAL) {
                            j = f13541i + jNanoTime;
                        }
                        long j3 = j - jNanoTime;
                        if (j3 <= 0) {
                            _thread = null;
                            X();
                            if (y()) {
                                return;
                            }
                            q();
                            return;
                        }
                        if (jS > j3) {
                            jS = j3;
                        }
                    } else {
                        j = Long.MAX_VALUE;
                    }
                    if (jS > 0) {
                        int i8 = debugStatus;
                        if (i8 == 2 || i8 == 3) {
                            _thread = null;
                            X();
                            if (y()) {
                                return;
                            }
                            q();
                            return;
                        }
                        LockSupport.parkNanos(this, jS);
                    }
                }
            }
        } finally {
            _thread = null;
            X();
            if (!y()) {
                q();
            }
        }
    }

    @Override // q6.v0, q6.w0
    public final void shutdown() {
        debugStatus = 4;
        super.shutdown();
    }

    @Override // q6.w
    public final String toString() {
        return "DefaultExecutor";
    }

    @Override // q6.w0
    public final void u(long j, t0 t0Var) {
        throw new RejectedExecutionException("DefaultExecutor was shut down. This error indicates that Dispatchers.shutdown() was invoked prior to completion of exiting coroutines, leaving coroutines in incomplete state. Please refer to Dispatchers.shutdown documentation for more details");
    }

    @Override // q6.v0
    public final void v(Runnable runnable) {
        if (debugStatus == 4) {
            throw new RejectedExecutionException("DefaultExecutor was shut down. This error indicates that Dispatchers.shutdown() was invoked prior to completion of exiting coroutines, leaving coroutines in incomplete state. Please refer to Dispatchers.shutdown documentation for more details");
        }
        super.v(runnable);
    }
}
