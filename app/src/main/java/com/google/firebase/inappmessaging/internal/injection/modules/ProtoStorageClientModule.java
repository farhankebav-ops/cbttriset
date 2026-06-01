package com.google.firebase.inappmessaging.internal.injection.modules;

import android.app.Application;
import com.google.firebase.inappmessaging.dagger.Module;
import com.google.firebase.inappmessaging.dagger.Provides;
import com.google.firebase.inappmessaging.internal.ProtoStorageClient;
import com.google.firebase.inappmessaging.internal.injection.qualifiers.CampaignCache;
import com.google.firebase.inappmessaging.internal.injection.qualifiers.ImpressionStore;
import com.google.firebase.inappmessaging.internal.injection.qualifiers.RateLimit;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
@Module
public class ProtoStorageClientModule {
    public static final String CAMPAIGN_CACHE_FILE = "fiam_eligible_campaigns_cache_file";
    public static final String IMPRESSIONS_STORE_FILE = "fiam_impressions_store_file";
    public static final String RATE_LIMIT_STORE_FILE = "rate_limit_store_file";

    @Provides
    @CampaignCache
    public ProtoStorageClient providesProtoStorageClientForCampaign(Application application) {
        return new ProtoStorageClient(application, CAMPAIGN_CACHE_FILE);
    }

    @Provides
    @ImpressionStore
    public ProtoStorageClient providesProtoStorageClientForImpressionStore(Application application) {
        return new ProtoStorageClient(application, IMPRESSIONS_STORE_FILE);
    }

    @Provides
    @RateLimit
    public ProtoStorageClient providesProtoStorageClientForLimiterStore(Application application) {
        return new ProtoStorageClient(application, RATE_LIMIT_STORE_FILE);
    }
}
