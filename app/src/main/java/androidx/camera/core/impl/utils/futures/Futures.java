package androidx.camera.core.impl.utils.futures;

import androidx.arch.core.util.Function;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.ImmediateFuture;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Preconditions;
import com.ironsource.C2300e4;
import j2.q;
import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class Futures {
    private static final Function<?, ?> IDENTITY_FUNCTION = new Function<Object, Object>() { // from class: androidx.camera.core.impl.utils.futures.Futures.2
        @Override // androidx.arch.core.util.Function, m0.f, x4.c
        public Object apply(Object obj) {
            return obj;
        }
    };

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class CallbackListener<V> implements Runnable {
        final FutureCallback<? super V> mCallback;
        final Future<V> mFuture;

        public CallbackListener(Future<V> future, FutureCallback<? super V> futureCallback) {
            this.mFuture = future;
            this.mCallback = futureCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.mCallback.onSuccess(Futures.getDone(this.mFuture));
            } catch (Error e) {
                e = e;
                this.mCallback.onFailure(e);
            } catch (RuntimeException e4) {
                e = e4;
                this.mCallback.onFailure(e);
            } catch (ExecutionException e8) {
                Throwable cause = e8.getCause();
                if (cause == null) {
                    this.mCallback.onFailure(e8);
                } else {
                    this.mCallback.onFailure(cause);
                }
            }
        }

        public String toString() {
            return CallbackListener.class.getSimpleName() + "," + this.mCallback;
        }
    }

    private Futures() {
    }

    public static <V> void addCallback(q qVar, FutureCallback<? super V> futureCallback, Executor executor) {
        Preconditions.checkNotNull(futureCallback);
        qVar.addListener(new CallbackListener(qVar, futureCallback), executor);
    }

    public static <V> q allAsList(Collection<? extends q> collection) {
        return new ListFuture(new ArrayList(collection), true, CameraXExecutors.directExecutor());
    }

    public static <V> V getDone(Future<V> future) throws ExecutionException {
        Preconditions.checkState(future.isDone(), "Future was expected to be done, " + future);
        return (V) getUninterruptibly(future);
    }

    public static <V> V getUninterruptibly(Future<V> future) throws ExecutionException {
        V v2;
        boolean z2 = false;
        while (true) {
            try {
                v2 = future.get();
                break;
            } catch (InterruptedException unused) {
                z2 = true;
            } catch (Throwable th) {
                if (z2) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z2) {
            Thread.currentThread().interrupt();
        }
        return v2;
    }

    public static <V> q immediateFailedFuture(Throwable th) {
        return new ImmediateFuture.ImmediateFailedFuture(th);
    }

    public static <V> ScheduledFuture<V> immediateFailedScheduledFuture(Throwable th) {
        return new ImmediateFuture.ImmediateFailedScheduledFuture(th);
    }

    public static <V> q immediateFuture(V v2) {
        return v2 == null ? ImmediateFuture.nullFuture() : new ImmediateFuture.ImmediateSuccessfulFuture(v2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Boolean lambda$makeTimeoutFuture$1(CallbackToFutureAdapter.Completer completer, q qVar, long j) throws Exception {
        return Boolean.valueOf(completer.setException(new TimeoutException("Future[" + qVar + "] is not done within " + j + " ms.")));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object lambda$makeTimeoutFuture$3(final q qVar, ScheduledExecutorService scheduledExecutorService, final long j, final CallbackToFutureAdapter.Completer completer) throws Exception {
        propagate(qVar, completer);
        if (!qVar.isDone()) {
            qVar.addListener(new e(scheduledExecutorService.schedule(new Callable() { // from class: androidx.camera.core.impl.utils.futures.f
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return Futures.lambda$makeTimeoutFuture$1(completer, qVar, j);
                }
            }, j, TimeUnit.MILLISECONDS), 1), CameraXExecutors.directExecutor());
        }
        return "TimeoutFuture[" + qVar + C2300e4.i.e;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$makeTimeoutFuture$4(CallbackToFutureAdapter.Completer completer, Object obj, boolean z2, q qVar) {
        completer.set(obj);
        if (z2) {
            qVar.cancel(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object lambda$makeTimeoutFuture$6(q qVar, ScheduledExecutorService scheduledExecutorService, Object obj, boolean z2, long j, CallbackToFutureAdapter.Completer completer) throws Exception {
        q qVar2;
        propagate(qVar, completer);
        if (qVar.isDone()) {
            qVar2 = qVar;
        } else {
            qVar2 = qVar;
            qVar2.addListener(new e(scheduledExecutorService.schedule(new d(completer, obj, z2, qVar2, 0), j, TimeUnit.MILLISECONDS), 0), CameraXExecutors.directExecutor());
        }
        return "TimeoutFuture[" + qVar2 + C2300e4.i.e;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object lambda$nonCancellationPropagating$0(q qVar, CallbackToFutureAdapter.Completer completer) throws Exception {
        propagateTransform(false, qVar, IDENTITY_FUNCTION, completer, CameraXExecutors.directExecutor());
        return "nonCancellationPropagating[" + qVar + C2300e4.i.e;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object lambda$transformAsyncOnCompletion$8(q qVar, CallbackToFutureAdapter.Completer completer) throws Exception {
        qVar.addListener(new a3.b(completer, 5), CameraXExecutors.directExecutor());
        return "transformVoidFuture [" + qVar + C2300e4.i.e;
    }

    public static <V> q makeTimeoutFuture(long j, ScheduledExecutorService scheduledExecutorService, q qVar) {
        return CallbackToFutureAdapter.getFuture(new a(qVar, scheduledExecutorService, j));
    }

    public static <V> q nonCancellationPropagating(q qVar) {
        Preconditions.checkNotNull(qVar);
        return qVar.isDone() ? qVar : CallbackToFutureAdapter.getFuture(new b(1, qVar));
    }

    public static <V> void propagate(q qVar, CallbackToFutureAdapter.Completer<V> completer) {
        propagateTransform(qVar, IDENTITY_FUNCTION, completer, CameraXExecutors.directExecutor());
    }

    public static <I, O> void propagateTransform(q qVar, Function<? super I, ? extends O> function, CallbackToFutureAdapter.Completer<O> completer, Executor executor) {
        propagateTransform(true, qVar, function, completer, executor);
    }

    public static <V> q successfulAsList(Collection<? extends q> collection) {
        return new ListFuture(new ArrayList(collection), false, CameraXExecutors.directExecutor());
    }

    public static <I, O> q transform(q qVar, final Function<? super I, ? extends O> function, Executor executor) {
        Preconditions.checkNotNull(function);
        return transformAsync(qVar, new AsyncFunction<I, O>() { // from class: androidx.camera.core.impl.utils.futures.Futures.1
            @Override // androidx.camera.core.impl.utils.futures.AsyncFunction
            public q apply(I i2) {
                return Futures.immediateFuture(function.apply(i2));
            }
        }, executor);
    }

    public static <I, O> q transformAsync(q qVar, AsyncFunction<? super I, ? extends O> asyncFunction, Executor executor) {
        ChainingListenableFuture chainingListenableFuture = new ChainingListenableFuture(asyncFunction, qVar);
        qVar.addListener(chainingListenableFuture, executor);
        return chainingListenableFuture;
    }

    public static <V> q transformAsyncOnCompletion(q qVar) {
        return CallbackToFutureAdapter.getFuture(new b(0, qVar));
    }

    public static <V> q makeTimeoutFuture(final long j, final ScheduledExecutorService scheduledExecutorService, final V v2, final boolean z2, final q qVar) {
        return CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver() { // from class: androidx.camera.core.impl.utils.futures.c
            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
            public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
                return Futures.lambda$makeTimeoutFuture$6(qVar, scheduledExecutorService, v2, z2, j, completer);
            }
        });
    }

    private static <I, O> void propagateTransform(boolean z2, final q qVar, final Function<? super I, ? extends O> function, final CallbackToFutureAdapter.Completer<O> completer, Executor executor) {
        Preconditions.checkNotNull(qVar);
        Preconditions.checkNotNull(function);
        Preconditions.checkNotNull(completer);
        Preconditions.checkNotNull(executor);
        addCallback(qVar, new FutureCallback<I>() { // from class: androidx.camera.core.impl.utils.futures.Futures.3
            @Override // androidx.camera.core.impl.utils.futures.FutureCallback
            public void onFailure(Throwable th) {
                completer.setException(th);
            }

            @Override // androidx.camera.core.impl.utils.futures.FutureCallback
            public void onSuccess(I i2) {
                try {
                    completer.set(function.apply(i2));
                } catch (Throwable th) {
                    completer.setException(th);
                }
            }
        }, executor);
        if (z2) {
            completer.addCancellationListener(new Runnable() { // from class: androidx.camera.core.impl.utils.futures.Futures.4
                @Override // java.lang.Runnable
                public void run() {
                    qVar.cancel(true);
                }
            }, CameraXExecutors.directExecutor());
        }
    }
}
