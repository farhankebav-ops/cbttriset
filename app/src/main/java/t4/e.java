package t4;

import android.os.Handler;
import java.util.concurrent.TimeUnit;
import s4.o;
import s4.p;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class e extends p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Handler f17408a;

    public e(Handler handler) {
        this.f17408a = handler;
    }

    @Override // s4.p
    public final o a() {
        return new c(this.f17408a);
    }

    @Override // s4.p
    public final u4.b c(Runnable runnable) {
        TimeUnit timeUnit = TimeUnit.NANOSECONDS;
        if (timeUnit == null) {
            throw new NullPointerException("unit == null");
        }
        Handler handler = this.f17408a;
        d dVar = new d(handler, runnable);
        handler.postDelayed(dVar, timeUnit.toMillis(0L));
        return dVar;
    }
}
