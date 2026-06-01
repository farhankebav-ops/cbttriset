package com.google.firebase.remoteconfig;

import java.util.concurrent.CancellationException;
import kotlin.jvm.internal.k;
import q6.c0;
import s6.x;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class RemoteConfigKt$configUpdates$1$registration$1 implements ConfigUpdateListener {
    final /* synthetic */ x $$this$callbackFlow;
    final /* synthetic */ FirebaseRemoteConfig $this_configUpdates;

    public RemoteConfigKt$configUpdates$1$registration$1(FirebaseRemoteConfig firebaseRemoteConfig, x xVar) {
        this.$this_configUpdates = firebaseRemoteConfig;
        this.$$this$callbackFlow = xVar;
    }

    @Override // com.google.firebase.remoteconfig.ConfigUpdateListener
    public void onError(FirebaseRemoteConfigException error) {
        k.e(error, "error");
        x xVar = this.$$this$callbackFlow;
        CancellationException cancellationException = new CancellationException("Error listening for config updates.");
        cancellationException.initCause(error);
        c0.i(xVar, cancellationException);
    }

    @Override // com.google.firebase.remoteconfig.ConfigUpdateListener
    public void onUpdate(ConfigUpdate configUpdate) {
        k.e(configUpdate, "configUpdate");
        this.$this_configUpdates.schedule(new a3.c(19, this.$$this$callbackFlow, configUpdate));
    }
}
