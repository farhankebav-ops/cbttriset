package l7;

import java.io.Closeable;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class q implements Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f12894a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f12895b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f12896c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ReentrantLock f12897d = new ReentrantLock();

    public q(boolean z2) {
        this.f12894a = z2;
    }

    public static o j(q qVar) {
        if (!qVar.f12894a) {
            throw new IllegalStateException("file handle is read-only");
        }
        ReentrantLock reentrantLock = qVar.f12897d;
        reentrantLock.lock();
        try {
            if (qVar.f12895b) {
                throw new IllegalStateException("closed");
            }
            qVar.f12896c++;
            reentrantLock.unlock();
            return new o(qVar);
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public abstract void a();

    public abstract void b();

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        ReentrantLock reentrantLock = this.f12897d;
        reentrantLock.lock();
        try {
            if (this.f12895b) {
                return;
            }
            this.f12895b = true;
            if (this.f12896c != 0) {
                return;
            }
            reentrantLock.unlock();
            a();
        } finally {
            reentrantLock.unlock();
        }
    }

    public abstract int e(long j, byte[] bArr, int i2, int i8);

    public final void flush() {
        if (!this.f12894a) {
            throw new IllegalStateException("file handle is read-only");
        }
        ReentrantLock reentrantLock = this.f12897d;
        reentrantLock.lock();
        try {
            if (this.f12895b) {
                throw new IllegalStateException("closed");
            }
            reentrantLock.unlock();
            b();
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public abstract long g();

    public abstract void i(long j, byte[] bArr, int i2, int i8);

    public final p k(long j) {
        ReentrantLock reentrantLock = this.f12897d;
        reentrantLock.lock();
        try {
            if (this.f12895b) {
                throw new IllegalStateException("closed");
            }
            this.f12896c++;
            reentrantLock.unlock();
            return new p(this, j);
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public final long size() {
        ReentrantLock reentrantLock = this.f12897d;
        reentrantLock.lock();
        try {
            if (this.f12895b) {
                throw new IllegalStateException("closed");
            }
            reentrantLock.unlock();
            return g();
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }
}
