package com.onesignal.user.internal.operations.impl.executors;

import com.onesignal.common.NetworkUtils;
import com.onesignal.common.consistency.models.IConsistencyManager;
import com.onesignal.core.internal.application.IApplicationService;
import com.onesignal.core.internal.config.ConfigModelStore;
import com.onesignal.core.internal.device.IDeviceService;
import com.onesignal.core.internal.operations.ExecutionResponse;
import com.onesignal.core.internal.operations.IOperationExecutor;
import com.onesignal.core.internal.operations.Operation;
import com.onesignal.debug.LogLevel;
import com.onesignal.debug.internal.logging.Logging;
import com.onesignal.user.internal.backend.ISubscriptionBackendService;
import com.onesignal.user.internal.backend.SubscriptionObjectType;
import com.onesignal.user.internal.builduser.IRebuildUserService;
import com.onesignal.user.internal.operations.CreateSubscriptionOperation;
import com.onesignal.user.internal.operations.DeleteSubscriptionOperation;
import com.onesignal.user.internal.operations.TransferSubscriptionOperation;
import com.onesignal.user.internal.operations.UpdateSubscriptionOperation;
import com.onesignal.user.internal.operations.impl.states.NewRecordsState;
import com.onesignal.user.internal.subscriptions.SubscriptionModelStore;
import com.onesignal.user.internal.subscriptions.SubscriptionType;
import com.vungle.ads.internal.protos.Sdk;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import r5.l;
import r5.m;
import x5.c;
import x5.e;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class SubscriptionOperationExecutor implements IOperationExecutor {
    public static final String CREATE_SUBSCRIPTION = "create-subscription";
    public static final Companion Companion = new Companion(null);
    public static final String DELETE_SUBSCRIPTION = "delete-subscription";
    public static final String TRANSFER_SUBSCRIPTION = "transfer-subscription";
    public static final String UPDATE_SUBSCRIPTION = "update-subscription";
    private final IApplicationService _applicationService;
    private final IRebuildUserService _buildUserService;
    private final ConfigModelStore _configModelStore;
    private final IConsistencyManager _consistencyManager;
    private final IDeviceService _deviceService;
    private final NewRecordsState _newRecordState;
    private final ISubscriptionBackendService _subscriptionBackend;
    private final SubscriptionModelStore _subscriptionModelStore;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[NetworkUtils.ResponseStatusType.values().length];
            iArr[NetworkUtils.ResponseStatusType.RETRYABLE.ordinal()] = 1;
            iArr[NetworkUtils.ResponseStatusType.CONFLICT.ordinal()] = 2;
            iArr[NetworkUtils.ResponseStatusType.INVALID.ordinal()] = 3;
            iArr[NetworkUtils.ResponseStatusType.UNAUTHORIZED.ordinal()] = 4;
            iArr[NetworkUtils.ResponseStatusType.MISSING.ordinal()] = 5;
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[SubscriptionType.values().length];
            iArr2[SubscriptionType.SMS.ordinal()] = 1;
            iArr2[SubscriptionType.EMAIL.ordinal()] = 2;
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    /* JADX INFO: renamed from: com.onesignal.user.internal.operations.impl.executors.SubscriptionOperationExecutor$createSubscription$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.onesignal.user.internal.operations.impl.executors.SubscriptionOperationExecutor", f = "SubscriptionOperationExecutor.kt", l = {111, Sdk.SDKError.Reason.INVALID_ADS_ENDPOINT_VALUE, Sdk.SDKError.Reason.INVALID_LOG_ERROR_ENDPOINT_VALUE}, m = "createSubscription")
    public static final class AnonymousClass1 extends c {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(v5.c<? super AnonymousClass1> cVar) {
            super(cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SubscriptionOperationExecutor.this.createSubscription(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.onesignal.user.internal.operations.impl.executors.SubscriptionOperationExecutor$deleteSubscription$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.onesignal.user.internal.operations.impl.executors.SubscriptionOperationExecutor", f = "SubscriptionOperationExecutor.kt", l = {279}, m = "deleteSubscription")
    public static final class C28411 extends c {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C28411(v5.c<? super C28411> cVar) {
            super(cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SubscriptionOperationExecutor.this.deleteSubscription(null, this);
        }
    }

    /* JADX INFO: renamed from: com.onesignal.user.internal.operations.impl.executors.SubscriptionOperationExecutor$transferSubscription$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.onesignal.user.internal.operations.impl.executors.SubscriptionOperationExecutor", f = "SubscriptionOperationExecutor.kt", l = {243}, m = "transferSubscription")
    public static final class C28421 extends c {
        int label;
        /* synthetic */ Object result;

        public C28421(v5.c<? super C28421> cVar) {
            super(cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SubscriptionOperationExecutor.this.transferSubscription(null, this);
        }
    }

    /* JADX INFO: renamed from: com.onesignal.user.internal.operations.impl.executors.SubscriptionOperationExecutor$updateSubscription$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.onesignal.user.internal.operations.impl.executors.SubscriptionOperationExecutor", f = "SubscriptionOperationExecutor.kt", l = {193, 196, 198}, m = "updateSubscription")
    public static final class C28431 extends c {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public C28431(v5.c<? super C28431> cVar) {
            super(cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SubscriptionOperationExecutor.this.updateSubscription(null, null, this);
        }
    }

    public SubscriptionOperationExecutor(ISubscriptionBackendService _subscriptionBackend, IDeviceService _deviceService, IApplicationService _applicationService, SubscriptionModelStore _subscriptionModelStore, ConfigModelStore _configModelStore, IRebuildUserService _buildUserService, NewRecordsState _newRecordState, IConsistencyManager _consistencyManager) {
        k.e(_subscriptionBackend, "_subscriptionBackend");
        k.e(_deviceService, "_deviceService");
        k.e(_applicationService, "_applicationService");
        k.e(_subscriptionModelStore, "_subscriptionModelStore");
        k.e(_configModelStore, "_configModelStore");
        k.e(_buildUserService, "_buildUserService");
        k.e(_newRecordState, "_newRecordState");
        k.e(_consistencyManager, "_consistencyManager");
        this._subscriptionBackend = _subscriptionBackend;
        this._deviceService = _deviceService;
        this._applicationService = _applicationService;
        this._subscriptionModelStore = _subscriptionModelStore;
        this._configModelStore = _configModelStore;
        this._buildUserService = _buildUserService;
        this._newRecordState = _newRecordState;
        this._consistencyManager = _consistencyManager;
    }

    private final SubscriptionObjectType convert(SubscriptionType subscriptionType) {
        int i2 = WhenMappings.$EnumSwitchMapping$1[subscriptionType.ordinal()];
        return i2 != 1 ? i2 != 2 ? SubscriptionObjectType.Companion.fromDeviceType(this._deviceService.getDeviceType()) : SubscriptionObjectType.EMAIL : SubscriptionObjectType.SMS;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x01b2, code lost:
    
        if (r0.resolveConditionsWithID(com.onesignal.common.consistency.IamFetchReadyCondition.ID, r9) == r3) goto L85;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:100:0x022a  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x02ab  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0169 A[Catch: BackendException -> 0x017a, TryCatch #4 {BackendException -> 0x017a, blocks: (B:70:0x0165, B:72:0x0169, B:76:0x017d, B:78:0x0187, B:83:0x01a2), top: B:132:0x0165 }] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x017d A[Catch: BackendException -> 0x017a, TryCatch #4 {BackendException -> 0x017a, blocks: (B:70:0x0165, B:72:0x0169, B:76:0x017d, B:78:0x0187, B:83:0x01a2), top: B:132:0x0165 }] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x01c4 A[Catch: BackendException -> 0x0042, TryCatch #3 {BackendException -> 0x0042, blocks: (B:15:0x003d, B:86:0x01b5, B:88:0x01c4, B:89:0x01d1, B:91:0x01e7, B:92:0x01f2), top: B:130:0x003d }] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001a  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x01e7 A[Catch: BackendException -> 0x0042, TryCatch #3 {BackendException -> 0x0042, blocks: (B:15:0x003d, B:86:0x01b5, B:88:0x01c4, B:89:0x01d1, B:91:0x01e7, B:92:0x01f2), top: B:130:0x003d }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object createSubscription(com.onesignal.user.internal.operations.CreateSubscriptionOperation r27, java.util.List<? extends com.onesignal.core.internal.operations.Operation> r28, v5.c<? super com.onesignal.core.internal.operations.ExecutionResponse> r29) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 700
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.user.internal.operations.impl.executors.SubscriptionOperationExecutor.createSubscription(com.onesignal.user.internal.operations.CreateSubscriptionOperation, java.util.List, v5.c):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object deleteSubscription(com.onesignal.user.internal.operations.DeleteSubscriptionOperation r12, v5.c<? super com.onesignal.core.internal.operations.ExecutionResponse> r13) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 254
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.user.internal.operations.impl.executors.SubscriptionOperationExecutor.deleteSubscription(com.onesignal.user.internal.operations.DeleteSubscriptionOperation, v5.c):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object transferSubscription(com.onesignal.user.internal.operations.TransferSubscriptionOperation r9, v5.c<? super com.onesignal.core.internal.operations.ExecutionResponse> r10) throws java.lang.Throwable {
        /*
            r8 = this;
            boolean r0 = r10 instanceof com.onesignal.user.internal.operations.impl.executors.SubscriptionOperationExecutor.C28421
            if (r0 == 0) goto L14
            r0 = r10
            com.onesignal.user.internal.operations.impl.executors.SubscriptionOperationExecutor$transferSubscription$1 r0 = (com.onesignal.user.internal.operations.impl.executors.SubscriptionOperationExecutor.C28421) r0
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
            com.onesignal.user.internal.operations.impl.executors.SubscriptionOperationExecutor$transferSubscription$1 r0 = new com.onesignal.user.internal.operations.impl.executors.SubscriptionOperationExecutor$transferSubscription$1
            r0.<init>(r10)
            goto L12
        L1a:
            java.lang.Object r10 = r6.result
            w5.a r0 = w5.a.f17774a
            int r1 = r6.label
            r7 = 1
            if (r1 == 0) goto L34
            if (r1 != r7) goto L2c
            r2.q.z0(r10)     // Catch: com.onesignal.common.exceptions.BackendException -> L29
            goto L50
        L29:
            r0 = move-exception
            r9 = r0
            goto L5e
        L2c:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L34:
            r2.q.z0(r10)
            com.onesignal.user.internal.backend.ISubscriptionBackendService r1 = r8._subscriptionBackend     // Catch: com.onesignal.common.exceptions.BackendException -> L29
            java.lang.String r2 = r9.getAppId()     // Catch: com.onesignal.common.exceptions.BackendException -> L29
            java.lang.String r3 = r9.getSubscriptionId()     // Catch: com.onesignal.common.exceptions.BackendException -> L29
            java.lang.String r4 = "onesignal_id"
            java.lang.String r5 = r9.getOnesignalId()     // Catch: com.onesignal.common.exceptions.BackendException -> L29
            r6.label = r7     // Catch: com.onesignal.common.exceptions.BackendException -> L29
            java.lang.Object r9 = r1.transferSubscription(r2, r3, r4, r5, r6)     // Catch: com.onesignal.common.exceptions.BackendException -> L29
            if (r9 != r0) goto L50
            return r0
        L50:
            com.onesignal.core.internal.operations.ExecutionResponse r1 = new com.onesignal.core.internal.operations.ExecutionResponse
            com.onesignal.core.internal.operations.ExecutionResult r2 = com.onesignal.core.internal.operations.ExecutionResult.SUCCESS
            r6 = 14
            r7 = 0
            r3 = 0
            r4 = 0
            r5 = 0
            r1.<init>(r2, r3, r4, r5, r6, r7)
            return r1
        L5e:
            com.onesignal.common.NetworkUtils r10 = com.onesignal.common.NetworkUtils.INSTANCE
            int r0 = r9.getStatusCode()
            com.onesignal.common.NetworkUtils$ResponseStatusType r10 = r10.getResponseStatusType(r0)
            int[] r0 = com.onesignal.user.internal.operations.impl.executors.SubscriptionOperationExecutor.WhenMappings.$EnumSwitchMapping$0
            int r10 = r10.ordinal()
            r10 = r0[r10]
            if (r10 != r7) goto L82
            com.onesignal.core.internal.operations.ExecutionResponse r0 = new com.onesignal.core.internal.operations.ExecutionResponse
            com.onesignal.core.internal.operations.ExecutionResult r1 = com.onesignal.core.internal.operations.ExecutionResult.FAIL_RETRY
            java.lang.Integer r4 = r9.getRetryAfterSeconds()
            r5 = 6
            r6 = 0
            r2 = 0
            r3 = 0
            r0.<init>(r1, r2, r3, r4, r5, r6)
            goto L90
        L82:
            com.onesignal.core.internal.operations.ExecutionResponse r1 = new com.onesignal.core.internal.operations.ExecutionResponse
            com.onesignal.core.internal.operations.ExecutionResult r2 = com.onesignal.core.internal.operations.ExecutionResult.FAIL_NORETRY
            r6 = 14
            r7 = 0
            r3 = 0
            r4 = 0
            r5 = 0
            r1.<init>(r2, r3, r4, r5, r6, r7)
            r0 = r1
        L90:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.user.internal.operations.impl.executors.SubscriptionOperationExecutor.transferSubscription(com.onesignal.user.internal.operations.TransferSubscriptionOperation, v5.c):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x010c, code lost:
    
        if (r0.resolveConditionsWithID(com.onesignal.common.consistency.IamFetchReadyCondition.ID, r2) == r3) goto L37;
     */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00e5 A[Catch: BackendException -> 0x0056, TryCatch #1 {BackendException -> 0x0056, blocks: (B:21:0x0051, B:30:0x00e0, B:32:0x00e5, B:35:0x00fc), top: B:64:0x0051 }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00fc A[Catch: BackendException -> 0x0056, TRY_LEAVE, TryCatch #1 {BackendException -> 0x0056, blocks: (B:21:0x0051, B:30:0x00e0, B:32:0x00e5, B:35:0x00fc), top: B:64:0x0051 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object updateSubscription(com.onesignal.user.internal.operations.UpdateSubscriptionOperation r22, java.util.List<? extends com.onesignal.core.internal.operations.Operation> r23, v5.c<? super com.onesignal.core.internal.operations.ExecutionResponse> r24) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 465
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.user.internal.operations.impl.executors.SubscriptionOperationExecutor.updateSubscription(com.onesignal.user.internal.operations.UpdateSubscriptionOperation, java.util.List, v5.c):java.lang.Object");
    }

    @Override // com.onesignal.core.internal.operations.IOperationExecutor
    public Object execute(List<? extends Operation> list, v5.c<? super ExecutionResponse> cVar) throws Exception {
        Logging.log(LogLevel.DEBUG, "SubscriptionOperationExecutor(operations: " + list + ')');
        Operation operation = (Operation) l.X0(list);
        if (operation instanceof CreateSubscriptionOperation) {
            return createSubscription((CreateSubscriptionOperation) operation, list, cVar);
        }
        if (!list.isEmpty()) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                if (((Operation) it.next()) instanceof DeleteSubscriptionOperation) {
                    if (list.size() > 1) {
                        throw new Exception("Only supports one operation! Attempted operations:\n" + list);
                    }
                    ArrayList arrayList = new ArrayList();
                    for (Object obj : list) {
                        if (obj instanceof DeleteSubscriptionOperation) {
                            arrayList.add(obj);
                        }
                    }
                    return deleteSubscription((DeleteSubscriptionOperation) l.X0(arrayList), cVar);
                }
            }
        }
        if (operation instanceof UpdateSubscriptionOperation) {
            return updateSubscription((UpdateSubscriptionOperation) operation, list, cVar);
        }
        if (!(operation instanceof TransferSubscriptionOperation)) {
            throw new Exception("Unrecognized operation: " + operation);
        }
        if (list.size() <= 1) {
            return transferSubscription((TransferSubscriptionOperation) operation, cVar);
        }
        throw new Exception("TransferSubscriptionOperation only supports one operation! Attempted operations:\n" + list);
    }

    @Override // com.onesignal.core.internal.operations.IOperationExecutor
    public List<String> getOperations() {
        return m.H0(CREATE_SUBSCRIPTION, UPDATE_SUBSCRIPTION, DELETE_SUBSCRIPTION, TRANSFER_SUBSCRIPTION);
    }
}
