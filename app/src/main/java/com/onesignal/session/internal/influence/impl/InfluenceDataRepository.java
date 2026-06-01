package com.onesignal.session.internal.influence.impl;

import com.onesignal.core.internal.config.ConfigModelStore;
import com.onesignal.core.internal.preferences.IPreferencesService;
import com.onesignal.core.internal.preferences.PreferenceStores;
import com.onesignal.session.internal.influence.InfluenceType;
import kotlin.jvm.internal.k;
import okhttp3.internal.url._UrlKt;
import org.json.JSONArray;
import org.json.JSONException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class InfluenceDataRepository implements IInfluenceDataRepository {
    private final ConfigModelStore _configModelStore;
    private final IPreferencesService preferences;

    public InfluenceDataRepository(IPreferencesService preferences, ConfigModelStore _configModelStore) {
        k.e(preferences, "preferences");
        k.e(_configModelStore, "_configModelStore");
        this.preferences = preferences;
        this._configModelStore = _configModelStore;
    }

    @Override // com.onesignal.session.internal.influence.impl.IInfluenceDataRepository
    public void cacheIAMInfluenceType(InfluenceType influenceType) {
        k.e(influenceType, "influenceType");
        this.preferences.saveString(PreferenceStores.ONESIGNAL, InfluenceConstants.PREFS_OS_OUTCOMES_CURRENT_IAM_INFLUENCE, influenceType.toString());
    }

    @Override // com.onesignal.session.internal.influence.impl.IInfluenceDataRepository
    public void cacheNotificationInfluenceType(InfluenceType influenceType) {
        k.e(influenceType, "influenceType");
        this.preferences.saveString(PreferenceStores.ONESIGNAL, InfluenceConstants.PREFS_OS_OUTCOMES_CURRENT_NOTIFICATION_INFLUENCE, influenceType.toString());
    }

    @Override // com.onesignal.session.internal.influence.impl.IInfluenceDataRepository
    public void cacheNotificationOpenId(String str) {
        this.preferences.saveString(PreferenceStores.ONESIGNAL, InfluenceConstants.PREFS_OS_LAST_ATTRIBUTED_NOTIFICATION_OPEN, str);
    }

    @Override // com.onesignal.session.internal.influence.impl.IInfluenceDataRepository
    public String getCachedNotificationOpenId() {
        return this.preferences.getString(PreferenceStores.ONESIGNAL, InfluenceConstants.PREFS_OS_LAST_ATTRIBUTED_NOTIFICATION_OPEN, null);
    }

    @Override // com.onesignal.session.internal.influence.impl.IInfluenceDataRepository
    public InfluenceType getIamCachedInfluenceType() {
        return InfluenceType.Companion.fromString(this.preferences.getString(PreferenceStores.ONESIGNAL, InfluenceConstants.PREFS_OS_OUTCOMES_CURRENT_IAM_INFLUENCE, InfluenceType.UNATTRIBUTED.toString()));
    }

    @Override // com.onesignal.session.internal.influence.impl.IInfluenceDataRepository
    public int getIamIndirectAttributionWindow() {
        return this._configModelStore.getModel().getInfluenceParams().getIndirectIAMAttributionWindow();
    }

    @Override // com.onesignal.session.internal.influence.impl.IInfluenceDataRepository
    public int getIamLimit() {
        return this._configModelStore.getModel().getInfluenceParams().getIamLimit();
    }

    @Override // com.onesignal.session.internal.influence.impl.IInfluenceDataRepository
    public JSONArray getLastIAMsReceivedData() throws JSONException {
        String string = this.preferences.getString(PreferenceStores.ONESIGNAL, InfluenceConstants.PREFS_OS_LAST_IAMS_RECEIVED, _UrlKt.PATH_SEGMENT_ENCODE_SET_URI);
        return string != null ? new JSONArray(string) : new JSONArray();
    }

    @Override // com.onesignal.session.internal.influence.impl.IInfluenceDataRepository
    public JSONArray getLastNotificationsReceivedData() throws JSONException {
        String string = this.preferences.getString(PreferenceStores.ONESIGNAL, InfluenceConstants.PREFS_OS_LAST_NOTIFICATIONS_RECEIVED, _UrlKt.PATH_SEGMENT_ENCODE_SET_URI);
        return string != null ? new JSONArray(string) : new JSONArray();
    }

    @Override // com.onesignal.session.internal.influence.impl.IInfluenceDataRepository
    public InfluenceType getNotificationCachedInfluenceType() {
        return InfluenceType.Companion.fromString(this.preferences.getString(PreferenceStores.ONESIGNAL, InfluenceConstants.PREFS_OS_OUTCOMES_CURRENT_NOTIFICATION_INFLUENCE, InfluenceType.UNATTRIBUTED.toString()));
    }

    @Override // com.onesignal.session.internal.influence.impl.IInfluenceDataRepository
    public int getNotificationIndirectAttributionWindow() {
        return this._configModelStore.getModel().getInfluenceParams().getIndirectNotificationAttributionWindow();
    }

    @Override // com.onesignal.session.internal.influence.impl.IInfluenceDataRepository
    public int getNotificationLimit() {
        return this._configModelStore.getModel().getInfluenceParams().getNotificationLimit();
    }

    @Override // com.onesignal.session.internal.influence.impl.IInfluenceDataRepository
    public boolean isDirectInfluenceEnabled() {
        return this._configModelStore.getModel().getInfluenceParams().isDirectEnabled();
    }

    @Override // com.onesignal.session.internal.influence.impl.IInfluenceDataRepository
    public boolean isIndirectInfluenceEnabled() {
        return this._configModelStore.getModel().getInfluenceParams().isIndirectEnabled();
    }

    @Override // com.onesignal.session.internal.influence.impl.IInfluenceDataRepository
    public boolean isUnattributedInfluenceEnabled() {
        return this._configModelStore.getModel().getInfluenceParams().isUnattributedEnabled();
    }

    @Override // com.onesignal.session.internal.influence.impl.IInfluenceDataRepository
    public void saveIAMs(JSONArray iams) {
        k.e(iams, "iams");
        this.preferences.saveString(PreferenceStores.ONESIGNAL, InfluenceConstants.PREFS_OS_LAST_IAMS_RECEIVED, iams.toString());
    }

    @Override // com.onesignal.session.internal.influence.impl.IInfluenceDataRepository
    public void saveNotifications(JSONArray notifications) {
        k.e(notifications, "notifications");
        this.preferences.saveString(PreferenceStores.ONESIGNAL, InfluenceConstants.PREFS_OS_LAST_NOTIFICATIONS_RECEIVED, notifications.toString());
    }
}
