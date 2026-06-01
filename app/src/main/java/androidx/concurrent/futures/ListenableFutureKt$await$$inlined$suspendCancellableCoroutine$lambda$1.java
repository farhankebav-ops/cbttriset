package androidx.concurrent.futures;

import j2.q;
import kotlin.jvm.internal.l;
import q5.x;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class ListenableFutureKt$await$$inlined$suspendCancellableCoroutine$lambda$1 extends l implements e6.l {
    final /* synthetic */ q $this_await$inlined;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ListenableFutureKt$await$$inlined$suspendCancellableCoroutine$lambda$1(q qVar) {
        super(1);
        this.$this_await$inlined = qVar;
    }

    @Override // e6.l
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Throwable) obj);
        return x.f13520a;
    }

    public final void invoke(Throwable th) {
        this.$this_await$inlined.cancel(false);
    }
}
