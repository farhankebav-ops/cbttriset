package com.google.firebase.inappmessaging.internal.injection.modules;

import com.google.firebase.events.Subscriber;
import com.google.firebase.inappmessaging.dagger.internal.DaggerGenerated;
import com.google.firebase.inappmessaging.dagger.internal.Factory;
import com.google.firebase.inappmessaging.dagger.internal.Preconditions;
import com.google.firebase.inappmessaging.dagger.internal.QualifierMetadata;
import com.google.firebase.inappmessaging.dagger.internal.ScopeMetadata;
import com.google.firebase.inappmessaging.internal.DataCollectionHelper;
import com.google.firebase.inappmessaging.internal.SharedPreferencesUtils;
import p5.a;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
@QualifierMetadata
@ScopeMetadata
@DaggerGenerated
public final class ApiClientModule_ProvidesDataCollectionHelperFactory implements Factory<DataCollectionHelper> {
    private final a firebaseEventSubscriberProvider;
    private final ApiClientModule module;
    private final a sharedPreferencesUtilsProvider;

    public ApiClientModule_ProvidesDataCollectionHelperFactory(ApiClientModule apiClientModule, a aVar, a aVar2) {
        this.module = apiClientModule;
        this.sharedPreferencesUtilsProvider = aVar;
        this.firebaseEventSubscriberProvider = aVar2;
    }

    public static ApiClientModule_ProvidesDataCollectionHelperFactory create(ApiClientModule apiClientModule, a aVar, a aVar2) {
        return new ApiClientModule_ProvidesDataCollectionHelperFactory(apiClientModule, aVar, aVar2);
    }

    public static DataCollectionHelper providesDataCollectionHelper(ApiClientModule apiClientModule, SharedPreferencesUtils sharedPreferencesUtils, Subscriber subscriber) {
        return (DataCollectionHelper) Preconditions.checkNotNullFromProvides(apiClientModule.providesDataCollectionHelper(sharedPreferencesUtils, subscriber));
    }

    @Override // com.google.firebase.inappmessaging.dagger.internal.Factory, com.google.firebase.inappmessaging.dagger.internal.Provider, p5.a
    public DataCollectionHelper get() {
        return providesDataCollectionHelper(this.module, (SharedPreferencesUtils) this.sharedPreferencesUtilsProvider.get(), (Subscriber) this.firebaseEventSubscriberProvider.get());
    }
}
