package l7;

import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class o implements n0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final q f12888a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f12889b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f12890c;

    public o(q fileHandle) {
        kotlin.jvm.internal.k.e(fileHandle, "fileHandle");
        this.f12888a = fileHandle;
        this.f12889b = 0L;
    }

    @Override // l7.n0, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (this.f12890c) {
            return;
        }
        this.f12890c = true;
        q qVar = this.f12888a;
        ReentrantLock reentrantLock = qVar.f12897d;
        reentrantLock.lock();
        try {
            int i2 = qVar.f12896c - 1;
            qVar.f12896c = i2;
            if (i2 == 0) {
                if (qVar.f12895b) {
                    reentrantLock.unlock();
                    qVar.a();
                }
            }
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // l7.n0, java.io.Flushable
    public final void flush() {
        if (this.f12890c) {
            throw new IllegalStateException("closed");
        }
        this.f12888a.b();
    }

    @Override // l7.n0
    public final r0 timeout() {
        return r0.NONE;
    }

    @Override // l7.n0
    public final void write(j source, long j) {
        kotlin.jvm.internal.k.e(source, "source");
        if (this.f12890c) {
            throw new IllegalStateException("closed");
        }
        long j3 = this.f12889b;
        q qVar = this.f12888a;
        qVar.getClass();
        b.e(source.f12868b, 0L, j);
        long j8 = j3 + j;
        long j9 = j3;
        while (j9 < j8) {
            k0 k0Var = source.f12867a;
            kotlin.jvm.internal.k.b(k0Var);
            int iMin = (int) Math.min(j8 - j9, k0Var.f12874c - k0Var.f12873b);
            qVar.i(j9, k0Var.f12872a, k0Var.f12873b, iMin);
            int i2 = k0Var.f12873b + iMin;
            k0Var.f12873b = i2;
            long j10 = iMin;
            j9 += j10;
            source.f12868b -= j10;
            if (i2 == k0Var.f12874c) {
                source.f12867a = k0Var.a();
                l0.a(k0Var);
            }
        }
        this.f12889b += j;
    }
}
