package d5;

import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class b extends AtomicInteger implements s4.g, f, o7.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final x4.c f11059b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f11060c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f11061d;
    public o7.b e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f11062f;
    public a5.h g;
    public volatile boolean h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public volatile boolean f11063i;
    public volatile boolean k;
    public int l;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f11058a = new e(this);
    public final l5.b j = new l5.b();

    public b(x4.c cVar, int i2) {
        this.f11059b = cVar;
        this.f11060c = i2;
        this.f11061d = i2;
    }

    @Override // s4.g
    public final void b(Object obj) {
        if (this.l == 2 || this.g.offer(obj)) {
            g();
        } else {
            this.e.cancel();
            onError(new IllegalStateException("Queue full?!"));
        }
    }

    @Override // s4.g
    public final void f(o7.b bVar) {
        if (k5.f.e(this.e, bVar)) {
            this.e = bVar;
            if (bVar instanceof a5.e) {
                a5.e eVar = (a5.e) bVar;
                int iD = eVar.d(3);
                if (iD == 1) {
                    this.l = iD;
                    this.g = eVar;
                    this.h = true;
                    h();
                    g();
                    return;
                }
                if (iD == 2) {
                    this.l = iD;
                    this.g = eVar;
                    h();
                    bVar.c(this.f11060c);
                    return;
                }
            }
            this.g = new h5.a(this.f11060c);
            h();
            bVar.c(this.f11060c);
        }
    }

    public abstract void g();

    public abstract void h();

    @Override // s4.g
    public final void onComplete() {
        this.h = true;
        g();
    }
}
