package com.google.firebase.sessions;

import com.google.firebase.FirebaseApp;
import com.google.firebase.sessions.FirebaseSessionsComponent;
import com.google.firebase.sessions.dagger.internal.DaggerGenerated;
import com.google.firebase.sessions.dagger.internal.Factory;
import com.google.firebase.sessions.dagger.internal.Preconditions;
import com.google.firebase.sessions.dagger.internal.QualifierMetadata;
import com.google.firebase.sessions.dagger.internal.ScopeMetadata;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata
@DaggerGenerated
public final class FirebaseSessionsComponent_MainModule_Companion_ApplicationInfoFactory implements Factory<ApplicationInfo> {
    private final p5.a firebaseAppProvider;

    public FirebaseSessionsComponent_MainModule_Companion_ApplicationInfoFactory(p5.a aVar) {
        this.firebaseAppProvider = aVar;
    }

    public static ApplicationInfo applicationInfo(FirebaseApp firebaseApp) {
        return (ApplicationInfo) Preconditions.checkNotNullFromProvides(FirebaseSessionsComponent.MainModule.Companion.applicationInfo(firebaseApp));
    }

    public static FirebaseSessionsComponent_MainModule_Companion_ApplicationInfoFactory create(p5.a aVar) {
        return new FirebaseSessionsComponent_MainModule_Companion_ApplicationInfoFactory(aVar);
    }

    @Override // com.google.firebase.sessions.dagger.internal.Factory, com.google.firebase.sessions.dagger.internal.Provider, p5.a
    public ApplicationInfo get() {
        return applicationInfo((FirebaseApp) this.firebaseAppProvider.get());
    }
}
