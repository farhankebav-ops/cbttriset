package com.google.firebase.inappmessaging.internal;

import com.google.firebase.inappmessaging.dagger.internal.DaggerGenerated;
import com.google.firebase.inappmessaging.dagger.internal.Factory;
import com.google.firebase.inappmessaging.dagger.internal.QualifierMetadata;
import com.google.firebase.inappmessaging.dagger.internal.ScopeMetadata;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
@QualifierMetadata({"com.google.firebase.inappmessaging.internal.injection.qualifiers.ImpressionStore"})
@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
public final class ImpressionStorageClient_Factory implements Factory<ImpressionStorageClient> {
    private final p5.a storageClientProvider;

    public ImpressionStorageClient_Factory(p5.a aVar) {
        this.storageClientProvider = aVar;
    }

    public static ImpressionStorageClient_Factory create(p5.a aVar) {
        return new ImpressionStorageClient_Factory(aVar);
    }

    public static ImpressionStorageClient newInstance(ProtoStorageClient protoStorageClient) {
        return new ImpressionStorageClient(protoStorageClient);
    }

    @Override // com.google.firebase.inappmessaging.dagger.internal.Factory, com.google.firebase.inappmessaging.dagger.internal.Provider, p5.a
    public ImpressionStorageClient get() {
        return newInstance((ProtoStorageClient) this.storageClientProvider.get());
    }
}
