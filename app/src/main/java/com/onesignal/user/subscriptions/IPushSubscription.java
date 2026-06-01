package com.onesignal.user.subscriptions;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public interface IPushSubscription extends ISubscription {
    void addObserver(IPushSubscriptionObserver iPushSubscriptionObserver);

    boolean getOptedIn();

    String getToken();

    void optIn();

    void optOut();

    void removeObserver(IPushSubscriptionObserver iPushSubscriptionObserver);
}
