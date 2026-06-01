package com.google.firebase.sessions.settings;

import androidx.datastore.core.DataStore;
import com.google.firebase.sessions.TimeProvider;
import com.google.firebase.sessions.dagger.internal.DaggerGenerated;
import com.google.firebase.sessions.dagger.internal.Factory;
import com.google.firebase.sessions.dagger.internal.QualifierMetadata;
import com.google.firebase.sessions.dagger.internal.ScopeMetadata;
import p5.a;
import v5.h;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata({"com.google.firebase.annotations.concurrent.Background"})
@DaggerGenerated
public final class SettingsCacheImpl_Factory implements Factory<SettingsCacheImpl> {
    private final a backgroundDispatcherProvider;
    private final a sessionConfigsDataStoreProvider;
    private final a timeProvider;

    public SettingsCacheImpl_Factory(a aVar, a aVar2, a aVar3) {
        this.backgroundDispatcherProvider = aVar;
        this.timeProvider = aVar2;
        this.sessionConfigsDataStoreProvider = aVar3;
    }

    public static SettingsCacheImpl_Factory create(a aVar, a aVar2, a aVar3) {
        return new SettingsCacheImpl_Factory(aVar, aVar2, aVar3);
    }

    public static SettingsCacheImpl newInstance(h hVar, TimeProvider timeProvider, DataStore<SessionConfigs> dataStore) {
        return new SettingsCacheImpl(hVar, timeProvider, dataStore);
    }

    @Override // com.google.firebase.sessions.dagger.internal.Factory, com.google.firebase.sessions.dagger.internal.Provider, p5.a
    public SettingsCacheImpl get() {
        return newInstance((h) this.backgroundDispatcherProvider.get(), (TimeProvider) this.timeProvider.get(), (DataStore) this.sessionConfigsDataStoreProvider.get());
    }
}
