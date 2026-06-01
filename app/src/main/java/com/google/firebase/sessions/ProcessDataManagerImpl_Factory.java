package com.google.firebase.sessions;

import android.content.Context;
import com.google.firebase.sessions.dagger.internal.DaggerGenerated;
import com.google.firebase.sessions.dagger.internal.Factory;
import com.google.firebase.sessions.dagger.internal.QualifierMetadata;
import com.google.firebase.sessions.dagger.internal.ScopeMetadata;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata
@DaggerGenerated
public final class ProcessDataManagerImpl_Factory implements Factory<ProcessDataManagerImpl> {
    private final p5.a appContextProvider;
    private final p5.a uuidGeneratorProvider;

    public ProcessDataManagerImpl_Factory(p5.a aVar, p5.a aVar2) {
        this.appContextProvider = aVar;
        this.uuidGeneratorProvider = aVar2;
    }

    public static ProcessDataManagerImpl_Factory create(p5.a aVar, p5.a aVar2) {
        return new ProcessDataManagerImpl_Factory(aVar, aVar2);
    }

    public static ProcessDataManagerImpl newInstance(Context context, UuidGenerator uuidGenerator) {
        return new ProcessDataManagerImpl(context, uuidGenerator);
    }

    @Override // com.google.firebase.sessions.dagger.internal.Factory, com.google.firebase.sessions.dagger.internal.Provider, p5.a
    public ProcessDataManagerImpl get() {
        return newInstance((Context) this.appContextProvider.get(), (UuidGenerator) this.uuidGeneratorProvider.get());
    }
}
