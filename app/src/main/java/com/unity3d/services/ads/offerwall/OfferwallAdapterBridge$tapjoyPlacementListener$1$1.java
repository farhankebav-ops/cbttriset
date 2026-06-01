package com.unity3d.services.ads.offerwall;

import e6.p;
import q5.x;
import q6.a0;
import v5.c;
import x5.e;
import x5.i;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
@e(c = "com.unity3d.services.ads.offerwall.OfferwallAdapterBridge$tapjoyPlacementListener$1$1", f = "OfferwallAdapterBridge.kt", l = {77, 83}, m = "invokeSuspend")
public final class OfferwallAdapterBridge$tapjoyPlacementListener$1$1 extends i implements p {
    final /* synthetic */ boolean $placementAvailable;
    final /* synthetic */ String $placementName;
    int label;
    final /* synthetic */ OfferwallAdapterBridge this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OfferwallAdapterBridge$tapjoyPlacementListener$1$1(boolean z2, OfferwallAdapterBridge offerwallAdapterBridge, String str, c<? super OfferwallAdapterBridge$tapjoyPlacementListener$1$1> cVar) {
        super(2, cVar);
        this.$placementAvailable = z2;
        this.this$0 = offerwallAdapterBridge;
        this.$placementName = str;
    }

    @Override // x5.a
    public final c<x> create(Object obj, c<?> cVar) {
        return new OfferwallAdapterBridge$tapjoyPlacementListener$1$1(this.$placementAvailable, this.this$0, this.$placementName, cVar);
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0041, code lost:
    
        if (r12.emit(r4, r11) == r0) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x006f, code lost:
    
        if (r12.emit(r3, r11) == r0) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0071, code lost:
    
        return r0;
     */
    @Override // x5.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r12) throws java.lang.Throwable {
        /*
            r11 = this;
            w5.a r0 = w5.a.f17774a
            int r1 = r11.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L19
            if (r1 == r3) goto L15
            if (r1 != r2) goto Ld
            goto L15
        Ld:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r0)
            throw r12
        L15:
            r2.q.z0(r12)
            goto L72
        L19:
            r2.q.z0(r12)
            boolean r12 = r11.$placementAvailable
            java.lang.String r1 = ""
            if (r12 == 0) goto L44
            com.unity3d.services.ads.offerwall.OfferwallAdapterBridge r12 = r11.this$0
            t6.p0 r12 = com.unity3d.services.ads.offerwall.OfferwallAdapterBridge.access$get_offerwallEventFlow$p(r12)
            com.unity3d.ads.core.domain.offerwall.OfferwallEventData r4 = new com.unity3d.ads.core.domain.offerwall.OfferwallEventData
            com.unity3d.services.ads.offerwall.OfferwallEvent r5 = com.unity3d.services.ads.offerwall.OfferwallEvent.REQUEST_SUCCESS
            java.lang.String r2 = r11.$placementName
            if (r2 != 0) goto L32
            r6 = r1
            goto L33
        L32:
            r6 = r2
        L33:
            r9 = 12
            r10 = 0
            r7 = 0
            r8 = 0
            r4.<init>(r5, r6, r7, r8, r9, r10)
            r11.label = r3
            java.lang.Object r12 = r12.emit(r4, r11)
            if (r12 != r0) goto L72
            goto L71
        L44:
            com.unity3d.services.ads.offerwall.OfferwallAdapterBridge r12 = r11.this$0
            java.util.HashMap r12 = com.unity3d.services.ads.offerwall.OfferwallAdapterBridge.access$getPlacementsMap$p(r12)
            java.lang.String r3 = r11.$placementName
            if (r3 != 0) goto L4f
            r3 = r1
        L4f:
            r12.remove(r3)
            com.unity3d.services.ads.offerwall.OfferwallAdapterBridge r12 = r11.this$0
            t6.p0 r12 = com.unity3d.services.ads.offerwall.OfferwallAdapterBridge.access$get_offerwallEventFlow$p(r12)
            com.unity3d.ads.core.domain.offerwall.OfferwallEventData r3 = new com.unity3d.ads.core.domain.offerwall.OfferwallEventData
            com.unity3d.services.ads.offerwall.OfferwallEvent r4 = com.unity3d.services.ads.offerwall.OfferwallEvent.REQUEST_FAILED
            java.lang.String r5 = r11.$placementName
            if (r5 != 0) goto L61
            r5 = r1
        L61:
            r8 = 12
            r9 = 0
            r6 = 0
            r7 = 0
            r3.<init>(r4, r5, r6, r7, r8, r9)
            r11.label = r2
            java.lang.Object r12 = r12.emit(r3, r11)
            if (r12 != r0) goto L72
        L71:
            return r0
        L72:
            q5.x r12 = q5.x.f13520a
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.services.ads.offerwall.OfferwallAdapterBridge$tapjoyPlacementListener$1$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // e6.p
    public final Object invoke(a0 a0Var, c<? super x> cVar) {
        return ((OfferwallAdapterBridge$tapjoyPlacementListener$1$1) create(a0Var, cVar)).invokeSuspend(x.f13520a);
    }
}
