package com.unity3d.services.ads.offerwall;

import com.unity3d.ads.core.domain.offerwall.OfferwallEventData;
import e6.p;
import q5.x;
import q6.a0;
import r2.q;
import t6.p0;
import v5.c;
import x5.e;
import x5.i;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
@e(c = "com.unity3d.services.ads.offerwall.OfferwallAdapterBridge$tapjoyPlacementListener$1$2", f = "OfferwallAdapterBridge.kt", l = {101}, m = "invokeSuspend")
public final class OfferwallAdapterBridge$tapjoyPlacementListener$1$2 extends i implements p {
    final /* synthetic */ String $placementName;
    int label;
    final /* synthetic */ OfferwallAdapterBridge this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OfferwallAdapterBridge$tapjoyPlacementListener$1$2(OfferwallAdapterBridge offerwallAdapterBridge, String str, c<? super OfferwallAdapterBridge$tapjoyPlacementListener$1$2> cVar) {
        super(2, cVar);
        this.this$0 = offerwallAdapterBridge;
        this.$placementName = str;
    }

    @Override // x5.a
    public final c<x> create(Object obj, c<?> cVar) {
        return new OfferwallAdapterBridge$tapjoyPlacementListener$1$2(this.this$0, this.$placementName, cVar);
    }

    @Override // x5.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        w5.a aVar = w5.a.f17774a;
        int i2 = this.label;
        if (i2 == 0) {
            q.z0(obj);
            p0 p0Var = this.this$0._offerwallEventFlow;
            OfferwallEvent offerwallEvent = OfferwallEvent.REQUEST_FAILED;
            String str = this.$placementName;
            if (str == null) {
                str = "";
            }
            OfferwallEventData offerwallEventData = new OfferwallEventData(offerwallEvent, str, null, null, 12, null);
            this.label = 1;
            if (p0Var.emit(offerwallEventData, this) == aVar) {
                return aVar;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            q.z0(obj);
        }
        return x.f13520a;
    }

    @Override // e6.p
    public final Object invoke(a0 a0Var, c<? super x> cVar) {
        return ((OfferwallAdapterBridge$tapjoyPlacementListener$1$2) create(a0Var, cVar)).invokeSuspend(x.f13520a);
    }
}
