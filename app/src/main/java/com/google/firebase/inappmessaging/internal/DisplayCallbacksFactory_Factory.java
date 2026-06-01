package com.google.firebase.inappmessaging.internal;

import com.google.firebase.inappmessaging.dagger.internal.DaggerGenerated;
import com.google.firebase.inappmessaging.dagger.internal.Factory;
import com.google.firebase.inappmessaging.dagger.internal.QualifierMetadata;
import com.google.firebase.inappmessaging.dagger.internal.ScopeMetadata;
import com.google.firebase.inappmessaging.internal.time.Clock;
import com.google.firebase.inappmessaging.model.RateLimit;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
@QualifierMetadata({"com.google.firebase.inappmessaging.internal.injection.qualifiers.AppForeground"})
@ScopeMetadata
@DaggerGenerated
public final class DisplayCallbacksFactory_Factory implements Factory<DisplayCallbacksFactory> {
    private final p5.a appForegroundRateLimitProvider;
    private final p5.a campaignCacheClientProvider;
    private final p5.a clockProvider;
    private final p5.a dataCollectionHelperProvider;
    private final p5.a impressionStorageClientProvider;
    private final p5.a metricsLoggerClientProvider;
    private final p5.a rateLimiterClientProvider;
    private final p5.a schedulersProvider;

    public DisplayCallbacksFactory_Factory(p5.a aVar, p5.a aVar2, p5.a aVar3, p5.a aVar4, p5.a aVar5, p5.a aVar6, p5.a aVar7, p5.a aVar8) {
        this.impressionStorageClientProvider = aVar;
        this.clockProvider = aVar2;
        this.schedulersProvider = aVar3;
        this.rateLimiterClientProvider = aVar4;
        this.campaignCacheClientProvider = aVar5;
        this.appForegroundRateLimitProvider = aVar6;
        this.metricsLoggerClientProvider = aVar7;
        this.dataCollectionHelperProvider = aVar8;
    }

    public static DisplayCallbacksFactory_Factory create(p5.a aVar, p5.a aVar2, p5.a aVar3, p5.a aVar4, p5.a aVar5, p5.a aVar6, p5.a aVar7, p5.a aVar8) {
        return new DisplayCallbacksFactory_Factory(aVar, aVar2, aVar3, aVar4, aVar5, aVar6, aVar7, aVar8);
    }

    public static DisplayCallbacksFactory newInstance(ImpressionStorageClient impressionStorageClient, Clock clock, Schedulers schedulers, RateLimiterClient rateLimiterClient, CampaignCacheClient campaignCacheClient, RateLimit rateLimit, MetricsLoggerClient metricsLoggerClient, DataCollectionHelper dataCollectionHelper) {
        return new DisplayCallbacksFactory(impressionStorageClient, clock, schedulers, rateLimiterClient, campaignCacheClient, rateLimit, metricsLoggerClient, dataCollectionHelper);
    }

    @Override // com.google.firebase.inappmessaging.dagger.internal.Factory, com.google.firebase.inappmessaging.dagger.internal.Provider, p5.a
    public DisplayCallbacksFactory get() {
        return newInstance((ImpressionStorageClient) this.impressionStorageClientProvider.get(), (Clock) this.clockProvider.get(), (Schedulers) this.schedulersProvider.get(), (RateLimiterClient) this.rateLimiterClientProvider.get(), (CampaignCacheClient) this.campaignCacheClientProvider.get(), (RateLimit) this.appForegroundRateLimitProvider.get(), (MetricsLoggerClient) this.metricsLoggerClientProvider.get(), (DataCollectionHelper) this.dataCollectionHelperProvider.get());
    }
}
