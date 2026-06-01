package com.google.firebase.sessions;

import com.google.firebase.inject.Provider;
import com.google.firebase.sessions.dagger.internal.DaggerGenerated;
import com.google.firebase.sessions.dagger.internal.Factory;
import com.google.firebase.sessions.dagger.internal.QualifierMetadata;
import com.google.firebase.sessions.dagger.internal.ScopeMetadata;
import m0.h;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata
@DaggerGenerated
public final class EventGDTLogger_Factory implements Factory<EventGDTLogger> {
    private final p5.a transportFactoryProvider;

    public EventGDTLogger_Factory(p5.a aVar) {
        this.transportFactoryProvider = aVar;
    }

    public static EventGDTLogger_Factory create(p5.a aVar) {
        return new EventGDTLogger_Factory(aVar);
    }

    public static EventGDTLogger newInstance(Provider<h> provider) {
        return new EventGDTLogger(provider);
    }

    @Override // com.google.firebase.sessions.dagger.internal.Factory, com.google.firebase.sessions.dagger.internal.Provider, p5.a
    public EventGDTLogger get() {
        return newInstance((Provider) this.transportFactoryProvider.get());
    }
}
