package com.google.firebase.sessions.settings;

import com.google.firebase.sessions.ApplicationInfo;
import com.google.firebase.sessions.dagger.internal.DaggerGenerated;
import com.google.firebase.sessions.dagger.internal.Factory;
import com.google.firebase.sessions.dagger.internal.QualifierMetadata;
import com.google.firebase.sessions.dagger.internal.ScopeMetadata;
import p5.a;
import v5.h;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata({"com.google.firebase.annotations.concurrent.Blocking"})
@DaggerGenerated
public final class RemoteSettingsFetcher_Factory implements Factory<RemoteSettingsFetcher> {
    private final a appInfoProvider;
    private final a blockingDispatcherProvider;

    public RemoteSettingsFetcher_Factory(a aVar, a aVar2) {
        this.appInfoProvider = aVar;
        this.blockingDispatcherProvider = aVar2;
    }

    public static RemoteSettingsFetcher_Factory create(a aVar, a aVar2) {
        return new RemoteSettingsFetcher_Factory(aVar, aVar2);
    }

    public static RemoteSettingsFetcher newInstance(ApplicationInfo applicationInfo, h hVar) {
        return new RemoteSettingsFetcher(applicationInfo, hVar);
    }

    @Override // com.google.firebase.sessions.dagger.internal.Factory, com.google.firebase.sessions.dagger.internal.Provider, p5.a
    public RemoteSettingsFetcher get() {
        return newInstance((ApplicationInfo) this.appInfoProvider.get(), (h) this.blockingDispatcherProvider.get());
    }
}
