package com.onesignal.user.internal;

import com.onesignal.common.IDManager;
import com.onesignal.user.internal.subscriptions.SubscriptionModel;
import com.onesignal.user.subscriptions.ISubscription;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class Subscription implements ISubscription {
    private final SubscriptionModel model;

    public Subscription(SubscriptionModel model) {
        k.e(model, "model");
        this.model = model;
    }

    @Override // com.onesignal.user.subscriptions.ISubscription
    public String getId() {
        return IDManager.INSTANCE.isLocalId(this.model.getId()) ? "" : this.model.getId();
    }

    public final SubscriptionModel getModel() {
        return this.model;
    }
}
