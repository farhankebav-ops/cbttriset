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
public final class SessionsActivityLifecycleCallbacks_Factory implements Factory<SessionsActivityLifecycleCallbacks> {
    private final p5.a sharedSessionRepositoryProvider;

    public SessionsActivityLifecycleCallbacks_Factory(p5.a aVar) {
        this.sharedSessionRepositoryProvider = aVar;
    }

    public static SessionsActivityLifecycleCallbacks_Factory create(p5.a aVar) {
        return new SessionsActivityLifecycleCallbacks_Factory(aVar);
    }

    public static SessionsActivityLifecycleCallbacks newInstance(SharedSessionRepository sharedSessionRepository) {
        return new SessionsActivityLifecycleCallbacks(sharedSessionRepository);
    }

    @Override // com.google.firebase.sessions.dagger.internal.Factory, com.google.firebase.sessions.dagger.internal.Provider, p5.a
    public SessionsActivityLifecycleCallbacks get() {
        return newInstance((SharedSessionRepository) this.sharedSessionRepositoryProvider.get());
    }
}
