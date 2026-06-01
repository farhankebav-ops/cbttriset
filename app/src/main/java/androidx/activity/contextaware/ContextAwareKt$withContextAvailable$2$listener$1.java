package androidx.activity.contextaware;

import android.content.Context;
import e6.l;
import kotlin.jvm.internal.k;
import q6.j;
import r2.q;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class ContextAwareKt$withContextAvailable$2$listener$1 implements OnContextAvailableListener {
    final /* synthetic */ j $co;
    final /* synthetic */ l $onContextAvailable;

    public ContextAwareKt$withContextAvailable$2$listener$1(j jVar, l lVar) {
        this.$co = jVar;
        this.$onContextAvailable = lVar;
    }

    @Override // androidx.activity.contextaware.OnContextAvailableListener
    public void onContextAvailable(Context context) {
        Object objM;
        k.e(context, "context");
        j jVar = this.$co;
        try {
            objM = this.$onContextAvailable.invoke(context);
        } catch (Throwable th) {
            objM = q.M(th);
        }
        jVar.resumeWith(objM);
    }
}
