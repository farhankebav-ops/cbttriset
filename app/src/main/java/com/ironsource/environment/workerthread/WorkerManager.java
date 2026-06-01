package com.ironsource.environment.workerthread;

import com.ironsource.C2531r4;
import com.ironsource.environment.workerthread.WorkerResult;
import com.ironsource.mediationsdk.logger.IronLog;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class WorkerManager<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    List<Callable<T>> f8497a = new ArrayList();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ExecutorService f8498b;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface WorkEndedListener<T> {
        void onWorkCompleted(List<WorkerResult<T>> list, long j);

        void onWorkFailed(String str);
    }

    public WorkerManager(ExecutorService executorService) {
        this.f8498b = executorService;
    }

    public void addCallable(Callable<T> callable) {
        this.f8497a.add(callable);
    }

    public void startWork(WorkEndedListener<T> workEndedListener, long j, TimeUnit timeUnit) {
        if (this.f8498b.isShutdown()) {
            workEndedListener.onWorkFailed("can not start work, executor has been shut down");
            return;
        }
        if (this.f8497a.isEmpty()) {
            workEndedListener.onWorkFailed("can not start work, callable list is empty");
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        ArrayList arrayList = new ArrayList();
        try {
            List<Future<T>> listInvokeAll = this.f8498b.invokeAll(this.f8497a, j, timeUnit);
            for (int i2 = 0; i2 < listInvokeAll.size(); i2++) {
                Future<T> future = listInvokeAll.get(i2);
                if (!future.isDone() || future.isCancelled()) {
                    arrayList.add(new WorkerResult.Canceled(this.f8497a.get(i2)));
                } else {
                    try {
                        arrayList.add(new WorkerResult.Completed(future.get()));
                    } catch (InterruptedException e) {
                        e = e;
                        C2531r4.d().a(e);
                        arrayList.add(new WorkerResult.Failed(this.f8497a.get(i2), e));
                    } catch (CancellationException e4) {
                        C2531r4.d().a(e4);
                        arrayList.add(new WorkerResult.Canceled(this.f8497a.get(i2)));
                    } catch (ExecutionException e8) {
                        e = e8;
                        C2531r4.d().a(e);
                        arrayList.add(new WorkerResult.Failed(this.f8497a.get(i2), e));
                    }
                }
            }
            workEndedListener.onWorkCompleted(arrayList, System.currentTimeMillis() - jCurrentTimeMillis);
            this.f8498b.shutdownNow();
        } catch (Exception e9) {
            C2531r4.d().a(e9);
            IronLog.INTERNAL.error(e9.toString());
            workEndedListener.onWorkFailed("failed to invoke callables, error= " + e9.getMessage());
            this.f8498b.shutdownNow();
        }
    }
}
