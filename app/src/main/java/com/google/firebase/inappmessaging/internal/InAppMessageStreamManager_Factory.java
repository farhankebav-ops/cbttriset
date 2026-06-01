package com.google.firebase.inappmessaging.internal;

import com.google.firebase.inappmessaging.dagger.internal.DaggerGenerated;
import com.google.firebase.inappmessaging.dagger.internal.Factory;
import com.google.firebase.inappmessaging.dagger.internal.QualifierMetadata;
import com.google.firebase.inappmessaging.dagger.internal.ScopeMetadata;
import com.google.firebase.inappmessaging.internal.time.Clock;
import com.google.firebase.inappmessaging.model.RateLimit;
import com.google.firebase.installations.FirebaseInstallationsApi;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
@QualifierMetadata({"com.google.firebase.inappmessaging.internal.injection.qualifiers.AppForeground", "com.google.firebase.inappmessaging.internal.injection.qualifiers.ProgrammaticTrigger", "com.google.firebase.annotations.concurrent.Blocking"})
@ScopeMetadata("com.google.firebase.inappmessaging.internal.injection.scopes.FirebaseAppScope")
@DaggerGenerated
public final class InAppMessageStreamManager_Factory implements Factory<InAppMessageStreamManager> {
    private final p5.a abtIntegrationHelperProvider;
    private final p5.a analyticsEventsManagerProvider;
    private final p5.a apiClientProvider;
    private final p5.a appForegroundEventFlowableProvider;
    private final p5.a appForegroundRateLimitProvider;
    private final p5.a blockingExecutorProvider;
    private final p5.a campaignCacheClientProvider;
    private final p5.a clockProvider;
    private final p5.a dataCollectionHelperProvider;
    private final p5.a firebaseInstallationsProvider;
    private final p5.a impressionStorageClientProvider;
    private final p5.a programmaticTriggerEventFlowableProvider;
    private final p5.a rateLimiterClientProvider;
    private final p5.a schedulersProvider;
    private final p5.a testDeviceHelperProvider;

    public InAppMessageStreamManager_Factory(p5.a aVar, p5.a aVar2, p5.a aVar3, p5.a aVar4, p5.a aVar5, p5.a aVar6, p5.a aVar7, p5.a aVar8, p5.a aVar9, p5.a aVar10, p5.a aVar11, p5.a aVar12, p5.a aVar13, p5.a aVar14, p5.a aVar15) {
        this.appForegroundEventFlowableProvider = aVar;
        this.programmaticTriggerEventFlowableProvider = aVar2;
        this.campaignCacheClientProvider = aVar3;
        this.clockProvider = aVar4;
        this.apiClientProvider = aVar5;
        this.analyticsEventsManagerProvider = aVar6;
        this.schedulersProvider = aVar7;
        this.impressionStorageClientProvider = aVar8;
        this.rateLimiterClientProvider = aVar9;
        this.appForegroundRateLimitProvider = aVar10;
        this.testDeviceHelperProvider = aVar11;
        this.firebaseInstallationsProvider = aVar12;
        this.dataCollectionHelperProvider = aVar13;
        this.abtIntegrationHelperProvider = aVar14;
        this.blockingExecutorProvider = aVar15;
    }

    public static InAppMessageStreamManager_Factory create(p5.a aVar, p5.a aVar2, p5.a aVar3, p5.a aVar4, p5.a aVar5, p5.a aVar6, p5.a aVar7, p5.a aVar8, p5.a aVar9, p5.a aVar10, p5.a aVar11, p5.a aVar12, p5.a aVar13, p5.a aVar14, p5.a aVar15) {
        return new InAppMessageStreamManager_Factory(aVar, aVar2, aVar3, aVar4, aVar5, aVar6, aVar7, aVar8, aVar9, aVar10, aVar11, aVar12, aVar13, aVar14, aVar15);
    }

    public static InAppMessageStreamManager newInstance(w4.a aVar, w4.a aVar2, CampaignCacheClient campaignCacheClient, Clock clock, ApiClient apiClient, AnalyticsEventsManager analyticsEventsManager, Schedulers schedulers, ImpressionStorageClient impressionStorageClient, RateLimiterClient rateLimiterClient, RateLimit rateLimit, TestDeviceHelper testDeviceHelper, FirebaseInstallationsApi firebaseInstallationsApi, DataCollectionHelper dataCollectionHelper, AbtIntegrationHelper abtIntegrationHelper, Executor executor) {
        return new InAppMessageStreamManager(aVar, aVar2, campaignCacheClient, clock, apiClient, analyticsEventsManager, schedulers, impressionStorageClient, rateLimiterClient, rateLimit, testDeviceHelper, firebaseInstallationsApi, dataCollectionHelper, abtIntegrationHelper, executor);
    }

    @Override // com.google.firebase.inappmessaging.dagger.internal.Factory, com.google.firebase.inappmessaging.dagger.internal.Provider, p5.a
    public InAppMessageStreamManager get() {
        return newInstance((w4.a) this.appForegroundEventFlowableProvider.get(), (w4.a) this.programmaticTriggerEventFlowableProvider.get(), (CampaignCacheClient) this.campaignCacheClientProvider.get(), (Clock) this.clockProvider.get(), (ApiClient) this.apiClientProvider.get(), (AnalyticsEventsManager) this.analyticsEventsManagerProvider.get(), (Schedulers) this.schedulersProvider.get(), (ImpressionStorageClient) this.impressionStorageClientProvider.get(), (RateLimiterClient) this.rateLimiterClientProvider.get(), (RateLimit) this.appForegroundRateLimitProvider.get(), (TestDeviceHelper) this.testDeviceHelperProvider.get(), (FirebaseInstallationsApi) this.firebaseInstallationsProvider.get(), (DataCollectionHelper) this.dataCollectionHelperProvider.get(), (AbtIntegrationHelper) this.abtIntegrationHelperProvider.get(), (Executor) this.blockingExecutorProvider.get());
    }
}
