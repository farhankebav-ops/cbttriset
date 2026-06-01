package f2;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class o extends e {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final transient Object[] f11341c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final transient int f11342d;
    public final transient int e;

    public o(Object[] objArr, int i2, int i8) {
        this.f11341c = objArr;
        this.f11342d = i2;
        this.e = i8;
    }

    @Override // f2.a
    public final boolean f() {
        return true;
    }

    @Override // java.util.List
    public final Object get(int i2) {
        r2.q.A(i2, this.e);
        Object obj = this.f11341c[(i2 * 2) + this.f11342d];
        Objects.requireNonNull(obj);
        return obj;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.e;
    }
}
