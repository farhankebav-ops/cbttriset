package com.onesignal.notifications.internal.lifecycle;

import android.app.Activity;
import com.onesignal.notifications.INotificationClickListener;
import com.onesignal.notifications.INotificationLifecycleListener;
import com.onesignal.notifications.INotificationReceivedEvent;
import com.onesignal.notifications.INotificationWillDisplayEvent;
import com.onesignal.notifications.internal.common.NotificationGenerationJob;
import org.json.JSONArray;
import org.json.JSONObject;
import q5.x;
import v5.c;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public interface INotificationLifecycleService {
    void addExternalClickListener(INotificationClickListener iNotificationClickListener);

    void addExternalForegroundLifecycleListener(INotificationLifecycleListener iNotificationLifecycleListener);

    Object canOpenNotification(Activity activity, JSONObject jSONObject, c<? super Boolean> cVar);

    Object canReceiveNotification(JSONObject jSONObject, c<? super Boolean> cVar);

    void externalNotificationWillShowInForeground(INotificationWillDisplayEvent iNotificationWillDisplayEvent);

    void externalRemoteNotificationReceived(INotificationReceivedEvent iNotificationReceivedEvent);

    Object notificationOpened(Activity activity, JSONArray jSONArray, c<? super x> cVar);

    Object notificationReceived(NotificationGenerationJob notificationGenerationJob, c<? super x> cVar);

    void removeExternalClickListener(INotificationClickListener iNotificationClickListener);

    void removeExternalForegroundLifecycleListener(INotificationLifecycleListener iNotificationLifecycleListener);

    void setInternalNotificationLifecycleCallback(INotificationLifecycleCallback iNotificationLifecycleCallback);
}
