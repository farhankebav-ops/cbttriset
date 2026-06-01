package com.onesignal.core.internal.background.impl;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import androidx.core.content.ContextCompat;
import com.onesignal.core.internal.application.IApplicationLifecycleHandler;
import com.onesignal.core.internal.application.IApplicationService;
import com.onesignal.core.internal.background.IBackgroundManager;
import com.onesignal.core.internal.background.IBackgroundService;
import com.onesignal.core.internal.startup.IStartableService;
import com.onesignal.core.internal.time.ITime;
import com.onesignal.core.services.SyncJobService;
import com.onesignal.debug.internal.logging.Logging;
import e6.p;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import q5.x;
import q6.a0;
import q6.c0;
import q6.f1;
import q6.m0;
import r2.q;
import v5.c;
import w5.a;
import x5.e;
import x5.i;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class BackgroundManager implements IApplicationLifecycleHandler, IBackgroundManager, IStartableService {
    public static final Companion Companion = new Companion(null);
    private static final int SYNC_TASK_ID = 2071862118;
    private final IApplicationService _applicationService;
    private final List<IBackgroundService> _backgroundServices;
    private final ITime _time;
    private f1 backgroundSyncJob;
    private final Object lock;
    private boolean needsJobReschedule;
    private long nextScheduledSyncTimeMs;
    private final Class<?> syncServiceJobClass;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: renamed from: com.onesignal.core.internal.background.impl.BackgroundManager$runBackgroundServices$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.onesignal.core.internal.background.impl.BackgroundManager$runBackgroundServices$2", f = "BackgroundManager.kt", l = {}, m = "invokeSuspend")
    public static final class AnonymousClass2 extends i implements p {
        private /* synthetic */ Object L$0;
        int label;

        /* JADX INFO: renamed from: com.onesignal.core.internal.background.impl.BackgroundManager$runBackgroundServices$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        @e(c = "com.onesignal.core.internal.background.impl.BackgroundManager$runBackgroundServices$2$1", f = "BackgroundManager.kt", l = {116}, m = "invokeSuspend")
        public static final class AnonymousClass1 extends i implements p {
            Object L$0;
            int label;
            final /* synthetic */ BackgroundManager this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(BackgroundManager backgroundManager, c<? super AnonymousClass1> cVar) {
                super(2, cVar);
                this.this$0 = backgroundManager;
            }

            @Override // x5.a
            public final c<x> create(Object obj, c<?> cVar) {
                return new AnonymousClass1(this.this$0, cVar);
            }

            @Override // x5.a
            public final Object invokeSuspend(Object obj) throws Throwable {
                Iterator it;
                a aVar = a.f17774a;
                int i2 = this.label;
                if (i2 == 0) {
                    q.z0(obj);
                    Object obj2 = this.this$0.lock;
                    BackgroundManager backgroundManager = this.this$0;
                    synchronized (obj2) {
                        backgroundManager.nextScheduledSyncTimeMs = 0L;
                    }
                    it = this.this$0._backgroundServices.iterator();
                } else {
                    if (i2 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    it = (Iterator) this.L$0;
                    q.z0(obj);
                }
                while (it.hasNext()) {
                    IBackgroundService iBackgroundService = (IBackgroundService) it.next();
                    this.L$0 = it;
                    this.label = 1;
                    if (iBackgroundService.backgroundRun(this) == aVar) {
                        return aVar;
                    }
                }
                this.this$0.scheduleBackground();
                return x.f13520a;
            }

            @Override // e6.p
            public final Object invoke(a0 a0Var, c<? super x> cVar) {
                return ((AnonymousClass1) create(a0Var, cVar)).invokeSuspend(x.f13520a);
            }
        }

        public AnonymousClass2(c<? super AnonymousClass2> cVar) {
            super(2, cVar);
        }

        @Override // x5.a
        public final c<x> create(Object obj, c<?> cVar) {
            AnonymousClass2 anonymousClass2 = BackgroundManager.this.new AnonymousClass2(cVar);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            a aVar = a.f17774a;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            q.z0(obj);
            a0 a0Var = (a0) this.L$0;
            Logging.debug$default("OSBackground sync, calling initWithContext", null, 2, null);
            BackgroundManager backgroundManager = BackgroundManager.this;
            backgroundManager.backgroundSyncJob = c0.u(a0Var, m0.f13567b, new AnonymousClass1(backgroundManager, null), 2);
            return x.f13520a;
        }

        @Override // e6.p
        public final Object invoke(a0 a0Var, c<? super x> cVar) {
            return ((AnonymousClass2) create(a0Var, cVar)).invokeSuspend(x.f13520a);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public BackgroundManager(IApplicationService _applicationService, ITime _time, List<? extends IBackgroundService> _backgroundServices) {
        k.e(_applicationService, "_applicationService");
        k.e(_time, "_time");
        k.e(_backgroundServices, "_backgroundServices");
        this._applicationService = _applicationService;
        this._time = _time;
        this._backgroundServices = _backgroundServices;
        this.lock = new Object();
        this.syncServiceJobClass = SyncJobService.class;
    }

    private final void cancelBackgroundSyncTask() {
        Logging.debug$default("BackgroundManager cancel background sync", null, 2, null);
        synchronized (this.lock) {
            Object systemService = this._applicationService.getAppContext().getSystemService("jobscheduler");
            k.c(systemService, "null cannot be cast to non-null type android.app.job.JobScheduler");
            ((JobScheduler) systemService).cancel(SYNC_TASK_ID);
        }
    }

    private final void cancelSyncTask() {
        synchronized (this.lock) {
            this.nextScheduledSyncTimeMs = 0L;
            cancelBackgroundSyncTask();
        }
    }

    private final boolean hasBootPermission() {
        return ContextCompat.checkSelfPermission(this._applicationService.getAppContext(), "android.permission.RECEIVE_BOOT_COMPLETED") == 0;
    }

    private final boolean isJobIdRunning() {
        f1 f1Var;
        Object systemService = this._applicationService.getAppContext().getSystemService("jobscheduler");
        k.c(systemService, "null cannot be cast to non-null type android.app.job.JobScheduler");
        Iterator<JobInfo> it = ((JobScheduler) systemService).getAllPendingJobs().iterator();
        while (it.hasNext()) {
            if (it.next().getId() == SYNC_TASK_ID && (f1Var = this.backgroundSyncJob) != null) {
                k.b(f1Var);
                if (f1Var.isActive()) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void scheduleBackground() {
        Iterator<IBackgroundService> it = this._backgroundServices.iterator();
        Long l = null;
        while (it.hasNext()) {
            Long scheduleBackgroundRunIn = it.next().getScheduleBackgroundRunIn();
            if (scheduleBackgroundRunIn != null && (l == null || scheduleBackgroundRunIn.longValue() < l.longValue())) {
                l = scheduleBackgroundRunIn;
            }
        }
        if (l != null) {
            scheduleSyncTask(l.longValue());
        }
    }

    private final void scheduleBackgroundSyncTask(long j) {
        synchronized (this.lock) {
            scheduleSyncServiceAsJob(j);
        }
    }

    private final void scheduleSyncServiceAsJob(long j) {
        Logging.debug$default(androidx.camera.core.processing.util.a.j("OSBackgroundSync scheduleSyncServiceAsJob:atTime: ", j), null, 2, null);
        if (isJobIdRunning()) {
            Logging.verbose$default("OSBackgroundSync scheduleSyncServiceAsJob Scheduler already running!", null, 2, null);
            setNeedsJobReschedule(true);
            return;
        }
        Context appContext = this._applicationService.getAppContext();
        k.b(appContext);
        Class<?> cls = this.syncServiceJobClass;
        k.b(cls);
        JobInfo.Builder builder = new JobInfo.Builder(SYNC_TASK_ID, new ComponentName(appContext, cls));
        builder.setMinimumLatency(j).setRequiredNetworkType(1);
        if (hasBootPermission()) {
            builder.setPersisted(true);
        }
        Context appContext2 = this._applicationService.getAppContext();
        k.b(appContext2);
        Object systemService = appContext2.getSystemService("jobscheduler");
        k.c(systemService, "null cannot be cast to non-null type android.app.job.JobScheduler");
        try {
            Logging.info$default("OSBackgroundSync scheduleSyncServiceAsJob:result: " + ((JobScheduler) systemService).schedule(builder.build()), null, 2, null);
        } catch (NullPointerException e) {
            Logging.error("scheduleSyncServiceAsJob called JobScheduler.jobScheduler which triggered an internal null Android error. Skipping job.", e);
        }
    }

    private final void scheduleSyncTask(long j) {
        synchronized (this.lock) {
            if (this.nextScheduledSyncTimeMs != 0 && this._time.getCurrentTimeMillis() + j > this.nextScheduledSyncTimeMs) {
                Logging.debug$default("OSSyncService scheduleSyncTask already update scheduled nextScheduledSyncTimeMs: " + this.nextScheduledSyncTimeMs, null, 2, null);
            } else {
                if (j < 5000) {
                    j = 5000;
                }
                scheduleBackgroundSyncTask(j);
                this.nextScheduledSyncTimeMs = this._time.getCurrentTimeMillis() + j;
            }
        }
    }

    @Override // com.onesignal.core.internal.background.IBackgroundManager
    public boolean cancelRunBackgroundServices() {
        f1 f1Var = this.backgroundSyncJob;
        if (f1Var == null || !f1Var.isActive()) {
            return false;
        }
        f1 f1Var2 = this.backgroundSyncJob;
        k.b(f1Var2);
        f1Var2.a(null);
        return true;
    }

    @Override // com.onesignal.core.internal.background.IBackgroundManager
    public boolean getNeedsJobReschedule() {
        return this.needsJobReschedule;
    }

    @Override // com.onesignal.core.internal.application.IApplicationLifecycleHandler
    public void onFocus(boolean z2) {
        cancelSyncTask();
    }

    @Override // com.onesignal.core.internal.application.IApplicationLifecycleHandler
    public void onUnfocused() {
        scheduleBackground();
    }

    @Override // com.onesignal.core.internal.background.IBackgroundManager
    public Object runBackgroundServices(c<? super x> cVar) {
        Object objJ = c0.j(new AnonymousClass2(null), cVar);
        return objJ == a.f17774a ? objJ : x.f13520a;
    }

    @Override // com.onesignal.core.internal.background.IBackgroundManager
    public void setNeedsJobReschedule(boolean z2) {
        this.needsJobReschedule = z2;
    }

    @Override // com.onesignal.core.internal.startup.IStartableService
    public void start() {
        this._applicationService.addApplicationLifecycleHandler(this);
    }
}
