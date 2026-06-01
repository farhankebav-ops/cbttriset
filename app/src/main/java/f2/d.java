package f2;

import java.util.Iterator;
import java.util.ListIterator;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class d extends e {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final transient int f11318c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final transient int f11319d;
    public final /* synthetic */ e e;

    public d(e eVar, int i2, int i8) {
        this.e = eVar;
        this.f11318c = i2;
        this.f11319d = i8;
    }

    @Override // f2.a
    public final Object[] c() {
        return this.e.c();
    }

    @Override // f2.a
    public final int d() {
        return this.e.e() + this.f11318c + this.f11319d;
    }

    @Override // f2.a
    public final int e() {
        return this.e.e() + this.f11318c;
    }

    @Override // f2.a
    public final boolean f() {
        return true;
    }

    @Override // java.util.List
    public final Object get(int i2) {
        r2.q.A(i2, this.f11319d);
        return this.e.get(i2 + this.f11318c);
    }

    @Override // f2.e, java.util.List
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public final e subList(int i2, int i8) {
        r2.q.F(i2, i8, this.f11319d);
        int i9 = this.f11318c;
        return this.e.subList(i2 + i9, i8 + i9);
    }

    @Override // f2.e, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public final Iterator iterator() {
        return listIterator(0);
    }

    @Override // f2.e, java.util.List
    public final ListIterator listIterator() {
        return listIterator(0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f11319d;
    }

    @Override // f2.e, java.util.List
    public final /* bridge */ /* synthetic */ ListIterator listIterator(int i2) {
        return listIterator(i2);
    }
}
