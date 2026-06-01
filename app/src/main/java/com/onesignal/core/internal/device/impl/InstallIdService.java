package com.onesignal.core.internal.device.impl;

import com.onesignal.core.internal.device.IInstallIdService;
import com.onesignal.core.internal.preferences.IPreferencesService;
import java.util.UUID;
import kotlin.jvm.internal.k;
import n7.b;
import q5.f;
import v5.c;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class InstallIdService implements IInstallIdService {
    private final IPreferencesService _prefs;
    private final f currentId$delegate;

    public InstallIdService(IPreferencesService _prefs) {
        k.e(_prefs, "_prefs");
        this._prefs = _prefs;
        this.currentId$delegate = b.C(new InstallIdService$currentId$2(this));
    }

    private final UUID getCurrentId() {
        Object value = this.currentId$delegate.getValue();
        k.d(value, "<get-currentId>(...)");
        return (UUID) value;
    }

    @Override // com.onesignal.core.internal.device.IInstallIdService
    public Object getId(c<? super UUID> cVar) {
        return getCurrentId();
    }
}
