package com.google.firebase.inappmessaging.internal.injection.modules;

import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.inappmessaging.dagger.internal.DaggerGenerated;
import com.google.firebase.inappmessaging.dagger.internal.Factory;
import com.google.firebase.inappmessaging.dagger.internal.Preconditions;
import com.google.firebase.inappmessaging.dagger.internal.QualifierMetadata;
import com.google.firebase.inappmessaging.dagger.internal.ScopeMetadata;
import com.google.firebase.inappmessaging.internal.AnalyticsEventsManager;
import p5.a;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
@QualifierMetadata
@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
public final class AnalyticsEventsModule_ProvidesAnalyticsEventsManagerFactory implements Factory<AnalyticsEventsManager> {
    private final a analyticsConnectorProvider;
    private final AnalyticsEventsModule module;

    public AnalyticsEventsModule_ProvidesAnalyticsEventsManagerFactory(AnalyticsEventsModule analyticsEventsModule, a aVar) {
        this.module = analyticsEventsModule;
        this.analyticsConnectorProvider = aVar;
    }

    public static AnalyticsEventsModule_ProvidesAnalyticsEventsManagerFactory create(AnalyticsEventsModule analyticsEventsModule, a aVar) {
        return new AnalyticsEventsModule_ProvidesAnalyticsEventsManagerFactory(analyticsEventsModule, aVar);
    }

    public static AnalyticsEventsManager providesAnalyticsEventsManager(AnalyticsEventsModule analyticsEventsModule, AnalyticsConnector analyticsConnector) {
        return (AnalyticsEventsManager) Preconditions.checkNotNullFromProvides(analyticsEventsModule.providesAnalyticsEventsManager(analyticsConnector));
    }

    @Override // com.google.firebase.inappmessaging.dagger.internal.Factory, com.google.firebase.inappmessaging.dagger.internal.Provider, p5.a
    public AnalyticsEventsManager get() {
        return providesAnalyticsEventsManager(this.module, (AnalyticsConnector) this.analyticsConnectorProvider.get());
    }
}
