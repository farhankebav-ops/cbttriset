package com.onesignal.core.internal.application;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public enum AppEntryAction {
    NOTIFICATION_CLICK,
    APP_OPEN,
    APP_CLOSE;

    public final boolean isAppClose() {
        return this == APP_CLOSE;
    }

    public final boolean isAppOpen() {
        return this == APP_OPEN;
    }

    public final boolean isNotificationClick() {
        return this == NOTIFICATION_CLICK;
    }
}
