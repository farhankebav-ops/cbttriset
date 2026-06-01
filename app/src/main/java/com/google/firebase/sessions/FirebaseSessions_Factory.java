package com.google.firebase.sessions;

import com.google.firebase.FirebaseApp;
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
public final class FirebaseSessions_Factory implements Factory<FirebaseSessions> {
    private final p5.a backgroundDispatcherProvider;
    private final p5.a firebaseAppProvider;
    private final p5.a sessionsActivityLifecycleCallbacksProvider;
    private final p5.a settingsProvider;

    public FirebaseSessions_Factory(p5.a aVar, p5.a aVar2, p5.a aVar3, p5.a aVar4) {
        this.firebaseAppProvider = aVar;
        this.settingsProvider = aVar2;
        this.backgroundDispatcherProvider = aVar3;
        this.sessionsActivityLifecycleCallbacksProvider = aVar4;
    }

    public static FirebaseSessions_Factory create(p5.a aVar, p5.a aVar2, p5.a aVar3, p5.a aVar4) {
        return new FirebaseSessions_Factory(aVar, aVar2, aVar3, aVar4);
    }

    public static FirebaseSessions newInstance(FirebaseApp firebaseApp, SessionsSettings sessionsSettings, h hVar, SessionsActivityLifecycleCallbacks sessionsActivityLifecycleCallbacks) {
        return new FirebaseSessions(firebaseApp, sessionsSettings, hVar, sessionsActivityLifecycleCallbacks);
    }

    @Override // com.google.firebase.sessions.dagger.internal.Factory, com.google.firebase.sessions.dagger.internal.Provider, p5.a
    public FirebaseSessions get() {
        return newInstance((FirebaseApp) this.firebaseAppProvider.get(), (SessionsSettings) this.settingsProvider.get(), (h) this.backgroundDispatcherProvider.get(), (SessionsActivityLifecycleCallbacks) this.sessionsActivityLifecycleCallbacksProvider.get());
    }
}
