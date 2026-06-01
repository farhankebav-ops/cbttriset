package com.onesignal.core.services;

import android.app.job.JobParameters;
import android.app.job.JobService;
import com.onesignal.OneSignal;
import com.onesignal.common.threading.ThreadUtilsKt;
import com.onesignal.core.internal.background.IBackgroundManager;
import com.onesignal.debug.internal.logging.Logging;
import e6.l;
import kotlin.jvm.internal.a0;
import kotlin.jvm.internal.k;
import q5.x;
import r2.q;
import v5.c;
import w5.a;
import x5.e;
import x5.i;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class SyncJobService extends JobService {

    /* JADX INFO: renamed from: com.onesignal.core.services.SyncJobService$onStartJob$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.onesignal.core.services.SyncJobService$onStartJob$1", f = "SyncJobService.kt", l = {45}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends i implements l {
        final /* synthetic */ a0 $backgroundService;
        final /* synthetic */ JobParameters $jobParameters;
        int label;
        final /* synthetic */ SyncJobService this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(a0 a0Var, SyncJobService syncJobService, JobParameters jobParameters, c<? super AnonymousClass1> cVar) {
            super(1, cVar);
            this.$backgroundService = a0Var;
            this.this$0 = syncJobService;
            this.$jobParameters = jobParameters;
        }

        @Override // x5.a
        public final c<x> create(c<?> cVar) {
            return new AnonymousClass1(this.$backgroundService, this.this$0, this.$jobParameters, cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            a aVar = a.f17774a;
            int i2 = this.label;
            if (i2 == 0) {
                q.z0(obj);
                IBackgroundManager iBackgroundManager = (IBackgroundManager) this.$backgroundService.f12717a;
                this.label = 1;
                if (iBackgroundManager.runBackgroundServices(this) == aVar) {
                    return aVar;
                }
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                q.z0(obj);
            }
            Logging.debug$default("LollipopSyncRunnable:JobFinished needsJobReschedule: " + ((IBackgroundManager) this.$backgroundService.f12717a).getNeedsJobReschedule(), null, 2, null);
            boolean needsJobReschedule = ((IBackgroundManager) this.$backgroundService.f12717a).getNeedsJobReschedule();
            ((IBackgroundManager) this.$backgroundService.f12717a).setNeedsJobReschedule(false);
            this.this$0.jobFinished(this.$jobParameters, needsJobReschedule);
            return x.f13520a;
        }

        @Override // e6.l
        public final Object invoke(c<? super x> cVar) {
            return ((AnonymousClass1) create(cVar)).invokeSuspend(x.f13520a);
        }
    }

    @Override // android.app.job.JobService
    public boolean onStartJob(JobParameters jobParameters) {
        k.e(jobParameters, "jobParameters");
        if (!OneSignal.initWithContext(this)) {
            return false;
        }
        a0 a0Var = new a0();
        a0Var.f12717a = OneSignal.INSTANCE.getServices().getService(IBackgroundManager.class);
        ThreadUtilsKt.suspendifyOnThread$default(0, new AnonymousClass1(a0Var, this, jobParameters, null), 1, null);
        return true;
    }

    @Override // android.app.job.JobService
    public boolean onStopJob(JobParameters jobParameters) {
        k.e(jobParameters, "jobParameters");
        boolean zCancelRunBackgroundServices = ((IBackgroundManager) OneSignal.INSTANCE.getServices().getService(IBackgroundManager.class)).cancelRunBackgroundServices();
        Logging.debug$default("SyncJobService onStopJob called, system conditions not available reschedule: " + zCancelRunBackgroundServices, null, 2, null);
        return zCancelRunBackgroundServices;
    }
}
