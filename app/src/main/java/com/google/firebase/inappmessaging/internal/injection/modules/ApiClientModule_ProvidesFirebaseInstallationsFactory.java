package com.google.firebase.inappmessaging.internal.injection.modules;

import com.google.firebase.inappmessaging.dagger.internal.DaggerGenerated;
import com.google.firebase.inappmessaging.dagger.internal.Factory;
import com.google.firebase.inappmessaging.dagger.internal.Preconditions;
import com.google.firebase.inappmessaging.dagger.internal.QualifierMetadata;
import com.google.firebase.inappmessaging.dagger.internal.ScopeMetadata;
import com.google.firebase.installations.FirebaseInstallationsApi;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
@QualifierMetadata
@ScopeMetadata
@DaggerGenerated
public final class ApiClientModule_ProvidesFirebaseInstallationsFactory implements Factory<FirebaseInstallationsApi> {
    private final ApiClientModule module;

    public ApiClientModule_ProvidesFirebaseInstallationsFactory(ApiClientModule apiClientModule) {
        this.module = apiClientModule;
    }

    public static ApiClientModule_ProvidesFirebaseInstallationsFactory create(ApiClientModule apiClientModule) {
        return new ApiClientModule_ProvidesFirebaseInstallationsFactory(apiClientModule);
    }

    public static FirebaseInstallationsApi providesFirebaseInstallations(ApiClientModule apiClientModule) {
        return (FirebaseInstallationsApi) Preconditions.checkNotNullFromProvides(apiClientModule.providesFirebaseInstallations());
    }

    @Override // com.google.firebase.inappmessaging.dagger.internal.Factory, com.google.firebase.inappmessaging.dagger.internal.Provider, p5.a
    public FirebaseInstallationsApi get() {
        return providesFirebaseInstallations(this.module);
    }
}
