package com.google.firebase.concurrent;

import com.google.firebase.inject.Provider;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.remoteconfig.RemoteConfigComponent;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class g implements Provider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5553a;

    public /* synthetic */ g(int i2) {
        this.f5553a = i2;
    }

    @Override // com.google.firebase.inject.Provider
    public final Object get() {
        switch (this.f5553a) {
            case 0:
                return ExecutorsRegistrar.lambda$static$0();
            case 1:
                return ExecutorsRegistrar.lambda$static$1();
            case 2:
                return ExecutorsRegistrar.lambda$static$2();
            case 3:
                return ExecutorsRegistrar.lambda$static$3();
            case 4:
                return FirebaseMessaging.lambda$clearTransportFactoryForTest$12();
            case 5:
                return FirebaseMessaging.lambda$static$0();
            default:
                return RemoteConfigComponent.lambda$getFetchHandler$0();
        }
    }
}
