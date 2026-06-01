package com.onesignal.location.internal.controller.impl;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class GoogleApiClientCompatProxy {
    private final Class<?> googleApiClientListenerClass;
    private final GoogleApiClient realInstance;

    public GoogleApiClientCompatProxy(GoogleApiClient realInstance) {
        k.e(realInstance, "realInstance");
        this.realInstance = realInstance;
        this.googleApiClientListenerClass = realInstance.getClass();
    }

    public final ConnectionResult blockingConnect() {
        try {
            Object objInvoke = this.googleApiClientListenerClass.getMethod("blockingConnect", null).invoke(this.realInstance, null);
            k.c(objInvoke, "null cannot be cast to non-null type com.google.android.gms.common.ConnectionResult");
            return (ConnectionResult) objInvoke;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public final void connect() {
        try {
            this.googleApiClientListenerClass.getMethod("connect", null).invoke(this.realInstance, null);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void disconnect() {
        try {
            this.googleApiClientListenerClass.getMethod("disconnect", null).invoke(this.realInstance, null);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final GoogleApiClient getRealInstance() {
        return this.realInstance;
    }
}
