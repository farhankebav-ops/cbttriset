package l7;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class a0 implements o0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j0 f12835a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Inflater f12836b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f12837c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f12838d;

    public a0(j0 j0Var, Inflater inflater) {
        this.f12835a = j0Var;
        this.f12836b = inflater;
    }

    public final long a(j sink, long j) throws IOException {
        Inflater inflater = this.f12836b;
        kotlin.jvm.internal.k.e(sink, "sink");
        if (j < 0) {
            throw new IllegalArgumentException(androidx.camera.core.processing.util.a.j("byteCount < 0: ", j).toString());
        }
        if (this.f12838d) {
            throw new IllegalStateException("closed");
        }
        if (j != 0) {
            try {
                k0 k0VarV = sink.v(1);
                int iMin = (int) Math.min(j, 8192 - k0VarV.f12874c);
                boolean zNeedsInput = inflater.needsInput();
                j0 j0Var = this.f12835a;
                if (zNeedsInput && !j0Var.M()) {
                    k0 k0Var = j0Var.f12870b.f12867a;
                    kotlin.jvm.internal.k.b(k0Var);
                    int i2 = k0Var.f12874c;
                    int i8 = k0Var.f12873b;
                    int i9 = i2 - i8;
                    this.f12837c = i9;
                    inflater.setInput(k0Var.f12872a, i8, i9);
                }
                int iInflate = inflater.inflate(k0VarV.f12872a, k0VarV.f12874c, iMin);
                int i10 = this.f12837c;
                if (i10 != 0) {
                    int remaining = i10 - inflater.getRemaining();
                    this.f12837c -= remaining;
                    j0Var.skip(remaining);
                }
                if (iInflate > 0) {
                    k0VarV.f12874c += iInflate;
                    long j3 = iInflate;
                    sink.f12868b += j3;
                    return j3;
                }
                if (k0VarV.f12873b == k0VarV.f12874c) {
                    sink.f12867a = k0VarV.a();
                    l0.a(k0VarV);
                }
            } catch (DataFormatException e) {
                throw new IOException(e);
            }
        }
        return 0L;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        if (this.f12838d) {
            return;
        }
        this.f12836b.end();
        this.f12838d = true;
        this.f12835a.close();
    }

    @Override // l7.o0
    public final long read(j sink, long j) throws IOException {
        kotlin.jvm.internal.k.e(sink, "sink");
        do {
            long jA = a(sink, j);
            if (jA > 0) {
                return jA;
            }
            Inflater inflater = this.f12836b;
            if (inflater.finished() || inflater.needsDictionary()) {
                return -1L;
            }
        } while (!this.f12835a.M());
        throw new EOFException("source exhausted prematurely");
    }

    @Override // l7.o0
    public final r0 timeout() {
        return this.f12835a.f12869a.timeout();
    }
}
