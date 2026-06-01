package com.unity3d.services.core.network.core;

import kotlin.jvm.internal.l;
import okhttp3.Call;
import q5.x;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class RefactoredOkHttp3Client$execute$2$1 extends l implements e6.l {
    final /* synthetic */ Call $call;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RefactoredOkHttp3Client$execute$2$1(Call call) {
        super(1);
        this.$call = call;
    }

    @Override // e6.l
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Throwable) obj);
        return x.f13520a;
    }

    public final void invoke(Throwable th) {
        this.$call.cancel();
    }
}
