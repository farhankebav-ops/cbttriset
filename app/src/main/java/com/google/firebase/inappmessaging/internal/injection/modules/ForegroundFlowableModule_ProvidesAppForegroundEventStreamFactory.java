package com.google.firebase.inappmessaging.internal.injection.modules;

import android.app.Application;
import com.google.firebase.inappmessaging.dagger.internal.DaggerGenerated;
import com.google.firebase.inappmessaging.dagger.internal.Factory;
import com.google.firebase.inappmessaging.dagger.internal.Preconditions;
import com.google.firebase.inappmessaging.dagger.internal.QualifierMetadata;
import com.google.firebase.inappmessaging.dagger.internal.ScopeMetadata;
import w4.a;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
@QualifierMetadata({"com.google.firebase.inappmessaging.internal.injection.qualifiers.AppForeground"})
@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
public final class ForegroundFlowableModule_ProvidesAppForegroundEventStreamFactory implements Factory<a> {
    private final p5.a applicationProvider;
    private final ForegroundFlowableModule module;

    public ForegroundFlowableModule_ProvidesAppForegroundEventStreamFactory(ForegroundFlowableModule foregroundFlowableModule, p5.a aVar) {
        this.module = foregroundFlowableModule;
        this.applicationProvider = aVar;
    }

    public static ForegroundFlowableModule_ProvidesAppForegroundEventStreamFactory create(ForegroundFlowableModule foregroundFlowableModule, p5.a aVar) {
        return new ForegroundFlowableModule_ProvidesAppForegroundEventStreamFactory(foregroundFlowableModule, aVar);
    }

    public static a providesAppForegroundEventStream(ForegroundFlowableModule foregroundFlowableModule, Application application) {
        return (a) Preconditions.checkNotNullFromProvides(foregroundFlowableModule.providesAppForegroundEventStream(application));
    }

    @Override // com.google.firebase.inappmessaging.dagger.internal.Factory, com.google.firebase.inappmessaging.dagger.internal.Provider, p5.a
    public a get() {
        return providesAppForegroundEventStream(this.module, (Application) this.applicationProvider.get());
    }
}
