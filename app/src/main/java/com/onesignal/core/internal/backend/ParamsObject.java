package com.onesignal.core.internal.backend;

import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import org.json.JSONArray;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class ParamsObject {
    private Boolean clearGroupOnSummaryClick;
    private Boolean disableGMSMissingPrompt;
    private Boolean enterprise;
    private FCMParamsObject fcmParams;
    private Boolean firebaseAnalytics;
    private String googleProjectNumber;
    private InfluenceParamsObject influenceParams;
    private Boolean locationShared;
    private JSONArray notificationChannels;
    private Long opRepoExecutionInterval;
    private Boolean receiveReceiptEnabled;
    private Boolean requiresUserPrivacyConsent;
    private Boolean restoreTTLFilter;
    private Boolean unsubscribeWhenNotificationsDisabled;
    private Boolean useIdentityVerification;

    public ParamsObject(String str, Boolean bool, Boolean bool2, JSONArray jSONArray, Boolean bool3, Boolean bool4, Boolean bool5, Boolean bool6, Boolean bool7, Boolean bool8, Boolean bool9, Boolean bool10, Long l, InfluenceParamsObject influenceParams, FCMParamsObject fcmParams) {
        k.e(influenceParams, "influenceParams");
        k.e(fcmParams, "fcmParams");
        this.googleProjectNumber = str;
        this.enterprise = bool;
        this.useIdentityVerification = bool2;
        this.notificationChannels = jSONArray;
        this.firebaseAnalytics = bool3;
        this.restoreTTLFilter = bool4;
        this.clearGroupOnSummaryClick = bool5;
        this.receiveReceiptEnabled = bool6;
        this.disableGMSMissingPrompt = bool7;
        this.unsubscribeWhenNotificationsDisabled = bool8;
        this.locationShared = bool9;
        this.requiresUserPrivacyConsent = bool10;
        this.opRepoExecutionInterval = l;
        this.influenceParams = influenceParams;
        this.fcmParams = fcmParams;
    }

    public final Boolean getClearGroupOnSummaryClick() {
        return this.clearGroupOnSummaryClick;
    }

    public final Boolean getDisableGMSMissingPrompt() {
        return this.disableGMSMissingPrompt;
    }

    public final Boolean getEnterprise() {
        return this.enterprise;
    }

    public final FCMParamsObject getFcmParams() {
        return this.fcmParams;
    }

    public final Boolean getFirebaseAnalytics() {
        return this.firebaseAnalytics;
    }

    public final String getGoogleProjectNumber() {
        return this.googleProjectNumber;
    }

    public final InfluenceParamsObject getInfluenceParams() {
        return this.influenceParams;
    }

    public final Boolean getLocationShared() {
        return this.locationShared;
    }

    public final JSONArray getNotificationChannels() {
        return this.notificationChannels;
    }

    public final Long getOpRepoExecutionInterval() {
        return this.opRepoExecutionInterval;
    }

    public final Boolean getReceiveReceiptEnabled() {
        return this.receiveReceiptEnabled;
    }

    public final Boolean getRequiresUserPrivacyConsent() {
        return this.requiresUserPrivacyConsent;
    }

    public final Boolean getRestoreTTLFilter() {
        return this.restoreTTLFilter;
    }

    public final Boolean getUnsubscribeWhenNotificationsDisabled() {
        return this.unsubscribeWhenNotificationsDisabled;
    }

    public final Boolean getUseIdentityVerification() {
        return this.useIdentityVerification;
    }

    public final void setClearGroupOnSummaryClick(Boolean bool) {
        this.clearGroupOnSummaryClick = bool;
    }

    public final void setDisableGMSMissingPrompt(Boolean bool) {
        this.disableGMSMissingPrompt = bool;
    }

    public final void setEnterprise(Boolean bool) {
        this.enterprise = bool;
    }

    public final void setFcmParams(FCMParamsObject fCMParamsObject) {
        k.e(fCMParamsObject, "<set-?>");
        this.fcmParams = fCMParamsObject;
    }

    public final void setFirebaseAnalytics(Boolean bool) {
        this.firebaseAnalytics = bool;
    }

    public final void setGoogleProjectNumber(String str) {
        this.googleProjectNumber = str;
    }

    public final void setInfluenceParams(InfluenceParamsObject influenceParamsObject) {
        k.e(influenceParamsObject, "<set-?>");
        this.influenceParams = influenceParamsObject;
    }

    public final void setLocationShared(Boolean bool) {
        this.locationShared = bool;
    }

    public final void setNotificationChannels(JSONArray jSONArray) {
        this.notificationChannels = jSONArray;
    }

    public final void setOpRepoExecutionInterval(Long l) {
        this.opRepoExecutionInterval = l;
    }

    public final void setReceiveReceiptEnabled(Boolean bool) {
        this.receiveReceiptEnabled = bool;
    }

    public final void setRequiresUserPrivacyConsent(Boolean bool) {
        this.requiresUserPrivacyConsent = bool;
    }

    public final void setRestoreTTLFilter(Boolean bool) {
        this.restoreTTLFilter = bool;
    }

    public final void setUnsubscribeWhenNotificationsDisabled(Boolean bool) {
        this.unsubscribeWhenNotificationsDisabled = bool;
    }

    public final void setUseIdentityVerification(Boolean bool) {
        this.useIdentityVerification = bool;
    }

    public /* synthetic */ ParamsObject(String str, Boolean bool, Boolean bool2, JSONArray jSONArray, Boolean bool3, Boolean bool4, Boolean bool5, Boolean bool6, Boolean bool7, Boolean bool8, Boolean bool9, Boolean bool10, Long l, InfluenceParamsObject influenceParamsObject, FCMParamsObject fCMParamsObject, int i2, f fVar) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : bool, (i2 & 4) != 0 ? null : bool2, (i2 & 8) != 0 ? null : jSONArray, (i2 & 16) != 0 ? null : bool3, (i2 & 32) != 0 ? null : bool4, (i2 & 64) != 0 ? null : bool5, (i2 & 128) != 0 ? null : bool6, (i2 & 256) != 0 ? null : bool7, (i2 & 512) != 0 ? null : bool8, (i2 & 1024) != 0 ? null : bool9, (i2 & 2048) != 0 ? null : bool10, (i2 & 4096) != 0 ? null : l, influenceParamsObject, fCMParamsObject);
    }
}
