package com.onesignal.notifications.internal.display;

import android.app.Notification;
import androidx.core.app.NotificationCompat;
import com.onesignal.notifications.internal.common.NotificationGenerationJob;
import com.onesignal.notifications.internal.display.impl.IntentGeneratorForAttachingToNotifications;
import com.onesignal.notifications.internal.display.impl.NotificationDisplayBuilder;
import org.json.JSONObject;
import q5.x;
import v5.c;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public interface ISummaryNotificationDisplayer {
    void createGenericPendingIntentsForGroup(NotificationCompat.Builder builder, IntentGeneratorForAttachingToNotifications intentGeneratorForAttachingToNotifications, JSONObject jSONObject, String str, int i2);

    Object createGrouplessSummaryNotification(NotificationGenerationJob notificationGenerationJob, IntentGeneratorForAttachingToNotifications intentGeneratorForAttachingToNotifications, int i2, int i8, c<? super x> cVar);

    Notification createSingleNotificationBeforeSummaryBuilder(NotificationGenerationJob notificationGenerationJob, NotificationCompat.Builder builder);

    Object createSummaryNotification(NotificationGenerationJob notificationGenerationJob, NotificationDisplayBuilder.OneSignalNotificationBuilder oneSignalNotificationBuilder, int i2, c<? super x> cVar);

    Object updateSummaryNotification(NotificationGenerationJob notificationGenerationJob, c<? super x> cVar);
}
