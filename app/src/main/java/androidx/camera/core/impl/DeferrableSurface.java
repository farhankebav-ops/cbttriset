package androidx.camera.core.impl;

import android.util.Log;
import android.util.Size;
import androidx.annotation.GuardedBy;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public abstract class DeferrableSurface {

    @GuardedBy("mLock")
    private CallbackToFutureAdapter.Completer<Void> mCloseCompleter;
    private final j2.q mCloseFuture;

    @GuardedBy("mLock")
    private boolean mClosed;
    Class<?> mContainerClass;
    private final Object mLock;
    private final Size mPrescribedSize;
    private final int mPrescribedStreamFormat;

    @GuardedBy("mLock")
    private CallbackToFutureAdapter.Completer<Void> mTerminationCompleter;
    private final j2.q mTerminationFuture;

    @GuardedBy("mLock")
    private int mUseCount;
    public static final Size SIZE_UNDEFINED = new Size(0, 0);
    private static final String TAG = "DeferrableSurface";
    private static final boolean DEBUG = Logger.isDebugEnabled(TAG);
    private static final AtomicInteger USED_COUNT = new AtomicInteger(0);
    private static final AtomicInteger TOTAL_COUNT = new AtomicInteger(0);

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final class SurfaceClosedException extends Exception {
        DeferrableSurface mDeferrableSurface;

        public SurfaceClosedException(String str, DeferrableSurface deferrableSurface) {
            super(str);
            this.mDeferrableSurface = deferrableSurface;
        }

        public DeferrableSurface getDeferrableSurface() {
            return this.mDeferrableSurface;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class SurfaceUnavailableException extends Exception {
        public SurfaceUnavailableException(String str) {
            super(str);
        }
    }

    public DeferrableSurface() {
        this(SIZE_UNDEFINED, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$new$0(CallbackToFutureAdapter.Completer completer) throws Exception {
        synchronized (this.mLock) {
            this.mTerminationCompleter = completer;
        }
        return "DeferrableSurface-termination(" + this + ")";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$new$1(CallbackToFutureAdapter.Completer completer) throws Exception {
        synchronized (this.mLock) {
            this.mCloseCompleter = completer;
        }
        return "DeferrableSurface-close(" + this + ")";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$2(String str) {
        try {
            this.mTerminationFuture.get();
            printGlobalDebugCounts("Surface terminated", TOTAL_COUNT.decrementAndGet(), USED_COUNT.get());
        } catch (Exception e) {
            Logger.e(TAG, "Unexpected surface termination for " + this + "\nStack Trace:\n" + str);
            synchronized (this.mLock) {
                throw new IllegalArgumentException(String.format("DeferrableSurface %s [closed: %b, use_count: %s] terminated with unexpected exception.", this, Boolean.valueOf(this.mClosed), Integer.valueOf(this.mUseCount)), e);
            }
        }
    }

    private void printGlobalDebugCounts(String str, int i2, int i8) {
        if (!DEBUG && Logger.isDebugEnabled(TAG)) {
            Logger.d(TAG, "DeferrableSurface usage statistics may be inaccurate since debug logging was not enabled at static initialization time. App restart may be required to enable accurate usage statistics.");
        }
        Logger.d(TAG, str + "[total_surfaces=" + i2 + ", used_surfaces=" + i8 + "](" + this + "}");
    }

    public void close() {
        CallbackToFutureAdapter.Completer<Void> completer;
        synchronized (this.mLock) {
            try {
                if (this.mClosed) {
                    completer = null;
                } else {
                    this.mClosed = true;
                    this.mCloseCompleter.set(null);
                    if (this.mUseCount == 0) {
                        completer = this.mTerminationCompleter;
                        this.mTerminationCompleter = null;
                    } else {
                        completer = null;
                    }
                    if (Logger.isDebugEnabled(TAG)) {
                        Logger.d(TAG, "surface closed,  useCount=" + this.mUseCount + " closed=true " + this);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (completer != null) {
            completer.set(null);
        }
    }

    public void decrementUseCount() {
        CallbackToFutureAdapter.Completer<Void> completer;
        synchronized (this.mLock) {
            try {
                int i2 = this.mUseCount;
                if (i2 == 0) {
                    throw new IllegalStateException("Decrementing use count occurs more times than incrementing");
                }
                int i8 = i2 - 1;
                this.mUseCount = i8;
                if (i8 == 0 && this.mClosed) {
                    completer = this.mTerminationCompleter;
                    this.mTerminationCompleter = null;
                } else {
                    completer = null;
                }
                if (Logger.isDebugEnabled(TAG)) {
                    Logger.d(TAG, "use count-1,  useCount=" + this.mUseCount + " closed=" + this.mClosed + " " + this);
                    if (this.mUseCount == 0) {
                        printGlobalDebugCounts("Surface no longer in use", TOTAL_COUNT.get(), USED_COUNT.decrementAndGet());
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (completer != null) {
            completer.set(null);
        }
    }

    public j2.q getCloseFuture() {
        return Futures.nonCancellationPropagating(this.mCloseFuture);
    }

    public Class<?> getContainerClass() {
        return this.mContainerClass;
    }

    public Size getPrescribedSize() {
        return this.mPrescribedSize;
    }

    public int getPrescribedStreamFormat() {
        return this.mPrescribedStreamFormat;
    }

    public final j2.q getSurface() {
        synchronized (this.mLock) {
            try {
                if (this.mClosed) {
                    return Futures.immediateFailedFuture(new SurfaceClosedException("DeferrableSurface already closed.", this));
                }
                return provideSurface();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public j2.q getTerminationFuture() {
        return Futures.nonCancellationPropagating(this.mTerminationFuture);
    }

    @VisibleForTesting
    public int getUseCount() {
        int i2;
        synchronized (this.mLock) {
            i2 = this.mUseCount;
        }
        return i2;
    }

    public void incrementUseCount() throws SurfaceClosedException {
        synchronized (this.mLock) {
            try {
                int i2 = this.mUseCount;
                if (i2 == 0 && this.mClosed) {
                    throw new SurfaceClosedException("Cannot begin use on a closed surface.", this);
                }
                this.mUseCount = i2 + 1;
                if (Logger.isDebugEnabled(TAG)) {
                    if (this.mUseCount == 1) {
                        printGlobalDebugCounts("New surface in use", TOTAL_COUNT.get(), USED_COUNT.incrementAndGet());
                    }
                    Logger.d(TAG, "use count+1, useCount=" + this.mUseCount + " " + this);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public boolean isClosed() {
        boolean z2;
        synchronized (this.mLock) {
            z2 = this.mClosed;
        }
        return z2;
    }

    public abstract j2.q provideSurface();

    public void setContainerClass(Class<?> cls) {
        this.mContainerClass = cls;
    }

    public DeferrableSurface(Size size, int i2) {
        this.mLock = new Object();
        this.mUseCount = 0;
        this.mClosed = false;
        this.mPrescribedSize = size;
        this.mPrescribedStreamFormat = i2;
        final int i8 = 0;
        j2.q future = CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver(this) { // from class: androidx.camera.core.impl.p

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ DeferrableSurface f3622b;

            {
                this.f3622b = this;
            }

            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
            public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
                switch (i8) {
                    case 0:
                        return this.f3622b.lambda$new$0(completer);
                    default:
                        return this.f3622b.lambda$new$1(completer);
                }
            }
        });
        this.mTerminationFuture = future;
        final int i9 = 1;
        this.mCloseFuture = CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver(this) { // from class: androidx.camera.core.impl.p

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ DeferrableSurface f3622b;

            {
                this.f3622b = this;
            }

            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
            public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
                switch (i9) {
                    case 0:
                        return this.f3622b.lambda$new$0(completer);
                    default:
                        return this.f3622b.lambda$new$1(completer);
                }
            }
        });
        if (Logger.isDebugEnabled(TAG)) {
            printGlobalDebugCounts("Surface created", TOTAL_COUNT.incrementAndGet(), USED_COUNT.get());
            future.addListener(new u(7, this, Log.getStackTraceString(new Exception())), CameraXExecutors.directExecutor());
        }
    }
}
