package androidx.lifecycle;

import e6.p;
import q5.x;
import q6.a0;
import q6.c0;
import q6.m0;
import q6.o0;
import r2.q;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class LiveDataScopeImpl<T> implements LiveDataScope<T> {
    private final v5.h coroutineContext;
    private CoroutineLiveData<T> target;

    /* JADX INFO: renamed from: androidx.lifecycle.LiveDataScopeImpl$emit$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @x5.e(c = "androidx.lifecycle.LiveDataScopeImpl$emit$2", f = "CoroutineLiveData.kt", l = {98}, m = "invokeSuspend")
    public static final class AnonymousClass2 extends x5.i implements p {
        final /* synthetic */ T $value;
        int label;
        final /* synthetic */ LiveDataScopeImpl<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(LiveDataScopeImpl<T> liveDataScopeImpl, T t3, v5.c<? super AnonymousClass2> cVar) {
            super(2, cVar);
            this.this$0 = liveDataScopeImpl;
            this.$value = t3;
        }

        @Override // x5.a
        public final v5.c<x> create(Object obj, v5.c<?> cVar) {
            return new AnonymousClass2(this.this$0, this.$value, cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            w5.a aVar = w5.a.f17774a;
            int i2 = this.label;
            if (i2 == 0) {
                q.z0(obj);
                CoroutineLiveData<T> target$lifecycle_livedata_release = this.this$0.getTarget$lifecycle_livedata_release();
                this.label = 1;
                if (target$lifecycle_livedata_release.clearSource$lifecycle_livedata_release(this) == aVar) {
                    return aVar;
                }
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                q.z0(obj);
            }
            this.this$0.getTarget$lifecycle_livedata_release().setValue(this.$value);
            return x.f13520a;
        }

        @Override // e6.p
        public final Object invoke(a0 a0Var, v5.c<? super x> cVar) {
            return ((AnonymousClass2) create(a0Var, cVar)).invokeSuspend(x.f13520a);
        }
    }

    /* JADX INFO: renamed from: androidx.lifecycle.LiveDataScopeImpl$emitSource$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @x5.e(c = "androidx.lifecycle.LiveDataScopeImpl$emitSource$2", f = "CoroutineLiveData.kt", l = {92}, m = "invokeSuspend")
    public static final class C03612 extends x5.i implements p {
        final /* synthetic */ LiveData<T> $source;
        int label;
        final /* synthetic */ LiveDataScopeImpl<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C03612(LiveDataScopeImpl<T> liveDataScopeImpl, LiveData<T> liveData, v5.c<? super C03612> cVar) {
            super(2, cVar);
            this.this$0 = liveDataScopeImpl;
            this.$source = liveData;
        }

        @Override // x5.a
        public final v5.c<x> create(Object obj, v5.c<?> cVar) {
            return new C03612(this.this$0, this.$source, cVar);
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
            CoroutineLiveData<T> target$lifecycle_livedata_release = this.this$0.getTarget$lifecycle_livedata_release();
            LiveData<T> liveData = this.$source;
            this.label = 1;
            Object objEmitSource$lifecycle_livedata_release = target$lifecycle_livedata_release.emitSource$lifecycle_livedata_release(liveData, this);
            return objEmitSource$lifecycle_livedata_release == aVar ? aVar : objEmitSource$lifecycle_livedata_release;
        }

        @Override // e6.p
        public final Object invoke(a0 a0Var, v5.c<? super o0> cVar) {
            return ((C03612) create(a0Var, cVar)).invokeSuspend(x.f13520a);
        }
    }

    public LiveDataScopeImpl(CoroutineLiveData<T> target, v5.h context) {
        kotlin.jvm.internal.k.e(target, "target");
        kotlin.jvm.internal.k.e(context, "context");
        this.target = target;
        x6.e eVar = m0.f13566a;
        this.coroutineContext = context.plus(v6.n.f17641a.f13648c);
    }

    @Override // androidx.lifecycle.LiveDataScope
    public Object emit(T t3, v5.c<? super x> cVar) throws Throwable {
        Object objH = c0.H(new AnonymousClass2(this, t3, null), this.coroutineContext, cVar);
        return objH == w5.a.f17774a ? objH : x.f13520a;
    }

    @Override // androidx.lifecycle.LiveDataScope
    public Object emitSource(LiveData<T> liveData, v5.c<? super o0> cVar) {
        return c0.H(new C03612(this, liveData, null), this.coroutineContext, cVar);
    }

    @Override // androidx.lifecycle.LiveDataScope
    public T getLatestValue() {
        return this.target.getValue();
    }

    public final CoroutineLiveData<T> getTarget$lifecycle_livedata_release() {
        return this.target;
    }

    public final void setTarget$lifecycle_livedata_release(CoroutineLiveData<T> coroutineLiveData) {
        kotlin.jvm.internal.k.e(coroutineLiveData, "<set-?>");
        this.target = coroutineLiveData;
    }
}
