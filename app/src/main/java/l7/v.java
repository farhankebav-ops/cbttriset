package l7;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class v implements n0 {
    private final n0 delegate;

    public v(n0 delegate) {
        kotlin.jvm.internal.k.e(delegate, "delegate");
        this.delegate = delegate;
    }

    /* JADX INFO: renamed from: -deprecated_delegate, reason: not valid java name */
    public final n0 m3455deprecated_delegate() {
        return this.delegate;
    }

    @Override // l7.n0, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.delegate.close();
    }

    public final n0 delegate() {
        return this.delegate;
    }

    @Override // l7.n0, java.io.Flushable
    public void flush() throws IOException {
        this.delegate.flush();
    }

    @Override // l7.n0
    public r0 timeout() {
        return this.delegate.timeout();
    }

    public String toString() {
        return getClass().getSimpleName() + '(' + this.delegate + ')';
    }

    @Override // l7.n0
    public void write(j source, long j) throws IOException {
        kotlin.jvm.internal.k.e(source, "source");
        this.delegate.write(source, j);
    }
}
