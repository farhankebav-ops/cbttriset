package com.google.firebase.inappmessaging.internal.injection.modules;

import com.google.firebase.FirebaseApp;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.inappmessaging.dagger.internal.DaggerGenerated;
import com.google.firebase.inappmessaging.dagger.internal.Factory;
import com.google.firebase.inappmessaging.dagger.internal.Preconditions;
import com.google.firebase.inappmessaging.dagger.internal.QualifierMetadata;
import com.google.firebase.inappmessaging.dagger.internal.ScopeMetadata;
import com.google.firebase.inappmessaging.internal.DeveloperListenerManager;
import com.google.firebase.inappmessaging.internal.MetricsLoggerClient;
import com.google.firebase.inappmessaging.internal.time.Clock;
import com.google.firebase.installations.FirebaseInstallationsApi;
import java.util.concurrent.Executor;
import m0.h;
import p5.a;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
@QualifierMetadata({"com.google.firebase.annotations.concurrent.Blocking"})
@ScopeMetadata("com.google.firebase.inappmessaging.internal.injection.scopes.FirebaseAppScope")
@DaggerGenerated
public final class TransportClientModule_ProvidesMetricsLoggerClientFactory implements Factory<MetricsLoggerClient> {
    private final a analyticsConnectorProvider;
    private final a appProvider;
    private final a blockingExecutorProvider;
    private final a clockProvider;
    private final a developerListenerManagerProvider;
    private final a firebaseInstallationsProvider;
    private final a transportFactoryProvider;

    public TransportClientModule_ProvidesMetricsLoggerClientFactory(a aVar, a aVar2, a aVar3, a aVar4, a aVar5, a aVar6, a aVar7) {
        this.appProvider = aVar;
        this.transportFactoryProvider = aVar2;
        this.analyticsConnectorProvider = aVar3;
        this.firebaseInstallationsProvider = aVar4;
        this.clockProvider = aVar5;
        this.developerListenerManagerProvider = aVar6;
        this.blockingExecutorProvider = aVar7;
    }

    public static TransportClientModule_ProvidesMetricsLoggerClientFactory create(a aVar, a aVar2, a aVar3, a aVar4, a aVar5, a aVar6, a aVar7) {
        return new TransportClientModule_ProvidesMetricsLoggerClientFactory(aVar, aVar2, aVar3, aVar4, aVar5, aVar6, aVar7);
    }

    public static MetricsLoggerClient providesMetricsLoggerClient(FirebaseApp firebaseApp, h hVar, AnalyticsConnector analyticsConnector, FirebaseInstallationsApi firebaseInstallationsApi, Clock clock, DeveloperListenerManager developerListenerManager, Executor executor) {
        return (MetricsLoggerClient) Preconditions.checkNotNullFromProvides(TransportClientModule.providesMetricsLoggerClient(firebaseApp, hVar, analyticsConnector, firebaseInstallationsApi, clock, developerListenerManager, executor));
    }

    @Override // com.google.firebase.inappmessaging.dagger.internal.Factory, com.google.firebase.inappmessaging.dagger.internal.Provider, p5.a
    public MetricsLoggerClient get() {
        return providesMetricsLoggerClient((FirebaseApp) this.appProvider.get(), (h) this.transportFactoryProvider.get(), (AnalyticsConnector) this.analyticsConnectorProvider.get(), (FirebaseInstallationsApi) this.firebaseInstallationsProvider.get(), (Clock) this.clockProvider.get(), (DeveloperListenerManager) this.developerListenerManagerProvider.get(), (Executor) this.blockingExecutorProvider.get());
    }
}
