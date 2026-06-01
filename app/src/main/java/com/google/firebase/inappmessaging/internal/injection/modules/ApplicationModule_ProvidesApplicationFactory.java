package com.google.firebase.inappmessaging.internal.injection.modules;

import android.app.Application;
import com.google.firebase.inappmessaging.dagger.internal.DaggerGenerated;
import com.google.firebase.inappmessaging.dagger.internal.Factory;
import com.google.firebase.inappmessaging.dagger.internal.Preconditions;
import com.google.firebase.inappmessaging.dagger.internal.QualifierMetadata;
import com.google.firebase.inappmessaging.dagger.internal.ScopeMetadata;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
@QualifierMetadata
@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
public final class ApplicationModule_ProvidesApplicationFactory implements Factory<Application> {
    private final ApplicationModule module;

    public ApplicationModule_ProvidesApplicationFactory(ApplicationModule applicationModule) {
        this.module = applicationModule;
    }

    public static ApplicationModule_ProvidesApplicationFactory create(ApplicationModule applicationModule) {
        return new ApplicationModule_ProvidesApplicationFactory(applicationModule);
    }

    public static Application providesApplication(ApplicationModule applicationModule) {
        return (Application) Preconditions.checkNotNullFromProvides(applicationModule.providesApplication());
    }

    @Override // com.google.firebase.inappmessaging.dagger.internal.Factory, com.google.firebase.inappmessaging.dagger.internal.Provider, p5.a
    public Application get() {
        return providesApplication(this.module);
    }
}
