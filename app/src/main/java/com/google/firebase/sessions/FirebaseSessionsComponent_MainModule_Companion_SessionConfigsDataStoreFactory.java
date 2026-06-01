package com.google.firebase.sessions;

import android.content.Context;
import androidx.datastore.core.DataStore;
import com.google.firebase.sessions.FirebaseSessionsComponent;
import com.google.firebase.sessions.dagger.internal.DaggerGenerated;
import com.google.firebase.sessions.dagger.internal.Factory;
import com.google.firebase.sessions.dagger.internal.Preconditions;
import com.google.firebase.sessions.dagger.internal.QualifierMetadata;
import com.google.firebase.sessions.dagger.internal.ScopeMetadata;
import com.google.firebase.sessions.settings.SessionConfigs;
import v5.h;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata({"com.google.firebase.annotations.concurrent.Blocking"})
@DaggerGenerated
public final class FirebaseSessionsComponent_MainModule_Companion_SessionConfigsDataStoreFactory implements Factory<DataStore<SessionConfigs>> {
    private final p5.a appContextProvider;
    private final p5.a blockingDispatcherProvider;

    public FirebaseSessionsComponent_MainModule_Companion_SessionConfigsDataStoreFactory(p5.a aVar, p5.a aVar2) {
        this.appContextProvider = aVar;
        this.blockingDispatcherProvider = aVar2;
    }

    public static FirebaseSessionsComponent_MainModule_Companion_SessionConfigsDataStoreFactory create(p5.a aVar, p5.a aVar2) {
        return new FirebaseSessionsComponent_MainModule_Companion_SessionConfigsDataStoreFactory(aVar, aVar2);
    }

    public static DataStore<SessionConfigs> sessionConfigsDataStore(Context context, h hVar) {
        return (DataStore) Preconditions.checkNotNullFromProvides(FirebaseSessionsComponent.MainModule.Companion.sessionConfigsDataStore(context, hVar));
    }

    @Override // com.google.firebase.sessions.dagger.internal.Factory, com.google.firebase.sessions.dagger.internal.Provider, p5.a
    public DataStore<SessionConfigs> get() {
        return sessionConfigsDataStore((Context) this.appContextProvider.get(), (h) this.blockingDispatcherProvider.get());
    }
}
