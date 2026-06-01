package com.google.firebase.inappmessaging.internal.injection.modules;

import android.app.Application;
import com.google.firebase.inappmessaging.dagger.internal.DaggerGenerated;
import com.google.firebase.inappmessaging.dagger.internal.Factory;
import com.google.firebase.inappmessaging.dagger.internal.Preconditions;
import com.google.firebase.inappmessaging.dagger.internal.QualifierMetadata;
import com.google.firebase.inappmessaging.dagger.internal.ScopeMetadata;
import com.google.firebase.inappmessaging.internal.ProtoStorageClient;
import p5.a;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
@QualifierMetadata({"com.google.firebase.inappmessaging.internal.injection.qualifiers.RateLimit"})
@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
public final class ProtoStorageClientModule_ProvidesProtoStorageClientForLimiterStoreFactory implements Factory<ProtoStorageClient> {
    private final a applicationProvider;
    private final ProtoStorageClientModule module;

    public ProtoStorageClientModule_ProvidesProtoStorageClientForLimiterStoreFactory(ProtoStorageClientModule protoStorageClientModule, a aVar) {
        this.module = protoStorageClientModule;
        this.applicationProvider = aVar;
    }

    public static ProtoStorageClientModule_ProvidesProtoStorageClientForLimiterStoreFactory create(ProtoStorageClientModule protoStorageClientModule, a aVar) {
        return new ProtoStorageClientModule_ProvidesProtoStorageClientForLimiterStoreFactory(protoStorageClientModule, aVar);
    }

    public static ProtoStorageClient providesProtoStorageClientForLimiterStore(ProtoStorageClientModule protoStorageClientModule, Application application) {
        return (ProtoStorageClient) Preconditions.checkNotNullFromProvides(protoStorageClientModule.providesProtoStorageClientForLimiterStore(application));
    }

    @Override // com.google.firebase.inappmessaging.dagger.internal.Factory, com.google.firebase.inappmessaging.dagger.internal.Provider, p5.a
    public ProtoStorageClient get() {
        return providesProtoStorageClientForLimiterStore(this.module, (Application) this.applicationProvider.get());
    }
}
