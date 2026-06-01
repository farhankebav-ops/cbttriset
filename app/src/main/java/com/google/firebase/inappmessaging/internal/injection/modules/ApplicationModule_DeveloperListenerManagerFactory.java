package com.google.firebase.inappmessaging.internal.injection.modules;

import com.google.firebase.inappmessaging.dagger.internal.DaggerGenerated;
import com.google.firebase.inappmessaging.dagger.internal.Factory;
import com.google.firebase.inappmessaging.dagger.internal.Preconditions;
import com.google.firebase.inappmessaging.dagger.internal.QualifierMetadata;
import com.google.firebase.inappmessaging.dagger.internal.ScopeMetadata;
import com.google.firebase.inappmessaging.internal.DeveloperListenerManager;
import java.util.concurrent.Executor;
import p5.a;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
@QualifierMetadata({"com.google.firebase.annotations.concurrent.Background"})
@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
public final class ApplicationModule_DeveloperListenerManagerFactory implements Factory<DeveloperListenerManager> {
    private final a backgroundExecutorProvider;
    private final ApplicationModule module;

    public ApplicationModule_DeveloperListenerManagerFactory(ApplicationModule applicationModule, a aVar) {
        this.module = applicationModule;
        this.backgroundExecutorProvider = aVar;
    }

    public static ApplicationModule_DeveloperListenerManagerFactory create(ApplicationModule applicationModule, a aVar) {
        return new ApplicationModule_DeveloperListenerManagerFactory(applicationModule, aVar);
    }

    public static DeveloperListenerManager developerListenerManager(ApplicationModule applicationModule, Executor executor) {
        return (DeveloperListenerManager) Preconditions.checkNotNullFromProvides(applicationModule.developerListenerManager(executor));
    }

    @Override // com.google.firebase.inappmessaging.dagger.internal.Factory, com.google.firebase.inappmessaging.dagger.internal.Provider, p5.a
    public DeveloperListenerManager get() {
        return developerListenerManager(this.module, (Executor) this.backgroundExecutorProvider.get());
    }
}
