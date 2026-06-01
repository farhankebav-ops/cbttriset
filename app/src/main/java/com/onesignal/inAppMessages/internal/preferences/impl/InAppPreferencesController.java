package com.onesignal.inAppMessages.internal.preferences.impl;

import com.onesignal.core.internal.preferences.IPreferencesService;
import com.onesignal.core.internal.preferences.PreferenceOneSignalKeys;
import com.onesignal.core.internal.preferences.PreferenceStores;
import com.onesignal.inAppMessages.internal.preferences.IInAppPreferencesController;
import java.util.Set;
import kotlin.jvm.internal.k;
import r5.l;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class InAppPreferencesController implements IInAppPreferencesController {
    private final IPreferencesService _prefs;

    public InAppPreferencesController(IPreferencesService _prefs) {
        k.e(_prefs, "_prefs");
        this._prefs = _prefs;
    }

    @Override // com.onesignal.inAppMessages.internal.preferences.IInAppPreferencesController
    public void cleanInAppMessageClickedClickIds(Set<String> set) {
        Set<String> stringSet;
        if (set == null || set.isEmpty() || (stringSet = this._prefs.getStringSet(PreferenceStores.ONESIGNAL, PreferenceOneSignalKeys.PREFS_OS_CLICKED_CLICK_IDS_IAMS, null)) == null || stringSet.isEmpty()) {
            return;
        }
        Set<String> setQ1 = l.q1(stringSet);
        setQ1.removeAll(set);
        this._prefs.saveStringSet(PreferenceStores.ONESIGNAL, PreferenceOneSignalKeys.PREFS_OS_CLICKED_CLICK_IDS_IAMS, setQ1);
    }

    @Override // com.onesignal.inAppMessages.internal.preferences.IInAppPreferencesController
    public void cleanInAppMessageIds(Set<String> set) {
        if (set == null || set.isEmpty()) {
            return;
        }
        Set<String> stringSet = this._prefs.getStringSet(PreferenceStores.ONESIGNAL, PreferenceOneSignalKeys.PREFS_OS_DISMISSED_IAMS, null);
        Set<String> stringSet2 = this._prefs.getStringSet(PreferenceStores.ONESIGNAL, PreferenceOneSignalKeys.PREFS_OS_IMPRESSIONED_IAMS, null);
        if (stringSet != null && !stringSet.isEmpty()) {
            Set<String> setQ1 = l.q1(stringSet);
            setQ1.removeAll(set);
            this._prefs.saveStringSet(PreferenceStores.ONESIGNAL, PreferenceOneSignalKeys.PREFS_OS_DISMISSED_IAMS, setQ1);
        }
        if (stringSet2 == null || stringSet2.isEmpty()) {
            return;
        }
        Set<String> setQ12 = l.q1(stringSet2);
        setQ12.removeAll(set);
        this._prefs.saveStringSet(PreferenceStores.ONESIGNAL, PreferenceOneSignalKeys.PREFS_OS_IMPRESSIONED_IAMS, setQ12);
    }

    @Override // com.onesignal.inAppMessages.internal.preferences.IInAppPreferencesController
    public Set<String> getClickedMessagesId() {
        return this._prefs.getStringSet(PreferenceStores.ONESIGNAL, PreferenceOneSignalKeys.PREFS_OS_CLICKED_CLICK_IDS_IAMS, null);
    }

    @Override // com.onesignal.inAppMessages.internal.preferences.IInAppPreferencesController
    public Set<String> getDismissedMessagesId() {
        return this._prefs.getStringSet(PreferenceStores.ONESIGNAL, PreferenceOneSignalKeys.PREFS_OS_DISMISSED_IAMS, null);
    }

    @Override // com.onesignal.inAppMessages.internal.preferences.IInAppPreferencesController
    public Set<String> getImpressionesMessagesId() {
        return this._prefs.getStringSet(PreferenceStores.ONESIGNAL, PreferenceOneSignalKeys.PREFS_OS_IMPRESSIONED_IAMS, null);
    }

    @Override // com.onesignal.inAppMessages.internal.preferences.IInAppPreferencesController
    public Long getLastTimeInAppDismissed() {
        return this._prefs.getLong(PreferenceStores.ONESIGNAL, PreferenceOneSignalKeys.PREFS_OS_IAM_LAST_DISMISSED_TIME, null);
    }

    @Override // com.onesignal.inAppMessages.internal.preferences.IInAppPreferencesController
    public String getSavedIAMs() {
        return this._prefs.getString(PreferenceStores.ONESIGNAL, PreferenceOneSignalKeys.PREFS_OS_CACHED_IAMS, null);
    }

    @Override // com.onesignal.inAppMessages.internal.preferences.IInAppPreferencesController
    public Set<String> getViewPageImpressionedIds() {
        return this._prefs.getStringSet(PreferenceStores.ONESIGNAL, PreferenceOneSignalKeys.PREFS_OS_PAGE_IMPRESSIONED_IAMS, null);
    }

    @Override // com.onesignal.inAppMessages.internal.preferences.IInAppPreferencesController
    public void setClickedMessagesId(Set<String> set) {
        this._prefs.saveStringSet(PreferenceStores.ONESIGNAL, PreferenceOneSignalKeys.PREFS_OS_CLICKED_CLICK_IDS_IAMS, set);
    }

    @Override // com.onesignal.inAppMessages.internal.preferences.IInAppPreferencesController
    public void setDismissedMessagesId(Set<String> set) {
        this._prefs.saveStringSet(PreferenceStores.ONESIGNAL, PreferenceOneSignalKeys.PREFS_OS_DISMISSED_IAMS, set);
    }

    @Override // com.onesignal.inAppMessages.internal.preferences.IInAppPreferencesController
    public void setImpressionesMessagesId(Set<String> set) {
        this._prefs.saveStringSet(PreferenceStores.ONESIGNAL, PreferenceOneSignalKeys.PREFS_OS_IMPRESSIONED_IAMS, set);
    }

    @Override // com.onesignal.inAppMessages.internal.preferences.IInAppPreferencesController
    public void setLastTimeInAppDismissed(Long l) {
        this._prefs.saveLong(PreferenceStores.ONESIGNAL, PreferenceOneSignalKeys.PREFS_OS_IAM_LAST_DISMISSED_TIME, l);
    }

    @Override // com.onesignal.inAppMessages.internal.preferences.IInAppPreferencesController
    public void setSavedIAMs(String str) {
        this._prefs.saveString(PreferenceStores.ONESIGNAL, PreferenceOneSignalKeys.PREFS_OS_CACHED_IAMS, str);
    }

    @Override // com.onesignal.inAppMessages.internal.preferences.IInAppPreferencesController
    public void setViewPageImpressionedIds(Set<String> set) {
        this._prefs.saveStringSet(PreferenceStores.ONESIGNAL, PreferenceOneSignalKeys.PREFS_OS_PAGE_IMPRESSIONED_IAMS, set);
    }
}
