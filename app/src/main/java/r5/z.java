package r5;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class z extends f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f13645a;

    public z(ArrayList arrayList) {
        this.f13645a = arrayList;
    }

    @Override // r5.f
    public final int a() {
        return this.f13645a.size();
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i2, Object obj) {
        this.f13645a.add(l.P0(this, i2), obj);
    }

    @Override // r5.f
    public final Object b(int i2) {
        return this.f13645a.remove(l.O0(this, i2));
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        this.f13645a.clear();
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i2) {
        return this.f13645a.get(l.O0(this, i2));
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public final Iterator iterator() {
        return new y(this, 0);
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator listIterator() {
        return new y(this, 0);
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int i2, Object obj) {
        return this.f13645a.set(l.O0(this, i2), obj);
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator listIterator(int i2) {
        return new y(this, i2);
    }
}
