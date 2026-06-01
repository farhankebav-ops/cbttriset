package com.google.firebase.inappmessaging.internal.injection.modules;

import com.google.firebase.inappmessaging.dagger.internal.DaggerGenerated;
import com.google.firebase.inappmessaging.dagger.internal.Factory;
import com.google.firebase.inappmessaging.dagger.internal.Preconditions;
import com.google.firebase.inappmessaging.dagger.internal.QualifierMetadata;
import com.google.firebase.inappmessaging.dagger.internal.ScopeMetadata;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
@QualifierMetadata({"com.google.firebase.annotations.concurrent.Lightweight"})
@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
public final class ExecutorsModule_ProvidesLightWeightExecutorFactory implements Factory<Executor> {
    private final ExecutorsModule module;

    public ExecutorsModule_ProvidesLightWeightExecutorFactory(ExecutorsModule executorsModule) {
        this.module = executorsModule;
    }

    public static ExecutorsModule_ProvidesLightWeightExecutorFactory create(ExecutorsModule executorsModule) {
        return new ExecutorsModule_ProvidesLightWeightExecutorFactory(executorsModule);
    }

    public static Executor providesLightWeightExecutor(ExecutorsModule executorsModule) {
        return (Executor) Preconditions.checkNotNullFromProvides(executorsModule.providesLightWeightExecutor());
    }

    @Override // com.google.firebase.inappmessaging.dagger.internal.Factory, com.google.firebase.inappmessaging.dagger.internal.Provider, p5.a
    public Executor get() {
        return providesLightWeightExecutor(this.module);
    }
}
