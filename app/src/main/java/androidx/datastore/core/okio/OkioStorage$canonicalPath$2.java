package androidx.datastore.core.okio;

import e6.a;
import kotlin.jvm.internal.l;
import l7.g0;
import m7.f;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class OkioStorage$canonicalPath$2 extends l implements a {
    final /* synthetic */ OkioStorage<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OkioStorage$canonicalPath$2(OkioStorage<T> okioStorage) {
        super(0);
        this.this$0 = okioStorage;
    }

    @Override // e6.a
    public final g0 invoke() {
        g0 g0Var = (g0) ((OkioStorage) this.this$0).producePath.invoke();
        g0Var.getClass();
        boolean z2 = f.a(g0Var) != -1;
        OkioStorage<T> okioStorage = this.this$0;
        if (z2) {
            return w1.f.d(g0Var.f12851a.t(), true);
        }
        throw new IllegalStateException(("OkioStorage requires absolute paths, but did not get an absolute path from producePath = " + ((OkioStorage) okioStorage).producePath + ", instead got " + g0Var).toString());
    }
}
