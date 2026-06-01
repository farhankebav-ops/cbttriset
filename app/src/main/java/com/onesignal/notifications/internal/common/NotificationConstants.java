package com.onesignal.notifications.internal.common;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class NotificationConstants {
    public static final String BUNDLE_KEY_ANDROID_NOTIFICATION_ID = "androidNotificationId";
    public static final String BUNDLE_KEY_ONESIGNAL_DATA = "onesignalData";
    public static final int DEFAULT_TTL_IF_NOT_IN_PAYLOAD = 259200;
    public static final String EXTENSION_SERVICE_META_DATA_TAG_NAME = "com.onesignal.NotificationServiceExtension";
    public static final String GENERATE_NOTIFICATION_BUNDLE_KEY_ACTION_ID = "actionId";
    public static final String GOOGLE_SENT_TIME_KEY = "google.sent_time";
    public static final String GOOGLE_TTL_KEY = "google.ttl";
    public static final String HMS_SENT_TIME_KEY = "hms.sent_time";
    public static final String HMS_TTL_KEY = "hms.ttl";
    public static final String IAM_PREVIEW_KEY = "os_in_app_message_preview_id";
    public static final NotificationConstants INSTANCE = new NotificationConstants();
    public static final String PUSH_ADDITIONAL_DATA_KEY = "a";

    private NotificationConstants() {
    }
}
