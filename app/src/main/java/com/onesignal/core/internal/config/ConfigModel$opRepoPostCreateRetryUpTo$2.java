package com.onesignal.core.internal.config;

import e6.a;
import kotlin.jvm.internal.l;
import okhttp3.internal.ws.RealWebSocket;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class ConfigModel$opRepoPostCreateRetryUpTo$2 extends l implements a {
    public static final ConfigModel$opRepoPostCreateRetryUpTo$2 INSTANCE = new ConfigModel$opRepoPostCreateRetryUpTo$2();

    public ConfigModel$opRepoPostCreateRetryUpTo$2() {
        super(0);
    }

    @Override // e6.a
    public final Long invoke() {
        return Long.valueOf(RealWebSocket.CANCEL_AFTER_CLOSE_MILLIS);
    }
}
