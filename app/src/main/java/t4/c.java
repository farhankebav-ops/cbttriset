package t4;

import android.os.Handler;
import android.os.Message;
import java.util.concurrent.TimeUnit;
import s4.o;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class c extends o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Handler f17404a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile boolean f17405b;

    public c(Handler handler) {
        this.f17404a = handler;
    }

    @Override // s4.o
    public final u4.b a(Runnable runnable, TimeUnit timeUnit) {
        TimeUnit timeUnit2 = TimeUnit.NANOSECONDS;
        y4.b bVar = y4.b.f17849a;
        if (timeUnit2 == null) {
            throw new NullPointerException("unit == null");
        }
        if (this.f17405b) {
            return bVar;
        }
        Handler handler = this.f17404a;
        d dVar = new d(handler, runnable);
        Message messageObtain = Message.obtain(handler, dVar);
        messageObtain.obj = this;
        this.f17404a.sendMessageDelayed(messageObtain, timeUnit2.toMillis(0L));
        if (!this.f17405b) {
            return dVar;
        }
        this.f17404a.removeCallbacks(dVar);
        return bVar;
    }

    @Override // u4.b
    public final void dispose() {
        this.f17405b = true;
        this.f17404a.removeCallbacksAndMessages(this);
    }
}
