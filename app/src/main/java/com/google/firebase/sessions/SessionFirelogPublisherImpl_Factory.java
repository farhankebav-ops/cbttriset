package com.google.firebase.sessions;

import com.google.firebase.FirebaseApp;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.sessions.dagger.internal.DaggerGenerated;
import com.google.firebase.sessions.dagger.internal.Factory;
import com.google.firebase.sessions.dagger.internal.QualifierMetadata;
import com.google.firebase.sessions.dagger.internal.ScopeMetadata;
import com.google.firebase.sessions.settings.SessionsSettings;
import v5.h;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata({"com.google.firebase.annotations.concurrent.Background"})
@DaggerGenerated
public final class SessionFirelogPublisherImpl_Factory implements Factory<SessionFirelogPublisherImpl> {
    private final p5.a backgroundDispatcherProvider;
    private final p5.a eventGDTLoggerProvider;
    private final p5.a firebaseAppProvider;
    private final p5.a firebaseInstallationsProvider;
    private final p5.a sessionSettingsProvider;

    public SessionFirelogPublisherImpl_Factory(p5.a aVar, p5.a aVar2, p5.a aVar3, p5.a aVar4, p5.a aVar5) {
        this.firebaseAppProvider = aVar;
        this.firebaseInstallationsProvider = aVar2;
        this.sessionSettingsProvider = aVar3;
        this.eventGDTLoggerProvider = aVar4;
        this.backgroundDispatcherProvider = aVar5;
    }

    public static SessionFirelogPublisherImpl_Factory create(p5.a aVar, p5.a aVar2, p5.a aVar3, p5.a aVar4, p5.a aVar5) {
        return new SessionFirelogPublisherImpl_Factory(aVar, aVar2, aVar3, aVar4, aVar5);
    }

    public static SessionFirelogPublisherImpl newInstance(FirebaseApp firebaseApp, FirebaseInstallationsApi firebaseInstallationsApi, SessionsSettings sessionsSettings, EventGDTLoggerInterface eventGDTLoggerInterface, h hVar) {
        return new SessionFirelogPublisherImpl(firebaseApp, firebaseInstallationsApi, sessionsSettings, eventGDTLoggerInterface, hVar);
    }

    @Override // com.google.firebase.sessions.dagger.internal.Factory, com.google.firebase.sessions.dagger.internal.Provider, p5.a
    public SessionFirelogPublisherImpl get() {
        return newInstance((FirebaseApp) this.firebaseAppProvider.get(), (FirebaseInstallationsApi) this.firebaseInstallationsProvider.get(), (SessionsSettings) this.sessionSettingsProvider.get(), (EventGDTLoggerInterface) this.eventGDTLoggerProvider.get(), (h) this.backgroundDispatcherProvider.get());
    }
}
