package com.onesignal.core.internal.config;

import androidx.work.WorkRequest;
import e6.a;
import kotlin.jvm.internal.l;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class ConfigModel$fetchIAMMinInterval$2 extends l implements a {
    public static final ConfigModel$fetchIAMMinInterval$2 INSTANCE = new ConfigModel$fetchIAMMinInterval$2();

    public ConfigModel$fetchIAMMinInterval$2() {
        super(0);
    }

    @Override // e6.a
    public final Long invoke() {
        return Long.valueOf(WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS);
    }
}
