package com.onesignal.notifications.internal.analytics.impl;

import com.onesignal.notifications.internal.analytics.IAnalyticsTracker;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class NoAnalyticsTracker implements IAnalyticsTracker {
    @Override // com.onesignal.notifications.internal.analytics.IAnalyticsTracker
    public void trackOpenedEvent(String notificationId, String campaign) {
        k.e(notificationId, "notificationId");
        k.e(campaign, "campaign");
    }

    @Override // com.onesignal.notifications.internal.analytics.IAnalyticsTracker
    public void trackReceivedEvent(String notificationId, String campaign) {
        k.e(notificationId, "notificationId");
        k.e(campaign, "campaign");
    }

    @Override // com.onesignal.notifications.internal.analytics.IAnalyticsTracker
    public void trackInfluenceOpenEvent() {
    }
}
