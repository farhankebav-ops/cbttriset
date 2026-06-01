package com.google.firebase.inappmessaging.display.internal;

import com.bumptech.glide.RequestManager;
import com.google.firebase.inappmessaging.display.dagger.internal.DaggerGenerated;
import com.google.firebase.inappmessaging.display.dagger.internal.Factory;
import com.google.firebase.inappmessaging.display.dagger.internal.QualifierMetadata;
import com.google.firebase.inappmessaging.display.dagger.internal.ScopeMetadata;
import p5.a;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
@QualifierMetadata
@DaggerGenerated
@ScopeMetadata("com.google.firebase.inappmessaging.display.internal.injection.scopes.FirebaseAppScope")
public final class FiamImageLoader_Factory implements Factory<FiamImageLoader> {
    private final a requestManagerProvider;

    public FiamImageLoader_Factory(a aVar) {
        this.requestManagerProvider = aVar;
    }

    public static FiamImageLoader_Factory create(a aVar) {
        return new FiamImageLoader_Factory(aVar);
    }

    public static FiamImageLoader newInstance(RequestManager requestManager) {
        return new FiamImageLoader(requestManager);
    }

    @Override // com.google.firebase.inappmessaging.display.dagger.internal.Factory, com.google.firebase.inappmessaging.display.dagger.internal.Provider, p5.a
    public FiamImageLoader get() {
        return newInstance((RequestManager) this.requestManagerProvider.get());
    }
}
