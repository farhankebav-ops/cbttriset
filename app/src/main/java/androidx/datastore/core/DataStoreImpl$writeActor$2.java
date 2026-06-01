package androidx.datastore.core;

import androidx.datastore.core.Message;
import e6.p;
import java.util.concurrent.CancellationException;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.l;
import q5.x;
import q6.q;
import q6.r;
import q6.u;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class DataStoreImpl$writeActor$2 extends l implements p {
    public static final DataStoreImpl$writeActor$2 INSTANCE = new DataStoreImpl$writeActor$2();

    public DataStoreImpl$writeActor$2() {
        super(2);
    }

    @Override // e6.p
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Message.Update) obj, (Throwable) obj2);
        return x.f13520a;
    }

    public final void invoke(Message.Update<T> msg, Throwable th) {
        k.e(msg, "msg");
        q ack = msg.getAck();
        if (th == null) {
            th = new CancellationException("DataStore scope was cancelled before updateData could complete");
        }
        r rVar = (r) ack;
        rVar.getClass();
        rVar.N(new u(false, th));
    }
}
