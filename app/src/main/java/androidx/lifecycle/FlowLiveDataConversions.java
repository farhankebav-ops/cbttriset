package androidx.lifecycle;

import androidx.annotation.RequiresApi;
import androidx.arch.core.executor.ArchTaskExecutor;
import androidx.camera.core.impl.utils.RedirectableLiveData;
import androidx.lifecycle.FlowLiveDataConversions;
import e2.s;
import e6.p;
import java.time.Duration;
import q5.x;
import q6.a0;
import q6.c0;
import q6.m0;
import q6.q1;
import r2.q;
import s6.w;
import t6.b1;
import t6.x0;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class FlowLiveDataConversions {

    /* JADX INFO: renamed from: androidx.lifecycle.FlowLiveDataConversions$asFlow$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @x5.e(c = "androidx.lifecycle.FlowLiveDataConversions$asFlow$1", f = "FlowLiveData.kt", l = {105, 106, 108}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends x5.i implements p {
        final /* synthetic */ LiveData<T> $this_asFlow;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX INFO: renamed from: androidx.lifecycle.FlowLiveDataConversions$asFlow$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        @x5.e(c = "androidx.lifecycle.FlowLiveDataConversions$asFlow$1$1", f = "FlowLiveData.kt", l = {}, m = "invokeSuspend")
        public static final class C00081 extends x5.i implements p {
            final /* synthetic */ Observer<T> $observer;
            final /* synthetic */ LiveData<T> $this_asFlow;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C00081(LiveData<T> liveData, Observer<T> observer, v5.c<? super C00081> cVar) {
                super(2, cVar);
                this.$this_asFlow = liveData;
                this.$observer = observer;
            }

            @Override // x5.a
            public final v5.c<x> create(Object obj, v5.c<?> cVar) {
                return new C00081(this.$this_asFlow, this.$observer, cVar);
            }

            /* JADX WARN: Type inference fix 'apply assigned field type' failed
            java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
            	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
            	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
            	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
             */
            @Override // x5.a
            public final Object invokeSuspend(Object obj) throws Throwable {
                w5.a aVar = w5.a.f17774a;
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                q.z0(obj);
                this.$this_asFlow.observeForever(this.$observer);
                return x.f13520a;
            }

            @Override // e6.p
            public final Object invoke(a0 a0Var, v5.c<? super x> cVar) {
                return ((C00081) create(a0Var, cVar)).invokeSuspend(x.f13520a);
            }
        }

        /* JADX INFO: renamed from: androidx.lifecycle.FlowLiveDataConversions$asFlow$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        @x5.e(c = "androidx.lifecycle.FlowLiveDataConversions$asFlow$1$2", f = "FlowLiveData.kt", l = {}, m = "invokeSuspend")
        public static final class AnonymousClass2 extends x5.i implements p {
            final /* synthetic */ Observer<T> $observer;
            final /* synthetic */ LiveData<T> $this_asFlow;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass2(LiveData<T> liveData, Observer<T> observer, v5.c<? super AnonymousClass2> cVar) {
                super(2, cVar);
                this.$this_asFlow = liveData;
                this.$observer = observer;
            }

            @Override // x5.a
            public final v5.c<x> create(Object obj, v5.c<?> cVar) {
                return new AnonymousClass2(this.$this_asFlow, this.$observer, cVar);
            }

            /* JADX WARN: Type inference fix 'apply assigned field type' failed
            java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
            	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
            	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
            	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
             */
            @Override // x5.a
            public final Object invokeSuspend(Object obj) throws Throwable {
                w5.a aVar = w5.a.f17774a;
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                q.z0(obj);
                this.$this_asFlow.removeObserver(this.$observer);
                return x.f13520a;
            }

            @Override // e6.p
            public final Object invoke(a0 a0Var, v5.c<? super x> cVar) {
                return ((AnonymousClass2) create(a0Var, cVar)).invokeSuspend(x.f13520a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(LiveData<T> liveData, v5.c<? super AnonymousClass1> cVar) {
            super(2, cVar);
            this.$this_asFlow = liveData;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invokeSuspend$lambda$0(s6.x xVar, Object obj) {
            ((w) xVar).d(obj);
        }

        @Override // x5.a
        public final v5.c<x> create(Object obj, v5.c<?> cVar) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$this_asFlow, cVar);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        /* JADX WARN: Type inference failed for: r1v0, types: [androidx.lifecycle.Observer, int] */
        @Override // x5.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            Observer observer;
            w5.a aVar = w5.a.f17774a;
            ?? r1 = this.label;
            int i2 = 2;
            try {
            } catch (Throwable th) {
                x6.e eVar = m0.f13566a;
                v5.h hVarPlus = v6.n.f17641a.f13648c.plus(q1.f13579a);
                AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$this_asFlow, r1, null);
                this.L$0 = th;
                this.label = 3;
                if (c0.H(anonymousClass2, hVarPlus, this) != aVar) {
                    throw th;
                }
            }
            if (r1 == 0) {
                q.z0(obj);
                final s6.x xVar = (s6.x) this.L$0;
                observer = new Observer() { // from class: androidx.lifecycle.f
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj2) {
                        FlowLiveDataConversions.AnonymousClass1.invokeSuspend$lambda$0(xVar, obj2);
                    }
                };
                x6.e eVar2 = m0.f13566a;
                r6.c cVar = v6.n.f17641a.f13648c;
                C00081 c00081 = new C00081(this.$this_asFlow, observer, null);
                this.L$0 = observer;
                this.label = 1;
                if (c0.H(c00081, cVar, this) == aVar) {
                    return aVar;
                }
            } else {
                if (r1 != 1) {
                    if (r1 == 2) {
                        q.z0(obj);
                        throw new s(i2);
                    }
                    if (r1 != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    Throwable th2 = (Throwable) this.L$0;
                    q.z0(obj);
                    throw th2;
                }
                observer = (Observer) this.L$0;
                q.z0(obj);
            }
            this.L$0 = observer;
            this.label = 2;
            c0.h(this);
            return aVar;
        }

        @Override // e6.p
        public final Object invoke(s6.x xVar, v5.c<? super x> cVar) {
            return ((AnonymousClass1) create(xVar, cVar)).invokeSuspend(x.f13520a);
        }
    }

    /* JADX INFO: renamed from: androidx.lifecycle.FlowLiveDataConversions$asLiveData$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @x5.e(c = "androidx.lifecycle.FlowLiveDataConversions$asLiveData$1", f = "FlowLiveData.kt", l = {78}, m = "invokeSuspend")
    public static final class C03581 extends x5.i implements p {
        final /* synthetic */ t6.e $this_asLiveData;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C03581(t6.e eVar, v5.c<? super C03581> cVar) {
            super(2, cVar);
            this.$this_asLiveData = eVar;
        }

        @Override // x5.a
        public final v5.c<x> create(Object obj, v5.c<?> cVar) {
            C03581 c03581 = new C03581(this.$this_asLiveData, cVar);
            c03581.L$0 = obj;
            return c03581;
        }

        @Override // e6.p
        public final Object invoke(LiveDataScope<T> liveDataScope, v5.c<? super x> cVar) {
            return ((C03581) create(liveDataScope, cVar)).invokeSuspend(x.f13520a);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            w5.a aVar = w5.a.f17774a;
            int i2 = this.label;
            if (i2 == 0) {
                q.z0(obj);
                final LiveDataScope liveDataScope = (LiveDataScope) this.L$0;
                t6.e eVar = this.$this_asLiveData;
                t6.f fVar = new t6.f() { // from class: androidx.lifecycle.FlowLiveDataConversions.asLiveData.1.1
                    @Override // t6.f
                    public final Object emit(T t3, v5.c<? super x> cVar) {
                        Object objEmit = liveDataScope.emit(t3, cVar);
                        return objEmit == w5.a.f17774a ? objEmit : x.f13520a;
                    }
                };
                this.label = 1;
                if (eVar.collect(fVar, this) == aVar) {
                    return aVar;
                }
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                q.z0(obj);
            }
            return x.f13520a;
        }
    }

    public static final <T> t6.e asFlow(LiveData<T> liveData) {
        kotlin.jvm.internal.k.e(liveData, "<this>");
        return x0.g(x0.h(new AnonymousClass1(liveData, null)), -1);
    }

    public static final <T> LiveData<T> asLiveData(t6.e eVar) {
        kotlin.jvm.internal.k.e(eVar, "<this>");
        return asLiveData$default(eVar, (v5.h) null, 0L, 3, (Object) null);
    }

    public static /* synthetic */ LiveData asLiveData$default(t6.e eVar, v5.h hVar, long j, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            hVar = v5.i.f17610a;
        }
        if ((i2 & 2) != 0) {
            j = 5000;
        }
        return asLiveData(eVar, hVar, j);
    }

    public static final <T> LiveData<T> asLiveData(t6.e eVar, v5.h context) {
        kotlin.jvm.internal.k.e(eVar, "<this>");
        kotlin.jvm.internal.k.e(context, "context");
        return asLiveData$default(eVar, context, 0L, 2, (Object) null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> LiveData<T> asLiveData(t6.e eVar, v5.h context, long j) {
        kotlin.jvm.internal.k.e(eVar, "<this>");
        kotlin.jvm.internal.k.e(context, "context");
        RedirectableLiveData redirectableLiveData = (LiveData<T>) CoroutineLiveDataKt.liveData(context, j, new C03581(eVar, null));
        if (eVar instanceof b1) {
            if (ArchTaskExecutor.getInstance().isMainThread()) {
                redirectableLiveData.setValue(((b1) eVar).getValue());
                return redirectableLiveData;
            }
            redirectableLiveData.postValue(((b1) eVar).getValue());
        }
        return redirectableLiveData;
    }

    public static /* synthetic */ LiveData asLiveData$default(t6.e eVar, Duration duration, v5.h hVar, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            hVar = v5.i.f17610a;
        }
        return asLiveData(eVar, duration, hVar);
    }

    @RequiresApi(26)
    public static final <T> LiveData<T> asLiveData(t6.e eVar, Duration timeout, v5.h context) {
        kotlin.jvm.internal.k.e(eVar, "<this>");
        kotlin.jvm.internal.k.e(timeout, "timeout");
        kotlin.jvm.internal.k.e(context, "context");
        return asLiveData(eVar, context, Api26Impl.INSTANCE.toMillis(timeout));
    }
}
