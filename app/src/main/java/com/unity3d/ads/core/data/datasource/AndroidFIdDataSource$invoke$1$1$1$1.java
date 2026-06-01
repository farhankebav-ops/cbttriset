package com.unity3d.ads.core.data.datasource;

import kotlin.jvm.internal.l;
import q5.x;
import v5.c;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class AndroidFIdDataSource$invoke$1$1$1$1 extends l implements e6.l {
    final /* synthetic */ c<String> $cont;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public AndroidFIdDataSource$invoke$1$1$1$1(c<? super String> cVar) {
        super(1);
        this.$cont = cVar;
    }

    @Override // e6.l
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((String) obj);
        return x.f13520a;
    }

    public final void invoke(String str) {
        this.$cont.resumeWith(str);
    }
}
