package com.unity3d.ads.core.domain.events;

import android.support.v4.media.g;
import com.unity3d.ads.core.data.datasource.ByteStringDataSource;
import com.unity3d.ads.core.data.repository.TransactionEventRepository;
import com.unity3d.ads.core.domain.GetRequestPolicy;
import com.unity3d.ads.core.domain.GetUniversalRequestForPayLoad;
import com.unity3d.ads.gatewayclient.GatewayClient;
import e6.p;
import gatewayprotocol.v1.TransactionEventRequestOuterClass;
import kotlin.jvm.internal.k;
import q5.x;
import q6.a0;
import q6.c0;
import q6.w;
import r2.q;
import t6.d1;
import t6.q0;
import t6.x0;
import v5.c;
import w5.a;
import x5.e;
import x5.i;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class TransactionEventObserver {
    private final w defaultDispatcher;
    private final GatewayClient gatewayClient;
    private final GetRequestPolicy getRequestPolicy;
    private final GetUniversalRequestForPayLoad getUniversalRequestForPayLoad;
    private final ByteStringDataSource iapTransactionStore;
    private final q0 isRunning;
    private final TransactionEventRepository transactionEventRepository;

    /* JADX INFO: renamed from: com.unity3d.ads.core.domain.events.TransactionEventObserver$invoke$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.unity3d.ads.core.domain.events.TransactionEventObserver$invoke$2", f = "TransactionEventObserver.kt", l = {}, m = "invokeSuspend")
    public static final class AnonymousClass2 extends i implements p {
        int label;

        /* JADX INFO: renamed from: com.unity3d.ads.core.domain.events.TransactionEventObserver$invoke$2$2, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        @e(c = "com.unity3d.ads.core.domain.events.TransactionEventObserver$invoke$2$2", f = "TransactionEventObserver.kt", l = {44, 46, 55}, m = "invokeSuspend")
        public static final class C02162 extends i implements p {
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ TransactionEventObserver this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C02162(TransactionEventObserver transactionEventObserver, c<? super C02162> cVar) {
                super(2, cVar);
                this.this$0 = transactionEventObserver;
            }

            @Override // x5.a
            public final c<x> create(Object obj, c<?> cVar) {
                C02162 c02162 = new C02162(this.this$0, cVar);
                c02162.L$0 = obj;
                return c02162;
            }

            @Override // e6.p
            public final Object invoke(TransactionEventRequestOuterClass.TransactionEventRequest transactionEventRequest, c<? super x> cVar) {
                return ((C02162) create(transactionEventRequest, cVar)).invokeSuspend(x.f13520a);
            }

            /* JADX WARN: Code restructure failed: missing block: B:22:0x00aa, code lost:
            
                if (r13.set(r1, r12) == r0) goto L23;
             */
            /* JADX WARN: Removed duplicated region for block: B:21:0x0086  */
            @Override // x5.a
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final java.lang.Object invokeSuspend(java.lang.Object r13) throws java.lang.Throwable {
                /*
                    r12 = this;
                    w5.a r0 = w5.a.f17774a
                    int r1 = r12.label
                    r2 = 3
                    r3 = 2
                    r4 = 1
                    if (r1 == 0) goto L2a
                    if (r1 == r4) goto L26
                    if (r1 == r3) goto L1d
                    if (r1 != r2) goto L15
                    r2.q.z0(r13)
                    r9 = r12
                    goto Lad
                L15:
                    java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
                    java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                    r13.<init>(r0)
                    throw r13
                L1d:
                    java.lang.Object r1 = r12.L$0
                    gatewayprotocol.v1.UniversalRequestOuterClass$UniversalRequest r1 = (gatewayprotocol.v1.UniversalRequestOuterClass.UniversalRequest) r1
                    r2.q.z0(r13)
                    r9 = r12
                    goto L7e
                L26:
                    r2.q.z0(r13)
                    goto L59
                L2a:
                    r2.q.z0(r13)
                    java.lang.Object r13 = r12.L$0
                    gatewayprotocol.v1.TransactionEventRequestOuterClass$TransactionEventRequest r13 = (gatewayprotocol.v1.TransactionEventRequestOuterClass.TransactionEventRequest) r13
                    gatewayprotocol.v1.UniversalRequestKt r1 = gatewayprotocol.v1.UniversalRequestKt.INSTANCE
                    gatewayprotocol.v1.UniversalRequestKt$PayloadKt$Dsl$Companion r1 = gatewayprotocol.v1.UniversalRequestKt.PayloadKt.Dsl.Companion
                    gatewayprotocol.v1.UniversalRequestOuterClass$UniversalRequest$Payload$Builder r5 = gatewayprotocol.v1.UniversalRequestOuterClass.UniversalRequest.Payload.newBuilder()
                    java.lang.String r6 = "newBuilder()"
                    kotlin.jvm.internal.k.d(r5, r6)
                    gatewayprotocol.v1.UniversalRequestKt$PayloadKt$Dsl r1 = r1._create(r5)
                    r1.setTransactionEventRequest(r13)
                    gatewayprotocol.v1.UniversalRequestOuterClass$UniversalRequest$Payload r13 = r1._build()
                    com.unity3d.ads.core.domain.events.TransactionEventObserver r1 = r12.this$0
                    com.unity3d.ads.core.domain.GetUniversalRequestForPayLoad r1 = com.unity3d.ads.core.domain.events.TransactionEventObserver.access$getGetUniversalRequestForPayLoad$p(r1)
                    r12.label = r4
                    java.lang.Object r13 = r1.invoke(r13, r12)
                    if (r13 != r0) goto L59
                    r9 = r12
                    goto Lac
                L59:
                    r6 = r13
                    gatewayprotocol.v1.UniversalRequestOuterClass$UniversalRequest r6 = (gatewayprotocol.v1.UniversalRequestOuterClass.UniversalRequest) r6
                    com.unity3d.ads.core.domain.events.TransactionEventObserver r13 = r12.this$0
                    com.unity3d.ads.gatewayclient.GatewayClient r4 = com.unity3d.ads.core.domain.events.TransactionEventObserver.access$getGatewayClient$p(r13)
                    com.unity3d.ads.core.domain.events.TransactionEventObserver r13 = r12.this$0
                    com.unity3d.ads.core.domain.GetRequestPolicy r13 = com.unity3d.ads.core.domain.events.TransactionEventObserver.access$getGetRequestPolicy$p(r13)
                    com.unity3d.ads.gatewayclient.RequestPolicy r7 = r13.invoke()
                    com.unity3d.ads.core.data.model.OperationType r8 = com.unity3d.ads.core.data.model.OperationType.TRANSACTION_EVENT
                    r12.L$0 = r6
                    r12.label = r3
                    r5 = 0
                    r10 = 1
                    r11 = 0
                    r9 = r12
                    java.lang.Object r13 = com.unity3d.ads.gatewayclient.GatewayClient.DefaultImpls.request$default(r4, r5, r6, r7, r8, r9, r10, r11)
                    if (r13 != r0) goto L7d
                    goto Lac
                L7d:
                    r1 = r6
                L7e:
                    gatewayprotocol.v1.UniversalResponseOuterClass$UniversalResponse r13 = (gatewayprotocol.v1.UniversalResponseOuterClass.UniversalResponse) r13
                    gatewayprotocol.v1.ErrorOuterClass$Error r13 = r13.getError()
                    if (r13 == 0) goto Lad
                    com.unity3d.ads.core.domain.events.TransactionEventObserver r13 = r9.this$0
                    com.unity3d.ads.core.data.datasource.ByteStringDataSource r13 = com.unity3d.ads.core.domain.events.TransactionEventObserver.access$getIapTransactionStore$p(r13)
                    gatewayprotocol.v1.UniversalRequestOuterClass$UniversalRequest$SharedData r1 = r1.getSharedData()
                    gatewayprotocol.v1.TimestampsOuterClass$Timestamps r1 = r1.getTimestamps()
                    com.google.protobuf.Timestamp r1 = r1.getTimestamp()
                    com.google.protobuf.ByteString r1 = r1.toByteString()
                    java.lang.String r3 = "fullRequest.sharedData.t….timestamp.toByteString()"
                    kotlin.jvm.internal.k.d(r1, r3)
                    r3 = 0
                    r9.L$0 = r3
                    r9.label = r2
                    java.lang.Object r13 = r13.set(r1, r12)
                    if (r13 != r0) goto Lad
                Lac:
                    return r0
                Lad:
                    q5.x r13 = q5.x.f13520a
                    return r13
                */
                throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.core.domain.events.TransactionEventObserver.AnonymousClass2.C02162.invokeSuspend(java.lang.Object):java.lang.Object");
            }
        }

        public AnonymousClass2(c<? super AnonymousClass2> cVar) {
            super(2, cVar);
        }

        @Override // x5.a
        public final c<x> create(Object obj, c<?> cVar) {
            return TransactionEventObserver.this.new AnonymousClass2(cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            d1 d1Var;
            Object value;
            Boolean bool;
            a aVar = a.f17774a;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            q.z0(obj);
            q0 q0Var = TransactionEventObserver.this.isRunning;
            do {
                d1Var = (d1) q0Var;
                value = d1Var.getValue();
                bool = (Boolean) value;
                bool.getClass();
            } while (!d1Var.g(value, Boolean.TRUE));
            boolean zBooleanValue = bool.booleanValue();
            x xVar = x.f13520a;
            if (zBooleanValue) {
                return xVar;
            }
            x0.o(new g(24, TransactionEventObserver.this.transactionEventRepository.getTransactionEvents(), new C02162(TransactionEventObserver.this, null)), c0.b(TransactionEventObserver.this.defaultDispatcher));
            return xVar;
        }

        @Override // e6.p
        public final Object invoke(a0 a0Var, c<? super x> cVar) {
            return ((AnonymousClass2) create(a0Var, cVar)).invokeSuspend(x.f13520a);
        }
    }

    public TransactionEventObserver(GetUniversalRequestForPayLoad getUniversalRequestForPayLoad, w defaultDispatcher, TransactionEventRepository transactionEventRepository, GatewayClient gatewayClient, GetRequestPolicy getRequestPolicy, ByteStringDataSource iapTransactionStore) {
        k.e(getUniversalRequestForPayLoad, "getUniversalRequestForPayLoad");
        k.e(defaultDispatcher, "defaultDispatcher");
        k.e(transactionEventRepository, "transactionEventRepository");
        k.e(gatewayClient, "gatewayClient");
        k.e(getRequestPolicy, "getRequestPolicy");
        k.e(iapTransactionStore, "iapTransactionStore");
        this.getUniversalRequestForPayLoad = getUniversalRequestForPayLoad;
        this.defaultDispatcher = defaultDispatcher;
        this.transactionEventRepository = transactionEventRepository;
        this.gatewayClient = gatewayClient;
        this.getRequestPolicy = getRequestPolicy;
        this.iapTransactionStore = iapTransactionStore;
        this.isRunning = x0.c(Boolean.FALSE);
    }

    public final Object invoke(c<? super x> cVar) throws Throwable {
        Object objH = c0.H(new AnonymousClass2(null), this.defaultDispatcher, cVar);
        return objH == a.f17774a ? objH : x.f13520a;
    }
}
