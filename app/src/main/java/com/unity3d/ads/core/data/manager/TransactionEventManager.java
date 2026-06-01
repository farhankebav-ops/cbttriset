package com.unity3d.ads.core.data.manager;

import com.unity3d.ads.core.data.datasource.ByteStringDataSource;
import com.unity3d.ads.core.data.manager.TransactionEventManager;
import com.unity3d.ads.core.data.model.exception.TransactionException;
import com.unity3d.ads.core.data.repository.SessionRepository;
import com.unity3d.ads.core.data.repository.TransactionEventRepository;
import com.unity3d.ads.core.domain.SendDiagnosticEvent;
import com.unity3d.ads.core.domain.billing.IsBillingClientAvailable;
import com.unity3d.ads.core.domain.billing.ProductDetailsFetcher;
import com.unity3d.ads.core.domain.events.GetTransactionData;
import com.unity3d.ads.core.domain.events.GetTransactionRequest;
import com.unity3d.services.store.gpbl.BillingResultResponseCode;
import com.unity3d.services.store.gpbl.bridges.BillingResultBridge;
import com.unity3d.services.store.gpbl.bridges.PurchaseBridge;
import com.unity3d.services.store.gpbl.bridges.billingclient.BillingClientAdapter;
import com.unity3d.services.store.gpbl.listeners.BillingInitializationListener;
import com.unity3d.services.store.gpbl.listeners.PurchasesResponseListener;
import com.vungle.ads.internal.protos.Sdk;
import e6.p;
import gatewayprotocol.v1.TransactionEventRequestOuterClass;
import java.util.List;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import q5.x;
import q6.a0;
import q6.c0;
import q6.l;
import r2.q;
import t6.d1;
import t6.q0;
import t6.x0;
import v5.c;
import x5.e;
import x5.i;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class TransactionEventManager {
    public static final Companion Companion = new Companion(null);
    private static final String INAPP = "inapp";
    private static final String SUBS = "subs";
    private final BillingClientAdapter billingClientAdapter;
    private final GetTransactionData getTransactionData;
    private final GetTransactionRequest getTransactionRequest;
    private final ByteStringDataSource iapTransactionStore;
    private final IsBillingClientAvailable isBillingClientAvailable;
    private final ProductDetailsFetcher productDetailsFetcher;
    private final a0 scope;
    private final SendDiagnosticEvent sendDiagnosticEvent;
    private final SessionRepository sessionRepository;
    private final TransactionEventRepository transactionEventRepository;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: renamed from: com.unity3d.ads.core.data.manager.TransactionEventManager$invoke$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.unity3d.ads.core.data.manager.TransactionEventManager$invoke$1", f = "TransactionEventManager.kt", l = {162}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends i implements p {
        Object L$0;
        int label;

        public AnonymousClass1(c<? super AnonymousClass1> cVar) {
            super(2, cVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invokeSuspend$lambda$1(TransactionEventManager transactionEventManager, BillingResultBridge billingResultBridge, List list) {
            transactionEventManager.onPurchasesReceived(billingResultBridge, list, TransactionEventRequestOuterClass.TransactionOrigin.TRANSACTION_ORIGIN_HISTORICAL);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invokeSuspend$lambda$2(TransactionEventManager transactionEventManager, BillingResultBridge billingResultBridge, List list) {
            transactionEventManager.onPurchasesReceived(billingResultBridge, list, TransactionEventRequestOuterClass.TransactionOrigin.TRANSACTION_ORIGIN_HISTORICAL);
        }

        @Override // x5.a
        public final c<x> create(Object obj, c<?> cVar) {
            return TransactionEventManager.this.new AnonymousClass1(cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            w5.a aVar = w5.a.f17774a;
            int i2 = this.label;
            try {
            } catch (Exception unused) {
                SendDiagnosticEvent.DefaultImpls.invoke$default(TransactionEventManager.this.sendDiagnosticEvent, "billing_service_unavailable", null, null, null, null, null, 62, null);
            }
            if (i2 == 0) {
                q.z0(obj);
                if (!TransactionEventManager.this.billingClientAdapter.isInitialized()) {
                    final TransactionEventManager transactionEventManager = TransactionEventManager.this;
                    this.L$0 = transactionEventManager;
                    this.label = 1;
                    final l lVar = new l(1, a.a.I(this));
                    lVar.r();
                    transactionEventManager.billingClientAdapter.initialize(new BillingInitializationListener() { // from class: com.unity3d.ads.core.data.manager.TransactionEventManager$invoke$1$1$1
                        private final q0 hasBeenResumed = x0.c(Boolean.FALSE);

                        private final void tryResume() {
                            d1 d1Var;
                            Object value;
                            Boolean bool;
                            if (lVar.isActive()) {
                                q0 q0Var = this.hasBeenResumed;
                                do {
                                    d1Var = (d1) q0Var;
                                    value = d1Var.getValue();
                                    bool = (Boolean) value;
                                    bool.getClass();
                                } while (!d1Var.g(value, Boolean.TRUE));
                                if (bool.booleanValue()) {
                                    return;
                                }
                                lVar.resumeWith(x.f13520a);
                            }
                        }

                        private final void tryResumeWithException(Exception exc) {
                            d1 d1Var;
                            Object value;
                            Boolean bool;
                            if (lVar.isActive()) {
                                q0 q0Var = this.hasBeenResumed;
                                do {
                                    d1Var = (d1) q0Var;
                                    value = d1Var.getValue();
                                    bool = (Boolean) value;
                                    bool.getClass();
                                } while (!d1Var.g(value, Boolean.TRUE));
                                if (bool.booleanValue()) {
                                    return;
                                }
                                lVar.resumeWith(q.M(exc));
                            }
                        }

                        public final q0 getHasBeenResumed() {
                            return this.hasBeenResumed;
                        }

                        @Override // com.unity3d.services.store.gpbl.listeners.BillingClientStateListener
                        public void onBillingServiceDisconnected() {
                            tryResumeWithException(new TransactionException("Billing service disconnected"));
                        }

                        @Override // com.unity3d.services.store.gpbl.listeners.BillingClientStateListener
                        public void onBillingSetupFinished(BillingResultBridge billingResult) {
                            k.e(billingResult, "billingResult");
                            if (billingResult.getResponseCode() != BillingResultResponseCode.OK) {
                                tryResumeWithException(new TransactionException("Billing setup failed"));
                            } else {
                                tryResume();
                            }
                        }

                        @Override // com.unity3d.services.store.gpbl.listeners.BillingInitializationListener
                        public void onIsAlreadyInitialized() {
                            tryResume();
                        }

                        @Override // com.unity3d.services.store.gpbl.listeners.PurchaseUpdatedResponseListener
                        public void onPurchaseUpdated(BillingResultBridge billingResult, List<? extends PurchaseBridge> list) {
                            k.e(billingResult, "billingResult");
                            transactionEventManager.onPurchasesReceived(billingResult, list, TransactionEventRequestOuterClass.TransactionOrigin.TRANSACTION_ORIGIN_LIVE_UPDATE);
                        }
                    });
                    if (lVar.p() == aVar) {
                        return aVar;
                    }
                }
                return x.f13520a;
            }
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            q.z0(obj);
            if (TransactionEventManager.this.sessionRepository.getNativeConfiguration().getFeatureFlags().getShouldSendIapHistory()) {
                BillingClientAdapter billingClientAdapter = TransactionEventManager.this.billingClientAdapter;
                final TransactionEventManager transactionEventManager2 = TransactionEventManager.this;
                final int i8 = 0;
                billingClientAdapter.queryPurchasesAsync(TransactionEventManager.INAPP, new PurchasesResponseListener() { // from class: com.unity3d.ads.core.data.manager.a
                    @Override // com.unity3d.services.store.gpbl.listeners.PurchasesResponseListener
                    public final void onPurchaseResponse(BillingResultBridge billingResultBridge, List list) {
                        switch (i8) {
                            case 0:
                                TransactionEventManager.AnonymousClass1.invokeSuspend$lambda$1(transactionEventManager2, billingResultBridge, list);
                                break;
                            default:
                                TransactionEventManager.AnonymousClass1.invokeSuspend$lambda$2(transactionEventManager2, billingResultBridge, list);
                                break;
                        }
                    }
                });
                BillingClientAdapter billingClientAdapter2 = TransactionEventManager.this.billingClientAdapter;
                final TransactionEventManager transactionEventManager3 = TransactionEventManager.this;
                final int i9 = 1;
                billingClientAdapter2.queryPurchasesAsync(TransactionEventManager.SUBS, new PurchasesResponseListener() { // from class: com.unity3d.ads.core.data.manager.a
                    @Override // com.unity3d.services.store.gpbl.listeners.PurchasesResponseListener
                    public final void onPurchaseResponse(BillingResultBridge billingResultBridge, List list) {
                        switch (i9) {
                            case 0:
                                TransactionEventManager.AnonymousClass1.invokeSuspend$lambda$1(transactionEventManager3, billingResultBridge, list);
                                break;
                            default:
                                TransactionEventManager.AnonymousClass1.invokeSuspend$lambda$2(transactionEventManager3, billingResultBridge, list);
                                break;
                        }
                    }
                });
            }
            return x.f13520a;
        }

        @Override // e6.p
        public final Object invoke(a0 a0Var, c<? super x> cVar) {
            return ((AnonymousClass1) create(a0Var, cVar)).invokeSuspend(x.f13520a);
        }
    }

    /* JADX INFO: renamed from: com.unity3d.ads.core.data.manager.TransactionEventManager$onPurchasesReceived$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.unity3d.ads.core.data.manager.TransactionEventManager$onPurchasesReceived$1", f = "TransactionEventManager.kt", l = {Sdk.SDKError.Reason.OMSDK_DOWNLOAD_JS_ERROR_VALUE, Sdk.SDKError.Reason.INVALID_CONFIG_RESPONSE_VALUE, 148, 151}, m = "invokeSuspend")
    public static final class C28891 extends i implements p {
        final /* synthetic */ List<PurchaseBridge> $purchases;
        final /* synthetic */ TransactionEventRequestOuterClass.TransactionOrigin $transactionOrigin;
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        int label;
        final /* synthetic */ TransactionEventManager this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C28891(List<? extends PurchaseBridge> list, TransactionEventManager transactionEventManager, TransactionEventRequestOuterClass.TransactionOrigin transactionOrigin, c<? super C28891> cVar) {
            super(2, cVar);
            this.$purchases = list;
            this.this$0 = transactionEventManager;
            this.$transactionOrigin = transactionOrigin;
        }

        @Override // x5.a
        public final c<x> create(Object obj, c<?> cVar) {
            return new C28891(this.$purchases, this.this$0, this.$transactionOrigin, cVar);
        }

        /* JADX WARN: Can't wrap try/catch for region: R(17:12|137|13|14|125|68|(1:70)|75|76|119|77|78|86|89|26|(2:28|(19:30|123|31|32|135|33|34|(1:37)|(2:129|39)(1:43)|44|(1:46)(1:47)|(2:53|(8:56|141|57|58|121|59|60|(6:131|62|63|139|64|(13:67|125|68|(0)|75|76|119|77|78|86|89|26|(3:92|(1:94)(9:95|(1:97)|143|98|(1:100)|144|101|(1:103)(1:104)|105)|(3:108|(0)|114))(0)))(10:74|75|76|119|77|78|86|89|26|(0)(0))))|84|127|85|86|89|26|(0)(0))(2:90|91))(0)|112) */
        /* JADX WARN: Can't wrap try/catch for region: R(19:30|(1:123)|31|32|135|33|34|(1:37)|(2:129|39)(1:43)|44|(1:46)(1:47)|(2:53|(8:56|141|57|58|121|59|60|(6:131|62|63|139|64|(13:67|125|68|(0)|75|76|119|77|78|86|89|26|(3:92|(1:94)(9:95|(1:97)|143|98|(1:100)|144|101|(1:103)(1:104)|105)|(3:108|(0)|114))(0)))(10:74|75|76|119|77|78|86|89|26|(0)(0))))|84|127|85|86|89|26|(0)(0)) */
        /* JADX WARN: Can't wrap try/catch for region: R(6:(1:131)|62|63|139|64|(13:67|125|68|(0)|75|76|119|77|78|86|89|26|(3:92|(1:94)(9:95|(1:97)|143|98|(1:100)|144|101|(1:103)(1:104)|105)|(3:108|(0)|114))(0))) */
        /* JADX WARN: Can't wrap try/catch for region: R(8:56|141|57|58|121|59|60|(6:131|62|63|139|64|(13:67|125|68|(0)|75|76|119|77|78|86|89|26|(3:92|(1:94)(9:95|(1:97)|143|98|(1:100)|144|101|(1:103)(1:104)|105)|(3:108|(0)|114))(0)))(10:74|75|76|119|77|78|86|89|26|(0)(0))) */
        /* JADX WARN: Code restructure failed: missing block: B:111:0x02a9, code lost:
        
            if (r2 == r1) goto L112;
         */
        /* JADX WARN: Code restructure failed: missing block: B:71:0x01b2, code lost:
        
            r12 = r14;
            r4 = r16;
         */
        /* JADX WARN: Code restructure failed: missing block: B:72:0x01b5, code lost:
        
            r14 = r3;
         */
        /* JADX WARN: Code restructure failed: missing block: B:79:0x01cb, code lost:
        
            r12 = r14;
         */
        /* JADX WARN: Code restructure failed: missing block: B:80:0x01cd, code lost:
        
            r4 = r16;
            r6 = 2;
         */
        /* JADX WARN: Code restructure failed: missing block: B:82:0x01d5, code lost:
        
            r6 = r5;
            r4 = r16;
         */
        /* JADX WARN: Code restructure failed: missing block: B:83:0x01d8, code lost:
        
            r15 = r2;
            r2 = r3;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:110:0x028e  */
        /* JADX WARN: Removed duplicated region for block: B:131:0x0176 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:28:0x00cb  */
        /* JADX WARN: Removed duplicated region for block: B:70:0x01a0 A[Catch: Exception -> 0x010b, TryCatch #3 {Exception -> 0x010b, blocks: (B:68:0x019a, B:70:0x01a0, B:75:0x01bc), top: B:125:0x019a }] */
        /* JADX WARN: Removed duplicated region for block: B:74:0x01b9  */
        /* JADX WARN: Removed duplicated region for block: B:92:0x0202  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:67:0x0197 -> B:125:0x019a). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:74:0x01b9 -> B:75:0x01bc). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:85:0x01de -> B:86:0x01e9). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:88:0x01ee -> B:78:0x01c9). Please report as a decompilation issue!!! */
        @Override // x5.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r21) throws java.lang.Throwable {
            /*
                Method dump skipped, instruction units count: 696
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.core.data.manager.TransactionEventManager.C28891.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // e6.p
        public final Object invoke(a0 a0Var, c<? super x> cVar) {
            return ((C28891) create(a0Var, cVar)).invokeSuspend(x.f13520a);
        }
    }

    public TransactionEventManager(a0 scope, BillingClientAdapter billingClientAdapter, GetTransactionData getTransactionData, GetTransactionRequest getTransactionRequest, TransactionEventRepository transactionEventRepository, ByteStringDataSource iapTransactionStore, SendDiagnosticEvent sendDiagnosticEvent, IsBillingClientAvailable isBillingClientAvailable, SessionRepository sessionRepository, ProductDetailsFetcher productDetailsFetcher) {
        k.e(scope, "scope");
        k.e(getTransactionData, "getTransactionData");
        k.e(getTransactionRequest, "getTransactionRequest");
        k.e(transactionEventRepository, "transactionEventRepository");
        k.e(iapTransactionStore, "iapTransactionStore");
        k.e(sendDiagnosticEvent, "sendDiagnosticEvent");
        k.e(isBillingClientAvailable, "isBillingClientAvailable");
        k.e(sessionRepository, "sessionRepository");
        k.e(productDetailsFetcher, "productDetailsFetcher");
        this.scope = scope;
        this.billingClientAdapter = billingClientAdapter;
        this.getTransactionData = getTransactionData;
        this.getTransactionRequest = getTransactionRequest;
        this.transactionEventRepository = transactionEventRepository;
        this.iapTransactionStore = iapTransactionStore;
        this.sendDiagnosticEvent = sendDiagnosticEvent;
        this.isBillingClientAvailable = isBillingClientAvailable;
        this.sessionRepository = sessionRepository;
        this.productDetailsFetcher = productDetailsFetcher;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onPurchasesReceived(BillingResultBridge billingResultBridge, List<? extends PurchaseBridge> list, TransactionEventRequestOuterClass.TransactionOrigin transactionOrigin) {
        if (billingResultBridge.getResponseCode() != BillingResultResponseCode.OK || list == null || list.isEmpty() || this.billingClientAdapter == null) {
            return;
        }
        c0.u(this.scope, null, new C28891(list, this, transactionOrigin, null), 3);
    }

    public final void invoke() {
        if (!this.isBillingClientAvailable.invoke() || this.billingClientAdapter == null) {
            SendDiagnosticEvent.DefaultImpls.invoke$default(this.sendDiagnosticEvent, "billing_service_unavailable", null, null, null, null, null, 62, null);
        } else {
            c0.u(this.scope, null, new AnonymousClass1(null), 3);
        }
    }
}
