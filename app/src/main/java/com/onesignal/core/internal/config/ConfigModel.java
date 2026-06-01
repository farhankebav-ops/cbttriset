package com.onesignal.core.internal.config;

import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.onesignal.common.modeling.Model;
import e6.a;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.l;
import okhttp3.internal.url._UrlKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class ConfigModel extends Model {

    /* JADX INFO: renamed from: com.onesignal.core.internal.config.ConfigModel$isInitializedWithRemote$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class AnonymousClass2 extends l implements a {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        public AnonymousClass2() {
            super(0);
        }

        @Override // e6.a
        public final Boolean invoke() {
            return Boolean.FALSE;
        }
    }

    public ConfigModel() {
        super(null, null, 3, null);
    }

    @Override // com.onesignal.common.modeling.Model
    public Model createModelForProperty(String property, JSONObject jsonObject) {
        k.e(property, "property");
        k.e(jsonObject, "jsonObject");
        if (property.equals("influenceParams")) {
            InfluenceConfigModel influenceConfigModel = new InfluenceConfigModel(this, "influenceParams");
            influenceConfigModel.initializeFromJson(jsonObject);
            return influenceConfigModel;
        }
        if (!property.equals("fcmParams")) {
            return null;
        }
        FCMConfigModel fCMConfigModel = new FCMConfigModel(this, "influenceParams");
        fCMConfigModel.initializeFromJson(jsonObject);
        return fCMConfigModel;
    }

    public final String getApiUrl() {
        return getStringProperty("apiUrl", ConfigModel$apiUrl$2.INSTANCE);
    }

    public final String getAppId() {
        return Model.getStringProperty$default(this, RemoteConfigConstants.RequestFieldKey.APP_ID, null, 2, null);
    }

    public final long getBackgroundFetchNotificationPermissionInterval() {
        return getLongProperty("backgroundFetchNotificationPermissionInterval", ConfigModel$backgroundFetchNotificationPermissionInterval$2.INSTANCE);
    }

    public final boolean getClearGroupOnSummaryClick() {
        return getBooleanProperty("clearGroupOnSummaryClick", ConfigModel$clearGroupOnSummaryClick$2.INSTANCE);
    }

    public final Boolean getConsentGiven() {
        return Model.getOptBooleanProperty$default(this, "consentGiven", null, 2, null);
    }

    public final Boolean getConsentRequired() {
        return Model.getOptBooleanProperty$default(this, "consentRequired", null, 2, null);
    }

    public final boolean getDisableGMSMissingPrompt() {
        return getBooleanProperty("disableGMSMissingPrompt", ConfigModel$disableGMSMissingPrompt$2.INSTANCE);
    }

    public final boolean getEnterprise() {
        return getBooleanProperty("enterprise", ConfigModel$enterprise$2.INSTANCE);
    }

    public final FCMConfigModel getFcmParams() {
        Object anyProperty = getAnyProperty("fcmParams", new ConfigModel$fcmParams$2(this));
        k.c(anyProperty, "null cannot be cast to non-null type com.onesignal.core.internal.config.FCMConfigModel");
        return (FCMConfigModel) anyProperty;
    }

    public final long getFetchIAMMinInterval() {
        return getLongProperty("fetchIAMMinInterval", ConfigModel$fetchIAMMinInterval$2.INSTANCE);
    }

    public final boolean getFirebaseAnalytics() {
        return getBooleanProperty("firebaseAnalytics", ConfigModel$firebaseAnalytics$2.INSTANCE);
    }

    public final long getForegroundFetchNotificationPermissionInterval() {
        return getLongProperty("foregroundFetchNotificationPermissionInterval", ConfigModel$foregroundFetchNotificationPermissionInterval$2.INSTANCE);
    }

    public final String getGoogleProjectNumber() {
        return Model.getOptStringProperty$default(this, "googleProjectNumber", null, 2, null);
    }

    public final int getHttpGetTimeout() {
        return getIntProperty("httpGetTimeout", ConfigModel$httpGetTimeout$2.INSTANCE);
    }

    public final int getHttpRetryAfterParseFailFallback() {
        return getIntProperty("httpRetryAfterParseFailFallback", ConfigModel$httpRetryAfterParseFailFallback$2.INSTANCE);
    }

    public final int getHttpTimeout() {
        return getIntProperty("httpTimeout", ConfigModel$httpTimeout$2.INSTANCE);
    }

    public final InfluenceConfigModel getInfluenceParams() {
        Object anyProperty = getAnyProperty("influenceParams", new ConfigModel$influenceParams$2(this));
        k.c(anyProperty, "null cannot be cast to non-null type com.onesignal.core.internal.config.InfluenceConfigModel");
        return (InfluenceConfigModel) anyProperty;
    }

    public final boolean getLocationShared() {
        return getBooleanProperty("locationShared", ConfigModel$locationShared$2.INSTANCE);
    }

    public final JSONArray getNotificationChannels() {
        String optStringProperty = getOptStringProperty("notificationChannels", ConfigModel$notificationChannels$2.INSTANCE);
        if (optStringProperty == null) {
            optStringProperty = _UrlKt.PATH_SEGMENT_ENCODE_SET_URI;
        }
        return new JSONArray(optStringProperty);
    }

    public final long getOpRepoDefaultFailRetryBackoff() {
        return getLongProperty("opRepoDefaultFailRetryBackoff", ConfigModel$opRepoDefaultFailRetryBackoff$2.INSTANCE);
    }

    public final long getOpRepoExecutionInterval() {
        return getLongProperty("opRepoExecutionInterval", ConfigModel$opRepoExecutionInterval$2.INSTANCE);
    }

    public final long getOpRepoPostCreateDelay() {
        return getLongProperty("opRepoPostCreateDelay", ConfigModel$opRepoPostCreateDelay$2.INSTANCE);
    }

    public final long getOpRepoPostCreateRetryUpTo() {
        return getLongProperty("opRepoPostCreateRetryUpTo", ConfigModel$opRepoPostCreateRetryUpTo$2.INSTANCE);
    }

    public final long getOpRepoPostWakeDelay() {
        return getLongProperty("opRepoPostWakeDelay", ConfigModel$opRepoPostWakeDelay$2.INSTANCE);
    }

    public final String getPushSubscriptionId() {
        return Model.getOptStringProperty$default(this, "pushSubscriptionId", null, 2, null);
    }

    public final boolean getReceiveReceiptEnabled() {
        return getBooleanProperty("receiveReceiptEnabled", ConfigModel$receiveReceiptEnabled$2.INSTANCE);
    }

    public final boolean getRestoreTTLFilter() {
        return getBooleanProperty("restoreTTLFilter", ConfigModel$restoreTTLFilter$2.INSTANCE);
    }

    public final long getSessionFocusTimeout() {
        return getLongProperty("sessionFocusTimeout", ConfigModel$sessionFocusTimeout$2.INSTANCE);
    }

    public final boolean getUnsubscribeWhenNotificationsDisabled() {
        return getBooleanProperty("unsubscribeWhenNotificationsDisabled", ConfigModel$unsubscribeWhenNotificationsDisabled$2.INSTANCE);
    }

    public final boolean getUseIdentityVerification() {
        return getBooleanProperty("useIdentityVerification", ConfigModel$useIdentityVerification$2.INSTANCE);
    }

    public final boolean getUserRejectedGMSUpdate() {
        return getBooleanProperty("userRejectedGMSUpdate", ConfigModel$userRejectedGMSUpdate$2.INSTANCE);
    }

    public final boolean isInitializedWithRemote() {
        return getBooleanProperty("isInitializedWithRemote", AnonymousClass2.INSTANCE);
    }

    public final void setApiUrl(String value) {
        k.e(value, "value");
        Model.setStringProperty$default(this, "apiUrl", value, null, false, 12, null);
    }

    public final void setAppId(String value) {
        k.e(value, "value");
        Model.setStringProperty$default(this, RemoteConfigConstants.RequestFieldKey.APP_ID, value, null, false, 12, null);
    }

    public final void setBackgroundFetchNotificationPermissionInterval(long j) {
        Model.setLongProperty$default(this, "backgroundFetchNotificationPermissionInterval", j, null, false, 12, null);
    }

    public final void setClearGroupOnSummaryClick(boolean z2) {
        Model.setBooleanProperty$default(this, "clearGroupOnSummaryClick", z2, null, false, 12, null);
    }

    public final void setConsentGiven(Boolean bool) {
        Model.setOptBooleanProperty$default(this, "consentGiven", bool, null, false, 12, null);
    }

    public final void setConsentRequired(Boolean bool) {
        Model.setOptBooleanProperty$default(this, "consentRequired", bool, null, false, 12, null);
    }

    public final void setDisableGMSMissingPrompt(boolean z2) {
        Model.setBooleanProperty$default(this, "disableGMSMissingPrompt", z2, null, false, 12, null);
    }

    public final void setEnterprise(boolean z2) {
        Model.setBooleanProperty$default(this, "enterprise", z2, null, false, 12, null);
    }

    public final void setFetchIAMMinInterval(long j) {
        Model.setLongProperty$default(this, "fetchIAMMinInterval", j, null, false, 12, null);
    }

    public final void setFirebaseAnalytics(boolean z2) {
        Model.setBooleanProperty$default(this, "firebaseAnalytics", z2, null, false, 12, null);
    }

    public final void setForegroundFetchNotificationPermissionInterval(long j) {
        Model.setLongProperty$default(this, "foregroundFetchNotificationPermissionInterval", j, null, false, 12, null);
    }

    public final void setGoogleProjectNumber(String str) {
        Model.setOptStringProperty$default(this, "googleProjectNumber", str, null, false, 12, null);
    }

    public final void setHttpGetTimeout(int i2) {
        Model.setIntProperty$default(this, "httpGetTimeout", i2, null, false, 12, null);
    }

    public final void setHttpRetryAfterParseFailFallback(int i2) {
        Model.setIntProperty$default(this, "httpRetryAfterParseFailFallback", i2, null, false, 12, null);
    }

    public final void setHttpTimeout(int i2) {
        Model.setIntProperty$default(this, "httpTimeout", i2, null, false, 12, null);
    }

    public final void setInitializedWithRemote(boolean z2) {
        Model.setBooleanProperty$default(this, "isInitializedWithRemote", z2, null, false, 12, null);
    }

    public final void setLocationShared(boolean z2) {
        Model.setBooleanProperty$default(this, "locationShared", z2, null, false, 12, null);
    }

    public final void setNotificationChannels(JSONArray jSONArray) {
        Model.setOptStringProperty$default(this, "notificationChannels", jSONArray != null ? jSONArray.toString() : null, null, false, 12, null);
    }

    public final void setOpRepoDefaultFailRetryBackoff(long j) {
        Model.setLongProperty$default(this, "opRepoDefaultFailRetryBackoff", j, null, false, 12, null);
    }

    public final void setOpRepoExecutionInterval(long j) {
        Model.setLongProperty$default(this, "opRepoExecutionInterval", j, null, false, 12, null);
    }

    public final void setOpRepoPostCreateDelay(long j) {
        Model.setLongProperty$default(this, "opRepoPostCreateDelay", j, null, false, 12, null);
    }

    public final void setOpRepoPostCreateRetryUpTo(long j) {
        Model.setLongProperty$default(this, "opRepoPostCreateRetryUpTo", j, null, false, 12, null);
    }

    public final void setOpRepoPostWakeDelay(long j) {
        Model.setLongProperty$default(this, "opRepoPostWakeDelay", j, null, false, 12, null);
    }

    public final void setPushSubscriptionId(String str) {
        Model.setOptStringProperty$default(this, "pushSubscriptionId", str, null, false, 12, null);
    }

    public final void setReceiveReceiptEnabled(boolean z2) {
        Model.setBooleanProperty$default(this, "receiveReceiptEnabled", z2, null, false, 12, null);
    }

    public final void setRestoreTTLFilter(boolean z2) {
        Model.setBooleanProperty$default(this, "restoreTTLFilter", z2, null, false, 12, null);
    }

    public final void setSessionFocusTimeout(long j) {
        Model.setLongProperty$default(this, "sessionFocusTimeout", j, null, false, 12, null);
    }

    public final void setUnsubscribeWhenNotificationsDisabled(boolean z2) {
        Model.setBooleanProperty$default(this, "unsubscribeWhenNotificationsDisabled", z2, null, false, 12, null);
    }

    public final void setUseIdentityVerification(boolean z2) {
        Model.setBooleanProperty$default(this, "useIdentityVerification", z2, null, false, 12, null);
    }

    public final void setUserRejectedGMSUpdate(boolean z2) {
        Model.setBooleanProperty$default(this, "userRejectedGMSUpdate", z2, null, false, 12, null);
    }
}
