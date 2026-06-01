package com.google.firebase.inappmessaging.internal;

import com.google.firebase.FirebaseApp;
import com.google.firebase.inappmessaging.dagger.internal.DaggerGenerated;
import com.google.firebase.inappmessaging.dagger.internal.Factory;
import com.google.firebase.inappmessaging.dagger.internal.QualifierMetadata;
import com.google.firebase.inappmessaging.dagger.internal.ScopeMetadata;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
@QualifierMetadata
@ScopeMetadata
@DaggerGenerated
public final class SharedPreferencesUtils_Factory implements Factory<SharedPreferencesUtils> {
    private final p5.a firebaseAppProvider;

    public SharedPreferencesUtils_Factory(p5.a aVar) {
        this.firebaseAppProvider = aVar;
    }

    public static SharedPreferencesUtils_Factory create(p5.a aVar) {
        return new SharedPreferencesUtils_Factory(aVar);
    }

    public static SharedPreferencesUtils newInstance(FirebaseApp firebaseApp) {
        return new SharedPreferencesUtils(firebaseApp);
    }

    @Override // com.google.firebase.inappmessaging.dagger.internal.Factory, com.google.firebase.inappmessaging.dagger.internal.Provider, p5.a
    public SharedPreferencesUtils get() {
        return newInstance((FirebaseApp) this.firebaseAppProvider.get());
    }
}
