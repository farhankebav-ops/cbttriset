package androidx.core.view;

import android.view.View;
import android.view.ViewGroup;
import java.util.Iterator;
import q5.x;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
@x5.e(c = "androidx.core.view.ViewKt$allViews$1", f = "View.kt", l = {409, 411}, m = "invokeSuspend")
public final class ViewKt$allViews$1 extends x5.h implements e6.p {
    final /* synthetic */ View $this_allViews;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ViewKt$allViews$1(View view, v5.c<? super ViewKt$allViews$1> cVar) {
        super(2, cVar);
        this.$this_allViews = view;
    }

    @Override // x5.a
    public final v5.c<x> create(Object obj, v5.c<?> cVar) {
        ViewKt$allViews$1 viewKt$allViews$1 = new ViewKt$allViews$1(this.$this_allViews, cVar);
        viewKt$allViews$1.L$0 = obj;
        return viewKt$allViews$1;
    }

    @Override // x5.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object obj2;
        w5.a aVar = w5.a.f17774a;
        int i2 = this.label;
        if (i2 == 0) {
            r2.q.z0(obj);
            m6.j jVar = (m6.j) this.L$0;
            View view = this.$this_allViews;
            this.L$0 = jVar;
            this.label = 1;
            jVar.a(view, this);
            return aVar;
        }
        x xVar = x.f13520a;
        if (i2 != 1) {
            if (i2 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            r2.q.z0(obj);
            return xVar;
        }
        m6.j jVar2 = (m6.j) this.L$0;
        r2.q.z0(obj);
        View view2 = this.$this_allViews;
        if (view2 instanceof ViewGroup) {
            m6.h descendants = ViewGroupKt.getDescendants((ViewGroup) view2);
            this.L$0 = null;
            this.label = 2;
            jVar2.getClass();
            Iterator it = descendants.iterator();
            m6.i iVar = (m6.i) jVar2;
            if (it.hasNext()) {
                iVar.f12987c = it;
                iVar.f12985a = 2;
                iVar.f12988d = this;
                obj2 = aVar;
            } else {
                obj2 = xVar;
            }
            if (obj2 != aVar) {
                obj2 = xVar;
            }
            if (obj2 == aVar) {
                return aVar;
            }
        }
        return xVar;
    }

    @Override // e6.p
    public final Object invoke(m6.j jVar, v5.c<? super x> cVar) {
        return ((ViewKt$allViews$1) create(jVar, cVar)).invokeSuspend(x.f13520a);
    }
}
