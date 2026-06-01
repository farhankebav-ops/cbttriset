package com.onesignal.core.internal.config;

import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.onesignal.common.modeling.Model;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class FCMConfigModel extends Model {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FCMConfigModel(Model parentModel, String parentProperty) {
        super(parentModel, parentProperty);
        k.e(parentModel, "parentModel");
        k.e(parentProperty, "parentProperty");
    }

    public final String getApiKey() {
        return getOptStringProperty("apiKey", FCMConfigModel$apiKey$2.INSTANCE);
    }

    public final String getAppId() {
        return getOptStringProperty(RemoteConfigConstants.RequestFieldKey.APP_ID, FCMConfigModel$appId$2.INSTANCE);
    }

    public final String getProjectId() {
        return getOptStringProperty("projectId", FCMConfigModel$projectId$2.INSTANCE);
    }

    public final void setApiKey(String str) {
        Model.setOptStringProperty$default(this, "apiKey", str, null, false, 12, null);
    }

    public final void setAppId(String str) {
        Model.setOptStringProperty$default(this, RemoteConfigConstants.RequestFieldKey.APP_ID, str, null, false, 12, null);
    }

    public final void setProjectId(String str) {
        Model.setOptStringProperty$default(this, "projectId", str, null, false, 12, null);
    }
}
