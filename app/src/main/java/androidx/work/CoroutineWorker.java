package androidx.work;

import a3.b;
import android.content.Context;
import androidx.work.ListenableWorker;
import androidx.work.impl.utils.futures.SettableFuture;
import com.vungle.ads.internal.protos.Sdk;
import e6.p;
import java.util.concurrent.ExecutionException;
import kotlin.jvm.internal.k;
import q5.x;
import q6.a0;
import q6.c0;
import q6.h1;
import q6.l;
import q6.m0;
import q6.n1;
import q6.s;
import q6.w;
import r2.q;
import v5.c;
import w5.a;
import x5.e;
import x5.i;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class CoroutineWorker extends ListenableWorker {
    private final w coroutineContext;
    private final SettableFuture<ListenableWorker.Result> future;
    private final s job;

    /* JADX INFO: renamed from: androidx.work.CoroutineWorker$getForegroundInfoAsync$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "androidx.work.CoroutineWorker$getForegroundInfoAsync$1", f = "CoroutineWorker.kt", l = {Sdk.SDKError.Reason.STORE_REGION_CODE_ERROR_VALUE}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends i implements p {
        final /* synthetic */ JobListenableFuture<ForegroundInfo> $jobFuture;
        Object L$0;
        int label;
        final /* synthetic */ CoroutineWorker this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(JobListenableFuture<ForegroundInfo> jobListenableFuture, CoroutineWorker coroutineWorker, c<? super AnonymousClass1> cVar) {
            super(2, cVar);
            this.$jobFuture = jobListenableFuture;
            this.this$0 = coroutineWorker;
        }

        @Override // x5.a
        public final c<x> create(Object obj, c<?> cVar) {
            return new AnonymousClass1(this.$jobFuture, this.this$0, cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            JobListenableFuture jobListenableFuture;
            a aVar = a.f17774a;
            int i2 = this.label;
            if (i2 == 0) {
                q.z0(obj);
                JobListenableFuture<ForegroundInfo> jobListenableFuture2 = this.$jobFuture;
                CoroutineWorker coroutineWorker = this.this$0;
                this.L$0 = jobListenableFuture2;
                this.label = 1;
                Object foregroundInfo = coroutineWorker.getForegroundInfo(this);
                if (foregroundInfo == aVar) {
                    return aVar;
                }
                jobListenableFuture = jobListenableFuture2;
                obj = foregroundInfo;
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                jobListenableFuture = (JobListenableFuture) this.L$0;
                q.z0(obj);
            }
            jobListenableFuture.complete(obj);
            return x.f13520a;
        }

        @Override // e6.p
        public final Object invoke(a0 a0Var, c<? super x> cVar) {
            return ((AnonymousClass1) create(a0Var, cVar)).invokeSuspend(x.f13520a);
        }
    }

    /* JADX INFO: renamed from: androidx.work.CoroutineWorker$startWork$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "androidx.work.CoroutineWorker$startWork$1", f = "CoroutineWorker.kt", l = {68}, m = "invokeSuspend")
    public static final class C03631 extends i implements p {
        int label;

        public C03631(c<? super C03631> cVar) {
            super(2, cVar);
        }

        @Override // x5.a
        public final c<x> create(Object obj, c<?> cVar) {
            return CoroutineWorker.this.new C03631(cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            a aVar = a.f17774a;
            int i2 = this.label;
            try {
                if (i2 == 0) {
                    q.z0(obj);
                    CoroutineWorker coroutineWorker = CoroutineWorker.this;
                    this.label = 1;
                    obj = coroutineWorker.doWork(this);
                    if (obj == aVar) {
                        return aVar;
                    }
                } else {
                    if (i2 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    q.z0(obj);
                }
                CoroutineWorker.this.getFuture$work_runtime_ktx_release().set((ListenableWorker.Result) obj);
            } catch (Throwable th) {
                CoroutineWorker.this.getFuture$work_runtime_ktx_release().setException(th);
            }
            return x.f13520a;
        }

        @Override // e6.p
        public final Object invoke(a0 a0Var, c<? super x> cVar) {
            return ((C03631) create(a0Var, cVar)).invokeSuspend(x.f13520a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CoroutineWorker(Context appContext, WorkerParameters params) {
        super(appContext, params);
        k.e(appContext, "appContext");
        k.e(params, "params");
        this.job = c0.c();
        SettableFuture<ListenableWorker.Result> settableFutureCreate = SettableFuture.create();
        k.d(settableFutureCreate, "create()");
        this.future = settableFutureCreate;
        settableFutureCreate.addListener(new b(this, 14), getTaskExecutor().getSerialTaskExecutor());
        this.coroutineContext = m0.f13566a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$0(CoroutineWorker this$0) {
        k.e(this$0, "this$0");
        if (this$0.future.isCancelled()) {
            ((n1) this$0.job).a(null);
        }
    }

    public static /* synthetic */ Object getForegroundInfo$suspendImpl(CoroutineWorker coroutineWorker, c<? super ForegroundInfo> cVar) {
        throw new IllegalStateException("Not implemented");
    }

    public abstract Object doWork(c<? super ListenableWorker.Result> cVar);

    public w getCoroutineContext() {
        return this.coroutineContext;
    }

    public Object getForegroundInfo(c<? super ForegroundInfo> cVar) {
        return getForegroundInfo$suspendImpl(this, cVar);
    }

    @Override // androidx.work.ListenableWorker
    public final j2.q getForegroundInfoAsync() {
        h1 h1VarC = c0.c();
        v6.c cVarB = c0.b(getCoroutineContext().plus(h1VarC));
        JobListenableFuture jobListenableFuture = new JobListenableFuture(h1VarC, null, 2, 0 == true ? 1 : 0);
        c0.u(cVarB, null, new AnonymousClass1(jobListenableFuture, this, null), 3);
        return jobListenableFuture;
    }

    public final SettableFuture<ListenableWorker.Result> getFuture$work_runtime_ktx_release() {
        return this.future;
    }

    public final s getJob$work_runtime_ktx_release() {
        return this.job;
    }

    @Override // androidx.work.ListenableWorker
    public final void onStopped() {
        super.onStopped();
        this.future.cancel(false);
    }

    public final Object setForeground(ForegroundInfo foregroundInfo, c<? super x> cVar) throws Throwable {
        j2.q foregroundAsync = setForegroundAsync(foregroundInfo);
        k.d(foregroundAsync, "setForegroundAsync(foregroundInfo)");
        if (foregroundAsync.isDone()) {
            try {
                foregroundAsync.get();
            } catch (ExecutionException e) {
                Throwable cause = e.getCause();
                if (cause == null) {
                    throw e;
                }
                throw cause;
            }
        } else {
            l lVar = new l(1, a.a.I(cVar));
            lVar.r();
            foregroundAsync.addListener(new ListenableFutureKt$await$2$1(lVar, foregroundAsync), DirectExecutor.INSTANCE);
            lVar.t(new ListenableFutureKt$await$2$2(foregroundAsync));
            Object objP = lVar.p();
            if (objP == a.f17774a) {
                return objP;
            }
        }
        return x.f13520a;
    }

    public final Object setProgress(Data data, c<? super x> cVar) throws Throwable {
        j2.q progressAsync = setProgressAsync(data);
        k.d(progressAsync, "setProgressAsync(data)");
        if (progressAsync.isDone()) {
            try {
                progressAsync.get();
            } catch (ExecutionException e) {
                Throwable cause = e.getCause();
                if (cause == null) {
                    throw e;
                }
                throw cause;
            }
        } else {
            l lVar = new l(1, a.a.I(cVar));
            lVar.r();
            progressAsync.addListener(new ListenableFutureKt$await$2$1(lVar, progressAsync), DirectExecutor.INSTANCE);
            lVar.t(new ListenableFutureKt$await$2$2(progressAsync));
            Object objP = lVar.p();
            if (objP == a.f17774a) {
                return objP;
            }
        }
        return x.f13520a;
    }

    @Override // androidx.work.ListenableWorker
    public final j2.q startWork() {
        c0.u(c0.b(getCoroutineContext().plus(this.job)), null, new C03631(null), 3);
        return this.future;
    }

    public static /* synthetic */ void getCoroutineContext$annotations() {
    }
}
