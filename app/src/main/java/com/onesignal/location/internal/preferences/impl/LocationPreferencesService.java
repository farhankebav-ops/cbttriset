package com.onesignal.location.internal.preferences.impl;

import com.onesignal.core.internal.preferences.IPreferencesService;
import com.onesignal.core.internal.preferences.PreferenceOneSignalKeys;
import com.onesignal.core.internal.preferences.PreferenceStores;
import com.onesignal.location.internal.preferences.ILocationPreferencesService;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class LocationPreferencesService implements ILocationPreferencesService {
    private final IPreferencesService _prefs;

    public LocationPreferencesService(IPreferencesService _prefs) {
        k.e(_prefs, "_prefs");
        this._prefs = _prefs;
    }

    @Override // com.onesignal.location.internal.preferences.ILocationPreferencesService
    public long getLastLocationTime() {
        Long l = this._prefs.getLong(PreferenceStores.ONESIGNAL, PreferenceOneSignalKeys.PREFS_OS_LAST_LOCATION_TIME, -600000L);
        k.b(l);
        return l.longValue();
    }

    @Override // com.onesignal.location.internal.preferences.ILocationPreferencesService
    public void setLastLocationTime(long j) {
        this._prefs.saveLong(PreferenceStores.ONESIGNAL, PreferenceOneSignalKeys.PREFS_OS_LAST_LOCATION_TIME, Long.valueOf(j));
    }
}
