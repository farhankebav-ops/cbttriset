package com.unity3d.ads.core.domain.exposure;

import com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt;
import com.vungle.ads.internal.protos.Sdk;
import q5.x;
import x5.c;
import x5.e;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
@e(c = "com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt$setPrivacyFsm$1", f = "CommonAdViewerExposedFunctions.kt", l = {Sdk.SDKError.Reason.AD_LOAD_FAIL_EMPTY_BID_PAYLOAD_VALUE}, m = "invoke")
public final class CommonAdViewerExposedFunctionsKt$setPrivacyFsm$1$invoke$1 extends c {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CommonAdViewerExposedFunctionsKt.C29521 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CommonAdViewerExposedFunctionsKt$setPrivacyFsm$1$invoke$1(CommonAdViewerExposedFunctionsKt.C29521 c29521, v5.c<? super CommonAdViewerExposedFunctionsKt$setPrivacyFsm$1$invoke$1> cVar) {
        super(cVar);
        this.this$0 = c29521;
    }

    @Override // x5.a
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.invoke((Object[]) null, (v5.c<? super x>) this);
    }
}
