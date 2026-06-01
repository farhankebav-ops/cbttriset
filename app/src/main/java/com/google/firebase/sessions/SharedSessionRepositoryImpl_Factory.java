package com.google.firebase.sessions;

import androidx.datastore.core.DataStore;
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
public final class SharedSessionRepositoryImpl_Factory implements Factory<SharedSessionRepositoryImpl> {
    private final p5.a backgroundDispatcherProvider;
    private final p5.a processDataManagerProvider;
    private final p5.a sessionDataStoreProvider;
    private final p5.a sessionFirelogPublisherProvider;
    private final p5.a sessionGeneratorProvider;
    private final p5.a sessionsSettingsProvider;
    private final p5.a timeProvider;

    public SharedSessionRepositoryImpl_Factory(p5.a aVar, p5.a aVar2, p5.a aVar3, p5.a aVar4, p5.a aVar5, p5.a aVar6, p5.a aVar7) {
        this.sessionsSettingsProvider = aVar;
        this.sessionGeneratorProvider = aVar2;
        this.sessionFirelogPublisherProvider = aVar3;
        this.timeProvider = aVar4;
        this.sessionDataStoreProvider = aVar5;
        this.processDataManagerProvider = aVar6;
        this.backgroundDispatcherProvider = aVar7;
    }

    public static SharedSessionRepositoryImpl_Factory create(p5.a aVar, p5.a aVar2, p5.a aVar3, p5.a aVar4, p5.a aVar5, p5.a aVar6, p5.a aVar7) {
        return new SharedSessionRepositoryImpl_Factory(aVar, aVar2, aVar3, aVar4, aVar5, aVar6, aVar7);
    }

    public static SharedSessionRepositoryImpl newInstance(SessionsSettings sessionsSettings, SessionGenerator sessionGenerator, SessionFirelogPublisher sessionFirelogPublisher, TimeProvider timeProvider, DataStore<SessionData> dataStore, ProcessDataManager processDataManager, h hVar) {
        return new SharedSessionRepositoryImpl(sessionsSettings, sessionGenerator, sessionFirelogPublisher, timeProvider, dataStore, processDataManager, hVar);
    }

    @Override // com.google.firebase.sessions.dagger.internal.Factory, com.google.firebase.sessions.dagger.internal.Provider, p5.a
    public SharedSessionRepositoryImpl get() {
        return newInstance((SessionsSettings) this.sessionsSettingsProvider.get(), (SessionGenerator) this.sessionGeneratorProvider.get(), (SessionFirelogPublisher) this.sessionFirelogPublisherProvider.get(), (TimeProvider) this.timeProvider.get(), (DataStore) this.sessionDataStoreProvider.get(), (ProcessDataManager) this.processDataManagerProvider.get(), (h) this.backgroundDispatcherProvider.get());
    }
}
