package l7;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class e implements o0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f12845a = 1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f12846b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f12847c;

    public e(InputStream inputStream, r0 timeout) {
        kotlin.jvm.internal.k.e(timeout, "timeout");
        this.f12846b = inputStream;
        this.f12847c = timeout;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        switch (this.f12845a) {
            case 0:
                f fVar = (f) this.f12846b;
                o0 o0Var = (o0) this.f12847c;
                fVar.enter();
                try {
                    o0Var.close();
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
                ((InputStream) this.f12846b).close();
                return;
        }
    }

    @Override // l7.o0
    public final long read(j sink, long j) throws IOException {
        switch (this.f12845a) {
            case 0:
                kotlin.jvm.internal.k.e(sink, "sink");
                f fVar = (f) this.f12846b;
                o0 o0Var = (o0) this.f12847c;
                fVar.enter();
                try {
                    long j3 = o0Var.read(sink, j);
                    if (fVar.exit()) {
                        throw fVar.access$newTimeoutException(null);
                    }
                    return j3;
                } catch (IOException e) {
                    if (fVar.exit()) {
                        throw fVar.access$newTimeoutException(e);
                    }
                    throw e;
                } finally {
                    fVar.exit();
                }
            default:
                kotlin.jvm.internal.k.e(sink, "sink");
                if (j == 0) {
                    return 0L;
                }
                if (j < 0) {
                    throw new IllegalArgumentException(androidx.camera.core.processing.util.a.j("byteCount < 0: ", j).toString());
                }
                try {
                    ((r0) this.f12847c).throwIfReached();
                    k0 k0VarV = sink.v(1);
                    int i2 = ((InputStream) this.f12846b).read(k0VarV.f12872a, k0VarV.f12874c, (int) Math.min(j, 8192 - k0VarV.f12874c));
                    if (i2 == -1) {
                        if (k0VarV.f12873b == k0VarV.f12874c) {
                            sink.f12867a = k0VarV.a();
                            l0.a(k0VarV);
                        }
                        return -1L;
                    }
                    k0VarV.f12874c += i2;
                    long j8 = i2;
                    sink.f12868b += j8;
                    return j8;
                } catch (AssertionError e4) {
                    if (m7.n.a(e4)) {
                        throw new IOException(e4);
                    }
                    throw e4;
                }
        }
    }

    @Override // l7.o0
    public final r0 timeout() {
        switch (this.f12845a) {
            case 0:
                return (f) this.f12846b;
            default:
                return (r0) this.f12847c;
        }
    }

    public final String toString() {
        switch (this.f12845a) {
            case 0:
                return "AsyncTimeout.source(" + ((o0) this.f12847c) + ')';
            default:
                return "source(" + ((InputStream) this.f12846b) + ')';
        }
    }

    public e(f fVar, o0 o0Var) {
        this.f12846b = fVar;
        this.f12847c = o0Var;
    }
}
