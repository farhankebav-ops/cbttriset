package com.onesignal.notifications.internal.receivereceipt.impl;

import android.content.Context;
import androidx.work.Constraints;
import androidx.work.CoroutineWorker;
import androidx.work.Data;
import androidx.work.ExistingWorkPolicy;
import androidx.work.NetworkType;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkerParameters;
import com.onesignal.common.AndroidUtils;
import com.onesignal.core.internal.application.IApplicationService;
import com.onesignal.core.internal.config.ConfigModelStore;
import com.onesignal.debug.internal.logging.Logging;
import com.onesignal.notifications.internal.common.OSWorkManagerHelper;
import com.onesignal.notifications.internal.receivereceipt.IReceiveReceiptWorkManager;
import com.onesignal.user.internal.subscriptions.ISubscriptionManager;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class ReceiveReceiptWorkManager implements IReceiveReceiptWorkManager {
    public static final Companion Companion = new Companion(null);
    private static final String OS_APP_ID = "os_app_id";
    private static final String OS_NOTIFICATION_ID = "os_notification_id";
    private static final String OS_SUBSCRIPTION_ID = "os_subscription_id";
    private final IApplicationService _applicationService;
    private final ConfigModelStore _configModelStore;
    private final ISubscriptionManager _subscriptionManager;
    private final int maxDelay;
    private final int minDelay;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class ReceiveReceiptWorker extends CoroutineWorker {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ReceiveReceiptWorker(Context context, WorkerParameters workerParams) {
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
        public java.lang.Object doWork(v5.c<? super androidx.work.ListenableWorker.Result> r9) throws java.lang.Throwable {
            /*
                r8 = this;
                boolean r0 = r9 instanceof com.onesignal.notifications.internal.receivereceipt.impl.ReceiveReceiptWorkManager$ReceiveReceiptWorker$doWork$1
                if (r0 == 0) goto L13
                r0 = r9
                com.onesignal.notifications.internal.receivereceipt.impl.ReceiveReceiptWorkManager$ReceiveReceiptWorker$doWork$1 r0 = (com.onesignal.notifications.internal.receivereceipt.impl.ReceiveReceiptWorkManager$ReceiveReceiptWorker$doWork$1) r0
                int r1 = r0.label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.label = r1
                goto L18
            L13:
                com.onesignal.notifications.internal.receivereceipt.impl.ReceiveReceiptWorkManager$ReceiveReceiptWorker$doWork$1 r0 = new com.onesignal.notifications.internal.receivereceipt.impl.ReceiveReceiptWorkManager$ReceiveReceiptWorker$doWork$1
                r0.<init>(r8, r9)
            L18:
                java.lang.Object r9 = r0.result
                w5.a r1 = w5.a.f17774a
                int r2 = r0.label
                java.lang.String r3 = "success()"
                r4 = 1
                if (r2 == 0) goto L31
                if (r2 != r4) goto L29
                r2.q.z0(r9)
                goto L89
            L29:
                java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r9.<init>(r0)
                throw r9
            L31:
                r2.q.z0(r9)
                android.content.Context r9 = r8.getApplicationContext()
                java.lang.String r2 = "applicationContext"
                kotlin.jvm.internal.k.d(r9, r2)
                boolean r9 = com.onesignal.OneSignal.initWithContext(r9)
                if (r9 != 0) goto L4b
                androidx.work.ListenableWorker$Result r9 = androidx.work.ListenableWorker.Result.success()
                kotlin.jvm.internal.k.d(r9, r3)
                return r9
            L4b:
                androidx.work.Data r9 = r8.getInputData()
                java.lang.String r2 = "os_notification_id"
                java.lang.String r9 = r9.getString(r2)
                kotlin.jvm.internal.k.b(r9)
                androidx.work.Data r2 = r8.getInputData()
                java.lang.String r5 = "os_app_id"
                java.lang.String r2 = r2.getString(r5)
                kotlin.jvm.internal.k.b(r2)
                androidx.work.Data r5 = r8.getInputData()
                java.lang.String r6 = "os_subscription_id"
                java.lang.String r5 = r5.getString(r6)
                kotlin.jvm.internal.k.b(r5)
                com.onesignal.OneSignal r6 = com.onesignal.OneSignal.INSTANCE
                com.onesignal.common.services.IServiceProvider r6 = r6.getServices()
                java.lang.Class<com.onesignal.notifications.internal.receivereceipt.IReceiveReceiptProcessor> r7 = com.onesignal.notifications.internal.receivereceipt.IReceiveReceiptProcessor.class
                java.lang.Object r6 = r6.getService(r7)
                com.onesignal.notifications.internal.receivereceipt.IReceiveReceiptProcessor r6 = (com.onesignal.notifications.internal.receivereceipt.IReceiveReceiptProcessor) r6
                r0.label = r4
                java.lang.Object r9 = r6.sendReceiveReceipt(r2, r5, r9, r0)
                if (r9 != r1) goto L89
                return r1
            L89:
                androidx.work.ListenableWorker$Result r9 = androidx.work.ListenableWorker.Result.success()
                kotlin.jvm.internal.k.d(r9, r3)
                return r9
            */
            throw new UnsupportedOperationException("Method not decompiled: com.onesignal.notifications.internal.receivereceipt.impl.ReceiveReceiptWorkManager.ReceiveReceiptWorker.doWork(v5.c):java.lang.Object");
        }
    }

    public ReceiveReceiptWorkManager(IApplicationService _applicationService, ConfigModelStore _configModelStore, ISubscriptionManager _subscriptionManager) {
        k.e(_applicationService, "_applicationService");
        k.e(_configModelStore, "_configModelStore");
        k.e(_subscriptionManager, "_subscriptionManager");
        this._applicationService = _applicationService;
        this._configModelStore = _configModelStore;
        this._subscriptionManager = _subscriptionManager;
        this.maxDelay = 25;
    }

    private final Constraints buildConstraints() {
        return new Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build();
    }

    @Override // com.onesignal.notifications.internal.receivereceipt.IReceiveReceiptWorkManager
    public void enqueueReceiveReceipt(String notificationId) throws Throwable {
        k.e(notificationId, "notificationId");
        if (!this._configModelStore.getModel().getReceiveReceiptEnabled()) {
            Logging.debug$default("sendReceiveReceipt disabled", null, 2, null);
            return;
        }
        String appId = this._configModelStore.getModel().getAppId();
        String id = this._subscriptionManager.getSubscriptions().getPush().getId();
        if (id.length() == 0 || appId.length() == 0) {
            Logging.debug$default("ReceiveReceiptWorkManager: No push subscription or appId!", null, 2, null);
        }
        int randomDelay = AndroidUtils.INSTANCE.getRandomDelay(this.minDelay, this.maxDelay);
        Data dataBuild = new Data.Builder().putString(OS_NOTIFICATION_ID, notificationId).putString(OS_APP_ID, appId).putString(OS_SUBSCRIPTION_ID, id).build();
        k.d(dataBuild, "Builder()\n              …\n                .build()");
        OneTimeWorkRequest oneTimeWorkRequestBuild = new OneTimeWorkRequest.Builder(ReceiveReceiptWorker.class).setConstraints(buildConstraints()).setInitialDelay(randomDelay, TimeUnit.SECONDS).setInputData(dataBuild).build();
        Logging.debug$default("OSReceiveReceiptController enqueueing send receive receipt work with notificationId: " + notificationId + " and delay: " + randomDelay + " seconds", null, 2, null);
        OSWorkManagerHelper.INSTANCE.getInstance(this._applicationService.getAppContext()).enqueueUniqueWork(notificationId.concat("_receive_receipt"), ExistingWorkPolicy.KEEP, oneTimeWorkRequestBuild);
    }
}
