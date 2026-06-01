package com.onesignal.notifications;

import v5.c;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public interface INotificationsManager {
    /* JADX INFO: renamed from: addClickListener */
    void mo3163addClickListener(INotificationClickListener iNotificationClickListener);

    /* JADX INFO: renamed from: addForegroundLifecycleListener */
    void mo3164addForegroundLifecycleListener(INotificationLifecycleListener iNotificationLifecycleListener);

    /* JADX INFO: renamed from: addPermissionObserver */
    void mo3165addPermissionObserver(IPermissionObserver iPermissionObserver);

    /* JADX INFO: renamed from: clearAllNotifications */
    void mo3166clearAllNotifications();

    /* JADX INFO: renamed from: getCanRequestPermission */
    boolean mo3167getCanRequestPermission();

    /* JADX INFO: renamed from: getPermission */
    boolean mo3168getPermission();

    /* JADX INFO: renamed from: removeClickListener */
    void mo3169removeClickListener(INotificationClickListener iNotificationClickListener);

    /* JADX INFO: renamed from: removeForegroundLifecycleListener */
    void mo3170removeForegroundLifecycleListener(INotificationLifecycleListener iNotificationLifecycleListener);

    /* JADX INFO: renamed from: removeGroupedNotifications */
    void mo3171removeGroupedNotifications(String str);

    /* JADX INFO: renamed from: removeNotification */
    void mo3172removeNotification(int i2);

    /* JADX INFO: renamed from: removePermissionObserver */
    void mo3173removePermissionObserver(IPermissionObserver iPermissionObserver);

    Object requestPermission(boolean z2, c<? super Boolean> cVar);
}
