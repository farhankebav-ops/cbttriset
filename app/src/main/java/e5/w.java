package e5;

import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class w extends AtomicInteger implements u4.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final s4.j f11302a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final w1.f f11303b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final x[] f11304c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Object[] f11305d;

    public w(s4.j jVar, int i2, w1.f fVar) {
        super(i2);
        this.f11302a = jVar;
        this.f11303b = fVar;
        x[] xVarArr = new x[i2];
        for (int i8 = 0; i8 < i2; i8++) {
            xVarArr[i8] = new x(this, i8);
        }
        this.f11304c = xVarArr;
        this.f11305d = new Object[i2];
    }

    public final void a(int i2) {
        x[] xVarArr = this.f11304c;
        int length = xVarArr.length;
        for (int i8 = 0; i8 < i2; i8++) {
            x xVar = xVarArr[i8];
            xVar.getClass();
            y4.a.a(xVar);
        }
        while (true) {
            i2++;
            if (i2 >= length) {
                return;
            }
            x xVar2 = xVarArr[i2];
            xVar2.getClass();
            y4.a.a(xVar2);
        }
    }

    @Override // u4.b
    public final void dispose() {
        if (getAndSet(0) > 0) {
            for (x xVar : this.f11304c) {
                xVar.getClass();
                y4.a.a(xVar);
            }
        }
    }
}
