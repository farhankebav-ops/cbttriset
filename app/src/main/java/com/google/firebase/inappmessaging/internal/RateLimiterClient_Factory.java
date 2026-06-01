package com.google.firebase.inappmessaging.internal;

import com.google.firebase.inappmessaging.dagger.internal.DaggerGenerated;
import com.google.firebase.inappmessaging.dagger.internal.Factory;
import com.google.firebase.inappmessaging.dagger.internal.QualifierMetadata;
import com.google.firebase.inappmessaging.dagger.internal.ScopeMetadata;
import com.google.firebase.inappmessaging.internal.time.Clock;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
@QualifierMetadata({"com.google.firebase.inappmessaging.internal.injection.qualifiers.RateLimit"})
@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
public final class RateLimiterClient_Factory implements Factory<RateLimiterClient> {
    private final p5.a clockProvider;
    private final p5.a storageClientProvider;

    public RateLimiterClient_Factory(p5.a aVar, p5.a aVar2) {
        this.storageClientProvider = aVar;
        this.clockProvider = aVar2;
    }

    public static RateLimiterClient_Factory create(p5.a aVar, p5.a aVar2) {
        return new RateLimiterClient_Factory(aVar, aVar2);
    }

    public static RateLimiterClient newInstance(ProtoStorageClient protoStorageClient, Clock clock) {
        return new RateLimiterClient(protoStorageClient, clock);
    }

    @Override // com.google.firebase.inappmessaging.dagger.internal.Factory, com.google.firebase.inappmessaging.dagger.internal.Provider, p5.a
    public RateLimiterClient get() {
        return newInstance((ProtoStorageClient) this.storageClientProvider.get(), (Clock) this.clockProvider.get());
    }
}
