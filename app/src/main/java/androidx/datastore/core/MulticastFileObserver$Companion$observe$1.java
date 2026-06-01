package androidx.datastore.core;

import androidx.datastore.core.MulticastFileObserver;
import e6.p;
import java.io.File;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.l;
import q5.x;
import q6.o0;
import r2.q;
import s6.w;
import v5.c;
import x5.e;
import x5.i;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
@e(c = "androidx.datastore.core.MulticastFileObserver$Companion$observe$1", f = "MulticastFileObserver.android.kt", l = {84, 85}, m = "invokeSuspend")
public final class MulticastFileObserver$Companion$observe$1 extends i implements p {
    final /* synthetic */ File $file;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX INFO: renamed from: androidx.datastore.core.MulticastFileObserver$Companion$observe$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class AnonymousClass1 extends l implements e6.a {
        final /* synthetic */ o0 $disposeListener;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(o0 o0Var) {
            super(0);
            this.$disposeListener = o0Var;
        }

        @Override // e6.a
        public /* bridge */ /* synthetic */ Object invoke() {
            m41invoke();
            return x.f13520a;
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final void m41invoke() {
            this.$disposeListener.dispose();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MulticastFileObserver$Companion$observe$1(File file, c<? super MulticastFileObserver$Companion$observe$1> cVar) {
        super(2, cVar);
        this.$file = file;
    }

    @Override // x5.a
    public final c<x> create(Object obj, c<?> cVar) {
        MulticastFileObserver$Companion$observe$1 multicastFileObserver$Companion$observe$1 = new MulticastFileObserver$Companion$observe$1(this.$file, cVar);
        multicastFileObserver$Companion$observe$1.L$0 = obj;
        return multicastFileObserver$Companion$observe$1;
    }

    @Override // x5.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        o0 o0VarObserve;
        s6.x xVar;
        w5.a aVar = w5.a.f17774a;
        int i2 = this.label;
        x xVar2 = x.f13520a;
        if (i2 == 0) {
            q.z0(obj);
            s6.x xVar3 = (s6.x) this.L$0;
            MulticastFileObserver$Companion$observe$1$flowObserver$1 multicastFileObserver$Companion$observe$1$flowObserver$1 = new MulticastFileObserver$Companion$observe$1$flowObserver$1(this.$file, xVar3);
            MulticastFileObserver.Companion companion = MulticastFileObserver.Companion;
            File parentFile = this.$file.getParentFile();
            k.b(parentFile);
            o0VarObserve = companion.observe(parentFile, multicastFileObserver$Companion$observe$1$flowObserver$1);
            this.L$0 = xVar3;
            this.L$1 = o0VarObserve;
            this.label = 1;
            if (((w) xVar3).f13759d.c(xVar2, this) != aVar) {
                xVar = xVar3;
            }
        }
        if (i2 != 1) {
            if (i2 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            q.z0(obj);
            return xVar2;
        }
        o0VarObserve = (o0) this.L$1;
        xVar = (s6.x) this.L$0;
        q.z0(obj);
        AnonymousClass1 anonymousClass1 = new AnonymousClass1(o0VarObserve);
        this.L$0 = null;
        this.L$1 = null;
        this.label = 2;
        return q.m(xVar, anonymousClass1, this) == aVar ? aVar : xVar2;
    }

    @Override // e6.p
    public final Object invoke(s6.x xVar, c<? super x> cVar) {
        return ((MulticastFileObserver$Companion$observe$1) create(xVar, cVar)).invokeSuspend(x.f13520a);
    }
}
