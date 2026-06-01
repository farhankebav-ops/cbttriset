package okhttp3.internal.publicsuffix;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.k;
import l7.b;
import l7.j0;
import l7.m;
import l7.o0;
import okhttp3.internal.platform.Platform;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class BasePublicSuffixList implements PublicSuffixList {
    public m bytes;
    public m exceptionBytes;
    private final AtomicBoolean listRead = new AtomicBoolean(false);
    private final CountDownLatch readCompleteLatch = new CountDownLatch(1);

    private final void readTheList() throws IOException {
        try {
            j0 j0VarC = b.c(listSource());
            try {
                m mVarJ = j0VarC.J(j0VarC.readInt());
                m mVarJ2 = j0VarC.J(j0VarC.readInt());
                j0VarC.close();
                synchronized (this) {
                    k.b(mVarJ);
                    setBytes(mVarJ);
                    k.b(mVarJ2);
                    setExceptionBytes(mVarJ2);
                }
            } finally {
            }
        } finally {
            this.readCompleteLatch.countDown();
        }
    }

    private final void readTheListUninterruptibly() {
        boolean z2 = false;
        while (true) {
            try {
                try {
                    readTheList();
                    break;
                } catch (InterruptedIOException unused) {
                    Thread.interrupted();
                    z2 = true;
                } catch (IOException e) {
                    Platform.Companion.get().log("Failed to read public suffix list", 5, e);
                    if (!z2) {
                        return;
                    }
                }
            } finally {
                if (z2) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    @Override // okhttp3.internal.publicsuffix.PublicSuffixList
    public void ensureLoaded() {
        if (this.listRead.get() || !this.listRead.compareAndSet(false, true)) {
            try {
                this.readCompleteLatch.await();
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        } else {
            readTheListUninterruptibly();
        }
        if (this.bytes != null) {
            return;
        }
        throw new IllegalStateException(("Unable to load " + getPath() + " resource.").toString());
    }

    @Override // okhttp3.internal.publicsuffix.PublicSuffixList
    public m getBytes() {
        m mVar = this.bytes;
        if (mVar != null) {
            return mVar;
        }
        k.l("bytes");
        throw null;
    }

    @Override // okhttp3.internal.publicsuffix.PublicSuffixList
    public m getExceptionBytes() {
        m mVar = this.exceptionBytes;
        if (mVar != null) {
            return mVar;
        }
        k.l("exceptionBytes");
        throw null;
    }

    public abstract Object getPath();

    public abstract o0 listSource();

    public void setBytes(m mVar) {
        k.e(mVar, "<set-?>");
        this.bytes = mVar;
    }

    public void setExceptionBytes(m mVar) {
        k.e(mVar, "<set-?>");
        this.exceptionBytes = mVar;
    }
}
