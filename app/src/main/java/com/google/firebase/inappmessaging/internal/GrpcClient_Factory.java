package com.google.firebase.inappmessaging.internal;

import com.google.firebase.inappmessaging.dagger.internal.DaggerGenerated;
import com.google.firebase.inappmessaging.dagger.internal.Factory;
import com.google.firebase.inappmessaging.dagger.internal.QualifierMetadata;
import com.google.firebase.inappmessaging.dagger.internal.ScopeMetadata;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
@QualifierMetadata
@ScopeMetadata("com.google.firebase.inappmessaging.internal.injection.scopes.FirebaseAppScope")
@DaggerGenerated
public final class GrpcClient_Factory implements Factory<GrpcClient> {
    private final p5.a stubProvider;

    public GrpcClient_Factory(p5.a aVar) {
        this.stubProvider = aVar;
    }

    public static GrpcClient_Factory create(p5.a aVar) {
        return new GrpcClient_Factory(aVar);
    }

    public static GrpcClient newInstance(r2.p pVar) {
        return new GrpcClient(pVar);
    }

    @Override // com.google.firebase.inappmessaging.dagger.internal.Factory, com.google.firebase.inappmessaging.dagger.internal.Provider, p5.a
    public GrpcClient get() {
        return newInstance((r2.p) this.stubProvider.get());
    }
}
