package d5;

import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class c extends b {
    public final s4.g m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final boolean f11066n;

    public c(s4.g gVar, com.google.firebase.inappmessaging.internal.k kVar, int i2, boolean z2) {
        super(kVar, i2);
        this.m = gVar;
        this.f11066n = z2;
    }

    @Override // d5.f
    public final void a(Throwable th) {
        l5.b bVar = this.j;
        bVar.getClass();
        if (!l5.c.a(bVar, th)) {
            n7.b.F(th);
            return;
        }
        if (!this.f11066n) {
            this.e.cancel();
            this.h = true;
        }
        this.k = false;
        g();
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
        this.m.b(obj);
    }

    @Override // d5.b
    public final void g() {
        if (getAndIncrement() == 0) {
            while (!this.f11063i) {
                if (!this.k) {
                    boolean z2 = this.h;
                    if (z2 && !this.f11066n && ((Throwable) this.j.get()) != null) {
                        s4.g gVar = this.m;
                        l5.b bVar = this.j;
                        bVar.getClass();
                        gVar.onError(l5.c.b(bVar));
                        return;
                    }
                    try {
                        Object objPoll = this.g.poll();
                        boolean z7 = objPoll == null;
                        if (z2 && z7) {
                            l5.b bVar2 = this.j;
                            bVar2.getClass();
                            Throwable thB = l5.c.b(bVar2);
                            if (thB != null) {
                                this.m.onError(thB);
                                return;
                            } else {
                                this.m.onComplete();
                                return;
                            }
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
                                        } else if (this.f11058a.g) {
                                            this.m.b(objCall);
                                        } else {
                                            this.k = true;
                                            e eVar = this.f11058a;
                                            eVar.h(new g(objCall, eVar));
                                        }
                                    } catch (Throwable th) {
                                        r2.q.y0(th);
                                        this.e.cancel();
                                        l5.b bVar3 = this.j;
                                        bVar3.getClass();
                                        l5.c.a(bVar3, th);
                                        s4.g gVar2 = this.m;
                                        l5.b bVar4 = this.j;
                                        bVar4.getClass();
                                        gVar2.onError(l5.c.b(bVar4));
                                        return;
                                    }
                                } else {
                                    this.k = true;
                                    aVar.a(this.f11058a);
                                }
                            } catch (Throwable th2) {
                                r2.q.y0(th2);
                                this.e.cancel();
                                l5.b bVar5 = this.j;
                                bVar5.getClass();
                                l5.c.a(bVar5, th2);
                                s4.g gVar3 = this.m;
                                l5.b bVar6 = this.j;
                                bVar6.getClass();
                                gVar3.onError(l5.c.b(bVar6));
                                return;
                            }
                        }
                    } catch (Throwable th3) {
                        r2.q.y0(th3);
                        this.e.cancel();
                        l5.b bVar7 = this.j;
                        bVar7.getClass();
                        l5.c.a(bVar7, th3);
                        s4.g gVar4 = this.m;
                        l5.b bVar8 = this.j;
                        bVar8.getClass();
                        gVar4.onError(l5.c.b(bVar8));
                        return;
                    }
                }
                if (decrementAndGet() == 0) {
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
        } else {
            this.h = true;
            g();
        }
    }
}
