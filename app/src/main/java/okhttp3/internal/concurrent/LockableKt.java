package okhttp3.internal.concurrent;

import e6.a;
import kotlin.jvm.internal.k;
import okhttp3.internal._UtilJvmKt;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class LockableKt {
    public static final void assertLockHeld(Lockable lockable) {
        k.e(lockable, "<this>");
        if (!_UtilJvmKt.assertionsEnabled || Thread.holdsLock(lockable)) {
            return;
        }
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + lockable);
    }

    public static final void assertLockNotHeld(Lockable lockable) {
        k.e(lockable, "<this>");
        if (_UtilJvmKt.assertionsEnabled && Thread.holdsLock(lockable)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + lockable);
        }
    }

    public static final void awaitNanos(Lockable lockable, long j) throws InterruptedException {
        k.e(lockable, "<this>");
        long j3 = j / 1000000;
        long j8 = j - (1000000 * j3);
        if (j3 > 0 || j > 0) {
            lockable.wait(j3, (int) j8);
        }
    }

    public static final void notify(Lockable lockable) {
        k.e(lockable, "<this>");
        lockable.notify();
    }

    public static final void notifyAll(Lockable lockable) {
        k.e(lockable, "<this>");
        lockable.notifyAll();
    }

    public static final void wait(Lockable lockable) throws InterruptedException {
        k.e(lockable, "<this>");
        lockable.wait();
    }

    public static final <T> T withLock(Lockable lockable, a action) {
        T t3;
        k.e(lockable, "<this>");
        k.e(action, "action");
        synchronized (lockable) {
            t3 = (T) action.invoke();
        }
        return t3;
    }
}
