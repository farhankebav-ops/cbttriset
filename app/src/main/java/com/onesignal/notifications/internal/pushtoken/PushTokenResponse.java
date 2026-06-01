package com.onesignal.notifications.internal.pushtoken;

import com.onesignal.user.internal.subscriptions.SubscriptionStatus;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class PushTokenResponse {
    private final SubscriptionStatus status;
    private final String token;

    public PushTokenResponse(String str, SubscriptionStatus status) {
        k.e(status, "status");
        this.token = str;
        this.status = status;
    }

    public final SubscriptionStatus getStatus() {
        return this.status;
    }

    public final String getToken() {
        return this.token;
    }
}
