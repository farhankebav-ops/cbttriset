package com.unity3d.ads.beta;

import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class UnityAdsBeta {
    public static final void getToken(TokenConfiguration configuration, TokenListener listener) {
        k.e(configuration, "configuration");
        k.e(listener, "listener");
    }

    public static final String getVersion() {
        return "";
    }

    public static final void initialize(InitializationConfiguration configuration, InitializationListener listener) {
        k.e(configuration, "configuration");
        k.e(listener, "listener");
    }

    public static final boolean isInitialize() {
        return true;
    }
}
