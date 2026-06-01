package okhttp3.internal.cache;

import e6.l;
import java.io.EOFException;
import java.io.IOException;
import kotlin.jvm.internal.k;
import l7.j;
import l7.n0;
import l7.v;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class FaultHidingSink extends v {
    private boolean hasErrors;
    private final l onException;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FaultHidingSink(n0 delegate, l onException) {
        super(delegate);
        k.e(delegate, "delegate");
        k.e(onException, "onException");
        this.onException = onException;
    }

    @Override // l7.v, l7.n0, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        try {
            super.close();
        } catch (IOException e) {
            this.hasErrors = true;
            this.onException.invoke(e);
        }
    }

    @Override // l7.v, l7.n0, java.io.Flushable
    public void flush() {
        if (this.hasErrors) {
            return;
        }
        try {
            super.flush();
        } catch (IOException e) {
            this.hasErrors = true;
            this.onException.invoke(e);
        }
    }

    public final l getOnException() {
        return this.onException;
    }

    @Override // l7.v, l7.n0
    public void write(j source, long j) throws EOFException {
        k.e(source, "source");
        if (this.hasErrors) {
            source.skip(j);
            return;
        }
        try {
            super.write(source, j);
        } catch (IOException e) {
            this.hasErrors = true;
            this.onException.invoke(e);
        }
    }
}
