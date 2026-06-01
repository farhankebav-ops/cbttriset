package com.google.firebase.inappmessaging.internal;

import com.google.firebase.abt.FirebaseABTesting;
import com.google.firebase.inappmessaging.dagger.internal.DaggerGenerated;
import com.google.firebase.inappmessaging.dagger.internal.Factory;
import com.google.firebase.inappmessaging.dagger.internal.QualifierMetadata;
import com.google.firebase.inappmessaging.dagger.internal.ScopeMetadata;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
@QualifierMetadata({"com.google.firebase.annotations.concurrent.Blocking"})
@ScopeMetadata("com.google.firebase.inappmessaging.internal.injection.scopes.FirebaseAppScope")
@DaggerGenerated
public final class AbtIntegrationHelper_Factory implements Factory<AbtIntegrationHelper> {
    private final p5.a abTestingProvider;
    private final p5.a blockingExecutorProvider;

    public AbtIntegrationHelper_Factory(p5.a aVar, p5.a aVar2) {
        this.abTestingProvider = aVar;
        this.blockingExecutorProvider = aVar2;
    }

    public static AbtIntegrationHelper_Factory create(p5.a aVar, p5.a aVar2) {
        return new AbtIntegrationHelper_Factory(aVar, aVar2);
    }

    public static AbtIntegrationHelper newInstance(FirebaseABTesting firebaseABTesting, Executor executor) {
        return new AbtIntegrationHelper(firebaseABTesting, executor);
    }

    @Override // com.google.firebase.inappmessaging.dagger.internal.Factory, com.google.firebase.inappmessaging.dagger.internal.Provider, p5.a
    public AbtIntegrationHelper get() {
        return newInstance((FirebaseABTesting) this.abTestingProvider.get(), (Executor) this.blockingExecutorProvider.get());
    }
}
