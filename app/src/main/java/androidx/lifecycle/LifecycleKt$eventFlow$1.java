package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import e6.p;
import r2.q;
import s6.w;
import s6.x;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
@x5.e(c = "androidx.lifecycle.LifecycleKt$eventFlow$1", f = "Lifecycle.kt", l = {373}, m = "invokeSuspend")
public final class LifecycleKt$eventFlow$1 extends x5.i implements p {
    final /* synthetic */ Lifecycle $this_eventFlow;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LifecycleKt$eventFlow$1(Lifecycle lifecycle, v5.c<? super LifecycleKt$eventFlow$1> cVar) {
        super(2, cVar);
        this.$this_eventFlow = lifecycle;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invokeSuspend$lambda$0(x xVar, LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        w wVar = (w) xVar;
        wVar.d(event);
        if (event == Lifecycle.Event.ON_DESTROY) {
            wVar.o(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final q5.x invokeSuspend$lambda$1(Lifecycle lifecycle, LifecycleEventObserver lifecycleEventObserver) {
        lifecycle.removeObserver(lifecycleEventObserver);
        return q5.x.f13520a;
    }

    @Override // x5.a
    public final v5.c<q5.x> create(Object obj, v5.c<?> cVar) {
        LifecycleKt$eventFlow$1 lifecycleKt$eventFlow$1 = new LifecycleKt$eventFlow$1(this.$this_eventFlow, cVar);
        lifecycleKt$eventFlow$1.L$0 = obj;
        return lifecycleKt$eventFlow$1;
    }

    @Override // x5.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        w5.a aVar = w5.a.f17774a;
        int i2 = this.label;
        if (i2 == 0) {
            q.z0(obj);
            x xVar = (x) this.L$0;
            final i iVar = new i(xVar, 0);
            this.$this_eventFlow.addObserver(iVar);
            final Lifecycle lifecycle = this.$this_eventFlow;
            e6.a aVar2 = new e6.a() { // from class: androidx.lifecycle.j
                @Override // e6.a
                public final Object invoke() {
                    return LifecycleKt$eventFlow$1.invokeSuspend$lambda$1(lifecycle, iVar);
                }
            };
            this.label = 1;
            if (q.m(xVar, aVar2, this) == aVar) {
                return aVar;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            q.z0(obj);
        }
        return q5.x.f13520a;
    }

    @Override // e6.p
    public final Object invoke(x xVar, v5.c<? super q5.x> cVar) {
        return ((LifecycleKt$eventFlow$1) create(xVar, cVar)).invokeSuspend(q5.x.f13520a);
    }
}
