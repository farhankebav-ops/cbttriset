package com.unity3d.ads.core.domain;

import kotlin.jvm.internal.k;
import x5.c;
import x5.e;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class AndroidGetInitializationData implements GetInitializationData {
    private final GetInitializationRequestPayload getInitializeRequestPayload;
    private final GetUniversalRequestSharedData getUniversalRequestSharedData;

    /* JADX INFO: renamed from: com.unity3d.ads.core.domain.AndroidGetInitializationData$invoke$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.unity3d.ads.core.domain.AndroidGetInitializationData", f = "AndroidGetInitializationData.kt", l = {10, 11}, m = "invoke")
    public static final class AnonymousClass1 extends c {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(v5.c<? super AnonymousClass1> cVar) {
            super(cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AndroidGetInitializationData.this.invoke(this);
        }
    }

    public AndroidGetInitializationData(GetInitializationRequestPayload getInitializeRequestPayload, GetUniversalRequestSharedData getUniversalRequestSharedData) {
        k.e(getInitializeRequestPayload, "getInitializeRequestPayload");
        k.e(getUniversalRequestSharedData, "getUniversalRequestSharedData");
        this.getInitializeRequestPayload = getInitializeRequestPayload;
        this.getUniversalRequestSharedData = getUniversalRequestSharedData;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.unity3d.ads.core.domain.GetInitializationData
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object invoke(v5.c<? super gatewayprotocol.v1.InitializationDataOuterClass.InitializationData> r9) throws java.lang.Throwable {
        /*
            r8 = this;
            boolean r0 = r9 instanceof com.unity3d.ads.core.domain.AndroidGetInitializationData.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r9
            com.unity3d.ads.core.domain.AndroidGetInitializationData$invoke$1 r0 = (com.unity3d.ads.core.domain.AndroidGetInitializationData.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.unity3d.ads.core.domain.AndroidGetInitializationData$invoke$1 r0 = new com.unity3d.ads.core.domain.AndroidGetInitializationData$invoke$1
            r0.<init>(r9)
        L18:
            java.lang.Object r9 = r0.result
            w5.a r1 = w5.a.f17774a
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L51
            if (r2 == r4) goto L3a
            if (r2 != r3) goto L32
            java.lang.Object r1 = r0.L$1
            gatewayprotocol.v1.InitializationDataKt$Dsl r1 = (gatewayprotocol.v1.InitializationDataKt.Dsl) r1
            java.lang.Object r0 = r0.L$0
            gatewayprotocol.v1.InitializationDataKt$Dsl r0 = (gatewayprotocol.v1.InitializationDataKt.Dsl) r0
            r2.q.z0(r9)
            goto L94
        L32:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L3a:
            java.lang.Object r2 = r0.L$3
            gatewayprotocol.v1.InitializationDataKt$Dsl r2 = (gatewayprotocol.v1.InitializationDataKt.Dsl) r2
            java.lang.Object r4 = r0.L$2
            gatewayprotocol.v1.InitializationDataKt$Dsl r4 = (gatewayprotocol.v1.InitializationDataKt.Dsl) r4
            java.lang.Object r5 = r0.L$1
            gatewayprotocol.v1.InitializationDataKt$Dsl r5 = (gatewayprotocol.v1.InitializationDataKt.Dsl) r5
            java.lang.Object r6 = r0.L$0
            com.unity3d.ads.core.domain.AndroidGetInitializationData r6 = (com.unity3d.ads.core.domain.AndroidGetInitializationData) r6
            r2.q.z0(r9)
            r7 = r5
            r5 = r2
            r2 = r7
            goto L79
        L51:
            r2.q.z0(r9)
            gatewayprotocol.v1.InitializationDataKt$Dsl$Companion r9 = gatewayprotocol.v1.InitializationDataKt.Dsl.Companion
            gatewayprotocol.v1.InitializationDataOuterClass$InitializationData$Builder r2 = gatewayprotocol.v1.InitializationDataOuterClass.InitializationData.newBuilder()
            java.lang.String r5 = "newBuilder()"
            kotlin.jvm.internal.k.d(r2, r5)
            gatewayprotocol.v1.InitializationDataKt$Dsl r2 = r9._create(r2)
            com.unity3d.ads.core.domain.GetInitializationRequestPayload r9 = r8.getInitializeRequestPayload
            r0.L$0 = r8
            r0.L$1 = r2
            r0.L$2 = r2
            r0.L$3 = r2
            r0.label = r4
            java.lang.Object r9 = r9.invoke(r0)
            if (r9 != r1) goto L76
            goto L91
        L76:
            r6 = r8
            r4 = r2
            r5 = r4
        L79:
            gatewayprotocol.v1.InitializationRequestOuterClass$InitializationRequest r9 = (gatewayprotocol.v1.InitializationRequestOuterClass.InitializationRequest) r9
            r5.setInitializationRequest(r9)
            com.unity3d.ads.core.domain.GetUniversalRequestSharedData r9 = r6.getUniversalRequestSharedData
            r0.L$0 = r2
            r0.L$1 = r4
            r5 = 0
            r0.L$2 = r5
            r0.L$3 = r5
            r0.label = r3
            java.lang.Object r9 = r9.invoke(r0)
            if (r9 != r1) goto L92
        L91:
            return r1
        L92:
            r0 = r2
            r1 = r4
        L94:
            gatewayprotocol.v1.UniversalRequestOuterClass$UniversalRequest$SharedData r9 = (gatewayprotocol.v1.UniversalRequestOuterClass.UniversalRequest.SharedData) r9
            r1.setSharedData(r9)
            gatewayprotocol.v1.InitializationDataOuterClass$InitializationData r9 = r0._build()
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.core.domain.AndroidGetInitializationData.invoke(v5.c):java.lang.Object");
    }
}
