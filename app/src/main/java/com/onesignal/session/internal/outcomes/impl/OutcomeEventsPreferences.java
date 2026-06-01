package com.onesignal.session.internal.outcomes.impl;

import com.onesignal.core.internal.preferences.IPreferencesService;
import com.onesignal.core.internal.preferences.PreferenceOneSignalKeys;
import com.onesignal.core.internal.preferences.PreferenceStores;
import java.util.Set;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class OutcomeEventsPreferences implements IOutcomeEventsPreferences {
    private final IPreferencesService preferences;

    public OutcomeEventsPreferences(IPreferencesService preferences) {
        k.e(preferences, "preferences");
        this.preferences = preferences;
    }

    @Override // com.onesignal.session.internal.outcomes.impl.IOutcomeEventsPreferences
    public Set<String> getUnattributedUniqueOutcomeEventsSentByChannel() {
        return this.preferences.getStringSet(PreferenceStores.ONESIGNAL, PreferenceOneSignalKeys.PREFS_OS_UNATTRIBUTED_UNIQUE_OUTCOME_EVENTS_SENT, null);
    }

    @Override // com.onesignal.session.internal.outcomes.impl.IOutcomeEventsPreferences
    public void setUnattributedUniqueOutcomeEventsSentByChannel(Set<String> set) {
        this.preferences.saveStringSet(PreferenceStores.ONESIGNAL, PreferenceOneSignalKeys.PREFS_OS_UNATTRIBUTED_UNIQUE_OUTCOME_EVENTS_SENT, set);
    }
}
