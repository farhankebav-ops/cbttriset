package com.google.firebase.inappmessaging.internal.injection.modules;

import com.google.firebase.events.Subscriber;
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
public final class AppMeasurementModule_ProvidesSubsriberFactory implements Factory<Subscriber> {
    private final AppMeasurementModule module;

    public AppMeasurementModule_ProvidesSubsriberFactory(AppMeasurementModule appMeasurementModule) {
        this.module = appMeasurementModule;
    }

    public static AppMeasurementModule_ProvidesSubsriberFactory create(AppMeasurementModule appMeasurementModule) {
        return new AppMeasurementModule_ProvidesSubsriberFactory(appMeasurementModule);
    }

    public static Subscriber providesSubsriber(AppMeasurementModule appMeasurementModule) {
        return (Subscriber) Preconditions.checkNotNullFromProvides(appMeasurementModule.providesSubsriber());
    }

    @Override // com.google.firebase.inappmessaging.dagger.internal.Factory, com.google.firebase.inappmessaging.dagger.internal.Provider, p5.a
    public Subscriber get() {
        return providesSubsriber(this.module);
    }
}
