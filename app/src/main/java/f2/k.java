package f2;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class k extends e {
    public static final k e = new k(new Object[0], 0);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final transient Object[] f11335c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final transient int f11336d;

    public k(Object[] objArr, int i2) {
        this.f11335c = objArr;
        this.f11336d = i2;
    }

    @Override // f2.e, f2.a
    public final int b(int i2, Object[] objArr) {
        Object[] objArr2 = this.f11335c;
        int i8 = this.f11336d;
        System.arraycopy(objArr2, 0, objArr, i2, i8);
        return i2 + i8;
    }

    @Override // f2.a
    public final Object[] c() {
        return this.f11335c;
    }

    @Override // f2.a
    public final int d() {
        return this.f11336d;
    }

    @Override // f2.a
    public final int e() {
        return 0;
    }

    @Override // f2.a
    public final boolean f() {
        return false;
    }

    @Override // java.util.List
    public final Object get(int i2) {
        r2.q.A(i2, this.f11336d);
        Object obj = this.f11335c[i2];
        Objects.requireNonNull(obj);
        return obj;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f11336d;
    }
}
