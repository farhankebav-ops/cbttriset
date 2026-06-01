package com.onesignal.core.internal.operations.impl;

import com.onesignal.common.modeling.IModelStore;
import com.onesignal.common.threading.OSPrimaryCoroutineScope;
import com.onesignal.common.threading.WaiterWithValue;
import com.onesignal.core.internal.config.ConfigModelStore;
import com.onesignal.core.internal.operations.ExecutionResult;
import com.onesignal.core.internal.operations.GroupComparisonType;
import com.onesignal.core.internal.operations.IOperationExecutor;
import com.onesignal.core.internal.operations.IOperationRepo;
import com.onesignal.core.internal.operations.Operation;
import com.onesignal.core.internal.startup.IStartableService;
import com.onesignal.core.internal.time.ITime;
import com.onesignal.debug.LogLevel;
import com.onesignal.debug.internal.logging.Logging;
import com.onesignal.user.internal.operations.impl.states.NewRecordsState;
import com.vungle.ads.internal.protos.Sdk;
import e6.l;
import e6.p;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import q5.x;
import q6.a0;
import q6.c0;
import q6.q;
import q6.r;
import r5.m;
import v5.c;
import w5.a;
import x5.e;
import x5.i;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class OperationRepo implements IOperationRepo, IStartableService {
    private final ConfigModelStore _configModelStore;
    private final NewRecordsState _newRecordState;
    private final OperationModelStore _operationModelStore;
    private final ITime _time;
    private a0 coroutineScope;
    private int enqueueIntoBucket;
    private final Map<String, IOperationExecutor> executorsMap;
    private final q initialized;
    private boolean paused;
    private final List<OperationQueueItem> queue;
    private final WaiterWithValue<LoopWaiterMessage> retryWaiter;
    private final WaiterWithValue<LoopWaiterMessage> waiter;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ExecutionResult.values().length];
            iArr[ExecutionResult.SUCCESS.ordinal()] = 1;
            iArr[ExecutionResult.FAIL_UNAUTHORIZED.ordinal()] = 2;
            iArr[ExecutionResult.FAIL_NORETRY.ordinal()] = 3;
            iArr[ExecutionResult.FAIL_CONFLICT.ordinal()] = 4;
            iArr[ExecutionResult.SUCCESS_STARTING_ONLY.ordinal()] = 5;
            iArr[ExecutionResult.FAIL_RETRY.ordinal()] = 6;
            iArr[ExecutionResult.FAIL_PAUSE_OPREPO.ordinal()] = 7;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: renamed from: com.onesignal.core.internal.operations.impl.OperationRepo$delayBeforeNextExecution$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.onesignal.core.internal.operations.impl.OperationRepo$delayBeforeNextExecution$2", f = "OperationRepo.kt", l = {346}, m = "invokeSuspend")
    public static final class AnonymousClass2 extends i implements p {
        int label;

        public AnonymousClass2(c<? super AnonymousClass2> cVar) {
            super(2, cVar);
        }

        @Override // x5.a
        public final c<x> create(Object obj, c<?> cVar) {
            return OperationRepo.this.new AnonymousClass2(cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            a aVar = a.f17774a;
            int i2 = this.label;
            if (i2 != 0) {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                r2.q.z0(obj);
                return obj;
            }
            r2.q.z0(obj);
            WaiterWithValue waiterWithValue = OperationRepo.this.retryWaiter;
            this.label = 1;
            Object objWaitForWake = waiterWithValue.waitForWake(this);
            return objWaitForWake == aVar ? aVar : objWaitForWake;
        }

        @Override // e6.p
        public final Object invoke(a0 a0Var, c<? super LoopWaiterMessage> cVar) {
            return ((AnonymousClass2) create(a0Var, cVar)).invokeSuspend(x.f13520a);
        }
    }

    /* JADX INFO: renamed from: com.onesignal.core.internal.operations.impl.OperationRepo$delayForPostCreate$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.onesignal.core.internal.operations.impl.OperationRepo", f = "OperationRepo.kt", l = {360}, m = "delayForPostCreate")
    public static final class AnonymousClass1 extends x5.c {
        long J$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(c<? super AnonymousClass1> cVar) {
            super(cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return OperationRepo.this.delayForPostCreate(0L, this);
        }
    }

    /* JADX INFO: renamed from: com.onesignal.core.internal.operations.impl.OperationRepo$enqueue$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.onesignal.core.internal.operations.impl.OperationRepo$enqueue$1", f = "OperationRepo.kt", l = {}, m = "invokeSuspend")
    public static final class C26991 extends i implements l {
        final /* synthetic */ boolean $flush;
        final /* synthetic */ Operation $operation;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C26991(Operation operation, boolean z2, c<? super C26991> cVar) {
            super(1, cVar);
            this.$operation = operation;
            this.$flush = z2;
        }

        @Override // x5.a
        public final c<x> create(c<?> cVar) {
            return OperationRepo.this.new C26991(this.$operation, this.$flush, cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            a aVar = a.f17774a;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            r2.q.z0(obj);
            OperationRepo operationRepo = OperationRepo.this;
            OperationRepo.internalEnqueue$default(operationRepo, new OperationQueueItem(this.$operation, null, operationRepo.enqueueIntoBucket, 0, 10, null), this.$flush, true, null, 8, null);
            return x.f13520a;
        }

        @Override // e6.l
        public final Object invoke(c<? super x> cVar) {
            return ((C26991) create(cVar)).invokeSuspend(x.f13520a);
        }
    }

    /* JADX INFO: renamed from: com.onesignal.core.internal.operations.impl.OperationRepo$processQueueForever$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.onesignal.core.internal.operations.impl.OperationRepo", f = "OperationRepo.kt", l = {174, 186, 189, 191}, m = "processQueueForever")
    public static final class C27001 extends x5.c {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C27001(c<? super C27001> cVar) {
            super(cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return OperationRepo.this.processQueueForever(this);
        }
    }

    /* JADX INFO: renamed from: com.onesignal.core.internal.operations.impl.OperationRepo$start$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.onesignal.core.internal.operations.impl.OperationRepo$start$1", f = "OperationRepo.kt", l = {102}, m = "invokeSuspend")
    public static final class C27011 extends i implements p {
        int label;

        public C27011(c<? super C27011> cVar) {
            super(2, cVar);
        }

        @Override // x5.a
        public final c<x> create(Object obj, c<?> cVar) {
            return OperationRepo.this.new C27011(cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            a aVar = a.f17774a;
            int i2 = this.label;
            if (i2 == 0) {
                r2.q.z0(obj);
                OperationRepo.this.loadSavedOperations$com_onesignal_core();
                OperationRepo operationRepo = OperationRepo.this;
                this.label = 1;
                if (operationRepo.processQueueForever(this) == aVar) {
                    return aVar;
                }
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                r2.q.z0(obj);
            }
            return x.f13520a;
        }

        @Override // e6.p
        public final Object invoke(a0 a0Var, c<? super x> cVar) {
            return ((C27011) create(a0Var, cVar)).invokeSuspend(x.f13520a);
        }
    }

    /* JADX INFO: renamed from: com.onesignal.core.internal.operations.impl.OperationRepo$waitForNewOperationAndExecutionInterval$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.onesignal.core.internal.operations.impl.OperationRepo", f = "OperationRepo.kt", l = {Sdk.SDKError.Reason.MRAID_JS_DOES_NOT_EXIST_VALUE, Sdk.SDKError.Reason.PRIVACY_ICON_FALLBACK_ERROR_VALUE}, m = "waitForNewOperationAndExecutionInterval")
    public static final class C27021 extends x5.c {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public C27021(c<? super C27021> cVar) {
            super(cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return OperationRepo.this.waitForNewOperationAndExecutionInterval(this);
        }
    }

    public OperationRepo(List<? extends IOperationExecutor> executors, OperationModelStore _operationModelStore, ConfigModelStore _configModelStore, ITime _time, NewRecordsState _newRecordState) {
        k.e(executors, "executors");
        k.e(_operationModelStore, "_operationModelStore");
        k.e(_configModelStore, "_configModelStore");
        k.e(_time, "_time");
        k.e(_newRecordState, "_newRecordState");
        this._operationModelStore = _operationModelStore;
        this._configModelStore = _configModelStore;
        this._time = _time;
        this._newRecordState = _newRecordState;
        this.queue = new ArrayList();
        this.waiter = new WaiterWithValue<>();
        this.retryWaiter = new WaiterWithValue<>();
        this.coroutineScope = c0.b(c0.w("OpRepo"));
        this.initialized = c0.a();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (IOperationExecutor iOperationExecutor : executors) {
            Iterator<String> it = iOperationExecutor.getOperations().iterator();
            while (it.hasNext()) {
                linkedHashMap.put(it.next(), iOperationExecutor);
            }
        }
        this.executorsMap = linkedHashMap;
    }

    private final int getExecuteBucket() {
        int i2 = this.enqueueIntoBucket;
        if (i2 == 0) {
            return 0;
        }
        return i2 - 1;
    }

    private final List<OperationQueueItem> getGroupableOperations(OperationQueueItem operationQueueItem) throws Exception {
        ArrayList arrayListI0 = m.I0(operationQueueItem);
        if (operationQueueItem.getOperation().getGroupComparisonType() != GroupComparisonType.NONE) {
            String createComparisonKey = operationQueueItem.getOperation().getGroupComparisonType() == GroupComparisonType.CREATE ? operationQueueItem.getOperation().getCreateComparisonKey() : operationQueueItem.getOperation().getModifyComparisonKey();
            for (OperationQueueItem operationQueueItem2 : r5.l.n1(this.queue)) {
                String createComparisonKey2 = operationQueueItem.getOperation().getGroupComparisonType() == GroupComparisonType.CREATE ? operationQueueItem2.getOperation().getCreateComparisonKey() : operationQueueItem2.getOperation().getModifyComparisonKey();
                if (k.a(createComparisonKey2, "") && k.a(createComparisonKey, "")) {
                    throw new Exception("Both comparison keys can not be blank!");
                }
                if (this._newRecordState.canAccess(operationQueueItem2.getOperation().getApplyToRecordId()) && k.a(createComparisonKey2, createComparisonKey)) {
                    this.queue.remove(operationQueueItem2);
                    arrayListI0.add(operationQueueItem2);
                }
            }
        }
        return arrayListI0;
    }

    private final void internalEnqueue(OperationQueueItem operationQueueItem, boolean z2, boolean z7, Integer num) {
        synchronized (this.queue) {
            try {
                List<OperationQueueItem> list = this.queue;
                if (!(list != null) || !list.isEmpty()) {
                    Iterator<T> it = list.iterator();
                    while (it.hasNext()) {
                        if (k.a(((OperationQueueItem) it.next()).getOperation().getId(), operationQueueItem.getOperation().getId())) {
                            Logging.debug$default("OperationRepo: internalEnqueue - operation.id: " + operationQueueItem.getOperation().getId() + " already exists in the queue.", null, 2, null);
                            return;
                        }
                    }
                }
                if (num != null) {
                    this.queue.add(num.intValue(), operationQueueItem);
                } else {
                    this.queue.add(operationQueueItem);
                }
                if (z7) {
                    IModelStore.DefaultImpls.add$default(this._operationModelStore, operationQueueItem.getOperation(), null, 2, null);
                }
                this.waiter.wake(new LoopWaiterMessage(z2, 0L));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static /* synthetic */ void internalEnqueue$default(OperationRepo operationRepo, OperationQueueItem operationQueueItem, boolean z2, boolean z7, Integer num, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            num = null;
        }
        operationRepo.internalEnqueue(operationQueueItem, z2, z7, num);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00bb, code lost:
    
        if (r2.waitForNewOperationAndExecutionInterval(r0) == r1) goto L39;
     */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0069 A[PHI: r2
  0x0069: PHI (r2v4 com.onesignal.core.internal.operations.impl.OperationRepo) = 
  (r2v2 com.onesignal.core.internal.operations.impl.OperationRepo)
  (r2v3 com.onesignal.core.internal.operations.impl.OperationRepo)
  (r2v5 com.onesignal.core.internal.operations.impl.OperationRepo)
  (r2v11 com.onesignal.core.internal.operations.impl.OperationRepo)
 binds: [B:24:0x0064, B:35:0x00b0, B:40:0x00be, B:17:0x003d] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:35:0x00b0 -> B:25:0x0069). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x00bb -> B:40:0x00be). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object processQueueForever(v5.c<? super q5.x> r11) throws java.lang.Throwable {
        /*
            r10 = this;
            boolean r0 = r11 instanceof com.onesignal.core.internal.operations.impl.OperationRepo.C27001
            if (r0 == 0) goto L13
            r0 = r11
            com.onesignal.core.internal.operations.impl.OperationRepo$processQueueForever$1 r0 = (com.onesignal.core.internal.operations.impl.OperationRepo.C27001) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.onesignal.core.internal.operations.impl.OperationRepo$processQueueForever$1 r0 = new com.onesignal.core.internal.operations.impl.OperationRepo$processQueueForever$1
            r0.<init>(r11)
        L18:
            java.lang.Object r11 = r0.result
            w5.a r1 = w5.a.f17774a
            int r2 = r0.label
            r3 = 4
            r4 = 3
            r5 = 2
            r6 = 1
            if (r2 == 0) goto L55
            if (r2 == r6) goto L4d
            if (r2 == r5) goto L45
            if (r2 == r4) goto L3d
            if (r2 != r3) goto L35
            java.lang.Object r2 = r0.L$0
            com.onesignal.core.internal.operations.impl.OperationRepo r2 = (com.onesignal.core.internal.operations.impl.OperationRepo) r2
            r2.q.z0(r11)
            goto Lbe
        L35:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L3d:
            java.lang.Object r2 = r0.L$0
            com.onesignal.core.internal.operations.impl.OperationRepo r2 = (com.onesignal.core.internal.operations.impl.OperationRepo) r2
            r2.q.z0(r11)
            goto L69
        L45:
            java.lang.Object r2 = r0.L$0
            com.onesignal.core.internal.operations.impl.OperationRepo r2 = (com.onesignal.core.internal.operations.impl.OperationRepo) r2
            r2.q.z0(r11)
            goto L9c
        L4d:
            java.lang.Object r2 = r0.L$0
            com.onesignal.core.internal.operations.impl.OperationRepo r2 = (com.onesignal.core.internal.operations.impl.OperationRepo) r2
            r2.q.z0(r11)
            goto L64
        L55:
            r2.q.z0(r11)
            r0.L$0 = r10
            r0.label = r6
            java.lang.Object r11 = r10.waitForNewOperationAndExecutionInterval(r0)
            if (r11 != r1) goto L63
            goto Lbd
        L63:
            r2 = r10
        L64:
            int r11 = r2.enqueueIntoBucket
            int r11 = r11 + r6
            r2.enqueueIntoBucket = r11
        L69:
            boolean r11 = r2.paused
            r7 = 0
            if (r11 == 0) goto L76
            java.lang.String r11 = "OperationRepo is paused"
            com.onesignal.debug.internal.logging.Logging.debug$default(r11, r7, r5, r7)
            q5.x r11 = q5.x.f13520a
            return r11
        L76:
            int r11 = r2.getExecuteBucket()
            java.util.List r11 = r2.getNextOps$com_onesignal_core(r11)
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            java.lang.String r9 = "processQueueForever:ops:\n"
            r8.<init>(r9)
            r8.append(r11)
            java.lang.String r8 = r8.toString()
            com.onesignal.debug.internal.logging.Logging.debug$default(r8, r7, r5, r7)
            if (r11 == 0) goto Lb3
            r0.L$0 = r2
            r0.label = r5
            java.lang.Object r11 = r2.executeOperations$com_onesignal_core(r11, r0)
            if (r11 != r1) goto L9c
            goto Lbd
        L9c:
            com.onesignal.core.internal.config.ConfigModelStore r11 = r2._configModelStore
            com.onesignal.common.modeling.Model r11 = r11.getModel()
            com.onesignal.core.internal.config.ConfigModel r11 = (com.onesignal.core.internal.config.ConfigModel) r11
            long r7 = r11.getOpRepoPostWakeDelay()
            r0.L$0 = r2
            r0.label = r4
            java.lang.Object r11 = q6.c0.k(r7, r0)
            if (r11 != r1) goto L69
            goto Lbd
        Lb3:
            r0.L$0 = r2
            r0.label = r3
            java.lang.Object r11 = r2.waitForNewOperationAndExecutionInterval(r0)
            if (r11 != r1) goto Lbe
        Lbd:
            return r1
        Lbe:
            int r11 = r2.enqueueIntoBucket
            int r11 = r11 + r6
            r2.enqueueIntoBucket = r11
            goto L69
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.core.internal.operations.impl.OperationRepo.processQueueForever(v5.c):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x009a, code lost:
    
        if (r11 == r1) goto L25;
     */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x009a -> B:26:0x009d). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object waitForNewOperationAndExecutionInterval(v5.c<? super q5.x> r11) throws java.lang.Throwable {
        /*
            r10 = this;
            boolean r0 = r11 instanceof com.onesignal.core.internal.operations.impl.OperationRepo.C27021
            if (r0 == 0) goto L13
            r0 = r11
            com.onesignal.core.internal.operations.impl.OperationRepo$waitForNewOperationAndExecutionInterval$1 r0 = (com.onesignal.core.internal.operations.impl.OperationRepo.C27021) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.onesignal.core.internal.operations.impl.OperationRepo$waitForNewOperationAndExecutionInterval$1 r0 = new com.onesignal.core.internal.operations.impl.OperationRepo$waitForNewOperationAndExecutionInterval$1
            r0.<init>(r11)
        L18:
            java.lang.Object r11 = r0.result
            w5.a r1 = w5.a.f17774a
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L4a
            if (r2 == r4) goto L3a
            if (r2 != r3) goto L32
            java.lang.Object r2 = r0.L$1
            kotlin.jvm.internal.a0 r2 = (kotlin.jvm.internal.a0) r2
            java.lang.Object r4 = r0.L$0
            com.onesignal.core.internal.operations.impl.OperationRepo r4 = (com.onesignal.core.internal.operations.impl.OperationRepo) r4
            r2.q.z0(r11)
            goto L9d
        L32:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L3a:
            java.lang.Object r2 = r0.L$2
            kotlin.jvm.internal.a0 r2 = (kotlin.jvm.internal.a0) r2
            java.lang.Object r4 = r0.L$1
            kotlin.jvm.internal.a0 r4 = (kotlin.jvm.internal.a0) r4
            java.lang.Object r5 = r0.L$0
            com.onesignal.core.internal.operations.impl.OperationRepo r5 = (com.onesignal.core.internal.operations.impl.OperationRepo) r5
            r2.q.z0(r11)
            goto L65
        L4a:
            r2.q.z0(r11)
            kotlin.jvm.internal.a0 r2 = new kotlin.jvm.internal.a0
            r2.<init>()
            com.onesignal.common.threading.WaiterWithValue<com.onesignal.core.internal.operations.impl.OperationRepo$LoopWaiterMessage> r11 = r10.waiter
            r0.L$0 = r10
            r0.L$1 = r2
            r0.L$2 = r2
            r0.label = r4
            java.lang.Object r11 = r11.waitForWake(r0)
            if (r11 != r1) goto L63
            goto L9c
        L63:
            r5 = r10
            r4 = r2
        L65:
            r2.f12717a = r11
            com.onesignal.core.internal.config.ConfigModelStore r11 = r5._configModelStore
            com.onesignal.common.modeling.Model r11 = r11.getModel()
            com.onesignal.core.internal.config.ConfigModel r11 = (com.onesignal.core.internal.config.ConfigModel) r11
            long r6 = r11.getOpRepoExecutionInterval()
            java.lang.Object r11 = r4.f12717a
            com.onesignal.core.internal.operations.impl.OperationRepo$LoopWaiterMessage r11 = (com.onesignal.core.internal.operations.impl.OperationRepo.LoopWaiterMessage) r11
            long r8 = r11.getPreviousWaitedTime()
            long r6 = r6 - r8
            r2 = r4
            r4 = r5
        L7e:
            java.lang.Object r11 = r2.f12717a
            com.onesignal.core.internal.operations.impl.OperationRepo$LoopWaiterMessage r11 = (com.onesignal.core.internal.operations.impl.OperationRepo.LoopWaiterMessage) r11
            boolean r11 = r11.getForce()
            if (r11 != 0) goto Lad
            com.onesignal.core.internal.operations.impl.OperationRepo$waitForNewOperationAndExecutionInterval$waitedTheFullTime$1 r11 = new com.onesignal.core.internal.operations.impl.OperationRepo$waitForNewOperationAndExecutionInterval$waitedTheFullTime$1
            r5 = 0
            r11.<init>(r2, r4, r5)
            r0.L$0 = r4
            r0.L$1 = r2
            r0.L$2 = r5
            r0.label = r3
            java.lang.Object r11 = q6.c0.J(r6, r11, r0)
            if (r11 != r1) goto L9d
        L9c:
            return r1
        L9d:
            if (r11 != 0) goto La0
            goto Lad
        La0:
            com.onesignal.core.internal.config.ConfigModelStore r11 = r4._configModelStore
            com.onesignal.common.modeling.Model r11 = r11.getModel()
            com.onesignal.core.internal.config.ConfigModel r11 = (com.onesignal.core.internal.config.ConfigModel) r11
            long r6 = r11.getOpRepoExecutionInterval()
            goto L7e
        Lad:
            q5.x r11 = q5.x.f13520a
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.core.internal.operations.impl.OperationRepo.waitForNewOperationAndExecutionInterval(v5.c):java.lang.Object");
    }

    @Override // com.onesignal.core.internal.operations.IOperationRepo
    public Object awaitInitialized(c<? super x> cVar) throws Throwable {
        Object objT = ((r) this.initialized).t(cVar);
        return objT == a.f17774a ? objT : x.f13520a;
    }

    @Override // com.onesignal.core.internal.operations.IOperationRepo
    public <T extends Operation> boolean containsInstanceOf(l6.c type) {
        boolean z2;
        k.e(type, "type");
        synchronized (this.queue) {
            try {
                List<OperationQueueItem> list = this.queue;
                z2 = true;
                if ((list != null) && list.isEmpty()) {
                    z2 = false;
                } else {
                    Iterator<T> it = list.iterator();
                    while (it.hasNext()) {
                        if (((kotlin.jvm.internal.e) type).g(((OperationQueueItem) it.next()).getOperation())) {
                            break;
                        }
                    }
                    z2 = false;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return z2;
    }

    public final Object delayBeforeNextExecution(int i2, Integer num, c<? super x> cVar) throws Throwable {
        Logging.debug$default("retryAfterSeconds: " + num, null, 2, null);
        long jMax = Math.max(this._configModelStore.getModel().getOpRepoDefaultFailRetryBackoff() * ((long) i2), (num != null ? num.intValue() : 0L) * ((long) 1000));
        x xVar = x.f13520a;
        if (jMax < 1) {
            return xVar;
        }
        Logging.error$default("Operations being delay for: " + jMax + " ms", null, 2, null);
        Object objJ = c0.J(jMax, new AnonymousClass2(null), cVar);
        return objJ == a.f17774a ? objJ : xVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object delayForPostCreate(long r5, v5.c<? super q5.x> r7) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r7 instanceof com.onesignal.core.internal.operations.impl.OperationRepo.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r7
            com.onesignal.core.internal.operations.impl.OperationRepo$delayForPostCreate$1 r0 = (com.onesignal.core.internal.operations.impl.OperationRepo.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.onesignal.core.internal.operations.impl.OperationRepo$delayForPostCreate$1 r0 = new com.onesignal.core.internal.operations.impl.OperationRepo$delayForPostCreate$1
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.result
            w5.a r1 = w5.a.f17774a
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            long r5 = r0.J$0
            java.lang.Object r0 = r0.L$0
            com.onesignal.core.internal.operations.impl.OperationRepo r0 = (com.onesignal.core.internal.operations.impl.OperationRepo) r0
            r2.q.z0(r7)
            goto L46
        L2d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L35:
            r2.q.z0(r7)
            r0.L$0 = r4
            r0.J$0 = r5
            r0.label = r3
            java.lang.Object r7 = q6.c0.k(r5, r0)
            if (r7 != r1) goto L45
            return r1
        L45:
            r0 = r4
        L46:
            java.util.List<com.onesignal.core.internal.operations.impl.OperationRepo$OperationQueueItem> r7 = r0.queue
            monitor-enter(r7)
            java.util.List<com.onesignal.core.internal.operations.impl.OperationRepo$OperationQueueItem> r1 = r0.queue     // Catch: java.lang.Throwable -> L5d
            boolean r1 = r1.isEmpty()     // Catch: java.lang.Throwable -> L5d
            if (r1 != 0) goto L5f
            com.onesignal.common.threading.WaiterWithValue<com.onesignal.core.internal.operations.impl.OperationRepo$LoopWaiterMessage> r0 = r0.waiter     // Catch: java.lang.Throwable -> L5d
            com.onesignal.core.internal.operations.impl.OperationRepo$LoopWaiterMessage r1 = new com.onesignal.core.internal.operations.impl.OperationRepo$LoopWaiterMessage     // Catch: java.lang.Throwable -> L5d
            r2 = 0
            r1.<init>(r2, r5)     // Catch: java.lang.Throwable -> L5d
            r0.wake(r1)     // Catch: java.lang.Throwable -> L5d
            goto L5f
        L5d:
            r5 = move-exception
            goto L63
        L5f:
            monitor-exit(r7)
            q5.x r5 = q5.x.f13520a
            return r5
        L63:
            monitor-exit(r7)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.core.internal.operations.impl.OperationRepo.delayForPostCreate(long, v5.c):java.lang.Object");
    }

    @Override // com.onesignal.core.internal.operations.IOperationRepo
    public void enqueue(Operation operation, boolean z2) {
        k.e(operation, "operation");
        Logging.log(LogLevel.DEBUG, "OperationRepo.enqueue(operation: " + operation + ", flush: " + z2 + ')');
        String string = UUID.randomUUID().toString();
        k.d(string, "randomUUID().toString()");
        operation.setId(string);
        OSPrimaryCoroutineScope.INSTANCE.execute(new C26991(operation, z2, null));
    }

    @Override // com.onesignal.core.internal.operations.IOperationRepo
    public Object enqueueAndWait(Operation operation, boolean z2, c<? super Boolean> cVar) {
        Logging.log(LogLevel.DEBUG, "OperationRepo.enqueueAndWait(operation: " + operation + ", force: " + z2 + ')');
        String string = UUID.randomUUID().toString();
        k.d(string, "randomUUID().toString()");
        operation.setId(string);
        WaiterWithValue waiterWithValue = new WaiterWithValue();
        internalEnqueue$default(this, new OperationQueueItem(operation, waiterWithValue, this.enqueueIntoBucket, 0, 8, null), z2, true, null, 8, null);
        return waiterWithValue.waitForWake(cVar);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:164:0x036b, code lost:
    
        if (r0 == r5) goto L165;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:100:0x01f5 A[Catch: all -> 0x0116, TryCatch #4 {all -> 0x0116, blocks: (B:44:0x00da, B:46:0x00fa, B:47:0x00fe, B:49:0x0104, B:52:0x0119, B:53:0x011b, B:61:0x013c, B:62:0x013d, B:63:0x0149, B:65:0x014f, B:66:0x015b, B:67:0x015c, B:68:0x015d, B:69:0x016a, B:142:0x02d9, B:144:0x02df, B:145:0x02e1, B:153:0x0333, B:155:0x0335, B:156:0x0336, B:157:0x0337, B:71:0x0170, B:72:0x0188, B:80:0x01a5, B:82:0x01a7, B:83:0x01a8, B:84:0x01a9, B:85:0x01bf, B:96:0x01f0, B:98:0x01f3, B:99:0x01f4, B:100:0x01f5, B:102:0x0208, B:103:0x020d, B:104:0x020f, B:118:0x024c, B:120:0x024f, B:121:0x0250, B:122:0x0251, B:123:0x0269, B:125:0x026f, B:126:0x0283, B:127:0x0287, B:129:0x028d, B:131:0x0299, B:132:0x029f, B:133:0x02a3, B:135:0x02a9, B:136:0x02bd, B:137:0x02c1, B:139:0x02c7, B:141:0x02d3, B:105:0x0210, B:106:0x0219, B:108:0x021f, B:110:0x022c, B:113:0x0232, B:114:0x023a, B:116:0x0240, B:146:0x02e2, B:147:0x02ee, B:149:0x02f4, B:73:0x0189, B:74:0x0191, B:76:0x0197, B:86:0x01c0, B:87:0x01c9, B:89:0x01cf, B:91:0x01e3, B:94:0x01ea, B:54:0x011c, B:55:0x0122, B:57:0x0128), top: B:187:0x00da, inners: #1, #2, #3, #5, #6 }] */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0251 A[Catch: all -> 0x0116, TryCatch #4 {all -> 0x0116, blocks: (B:44:0x00da, B:46:0x00fa, B:47:0x00fe, B:49:0x0104, B:52:0x0119, B:53:0x011b, B:61:0x013c, B:62:0x013d, B:63:0x0149, B:65:0x014f, B:66:0x015b, B:67:0x015c, B:68:0x015d, B:69:0x016a, B:142:0x02d9, B:144:0x02df, B:145:0x02e1, B:153:0x0333, B:155:0x0335, B:156:0x0336, B:157:0x0337, B:71:0x0170, B:72:0x0188, B:80:0x01a5, B:82:0x01a7, B:83:0x01a8, B:84:0x01a9, B:85:0x01bf, B:96:0x01f0, B:98:0x01f3, B:99:0x01f4, B:100:0x01f5, B:102:0x0208, B:103:0x020d, B:104:0x020f, B:118:0x024c, B:120:0x024f, B:121:0x0250, B:122:0x0251, B:123:0x0269, B:125:0x026f, B:126:0x0283, B:127:0x0287, B:129:0x028d, B:131:0x0299, B:132:0x029f, B:133:0x02a3, B:135:0x02a9, B:136:0x02bd, B:137:0x02c1, B:139:0x02c7, B:141:0x02d3, B:105:0x0210, B:106:0x0219, B:108:0x021f, B:110:0x022c, B:113:0x0232, B:114:0x023a, B:116:0x0240, B:146:0x02e2, B:147:0x02ee, B:149:0x02f4, B:73:0x0189, B:74:0x0191, B:76:0x0197, B:86:0x01c0, B:87:0x01c9, B:89:0x01cf, B:91:0x01e3, B:94:0x01ea, B:54:0x011c, B:55:0x0122, B:57:0x0128), top: B:187:0x00da, inners: #1, #2, #3, #5, #6 }] */
    /* JADX WARN: Removed duplicated region for block: B:132:0x029f A[Catch: all -> 0x0116, TryCatch #4 {all -> 0x0116, blocks: (B:44:0x00da, B:46:0x00fa, B:47:0x00fe, B:49:0x0104, B:52:0x0119, B:53:0x011b, B:61:0x013c, B:62:0x013d, B:63:0x0149, B:65:0x014f, B:66:0x015b, B:67:0x015c, B:68:0x015d, B:69:0x016a, B:142:0x02d9, B:144:0x02df, B:145:0x02e1, B:153:0x0333, B:155:0x0335, B:156:0x0336, B:157:0x0337, B:71:0x0170, B:72:0x0188, B:80:0x01a5, B:82:0x01a7, B:83:0x01a8, B:84:0x01a9, B:85:0x01bf, B:96:0x01f0, B:98:0x01f3, B:99:0x01f4, B:100:0x01f5, B:102:0x0208, B:103:0x020d, B:104:0x020f, B:118:0x024c, B:120:0x024f, B:121:0x0250, B:122:0x0251, B:123:0x0269, B:125:0x026f, B:126:0x0283, B:127:0x0287, B:129:0x028d, B:131:0x0299, B:132:0x029f, B:133:0x02a3, B:135:0x02a9, B:136:0x02bd, B:137:0x02c1, B:139:0x02c7, B:141:0x02d3, B:105:0x0210, B:106:0x0219, B:108:0x021f, B:110:0x022c, B:113:0x0232, B:114:0x023a, B:116:0x0240, B:146:0x02e2, B:147:0x02ee, B:149:0x02f4, B:73:0x0189, B:74:0x0191, B:76:0x0197, B:86:0x01c0, B:87:0x01c9, B:89:0x01cf, B:91:0x01e3, B:94:0x01ea, B:54:0x011c, B:55:0x0122, B:57:0x0128), top: B:187:0x00da, inners: #1, #2, #3, #5, #6 }] */
    /* JADX WARN: Removed duplicated region for block: B:144:0x02df A[Catch: all -> 0x0116, TryCatch #4 {all -> 0x0116, blocks: (B:44:0x00da, B:46:0x00fa, B:47:0x00fe, B:49:0x0104, B:52:0x0119, B:53:0x011b, B:61:0x013c, B:62:0x013d, B:63:0x0149, B:65:0x014f, B:66:0x015b, B:67:0x015c, B:68:0x015d, B:69:0x016a, B:142:0x02d9, B:144:0x02df, B:145:0x02e1, B:153:0x0333, B:155:0x0335, B:156:0x0336, B:157:0x0337, B:71:0x0170, B:72:0x0188, B:80:0x01a5, B:82:0x01a7, B:83:0x01a8, B:84:0x01a9, B:85:0x01bf, B:96:0x01f0, B:98:0x01f3, B:99:0x01f4, B:100:0x01f5, B:102:0x0208, B:103:0x020d, B:104:0x020f, B:118:0x024c, B:120:0x024f, B:121:0x0250, B:122:0x0251, B:123:0x0269, B:125:0x026f, B:126:0x0283, B:127:0x0287, B:129:0x028d, B:131:0x0299, B:132:0x029f, B:133:0x02a3, B:135:0x02a9, B:136:0x02bd, B:137:0x02c1, B:139:0x02c7, B:141:0x02d3, B:105:0x0210, B:106:0x0219, B:108:0x021f, B:110:0x022c, B:113:0x0232, B:114:0x023a, B:116:0x0240, B:146:0x02e2, B:147:0x02ee, B:149:0x02f4, B:73:0x0189, B:74:0x0191, B:76:0x0197, B:86:0x01c0, B:87:0x01c9, B:89:0x01cf, B:91:0x01e3, B:94:0x01ea, B:54:0x011c, B:55:0x0122, B:57:0x0128), top: B:187:0x00da, inners: #1, #2, #3, #5, #6 }] */
    /* JADX WARN: Removed duplicated region for block: B:160:0x034c  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x0353 A[Catch: all -> 0x003f, TRY_LEAVE, TryCatch #9 {all -> 0x003f, blocks: (B:14:0x003a, B:161:0x034d, B:163:0x0353), top: B:197:0x002a }] */
    /* JADX WARN: Removed duplicated region for block: B:171:0x03a5 A[LOOP:0: B:169:0x039f->B:171:0x03a5, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:175:0x03c3  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00fa A[Catch: all -> 0x0116, TryCatch #4 {all -> 0x0116, blocks: (B:44:0x00da, B:46:0x00fa, B:47:0x00fe, B:49:0x0104, B:52:0x0119, B:53:0x011b, B:61:0x013c, B:62:0x013d, B:63:0x0149, B:65:0x014f, B:66:0x015b, B:67:0x015c, B:68:0x015d, B:69:0x016a, B:142:0x02d9, B:144:0x02df, B:145:0x02e1, B:153:0x0333, B:155:0x0335, B:156:0x0336, B:157:0x0337, B:71:0x0170, B:72:0x0188, B:80:0x01a5, B:82:0x01a7, B:83:0x01a8, B:84:0x01a9, B:85:0x01bf, B:96:0x01f0, B:98:0x01f3, B:99:0x01f4, B:100:0x01f5, B:102:0x0208, B:103:0x020d, B:104:0x020f, B:118:0x024c, B:120:0x024f, B:121:0x0250, B:122:0x0251, B:123:0x0269, B:125:0x026f, B:126:0x0283, B:127:0x0287, B:129:0x028d, B:131:0x0299, B:132:0x029f, B:133:0x02a3, B:135:0x02a9, B:136:0x02bd, B:137:0x02c1, B:139:0x02c7, B:141:0x02d3, B:105:0x0210, B:106:0x0219, B:108:0x021f, B:110:0x022c, B:113:0x0232, B:114:0x023a, B:116:0x0240, B:146:0x02e2, B:147:0x02ee, B:149:0x02f4, B:73:0x0189, B:74:0x0191, B:76:0x0197, B:86:0x01c0, B:87:0x01c9, B:89:0x01cf, B:91:0x01e3, B:94:0x01ea, B:54:0x011c, B:55:0x0122, B:57:0x0128), top: B:187:0x00da, inners: #1, #2, #3, #5, #6 }] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x016d  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0170 A[Catch: all -> 0x0116, TryCatch #4 {all -> 0x0116, blocks: (B:44:0x00da, B:46:0x00fa, B:47:0x00fe, B:49:0x0104, B:52:0x0119, B:53:0x011b, B:61:0x013c, B:62:0x013d, B:63:0x0149, B:65:0x014f, B:66:0x015b, B:67:0x015c, B:68:0x015d, B:69:0x016a, B:142:0x02d9, B:144:0x02df, B:145:0x02e1, B:153:0x0333, B:155:0x0335, B:156:0x0336, B:157:0x0337, B:71:0x0170, B:72:0x0188, B:80:0x01a5, B:82:0x01a7, B:83:0x01a8, B:84:0x01a9, B:85:0x01bf, B:96:0x01f0, B:98:0x01f3, B:99:0x01f4, B:100:0x01f5, B:102:0x0208, B:103:0x020d, B:104:0x020f, B:118:0x024c, B:120:0x024f, B:121:0x0250, B:122:0x0251, B:123:0x0269, B:125:0x026f, B:126:0x0283, B:127:0x0287, B:129:0x028d, B:131:0x0299, B:132:0x029f, B:133:0x02a3, B:135:0x02a9, B:136:0x02bd, B:137:0x02c1, B:139:0x02c7, B:141:0x02d3, B:105:0x0210, B:106:0x0219, B:108:0x021f, B:110:0x022c, B:113:0x0232, B:114:0x023a, B:116:0x0240, B:146:0x02e2, B:147:0x02ee, B:149:0x02f4, B:73:0x0189, B:74:0x0191, B:76:0x0197, B:86:0x01c0, B:87:0x01c9, B:89:0x01cf, B:91:0x01e3, B:94:0x01ea, B:54:0x011c, B:55:0x0122, B:57:0x0128), top: B:187:0x00da, inners: #1, #2, #3, #5, #6 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001b  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x01a9 A[Catch: all -> 0x0116, TryCatch #4 {all -> 0x0116, blocks: (B:44:0x00da, B:46:0x00fa, B:47:0x00fe, B:49:0x0104, B:52:0x0119, B:53:0x011b, B:61:0x013c, B:62:0x013d, B:63:0x0149, B:65:0x014f, B:66:0x015b, B:67:0x015c, B:68:0x015d, B:69:0x016a, B:142:0x02d9, B:144:0x02df, B:145:0x02e1, B:153:0x0333, B:155:0x0335, B:156:0x0336, B:157:0x0337, B:71:0x0170, B:72:0x0188, B:80:0x01a5, B:82:0x01a7, B:83:0x01a8, B:84:0x01a9, B:85:0x01bf, B:96:0x01f0, B:98:0x01f3, B:99:0x01f4, B:100:0x01f5, B:102:0x0208, B:103:0x020d, B:104:0x020f, B:118:0x024c, B:120:0x024f, B:121:0x0250, B:122:0x0251, B:123:0x0269, B:125:0x026f, B:126:0x0283, B:127:0x0287, B:129:0x028d, B:131:0x0299, B:132:0x029f, B:133:0x02a3, B:135:0x02a9, B:136:0x02bd, B:137:0x02c1, B:139:0x02c7, B:141:0x02d3, B:105:0x0210, B:106:0x0219, B:108:0x021f, B:110:0x022c, B:113:0x0232, B:114:0x023a, B:116:0x0240, B:146:0x02e2, B:147:0x02ee, B:149:0x02f4, B:73:0x0189, B:74:0x0191, B:76:0x0197, B:86:0x01c0, B:87:0x01c9, B:89:0x01cf, B:91:0x01e3, B:94:0x01ea, B:54:0x011c, B:55:0x0122, B:57:0x0128), top: B:187:0x00da, inners: #1, #2, #3, #5, #6 }] */
    /* JADX WARN: Type inference failed for: r3v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v2, types: [com.onesignal.core.internal.operations.impl.OperationRepo] */
    /* JADX WARN: Type inference failed for: r3v26 */
    /* JADX WARN: Type inference failed for: r3v32 */
    /* JADX WARN: Type inference failed for: r3v36 */
    /* JADX WARN: Type inference failed for: r3v37 */
    /* JADX WARN: Type inference failed for: r3v38 */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v6 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object executeOperations$com_onesignal_core(java.util.List<com.onesignal.core.internal.operations.impl.OperationRepo.OperationQueueItem> r23, v5.c<? super q5.x> r24) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 1002
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.core.internal.operations.impl.OperationRepo.executeOperations$com_onesignal_core(java.util.List, v5.c):java.lang.Object");
    }

    @Override // com.onesignal.core.internal.operations.IOperationRepo
    public void forceExecuteOperations() {
        int i2 = 2;
        f fVar = null;
        long j = 0;
        this.retryWaiter.wake(new LoopWaiterMessage(true, j, i2, fVar));
        this.waiter.wake(new LoopWaiterMessage(false, j, i2, fVar));
    }

    public final List<OperationQueueItem> getNextOps$com_onesignal_core(int i2) {
        List<OperationQueueItem> groupableOperations;
        Object next;
        synchronized (this.queue) {
            try {
                Iterator<T> it = this.queue.iterator();
                while (true) {
                    groupableOperations = null;
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                    OperationQueueItem operationQueueItem = (OperationQueueItem) next;
                    if (operationQueueItem.getOperation().getCanStartExecute() && this._newRecordState.canAccess(operationQueueItem.getOperation().getApplyToRecordId()) && operationQueueItem.getBucket() <= i2) {
                        break;
                    }
                }
                OperationQueueItem operationQueueItem2 = (OperationQueueItem) next;
                if (operationQueueItem2 != null) {
                    this.queue.remove(operationQueueItem2);
                    groupableOperations = getGroupableOperations(operationQueueItem2);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return groupableOperations;
    }

    public final List<OperationQueueItem> getQueue$com_onesignal_core() {
        return this.queue;
    }

    public final void loadSavedOperations$com_onesignal_core() {
        this._operationModelStore.loadOperations();
        Iterator it = r5.l.i1(this._operationModelStore.list()).iterator();
        while (it.hasNext()) {
            internalEnqueue(new OperationQueueItem((Operation) it.next(), null, this.enqueueIntoBucket, 0, 10, null), false, false, 0);
        }
        ((r) this.initialized).N(x.f13520a);
    }

    @Override // com.onesignal.core.internal.startup.IStartableService
    public void start() {
        this.paused = false;
        c0.u(this.coroutineScope, null, new C27011(null), 3);
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class LoopWaiterMessage {
        private final boolean force;
        private final long previousWaitedTime;

        public LoopWaiterMessage(boolean z2, long j) {
            this.force = z2;
            this.previousWaitedTime = j;
        }

        public final boolean getForce() {
            return this.force;
        }

        public final long getPreviousWaitedTime() {
            return this.previousWaitedTime;
        }

        public /* synthetic */ LoopWaiterMessage(boolean z2, long j, int i2, f fVar) {
            this(z2, (i2 & 2) != 0 ? 0L : j);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class OperationQueueItem {
        private final int bucket;
        private final Operation operation;
        private int retries;
        private final WaiterWithValue<Boolean> waiter;

        public OperationQueueItem(Operation operation, WaiterWithValue<Boolean> waiterWithValue, int i2, int i8) {
            k.e(operation, "operation");
            this.operation = operation;
            this.waiter = waiterWithValue;
            this.bucket = i2;
            this.retries = i8;
        }

        public final int getBucket() {
            return this.bucket;
        }

        public final Operation getOperation() {
            return this.operation;
        }

        public final int getRetries() {
            return this.retries;
        }

        public final WaiterWithValue<Boolean> getWaiter() {
            return this.waiter;
        }

        public final void setRetries(int i2) {
            this.retries = i2;
        }

        public String toString() {
            return "bucket:" + this.bucket + ", retries:" + this.retries + ", operation:" + this.operation + '\n';
        }

        public /* synthetic */ OperationQueueItem(Operation operation, WaiterWithValue waiterWithValue, int i2, int i8, int i9, f fVar) {
            this(operation, (i9 & 2) != 0 ? null : waiterWithValue, i2, (i9 & 8) != 0 ? 0 : i8);
        }
    }
}
