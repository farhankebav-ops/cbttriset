package com.onesignal.notifications.internal.generation.impl;

import a1.a;
import android.content.Context;
import androidx.work.CoroutineWorker;
import androidx.work.Data;
import androidx.work.ExistingWorkPolicy;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkerParameters;
import com.onesignal.common.AndroidUtils;
import com.onesignal.debug.internal.logging.Logging;
import com.onesignal.notifications.internal.common.NotificationFormatHelper;
import com.onesignal.notifications.internal.common.OSWorkManagerHelper;
import com.onesignal.notifications.internal.generation.INotificationGenerationWorkManager;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class NotificationGenerationWorkManager implements INotificationGenerationWorkManager {
    private static final String ANDROID_NOTIF_ID_WORKER_DATA_PARAM = "android_notif_id";
    private static final String IS_RESTORING_WORKER_DATA_PARAM = "is_restoring";
    private static final String JSON_PAYLOAD_WORKER_DATA_PARAM = "json_payload";
    private static final String OS_ID_DATA_PARAM = "os_notif_id";
    private static final String TIMESTAMP_WORKER_DATA_PARAM = "timestamp";
    public static final Companion Companion = new Companion(null);
    private static final ConcurrentHashMap<String, Boolean> notificationIds = new ConcurrentHashMap<>();

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        public final boolean addNotificationIdProcessed(String osNotificationId) {
            k.e(osNotificationId, "osNotificationId");
            if (!AndroidUtils.INSTANCE.isStringNotEmpty(osNotificationId)) {
                return true;
            }
            if (NotificationGenerationWorkManager.notificationIds.contains(osNotificationId)) {
                Logging.debug$default(a.m("OSNotificationWorkManager notification with notificationId: ", osNotificationId, " already queued"), null, 2, null);
                return false;
            }
            NotificationGenerationWorkManager.notificationIds.put(osNotificationId, Boolean.TRUE);
            return true;
        }

        public final void removeNotificationIdProcessed(String osNotificationId) {
            k.e(osNotificationId, "osNotificationId");
            if (AndroidUtils.INSTANCE.isStringNotEmpty(osNotificationId)) {
                NotificationGenerationWorkManager.notificationIds.remove(osNotificationId);
            }
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class NotificationGenerationWorker extends CoroutineWorker {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public NotificationGenerationWorker(Context context, WorkerParameters workerParams) {
            super(context, workerParams);
            k.e(context, "context");
            k.e(workerParams, "workerParams");
        }

        /* JADX WARN: Removed duplicated region for block: B:8:0x001c  */
        @Override // androidx.work.CoroutineWorker
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public java.lang.Object doWork(v5.c<? super androidx.work.ListenableWorker.Result> r23) throws java.lang.Throwable {
            /*
                Method dump skipped, instruction units count: 285
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.onesignal.notifications.internal.generation.impl.NotificationGenerationWorkManager.NotificationGenerationWorker.doWork(v5.c):java.lang.Object");
        }
    }

    @Override // com.onesignal.notifications.internal.generation.INotificationGenerationWorkManager
    public boolean beginEnqueueingWork(Context context, String osNotificationId, int i2, JSONObject jSONObject, long j, boolean z2, boolean z7) throws Throwable {
        k.e(context, "context");
        k.e(osNotificationId, "osNotificationId");
        String oSNotificationIdFromJson = NotificationFormatHelper.INSTANCE.getOSNotificationIdFromJson(jSONObject);
        if (oSNotificationIdFromJson == null) {
            Logging.debug$default("Notification beginEnqueueingWork with id null", null, 2, null);
            return false;
        }
        if (!Companion.addNotificationIdProcessed(oSNotificationIdFromJson)) {
            Logging.debug$default("Notification beginEnqueueingWork with id duplicated", null, 2, null);
            return true;
        }
        Data dataBuild = new Data.Builder().putString(OS_ID_DATA_PARAM, oSNotificationIdFromJson).putInt(ANDROID_NOTIF_ID_WORKER_DATA_PARAM, i2).putString(JSON_PAYLOAD_WORKER_DATA_PARAM, String.valueOf(jSONObject)).putLong("timestamp", j).putBoolean(IS_RESTORING_WORKER_DATA_PARAM, z2).build();
        k.d(dataBuild, "Builder()\n              …\n                .build()");
        OneTimeWorkRequest oneTimeWorkRequestBuild = new OneTimeWorkRequest.Builder(NotificationGenerationWorker.class).setInputData(dataBuild).build();
        Logging.debug$default("NotificationWorkManager enqueueing notification work with notificationId: " + osNotificationId + " and jsonPayload: " + jSONObject, null, 2, null);
        OSWorkManagerHelper.INSTANCE.getInstance(context).enqueueUniqueWork(osNotificationId, ExistingWorkPolicy.KEEP, oneTimeWorkRequestBuild);
        return true;
    }
}
