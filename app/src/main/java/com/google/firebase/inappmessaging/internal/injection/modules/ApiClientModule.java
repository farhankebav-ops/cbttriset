package com.google.firebase.inappmessaging.internal.injection.modules;

import android.app.Application;
import com.google.firebase.FirebaseApp;
import com.google.firebase.events.Subscriber;
import com.google.firebase.inappmessaging.dagger.Module;
import com.google.firebase.inappmessaging.dagger.Provides;
import com.google.firebase.inappmessaging.internal.ApiClient;
import com.google.firebase.inappmessaging.internal.DataCollectionHelper;
import com.google.firebase.inappmessaging.internal.ProviderInstaller;
import com.google.firebase.inappmessaging.internal.SharedPreferencesUtils;
import com.google.firebase.inappmessaging.internal.TestDeviceHelper;
import com.google.firebase.inappmessaging.internal.injection.scopes.FirebaseAppScope;
import com.google.firebase.inappmessaging.internal.time.Clock;
import com.google.firebase.installations.FirebaseInstallationsApi;
import p5.a;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
@Module
public class ApiClientModule {
    private final Clock clock;
    private final FirebaseApp firebaseApp;
    private final FirebaseInstallationsApi firebaseInstallations;

    public ApiClientModule(FirebaseApp firebaseApp, FirebaseInstallationsApi firebaseInstallationsApi, Clock clock) {
        this.firebaseApp = firebaseApp;
        this.firebaseInstallations = firebaseInstallationsApi;
        this.clock = clock;
    }

    @Provides
    @FirebaseAppScope
    public ApiClient providesApiClient(a aVar, Application application, ProviderInstaller providerInstaller) {
        return new ApiClient(aVar, this.firebaseApp, application, this.clock, providerInstaller);
    }

    @Provides
    public DataCollectionHelper providesDataCollectionHelper(SharedPreferencesUtils sharedPreferencesUtils, Subscriber subscriber) {
        return new DataCollectionHelper(this.firebaseApp, sharedPreferencesUtils, subscriber);
    }

    @Provides
    public FirebaseApp providesFirebaseApp() {
        return this.firebaseApp;
    }

    @Provides
    public FirebaseInstallationsApi providesFirebaseInstallations() {
        return this.firebaseInstallations;
    }

    @Provides
    public SharedPreferencesUtils providesSharedPreferencesUtils() {
        return new SharedPreferencesUtils(this.firebaseApp);
    }

    @Provides
    public TestDeviceHelper providesTestDeviceHelper(SharedPreferencesUtils sharedPreferencesUtils) {
        return new TestDeviceHelper(sharedPreferencesUtils);
    }
}
