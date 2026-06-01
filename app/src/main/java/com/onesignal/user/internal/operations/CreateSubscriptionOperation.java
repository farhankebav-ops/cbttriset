package com.onesignal.user.internal.operations;

import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.onesignal.common.IDManager;
import com.onesignal.common.modeling.Model;
import com.onesignal.common.modeling.ModelChangeTags;
import com.onesignal.core.internal.operations.GroupComparisonType;
import com.onesignal.core.internal.operations.Operation;
import com.onesignal.user.internal.operations.impl.executors.SubscriptionOperationExecutor;
import com.onesignal.user.internal.subscriptions.SubscriptionStatus;
import com.onesignal.user.internal.subscriptions.SubscriptionType;
import java.util.Map;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class CreateSubscriptionOperation extends Operation {
    private final GroupComparisonType groupComparisonType;

    public CreateSubscriptionOperation() {
        super(SubscriptionOperationExecutor.CREATE_SUBSCRIPTION);
        this.groupComparisonType = GroupComparisonType.ALTER;
    }

    private final void setAddress(String str) {
        Model.setStringProperty$default(this, "address", str, null, false, 12, null);
    }

    private final void setAppId(String str) {
        Model.setStringProperty$default(this, RemoteConfigConstants.RequestFieldKey.APP_ID, str, null, false, 12, null);
    }

    private final void setEnabled(boolean z2) {
        Model.setBooleanProperty$default(this, "enabled", z2, null, false, 12, null);
    }

    private final void setOnesignalId(String str) {
        Model.setStringProperty$default(this, "onesignalId", str, null, false, 12, null);
    }

    private final void setStatus(SubscriptionStatus subscriptionStatus) {
        setOptAnyProperty("status", subscriptionStatus != null ? subscriptionStatus.toString() : null, ModelChangeTags.NORMAL, false);
    }

    private final void setSubscriptionId(String str) {
        Model.setStringProperty$default(this, "subscriptionId", str, null, false, 12, null);
    }

    private final void setType(SubscriptionType subscriptionType) {
        setOptAnyProperty("type", subscriptionType != null ? subscriptionType.toString() : null, ModelChangeTags.NORMAL, false);
    }

    public final String getAddress() {
        return Model.getStringProperty$default(this, "address", null, 2, null);
    }

    public final String getAppId() {
        return Model.getStringProperty$default(this, RemoteConfigConstants.RequestFieldKey.APP_ID, null, 2, null);
    }

    @Override // com.onesignal.core.internal.operations.Operation
    public String getApplyToRecordId() {
        return getOnesignalId();
    }

    @Override // com.onesignal.core.internal.operations.Operation
    public boolean getCanStartExecute() {
        return !IDManager.INSTANCE.isLocalId(getOnesignalId());
    }

    @Override // com.onesignal.core.internal.operations.Operation
    public String getCreateComparisonKey() {
        return getAppId() + ".User." + getOnesignalId();
    }

    public final boolean getEnabled() {
        return Model.getBooleanProperty$default(this, "enabled", null, 2, null);
    }

    @Override // com.onesignal.core.internal.operations.Operation
    public GroupComparisonType getGroupComparisonType() {
        return this.groupComparisonType;
    }

    @Override // com.onesignal.core.internal.operations.Operation
    public String getModifyComparisonKey() {
        return getAppId() + ".User." + getOnesignalId() + ".Subscription." + getSubscriptionId();
    }

    public final String getOnesignalId() {
        return Model.getStringProperty$default(this, "onesignalId", null, 2, null);
    }

    public final SubscriptionStatus getStatus() {
        Object optAnyProperty$default = Model.getOptAnyProperty$default(this, "status", null, 2, null);
        Enum enumValueOf = optAnyProperty$default != null ? optAnyProperty$default instanceof SubscriptionStatus ? (Enum) optAnyProperty$default : optAnyProperty$default instanceof String ? SubscriptionStatus.valueOf((String) optAnyProperty$default) : (SubscriptionStatus) optAnyProperty$default : null;
        if (enumValueOf != null) {
            return (SubscriptionStatus) enumValueOf;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.onesignal.user.internal.subscriptions.SubscriptionStatus");
    }

    public final String getSubscriptionId() {
        return Model.getStringProperty$default(this, "subscriptionId", null, 2, null);
    }

    public final SubscriptionType getType() {
        Object optAnyProperty$default = Model.getOptAnyProperty$default(this, "type", null, 2, null);
        Enum enumValueOf = optAnyProperty$default != null ? optAnyProperty$default instanceof SubscriptionType ? (Enum) optAnyProperty$default : optAnyProperty$default instanceof String ? SubscriptionType.valueOf((String) optAnyProperty$default) : (SubscriptionType) optAnyProperty$default : null;
        if (enumValueOf != null) {
            return (SubscriptionType) enumValueOf;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.onesignal.user.internal.subscriptions.SubscriptionType");
    }

    @Override // com.onesignal.core.internal.operations.Operation
    public void translateIds(Map<String, String> map) {
        k.e(map, "map");
        String str = map.get(getOnesignalId());
        if (str != null) {
            setOnesignalId(str);
        }
        String str2 = map.get(getSubscriptionId());
        if (str2 != null) {
            setSubscriptionId(str2);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CreateSubscriptionOperation(String appId, String onesignalId, String subscriptionId, SubscriptionType type, boolean z2, String address, SubscriptionStatus status) {
        this();
        k.e(appId, "appId");
        k.e(onesignalId, "onesignalId");
        k.e(subscriptionId, "subscriptionId");
        k.e(type, "type");
        k.e(address, "address");
        k.e(status, "status");
        setAppId(appId);
        setOnesignalId(onesignalId);
        setSubscriptionId(subscriptionId);
        setType(type);
        setEnabled(z2);
        setAddress(address);
        setStatus(status);
    }
}
