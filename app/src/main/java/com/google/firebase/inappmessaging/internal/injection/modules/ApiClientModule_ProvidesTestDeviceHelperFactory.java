package com.google.firebase.inappmessaging.internal.injection.modules;

import com.google.firebase.inappmessaging.dagger.internal.DaggerGenerated;
import com.google.firebase.inappmessaging.dagger.internal.Factory;
import com.google.firebase.inappmessaging.dagger.internal.Preconditions;
import com.google.firebase.inappmessaging.dagger.internal.QualifierMetadata;
import com.google.firebase.inappmessaging.dagger.internal.ScopeMetadata;
import com.google.firebase.inappmessaging.internal.SharedPreferencesUtils;
import com.google.firebase.inappmessaging.internal.TestDeviceHelper;
import p5.a;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
@QualifierMetadata
@ScopeMetadata
@DaggerGenerated
public final class ApiClientModule_ProvidesTestDeviceHelperFactory implements Factory<TestDeviceHelper> {
    private final ApiClientModule module;
    private final a sharedPreferencesUtilsProvider;

    public ApiClientModule_ProvidesTestDeviceHelperFactory(ApiClientModule apiClientModule, a aVar) {
        this.module = apiClientModule;
        this.sharedPreferencesUtilsProvider = aVar;
    }

    public static ApiClientModule_ProvidesTestDeviceHelperFactory create(ApiClientModule apiClientModule, a aVar) {
        return new ApiClientModule_ProvidesTestDeviceHelperFactory(apiClientModule, aVar);
    }

    public static TestDeviceHelper providesTestDeviceHelper(ApiClientModule apiClientModule, SharedPreferencesUtils sharedPreferencesUtils) {
        return (TestDeviceHelper) Preconditions.checkNotNullFromProvides(apiClientModule.providesTestDeviceHelper(sharedPreferencesUtils));
    }

    @Override // com.google.firebase.inappmessaging.dagger.internal.Factory, com.google.firebase.inappmessaging.dagger.internal.Provider, p5.a
    public TestDeviceHelper get() {
        return providesTestDeviceHelper(this.module, (SharedPreferencesUtils) this.sharedPreferencesUtilsProvider.get());
    }
}
