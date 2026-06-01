package com.unity3d.ads.core.data.repository;

import android.app.Activity;
import android.support.v4.media.g;
import com.unity3d.ads.core.domain.AndroidGetLifecycleFlow;
import com.unity3d.ads.core.domain.LifecycleEvent;
import com.vungle.ads.internal.protos.Sdk;
import e6.p;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import l6.o;
import q5.x;
import q6.c0;
import q6.w;
import r2.q;
import t6.b1;
import t6.d1;
import t6.f;
import t6.q0;
import t6.x0;
import v5.c;
import w5.a;
import x5.e;
import x5.i;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class OrientationRepository {
    private final q0 _resumedActivityOrientation;
    private final w defaultDispatcher;
    private final AndroidGetLifecycleFlow getLifecycleFlow;
    private final q0 isRunning;
    private final b1 resumedActivityOrientation;

    /* JADX INFO: renamed from: com.unity3d.ads.core.data.repository.OrientationRepository$invoke$4, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.unity3d.ads.core.data.repository.OrientationRepository$invoke$4", f = "OrientationRepository.kt", l = {}, m = "invokeSuspend")
    public static final class AnonymousClass4 extends i implements p {
        /* synthetic */ Object L$0;
        int label;

        public AnonymousClass4(c<? super AnonymousClass4> cVar) {
            super(2, cVar);
        }

        @Override // x5.a
        public final c<x> create(Object obj, c<?> cVar) {
            AnonymousClass4 anonymousClass4 = OrientationRepository.this.new AnonymousClass4(cVar);
            anonymousClass4.L$0 = obj;
            return anonymousClass4;
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            a aVar = a.f17774a;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            q.z0(obj);
            WeakReference weakReference = (WeakReference) this.L$0;
            q0 q0Var = OrientationRepository.this._resumedActivityOrientation;
            Activity activity = (Activity) weakReference.get();
            Integer num = new Integer(activity != null ? activity.getRequestedOrientation() : -1);
            d1 d1Var = (d1) q0Var;
            d1Var.getClass();
            d1Var.i(null, num);
            return x.f13520a;
        }

        @Override // e6.p
        public final Object invoke(WeakReference<Activity> weakReference, c<? super x> cVar) {
            return ((AnonymousClass4) create(weakReference, cVar)).invokeSuspend(x.f13520a);
        }
    }

    public OrientationRepository(AndroidGetLifecycleFlow getLifecycleFlow, w defaultDispatcher) {
        k.e(getLifecycleFlow, "getLifecycleFlow");
        k.e(defaultDispatcher, "defaultDispatcher");
        this.getLifecycleFlow = getLifecycleFlow;
        this.defaultDispatcher = defaultDispatcher;
        this.isRunning = x0.c(Boolean.FALSE);
        d1 d1VarC = x0.c(-1);
        this._resumedActivityOrientation = d1VarC;
        this.resumedActivityOrientation = d1VarC;
    }

    public final b1 getResumedActivityOrientation() {
        return this.resumedActivityOrientation;
    }

    public final void invoke() {
        d1 d1Var;
        Object value;
        Boolean bool;
        q0 q0Var = this.isRunning;
        do {
            d1Var = (d1) q0Var;
            value = d1Var.getValue();
            bool = (Boolean) value;
            bool.getClass();
        } while (!d1Var.g(value, Boolean.TRUE));
        if (bool.booleanValue()) {
            return;
        }
        final t6.e eVarInvoke = this.getLifecycleFlow.invoke();
        final t6.e eVar = new t6.e() { // from class: com.unity3d.ads.core.data.repository.OrientationRepository$invoke$$inlined$filterIsInstance$1

            /* JADX INFO: renamed from: com.unity3d.ads.core.data.repository.OrientationRepository$invoke$$inlined$filterIsInstance$1$2, reason: invalid class name */
            /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
            public static final class AnonymousClass2<T> implements f {
                final /* synthetic */ f $this_unsafeFlow;

                /* JADX INFO: renamed from: com.unity3d.ads.core.data.repository.OrientationRepository$invoke$$inlined$filterIsInstance$1$2$1, reason: invalid class name */
                /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
                @e(c = "com.unity3d.ads.core.data.repository.OrientationRepository$invoke$$inlined$filterIsInstance$1$2", f = "OrientationRepository.kt", l = {Sdk.SDKError.Reason.AD_LOAD_FAIL_EMPTY_BID_PAYLOAD_VALUE}, m = "emit")
                public static final class AnonymousClass1 extends x5.c {
                    Object L$0;
                    Object L$1;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(c cVar) {
                        super(cVar);
                    }

                    @Override // x5.a
                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(f fVar) {
                    this.$this_unsafeFlow = fVar;
                }

                /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                @Override // t6.f
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final java.lang.Object emit(java.lang.Object r5, v5.c r6) throws java.lang.Throwable {
                    /*
                        r4 = this;
                        boolean r0 = r6 instanceof com.unity3d.ads.core.data.repository.OrientationRepository$invoke$$inlined$filterIsInstance$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r6
                        com.unity3d.ads.core.data.repository.OrientationRepository$invoke$$inlined$filterIsInstance$1$2$1 r0 = (com.unity3d.ads.core.data.repository.OrientationRepository$invoke$$inlined$filterIsInstance$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L18
                    L13:
                        com.unity3d.ads.core.data.repository.OrientationRepository$invoke$$inlined$filterIsInstance$1$2$1 r0 = new com.unity3d.ads.core.data.repository.OrientationRepository$invoke$$inlined$filterIsInstance$1$2$1
                        r0.<init>(r6)
                    L18:
                        java.lang.Object r6 = r0.result
                        w5.a r1 = w5.a.f17774a
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L2f
                        if (r2 != r3) goto L27
                        r2.q.z0(r6)
                        goto L41
                    L27:
                        java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                        java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                        r5.<init>(r6)
                        throw r5
                    L2f:
                        r2.q.z0(r6)
                        t6.f r6 = r4.$this_unsafeFlow
                        boolean r2 = r5 instanceof com.unity3d.ads.core.domain.LifecycleEvent.Resumed
                        if (r2 == 0) goto L41
                        r0.label = r3
                        java.lang.Object r5 = r6.emit(r5, r0)
                        if (r5 != r1) goto L41
                        return r1
                    L41:
                        q5.x r5 = q5.x.f13520a
                        return r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.core.data.repository.OrientationRepository$invoke$$inlined$filterIsInstance$1.AnonymousClass2.emit(java.lang.Object, v5.c):java.lang.Object");
                }
            }

            @Override // t6.e
            public Object collect(f fVar, c cVar) {
                Object objCollect = eVarInvoke.collect(new AnonymousClass2(fVar), cVar);
                return objCollect == a.f17774a ? objCollect : x.f13520a;
            }
        };
        final AnonymousClass3 anonymousClass3 = new t() { // from class: com.unity3d.ads.core.data.repository.OrientationRepository.invoke.3
            @Override // l6.o
            public Object get(Object obj) {
                return ((LifecycleEvent) obj).getActivity();
            }
        };
        x0.o(new g(24, new t6.e() { // from class: com.unity3d.ads.core.data.repository.OrientationRepository$invoke$$inlined$map$1

            /* JADX INFO: renamed from: com.unity3d.ads.core.data.repository.OrientationRepository$invoke$$inlined$map$1$2, reason: invalid class name */
            /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
            public static final class AnonymousClass2<T> implements f {
                final /* synthetic */ f $this_unsafeFlow;
                final /* synthetic */ o receiver$inlined;

                /* JADX INFO: renamed from: com.unity3d.ads.core.data.repository.OrientationRepository$invoke$$inlined$map$1$2$1, reason: invalid class name */
                /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
                @e(c = "com.unity3d.ads.core.data.repository.OrientationRepository$invoke$$inlined$map$1$2", f = "OrientationRepository.kt", l = {Sdk.SDKError.Reason.STALE_CACHED_RESPONSE_VALUE}, m = "emit")
                public static final class AnonymousClass1 extends x5.c {
                    Object L$0;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(c cVar) {
                        super(cVar);
                    }

                    @Override // x5.a
                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(f fVar, o oVar) {
                    this.$this_unsafeFlow = fVar;
                    this.receiver$inlined = oVar;
                }

                /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                @Override // t6.f
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final java.lang.Object emit(java.lang.Object r5, v5.c r6) throws java.lang.Throwable {
                    /*
                        r4 = this;
                        boolean r0 = r6 instanceof com.unity3d.ads.core.data.repository.OrientationRepository$invoke$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r6
                        com.unity3d.ads.core.data.repository.OrientationRepository$invoke$$inlined$map$1$2$1 r0 = (com.unity3d.ads.core.data.repository.OrientationRepository$invoke$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L18
                    L13:
                        com.unity3d.ads.core.data.repository.OrientationRepository$invoke$$inlined$map$1$2$1 r0 = new com.unity3d.ads.core.data.repository.OrientationRepository$invoke$$inlined$map$1$2$1
                        r0.<init>(r6)
                    L18:
                        java.lang.Object r6 = r0.result
                        w5.a r1 = w5.a.f17774a
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L2f
                        if (r2 != r3) goto L27
                        r2.q.z0(r6)
                        goto L45
                    L27:
                        java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                        java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                        r5.<init>(r6)
                        throw r5
                    L2f:
                        r2.q.z0(r6)
                        t6.f r6 = r4.$this_unsafeFlow
                        com.unity3d.ads.core.domain.LifecycleEvent r5 = (com.unity3d.ads.core.domain.LifecycleEvent) r5
                        l6.o r2 = r4.receiver$inlined
                        java.lang.Object r5 = r2.get(r5)
                        r0.label = r3
                        java.lang.Object r5 = r6.emit(r5, r0)
                        if (r5 != r1) goto L45
                        return r1
                    L45:
                        q5.x r5 = q5.x.f13520a
                        return r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.core.data.repository.OrientationRepository$invoke$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, v5.c):java.lang.Object");
                }
            }

            @Override // t6.e
            public Object collect(f fVar, c cVar) {
                Object objCollect = eVar.collect(new AnonymousClass2(fVar, anonymousClass3), cVar);
                return objCollect == a.f17774a ? objCollect : x.f13520a;
            }
        }, new AnonymousClass4(null)), c0.b(this.defaultDispatcher));
    }
}
