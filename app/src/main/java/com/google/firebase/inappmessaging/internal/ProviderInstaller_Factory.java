package com.google.firebase.inappmessaging.internal;

import android.app.Application;
import com.google.firebase.inappmessaging.dagger.internal.DaggerGenerated;
import com.google.firebase.inappmessaging.dagger.internal.Factory;
import com.google.firebase.inappmessaging.dagger.internal.QualifierMetadata;
import com.google.firebase.inappmessaging.dagger.internal.ScopeMetadata;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
@QualifierMetadata
@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
public final class ProviderInstaller_Factory implements Factory<ProviderInstaller> {
    private final p5.a applicationProvider;

    public ProviderInstaller_Factory(p5.a aVar) {
        this.applicationProvider = aVar;
    }

    public static ProviderInstaller_Factory create(p5.a aVar) {
        return new ProviderInstaller_Factory(aVar);
    }

    public static ProviderInstaller newInstance(Application application) {
        return new ProviderInstaller(application);
    }

    @Override // com.google.firebase.inappmessaging.dagger.internal.Factory, com.google.firebase.inappmessaging.dagger.internal.Provider, p5.a
    public ProviderInstaller get() {
        return newInstance((Application) this.applicationProvider.get());
    }
}
