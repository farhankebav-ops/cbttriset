package com.onesignal.core.internal.config;

import com.unity3d.services.UnityAdsConstants;
import e6.a;
import kotlin.jvm.internal.l;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class ConfigModel$httpTimeout$2 extends l implements a {
    public static final ConfigModel$httpTimeout$2 INSTANCE = new ConfigModel$httpTimeout$2();

    public ConfigModel$httpTimeout$2() {
        super(0);
    }

    @Override // e6.a
    public final Integer invoke() {
        return Integer.valueOf(UnityAdsConstants.RequestPolicy.RETRY_MAX_DURATION);
    }
}
