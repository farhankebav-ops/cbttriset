package com.onesignal.notifications.internal.common;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build;
import android.service.notification.StatusBarNotification;
import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import com.onesignal.common.AndroidUtils;
import com.onesignal.core.internal.database.impl.OneSignalDbContract;
import com.onesignal.core.internal.time.ITime;
import com.onesignal.debug.internal.logging.Logging;
import com.onesignal.notifications.INotification;
import com.onesignal.notifications.internal.NotificationClickEvent;
import com.onesignal.notifications.internal.NotificationClickResult;
import java.util.ArrayList;
import kotlin.jvm.internal.k;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class NotificationHelper {
    public static final int GROUPLESS_SUMMARY_ID = -718463522;
    public static final String GROUPLESS_SUMMARY_KEY = "os_group_undefined";
    public static final NotificationHelper INSTANCE = new NotificationHelper();

    private NotificationHelper() {
    }

    public static /* synthetic */ boolean areNotificationsEnabled$default(NotificationHelper notificationHelper, Context context, String str, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str = null;
        }
        return notificationHelper.areNotificationsEnabled(context, str);
    }

    public final boolean areNotificationsEnabled(Context context, String str) {
        k.e(context, "context");
        try {
            if (!NotificationManagerCompat.from(context).areNotificationsEnabled()) {
                return false;
            }
            if (str == null || Build.VERSION.SDK_INT < 26) {
                return true;
            }
            NotificationManager notificationManager = getNotificationManager(context);
            NotificationChannel notificationChannel = notificationManager != null ? notificationManager.getNotificationChannel(str) : null;
            if (notificationChannel != null) {
                return notificationChannel.getImportance() != 0;
            }
            return true;
        } catch (Throwable unused) {
            return true;
        }
    }

    @RequiresApi(api = 24)
    public final void assignGrouplessNotifications(Context context, ArrayList<StatusBarNotification> grouplessNotifs) {
        k.e(grouplessNotifs, "grouplessNotifs");
        int size = grouplessNotifs.size();
        int i2 = 0;
        while (i2 < size) {
            StatusBarNotification statusBarNotification = grouplessNotifs.get(i2);
            i2++;
            StatusBarNotification statusBarNotification2 = statusBarNotification;
            Notification.Builder builderRecoverBuilder = Notification.Builder.recoverBuilder(context, statusBarNotification2.getNotification());
            k.d(builderRecoverBuilder, "recoverBuilder(context, …uplessNotif.notification)");
            Notification notificationBuild = builderRecoverBuilder.setGroup(GROUPLESS_SUMMARY_KEY).setOnlyAlertOnce(true).build();
            k.d(notificationBuild, "grouplessNotifBuilder\n  …                 .build()");
            k.b(context);
            NotificationManagerCompat.from(context).notify(statusBarNotification2.getId(), notificationBuild);
        }
    }

    public final NotificationClickEvent generateNotificationOpenedResult$com_onesignal_notifications(JSONArray jsonArray, ITime time) {
        k.e(jsonArray, "jsonArray");
        k.e(time, "time");
        int length = jsonArray.length();
        int iOptInt = jsonArray.optJSONObject(0).optInt(NotificationConstants.BUNDLE_KEY_ANDROID_NOTIFICATION_ID);
        ArrayList arrayList = new ArrayList();
        boolean z2 = true;
        JSONObject jSONObject = null;
        String strOptString = null;
        for (int i2 = 0; i2 < length; i2++) {
            try {
                jSONObject = jsonArray.getJSONObject(i2);
                if (strOptString == null && jSONObject.has(NotificationConstants.GENERATE_NOTIFICATION_BUNDLE_KEY_ACTION_ID)) {
                    strOptString = jSONObject.optString(NotificationConstants.GENERATE_NOTIFICATION_BUNDLE_KEY_ACTION_ID, null);
                }
                if (z2) {
                    z2 = false;
                } else {
                    arrayList.add(new com.onesignal.notifications.internal.Notification(jSONObject, time));
                }
            } catch (Throwable th) {
                Logging.error("Error parsing JSON item " + i2 + '/' + length + " for callback.", th);
            }
        }
        k.b(jSONObject);
        com.onesignal.notifications.internal.Notification notification = new com.onesignal.notifications.internal.Notification(arrayList, jSONObject, iOptInt, time);
        return new NotificationClickEvent(notification, new NotificationClickResult(strOptString, notification.getLaunchURL()));
    }

    @RequiresApi(api = 23)
    public final ArrayList<StatusBarNotification> getActiveGrouplessNotifications(Context context) {
        k.e(context, "context");
        ArrayList<StatusBarNotification> arrayList = new ArrayList<>();
        for (StatusBarNotification statusBarNotification : getActiveNotifications(context)) {
            Notification notification = statusBarNotification.getNotification();
            boolean zIsGroupSummary = isGroupSummary(statusBarNotification);
            boolean z2 = notification.getGroup() == null || k.a(notification.getGroup(), GROUPLESS_SUMMARY_KEY);
            if (!zIsGroupSummary && z2) {
                arrayList.add(statusBarNotification);
            }
        }
        return arrayList;
    }

    @RequiresApi(api = 23)
    public final StatusBarNotification[] getActiveNotifications(Context context) {
        k.e(context, "context");
        StatusBarNotification[] statusBarNotificationArr = new StatusBarNotification[0];
        try {
            StatusBarNotification[] activeNotifications = getNotificationManager(context).getActiveNotifications();
            k.d(activeNotifications, "getNotificationManager(c…text).activeNotifications");
            return activeNotifications;
        } catch (Throwable unused) {
            return statusBarNotificationArr;
        }
    }

    public final String getCampaignNameFromNotification(INotification notification) {
        String templateId;
        k.e(notification, "notification");
        String templateName = notification.getTemplateName();
        if ((templateName == null || templateName.length() != 0) && ((templateId = notification.getTemplateId()) == null || templateId.length() != 0)) {
            return notification.getTemplateName() + " - " + notification.getTemplateId();
        }
        if (notification.getTitle() == null) {
            return "";
        }
        String title = notification.getTitle();
        k.b(title);
        String title2 = notification.getTitle();
        k.b(title2);
        String strSubstring = title.substring(0, Math.min(10, title2.length()));
        k.d(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public final JSONObject getCustomJSONObject(JSONObject jsonObject) throws JSONException {
        k.e(jsonObject, "jsonObject");
        return new JSONObject(jsonObject.optString(NotificationFormatHelper.PAYLOAD_OS_ROOT_CUSTOM));
    }

    @RequiresApi(api = 23)
    public final int getGrouplessNotifsCount(Context context) {
        k.e(context, "context");
        int i2 = 0;
        for (StatusBarNotification statusBarNotification : getActiveNotifications(context)) {
            if (!NotificationCompat.isGroupSummary(statusBarNotification.getNotification()) && GROUPLESS_SUMMARY_KEY.equals(statusBarNotification.getNotification().getGroup())) {
                i2++;
            }
        }
        return i2;
    }

    public final String getNotificationIdFromFCMJson(JSONObject jSONObject) {
        JSONObject jSONObject2;
        if (jSONObject == null) {
            return null;
        }
        try {
            jSONObject2 = new JSONObject(jSONObject.getString(NotificationFormatHelper.PAYLOAD_OS_ROOT_CUSTOM));
        } catch (JSONException unused) {
            Logging.debug$default("Not a OneSignal formatted FCM message. No 'custom' field in the JSONObject.", null, 2, null);
        }
        if (jSONObject2.has("i")) {
            return jSONObject2.optString("i", null);
        }
        Logging.debug$default("Not a OneSignal formatted FCM message. No 'i' field in custom.", null, 2, null);
        return null;
    }

    public final NotificationManager getNotificationManager(Context context) {
        k.e(context, "context");
        Object systemService = context.getSystemService(OneSignalDbContract.NotificationTable.TABLE_NAME);
        k.c(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
        return (NotificationManager) systemService;
    }

    public final Uri getSoundUri(Context context, String str) {
        int identifier;
        k.e(context, "context");
        Resources resources = context.getResources();
        String packageName = context.getPackageName();
        if (AndroidUtils.INSTANCE.isValidResourceName(str) && (identifier = resources.getIdentifier(str, "raw", packageName)) != 0) {
            return Uri.parse("android.resource://" + packageName + '/' + identifier);
        }
        int identifier2 = resources.getIdentifier("onesignal_default_sound", "raw", packageName);
        if (identifier2 == 0) {
            return null;
        }
        return Uri.parse("android.resource://" + packageName + '/' + identifier2);
    }

    public final boolean isGroupSummary(StatusBarNotification notif) {
        k.e(notif, "notif");
        return (notif.getNotification().flags & 512) != 0;
    }

    public final long[] parseVibrationPattern(JSONObject fcmBundle) {
        JSONArray jSONArray;
        k.e(fcmBundle, "fcmBundle");
        try {
            Object objOpt = fcmBundle.opt("vib_pt");
            if (objOpt instanceof String) {
                jSONArray = new JSONArray((String) objOpt);
            } else {
                k.c(objOpt, "null cannot be cast to non-null type org.json.JSONArray");
                jSONArray = (JSONArray) objOpt;
            }
            long[] jArr = new long[jSONArray.length()];
            int length = jSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                jArr[i2] = jSONArray.optLong(i2);
            }
            return jArr;
        } catch (JSONException unused) {
            return null;
        }
    }
}
