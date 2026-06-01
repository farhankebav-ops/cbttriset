package i5;

import d5.i0;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class a extends s4.o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final u4.a f11983a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final u4.a f11984b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final u4.a f11985c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c f11986d;
    public volatile boolean e;

    public a(c cVar) {
        this.f11986d = cVar;
        u4.a aVar = new u4.a(1);
        this.f11983a = aVar;
        u4.a aVar2 = new u4.a(0);
        this.f11984b = aVar2;
        u4.a aVar3 = new u4.a(1);
        this.f11985c = aVar3;
        aVar3.a(aVar);
        aVar3.a(aVar2);
    }

    @Override // s4.o
    public final u4.b a(Runnable runnable, TimeUnit timeUnit) {
        return this.e ? y4.b.f17849a : this.f11986d.c(runnable, TimeUnit.NANOSECONDS, this.f11984b);
    }

    @Override // s4.o
    public final void b(i0 i0Var) {
        if (this.e) {
            return;
        }
        this.f11986d.c(i0Var, TimeUnit.MILLISECONDS, this.f11983a);
    }

    @Override // u4.b
    public final void dispose() {
        if (this.e) {
            return;
        }
        this.e = true;
        this.f11985c.dispose();
    }
}
