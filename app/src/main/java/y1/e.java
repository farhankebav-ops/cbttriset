package y1;

import android.os.Handler;
import android.os.Message;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class e implements Handler.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ w3.a f17835a;

    public e(w3.a aVar) {
        this.f17835a = aVar;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        if (message.what != 0) {
            return false;
        }
        w3.a aVar = this.f17835a;
        if (message.obj != null) {
            throw new ClassCastException();
        }
        synchronized (aVar.f17773b) {
            throw null;
        }
    }
}
