package com.google.firebase.inappmessaging.internal.injection.modules;

import android.app.Application;
import com.google.firebase.inappmessaging.dagger.internal.DaggerGenerated;
import com.google.firebase.inappmessaging.dagger.internal.Factory;
import com.google.firebase.inappmessaging.dagger.internal.Preconditions;
import com.google.firebase.inappmessaging.dagger.internal.QualifierMetadata;
import com.google.firebase.inappmessaging.dagger.internal.ScopeMetadata;
import com.google.firebase.inappmessaging.internal.ApiClient;
import com.google.firebase.inappmessaging.internal.ProviderInstaller;
import p5.a;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
@QualifierMetadata
@ScopeMetadata("com.google.firebase.inappmessaging.internal.injection.scopes.FirebaseAppScope")
@DaggerGenerated
public final class ApiClientModule_ProvidesApiClientFactory implements Factory<ApiClient> {
    private final a applicationProvider;
    private final a grpcClientProvider;
    private final ApiClientModule module;
    private final a providerInstallerProvider;

    public ApiClientModule_ProvidesApiClientFactory(ApiClientModule apiClientModule, a aVar, a aVar2, a aVar3) {
        this.module = apiClientModule;
        this.grpcClientProvider = aVar;
        this.applicationProvider = aVar2;
        this.providerInstallerProvider = aVar3;
    }

    public static ApiClientModule_ProvidesApiClientFactory create(ApiClientModule apiClientModule, a aVar, a aVar2, a aVar3) {
        return new ApiClientModule_ProvidesApiClientFactory(apiClientModule, aVar, aVar2, aVar3);
    }

    public static ApiClient providesApiClient(ApiClientModule apiClientModule, a aVar, Application application, ProviderInstaller providerInstaller) {
        return (ApiClient) Preconditions.checkNotNullFromProvides(apiClientModule.providesApiClient(aVar, application, providerInstaller));
    }

    @Override // com.google.firebase.inappmessaging.dagger.internal.Factory, com.google.firebase.inappmessaging.dagger.internal.Provider, p5.a
    public ApiClient get() {
        return providesApiClient(this.module, this.grpcClientProvider, (Application) this.applicationProvider.get(), (ProviderInstaller) this.providerInstallerProvider.get());
    }
}
