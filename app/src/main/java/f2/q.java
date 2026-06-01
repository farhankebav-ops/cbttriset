package f2;

import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class q extends i {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Object[] f11345i;
    public static final q j;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final transient Object[] f11346d;
    public final transient int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final transient Object[] f11347f;
    public final transient int g;
    public final transient int h;

    static {
        Object[] objArr = new Object[0];
        f11345i = objArr;
        j = new q(objArr, 0, objArr, 0, 0);
    }

    public q(Object[] objArr, int i2, Object[] objArr2, int i8, int i9) {
        this.f11346d = objArr;
        this.e = i2;
        this.f11347f = objArr2;
        this.g = i8;
        this.h = i9;
    }

    @Override // f2.a
    public final int b(int i2, Object[] objArr) {
        Object[] objArr2 = this.f11346d;
        int i8 = this.h;
        System.arraycopy(objArr2, 0, objArr, i2, i8);
        return i2 + i8;
    }

    @Override // f2.a
    public final Object[] c() {
        return this.f11346d;
    }

    @Override // f2.a, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        if (obj != null) {
            Object[] objArr = this.f11347f;
            if (objArr.length != 0) {
                int iP = n7.b.P(obj.hashCode());
                while (true) {
                    int i2 = iP & this.g;
                    Object obj2 = objArr[i2];
                    if (obj2 == null) {
                        return false;
                    }
                    if (obj2.equals(obj)) {
                        return true;
                    }
                    iP = i2 + 1;
                }
            }
        }
        return false;
    }

    @Override // f2.a
    public final int d() {
        return this.h;
    }

    @Override // f2.a
    public final int e() {
        return 0;
    }

    @Override // f2.a
    public final boolean f() {
        return false;
    }

    @Override // f2.i, java.util.Collection, java.util.Set
    public final int hashCode() {
        return this.e;
    }

    @Override // f2.i
    public final e i() {
        return e.g(this.h, this.f11346d);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        return a().listIterator(0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.h;
    }
}
