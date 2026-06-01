package androidx.camera.core.impl.utils.futures;

import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.core.util.Preconditions;
import j2.q;
import java.lang.reflect.UndeclaredThrowableException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
class ChainingListenableFuture<I, O> extends FutureChain<O> implements Runnable {
    private AsyncFunction<? super I, ? extends O> mFunction;
    private q mInputFuture;
    private final BlockingQueue<Boolean> mMayInterruptIfRunningChannel = new LinkedBlockingQueue(1);
    private final CountDownLatch mOutputCreated = new CountDownLatch(1);
    volatile q mOutputFuture;

    public ChainingListenableFuture(AsyncFunction<? super I, ? extends O> asyncFunction, q qVar) {
        this.mFunction = (AsyncFunction) Preconditions.checkNotNull(asyncFunction);
        this.mInputFuture = (q) Preconditions.checkNotNull(qVar);
    }

    private <E> void putUninterruptibly(BlockingQueue<E> blockingQueue, E e) {
        boolean z2 = false;
        while (true) {
            try {
                blockingQueue.put(e);
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
    }

    private <E> E takeUninterruptibly(BlockingQueue<E> blockingQueue) {
        E eTake;
        boolean z2 = false;
        while (true) {
            try {
                eTake = blockingQueue.take();
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
        return eTake;
    }

    @Override // androidx.camera.core.impl.utils.futures.FutureChain, java.util.concurrent.Future
    public boolean cancel(boolean z2) {
        if (!super.cancel(z2)) {
            return false;
        }
        putUninterruptibly(this.mMayInterruptIfRunningChannel, Boolean.valueOf(z2));
        cancel(this.mInputFuture, z2);
        cancel(this.mOutputFuture, z2);
        return true;
    }

    @Override // androidx.camera.core.impl.utils.futures.FutureChain, java.util.concurrent.Future
    public O get() throws ExecutionException, InterruptedException {
        if (!isDone()) {
            q qVar = this.mInputFuture;
            if (qVar != null) {
                qVar.get();
            }
            this.mOutputCreated.await();
            q qVar2 = this.mOutputFuture;
            if (qVar2 != null) {
                qVar2.get();
            }
        }
        return (O) super.get();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [androidx.camera.core.impl.utils.futures.AsyncFunction<? super I, ? extends O>, j2.q] */
    /* JADX WARN: Type inference failed for: r0v1, types: [androidx.camera.core.impl.utils.futures.AsyncFunction<? super I, ? extends O>, j2.q] */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4, types: [androidx.camera.core.impl.utils.futures.AsyncFunction<? super I, ? extends O>, j2.q] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8, types: [java.util.concurrent.CountDownLatch] */
    @Override // java.lang.Runnable
    public void run() {
        ?? r02;
        ?? r03 = (AsyncFunction<? super I, ? extends O>) null;
        try {
            try {
                try {
                    try {
                        try {
                            final q qVarApply = this.mFunction.apply(Futures.getUninterruptibly(this.mInputFuture));
                            this.mOutputFuture = qVarApply;
                            if (isCancelled()) {
                                qVarApply.cancel(((Boolean) takeUninterruptibly(this.mMayInterruptIfRunningChannel)).booleanValue());
                                this.mOutputFuture = null;
                            } else {
                                qVarApply.addListener(new Runnable() { // from class: androidx.camera.core.impl.utils.futures.ChainingListenableFuture.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        try {
                                            try {
                                                try {
                                                    ChainingListenableFuture.this.set(Futures.getUninterruptibly(qVarApply));
                                                } catch (ExecutionException e) {
                                                    ChainingListenableFuture.this.setException(e.getCause());
                                                }
                                            } catch (CancellationException unused) {
                                                ChainingListenableFuture.this.cancel(false);
                                            }
                                        } finally {
                                            ChainingListenableFuture.this.mOutputFuture = null;
                                        }
                                    }
                                }, CameraXExecutors.directExecutor());
                            }
                        } catch (CancellationException unused) {
                            cancel(false);
                        } catch (ExecutionException e) {
                            setException(e.getCause());
                        }
                    } catch (Error e4) {
                        setException(e4);
                        r02 = r03;
                    }
                } catch (Exception e8) {
                    setException(e8);
                    r02 = r03;
                }
            } finally {
                this.mFunction = (AsyncFunction<? super I, ? extends O>) r03;
                this.mInputFuture = (q) r03;
                this.mOutputCreated.countDown();
            }
        } catch (UndeclaredThrowableException e9) {
            setException(e9.getCause());
            r02 = r03;
        }
    }

    private void cancel(Future<?> future, boolean z2) {
        if (future != null) {
            future.cancel(z2);
        }
    }

    @Override // androidx.camera.core.impl.utils.futures.FutureChain, java.util.concurrent.Future
    public O get(long j, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        if (!isDone()) {
            TimeUnit timeUnit2 = TimeUnit.NANOSECONDS;
            if (timeUnit != timeUnit2) {
                j = timeUnit2.convert(j, timeUnit);
                timeUnit = timeUnit2;
            }
            q qVar = this.mInputFuture;
            if (qVar != null) {
                long jNanoTime = System.nanoTime();
                qVar.get(j, timeUnit);
                j -= Math.max(0L, System.nanoTime() - jNanoTime);
            }
            long jNanoTime2 = System.nanoTime();
            if (this.mOutputCreated.await(j, timeUnit)) {
                j -= Math.max(0L, System.nanoTime() - jNanoTime2);
                q qVar2 = this.mOutputFuture;
                if (qVar2 != null) {
                    qVar2.get(j, timeUnit);
                }
            } else {
                throw new TimeoutException();
            }
        }
        return (O) super.get(j, timeUnit);
    }
}
