package com.google.firebase.inappmessaging.internal.injection.modules;

import com.google.firebase.inappmessaging.dagger.internal.DaggerGenerated;
import com.google.firebase.inappmessaging.dagger.internal.Factory;
import com.google.firebase.inappmessaging.dagger.internal.Preconditions;
import com.google.firebase.inappmessaging.dagger.internal.QualifierMetadata;
import com.google.firebase.inappmessaging.dagger.internal.ScopeMetadata;
import i4.e;
import p5.a;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
@QualifierMetadata({"javax.inject.Named"})
@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
public final class GrpcChannelModule_ProvidesGrpcChannelFactory implements Factory<e> {
    private final a hostProvider;
    private final GrpcChannelModule module;

    public GrpcChannelModule_ProvidesGrpcChannelFactory(GrpcChannelModule grpcChannelModule, a aVar) {
        this.module = grpcChannelModule;
        this.hostProvider = aVar;
    }

    public static GrpcChannelModule_ProvidesGrpcChannelFactory create(GrpcChannelModule grpcChannelModule, a aVar) {
        return new GrpcChannelModule_ProvidesGrpcChannelFactory(grpcChannelModule, aVar);
    }

    public static e providesGrpcChannel(GrpcChannelModule grpcChannelModule, String str) {
        return (e) Preconditions.checkNotNullFromProvides(grpcChannelModule.providesGrpcChannel(str));
    }

    @Override // com.google.firebase.inappmessaging.dagger.internal.Factory, com.google.firebase.inappmessaging.dagger.internal.Provider, p5.a
    public e get() {
        return providesGrpcChannel(this.module, (String) this.hostProvider.get());
    }
}
