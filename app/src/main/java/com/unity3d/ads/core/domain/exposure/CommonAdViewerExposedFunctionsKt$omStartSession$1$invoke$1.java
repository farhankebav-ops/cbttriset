package com.unity3d.ads.core.domain.exposure;

import com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt;
import q5.x;
import x5.c;
import x5.e;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
@e(c = "com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt$omStartSession$1", f = "CommonAdViewerExposedFunctions.kt", l = {341}, m = "invoke")
public final class CommonAdViewerExposedFunctionsKt$omStartSession$1$invoke$1 extends c {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CommonAdViewerExposedFunctionsKt.C29401 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CommonAdViewerExposedFunctionsKt$omStartSession$1$invoke$1(CommonAdViewerExposedFunctionsKt.C29401 c29401, v5.c<? super CommonAdViewerExposedFunctionsKt$omStartSession$1$invoke$1> cVar) {
        super(cVar);
        this.this$0 = c29401;
    }

    @Override // x5.a
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.invoke((Object[]) null, (v5.c<? super x>) this);
    }
}
