package com.onesignal.notifications.internal.restoration.impl;

import android.content.Context;
import androidx.work.CoroutineWorker;
import androidx.work.ExistingWorkPolicy;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkerParameters;
import com.onesignal.notifications.internal.common.OSWorkManagerHelper;
import com.onesignal.notifications.internal.restoration.INotificationRestoreWorkManager;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class NotificationRestoreWorkManager implements INotificationRestoreWorkManager {
    public static final Companion Companion = new Companion(null);
    private static final String NOTIFICATION_RESTORE_WORKER_IDENTIFIER = NotificationRestoreWorker.class.getCanonicalName();
    private boolean restored;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class NotificationRestoreWorker extends CoroutineWorker {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public NotificationRestoreWorker(Context context, WorkerParameters workerParams) {
            super(context, workerParams);
            k.e(context, "context");
            k.e(workerParams, "workerParams");
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        @Override // androidx.work.CoroutineWorker
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public java.lang.Object doWork(v5.c<? super androidx.work.ListenableWorker.Result> r8) throws java.lang.Throwable {
            /*
                r7 = this;
                boolean r0 = r8 instanceof com.onesignal.notifications.internal.restoration.impl.NotificationRestoreWorkManager$NotificationRestoreWorker$doWork$1
                if (r0 == 0) goto L13
                r0 = r8
                com.onesignal.notifications.internal.restoration.impl.NotificationRestoreWorkManager$NotificationRestoreWorker$doWork$1 r0 = (com.onesignal.notifications.internal.restoration.impl.NotificationRestoreWorkManager$NotificationRestoreWorker$doWork$1) r0
                int r1 = r0.label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.label = r1
                goto L18
            L13:
                com.onesignal.notifications.internal.restoration.impl.NotificationRestoreWorkManager$NotificationRestoreWorker$doWork$1 r0 = new com.onesignal.notifications.internal.restoration.impl.NotificationRestoreWorkManager$NotificationRestoreWorker$doWork$1
                r0.<init>(r7, r8)
            L18:
                java.lang.Object r8 = r0.result
                w5.a r1 = w5.a.f17774a
                int r2 = r0.label
                java.lang.String r3 = "success()"
                r4 = 1
                if (r2 == 0) goto L31
                if (r2 != r4) goto L29
                r2.q.z0(r8)
                goto L76
            L29:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r0)
                throw r8
            L31:
                r2.q.z0(r8)
                android.content.Context r8 = r7.getApplicationContext()
                java.lang.String r2 = "applicationContext"
                kotlin.jvm.internal.k.d(r8, r2)
                boolean r2 = com.onesignal.OneSignal.initWithContext(r8)
                if (r2 != 0) goto L4b
                androidx.work.ListenableWorker$Result r8 = androidx.work.ListenableWorker.Result.success()
                kotlin.jvm.internal.k.d(r8, r3)
                return r8
            L4b:
                com.onesignal.notifications.internal.common.NotificationHelper r2 = com.onesignal.notifications.internal.common.NotificationHelper.INSTANCE
                r5 = 2
                r6 = 0
                boolean r8 = com.onesignal.notifications.internal.common.NotificationHelper.areNotificationsEnabled$default(r2, r8, r6, r5, r6)
                if (r8 != 0) goto L5f
                androidx.work.ListenableWorker$Result r8 = androidx.work.ListenableWorker.Result.failure()
                java.lang.String r0 = "failure()"
                kotlin.jvm.internal.k.d(r8, r0)
                return r8
            L5f:
                com.onesignal.OneSignal r8 = com.onesignal.OneSignal.INSTANCE
                com.onesignal.common.services.IServiceProvider r8 = r8.getServices()
                java.lang.Class<com.onesignal.notifications.internal.restoration.INotificationRestoreProcessor> r2 = com.onesignal.notifications.internal.restoration.INotificationRestoreProcessor.class
                java.lang.Object r8 = r8.getService(r2)
                com.onesignal.notifications.internal.restoration.INotificationRestoreProcessor r8 = (com.onesignal.notifications.internal.restoration.INotificationRestoreProcessor) r8
                r0.label = r4
                java.lang.Object r8 = r8.process(r0)
                if (r8 != r1) goto L76
                return r1
            L76:
                androidx.work.ListenableWorker$Result r8 = androidx.work.ListenableWorker.Result.success()
                kotlin.jvm.internal.k.d(r8, r3)
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: com.onesignal.notifications.internal.restoration.impl.NotificationRestoreWorkManager.NotificationRestoreWorker.doWork(v5.c):java.lang.Object");
        }
    }

    @Override // com.onesignal.notifications.internal.restoration.INotificationRestoreWorkManager
    public void beginEnqueueingWork(Context context, boolean z2) {
        k.e(context, "context");
        synchronized (Boolean.valueOf(this.restored)) {
            if (this.restored) {
                return;
            }
            this.restored = true;
            OSWorkManagerHelper.INSTANCE.getInstance(context).enqueueUniqueWork(NOTIFICATION_RESTORE_WORKER_IDENTIFIER, ExistingWorkPolicy.KEEP, new OneTimeWorkRequest.Builder(NotificationRestoreWorker.class).setInitialDelay(z2 ? 15 : 0, TimeUnit.SECONDS).build());
        }
    }
}
