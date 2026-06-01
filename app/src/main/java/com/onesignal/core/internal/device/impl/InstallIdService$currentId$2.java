package com.onesignal.core.internal.device.impl;

import com.onesignal.core.internal.preferences.IPreferencesService;
import com.onesignal.core.internal.preferences.PreferenceOneSignalKeys;
import com.onesignal.core.internal.preferences.PreferenceStores;
import e6.a;
import java.util.UUID;
import kotlin.jvm.internal.l;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class InstallIdService$currentId$2 extends l implements a {
    final /* synthetic */ InstallIdService this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InstallIdService$currentId$2(InstallIdService installIdService) {
        super(0);
        this.this$0 = installIdService;
    }

    @Override // e6.a
    public final UUID invoke() {
        String string$default = IPreferencesService.DefaultImpls.getString$default(this.this$0._prefs, PreferenceStores.ONESIGNAL, PreferenceOneSignalKeys.PREFS_OS_INSTALL_ID, null, 4, null);
        if (string$default != null) {
            return UUID.fromString(string$default);
        }
        UUID uuidRandomUUID = UUID.randomUUID();
        this.this$0._prefs.saveString(PreferenceStores.ONESIGNAL, PreferenceOneSignalKeys.PREFS_OS_INSTALL_ID, uuidRandomUUID.toString());
        return uuidRandomUUID;
    }
}
