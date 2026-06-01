package com.onesignal.notifications.internal.display;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import androidx.core.app.NotificationCompat;
import com.onesignal.notifications.internal.common.NotificationGenerationJob;
import com.onesignal.notifications.internal.display.impl.IntentGeneratorForAttachingToNotifications;
import com.onesignal.notifications.internal.display.impl.NotificationDisplayBuilder;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public interface INotificationDisplayBuilder {
    void addNotificationActionButtons(JSONObject jSONObject, IntentGeneratorForAttachingToNotifications intentGeneratorForAttachingToNotifications, NotificationCompat.Builder builder, int i2, String str);

    void addXiaomiSettings(NotificationDisplayBuilder.OneSignalNotificationBuilder oneSignalNotificationBuilder, Notification notification);

    NotificationDisplayBuilder.OneSignalNotificationBuilder getBaseOneSignalNotificationBuilder(NotificationGenerationJob notificationGenerationJob);

    Bitmap getDefaultLargeIcon();

    int getDefaultSmallIconId();

    int getGroupAlertBehavior();

    Intent getNewBaseDismissIntent(int i2);

    PendingIntent getNewDismissActionPendingIntent(int i2, Intent intent);

    CharSequence getTitle(JSONObject jSONObject);

    void removeNotifyOptions(NotificationCompat.Builder builder);
}
