package com.google.firebase.inappmessaging.display.internal.injection.modules;

import android.app.Application;
import com.bumptech.glide.RequestManager;
import com.google.firebase.inappmessaging.display.dagger.internal.DaggerGenerated;
import com.google.firebase.inappmessaging.display.dagger.internal.Factory;
import com.google.firebase.inappmessaging.display.dagger.internal.Preconditions;
import com.google.firebase.inappmessaging.display.dagger.internal.QualifierMetadata;
import com.google.firebase.inappmessaging.display.dagger.internal.ScopeMetadata;
import p5.a;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
@QualifierMetadata
@DaggerGenerated
@ScopeMetadata("com.google.firebase.inappmessaging.display.internal.injection.scopes.FirebaseAppScope")
public final class GlideModule_ProvidesGlideRequestManagerFactory implements Factory<RequestManager> {
    private final a applicationProvider;
    private final GlideModule module;

    public GlideModule_ProvidesGlideRequestManagerFactory(GlideModule glideModule, a aVar) {
        this.module = glideModule;
        this.applicationProvider = aVar;
    }

    public static GlideModule_ProvidesGlideRequestManagerFactory create(GlideModule glideModule, a aVar) {
        return new GlideModule_ProvidesGlideRequestManagerFactory(glideModule, aVar);
    }

    public static RequestManager providesGlideRequestManager(GlideModule glideModule, Application application) {
        return (RequestManager) Preconditions.checkNotNullFromProvides(glideModule.providesGlideRequestManager(application));
    }

    @Override // com.google.firebase.inappmessaging.display.dagger.internal.Factory, com.google.firebase.inappmessaging.display.dagger.internal.Provider, p5.a
    public RequestManager get() {
        return providesGlideRequestManager(this.module, (Application) this.applicationProvider.get());
    }
}
