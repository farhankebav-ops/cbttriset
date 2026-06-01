package com.unity3d.ads.core.data.repository;

import com.unity3d.ads.core.domain.AndroidGetLifecycleFlow;
import com.unity3d.services.core.log.DeviceLog;
import com.vungle.ads.internal.protos.Sdk;
import kotlin.jvm.internal.k;
import q5.x;
import q6.c0;
import q6.w;
import t6.e;
import t6.f;
import t6.t0;
import t6.x0;
import w5.a;
import x5.c;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class FocusRepository {
    private final t0 focusState;

    public FocusRepository(AndroidGetLifecycleFlow getLifecycleFlow, w defaultDispatcher) {
        t0 t0VarA;
        k.e(getLifecycleFlow, "getLifecycleFlow");
        k.e(defaultDispatcher, "defaultDispatcher");
        try {
            final e eVarInvoke = getLifecycleFlow.invoke();
            final e eVar = new e() { // from class: com.unity3d.ads.core.data.repository.FocusRepository$special$$inlined$filter$1

                /* JADX INFO: renamed from: com.unity3d.ads.core.data.repository.FocusRepository$special$$inlined$filter$1$2, reason: invalid class name */
                /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
                public static final class AnonymousClass2<T> implements f {
                    final /* synthetic */ f $this_unsafeFlow;

                    /* JADX INFO: renamed from: com.unity3d.ads.core.data.repository.FocusRepository$special$$inlined$filter$1$2$1, reason: invalid class name */
                    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
                    @x5.e(c = "com.unity3d.ads.core.data.repository.FocusRepository$special$$inlined$filter$1$2", f = "FocusRepository.kt", l = {Sdk.SDKError.Reason.STALE_CACHED_RESPONSE_VALUE}, m = "emit")
                    public static final class AnonymousClass1 extends c {
                        Object L$0;
                        Object L$1;
                        int label;
                        /* synthetic */ Object result;

                        public AnonymousClass1(v5.c cVar) {
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
                    public final java.lang.Object emit(java.lang.Object r6, v5.c r7) throws java.lang.Throwable {
                        /*
                            r5 = this;
                            boolean r0 = r7 instanceof com.unity3d.ads.core.data.repository.FocusRepository$special$$inlined$filter$1.AnonymousClass2.AnonymousClass1
                            if (r0 == 0) goto L13
                            r0 = r7
                            com.unity3d.ads.core.data.repository.FocusRepository$special$$inlined$filter$1$2$1 r0 = (com.unity3d.ads.core.data.repository.FocusRepository$special$$inlined$filter$1.AnonymousClass2.AnonymousClass1) r0
                            int r1 = r0.label
                            r2 = -2147483648(0xffffffff80000000, float:-0.0)
                            r3 = r1 & r2
                            if (r3 == 0) goto L13
                            int r1 = r1 - r2
                            r0.label = r1
                            goto L18
                        L13:
                            com.unity3d.ads.core.data.repository.FocusRepository$special$$inlined$filter$1$2$1 r0 = new com.unity3d.ads.core.data.repository.FocusRepository$special$$inlined$filter$1$2$1
                            r0.<init>(r7)
                        L18:
                            java.lang.Object r7 = r0.result
                            w5.a r1 = w5.a.f17774a
                            int r2 = r0.label
                            r3 = 1
                            if (r2 == 0) goto L2f
                            if (r2 != r3) goto L27
                            r2.q.z0(r7)
                            goto L48
                        L27:
                            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                            r6.<init>(r7)
                            throw r6
                        L2f:
                            r2.q.z0(r7)
                            t6.f r7 = r5.$this_unsafeFlow
                            r2 = r6
                            com.unity3d.ads.core.domain.LifecycleEvent r2 = (com.unity3d.ads.core.domain.LifecycleEvent) r2
                            boolean r4 = r2 instanceof com.unity3d.ads.core.domain.LifecycleEvent.Paused
                            if (r4 != 0) goto L3f
                            boolean r2 = r2 instanceof com.unity3d.ads.core.domain.LifecycleEvent.Resumed
                            if (r2 == 0) goto L48
                        L3f:
                            r0.label = r3
                            java.lang.Object r6 = r7.emit(r6, r0)
                            if (r6 != r1) goto L48
                            return r1
                        L48:
                            q5.x r6 = q5.x.f13520a
                            return r6
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.core.data.repository.FocusRepository$special$$inlined$filter$1.AnonymousClass2.emit(java.lang.Object, v5.c):java.lang.Object");
                    }
                }

                @Override // t6.e
                public Object collect(f fVar, v5.c cVar) {
                    Object objCollect = eVarInvoke.collect(new AnonymousClass2(fVar), cVar);
                    return objCollect == a.f17774a ? objCollect : x.f13520a;
                }
            };
            t0VarA = x0.p(new e() { // from class: com.unity3d.ads.core.data.repository.FocusRepository$special$$inlined$map$1

                /* JADX INFO: renamed from: com.unity3d.ads.core.data.repository.FocusRepository$special$$inlined$map$1$2, reason: invalid class name */
                /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
                public static final class AnonymousClass2<T> implements f {
                    final /* synthetic */ f $this_unsafeFlow;

                    /* JADX INFO: renamed from: com.unity3d.ads.core.data.repository.FocusRepository$special$$inlined$map$1$2$1, reason: invalid class name */
                    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
                    @x5.e(c = "com.unity3d.ads.core.data.repository.FocusRepository$special$$inlined$map$1$2", f = "FocusRepository.kt", l = {Sdk.SDKError.Reason.STALE_CACHED_RESPONSE_VALUE}, m = "emit")
                    public static final class AnonymousClass1 extends c {
                        Object L$0;
                        int label;
                        /* synthetic */ Object result;

                        public AnonymousClass1(v5.c cVar) {
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
                            boolean r0 = r6 instanceof com.unity3d.ads.core.data.repository.FocusRepository$special$$inlined$map$1.AnonymousClass2.AnonymousClass1
                            if (r0 == 0) goto L13
                            r0 = r6
                            com.unity3d.ads.core.data.repository.FocusRepository$special$$inlined$map$1$2$1 r0 = (com.unity3d.ads.core.data.repository.FocusRepository$special$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                            int r1 = r0.label
                            r2 = -2147483648(0xffffffff80000000, float:-0.0)
                            r3 = r1 & r2
                            if (r3 == 0) goto L13
                            int r1 = r1 - r2
                            r0.label = r1
                            goto L18
                        L13:
                            com.unity3d.ads.core.data.repository.FocusRepository$special$$inlined$map$1$2$1 r0 = new com.unity3d.ads.core.data.repository.FocusRepository$special$$inlined$map$1$2$1
                            r0.<init>(r6)
                        L18:
                            java.lang.Object r6 = r0.result
                            w5.a r1 = w5.a.f17774a
                            int r2 = r0.label
                            r3 = 1
                            if (r2 == 0) goto L2f
                            if (r2 != r3) goto L27
                            r2.q.z0(r6)
                            goto L56
                        L27:
                            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                            r5.<init>(r6)
                            throw r5
                        L2f:
                            r2.q.z0(r6)
                            t6.f r6 = r4.$this_unsafeFlow
                            com.unity3d.ads.core.domain.LifecycleEvent r5 = (com.unity3d.ads.core.domain.LifecycleEvent) r5
                            boolean r2 = r5 instanceof com.unity3d.ads.core.domain.LifecycleEvent.Resumed
                            if (r2 == 0) goto L44
                            com.unity3d.ads.core.data.repository.FocusState$Focused r2 = new com.unity3d.ads.core.data.repository.FocusState$Focused
                            java.lang.ref.WeakReference r5 = r5.getActivity()
                            r2.<init>(r5)
                            goto L4d
                        L44:
                            com.unity3d.ads.core.data.repository.FocusState$Unfocused r2 = new com.unity3d.ads.core.data.repository.FocusState$Unfocused
                            java.lang.ref.WeakReference r5 = r5.getActivity()
                            r2.<init>(r5)
                        L4d:
                            r0.label = r3
                            java.lang.Object r5 = r6.emit(r2, r0)
                            if (r5 != r1) goto L56
                            return r1
                        L56:
                            q5.x r5 = q5.x.f13520a
                            return r5
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.core.data.repository.FocusRepository$special$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, v5.c):java.lang.Object");
                    }
                }

                @Override // t6.e
                public Object collect(f fVar, v5.c cVar) {
                    Object objCollect = eVar.collect(new AnonymousClass2(fVar), cVar);
                    return objCollect == a.f17774a ? objCollect : x.f13520a;
                }
            }, c0.b(defaultDispatcher), 1);
        } catch (Exception e) {
            DeviceLog.error("Could not subscribe to lifecycle flow", e);
            t0VarA = x0.a((7 & 1) != 0 ? 0 : 100, (7 & 2) == 0 ? 64 : 0, s6.a.f13718a);
        }
        this.focusState = t0VarA;
    }

    public final t0 getFocusState() {
        return this.focusState;
    }
}
