package l7;

import java.io.EOFException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class g implements n0 {
    @Override // l7.n0
    public final r0 timeout() {
        return r0.NONE;
    }

    @Override // l7.n0
    public final void write(j source, long j) throws EOFException {
        kotlin.jvm.internal.k.e(source, "source");
        source.skip(j);
    }

    @Override // l7.n0, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }

    @Override // l7.n0, java.io.Flushable
    public final void flush() {
    }
}
