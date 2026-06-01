package com.google.firebase.remoteconfig;

import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class c implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5718a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f5719b;

    public /* synthetic */ c(Object obj, int i2) {
        this.f5718a = i2;
        this.f5719b = obj;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        switch (this.f5718a) {
            case 0:
                return ((FirebaseRemoteConfig) this.f5719b).lambda$reset$6();
            case 1:
                return ((FirebaseRemoteConfig) this.f5719b).getInfo();
            default:
                return ((RemoteConfigComponent) this.f5719b).getDefault();
        }
    }
}
