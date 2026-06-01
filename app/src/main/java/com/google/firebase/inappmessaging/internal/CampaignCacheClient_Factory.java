package com.google.firebase.inappmessaging.internal;

import android.app.Application;
import com.google.firebase.inappmessaging.dagger.internal.DaggerGenerated;
import com.google.firebase.inappmessaging.dagger.internal.Factory;
import com.google.firebase.inappmessaging.dagger.internal.QualifierMetadata;
import com.google.firebase.inappmessaging.dagger.internal.ScopeMetadata;
import com.google.firebase.inappmessaging.internal.time.Clock;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
@QualifierMetadata({"com.google.firebase.inappmessaging.internal.injection.qualifiers.CampaignCache"})
@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
public final class CampaignCacheClient_Factory implements Factory<CampaignCacheClient> {
    private final p5.a applicationProvider;
    private final p5.a clockProvider;
    private final p5.a storageClientProvider;

    public CampaignCacheClient_Factory(p5.a aVar, p5.a aVar2, p5.a aVar3) {
        this.storageClientProvider = aVar;
        this.applicationProvider = aVar2;
        this.clockProvider = aVar3;
    }

    public static CampaignCacheClient_Factory create(p5.a aVar, p5.a aVar2, p5.a aVar3) {
        return new CampaignCacheClient_Factory(aVar, aVar2, aVar3);
    }

    public static CampaignCacheClient newInstance(ProtoStorageClient protoStorageClient, Application application, Clock clock) {
        return new CampaignCacheClient(protoStorageClient, application, clock);
    }

    @Override // com.google.firebase.inappmessaging.dagger.internal.Factory, com.google.firebase.inappmessaging.dagger.internal.Provider, p5.a
    public CampaignCacheClient get() {
        return newInstance((ProtoStorageClient) this.storageClientProvider.get(), (Application) this.applicationProvider.get(), (Clock) this.clockProvider.get());
    }
}
