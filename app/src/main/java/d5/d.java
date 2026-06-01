package d5;

import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class d extends b {
    public final s4.g m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final AtomicInteger f11073n;

    public d(s4.g gVar, com.google.firebase.inappmessaging.internal.k kVar, int i2) {
        super(kVar, i2);
        this.m = gVar;
        this.f11073n = new AtomicInteger();
    }

    @Override // d5.f
    public final void a(Throwable th) {
        l5.b bVar = this.j;
        bVar.getClass();
        if (!l5.c.a(bVar, th)) {
            n7.b.F(th);
            return;
        }
        this.e.cancel();
        if (getAndIncrement() == 0) {
            this.m.onError(l5.c.b(bVar));
        }
    }

    @Override // o7.b
    public final void c(long j) {
        this.f11058a.c(j);
    }

    @Override // o7.b
    public final void cancel() {
        if (this.f11063i) {
            return;
        }
        this.f11063i = true;
        this.f11058a.cancel();
        this.e.cancel();
    }

    @Override // d5.f
    public final void d(Object obj) {
        if (get() == 0 && compareAndSet(0, 1)) {
            s4.g gVar = this.m;
            gVar.b(obj);
            if (compareAndSet(1, 0)) {
                return;
            }
            l5.b bVar = this.j;
            bVar.getClass();
            gVar.onError(l5.c.b(bVar));
        }
    }

    @Override // d5.b
    public final void g() {
        if (this.f11073n.getAndIncrement() == 0) {
            while (!this.f11063i) {
                if (!this.k) {
                    boolean z2 = this.h;
                    try {
                        Object objPoll = this.g.poll();
                        boolean z7 = objPoll == null;
                        if (z2 && z7) {
                            this.m.onComplete();
                            return;
                        }
                        if (!z7) {
                            try {
                                Object objApply = this.f11059b.apply(objPoll);
                                z4.b.a(objApply, "The mapper returned a null Publisher");
                                o7.a aVar = (o7.a) objApply;
                                if (this.l != 1) {
                                    int i2 = this.f11062f + 1;
                                    if (i2 == this.f11061d) {
                                        this.f11062f = 0;
                                        this.e.c(i2);
                                    } else {
                                        this.f11062f = i2;
                                    }
                                }
                                if (aVar instanceof Callable) {
                                    try {
                                        Object objCall = ((Callable) aVar).call();
                                        if (objCall == null) {
                                            continue;
                                        } else if (!this.f11058a.g) {
                                            this.k = true;
                                            e eVar = this.f11058a;
                                            eVar.h(new g(objCall, eVar));
                                        } else if (get() == 0 && compareAndSet(0, 1)) {
                                            this.m.b(objCall);
                                            if (!compareAndSet(1, 0)) {
                                                s4.g gVar = this.m;
                                                l5.b bVar = this.j;
                                                bVar.getClass();
                                                gVar.onError(l5.c.b(bVar));
                                                return;
                                            }
                                        }
                                    } catch (Throwable th) {
                                        r2.q.y0(th);
                                        this.e.cancel();
                                        l5.b bVar2 = this.j;
                                        bVar2.getClass();
                                        l5.c.a(bVar2, th);
                                        s4.g gVar2 = this.m;
                                        l5.b bVar3 = this.j;
                                        bVar3.getClass();
                                        gVar2.onError(l5.c.b(bVar3));
                                        return;
                                    }
                                } else {
                                    this.k = true;
                                    aVar.a(this.f11058a);
                                }
                            } catch (Throwable th2) {
                                r2.q.y0(th2);
                                this.e.cancel();
                                l5.b bVar4 = this.j;
                                bVar4.getClass();
                                l5.c.a(bVar4, th2);
                                s4.g gVar3 = this.m;
                                l5.b bVar5 = this.j;
                                bVar5.getClass();
                                gVar3.onError(l5.c.b(bVar5));
                                return;
                            }
                        }
                    } catch (Throwable th3) {
                        r2.q.y0(th3);
                        this.e.cancel();
                        l5.b bVar6 = this.j;
                        bVar6.getClass();
                        l5.c.a(bVar6, th3);
                        s4.g gVar4 = this.m;
                        l5.b bVar7 = this.j;
                        bVar7.getClass();
                        gVar4.onError(l5.c.b(bVar7));
                        return;
                    }
                }
                if (this.f11073n.decrementAndGet() == 0) {
                    return;
                }
            }
        }
    }

    @Override // d5.b
    public final void h() {
        this.m.f(this);
    }

    @Override // s4.g
    public final void onError(Throwable th) {
        l5.b bVar = this.j;
        bVar.getClass();
        if (!l5.c.a(bVar, th)) {
            n7.b.F(th);
            return;
        }
        this.f11058a.cancel();
        if (getAndIncrement() == 0) {
            bVar.getClass();
            this.m.onError(l5.c.b(bVar));
        }
    }
}
