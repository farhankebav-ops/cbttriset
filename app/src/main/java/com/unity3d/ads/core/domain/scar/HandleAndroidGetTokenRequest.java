package com.unity3d.ads.core.domain.scar;

import com.unity3d.ads.core.domain.GetRequestPolicy;
import com.unity3d.ads.core.domain.GetUniversalRequestForPayLoad;
import com.unity3d.ads.gatewayclient.GatewayClient;
import kotlin.jvm.internal.k;
import x5.c;
import x5.e;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class HandleAndroidGetTokenRequest implements HandleGetTokenRequest {
    private final GatewayClient gatewayClient;
    private final GetHbTokenEventRequest getHbTokenEventRequest;
    private final GetRequestPolicy getRequestPolicy;
    private final GetUniversalRequestForPayLoad getUniversalRequestForPayLoad;

    /* JADX INFO: renamed from: com.unity3d.ads.core.domain.scar.HandleAndroidGetTokenRequest$invoke$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.unity3d.ads.core.domain.scar.HandleAndroidGetTokenRequest", f = "HandleAndroidGetTokenRequest.kt", l = {20, 24, 26}, m = "invoke")
    public static final class AnonymousClass1 extends c {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(v5.c<? super AnonymousClass1> cVar) {
            super(cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return HandleAndroidGetTokenRequest.this.invoke(null, null, this);
        }
    }

    public HandleAndroidGetTokenRequest(GetUniversalRequestForPayLoad getUniversalRequestForPayLoad, GetHbTokenEventRequest getHbTokenEventRequest, GetRequestPolicy getRequestPolicy, GatewayClient gatewayClient) {
        k.e(getUniversalRequestForPayLoad, "getUniversalRequestForPayLoad");
        k.e(getHbTokenEventRequest, "getHbTokenEventRequest");
        k.e(getRequestPolicy, "getRequestPolicy");
        k.e(gatewayClient, "gatewayClient");
        this.getUniversalRequestForPayLoad = getUniversalRequestForPayLoad;
        this.getHbTokenEventRequest = getHbTokenEventRequest;
        this.getRequestPolicy = getRequestPolicy;
        this.gatewayClient = gatewayClient;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x009b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    @Override // com.unity3d.ads.core.domain.scar.HandleGetTokenRequest
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object invoke(com.google.protobuf.ByteString r10, com.unity3d.services.ads.gmascar.models.BiddingSignals r11, v5.c<? super gatewayprotocol.v1.UniversalResponseOuterClass.UniversalResponse> r12) throws java.lang.Throwable {
        /*
            r9 = this;
            boolean r0 = r12 instanceof com.unity3d.ads.core.domain.scar.HandleAndroidGetTokenRequest.AnonymousClass1
            if (r0 == 0) goto L14
            r0 = r12
            com.unity3d.ads.core.domain.scar.HandleAndroidGetTokenRequest$invoke$1 r0 = (com.unity3d.ads.core.domain.scar.HandleAndroidGetTokenRequest.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.label = r1
        L12:
            r6 = r0
            goto L1a
        L14:
            com.unity3d.ads.core.domain.scar.HandleAndroidGetTokenRequest$invoke$1 r0 = new com.unity3d.ads.core.domain.scar.HandleAndroidGetTokenRequest$invoke$1
            r0.<init>(r12)
            goto L12
        L1a:
            java.lang.Object r12 = r6.result
            w5.a r0 = w5.a.f17774a
            int r1 = r6.label
            r2 = 3
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L47
            if (r1 == r4) goto L3f
            if (r1 == r3) goto L37
            if (r1 != r2) goto L2f
            r2.q.z0(r12)
            return r12
        L2f:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L37:
            java.lang.Object r10 = r6.L$0
            com.unity3d.ads.core.domain.scar.HandleAndroidGetTokenRequest r10 = (com.unity3d.ads.core.domain.scar.HandleAndroidGetTokenRequest) r10
            r2.q.z0(r12)
            goto L7f
        L3f:
            java.lang.Object r10 = r6.L$0
            com.unity3d.ads.core.domain.scar.HandleAndroidGetTokenRequest r10 = (com.unity3d.ads.core.domain.scar.HandleAndroidGetTokenRequest) r10
            r2.q.z0(r12)
            goto L58
        L47:
            r2.q.z0(r12)
            com.unity3d.ads.core.domain.scar.GetHbTokenEventRequest r12 = r9.getHbTokenEventRequest
            r6.L$0 = r9
            r6.label = r4
            java.lang.Object r12 = r12.invoke(r10, r11, r6)
            if (r12 != r0) goto L57
            goto L9a
        L57:
            r10 = r9
        L58:
            gatewayprotocol.v1.GetTokenEventRequestOuterClass$GetTokenEventRequest r12 = (gatewayprotocol.v1.GetTokenEventRequestOuterClass.GetTokenEventRequest) r12
            gatewayprotocol.v1.UniversalRequestKt r11 = gatewayprotocol.v1.UniversalRequestKt.INSTANCE
            gatewayprotocol.v1.UniversalRequestKt$PayloadKt$Dsl$Companion r11 = gatewayprotocol.v1.UniversalRequestKt.PayloadKt.Dsl.Companion
            gatewayprotocol.v1.UniversalRequestOuterClass$UniversalRequest$Payload$Builder r1 = gatewayprotocol.v1.UniversalRequestOuterClass.UniversalRequest.Payload.newBuilder()
            java.lang.String r4 = "newBuilder()"
            kotlin.jvm.internal.k.d(r1, r4)
            gatewayprotocol.v1.UniversalRequestKt$PayloadKt$Dsl r11 = r11._create(r1)
            r11.setGetTokenEventRequest(r12)
            gatewayprotocol.v1.UniversalRequestOuterClass$UniversalRequest$Payload r11 = r11._build()
            com.unity3d.ads.core.domain.GetUniversalRequestForPayLoad r12 = r10.getUniversalRequestForPayLoad
            r6.L$0 = r10
            r6.label = r3
            java.lang.Object r12 = r12.invoke(r11, r6)
            if (r12 != r0) goto L7f
            goto L9a
        L7f:
            r3 = r12
            gatewayprotocol.v1.UniversalRequestOuterClass$UniversalRequest r3 = (gatewayprotocol.v1.UniversalRequestOuterClass.UniversalRequest) r3
            com.unity3d.ads.core.domain.GetRequestPolicy r11 = r10.getRequestPolicy
            com.unity3d.ads.gatewayclient.RequestPolicy r4 = r11.invoke()
            com.unity3d.ads.gatewayclient.GatewayClient r1 = r10.gatewayClient
            com.unity3d.ads.core.data.model.OperationType r5 = com.unity3d.ads.core.data.model.OperationType.GET_TOKEN
            r10 = 0
            r6.L$0 = r10
            r6.label = r2
            r2 = 0
            r7 = 1
            r8 = 0
            java.lang.Object r10 = com.unity3d.ads.gatewayclient.GatewayClient.DefaultImpls.request$default(r1, r2, r3, r4, r5, r6, r7, r8)
            if (r10 != r0) goto L9b
        L9a:
            return r0
        L9b:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.core.domain.scar.HandleAndroidGetTokenRequest.invoke(com.google.protobuf.ByteString, com.unity3d.services.ads.gmascar.models.BiddingSignals, v5.c):java.lang.Object");
    }
}
