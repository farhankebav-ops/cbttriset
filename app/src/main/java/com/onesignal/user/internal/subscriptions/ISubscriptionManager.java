package com.onesignal.user.internal.subscriptions;

import com.onesignal.common.events.IEventNotifier;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public interface ISubscriptionManager extends IEventNotifier<ISubscriptionChangedHandler> {
    void addEmailSubscription(String str);

    void addOrUpdatePushSubscriptionToken(String str, SubscriptionStatus subscriptionStatus);

    void addSmsSubscription(String str);

    SubscriptionModel getPushSubscriptionModel();

    SubscriptionList getSubscriptions();

    void removeEmailSubscription(String str);

    void removeSmsSubscription(String str);

    void setSubscriptions(SubscriptionList subscriptionList);
}
