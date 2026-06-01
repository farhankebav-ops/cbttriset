package com.google.firebase.sessions;

import android.content.Context;
import androidx.datastore.core.DataStore;
import com.google.firebase.sessions.FirebaseSessionsComponent;
import com.google.firebase.sessions.dagger.internal.DaggerGenerated;
import com.google.firebase.sessions.dagger.internal.Factory;
import com.google.firebase.sessions.dagger.internal.Preconditions;
import com.google.firebase.sessions.dagger.internal.QualifierMetadata;
import com.google.firebase.sessions.dagger.internal.ScopeMetadata;
import v5.h;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata({"com.google.firebase.annotations.concurrent.Blocking"})
@DaggerGenerated
public final class FirebaseSessionsComponent_MainModule_Companion_SessionDataStoreFactory implements Factory<DataStore<SessionData>> {
    private final p5.a appContextProvider;
    private final p5.a blockingDispatcherProvider;
    private final p5.a sessionDataSerializerProvider;

    public FirebaseSessionsComponent_MainModule_Companion_SessionDataStoreFactory(p5.a aVar, p5.a aVar2, p5.a aVar3) {
        this.appContextProvider = aVar;
        this.blockingDispatcherProvider = aVar2;
        this.sessionDataSerializerProvider = aVar3;
    }

    public static FirebaseSessionsComponent_MainModule_Companion_SessionDataStoreFactory create(p5.a aVar, p5.a aVar2, p5.a aVar3) {
        return new FirebaseSessionsComponent_MainModule_Companion_SessionDataStoreFactory(aVar, aVar2, aVar3);
    }

    public static DataStore<SessionData> sessionDataStore(Context context, h hVar, SessionDataSerializer sessionDataSerializer) {
        return (DataStore) Preconditions.checkNotNullFromProvides(FirebaseSessionsComponent.MainModule.Companion.sessionDataStore(context, hVar, sessionDataSerializer));
    }

    @Override // com.google.firebase.sessions.dagger.internal.Factory, com.google.firebase.sessions.dagger.internal.Provider, p5.a
    public DataStore<SessionData> get() {
        return sessionDataStore((Context) this.appContextProvider.get(), (h) this.blockingDispatcherProvider.get(), (SessionDataSerializer) this.sessionDataSerializerProvider.get());
    }
}
