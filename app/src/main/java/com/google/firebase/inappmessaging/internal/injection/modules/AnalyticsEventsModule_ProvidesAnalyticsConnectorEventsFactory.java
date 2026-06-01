package com.google.firebase.inappmessaging.internal.injection.modules;

import com.google.firebase.inappmessaging.dagger.internal.DaggerGenerated;
import com.google.firebase.inappmessaging.dagger.internal.Factory;
import com.google.firebase.inappmessaging.dagger.internal.Preconditions;
import com.google.firebase.inappmessaging.dagger.internal.QualifierMetadata;
import com.google.firebase.inappmessaging.dagger.internal.ScopeMetadata;
import com.google.firebase.inappmessaging.internal.AnalyticsEventsManager;
import w4.a;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
@QualifierMetadata({"com.google.firebase.inappmessaging.internal.injection.qualifiers.AnalyticsListener"})
@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
public final class AnalyticsEventsModule_ProvidesAnalyticsConnectorEventsFactory implements Factory<a> {
    private final p5.a analyticsEventsManagerProvider;
    private final AnalyticsEventsModule module;

    public AnalyticsEventsModule_ProvidesAnalyticsConnectorEventsFactory(AnalyticsEventsModule analyticsEventsModule, p5.a aVar) {
        this.module = analyticsEventsModule;
        this.analyticsEventsManagerProvider = aVar;
    }

    public static AnalyticsEventsModule_ProvidesAnalyticsConnectorEventsFactory create(AnalyticsEventsModule analyticsEventsModule, p5.a aVar) {
        return new AnalyticsEventsModule_ProvidesAnalyticsConnectorEventsFactory(analyticsEventsModule, aVar);
    }

    public static a providesAnalyticsConnectorEvents(AnalyticsEventsModule analyticsEventsModule, AnalyticsEventsManager analyticsEventsManager) {
        return (a) Preconditions.checkNotNullFromProvides(analyticsEventsModule.providesAnalyticsConnectorEvents(analyticsEventsManager));
    }

    @Override // com.google.firebase.inappmessaging.dagger.internal.Factory, com.google.firebase.inappmessaging.dagger.internal.Provider, p5.a
    public a get() {
        return providesAnalyticsConnectorEvents(this.module, (AnalyticsEventsManager) this.analyticsEventsManagerProvider.get());
    }
}
