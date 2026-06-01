package androidx.camera.core.impl.utils.futures;

import androidx.camera.core.Logger;
import androidx.core.util.Preconditions;
import j2.q;
import java.util.concurrent.Delayed;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
abstract class ImmediateFuture<V> implements q {
    private static final String TAG = "ImmediateFuture";

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class ImmediateFailedFuture<V> extends ImmediateFuture<V> {
        private final Throwable mCause;

        public ImmediateFailedFuture(Throwable th) {
            this.mCause = th;
        }

        @Override // androidx.camera.core.impl.utils.futures.ImmediateFuture, java.util.concurrent.Future
        public V get() throws ExecutionException {
            throw new ExecutionException(this.mCause);
        }

        public String toString() {
            return super.toString() + "[status=FAILURE, cause=[" + this.mCause + "]]";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class ImmediateFailedScheduledFuture<V> extends ImmediateFailedFuture<V> implements ScheduledFuture<V> {
        public ImmediateFailedScheduledFuture(Throwable th) {
            super(th);
        }

        @Override // java.lang.Comparable
        public int compareTo(Delayed delayed) {
            return -1;
        }

        @Override // java.util.concurrent.Delayed
        public long getDelay(TimeUnit timeUnit) {
            return 0L;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class ImmediateSuccessfulFuture<V> extends ImmediateFuture<V> {
        static final ImmediateFuture<Object> NULL_FUTURE = new ImmediateSuccessfulFuture(null);
        private final V mValue;

        public ImmediateSuccessfulFuture(V v2) {
            this.mValue = v2;
        }

        @Override // androidx.camera.core.impl.utils.futures.ImmediateFuture, java.util.concurrent.Future
        public V get() {
            return this.mValue;
        }

        public String toString() {
            return super.toString() + "[status=SUCCESS, result=[" + this.mValue + "]]";
        }
    }

    public static <V> q nullFuture() {
        return ImmediateSuccessfulFuture.NULL_FUTURE;
    }

    @Override // j2.q
    public void addListener(Runnable runnable, Executor executor) {
        Preconditions.checkNotNull(runnable);
        Preconditions.checkNotNull(executor);
        try {
            executor.execute(runnable);
        } catch (RuntimeException e) {
            Logger.e(TAG, "Experienced RuntimeException while attempting to notify " + runnable + " on Executor " + executor, e);
        }
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z2) {
        return false;
    }

    @Override // java.util.concurrent.Future
    public abstract V get() throws ExecutionException;

    @Override // java.util.concurrent.Future
    public V get(long j, TimeUnit timeUnit) throws ExecutionException {
        Preconditions.checkNotNull(timeUnit);
        return get();
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return false;
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return true;
    }
}
