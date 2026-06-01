package com.onesignal.user.internal;

import com.onesignal.user.internal.subscriptions.SubscriptionModel;
import com.onesignal.user.subscriptions.ISmsSubscription;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class SmsSubscription extends Subscription implements ISmsSubscription {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SmsSubscription(SubscriptionModel model) {
        super(model);
        k.e(model, "model");
    }

    @Override // com.onesignal.user.subscriptions.ISmsSubscription
    public String getNumber() {
        return getModel().getAddress();
    }
}
