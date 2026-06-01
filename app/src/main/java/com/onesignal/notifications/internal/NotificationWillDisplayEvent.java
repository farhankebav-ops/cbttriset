package com.onesignal.notifications.internal;

import com.onesignal.debug.internal.logging.Logging;
import com.onesignal.notifications.INotificationWillDisplayEvent;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class NotificationWillDisplayEvent implements INotificationWillDisplayEvent {
    private boolean discard;
    private boolean isPreventDefault;
    private final Notification notification;

    public NotificationWillDisplayEvent(Notification notification) {
        k.e(notification, "notification");
        this.notification = notification;
    }

    public final boolean getDiscard() {
        return this.discard;
    }

    public final boolean isPreventDefault() {
        return this.isPreventDefault;
    }

    @Override // com.onesignal.notifications.INotificationWillDisplayEvent
    public void preventDefault() {
        preventDefault(false);
    }

    public final void setDiscard(boolean z2) {
        this.discard = z2;
    }

    public final void setPreventDefault(boolean z2) {
        this.isPreventDefault = z2;
    }

    @Override // com.onesignal.notifications.INotificationWillDisplayEvent
    public Notification getNotification() {
        return this.notification;
    }

    @Override // com.onesignal.notifications.INotificationWillDisplayEvent
    public void preventDefault(boolean z2) {
        Logging.debug$default("NotificationWillDisplayEvent.preventDefault(" + z2 + ')', null, 2, null);
        if (this.isPreventDefault && z2) {
            getNotification().getDisplayWaiter().wake(Boolean.FALSE);
        }
        this.isPreventDefault = true;
        this.discard = z2;
    }
}
