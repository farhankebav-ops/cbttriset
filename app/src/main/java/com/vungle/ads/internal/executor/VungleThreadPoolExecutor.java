package com.vungle.ads.internal.executor;

import com.google.firebase.remoteconfig.b;
import com.ironsource.hi;
import com.vungle.ads.OutOfMemory;
import com.vungle.ads.c;
import com.vungle.ads.internal.task.PriorityRunnable;
import com.vungle.ads.internal.util.Logger;
import e6.a;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.l;
import q5.x;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class VungleThreadPoolExecutor extends ThreadPoolExecutor implements AutoCloseable {
    public static final Companion Companion = new Companion(null);
    private static final String TAG = "VungleThreadPool";
    private final NamedThreadFactory threadFactory;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final <T> Callable<T> getWrappedCallableWithFallback(Callable<T> callable, a aVar) {
            return new b(3, callable, aVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX INFO: renamed from: getWrappedCallableWithFallback$lambda-0, reason: not valid java name */
        public static final Object m3317getWrappedCallableWithFallback$lambda0(Callable command, a failFallback) {
            k.e(command, "$command");
            k.e(failFallback, "$failFallback");
            try {
                return command.call();
            } catch (OutOfMemoryError unused) {
                failFallback.invoke();
                return null;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final ComparableRunnable getWrappedRunnableWithFail(final Runnable runnable, final Runnable runnable2) {
            return runnable instanceof PriorityRunnable ? new PriorityRunnable() { // from class: com.vungle.ads.internal.executor.VungleThreadPoolExecutor$Companion$getWrappedRunnableWithFail$1
                @Override // com.vungle.ads.internal.task.PriorityRunnable, java.lang.Comparable
                public int compareTo(Object other) {
                    k.e(other, "other");
                    if (!(other instanceof PriorityRunnable)) {
                        return 0;
                    }
                    return k.g(((PriorityRunnable) other).getPriority(), getPriority());
                }

                @Override // com.vungle.ads.internal.task.PriorityRunnable
                public int getPriority() {
                    return ((PriorityRunnable) runnable).getPriority();
                }

                @Override // java.lang.Runnable
                public void run() {
                    VungleThreadPoolExecutor.Companion.wrapRunnableWithFail(runnable, runnable2);
                }
            } : new ComparableRunnable() { // from class: com.vungle.ads.internal.executor.VungleThreadPoolExecutor$Companion$getWrappedRunnableWithFail$2
                @Override // java.lang.Comparable
                public int compareTo(Object other) {
                    k.e(other, "other");
                    Runnable runnable3 = runnable;
                    if (runnable3 instanceof PriorityRunnable) {
                        return ((PriorityRunnable) runnable3).compareTo(other);
                    }
                    return 0;
                }

                @Override // java.lang.Runnable
                public void run() {
                    VungleThreadPoolExecutor.Companion.wrapRunnableWithFail(runnable, runnable2);
                }
            };
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void wrapRunnableWithFail(Runnable runnable, Runnable runnable2) {
            try {
                runnable.run();
            } catch (OutOfMemoryError unused) {
                runnable2.run();
            }
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface ComparableRunnable extends Comparable<Object>, Runnable {
    }

    /* JADX INFO: renamed from: com.vungle.ads.internal.executor.VungleThreadPoolExecutor$submit$3, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class AnonymousClass3 extends l implements a {
        public AnonymousClass3() {
            super(0);
        }

        @Override // e6.a
        public /* bridge */ /* synthetic */ Object invoke() {
            m3318invoke();
            return x.f13520a;
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final void m3318invoke() {
            new OutOfMemory("submit callable error in " + VungleThreadPoolExecutor.this.executorName()).logErrorNoReturnValue$vungle_ads_release();
        }
    }

    public VungleThreadPoolExecutor(int i2, int i8, long j, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, NamedThreadFactory namedThreadFactory) {
        super(i2, i8, j, timeUnit, blockingQueue, namedThreadFactory);
        this.threadFactory = namedThreadFactory;
        allowCoreThreadTimeOut(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: execute$lambda-0, reason: not valid java name */
    public static final void m3314execute$lambda0(VungleThreadPoolExecutor this$0) {
        k.e(this$0, "this$0");
        new OutOfMemory("execute error in " + this$0.executorName()).logErrorNoReturnValue$vungle_ads_release();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String executorName() {
        String name;
        NamedThreadFactory namedThreadFactory = this.threadFactory;
        return (namedThreadFactory == null || (name = namedThreadFactory.getName()) == null) ? "VungleThreadPoolExecutor" : name;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: submit$lambda-1, reason: not valid java name */
    public static final void m3315submit$lambda1(VungleThreadPoolExecutor this$0) {
        k.e(this$0, "this$0");
        new OutOfMemory("submit error in " + this$0.executorName()).logErrorNoReturnValue$vungle_ads_release();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: submit$lambda-2, reason: not valid java name */
    public static final void m3316submit$lambda2(VungleThreadPoolExecutor this$0) {
        k.e(this$0, "this$0");
        new OutOfMemory("submit error with result in " + this$0.executorName()).logErrorNoReturnValue$vungle_ads_release();
    }

    @Override // java.lang.AutoCloseable
    public final /* synthetic */ void close() {
        hi.q(this);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.Executor
    public void execute(Runnable command) {
        k.e(command, "command");
        try {
            super.execute(Companion.getWrappedRunnableWithFail(command, new c(this, 2)));
        } catch (Exception e) {
            Logger.Companion.e(TAG, "execute exception", e);
        } catch (OutOfMemoryError e4) {
            String str = "execute error in " + executorName() + ": " + e4.getLocalizedMessage();
            Logger.Companion.e(TAG, str, e4);
            new OutOfMemory(str).logErrorNoReturnValue$vungle_ads_release();
        }
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public final NamedThreadFactory getThreadFactory() {
        return this.threadFactory;
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public Future<?> submit(Runnable task) {
        k.e(task, "task");
        try {
            Future<?> futureSubmit = super.submit(Companion.getWrappedRunnableWithFail(task, new c(this, 3)));
            k.d(futureSubmit, "{\n            super.subm…\n            })\n        }");
            return futureSubmit;
        } catch (Exception e) {
            Logger.Companion.e(TAG, "submit exception", e);
            return new FutureResult(null);
        } catch (OutOfMemoryError e4) {
            String str = "submit error in " + executorName() + ": " + e4.getLocalizedMessage();
            Logger.Companion.e(TAG, str, e4);
            new OutOfMemory(str).logErrorNoReturnValue$vungle_ads_release();
            return new FutureResult(null);
        }
    }

    public final Future<?> submit$vungle_ads_release(Runnable task, Runnable fail) {
        k.e(task, "task");
        k.e(fail, "fail");
        try {
            Future<?> futureSubmit = super.submit(Companion.getWrappedRunnableWithFail(task, fail));
            k.d(futureSubmit, "{\n            super.subm…il(task, fail))\n        }");
            return futureSubmit;
        } catch (Exception e) {
            Logger.Companion.e(TAG, "submit exception with fail", e);
            fail.run();
            return new FutureResult(null);
        } catch (OutOfMemoryError e4) {
            String str = "submit error with fail in " + executorName() + ": " + e4.getLocalizedMessage();
            Logger.Companion.e(TAG, str, e4);
            new OutOfMemory(str).logErrorNoReturnValue$vungle_ads_release();
            fail.run();
            return new FutureResult(null);
        }
    }

    public final void execute(Runnable command, Runnable fail) {
        k.e(command, "command");
        k.e(fail, "fail");
        try {
            super.execute(Companion.getWrappedRunnableWithFail(command, fail));
        } catch (Exception e) {
            Logger.Companion.e(TAG, "execute exception with fail", e);
            fail.run();
        } catch (OutOfMemoryError e4) {
            String str = "execute error with fail in " + executorName() + ": " + e4.getLocalizedMessage();
            Logger.Companion.e(TAG, str, e4);
            new OutOfMemory(str).logErrorNoReturnValue$vungle_ads_release();
            fail.run();
        }
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public <T> Future<T> submit(Runnable task, T t3) {
        k.e(task, "task");
        try {
            Future<T> futureSubmit = super.submit(Companion.getWrappedRunnableWithFail(task, new c(this, 1)), t3);
            k.d(futureSubmit, "{\n            super.subm…     }, result)\n        }");
            return futureSubmit;
        } catch (Exception e) {
            Logger.Companion.e(TAG, "submit exception with result", e);
            return new FutureResult(null);
        } catch (OutOfMemoryError e4) {
            String str = "submit error with result in " + executorName() + ": " + e4.getLocalizedMessage();
            Logger.Companion.e(TAG, str, e4);
            new OutOfMemory(str).logErrorNoReturnValue$vungle_ads_release();
            return new FutureResult(null);
        }
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public <T> Future<T> submit(Callable<T> task) {
        k.e(task, "task");
        try {
            Future<T> futureSubmit = super.submit(Companion.getWrappedCallableWithFallback(task, new AnonymousClass3()));
            k.d(futureSubmit, "override fun <T> submit(…Future<T>\n        }\n    }");
            return futureSubmit;
        } catch (Exception e) {
            Logger.Companion.e(TAG, "submit exception callable: " + e);
            return new FutureResult(null);
        } catch (OutOfMemoryError e4) {
            String str = "submit error callable in " + executorName() + ": " + e4.getLocalizedMessage();
            Logger.Companion.e(TAG, str, e4);
            new OutOfMemory(str).logErrorNoReturnValue$vungle_ads_release();
            return new FutureResult(null);
        }
    }
}
