package com.ironsource;

import com.ironsource.sdk.utils.SDKUtils;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class U7 {
    public final String a() {
        String OMID_LIB_VERSION = Hc.f6926f;
        kotlin.jvm.internal.k.d(OMID_LIB_VERSION, "OMID_LIB_VERSION");
        return OMID_LIB_VERSION;
    }

    public final String b() {
        return Hc.e;
    }

    public final String c() {
        String sDKVersion = SDKUtils.getSDKVersion();
        kotlin.jvm.internal.k.d(sDKVersion, "getSDKVersion()");
        return sDKVersion;
    }
}
