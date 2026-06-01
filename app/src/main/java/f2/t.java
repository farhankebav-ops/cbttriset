package f2;

import com.ironsource.C2300e4;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class t extends i {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final transient Object f11354d;

    public t(Object obj) {
        this.f11354d = obj;
    }

    @Override // f2.i, f2.a
    public final e a() {
        c cVar = e.f11320b;
        Object[] objArr = {this.f11354d};
        r2.q.B(1, objArr);
        return e.g(1, objArr);
    }

    @Override // f2.a
    public final int b(int i2, Object[] objArr) {
        objArr[i2] = this.f11354d;
        return i2 + 1;
    }

    @Override // f2.a, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        return this.f11354d.equals(obj);
    }

    @Override // f2.a
    public final boolean f() {
        return false;
    }

    @Override // f2.i, java.util.Collection, java.util.Set
    public final int hashCode() {
        return this.f11354d.hashCode();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        return new j(this.f11354d);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return 1;
    }

    @Override // java.util.AbstractCollection
    public final String toString() {
        return C2300e4.i.f8403d + this.f11354d.toString() + ']';
    }
}
