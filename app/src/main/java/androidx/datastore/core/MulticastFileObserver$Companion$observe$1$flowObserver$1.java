package androidx.datastore.core;

import java.io.File;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.l;
import n7.b;
import s6.x;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class MulticastFileObserver$Companion$observe$1$flowObserver$1 extends l implements e6.l {
    final /* synthetic */ x $$this$channelFlow;
    final /* synthetic */ File $file;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MulticastFileObserver$Companion$observe$1$flowObserver$1(File file, x xVar) {
        super(1);
        this.$file = file;
        this.$$this$channelFlow = xVar;
    }

    @Override // e6.l
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((String) obj);
        return q5.x.f13520a;
    }

    public final void invoke(String str) {
        if (k.a(str, this.$file.getName())) {
            b.U(this.$$this$channelFlow, q5.x.f13520a);
        }
    }
}
