package d5;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class p0 extends AtomicInteger implements s4.g, u4.b {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final o0[] f11134i = new o0[0];
    public static final o0[] j = new o0[0];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicReference f11135a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f11136b;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile Serializable f11139f;
    public int g;
    public volatile a5.h h;
    public final AtomicReference e = new AtomicReference();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicReference f11137c = new AtomicReference(f11134i);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AtomicBoolean f11138d = new AtomicBoolean();

    public p0(AtomicReference atomicReference, int i2) {
        this.f11135a = atomicReference;
        this.f11136b = i2;
    }

    public final boolean a(Object obj, boolean z2) {
        int i2 = 0;
        if (obj != null) {
            l5.e eVar = l5.e.f12825a;
            o0[] o0VarArr = j;
            AtomicReference atomicReference = this.f11137c;
            AtomicReference atomicReference2 = this.f11135a;
            if (obj != eVar) {
                Throwable th = ((l5.d) obj).f12824a;
                while (!atomicReference2.compareAndSet(this, null) && atomicReference2.get() == this) {
                }
                o0[] o0VarArr2 = (o0[]) atomicReference.getAndSet(o0VarArr);
                if (o0VarArr2.length != 0) {
                    int length = o0VarArr2.length;
                    while (i2 < length) {
                        o0VarArr2[i2].f11128a.onError(th);
                        i2++;
                    }
                } else {
                    n7.b.F(th);
                }
                return true;
            }
            if (z2) {
                while (!atomicReference2.compareAndSet(this, null) && atomicReference2.get() == this) {
                }
                o0[] o0VarArr3 = (o0[]) atomicReference.getAndSet(o0VarArr);
                int length2 = o0VarArr3.length;
                while (i2 < length2) {
                    o0VarArr3[i2].f11128a.onComplete();
                    i2++;
                }
                return true;
            }
        }
        return false;
    }

    @Override // s4.g
    public final void b(Object obj) {
        if (this.g != 0 || this.h.offer(obj)) {
            c();
        } else {
            onError(new v4.c("Prefetch queue is full?!"));
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:75:0x0124, code lost:
    
        r4 = r0;
        r3 = true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void c() {
        /*
            Method dump skipped, instruction units count: 345
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: d5.p0.c():void");
    }

    public final boolean d() {
        return this.f11137c.get() == j;
    }

    @Override // u4.b
    public final void dispose() {
        AtomicReference atomicReference;
        AtomicReference atomicReference2 = this.f11137c;
        Object obj = atomicReference2.get();
        Object obj2 = j;
        if (obj == obj2 || ((o0[]) atomicReference2.getAndSet(obj2)) == obj2) {
            return;
        }
        do {
            atomicReference = this.f11135a;
            if (atomicReference.compareAndSet(this, null)) {
                break;
            }
        } while (atomicReference.get() == this);
        k5.f.a(this.e);
    }

    @Override // s4.g
    public final void f(o7.b bVar) {
        if (k5.f.b(this.e, bVar)) {
            if (bVar instanceof a5.e) {
                a5.e eVar = (a5.e) bVar;
                int iD = eVar.d(3);
                if (iD == 1) {
                    this.g = iD;
                    this.h = eVar;
                    this.f11139f = l5.e.f12825a;
                    c();
                    return;
                }
                if (iD == 2) {
                    this.g = iD;
                    this.h = eVar;
                    bVar.c(this.f11136b);
                    return;
                }
            }
            this.h = new h5.a(this.f11136b);
            bVar.c(this.f11136b);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void g(o0 o0Var) {
        o0[] o0VarArr;
        while (true) {
            AtomicReference atomicReference = this.f11137c;
            o0[] o0VarArr2 = (o0[]) atomicReference.get();
            int length = o0VarArr2.length;
            if (length == 0) {
                return;
            }
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    i2 = -1;
                    break;
                } else if (o0VarArr2[i2].equals(o0Var)) {
                    break;
                } else {
                    i2++;
                }
            }
            if (i2 < 0) {
                return;
            }
            if (length == 1) {
                o0VarArr = f11134i;
            } else {
                o0[] o0VarArr3 = new o0[length - 1];
                System.arraycopy(o0VarArr2, 0, o0VarArr3, 0, i2);
                System.arraycopy(o0VarArr2, i2 + 1, o0VarArr3, i2, (length - i2) - 1);
                o0VarArr = o0VarArr3;
            }
            while (!atomicReference.compareAndSet(o0VarArr2, o0VarArr)) {
                if (atomicReference.get() != o0VarArr2) {
                    break;
                }
            }
            return;
        }
    }

    @Override // s4.g
    public final void onComplete() {
        if (this.f11139f == null) {
            this.f11139f = l5.e.f12825a;
            c();
        }
    }

    @Override // s4.g
    public final void onError(Throwable th) {
        if (this.f11139f != null) {
            n7.b.F(th);
        } else {
            this.f11139f = new l5.d(th);
            c();
        }
    }
}
