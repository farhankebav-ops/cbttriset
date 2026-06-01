package androidx.lifecycle;

import androidx.annotation.RequiresApi;
import e6.p;
import java.time.Duration;
import q5.x;
import q6.a0;
import q6.c0;
import q6.m0;
import r2.q;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class CoroutineLiveDataKt {
    public static final long DEFAULT_TIMEOUT = 5000;

    /* JADX INFO: renamed from: androidx.lifecycle.CoroutineLiveDataKt$addDisposableSource$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @x5.e(c = "androidx.lifecycle.CoroutineLiveDataKt$addDisposableSource$2", f = "CoroutineLiveData.kt", l = {}, m = "invokeSuspend")
    public static final class AnonymousClass2 extends x5.i implements p {
        final /* synthetic */ LiveData<T> $source;
        final /* synthetic */ MediatorLiveData<T> $this_addDisposableSource;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(MediatorLiveData<T> mediatorLiveData, LiveData<T> liveData, v5.c<? super AnonymousClass2> cVar) {
            super(2, cVar);
            this.$this_addDisposableSource = mediatorLiveData;
            this.$source = liveData;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final x invokeSuspend$lambda$0(MediatorLiveData mediatorLiveData, Object obj) {
            mediatorLiveData.setValue(obj);
            return x.f13520a;
        }

        @Override // x5.a
        public final v5.c<x> create(Object obj, v5.c<?> cVar) {
            return new AnonymousClass2(this.$this_addDisposableSource, this.$source, cVar);
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
            MediatorLiveData<T> mediatorLiveData = this.$this_addDisposableSource;
            mediatorLiveData.addSource(this.$source, new CoroutineLiveDataKt$sam$androidx_lifecycle_Observer$0(new c(mediatorLiveData, 0)));
            return new EmittedSource(this.$source, this.$this_addDisposableSource);
        }

        @Override // e6.p
        public final Object invoke(a0 a0Var, v5.c<? super EmittedSource> cVar) {
            return ((AnonymousClass2) create(a0Var, cVar)).invokeSuspend(x.f13520a);
        }
    }

    public static final <T> Object addDisposableSource(MediatorLiveData<T> mediatorLiveData, LiveData<T> liveData, v5.c<? super EmittedSource> cVar) {
        x6.e eVar = m0.f13566a;
        return c0.H(new AnonymousClass2(mediatorLiveData, liveData, null), v6.n.f17641a.f13648c, cVar);
    }

    public static final <T> LiveData<T> liveData(p block) {
        kotlin.jvm.internal.k.e(block, "block");
        return liveData$default((v5.h) null, 0L, block, 3, (Object) null);
    }

    public static /* synthetic */ LiveData liveData$default(v5.h hVar, long j, p pVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            hVar = v5.i.f17610a;
        }
        if ((i2 & 2) != 0) {
            j = 5000;
        }
        return liveData(hVar, j, pVar);
    }

    @RequiresApi(26)
    public static final <T> LiveData<T> liveData(Duration timeout, p block) {
        kotlin.jvm.internal.k.e(timeout, "timeout");
        kotlin.jvm.internal.k.e(block, "block");
        return liveData$default(timeout, (v5.h) null, block, 2, (Object) null);
    }

    public static final <T> LiveData<T> liveData(v5.h context, p block) {
        kotlin.jvm.internal.k.e(context, "context");
        kotlin.jvm.internal.k.e(block, "block");
        return liveData$default(context, 0L, block, 2, (Object) null);
    }

    public static /* synthetic */ LiveData liveData$default(Duration duration, v5.h hVar, p pVar, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            hVar = v5.i.f17610a;
        }
        return liveData(duration, hVar, pVar);
    }

    public static final <T> LiveData<T> liveData(v5.h context, long j, p block) {
        kotlin.jvm.internal.k.e(context, "context");
        kotlin.jvm.internal.k.e(block, "block");
        return new CoroutineLiveData(context, j, block);
    }

    @RequiresApi(26)
    public static final <T> LiveData<T> liveData(Duration timeout, v5.h context, p block) {
        kotlin.jvm.internal.k.e(timeout, "timeout");
        kotlin.jvm.internal.k.e(context, "context");
        kotlin.jvm.internal.k.e(block, "block");
        return new CoroutineLiveData(context, Api26Impl.INSTANCE.toMillis(timeout), block);
    }
}
