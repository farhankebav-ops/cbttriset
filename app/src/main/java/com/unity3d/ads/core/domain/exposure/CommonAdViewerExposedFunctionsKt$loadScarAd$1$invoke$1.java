package com.unity3d.ads.core.domain.exposure;

import com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt;
import q5.x;
import x5.c;
import x5.e;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
@e(c = "com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt$loadScarAd$1", f = "CommonAdViewerExposedFunctions.kt", l = {385}, m = "invoke")
public final class CommonAdViewerExposedFunctionsKt$loadScarAd$1$invoke$1 extends c {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CommonAdViewerExposedFunctionsKt.C29351 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CommonAdViewerExposedFunctionsKt$loadScarAd$1$invoke$1(CommonAdViewerExposedFunctionsKt.C29351 c29351, v5.c<? super CommonAdViewerExposedFunctionsKt$loadScarAd$1$invoke$1> cVar) {
        super(cVar);
        this.this$0 = c29351;
    }

    @Override // x5.a
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.invoke((Object[]) null, (v5.c<? super x>) this);
    }
}
