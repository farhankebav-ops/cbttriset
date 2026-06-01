package com.google.firebase.inappmessaging.internal;

import com.google.firebase.FirebaseApp;
import com.google.firebase.events.Subscriber;
import com.google.firebase.inappmessaging.dagger.internal.DaggerGenerated;
import com.google.firebase.inappmessaging.dagger.internal.Factory;
import com.google.firebase.inappmessaging.dagger.internal.QualifierMetadata;
import com.google.firebase.inappmessaging.dagger.internal.ScopeMetadata;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
@QualifierMetadata
@ScopeMetadata
@DaggerGenerated
public final class DataCollectionHelper_Factory implements Factory<DataCollectionHelper> {
    private final p5.a firebaseAppProvider;
    private final p5.a firebaseEventsSubscriberProvider;
    private final p5.a sharedPreferencesUtilsProvider;

    public DataCollectionHelper_Factory(p5.a aVar, p5.a aVar2, p5.a aVar3) {
        this.firebaseAppProvider = aVar;
        this.sharedPreferencesUtilsProvider = aVar2;
        this.firebaseEventsSubscriberProvider = aVar3;
    }

    public static DataCollectionHelper_Factory create(p5.a aVar, p5.a aVar2, p5.a aVar3) {
        return new DataCollectionHelper_Factory(aVar, aVar2, aVar3);
    }

    public static DataCollectionHelper newInstance(FirebaseApp firebaseApp, SharedPreferencesUtils sharedPreferencesUtils, Subscriber subscriber) {
        return new DataCollectionHelper(firebaseApp, sharedPreferencesUtils, subscriber);
    }

    @Override // com.google.firebase.inappmessaging.dagger.internal.Factory, com.google.firebase.inappmessaging.dagger.internal.Provider, p5.a
    public DataCollectionHelper get() {
        return newInstance((FirebaseApp) this.firebaseAppProvider.get(), (SharedPreferencesUtils) this.sharedPreferencesUtilsProvider.get(), (Subscriber) this.firebaseEventsSubscriberProvider.get());
    }
}
