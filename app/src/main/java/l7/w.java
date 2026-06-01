package l7;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class w implements o0 {
    private final o0 delegate;

    public w(o0 delegate) {
        kotlin.jvm.internal.k.e(delegate, "delegate");
        this.delegate = delegate;
    }

    /* JADX INFO: renamed from: -deprecated_delegate, reason: not valid java name */
    public final o0 m3456deprecated_delegate() {
        return this.delegate;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.delegate.close();
    }

    public final o0 delegate() {
        return this.delegate;
    }

    @Override // l7.o0
    public long read(j sink, long j) throws IOException {
        kotlin.jvm.internal.k.e(sink, "sink");
        return this.delegate.read(sink, j);
    }

    @Override // l7.o0
    public r0 timeout() {
        return this.delegate.timeout();
    }

    public String toString() {
        return getClass().getSimpleName() + '(' + this.delegate + ')';
    }
}
