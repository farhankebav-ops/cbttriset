package com.onesignal.notifications.internal;

import android.content.Context;
import com.onesignal.debug.internal.logging.Logging;
import com.onesignal.notifications.INotificationReceivedEvent;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class NotificationReceivedEvent implements INotificationReceivedEvent {
    private final Context context;
    private boolean discard;
    private boolean isPreventDefault;
    private final Notification notification;

    public NotificationReceivedEvent(Context context, Notification notification) {
        k.e(context, "context");
        k.e(notification, "notification");
        this.context = context;
        this.notification = notification;
    }

    @Override // com.onesignal.notifications.INotificationReceivedEvent
    public Context getContext() {
        return this.context;
    }

    public final boolean getDiscard() {
        return this.discard;
    }

    public final boolean isPreventDefault() {
        return this.isPreventDefault;
    }

    @Override // com.onesignal.notifications.INotificationReceivedEvent
    public void preventDefault() {
        preventDefault(false);
    }

    public final void setDiscard(boolean z2) {
        this.discard = z2;
    }

    public final void setPreventDefault(boolean z2) {
        this.isPreventDefault = z2;
    }

    @Override // com.onesignal.notifications.INotificationReceivedEvent
    public Notification getNotification() {
        return this.notification;
    }

    @Override // com.onesignal.notifications.INotificationReceivedEvent
    public void preventDefault(boolean z2) {
        Logging.debug$default("NotificationReceivedEvent.preventDefault(" + z2 + ')', null, 2, null);
        if (this.isPreventDefault && z2) {
            getNotification().getDisplayWaiter().wake(Boolean.FALSE);
        }
        this.isPreventDefault = true;
        this.discard = z2;
    }
}
