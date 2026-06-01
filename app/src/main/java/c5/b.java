package c5;

import r2.q;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class b extends s4.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4207a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f4208b;

    public /* synthetic */ b(Object obj, int i2) {
        this.f4207a = i2;
        this.f4208b = obj;
    }

    @Override // s4.a
    public final void e(s4.b bVar) {
        switch (this.f4207a) {
            case 0:
                a aVar = new a(bVar, (s4.c[]) this.f4208b);
                bVar.a(aVar.f4206d);
                aVar.b();
                break;
            case 1:
                b5.b bVar2 = new b5.b(z4.b.f17982b);
                bVar.a(bVar2);
                try {
                    ((x4.a) this.f4208b).run();
                    if (!bVar2.b()) {
                        bVar.onComplete();
                    }
                } catch (Throwable th) {
                    q.y0(th);
                    if (bVar2.b()) {
                        return;
                    }
                    bVar.onError(th);
                    return;
                }
                break;
            default:
                b5.b bVar3 = new b5.b(z4.b.f17982b);
                bVar.a(bVar3);
                try {
                    ((com.google.firebase.inappmessaging.internal.q) this.f4208b).call();
                    if (!bVar3.b()) {
                        bVar.onComplete();
                    }
                } catch (Throwable th2) {
                    q.y0(th2);
                    if (bVar3.b()) {
                        return;
                    }
                    bVar.onError(th2);
                }
                break;
        }
    }
}
