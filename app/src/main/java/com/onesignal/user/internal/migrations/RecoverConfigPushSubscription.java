package com.onesignal.user.internal.migrations;

import com.onesignal.core.internal.config.ConfigModel;
import com.onesignal.core.internal.config.ConfigModelStore;
import com.onesignal.user.internal.subscriptions.SubscriptionModel;
import com.onesignal.user.internal.subscriptions.SubscriptionModelStore;
import kotlin.jvm.internal.k;
import n7.b;
import q5.f;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class RecoverConfigPushSubscription extends MigrationRecovery {
    private final ConfigModelStore _configModelStore;
    private final SubscriptionModelStore _subscriptionModelStore;
    private final f activePushSubscription$delegate;

    public RecoverConfigPushSubscription(ConfigModelStore _configModelStore, SubscriptionModelStore _subscriptionModelStore) {
        k.e(_configModelStore, "_configModelStore");
        k.e(_subscriptionModelStore, "_subscriptionModelStore");
        this._configModelStore = _configModelStore;
        this._subscriptionModelStore = _subscriptionModelStore;
        this.activePushSubscription$delegate = b.C(new RecoverConfigPushSubscription$activePushSubscription$2(this));
    }

    public final SubscriptionModel getActivePushSubscription() {
        return (SubscriptionModel) this.activePushSubscription$delegate.getValue();
    }

    @Override // com.onesignal.user.internal.migrations.IMigrationRecovery
    public boolean isInBadState() {
        return this._configModelStore.getModel().getPushSubscriptionId() == null && getActivePushSubscription() != null;
    }

    @Override // com.onesignal.user.internal.migrations.IMigrationRecovery
    public void recover() {
        ConfigModel model = this._configModelStore.getModel();
        SubscriptionModel activePushSubscription = getActivePushSubscription();
        model.setPushSubscriptionId(activePushSubscription != null ? activePushSubscription.getId() : null);
    }

    @Override // com.onesignal.user.internal.migrations.IMigrationRecovery
    public String recoveryMessage() {
        return "Recovering missing push subscription ID in the config model store.";
    }
}
