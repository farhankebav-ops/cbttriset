package com.vungle.ads.internal.executor;

import com.vungle.ads.internal.util.Logger;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class FutureResult<T> implements Future<T> {
    public static final Companion Companion = new Companion(null);
    private static final String TAG = "FutureResult";
    private final Future<T> future;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        public final String getTAG() {
            return FutureResult.TAG;
        }

        private Companion() {
        }
    }

    public FutureResult(Future<T> future) {
        this.future = future;
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z2) {
        Future<T> future = this.future;
        if (future != null) {
            return future.cancel(z2);
        }
        return false;
    }

    @Override // java.util.concurrent.Future
    public T get() {
        try {
            Future<T> future = this.future;
            if (future != null) {
                return future.get();
            }
            return null;
        } catch (InterruptedException unused) {
            Logger.Companion companion = Logger.Companion;
            String TAG2 = TAG;
            k.d(TAG2, "TAG");
            companion.w(TAG2, "future.get() Interrupted on Thread " + Thread.currentThread().getName());
            Thread.currentThread().interrupt();
            return null;
        } catch (ExecutionException e) {
            Logger.Companion companion2 = Logger.Companion;
            String TAG3 = TAG;
            k.d(TAG3, "TAG");
            companion2.e(TAG3, "error on execution", e);
            return null;
        }
    }

    public final Future<T> getFuture() {
        return this.future;
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        Future<T> future = this.future;
        if (future != null) {
            return future.isCancelled();
        }
        return false;
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        Future<T> future = this.future;
        if (future != null) {
            return future.isDone();
        }
        return false;
    }

    @Override // java.util.concurrent.Future
    public T get(long j, TimeUnit unit) {
        k.e(unit, "unit");
        try {
            Future<T> future = this.future;
            if (future != null) {
                return future.get(j, unit);
            }
            return null;
        } catch (InterruptedException unused) {
            Logger.Companion companion = Logger.Companion;
            String TAG2 = TAG;
            k.d(TAG2, "TAG");
            companion.w(TAG2, "future.get() Interrupted on Thread " + Thread.currentThread().getName());
            Thread.currentThread().interrupt();
            return null;
        } catch (ExecutionException e) {
            Logger.Companion companion2 = Logger.Companion;
            String TAG3 = TAG;
            k.d(TAG3, "TAG");
            companion2.e(TAG3, "error on execution", e);
            return null;
        } catch (TimeoutException e4) {
            Logger.Companion companion3 = Logger.Companion;
            String TAG4 = TAG;
            k.d(TAG4, "TAG");
            companion3.e(TAG4, "error on timeout", e4);
            k.d(TAG4, "TAG");
            companion3.w(TAG4, "future.get() Timeout on Thread " + Thread.currentThread().getName());
            return null;
        }
    }
}
