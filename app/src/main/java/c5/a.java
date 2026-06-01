package c5;

import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class a extends AtomicInteger implements s4.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final s4.b f4203a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final s4.c[] f4204b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f4205c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final b5.b f4206d = new b5.b(2);

    public a(s4.b bVar, s4.c[] cVarArr) {
        this.f4203a = bVar;
        this.f4204b = cVarArr;
    }

    @Override // s4.b, s4.j, s4.r
    public final void a(u4.b bVar) {
        b5.b bVar2 = this.f4206d;
        bVar2.getClass();
        y4.a.c(bVar2, bVar);
    }

    public final void b() {
        b5.b bVar = this.f4206d;
        if (!bVar.b() && getAndIncrement() == 0) {
            while (!bVar.b()) {
                int i2 = this.f4205c;
                this.f4205c = i2 + 1;
                s4.c[] cVarArr = this.f4204b;
                if (i2 == cVarArr.length) {
                    this.f4203a.onComplete();
                    return;
                } else {
                    ((s4.a) cVarArr[i2]).d(this);
                    if (decrementAndGet() == 0) {
                        return;
                    }
                }
            }
        }
    }

    @Override // s4.b, s4.j
    public final void onComplete() {
        b();
    }

    @Override // s4.b, s4.j, s4.r
    public final void onError(Throwable th) {
        this.f4203a.onError(th);
    }
}
