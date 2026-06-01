package com.google.firebase.sessions.settings;

import com.google.firebase.sessions.dagger.internal.DaggerGenerated;
import com.google.firebase.sessions.dagger.internal.Factory;
import com.google.firebase.sessions.dagger.internal.QualifierMetadata;
import com.google.firebase.sessions.dagger.internal.ScopeMetadata;
import p5.a;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata({"com.google.firebase.sessions.LocalOverrideSettingsProvider", "com.google.firebase.sessions.RemoteSettingsProvider"})
@DaggerGenerated
public final class SessionsSettings_Factory implements Factory<SessionsSettings> {
    private final a localOverrideSettingsProvider;
    private final a remoteSettingsProvider;

    public SessionsSettings_Factory(a aVar, a aVar2) {
        this.localOverrideSettingsProvider = aVar;
        this.remoteSettingsProvider = aVar2;
    }

    public static SessionsSettings_Factory create(a aVar, a aVar2) {
        return new SessionsSettings_Factory(aVar, aVar2);
    }

    public static SessionsSettings newInstance(SettingsProvider settingsProvider, SettingsProvider settingsProvider2) {
        return new SessionsSettings(settingsProvider, settingsProvider2);
    }

    @Override // com.google.firebase.sessions.dagger.internal.Factory, com.google.firebase.sessions.dagger.internal.Provider, p5.a
    public SessionsSettings get() {
        return newInstance((SettingsProvider) this.localOverrideSettingsProvider.get(), (SettingsProvider) this.remoteSettingsProvider.get());
    }
}
