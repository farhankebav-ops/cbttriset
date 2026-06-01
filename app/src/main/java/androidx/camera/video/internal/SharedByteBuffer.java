package androidx.camera.video.internal;

import a1.a;
import androidx.annotation.GuardedBy;
import androidx.camera.core.Logger;
import androidx.core.util.Pair;
import androidx.core.util.Preconditions;
import com.ironsource.C2300e4;
import java.io.Closeable;
import java.nio.ByteBuffer;
import java.util.Locale;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class SharedByteBuffer implements Closeable {
    private static final String TAG = "SharedByteBuffer";
    private final Object mCloseLock = new Object();

    @GuardedBy("mCloseLock")
    private boolean mClosed = false;
    private final Pair<Executor, Runnable> mFinalCloseAction;
    private final int mShareId;
    private final ByteBuffer mSharedByteBuffer;

    @GuardedBy("mCloseLock")
    private final AtomicInteger mSharedRefCount;

    private SharedByteBuffer(ByteBuffer byteBuffer, AtomicInteger atomicInteger, Pair<Executor, Runnable> pair, int i2) {
        int i8;
        this.mSharedByteBuffer = byteBuffer;
        this.mSharedRefCount = atomicInteger;
        this.mFinalCloseAction = pair;
        this.mShareId = i2;
        if (!Logger.isDebugEnabled(TAG) || (i8 = atomicInteger.get()) >= 1) {
            return;
        }
        Locale locale = Locale.US;
        throw new AssertionError("Cannot create new instance of SharedByteBuffer with invalid ref count " + i8 + ". Ref count must be >= 1. [" + toString() + C2300e4.i.e);
    }

    @GuardedBy("mCloseLock")
    private void checkNotClosed(String str) {
        if (this.mClosed) {
            throw new IllegalStateException(a.m("Cannot call ", str, " on a closed SharedByteBuffer."));
        }
    }

    private boolean closeInternal() {
        synchronized (this.mCloseLock) {
            try {
                if (this.mClosed) {
                    return false;
                }
                this.mClosed = true;
                int iDecrementAndGet = this.mSharedRefCount.decrementAndGet();
                if (Logger.isDebugEnabled(TAG)) {
                    if (iDecrementAndGet < 0) {
                        throw new AssertionError("Invalid ref count. close() should never produce a ref count below 0");
                    }
                    Locale locale = Locale.US;
                    Logger.d(TAG, "Ref count decremented: " + iDecrementAndGet + " [" + toString() + C2300e4.i.e);
                }
                if (iDecrementAndGet == 0) {
                    if (Logger.isDebugEnabled(TAG)) {
                        Locale locale2 = Locale.US;
                        Logger.d(TAG, "Final reference released. Running final close action. [" + toString() + C2300e4.i.e);
                    }
                    try {
                        ((Executor) Preconditions.checkNotNull(this.mFinalCloseAction.first)).execute((Runnable) Preconditions.checkNotNull(this.mFinalCloseAction.second));
                    } catch (RejectedExecutionException e) {
                        Locale locale3 = Locale.US;
                        Logger.e(TAG, "Unable to execute final close action. [" + toString() + C2300e4.i.e, e);
                    }
                }
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static SharedByteBuffer newSharedInstance(ByteBuffer byteBuffer, Executor executor, Runnable runnable) {
        return new SharedByteBuffer(((ByteBuffer) Preconditions.checkNotNull(byteBuffer)).asReadOnlyBuffer(), new AtomicInteger(1), new Pair((Executor) Preconditions.checkNotNull(executor), (Runnable) Preconditions.checkNotNull(runnable)), System.identityHashCode(byteBuffer));
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        closeInternal();
    }

    public void finalize() throws Throwable {
        try {
            if (closeInternal()) {
                Locale locale = Locale.US;
                Logger.w(TAG, "SharedByteBuffer closed by finalizer, but should have been closed manually with SharedByteBuffer.close() [" + toString() + C2300e4.i.e);
            }
        } finally {
            super.finalize();
        }
    }

    public ByteBuffer get() {
        ByteBuffer byteBuffer;
        synchronized (this.mCloseLock) {
            checkNotClosed("get()");
            byteBuffer = this.mSharedByteBuffer;
        }
        return byteBuffer;
    }

    public SharedByteBuffer share() {
        int iIncrementAndGet;
        AtomicInteger atomicInteger;
        synchronized (this.mCloseLock) {
            checkNotClosed("share()");
            iIncrementAndGet = this.mSharedRefCount.incrementAndGet();
            atomicInteger = this.mSharedRefCount;
        }
        if (Logger.isDebugEnabled(TAG)) {
            if (iIncrementAndGet <= 1) {
                throw new AssertionError("Invalid ref count. share() should always produce a ref count of 2 or more.");
            }
            Locale locale = Locale.US;
            Logger.d(TAG, "Ref count incremented: " + iIncrementAndGet + " [" + toString() + C2300e4.i.e);
        }
        return new SharedByteBuffer(this.mSharedByteBuffer.asReadOnlyBuffer(), atomicInteger, this.mFinalCloseAction, this.mShareId);
    }

    public String toString() {
        return String.format(Locale.US, "SharedByteBuffer[buf: %s, shareId: 0x%x, instanceId:0x%x]", this.mSharedByteBuffer, Integer.valueOf(this.mShareId), Integer.valueOf(System.identityHashCode(this)));
    }
}
