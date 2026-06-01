package com.google.firebase.inappmessaging.internal.injection.modules;

import com.google.firebase.inappmessaging.dagger.internal.DaggerGenerated;
import com.google.firebase.inappmessaging.dagger.internal.Factory;
import com.google.firebase.inappmessaging.dagger.internal.Preconditions;
import com.google.firebase.inappmessaging.dagger.internal.QualifierMetadata;
import com.google.firebase.inappmessaging.dagger.internal.ScopeMetadata;
import i4.a1;
import i4.e;
import p5.a;
import r2.p;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
@QualifierMetadata
@ScopeMetadata("com.google.firebase.inappmessaging.internal.injection.scopes.FirebaseAppScope")
@DaggerGenerated
public final class GrpcClientModule_ProvidesInAppMessagingSdkServingStubFactory implements Factory<p> {
    private final a channelProvider;
    private final a metadataProvider;
    private final GrpcClientModule module;

    public GrpcClientModule_ProvidesInAppMessagingSdkServingStubFactory(GrpcClientModule grpcClientModule, a aVar, a aVar2) {
        this.module = grpcClientModule;
        this.channelProvider = aVar;
        this.metadataProvider = aVar2;
    }

    public static GrpcClientModule_ProvidesInAppMessagingSdkServingStubFactory create(GrpcClientModule grpcClientModule, a aVar, a aVar2) {
        return new GrpcClientModule_ProvidesInAppMessagingSdkServingStubFactory(grpcClientModule, aVar, aVar2);
    }

    public static p providesInAppMessagingSdkServingStub(GrpcClientModule grpcClientModule, e eVar, a1 a1Var) {
        return (p) Preconditions.checkNotNullFromProvides(grpcClientModule.providesInAppMessagingSdkServingStub(eVar, a1Var));
    }

    @Override // com.google.firebase.inappmessaging.dagger.internal.Factory, com.google.firebase.inappmessaging.dagger.internal.Provider, p5.a
    public p get() {
        return providesInAppMessagingSdkServingStub(this.module, (e) this.channelProvider.get(), (a1) this.metadataProvider.get());
    }
}
