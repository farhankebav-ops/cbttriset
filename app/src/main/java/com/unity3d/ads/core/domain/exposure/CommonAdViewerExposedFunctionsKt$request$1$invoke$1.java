package com.unity3d.ads.core.domain.exposure;

import com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt;
import x5.c;
import x5.e;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
@e(c = "com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt$request$1", f = "CommonAdViewerExposedFunctions.kt", l = {426}, m = "invoke")
public final class CommonAdViewerExposedFunctionsKt$request$1$invoke$1 extends c {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CommonAdViewerExposedFunctionsKt.C29441 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CommonAdViewerExposedFunctionsKt$request$1$invoke$1(CommonAdViewerExposedFunctionsKt.C29441 c29441, v5.c<? super CommonAdViewerExposedFunctionsKt$request$1$invoke$1> cVar) {
        super(cVar);
        this.this$0 = c29441;
    }

    @Override // x5.a
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.invoke((Object[]) null, (v5.c<Object>) this);
    }
}
