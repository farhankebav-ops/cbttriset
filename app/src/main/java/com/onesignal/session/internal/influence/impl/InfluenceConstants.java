package com.onesignal.session.internal.influence.impl;

import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class InfluenceConstants {
    public static final String DIRECT_TAG = "direct";
    public static final String IAM_ID_TAG = "iam_id";
    private static final String IAM_TAG;
    public static final InfluenceConstants INSTANCE = new InfluenceConstants();
    public static final String NOTIFICATIONS_IDS = "notification_ids";
    public static final String NOTIFICATION_ID_TAG = "notification_id";
    private static final String NOTIFICATION_TAG;
    public static final String PREFS_OS_LAST_ATTRIBUTED_NOTIFICATION_OPEN = "PREFS_OS_LAST_ATTRIBUTED_NOTIFICATION_OPEN";
    public static final String PREFS_OS_LAST_IAMS_RECEIVED = "PREFS_OS_LAST_IAMS_RECEIVED";
    public static final String PREFS_OS_LAST_NOTIFICATIONS_RECEIVED = "PREFS_OS_LAST_NOTIFICATIONS_RECEIVED";
    public static final String PREFS_OS_OUTCOMES_CURRENT_IAM_INFLUENCE = "PREFS_OS_OUTCOMES_CURRENT_IAM_INFLUENCE";
    public static final String PREFS_OS_OUTCOMES_CURRENT_NOTIFICATION_INFLUENCE = "PREFS_OS_OUTCOMES_CURRENT_SESSION";
    public static final String TIME = "time";

    static {
        String canonicalName = InAppMessageTracker.class.getCanonicalName();
        k.c(canonicalName, "null cannot be cast to non-null type kotlin.String");
        IAM_TAG = canonicalName;
        String canonicalName2 = NotificationTracker.class.getCanonicalName();
        k.c(canonicalName2, "null cannot be cast to non-null type kotlin.String");
        NOTIFICATION_TAG = canonicalName2;
    }

    private InfluenceConstants() {
    }

    public final String getIAM_TAG() {
        return IAM_TAG;
    }

    public final String getNOTIFICATION_TAG() {
        return NOTIFICATION_TAG;
    }
}
