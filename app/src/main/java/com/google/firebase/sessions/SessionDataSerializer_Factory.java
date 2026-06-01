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
public final class SessionDataSerializer_Factory implements Factory<SessionDataSerializer> {
    private final p5.a sessionGeneratorProvider;

    public SessionDataSerializer_Factory(p5.a aVar) {
        this.sessionGeneratorProvider = aVar;
    }

    public static SessionDataSerializer_Factory create(p5.a aVar) {
        return new SessionDataSerializer_Factory(aVar);
    }

    public static SessionDataSerializer newInstance(SessionGenerator sessionGenerator) {
        return new SessionDataSerializer(sessionGenerator);
    }

    @Override // com.google.firebase.sessions.dagger.internal.Factory, com.google.firebase.sessions.dagger.internal.Provider, p5.a
    public SessionDataSerializer get() {
        return newInstance((SessionGenerator) this.sessionGeneratorProvider.get());
    }
}
