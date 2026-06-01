package q0;

import android.content.Context;
import w0.i;
import w0.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class g implements r0.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f13378a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final p5.a f13379b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final p5.a f13380c;

    public /* synthetic */ g(p5.a aVar, p5.a aVar2, int i2) {
        this.f13378a = i2;
        this.f13379b = aVar;
        this.f13380c = aVar2;
    }

    @Override // p5.a
    public final Object get() {
        switch (this.f13378a) {
            case 0:
                return new f((Context) ((e) this.f13379b).f13374b, (e2.h) ((e) this.f13380c).get());
            default:
                return new i(new r4.c(6), new w1.f(5), w0.a.f17655f, (k) this.f13379b.get(), this.f13380c);
        }
    }
}
