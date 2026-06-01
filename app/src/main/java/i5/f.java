package i5;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class f extends s4.o {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e f12000b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final g f12001c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AtomicBoolean f12002d = new AtomicBoolean();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final u4.a f11999a = new u4.a(0);

    public f(e eVar) {
        g gVar;
        g gVar2;
        this.f12000b = eVar;
        if (eVar.f11996c.f17536b) {
            gVar2 = h.e;
        } else {
            while (true) {
                if (eVar.f11995b.isEmpty()) {
                    gVar = new g(eVar.f11998f);
                    eVar.f11996c.a(gVar);
                    break;
                } else {
                    gVar = (g) eVar.f11995b.poll();
                    if (gVar != null) {
                        break;
                    }
                }
            }
            gVar2 = gVar;
        }
        this.f12001c = gVar2;
    }

    @Override // s4.o
    public final u4.b a(Runnable runnable, TimeUnit timeUnit) {
        return this.f11999a.f17536b ? y4.b.f17849a : this.f12001c.c(runnable, TimeUnit.NANOSECONDS, this.f11999a);
    }

    @Override // u4.b
    public final void dispose() {
        if (this.f12002d.compareAndSet(false, true)) {
            this.f11999a.dispose();
            e eVar = this.f12000b;
            eVar.getClass();
            long jNanoTime = System.nanoTime() + eVar.f11994a;
            g gVar = this.f12001c;
            gVar.f12003c = jNanoTime;
            eVar.f11995b.offer(gVar);
        }
    }
}
