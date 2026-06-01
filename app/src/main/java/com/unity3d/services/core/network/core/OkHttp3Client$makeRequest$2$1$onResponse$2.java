package com.unity3d.services.core.network.core;

import kotlin.jvm.internal.l;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class OkHttp3Client$makeRequest$2$1$onResponse$2 extends l implements e6.l {
    public static final OkHttp3Client$makeRequest$2$1$onResponse$2 INSTANCE = new OkHttp3Client$makeRequest$2$1$onResponse$2();

    public OkHttp3Client$makeRequest$2$1$onResponse$2() {
        super(1);
    }

    public final Boolean invoke(long j) {
        return Boolean.valueOf(j != -1);
    }

    @Override // e6.l
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return invoke(((Number) obj).longValue());
    }
}
