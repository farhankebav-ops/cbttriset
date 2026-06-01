package com.onesignal.notifications.internal.data.impl;

import com.onesignal.core.internal.config.ConfigModelStore;
import com.onesignal.core.internal.time.ITime;
import com.onesignal.notifications.internal.data.INotificationQueryHelper;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class NotificationQueryHelper implements INotificationQueryHelper {
    private final ConfigModelStore _configModelStore;
    private final ITime _time;

    public NotificationQueryHelper(ConfigModelStore _configModelStore, ITime _time) {
        k.e(_configModelStore, "_configModelStore");
        k.e(_time, "_time");
        this._configModelStore = _configModelStore;
        this._time = _time;
    }

    @Override // com.onesignal.notifications.internal.data.INotificationQueryHelper
    public StringBuilder recentUninteractedWithNotificationsWhere() {
        long currentTimeMillis = this._time.getCurrentTimeMillis() / 1000;
        StringBuilder sb = new StringBuilder("created_time > " + (currentTimeMillis - 604800) + " AND dismissed = 0 AND opened = 0 AND is_summary = 0");
        if (this._configModelStore.getModel().getRestoreTTLFilter()) {
            sb.append(" AND expire_time > " + currentTimeMillis);
        }
        return sb;
    }
}
