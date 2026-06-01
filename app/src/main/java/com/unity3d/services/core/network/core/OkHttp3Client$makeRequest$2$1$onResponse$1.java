package com.unity3d.services.core.network.core;

import e6.a;
import kotlin.jvm.internal.l;
import l7.j;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class OkHttp3Client$makeRequest$2$1$onResponse$1 extends l implements a {
    final /* synthetic */ j $buffer;
    final /* synthetic */ l7.l $source;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OkHttp3Client$makeRequest$2$1$onResponse$1(l7.l lVar, j jVar) {
        super(0);
        this.$source = lVar;
        this.$buffer = jVar;
    }

    @Override // e6.a
    public final Long invoke() {
        return Long.valueOf(this.$source.read(this.$buffer, 8192L));
    }
}
