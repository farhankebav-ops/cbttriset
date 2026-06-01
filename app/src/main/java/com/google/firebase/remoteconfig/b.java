package com.google.firebase.remoteconfig;

import com.google.firebase.remoteconfig.internal.ConfigCacheClient;
import com.google.firebase.remoteconfig.internal.ConfigContainer;
import com.vungle.ads.internal.executor.VungleThreadPoolExecutor;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class b implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5715a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f5716b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f5717c;

    public /* synthetic */ b(int i2, Object obj, Object obj2) {
        this.f5715a = i2;
        this.f5716b = obj;
        this.f5717c = obj2;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        switch (this.f5715a) {
            case 0:
                return ((FirebaseRemoteConfig) this.f5716b).lambda$setCustomSignals$8((CustomSignals) this.f5717c);
            case 1:
                return ((FirebaseRemoteConfig) this.f5716b).lambda$setConfigSettingsAsync$5((FirebaseRemoteConfigSettings) this.f5717c);
            case 2:
                return ((ConfigCacheClient) this.f5716b).lambda$put$0((ConfigContainer) this.f5717c);
            default:
                return VungleThreadPoolExecutor.Companion.m3317getWrappedCallableWithFallback$lambda0((Callable) this.f5716b, (e6.a) this.f5717c);
        }
    }
}
