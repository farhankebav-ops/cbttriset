package androidx.datastore.core;

import androidx.datastore.core.Message;
import androidx.datastore.core.UpdatingDataContextElement;
import androidx.datastore.core.handlers.NoOpCorruptionHandler;
import com.google.mlkit.common.MlKitException;
import com.vungle.ads.internal.protos.Sdk;
import e6.p;
import java.util.List;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.y;
import n7.b;
import q5.f;
import q5.x;
import q6.a0;
import q6.c0;
import q6.f1;
import q6.r;
import r2.q;
import r5.l;
import t6.e;
import v5.h;
import x5.c;
import x5.i;
import z6.d;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class DataStoreImpl<T> implements DataStore<T> {
    private static final String BUG_MESSAGE = "This is a bug in DataStore. Please file a bug at: https://issuetracker.google.com/issues/new?component=907884&template=1466542";
    public static final Companion Companion = new Companion(null);
    private int collectorCounter;
    private f1 collectorJob;
    private final z6.a collectorMutex;
    private final f coordinator$delegate;
    private final CorruptionHandler<T> corruptionHandler;
    private final e data;
    private final DataStoreInMemoryCache<T> inMemoryCache;
    private final DataStoreImpl<T>.InitDataStore readAndInit;
    private final a0 scope;
    private final Storage<T> storage;
    private final f storageConnectionDelegate;
    private final SimpleActor<Message.Update<T>> writeActor;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.f fVar) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public final class InitDataStore extends RunOnce {
        private List<? extends p> initTasks;
        final /* synthetic */ DataStoreImpl<T> this$0;

        public InitDataStore(DataStoreImpl dataStoreImpl, List<? extends p> initTasksList) {
            k.e(initTasksList, "initTasksList");
            this.this$0 = dataStoreImpl;
            this.initTasks = l.n1(initTasksList);
        }

        /* JADX WARN: Removed duplicated region for block: B:26:0x006c  */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        @Override // androidx.datastore.core.RunOnce
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public java.lang.Object doRun(v5.c<? super q5.x> r7) throws java.lang.Throwable {
            /*
                r6 = this;
                boolean r0 = r7 instanceof androidx.datastore.core.DataStoreImpl$InitDataStore$doRun$1
                if (r0 == 0) goto L13
                r0 = r7
                androidx.datastore.core.DataStoreImpl$InitDataStore$doRun$1 r0 = (androidx.datastore.core.DataStoreImpl$InitDataStore$doRun$1) r0
                int r1 = r0.label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.label = r1
                goto L18
            L13:
                androidx.datastore.core.DataStoreImpl$InitDataStore$doRun$1 r0 = new androidx.datastore.core.DataStoreImpl$InitDataStore$doRun$1
                r0.<init>(r6, r7)
            L18:
                java.lang.Object r7 = r0.result
                w5.a r1 = w5.a.f17774a
                int r2 = r0.label
                r3 = 2
                r4 = 1
                if (r2 == 0) goto L3e
                if (r2 == r4) goto L36
                if (r2 != r3) goto L2e
                java.lang.Object r0 = r0.L$0
                androidx.datastore.core.DataStoreImpl$InitDataStore r0 = (androidx.datastore.core.DataStoreImpl.InitDataStore) r0
                r2.q.z0(r7)
                goto L69
            L2e:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r0)
                throw r7
            L36:
                java.lang.Object r0 = r0.L$0
                androidx.datastore.core.DataStoreImpl$InitDataStore r0 = (androidx.datastore.core.DataStoreImpl.InitDataStore) r0
                r2.q.z0(r7)
                goto L7b
            L3e:
                r2.q.z0(r7)
                java.util.List<? extends e6.p> r7 = r6.initTasks
                if (r7 == 0) goto L6c
                kotlin.jvm.internal.k.b(r7)
                boolean r7 = r7.isEmpty()
                if (r7 == 0) goto L4f
                goto L6c
            L4f:
                androidx.datastore.core.DataStoreImpl<T> r7 = r6.this$0
                androidx.datastore.core.InterProcessCoordinator r7 = androidx.datastore.core.DataStoreImpl.access$getCoordinator(r7)
                androidx.datastore.core.DataStoreImpl$InitDataStore$doRun$initData$1 r2 = new androidx.datastore.core.DataStoreImpl$InitDataStore$doRun$initData$1
                androidx.datastore.core.DataStoreImpl<T> r4 = r6.this$0
                r5 = 0
                r2.<init>(r4, r6, r5)
                r0.L$0 = r6
                r0.label = r3
                java.lang.Object r7 = r7.lock(r2, r0)
                if (r7 != r1) goto L68
                goto L79
            L68:
                r0 = r6
            L69:
                androidx.datastore.core.Data r7 = (androidx.datastore.core.Data) r7
                goto L7d
            L6c:
                androidx.datastore.core.DataStoreImpl<T> r7 = r6.this$0
                r0.L$0 = r6
                r0.label = r4
                r2 = 0
                java.lang.Object r7 = androidx.datastore.core.DataStoreImpl.access$readDataOrHandleCorruption(r7, r2, r0)
                if (r7 != r1) goto L7a
            L79:
                return r1
            L7a:
                r0 = r6
            L7b:
                androidx.datastore.core.Data r7 = (androidx.datastore.core.Data) r7
            L7d:
                androidx.datastore.core.DataStoreImpl<T> r0 = r0.this$0
                androidx.datastore.core.DataStoreInMemoryCache r0 = androidx.datastore.core.DataStoreImpl.access$getInMemoryCache$p(r0)
                r0.tryUpdate(r7)
                q5.x r7 = q5.x.f13520a
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.DataStoreImpl.InitDataStore.doRun(v5.c):java.lang.Object");
        }
    }

    /* JADX INFO: renamed from: androidx.datastore.core.DataStoreImpl$decrementCollector$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @x5.e(c = "androidx.datastore.core.DataStoreImpl", f = "DataStoreImpl.kt", l = {544}, m = "decrementCollector")
    public static final class AnonymousClass1 extends c {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ DataStoreImpl<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(DataStoreImpl<T> dataStoreImpl, v5.c<? super AnonymousClass1> cVar) {
            super(cVar);
            this.this$0 = dataStoreImpl;
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.decrementCollector(this);
        }
    }

    /* JADX INFO: renamed from: androidx.datastore.core.DataStoreImpl$doWithWriteFileLock$3, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @x5.e(c = "androidx.datastore.core.DataStoreImpl$doWithWriteFileLock$3", f = "DataStoreImpl.kt", l = {416}, m = "invokeSuspend")
    public static final class AnonymousClass3 extends i implements e6.l {
        final /* synthetic */ e6.l $block;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(e6.l lVar, v5.c<? super AnonymousClass3> cVar) {
            super(1, cVar);
            this.$block = lVar;
        }

        @Override // x5.a
        public final v5.c<x> create(v5.c<?> cVar) {
            return new AnonymousClass3(this.$block, cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            w5.a aVar = w5.a.f17774a;
            int i2 = this.label;
            if (i2 != 0) {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                q.z0(obj);
                return obj;
            }
            q.z0(obj);
            e6.l lVar = this.$block;
            this.label = 1;
            Object objInvoke = lVar.invoke(this);
            return objInvoke == aVar ? aVar : objInvoke;
        }

        @Override // e6.l
        public final Object invoke(v5.c<? super R> cVar) {
            return ((AnonymousClass3) create(cVar)).invokeSuspend(x.f13520a);
        }
    }

    /* JADX INFO: renamed from: androidx.datastore.core.DataStoreImpl$handleUpdate$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @x5.e(c = "androidx.datastore.core.DataStoreImpl", f = "DataStoreImpl.kt", l = {237, 243, 246}, m = "handleUpdate")
    public static final class C03391 extends c {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ DataStoreImpl<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C03391(DataStoreImpl<T> dataStoreImpl, v5.c<? super C03391> cVar) {
            super(cVar);
            this.this$0 = dataStoreImpl;
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.handleUpdate(null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.datastore.core.DataStoreImpl$incrementCollector$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @x5.e(c = "androidx.datastore.core.DataStoreImpl", f = "DataStoreImpl.kt", l = {544}, m = "incrementCollector")
    public static final class C03401 extends c {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ DataStoreImpl<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C03401(DataStoreImpl<T> dataStoreImpl, v5.c<? super C03401> cVar) {
            super(cVar);
            this.this$0 = dataStoreImpl;
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.incrementCollector(this);
        }
    }

    /* JADX INFO: renamed from: androidx.datastore.core.DataStoreImpl$readAndInitOrPropagateAndThrowFailure$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @x5.e(c = "androidx.datastore.core.DataStoreImpl", f = "DataStoreImpl.kt", l = {264, 266}, m = "readAndInitOrPropagateAndThrowFailure")
    public static final class C03411 extends c {
        int I$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ DataStoreImpl<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C03411(DataStoreImpl<T> dataStoreImpl, v5.c<? super C03411> cVar) {
            super(cVar);
            this.this$0 = dataStoreImpl;
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.readAndInitOrPropagateAndThrowFailure(this);
        }
    }

    /* JADX INFO: renamed from: androidx.datastore.core.DataStoreImpl$readDataAndUpdateCache$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @x5.e(c = "androidx.datastore.core.DataStoreImpl", f = "DataStoreImpl.kt", l = {287, 296, 304}, m = "readDataAndUpdateCache")
    public static final class C03421 extends c {
        Object L$0;
        Object L$1;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ DataStoreImpl<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C03421(DataStoreImpl<T> dataStoreImpl, v5.c<? super C03421> cVar) {
            super(cVar);
            this.this$0 = dataStoreImpl;
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.readDataAndUpdateCache(false, this);
        }
    }

    /* JADX INFO: renamed from: androidx.datastore.core.DataStoreImpl$readDataAndUpdateCache$3, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @x5.e(c = "androidx.datastore.core.DataStoreImpl$readDataAndUpdateCache$3", f = "DataStoreImpl.kt", l = {298, MlKitException.LOW_LIGHT_AUTO_EXPOSURE_COMPUTATION_FAILURE}, m = "invokeSuspend")
    public static final class C03433 extends i implements e6.l {
        Object L$0;
        int label;
        final /* synthetic */ DataStoreImpl<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C03433(DataStoreImpl<T> dataStoreImpl, v5.c<? super C03433> cVar) {
            super(1, cVar);
            this.this$0 = dataStoreImpl;
        }

        @Override // x5.a
        public final v5.c<x> create(v5.c<?> cVar) {
            return new C03433(this.this$0, cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            Throwable th;
            State readException;
            w5.a aVar = w5.a.f17774a;
            int i2 = this.label;
            try {
            } catch (Throwable th2) {
                InterProcessCoordinator coordinator = this.this$0.getCoordinator();
                this.L$0 = th2;
                this.label = 2;
                Object version = coordinator.getVersion(this);
                if (version != aVar) {
                    th = th2;
                    obj = version;
                }
                return aVar;
            }
            if (i2 == 0) {
                q.z0(obj);
                DataStoreImpl<T> dataStoreImpl = this.this$0;
                this.label = 1;
                obj = dataStoreImpl.readDataOrHandleCorruption(true, this);
                if (obj == aVar) {
                    return aVar;
                }
            } else {
                if (i2 != 1) {
                    if (i2 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    th = (Throwable) this.L$0;
                    q.z0(obj);
                    readException = new ReadException(th, ((Number) obj).intValue());
                    return new q5.i(readException, Boolean.TRUE);
                }
                q.z0(obj);
            }
            readException = (State) obj;
            return new q5.i(readException, Boolean.TRUE);
        }

        @Override // e6.l
        public final Object invoke(v5.c<? super q5.i> cVar) {
            return ((C03433) create(cVar)).invokeSuspend(x.f13520a);
        }
    }

    /* JADX INFO: renamed from: androidx.datastore.core.DataStoreImpl$readDataAndUpdateCache$4, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @x5.e(c = "androidx.datastore.core.DataStoreImpl$readDataAndUpdateCache$4", f = "DataStoreImpl.kt", l = {306, 309}, m = "invokeSuspend")
    public static final class AnonymousClass4 extends i implements p {
        final /* synthetic */ int $cachedVersion;
        Object L$0;
        /* synthetic */ boolean Z$0;
        int label;
        final /* synthetic */ DataStoreImpl<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass4(DataStoreImpl<T> dataStoreImpl, int i2, v5.c<? super AnonymousClass4> cVar) {
            super(2, cVar);
            this.this$0 = dataStoreImpl;
            this.$cachedVersion = i2;
        }

        @Override // x5.a
        public final v5.c<x> create(Object obj, v5.c<?> cVar) {
            AnonymousClass4 anonymousClass4 = new AnonymousClass4(this.this$0, this.$cachedVersion, cVar);
            anonymousClass4.Z$0 = ((Boolean) obj).booleanValue();
            return anonymousClass4;
        }

        @Override // e6.p
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return invoke(((Boolean) obj).booleanValue(), (v5.c<? super q5.i>) obj2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v10 */
        /* JADX WARN: Type inference failed for: r0v2 */
        /* JADX WARN: Type inference failed for: r0v3 */
        /* JADX WARN: Type inference failed for: r0v5 */
        /* JADX WARN: Type inference failed for: r0v6 */
        /* JADX WARN: Type inference failed for: r0v9 */
        /* JADX WARN: Type inference failed for: r1v0, types: [int] */
        /* JADX WARN: Type inference failed for: r1v1, types: [boolean] */
        /* JADX WARN: Type inference failed for: r1v10 */
        /* JADX WARN: Type inference failed for: r1v14 */
        /* JADX WARN: Type inference failed for: r1v15 */
        /* JADX WARN: Type inference failed for: r1v16 */
        /* JADX WARN: Type inference failed for: r1v4, types: [boolean] */
        /* JADX WARN: Type inference failed for: r1v7 */
        /* JADX WARN: Type inference failed for: r4v0 */
        @Override // x5.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            Throwable th;
            int iIntValue;
            ?? r02;
            ?? r03;
            State state;
            ?? r1;
            w5.a aVar = w5.a.f17774a;
            ?? r12 = this.label;
            try {
            } catch (Throwable th2) {
                if (r12 != 0) {
                    InterProcessCoordinator coordinator = this.this$0.getCoordinator();
                    this.L$0 = th2;
                    this.Z$0 = r12;
                    this.label = 2;
                    Object version = coordinator.getVersion(this);
                    if (version != aVar) {
                        r03 = r12;
                        th = th2;
                        obj = version;
                    }
                    return aVar;
                }
                ?? r42 = r12;
                th = th2;
                iIntValue = this.$cachedVersion;
                r02 = r42 == true ? 1 : 0;
            }
            if (r12 == 0) {
                q.z0(obj);
                boolean z2 = this.Z$0;
                DataStoreImpl<T> dataStoreImpl = this.this$0;
                this.Z$0 = z2;
                this.label = 1;
                obj = dataStoreImpl.readDataOrHandleCorruption(z2, this);
                r12 = z2;
                if (obj == aVar) {
                    return aVar;
                }
            } else {
                if (r12 != 1) {
                    if (r12 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    boolean z7 = this.Z$0;
                    th = (Throwable) this.L$0;
                    q.z0(obj);
                    r03 = z7;
                    iIntValue = ((Number) obj).intValue();
                    r02 = r03;
                    ReadException readException = new ReadException(th, iIntValue);
                    r1 = r02;
                    state = readException;
                    return new q5.i(state, Boolean.valueOf((boolean) r1));
                }
                boolean z8 = this.Z$0;
                q.z0(obj);
                r12 = z8;
            }
            state = (State) obj;
            r1 = r12;
            return new q5.i(state, Boolean.valueOf((boolean) r1));
        }

        public final Object invoke(boolean z2, v5.c<? super q5.i> cVar) {
            return ((AnonymousClass4) create(Boolean.valueOf(z2), cVar)).invokeSuspend(x.f13520a);
        }
    }

    /* JADX INFO: renamed from: androidx.datastore.core.DataStoreImpl$readDataOrHandleCorruption$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @x5.e(c = "androidx.datastore.core.DataStoreImpl", f = "DataStoreImpl.kt", l = {365, 366, 368, 369, 380, 384}, m = "readDataOrHandleCorruption")
    public static final class C03441 extends c {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ DataStoreImpl<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C03441(DataStoreImpl<T> dataStoreImpl, v5.c<? super C03441> cVar) {
            super(cVar);
            this.this$0 = dataStoreImpl;
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.readDataOrHandleCorruption(false, this);
        }
    }

    /* JADX INFO: renamed from: androidx.datastore.core.DataStoreImpl$readDataOrHandleCorruption$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @x5.e(c = "androidx.datastore.core.DataStoreImpl$readDataOrHandleCorruption$2", f = "DataStoreImpl.kt", l = {370, 371}, m = "invokeSuspend")
    public static final class AnonymousClass2 extends i implements p {
        final /* synthetic */ int $preLockVersion;
        Object L$0;
        /* synthetic */ boolean Z$0;
        int label;
        final /* synthetic */ DataStoreImpl<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(DataStoreImpl<T> dataStoreImpl, int i2, v5.c<? super AnonymousClass2> cVar) {
            super(2, cVar);
            this.this$0 = dataStoreImpl;
            this.$preLockVersion = i2;
        }

        @Override // x5.a
        public final v5.c<x> create(Object obj, v5.c<?> cVar) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.this$0, this.$preLockVersion, cVar);
            anonymousClass2.Z$0 = ((Boolean) obj).booleanValue();
            return anonymousClass2;
        }

        @Override // e6.p
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return invoke(((Boolean) obj).booleanValue(), (v5.c) obj2);
        }

        /* JADX WARN: Removed duplicated region for block: B:22:0x0057  */
        /* JADX WARN: Removed duplicated region for block: B:23:0x005c  */
        @Override // x5.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r6) throws java.lang.Throwable {
            /*
                r5 = this;
                w5.a r0 = w5.a.f17774a
                int r1 = r5.label
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L20
                if (r1 == r3) goto L1a
                if (r1 != r2) goto L12
                java.lang.Object r0 = r5.L$0
                r2.q.z0(r6)
                goto L47
            L12:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r0)
                throw r6
            L1a:
                boolean r1 = r5.Z$0
                r2.q.z0(r6)
                goto L32
            L20:
                r2.q.z0(r6)
                boolean r1 = r5.Z$0
                androidx.datastore.core.DataStoreImpl<T> r6 = r5.this$0
                r5.Z$0 = r1
                r5.label = r3
                java.lang.Object r6 = androidx.datastore.core.DataStoreImpl.access$readDataFromFileOrDefault(r6, r5)
                if (r6 != r0) goto L32
                goto L44
            L32:
                if (r1 == 0) goto L4e
                androidx.datastore.core.DataStoreImpl<T> r1 = r5.this$0
                androidx.datastore.core.InterProcessCoordinator r1 = androidx.datastore.core.DataStoreImpl.access$getCoordinator(r1)
                r5.L$0 = r6
                r5.label = r2
                java.lang.Object r1 = r1.getVersion(r5)
                if (r1 != r0) goto L45
            L44:
                return r0
            L45:
                r0 = r6
                r6 = r1
            L47:
                java.lang.Number r6 = (java.lang.Number) r6
                int r6 = r6.intValue()
                goto L53
            L4e:
                int r0 = r5.$preLockVersion
                r4 = r0
                r0 = r6
                r6 = r4
            L53:
                androidx.datastore.core.Data r1 = new androidx.datastore.core.Data
                if (r0 == 0) goto L5c
                int r2 = r0.hashCode()
                goto L5d
            L5c:
                r2 = 0
            L5d:
                r1.<init>(r0, r2, r6)
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.DataStoreImpl.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        public final Object invoke(boolean z2, v5.c<? super Data<T>> cVar) {
            return ((AnonymousClass2) create(Boolean.valueOf(z2), cVar)).invokeSuspend(x.f13520a);
        }
    }

    /* JADX INFO: renamed from: androidx.datastore.core.DataStoreImpl$readDataOrHandleCorruption$3, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @x5.e(c = "androidx.datastore.core.DataStoreImpl$readDataOrHandleCorruption$3", f = "DataStoreImpl.kt", l = {387, 388, 390}, m = "invokeSuspend")
    public static final class C03453 extends i implements e6.l {
        final /* synthetic */ kotlin.jvm.internal.a0 $newData;
        final /* synthetic */ y $version;
        Object L$0;
        int label;
        final /* synthetic */ DataStoreImpl<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C03453(kotlin.jvm.internal.a0 a0Var, DataStoreImpl<T> dataStoreImpl, y yVar, v5.c<? super C03453> cVar) {
            super(1, cVar);
            this.$newData = a0Var;
            this.this$0 = dataStoreImpl;
            this.$version = yVar;
        }

        @Override // x5.a
        public final v5.c<x> create(v5.c<?> cVar) {
            return new C03453(this.$newData, this.this$0, this.$version, cVar);
        }

        /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
            jadx.core.utils.exceptions.JadxRuntimeException: Can't change immutable type v5.c to androidx.datastore.core.DataStoreImpl$readDataOrHandleCorruption$3 for r5v1 'this'  v5.c
            	at jadx.core.dex.instructions.args.SSAVar.setType(SSAVar.java:114)
            	at jadx.core.dex.instructions.args.RegisterArg.setType(RegisterArg.java:52)
            	at jadx.core.dex.visitors.ModVisitor.removeCheckCast(ModVisitor.java:417)
            	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:152)
            	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:96)
            */
        @Override // x5.a
        public final java.lang.Object invokeSuspend(java.lang.Object r6) {
            /*
                r5 = this;
                w5.a r0 = w5.a.f17774a
                int r1 = r5.label
                r2 = 3
                r3 = 2
                r4 = 1
                if (r1 == 0) goto L2f
                if (r1 == r4) goto L27
                if (r1 == r3) goto L1f
                if (r1 != r2) goto L17
                java.lang.Object r0 = r5.L$0
                kotlin.jvm.internal.y r0 = (kotlin.jvm.internal.y) r0
                r2.q.z0(r6)
                goto L74
            L17:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r0)
                throw r6
            L1f:
                java.lang.Object r1 = r5.L$0
                kotlin.jvm.internal.y r1 = (kotlin.jvm.internal.y) r1
                r2.q.z0(r6)     // Catch: androidx.datastore.core.CorruptionException -> L5f
                goto L56
            L27:
                java.lang.Object r1 = r5.L$0
                kotlin.jvm.internal.a0 r1 = (kotlin.jvm.internal.a0) r1
                r2.q.z0(r6)     // Catch: androidx.datastore.core.CorruptionException -> L5f
                goto L41
            L2f:
                r2.q.z0(r6)
                kotlin.jvm.internal.a0 r1 = r5.$newData     // Catch: androidx.datastore.core.CorruptionException -> L5f
                androidx.datastore.core.DataStoreImpl<T> r6 = r5.this$0     // Catch: androidx.datastore.core.CorruptionException -> L5f
                r5.L$0 = r1     // Catch: androidx.datastore.core.CorruptionException -> L5f
                r5.label = r4     // Catch: androidx.datastore.core.CorruptionException -> L5f
                java.lang.Object r6 = androidx.datastore.core.DataStoreImpl.access$readDataFromFileOrDefault(r6, r5)     // Catch: androidx.datastore.core.CorruptionException -> L5f
                if (r6 != r0) goto L41
                goto L71
            L41:
                r1.f12717a = r6     // Catch: androidx.datastore.core.CorruptionException -> L5f
                kotlin.jvm.internal.y r1 = r5.$version     // Catch: androidx.datastore.core.CorruptionException -> L5f
                androidx.datastore.core.DataStoreImpl<T> r6 = r5.this$0     // Catch: androidx.datastore.core.CorruptionException -> L5f
                androidx.datastore.core.InterProcessCoordinator r6 = androidx.datastore.core.DataStoreImpl.access$getCoordinator(r6)     // Catch: androidx.datastore.core.CorruptionException -> L5f
                r5.L$0 = r1     // Catch: androidx.datastore.core.CorruptionException -> L5f
                r5.label = r3     // Catch: androidx.datastore.core.CorruptionException -> L5f
                java.lang.Object r6 = r6.getVersion(r5)     // Catch: androidx.datastore.core.CorruptionException -> L5f
                if (r6 != r0) goto L56
                goto L71
            L56:
                java.lang.Number r6 = (java.lang.Number) r6     // Catch: androidx.datastore.core.CorruptionException -> L5f
                int r6 = r6.intValue()     // Catch: androidx.datastore.core.CorruptionException -> L5f
                r1.f12730a = r6     // Catch: androidx.datastore.core.CorruptionException -> L5f
                goto L7c
            L5f:
                kotlin.jvm.internal.y r6 = r5.$version
                androidx.datastore.core.DataStoreImpl<T> r1 = r5.this$0
                kotlin.jvm.internal.a0 r3 = r5.$newData
                java.lang.Object r3 = r3.f12717a
                r5.L$0 = r6
                r5.label = r2
                java.lang.Object r1 = r1.writeData$datastore_core_release(r3, r4, r5)
                if (r1 != r0) goto L72
            L71:
                return r0
            L72:
                r0 = r6
                r6 = r1
            L74:
                java.lang.Number r6 = (java.lang.Number) r6
                int r6 = r6.intValue()
                r0.f12730a = r6
            L7c:
                q5.x r6 = q5.x.f13520a
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.DataStoreImpl.C03453.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // e6.l
        public final Object invoke(v5.c<? super x> cVar) {
            return ((C03453) create(cVar)).invokeSuspend(x.f13520a);
        }
    }

    /* JADX INFO: renamed from: androidx.datastore.core.DataStoreImpl$readState$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @x5.e(c = "androidx.datastore.core.DataStoreImpl$readState$2", f = "DataStoreImpl.kt", l = {Sdk.SDKError.Reason.MRAID_JS_DOES_NOT_EXIST_VALUE, Sdk.SDKError.Reason.PRIVACY_ICON_FALLBACK_ERROR_VALUE}, m = "invokeSuspend")
    public static final class C03462 extends i implements p {
        final /* synthetic */ boolean $requireLock;
        int label;
        final /* synthetic */ DataStoreImpl<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C03462(DataStoreImpl<T> dataStoreImpl, boolean z2, v5.c<? super C03462> cVar) {
            super(2, cVar);
            this.this$0 = dataStoreImpl;
            this.$requireLock = z2;
        }

        @Override // x5.a
        public final v5.c<x> create(Object obj, v5.c<?> cVar) {
            return new C03462(this.this$0, this.$requireLock, cVar);
        }

        /* JADX WARN: Code restructure failed: missing block: B:21:0x004f, code lost:
        
            if (r5 == r0) goto L22;
         */
        @Override // x5.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r5) throws java.lang.Throwable {
            /*
                r4 = this;
                w5.a r0 = w5.a.f17774a
                int r1 = r4.label
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L1e
                if (r1 == r3) goto L18
                if (r1 != r2) goto L10
                r2.q.z0(r5)
                goto L52
            L10:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r0)
                throw r5
            L18:
                r2.q.z0(r5)     // Catch: java.lang.Throwable -> L1c
                goto L45
            L1c:
                r5 = move-exception
                goto L55
            L1e:
                r2.q.z0(r5)
                androidx.datastore.core.DataStoreImpl<T> r5 = r4.this$0
                androidx.datastore.core.DataStoreInMemoryCache r5 = androidx.datastore.core.DataStoreImpl.access$getInMemoryCache$p(r5)
                androidx.datastore.core.State r5 = r5.getCurrentState()
                boolean r5 = r5 instanceof androidx.datastore.core.Final
                if (r5 == 0) goto L3a
                androidx.datastore.core.DataStoreImpl<T> r5 = r4.this$0
                androidx.datastore.core.DataStoreInMemoryCache r5 = androidx.datastore.core.DataStoreImpl.access$getInMemoryCache$p(r5)
                androidx.datastore.core.State r5 = r5.getCurrentState()
                return r5
            L3a:
                androidx.datastore.core.DataStoreImpl<T> r5 = r4.this$0     // Catch: java.lang.Throwable -> L1c
                r4.label = r3     // Catch: java.lang.Throwable -> L1c
                java.lang.Object r5 = androidx.datastore.core.DataStoreImpl.access$readAndInitOrPropagateAndThrowFailure(r5, r4)     // Catch: java.lang.Throwable -> L1c
                if (r5 != r0) goto L45
                goto L51
            L45:
                androidx.datastore.core.DataStoreImpl<T> r5 = r4.this$0
                boolean r1 = r4.$requireLock
                r4.label = r2
                java.lang.Object r5 = androidx.datastore.core.DataStoreImpl.access$readDataAndUpdateCache(r5, r1, r4)
                if (r5 != r0) goto L52
            L51:
                return r0
            L52:
                androidx.datastore.core.State r5 = (androidx.datastore.core.State) r5
                return r5
            L55:
                androidx.datastore.core.ReadException r0 = new androidx.datastore.core.ReadException
                r1 = -1
                r0.<init>(r5, r1)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.DataStoreImpl.C03462.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // e6.p
        public final Object invoke(a0 a0Var, v5.c<? super State<T>> cVar) {
            return ((C03462) create(a0Var, cVar)).invokeSuspend(x.f13520a);
        }
    }

    /* JADX INFO: renamed from: androidx.datastore.core.DataStoreImpl$transformAndWrite$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @x5.e(c = "androidx.datastore.core.DataStoreImpl$transformAndWrite$2", f = "DataStoreImpl.kt", l = {330, 331, 337}, m = "invokeSuspend")
    public static final class C03472 extends i implements e6.l {
        final /* synthetic */ h $callerContext;
        final /* synthetic */ p $transform;
        Object L$0;
        int label;
        final /* synthetic */ DataStoreImpl<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C03472(DataStoreImpl<T> dataStoreImpl, h hVar, p pVar, v5.c<? super C03472> cVar) {
            super(1, cVar);
            this.this$0 = dataStoreImpl;
            this.$callerContext = hVar;
            this.$transform = pVar;
        }

        @Override // x5.a
        public final v5.c<x> create(v5.c<?> cVar) {
            return new C03472(this.this$0, this.$callerContext, this.$transform, cVar);
        }

        /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
            jadx.core.utils.exceptions.JadxRuntimeException: Can't change immutable type v5.c to androidx.datastore.core.DataStoreImpl$transformAndWrite$2 for r8v1 'this'  v5.c
            	at jadx.core.dex.instructions.args.SSAVar.setType(SSAVar.java:114)
            	at jadx.core.dex.instructions.args.RegisterArg.setType(RegisterArg.java:52)
            	at jadx.core.dex.visitors.ModVisitor.removeCheckCast(ModVisitor.java:417)
            	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:152)
            	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:96)
            */
        @Override // x5.a
        public final java.lang.Object invokeSuspend(java.lang.Object r9) {
            /*
                r8 = this;
                w5.a r0 = w5.a.f17774a
                int r1 = r8.label
                r2 = 3
                r3 = 2
                r4 = 1
                if (r1 == 0) goto L29
                if (r1 == r4) goto L25
                if (r1 == r3) goto L1d
                if (r1 != r2) goto L15
                java.lang.Object r0 = r8.L$0
                r2.q.z0(r9)
                return r0
            L15:
                java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r9.<init>(r0)
                throw r9
            L1d:
                java.lang.Object r1 = r8.L$0
                androidx.datastore.core.Data r1 = (androidx.datastore.core.Data) r1
                r2.q.z0(r9)
                goto L4f
            L25:
                r2.q.z0(r9)
                goto L37
            L29:
                r2.q.z0(r9)
                androidx.datastore.core.DataStoreImpl<T> r9 = r8.this$0
                r8.label = r4
                java.lang.Object r9 = androidx.datastore.core.DataStoreImpl.access$readDataOrHandleCorruption(r9, r4, r8)
                if (r9 != r0) goto L37
                goto L68
            L37:
                r1 = r9
                androidx.datastore.core.Data r1 = (androidx.datastore.core.Data) r1
                v5.h r9 = r8.$callerContext
                androidx.datastore.core.DataStoreImpl$transformAndWrite$2$newData$1 r5 = new androidx.datastore.core.DataStoreImpl$transformAndWrite$2$newData$1
                e6.p r6 = r8.$transform
                r7 = 0
                r5.<init>(r6, r1, r7)
                r8.L$0 = r1
                r8.label = r3
                java.lang.Object r9 = q6.c0.H(r5, r9, r8)
                if (r9 != r0) goto L4f
                goto L68
            L4f:
                r1.checkHashCode()
                java.lang.Object r1 = r1.getValue()
                boolean r1 = kotlin.jvm.internal.k.a(r1, r9)
                if (r1 != 0) goto L69
                androidx.datastore.core.DataStoreImpl<T> r1 = r8.this$0
                r8.L$0 = r9
                r8.label = r2
                java.lang.Object r1 = r1.writeData$datastore_core_release(r9, r4, r8)
                if (r1 != r0) goto L69
            L68:
                return r0
            L69:
                return r9
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.DataStoreImpl.C03472.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // e6.l
        public final Object invoke(v5.c<? super T> cVar) {
            return ((C03472) create(cVar)).invokeSuspend(x.f13520a);
        }
    }

    /* JADX INFO: renamed from: androidx.datastore.core.DataStoreImpl$updateData$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @x5.e(c = "androidx.datastore.core.DataStoreImpl$updateData$2", f = "DataStoreImpl.kt", l = {169}, m = "invokeSuspend")
    public static final class C03482 extends i implements p {
        final /* synthetic */ p $transform;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ DataStoreImpl<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C03482(DataStoreImpl<T> dataStoreImpl, p pVar, v5.c<? super C03482> cVar) {
            super(2, cVar);
            this.this$0 = dataStoreImpl;
            this.$transform = pVar;
        }

        @Override // x5.a
        public final v5.c<x> create(Object obj, v5.c<?> cVar) {
            C03482 c03482 = new C03482(this.this$0, this.$transform, cVar);
            c03482.L$0 = obj;
            return c03482;
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            w5.a aVar = w5.a.f17774a;
            int i2 = this.label;
            if (i2 != 0) {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                q.z0(obj);
                return obj;
            }
            q.z0(obj);
            a0 a0Var = (a0) this.L$0;
            r rVarA = c0.a();
            ((DataStoreImpl) this.this$0).writeActor.offer(new Message.Update(this.$transform, rVarA, ((DataStoreImpl) this.this$0).inMemoryCache.getCurrentState(), a0Var.getCoroutineContext()));
            this.label = 1;
            Object objT = rVarA.t(this);
            return objT == aVar ? aVar : objT;
        }

        @Override // e6.p
        public final Object invoke(a0 a0Var, v5.c<? super T> cVar) {
            return ((C03482) create(a0Var, cVar)).invokeSuspend(x.f13520a);
        }
    }

    public DataStoreImpl(Storage<T> storage, List<? extends p> initTasksList, CorruptionHandler<T> corruptionHandler, a0 scope) {
        k.e(storage, "storage");
        k.e(initTasksList, "initTasksList");
        k.e(corruptionHandler, "corruptionHandler");
        k.e(scope, "scope");
        this.storage = storage;
        this.corruptionHandler = corruptionHandler;
        this.scope = scope;
        this.data = new a4.a(new DataStoreImpl$data$1(this, null));
        this.collectorMutex = d.a();
        this.inMemoryCache = new DataStoreInMemoryCache<>();
        this.readAndInit = new InitDataStore(this, initTasksList);
        this.storageConnectionDelegate = b.C(new DataStoreImpl$storageConnectionDelegate$1(this));
        this.coordinator$delegate = b.C(new DataStoreImpl$coordinator$2(this));
        this.writeActor = new SimpleActor<>(scope, new DataStoreImpl$writeActor$1(this), DataStoreImpl$writeActor$2.INSTANCE, new DataStoreImpl$writeActor$3(this, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object decrementCollector(v5.c<? super q5.x> r5) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r5 instanceof androidx.datastore.core.DataStoreImpl.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r5
            androidx.datastore.core.DataStoreImpl$decrementCollector$1 r0 = (androidx.datastore.core.DataStoreImpl.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.datastore.core.DataStoreImpl$decrementCollector$1 r0 = new androidx.datastore.core.DataStoreImpl$decrementCollector$1
            r0.<init>(r4, r5)
        L18:
            java.lang.Object r5 = r0.result
            w5.a r1 = w5.a.f17774a
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            java.lang.Object r1 = r0.L$1
            z6.a r1 = (z6.a) r1
            java.lang.Object r0 = r0.L$0
            androidx.datastore.core.DataStoreImpl r0 = (androidx.datastore.core.DataStoreImpl) r0
            r2.q.z0(r5)
            goto L4d
        L2f:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L37:
            r2.q.z0(r5)
            z6.a r5 = r4.collectorMutex
            r0.L$0 = r4
            r0.L$1 = r5
            r0.label = r3
            z6.c r5 = (z6.c) r5
            java.lang.Object r0 = r5.d(r0)
            if (r0 != r1) goto L4b
            return r1
        L4b:
            r0 = r4
            r1 = r5
        L4d:
            r5 = 0
            int r2 = r0.collectorCounter     // Catch: java.lang.Throwable -> L5e
            int r2 = r2 + (-1)
            r0.collectorCounter = r2     // Catch: java.lang.Throwable -> L5e
            if (r2 != 0) goto L62
            q6.f1 r2 = r0.collectorJob     // Catch: java.lang.Throwable -> L5e
            if (r2 == 0) goto L60
            r2.a(r5)     // Catch: java.lang.Throwable -> L5e
            goto L60
        L5e:
            r0 = move-exception
            goto L6a
        L60:
            r0.collectorJob = r5     // Catch: java.lang.Throwable -> L5e
        L62:
            z6.c r1 = (z6.c) r1
            r1.f(r5)
            q5.x r5 = q5.x.f13520a
            return r5
        L6a:
            z6.c r1 = (z6.c) r1
            r1.f(r5)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.DataStoreImpl.decrementCollector(v5.c):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final <R> Object doWithWriteFileLock(boolean z2, e6.l lVar, v5.c<? super R> cVar) {
        return z2 ? lVar.invoke(cVar) : getCoordinator().lock(new AnonymousClass3(lVar, null), cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final InterProcessCoordinator getCoordinator() {
        return (InterProcessCoordinator) this.coordinator$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00b0, code lost:
    
        if (r9 != r1) goto L29;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object handleUpdate(androidx.datastore.core.Message.Update<T> r9, v5.c<? super q5.x> r10) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 240
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.DataStoreImpl.handleUpdate(androidx.datastore.core.Message$Update, v5.c):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object incrementCollector(v5.c<? super q5.x> r6) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r6 instanceof androidx.datastore.core.DataStoreImpl.C03401
            if (r0 == 0) goto L13
            r0 = r6
            androidx.datastore.core.DataStoreImpl$incrementCollector$1 r0 = (androidx.datastore.core.DataStoreImpl.C03401) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.datastore.core.DataStoreImpl$incrementCollector$1 r0 = new androidx.datastore.core.DataStoreImpl$incrementCollector$1
            r0.<init>(r5, r6)
        L18:
            java.lang.Object r6 = r0.result
            w5.a r1 = w5.a.f17774a
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            java.lang.Object r1 = r0.L$1
            z6.a r1 = (z6.a) r1
            java.lang.Object r0 = r0.L$0
            androidx.datastore.core.DataStoreImpl r0 = (androidx.datastore.core.DataStoreImpl) r0
            r2.q.z0(r6)
            goto L4d
        L2f:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L37:
            r2.q.z0(r6)
            z6.a r6 = r5.collectorMutex
            r0.L$0 = r5
            r0.L$1 = r6
            r0.label = r3
            z6.c r6 = (z6.c) r6
            java.lang.Object r0 = r6.d(r0)
            if (r0 != r1) goto L4b
            return r1
        L4b:
            r0 = r5
            r1 = r6
        L4d:
            r6 = 0
            int r2 = r0.collectorCounter     // Catch: java.lang.Throwable -> L64
            int r2 = r2 + r3
            r0.collectorCounter = r2     // Catch: java.lang.Throwable -> L64
            if (r2 != r3) goto L66
            q6.a0 r2 = r0.scope     // Catch: java.lang.Throwable -> L64
            androidx.datastore.core.DataStoreImpl$incrementCollector$2$1 r3 = new androidx.datastore.core.DataStoreImpl$incrementCollector$2$1     // Catch: java.lang.Throwable -> L64
            r3.<init>(r0, r6)     // Catch: java.lang.Throwable -> L64
            r4 = 3
            q6.u1 r2 = q6.c0.u(r2, r6, r3, r4)     // Catch: java.lang.Throwable -> L64
            r0.collectorJob = r2     // Catch: java.lang.Throwable -> L64
            goto L66
        L64:
            r0 = move-exception
            goto L6e
        L66:
            z6.c r1 = (z6.c) r1
            r1.f(r6)
            q5.x r6 = q5.x.f13520a
            return r6
        L6e:
            z6.c r1 = (z6.c) r1
            r1.f(r6)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.DataStoreImpl.incrementCollector(v5.c):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0067, code lost:
    
        if (r4.runIfNeeded(r0) == r1) goto L27;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object readAndInitOrPropagateAndThrowFailure(v5.c<? super q5.x> r6) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r6 instanceof androidx.datastore.core.DataStoreImpl.C03411
            if (r0 == 0) goto L13
            r0 = r6
            androidx.datastore.core.DataStoreImpl$readAndInitOrPropagateAndThrowFailure$1 r0 = (androidx.datastore.core.DataStoreImpl.C03411) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.datastore.core.DataStoreImpl$readAndInitOrPropagateAndThrowFailure$1 r0 = new androidx.datastore.core.DataStoreImpl$readAndInitOrPropagateAndThrowFailure$1
            r0.<init>(r5, r6)
        L18:
            java.lang.Object r6 = r0.result
            w5.a r1 = w5.a.f17774a
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L42
            if (r2 == r4) goto L3a
            if (r2 != r3) goto L32
            int r1 = r0.I$0
            java.lang.Object r0 = r0.L$0
            androidx.datastore.core.DataStoreImpl r0 = (androidx.datastore.core.DataStoreImpl) r0
            r2.q.z0(r6)     // Catch: java.lang.Throwable -> L30
            goto L6a
        L30:
            r6 = move-exception
            goto L71
        L32:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L3a:
            java.lang.Object r2 = r0.L$0
            androidx.datastore.core.DataStoreImpl r2 = (androidx.datastore.core.DataStoreImpl) r2
            r2.q.z0(r6)
            goto L55
        L42:
            r2.q.z0(r6)
            androidx.datastore.core.InterProcessCoordinator r6 = r5.getCoordinator()
            r0.L$0 = r5
            r0.label = r4
            java.lang.Object r6 = r6.getVersion(r0)
            if (r6 != r1) goto L54
            goto L69
        L54:
            r2 = r5
        L55:
            java.lang.Number r6 = (java.lang.Number) r6
            int r6 = r6.intValue()
            androidx.datastore.core.DataStoreImpl<T>$InitDataStore r4 = r2.readAndInit     // Catch: java.lang.Throwable -> L6d
            r0.L$0 = r2     // Catch: java.lang.Throwable -> L6d
            r0.I$0 = r6     // Catch: java.lang.Throwable -> L6d
            r0.label = r3     // Catch: java.lang.Throwable -> L6d
            java.lang.Object r6 = r4.runIfNeeded(r0)     // Catch: java.lang.Throwable -> L6d
            if (r6 != r1) goto L6a
        L69:
            return r1
        L6a:
            q5.x r6 = q5.x.f13520a
            return r6
        L6d:
            r0 = move-exception
            r1 = r6
            r6 = r0
            r0 = r2
        L71:
            androidx.datastore.core.DataStoreInMemoryCache<T> r0 = r0.inMemoryCache
            androidx.datastore.core.ReadException r2 = new androidx.datastore.core.ReadException
            r2.<init>(r6, r1)
            r0.tryUpdate(r2)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.DataStoreImpl.readAndInitOrPropagateAndThrowFailure(v5.c):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00a5, code lost:
    
        if (r11 == r1) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00be, code lost:
    
        if (r11 == r1) goto L39;
     */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object readDataAndUpdateCache(boolean r10, v5.c<? super androidx.datastore.core.State<T>> r11) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 223
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.DataStoreImpl.readDataAndUpdateCache(boolean, v5.c):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object readDataFromFileOrDefault(v5.c<? super T> cVar) {
        return StorageConnectionKt.readData(getStorageConnection$datastore_core_release(), cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0153  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00a8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v0, types: [int] */
    /* JADX WARN: Type inference failed for: r2v14, types: [androidx.datastore.core.DataStoreImpl, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v22 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r6v10, types: [androidx.datastore.core.DataStoreImpl] */
    /* JADX WARN: Type inference failed for: r6v14 */
    /* JADX WARN: Type inference failed for: r6v15 */
    /* JADX WARN: Type inference failed for: r6v16 */
    /* JADX WARN: Type inference failed for: r6v17 */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v4, types: [androidx.datastore.core.DataStoreImpl, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r6v6 */
    /* JADX WARN: Type inference failed for: r6v7 */
    /* JADX WARN: Type inference failed for: r6v8 */
    /* JADX WARN: Type inference failed for: r7v0 */
    /* JADX WARN: Type inference failed for: r7v1, types: [androidx.datastore.core.DataStoreImpl, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v2, types: [androidx.datastore.core.DataStoreImpl] */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARN: Type inference failed for: r7v6 */
    /* JADX WARN: Type inference failed for: r7v9 */
    /* JADX WARN: Type inference failed for: r9v0, types: [androidx.datastore.core.DataStoreImpl, androidx.datastore.core.DataStoreImpl<T>, java.lang.Object] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object readDataOrHandleCorruption(boolean r10, v5.c<? super androidx.datastore.core.Data<T>> r11) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 374
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.DataStoreImpl.readDataOrHandleCorruption(boolean, v5.c):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object readState(boolean z2, v5.c<? super State<T>> cVar) {
        return c0.H(new C03462(this, z2, null), this.scope.getCoroutineContext(), cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object transformAndWrite(p pVar, h hVar, v5.c<? super T> cVar) {
        return getCoordinator().lock(new C03472(this, hVar, pVar, null), cVar);
    }

    @Override // androidx.datastore.core.DataStore
    public e getData() {
        return this.data;
    }

    public final StorageConnection<T> getStorageConnection$datastore_core_release() {
        return (StorageConnection) this.storageConnectionDelegate.getValue();
    }

    @Override // androidx.datastore.core.DataStore
    public Object updateData(p pVar, v5.c<? super T> cVar) {
        UpdatingDataContextElement updatingDataContextElement = (UpdatingDataContextElement) cVar.getContext().get(UpdatingDataContextElement.Companion.Key.INSTANCE);
        if (updatingDataContextElement != null) {
            updatingDataContextElement.checkNotUpdating(this);
        }
        return c0.H(new C03482(this, pVar, null), new UpdatingDataContextElement(updatingDataContextElement, this), cVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object writeData$datastore_core_release(T r11, boolean r12, v5.c<? super java.lang.Integer> r13) throws java.lang.Throwable {
        /*
            r10 = this;
            boolean r0 = r13 instanceof androidx.datastore.core.DataStoreImpl$writeData$1
            if (r0 == 0) goto L13
            r0 = r13
            androidx.datastore.core.DataStoreImpl$writeData$1 r0 = (androidx.datastore.core.DataStoreImpl$writeData$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.datastore.core.DataStoreImpl$writeData$1 r0 = new androidx.datastore.core.DataStoreImpl$writeData$1
            r0.<init>(r10, r13)
        L18:
            java.lang.Object r13 = r0.result
            w5.a r1 = w5.a.f17774a
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            java.lang.Object r11 = r0.L$0
            kotlin.jvm.internal.y r11 = (kotlin.jvm.internal.y) r11
            r2.q.z0(r13)
            goto L54
        L2b:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L33:
            r2.q.z0(r13)
            kotlin.jvm.internal.y r5 = new kotlin.jvm.internal.y
            r5.<init>()
            androidx.datastore.core.StorageConnection r13 = r10.getStorageConnection$datastore_core_release()
            androidx.datastore.core.DataStoreImpl$writeData$2 r4 = new androidx.datastore.core.DataStoreImpl$writeData$2
            r9 = 0
            r6 = r10
            r7 = r11
            r8 = r12
            r4.<init>(r5, r6, r7, r8, r9)
            r0.L$0 = r5
            r0.label = r3
            java.lang.Object r11 = r13.writeScope(r4, r0)
            if (r11 != r1) goto L53
            return r1
        L53:
            r11 = r5
        L54:
            int r11 = r11.f12730a
            java.lang.Integer r12 = new java.lang.Integer
            r12.<init>(r11)
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.DataStoreImpl.writeData$datastore_core_release(java.lang.Object, boolean, v5.c):java.lang.Object");
    }

    public /* synthetic */ DataStoreImpl(Storage storage, List list, CorruptionHandler corruptionHandler, a0 a0Var, int i2, kotlin.jvm.internal.f fVar) {
        this(storage, (i2 & 2) != 0 ? r5.r.f13638a : list, (i2 & 4) != 0 ? new NoOpCorruptionHandler() : corruptionHandler, (i2 & 8) != 0 ? c0.b(Actual_jvmKt.ioDispatcher().plus(c0.e())) : a0Var);
    }
}
