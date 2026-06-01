package androidx.lifecycle;

import q6.c0;
import q6.e1;
import q6.m0;
import q6.v1;
import t6.x0;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class LifecycleKt {
    public static final LifecycleCoroutineScope getCoroutineScope(Lifecycle lifecycle) {
        LifecycleCoroutineScopeImpl lifecycleCoroutineScopeImpl;
        kotlin.jvm.internal.k.e(lifecycle, "<this>");
        do {
            LifecycleCoroutineScopeImpl lifecycleCoroutineScopeImpl2 = (LifecycleCoroutineScopeImpl) lifecycle.getInternalScopeRef().get();
            if (lifecycleCoroutineScopeImpl2 != null) {
                return lifecycleCoroutineScopeImpl2;
            }
            v1 v1VarE = c0.e();
            x6.e eVar = m0.f13566a;
            lifecycleCoroutineScopeImpl = new LifecycleCoroutineScopeImpl(lifecycle, a.a.O(v1VarE, v6.n.f17641a.f13648c));
        } while (!lifecycle.getInternalScopeRef().compareAndSet(null, lifecycleCoroutineScopeImpl));
        lifecycleCoroutineScopeImpl.register();
        return lifecycleCoroutineScopeImpl;
    }

    public static final t6.e getEventFlow(Lifecycle lifecycle) {
        kotlin.jvm.internal.k.e(lifecycle, "<this>");
        t6.c cVarH = x0.h(new LifecycleKt$eventFlow$1(lifecycle, null));
        x6.e eVar = m0.f13566a;
        r6.c cVar = v6.n.f17641a.f13648c;
        if (cVar.get(e1.f13546a) == null) {
            return cVar.equals(v5.i.f17610a) ? cVarH : u6.c.a(cVarH, cVar, 0, null, 6);
        }
        throw new IllegalArgumentException(("Flow context cannot contain job in it. Had " + cVar).toString());
    }
}
