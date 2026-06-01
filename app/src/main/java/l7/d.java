package l7;

import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class d implements n0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f12841a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f12842b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f12843c;

    public /* synthetic */ d(int i2, Object obj, Object obj2) {
        this.f12841a = i2;
        this.f12842b = obj;
        this.f12843c = obj2;
    }

    @Override // l7.n0, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        switch (this.f12841a) {
            case 0:
                f fVar = (f) this.f12842b;
                n0 n0Var = (n0) this.f12843c;
                fVar.enter();
                try {
                    n0Var.close();
                    if (fVar.exit()) {
                        throw fVar.access$newTimeoutException(null);
                    }
                    return;
                } catch (IOException e) {
                    if (!fVar.exit()) {
                        throw e;
                    }
                    throw fVar.access$newTimeoutException(e);
                } finally {
                    fVar.exit();
                }
            default:
                ((OutputStream) this.f12842b).close();
                return;
        }
    }

    @Override // l7.n0, java.io.Flushable
    public final void flush() throws IOException {
        switch (this.f12841a) {
            case 0:
                f fVar = (f) this.f12842b;
                n0 n0Var = (n0) this.f12843c;
                fVar.enter();
                try {
                    n0Var.flush();
                    if (fVar.exit()) {
                        throw fVar.access$newTimeoutException(null);
                    }
                    return;
                } catch (IOException e) {
                    if (!fVar.exit()) {
                        throw e;
                    }
                    throw fVar.access$newTimeoutException(e);
                } finally {
                    fVar.exit();
                }
            default:
                ((OutputStream) this.f12842b).flush();
                return;
        }
    }

    @Override // l7.n0
    public final r0 timeout() {
        switch (this.f12841a) {
            case 0:
                return (f) this.f12842b;
            default:
                return (r0) this.f12843c;
        }
    }

    public final String toString() {
        switch (this.f12841a) {
            case 0:
                return "AsyncTimeout.sink(" + ((n0) this.f12843c) + ')';
            default:
                return "sink(" + ((OutputStream) this.f12842b) + ')';
        }
    }

    @Override // l7.n0
    public final void write(j source, long j) throws IOException {
        switch (this.f12841a) {
            case 0:
                kotlin.jvm.internal.k.e(source, "source");
                b.e(source.f12868b, 0L, j);
                long j3 = j;
                while (true) {
                    long j8 = 0;
                    if (j3 <= 0) {
                        return;
                    }
                    k0 k0Var = source.f12867a;
                    kotlin.jvm.internal.k.b(k0Var);
                    while (true) {
                        if (j8 < 65536) {
                            j8 += (long) (k0Var.f12874c - k0Var.f12873b);
                            if (j8 >= j3) {
                                j8 = j3;
                            } else {
                                k0Var = k0Var.f12876f;
                                kotlin.jvm.internal.k.b(k0Var);
                            }
                        }
                    }
                    f fVar = (f) this.f12842b;
                    n0 n0Var = (n0) this.f12843c;
                    fVar.enter();
                    try {
                        try {
                            n0Var.write(source, j8);
                            if (fVar.exit()) {
                                throw fVar.access$newTimeoutException(null);
                            }
                            j3 -= j8;
                        } catch (IOException e) {
                            if (!fVar.exit()) {
                                throw e;
                            }
                            throw fVar.access$newTimeoutException(e);
                        }
                    } catch (Throwable th) {
                        fVar.exit();
                        throw th;
                    }
                }
                break;
            default:
                kotlin.jvm.internal.k.e(source, "source");
                b.e(source.f12868b, 0L, j);
                while (j > 0) {
                    ((r0) this.f12843c).throwIfReached();
                    k0 k0Var2 = source.f12867a;
                    kotlin.jvm.internal.k.b(k0Var2);
                    int iMin = (int) Math.min(j, k0Var2.f12874c - k0Var2.f12873b);
                    ((OutputStream) this.f12842b).write(k0Var2.f12872a, k0Var2.f12873b, iMin);
                    int i2 = k0Var2.f12873b + iMin;
                    k0Var2.f12873b = i2;
                    long j9 = iMin;
                    j -= j9;
                    source.f12868b -= j9;
                    if (i2 == k0Var2.f12874c) {
                        source.f12867a = k0Var2.a();
                        l0.a(k0Var2);
                    }
                }
                return;
        }
    }
}
