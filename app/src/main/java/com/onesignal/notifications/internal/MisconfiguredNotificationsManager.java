package com.onesignal.notifications.internal;

import com.onesignal.core.internal.minification.KeepStub;
import com.onesignal.notifications.INotificationClickListener;
import com.onesignal.notifications.INotificationLifecycleListener;
import com.onesignal.notifications.INotificationsManager;
import com.onesignal.notifications.IPermissionObserver;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import v5.c;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
@KeepStub
public final class MisconfiguredNotificationsManager implements INotificationsManager {
    public static final Companion Companion = new Companion(null);

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Exception getEXCEPTION() {
            return new Exception("Must include gradle module com.onesignal:Notification in order to use this functionality!");
        }

        private Companion() {
        }
    }

    @Override // com.onesignal.notifications.INotificationsManager
    /* JADX INFO: renamed from: getCanRequestPermission, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ boolean mo3167getCanRequestPermission() {
        return ((Boolean) getCanRequestPermission()).booleanValue();
    }

    @Override // com.onesignal.notifications.INotificationsManager
    /* JADX INFO: renamed from: getPermission, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ boolean mo3168getPermission() {
        return ((Boolean) getPermission()).booleanValue();
    }

    @Override // com.onesignal.notifications.INotificationsManager
    public Object requestPermission(boolean z2, c<?> cVar) throws Exception {
        throw Companion.getEXCEPTION();
    }

    @Override // com.onesignal.notifications.INotificationsManager
    /* JADX INFO: renamed from: addClickListener, reason: merged with bridge method [inline-methods] */
    public Void mo3163addClickListener(INotificationClickListener listener) throws Exception {
        k.e(listener, "listener");
        throw Companion.getEXCEPTION();
    }

    @Override // com.onesignal.notifications.INotificationsManager
    /* JADX INFO: renamed from: addForegroundLifecycleListener, reason: merged with bridge method [inline-methods] */
    public Void mo3164addForegroundLifecycleListener(INotificationLifecycleListener listener) throws Exception {
        k.e(listener, "listener");
        throw Companion.getEXCEPTION();
    }

    @Override // com.onesignal.notifications.INotificationsManager
    /* JADX INFO: renamed from: addPermissionObserver, reason: merged with bridge method [inline-methods] */
    public Void mo3165addPermissionObserver(IPermissionObserver observer) throws Exception {
        k.e(observer, "observer");
        throw Companion.getEXCEPTION();
    }

    @Override // com.onesignal.notifications.INotificationsManager
    /* JADX INFO: renamed from: clearAllNotifications, reason: merged with bridge method [inline-methods] */
    public Void mo3166clearAllNotifications() throws Exception {
        throw Companion.getEXCEPTION();
    }

    public Void getCanRequestPermission() throws Exception {
        throw Companion.getEXCEPTION();
    }

    public Void getPermission() throws Exception {
        throw Companion.getEXCEPTION();
    }

    @Override // com.onesignal.notifications.INotificationsManager
    /* JADX INFO: renamed from: removeClickListener, reason: merged with bridge method [inline-methods] */
    public Void mo3169removeClickListener(INotificationClickListener listener) throws Exception {
        k.e(listener, "listener");
        throw Companion.getEXCEPTION();
    }

    @Override // com.onesignal.notifications.INotificationsManager
    /* JADX INFO: renamed from: removeForegroundLifecycleListener, reason: merged with bridge method [inline-methods] */
    public Void mo3170removeForegroundLifecycleListener(INotificationLifecycleListener listener) throws Exception {
        k.e(listener, "listener");
        throw Companion.getEXCEPTION();
    }

    @Override // com.onesignal.notifications.INotificationsManager
    /* JADX INFO: renamed from: removeGroupedNotifications, reason: merged with bridge method [inline-methods] */
    public Void mo3171removeGroupedNotifications(String group) throws Exception {
        k.e(group, "group");
        throw Companion.getEXCEPTION();
    }

    @Override // com.onesignal.notifications.INotificationsManager
    /* JADX INFO: renamed from: removeNotification, reason: merged with bridge method [inline-methods] */
    public Void mo3172removeNotification(int i2) throws Exception {
        throw Companion.getEXCEPTION();
    }

    @Override // com.onesignal.notifications.INotificationsManager
    /* JADX INFO: renamed from: removePermissionObserver, reason: merged with bridge method [inline-methods] */
    public Void mo3173removePermissionObserver(IPermissionObserver observer) throws Exception {
        k.e(observer, "observer");
        throw Companion.getEXCEPTION();
    }
}
