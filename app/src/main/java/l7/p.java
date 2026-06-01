package l7;

import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class p implements o0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final q f12891a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f12892b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f12893c;

    public p(q qVar, long j) {
        this.f12891a = qVar;
        this.f12892b = j;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (this.f12893c) {
            return;
        }
        this.f12893c = true;
        q qVar = this.f12891a;
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

    @Override // l7.o0
    public final long read(j sink, long j) {
        long j3;
        long j8;
        kotlin.jvm.internal.k.e(sink, "sink");
        if (this.f12893c) {
            throw new IllegalStateException("closed");
        }
        long j9 = this.f12892b;
        if (j < 0) {
            throw new IllegalArgumentException(androidx.camera.core.processing.util.a.j("byteCount < 0: ", j).toString());
        }
        long j10 = j + j9;
        long j11 = j9;
        while (true) {
            if (j11 >= j10) {
                j3 = -1;
                break;
            }
            k0 k0VarV = sink.v(1);
            j3 = -1;
            long j12 = j10;
            int iE = this.f12891a.e(j11, k0VarV.f12872a, k0VarV.f12874c, (int) Math.min(j10 - j11, 8192 - r10));
            if (iE == -1) {
                if (k0VarV.f12873b == k0VarV.f12874c) {
                    sink.f12867a = k0VarV.a();
                    l0.a(k0VarV);
                }
                if (j9 == j11) {
                    j8 = -1;
                }
            } else {
                k0VarV.f12874c += iE;
                long j13 = iE;
                j11 += j13;
                sink.f12868b += j13;
                j10 = j12;
            }
        }
        j8 = j11 - j9;
        if (j8 != j3) {
            this.f12892b += j8;
        }
        return j8;
    }

    @Override // l7.o0
    public final r0 timeout() {
        return r0.NONE;
    }
}
