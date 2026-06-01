package androidx.work.impl;

import androidx.annotation.RestrictTo;
import androidx.camera.core.w;
import androidx.work.Configuration;
import androidx.work.Operation;
import androidx.work.WorkInfo;
import androidx.work.WorkManager;
import androidx.work.WorkRequest;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecDao;
import androidx.work.impl.model.WorkTagDao;
import androidx.work.impl.utils.EnqueueUtilsKt;
import androidx.work.impl.utils.futures.SettableFuture;
import j2.q;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.jvm.internal.k;
import r5.l;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class WorkerUpdater {
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final Operation enqueueUniquelyNamedPeriodic(WorkManagerImpl workManagerImpl, String name, WorkRequest workRequest) {
        k.e(workManagerImpl, "<this>");
        k.e(name, "name");
        k.e(workRequest, "workRequest");
        OperationImpl operationImpl = new OperationImpl();
        workManagerImpl.getWorkTaskExecutor().getSerialTaskExecutor().execute(new w(workManagerImpl, name, operationImpl, new WorkerUpdater$enqueueUniquelyNamedPeriodic$enqueueNew$1(workRequest, workManagerImpl, name, operationImpl), workRequest, 1));
        return operationImpl;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void enqueueUniquelyNamedPeriodic$lambda$3(WorkManagerImpl this_enqueueUniquelyNamedPeriodic, String name, OperationImpl operation, e6.a enqueueNew, WorkRequest workRequest) {
        k.e(this_enqueueUniquelyNamedPeriodic, "$this_enqueueUniquelyNamedPeriodic");
        k.e(name, "$name");
        k.e(operation, "$operation");
        k.e(enqueueNew, "$enqueueNew");
        k.e(workRequest, "$workRequest");
        WorkSpecDao workSpecDao = this_enqueueUniquelyNamedPeriodic.getWorkDatabase().workSpecDao();
        List<WorkSpec.IdAndState> workSpecIdAndStatesForName = workSpecDao.getWorkSpecIdAndStatesForName(name);
        if (workSpecIdAndStatesForName.size() > 1) {
            failWorkTypeChanged(operation, "Can't apply UPDATE policy to the chains of work.");
            return;
        }
        WorkSpec.IdAndState idAndState = (WorkSpec.IdAndState) l.Y0(workSpecIdAndStatesForName);
        if (idAndState == null) {
            enqueueNew.invoke();
            return;
        }
        WorkSpec workSpec = workSpecDao.getWorkSpec(idAndState.id);
        if (workSpec == null) {
            operation.markState(new Operation.State.FAILURE(new IllegalStateException(androidx.camera.core.processing.util.a.n(new StringBuilder("WorkSpec with "), idAndState.id, ", that matches a name \"", name, "\", wasn't found"))));
            return;
        }
        if (!workSpec.isPeriodic()) {
            failWorkTypeChanged(operation, "Can't update OneTimeWorker to Periodic Worker. Update operation must preserve worker's type.");
            return;
        }
        if (idAndState.state == WorkInfo.State.CANCELLED) {
            workSpecDao.delete(idAndState.id);
            enqueueNew.invoke();
            return;
        }
        WorkSpec workSpecCopy$default = WorkSpec.copy$default(workRequest.getWorkSpec(), idAndState.id, null, null, null, null, null, 0L, 0L, 0L, null, 0, null, 0L, 0L, 0L, 0L, false, null, 0, 0, 1048574, null);
        try {
            Processor processor = this_enqueueUniquelyNamedPeriodic.getProcessor();
            k.d(processor, "processor");
            WorkDatabase workDatabase = this_enqueueUniquelyNamedPeriodic.getWorkDatabase();
            k.d(workDatabase, "workDatabase");
            Configuration configuration = this_enqueueUniquelyNamedPeriodic.getConfiguration();
            k.d(configuration, "configuration");
            List<Scheduler> schedulers = this_enqueueUniquelyNamedPeriodic.getSchedulers();
            k.d(schedulers, "schedulers");
            updateWorkImpl(processor, workDatabase, configuration, schedulers, workSpecCopy$default, workRequest.getTags());
            operation.markState(Operation.SUCCESS);
        } catch (Throwable th) {
            operation.markState(new Operation.State.FAILURE(th));
        }
    }

    private static final void failWorkTypeChanged(OperationImpl operationImpl, String str) {
        operationImpl.markState(new Operation.State.FAILURE(new UnsupportedOperationException(str)));
    }

    private static final WorkManager.UpdateResult updateWorkImpl(Processor processor, final WorkDatabase workDatabase, Configuration configuration, final List<? extends Scheduler> list, final WorkSpec workSpec, final Set<String> set) {
        final String str = workSpec.id;
        final WorkSpec workSpec2 = workDatabase.workSpecDao().getWorkSpec(str);
        if (workSpec2 == null) {
            throw new IllegalArgumentException(a1.a.m("Worker with ", str, " doesn't exist"));
        }
        if (workSpec2.state.isFinished()) {
            return WorkManager.UpdateResult.NOT_APPLIED;
        }
        if (workSpec2.isPeriodic() ^ workSpec.isPeriodic()) {
            WorkerUpdater$updateWorkImpl$type$1 workerUpdater$updateWorkImpl$type$1 = WorkerUpdater$updateWorkImpl$type$1.INSTANCE;
            StringBuilder sb = new StringBuilder("Can't update ");
            sb.append((String) workerUpdater$updateWorkImpl$type$1.invoke((Object) workSpec2));
            sb.append(" Worker to ");
            throw new UnsupportedOperationException(a1.a.r(sb, (String) workerUpdater$updateWorkImpl$type$1.invoke((Object) workSpec), " Worker. Update operation must preserve worker's type."));
        }
        final boolean zIsEnqueued = processor.isEnqueued(str);
        if (!zIsEnqueued) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                ((Scheduler) it.next()).cancel(str);
            }
        }
        workDatabase.runInTransaction(new Runnable() { // from class: androidx.work.impl.c
            @Override // java.lang.Runnable
            public final void run() {
                WorkerUpdater.updateWorkImpl$lambda$1(workDatabase, workSpec, workSpec2, list, str, set, zIsEnqueued);
            }
        });
        if (!zIsEnqueued) {
            Schedulers.schedule(configuration, workDatabase, list);
        }
        return zIsEnqueued ? WorkManager.UpdateResult.APPLIED_FOR_NEXT_RUN : WorkManager.UpdateResult.APPLIED_IMMEDIATELY;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateWorkImpl$lambda$1(WorkDatabase workDatabase, WorkSpec newWorkSpec, WorkSpec oldWorkSpec, List schedulers, String workSpecId, Set tags, boolean z2) {
        k.e(workDatabase, "$workDatabase");
        k.e(newWorkSpec, "$newWorkSpec");
        k.e(oldWorkSpec, "$oldWorkSpec");
        k.e(schedulers, "$schedulers");
        k.e(workSpecId, "$workSpecId");
        k.e(tags, "$tags");
        WorkSpecDao workSpecDao = workDatabase.workSpecDao();
        WorkTagDao workTagDao = workDatabase.workTagDao();
        workSpecDao.updateWorkSpec(EnqueueUtilsKt.wrapInConstraintTrackingWorkerIfNeeded(schedulers, WorkSpec.copy$default(newWorkSpec, null, oldWorkSpec.state, null, null, null, null, 0L, 0L, 0L, null, oldWorkSpec.runAttemptCount, null, 0L, oldWorkSpec.lastEnqueueTime, 0L, 0L, false, null, 0, oldWorkSpec.getGeneration() + 1, 515069, null)));
        workTagDao.deleteByWorkSpecId(workSpecId);
        workTagDao.insertTags(workSpecId, tags);
        if (z2) {
            return;
        }
        workSpecDao.markWorkSpecScheduled(workSpecId, -1L);
        workDatabase.workProgressDao().delete(workSpecId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateWorkImpl$lambda$2(SettableFuture settableFuture, WorkManagerImpl this_updateWorkImpl, WorkRequest workRequest) {
        k.e(this_updateWorkImpl, "$this_updateWorkImpl");
        k.e(workRequest, "$workRequest");
        if (settableFuture.isCancelled()) {
            return;
        }
        try {
            Processor processor = this_updateWorkImpl.getProcessor();
            k.d(processor, "processor");
            WorkDatabase workDatabase = this_updateWorkImpl.getWorkDatabase();
            k.d(workDatabase, "workDatabase");
            Configuration configuration = this_updateWorkImpl.getConfiguration();
            k.d(configuration, "configuration");
            List<Scheduler> schedulers = this_updateWorkImpl.getSchedulers();
            k.d(schedulers, "schedulers");
            settableFuture.set(updateWorkImpl(processor, workDatabase, configuration, schedulers, workRequest.getWorkSpec(), workRequest.getTags()));
        } catch (Throwable th) {
            settableFuture.setException(th);
        }
    }

    public static final q updateWorkImpl(WorkManagerImpl workManagerImpl, WorkRequest workRequest) {
        k.e(workManagerImpl, "<this>");
        k.e(workRequest, "workRequest");
        SettableFuture future = SettableFuture.create();
        workManagerImpl.getWorkTaskExecutor().getSerialTaskExecutor().execute(new androidx.camera.core.processing.c(future, workManagerImpl, workRequest, 8));
        k.d(future, "future");
        return future;
    }
}
