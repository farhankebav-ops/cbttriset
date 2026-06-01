package com.onesignal.user.internal.subscriptions;

import com.ironsource.C2253bb;
import com.ironsource.Q6;
import com.onesignal.common.modeling.Model;
import com.onesignal.common.modeling.ModelChangeTags;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class SubscriptionModel extends Model {
    public SubscriptionModel() {
        super(null, null, 3, null);
    }

    public final String getAddress() {
        return Model.getStringProperty$default(this, "address", null, 2, null);
    }

    public final String getAppVersion() {
        return getStringProperty("appVersion", SubscriptionModel$appVersion$2.INSTANCE);
    }

    public final String getCarrier() {
        return getStringProperty(Q6.P0, SubscriptionModel$carrier$2.INSTANCE);
    }

    public final String getDeviceOS() {
        return getStringProperty(C2253bb.f8071o, SubscriptionModel$deviceOS$2.INSTANCE);
    }

    public final boolean getOptedIn() {
        return Model.getBooleanProperty$default(this, "optedIn", null, 2, null);
    }

    public final String getSdk() {
        return getStringProperty("sdk", SubscriptionModel$sdk$2.INSTANCE);
    }

    public final SubscriptionStatus getStatus() {
        if (!hasProperty("status")) {
            SubscriptionStatus subscriptionStatus = SubscriptionStatus.SUBSCRIBED;
            setOptAnyProperty("status", subscriptionStatus != null ? subscriptionStatus.toString() : null, ModelChangeTags.NORMAL, false);
        }
        Object optAnyProperty$default = Model.getOptAnyProperty$default(this, "status", null, 2, null);
        Enum enumValueOf = optAnyProperty$default != null ? optAnyProperty$default instanceof SubscriptionStatus ? (Enum) optAnyProperty$default : optAnyProperty$default instanceof String ? SubscriptionStatus.valueOf((String) optAnyProperty$default) : (SubscriptionStatus) optAnyProperty$default : null;
        if (enumValueOf != null) {
            return (SubscriptionStatus) enumValueOf;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.onesignal.user.internal.subscriptions.SubscriptionStatus");
    }

    public final SubscriptionType getType() {
        Object optAnyProperty$default = Model.getOptAnyProperty$default(this, "type", null, 2, null);
        Enum enumValueOf = optAnyProperty$default != null ? optAnyProperty$default instanceof SubscriptionType ? (Enum) optAnyProperty$default : optAnyProperty$default instanceof String ? SubscriptionType.valueOf((String) optAnyProperty$default) : (SubscriptionType) optAnyProperty$default : null;
        if (enumValueOf != null) {
            return (SubscriptionType) enumValueOf;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.onesignal.user.internal.subscriptions.SubscriptionType");
    }

    public final void setAddress(String value) {
        k.e(value, "value");
        Model.setStringProperty$default(this, "address", value, null, false, 12, null);
    }

    public final void setAppVersion(String value) {
        k.e(value, "value");
        Model.setStringProperty$default(this, "appVersion", value, null, false, 12, null);
    }

    public final void setCarrier(String value) {
        k.e(value, "value");
        Model.setStringProperty$default(this, Q6.P0, value, null, false, 12, null);
    }

    public final void setDeviceOS(String value) {
        k.e(value, "value");
        Model.setStringProperty$default(this, C2253bb.f8071o, value, null, false, 12, null);
    }

    public final void setOptedIn(boolean z2) {
        Model.setBooleanProperty$default(this, "optedIn", z2, null, false, 12, null);
    }

    public final void setSdk(String value) {
        k.e(value, "value");
        Model.setStringProperty$default(this, "sdk", value, null, false, 12, null);
    }

    public final void setStatus(SubscriptionStatus value) {
        k.e(value, "value");
        setOptAnyProperty("status", value.toString(), ModelChangeTags.NORMAL, false);
    }

    public final void setType(SubscriptionType value) {
        k.e(value, "value");
        setOptAnyProperty("type", value.toString(), ModelChangeTags.NORMAL, false);
    }
}
