package com.google.firebase.remoteconfig;

import e6.p;
import kotlin.jvm.internal.k;
import q5.x;
import r2.q;
import x5.i;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
@x5.e(c = "com.google.firebase.remoteconfig.RemoteConfigKt$configUpdates$1", f = "RemoteConfig.kt", l = {76}, m = "invokeSuspend")
public final class RemoteConfigKt$configUpdates$1 extends i implements p {
    final /* synthetic */ FirebaseRemoteConfig $this_configUpdates;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RemoteConfigKt$configUpdates$1(FirebaseRemoteConfig firebaseRemoteConfig, v5.c<? super RemoteConfigKt$configUpdates$1> cVar) {
        super(2, cVar);
        this.$this_configUpdates = firebaseRemoteConfig;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final x invokeSuspend$lambda$0(ConfigUpdateListenerRegistration configUpdateListenerRegistration) {
        configUpdateListenerRegistration.remove();
        return x.f13520a;
    }

    @Override // x5.a
    public final v5.c<x> create(Object obj, v5.c<?> cVar) {
        RemoteConfigKt$configUpdates$1 remoteConfigKt$configUpdates$1 = new RemoteConfigKt$configUpdates$1(this.$this_configUpdates, cVar);
        remoteConfigKt$configUpdates$1.L$0 = obj;
        return remoteConfigKt$configUpdates$1;
    }

    @Override // x5.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        w5.a aVar = w5.a.f17774a;
        int i2 = this.label;
        if (i2 == 0) {
            q.z0(obj);
            s6.x xVar = (s6.x) this.L$0;
            FirebaseRemoteConfig firebaseRemoteConfig = this.$this_configUpdates;
            final ConfigUpdateListenerRegistration configUpdateListenerRegistrationAddOnConfigUpdateListener = firebaseRemoteConfig.addOnConfigUpdateListener(new RemoteConfigKt$configUpdates$1$registration$1(firebaseRemoteConfig, xVar));
            k.d(configUpdateListenerRegistrationAddOnConfigUpdateListener, "addOnConfigUpdateListener(...)");
            e6.a aVar2 = new e6.a() { // from class: com.google.firebase.remoteconfig.e
                @Override // e6.a
                public final Object invoke() {
                    return RemoteConfigKt$configUpdates$1.invokeSuspend$lambda$0(configUpdateListenerRegistrationAddOnConfigUpdateListener);
                }
            };
            this.label = 1;
            if (q.m(xVar, aVar2, this) == aVar) {
                return aVar;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            q.z0(obj);
        }
        return x.f13520a;
    }

    @Override // e6.p
    public final Object invoke(s6.x xVar, v5.c<? super x> cVar) {
        return ((RemoteConfigKt$configUpdates$1) create(xVar, cVar)).invokeSuspend(x.f13520a);
    }
}
