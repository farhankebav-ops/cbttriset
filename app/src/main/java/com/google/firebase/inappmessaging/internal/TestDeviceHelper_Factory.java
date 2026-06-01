package com.google.firebase.inappmessaging.internal;

import com.google.firebase.inappmessaging.dagger.internal.DaggerGenerated;
import com.google.firebase.inappmessaging.dagger.internal.Factory;
import com.google.firebase.inappmessaging.dagger.internal.QualifierMetadata;
import com.google.firebase.inappmessaging.dagger.internal.ScopeMetadata;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
@QualifierMetadata
@ScopeMetadata
@DaggerGenerated
public final class TestDeviceHelper_Factory implements Factory<TestDeviceHelper> {
    private final p5.a sharedPreferencesUtilsProvider;

    public TestDeviceHelper_Factory(p5.a aVar) {
        this.sharedPreferencesUtilsProvider = aVar;
    }

    public static TestDeviceHelper_Factory create(p5.a aVar) {
        return new TestDeviceHelper_Factory(aVar);
    }

    public static TestDeviceHelper newInstance(SharedPreferencesUtils sharedPreferencesUtils) {
        return new TestDeviceHelper(sharedPreferencesUtils);
    }

    @Override // com.google.firebase.inappmessaging.dagger.internal.Factory, com.google.firebase.inappmessaging.dagger.internal.Provider, p5.a
    public TestDeviceHelper get() {
        return newInstance((SharedPreferencesUtils) this.sharedPreferencesUtilsProvider.get());
    }
}
