package com.google.firebase.sessions;

import com.google.firebase.sessions.dagger.internal.DaggerGenerated;
import com.google.firebase.sessions.dagger.internal.Factory;
import com.google.firebase.sessions.dagger.internal.QualifierMetadata;
import com.google.firebase.sessions.dagger.internal.ScopeMetadata;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata
@DaggerGenerated
public final class SessionGenerator_Factory implements Factory<SessionGenerator> {
    private final p5.a timeProvider;
    private final p5.a uuidGeneratorProvider;

    public SessionGenerator_Factory(p5.a aVar, p5.a aVar2) {
        this.timeProvider = aVar;
        this.uuidGeneratorProvider = aVar2;
    }

    public static SessionGenerator_Factory create(p5.a aVar, p5.a aVar2) {
        return new SessionGenerator_Factory(aVar, aVar2);
    }

    public static SessionGenerator newInstance(TimeProvider timeProvider, UuidGenerator uuidGenerator) {
        return new SessionGenerator(timeProvider, uuidGenerator);
    }

    @Override // com.google.firebase.sessions.dagger.internal.Factory, com.google.firebase.sessions.dagger.internal.Provider, p5.a
    public SessionGenerator get() {
        return newInstance((TimeProvider) this.timeProvider.get(), (UuidGenerator) this.uuidGeneratorProvider.get());
    }
}
