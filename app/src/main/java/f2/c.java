package f2;

import java.util.ListIterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class c extends u implements ListIterator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f11315a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f11316b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final e f11317c;

    public c(e eVar, int i2) {
        int size = eVar.size();
        r2.q.E(i2, size);
        this.f11315a = size;
        this.f11316b = i2;
        this.f11317c = eVar;
    }

    public final Object a(int i2) {
        return this.f11317c.get(i2);
    }

    @Override // java.util.ListIterator
    public final void add(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Iterator, java.util.ListIterator
    public final boolean hasNext() {
        return this.f11316b < this.f11315a;
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.f11316b > 0;
    }

    @Override // java.util.Iterator, java.util.ListIterator
    public final Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int i2 = this.f11316b;
        this.f11316b = i2 + 1;
        return a(i2);
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.f11316b;
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        if (!hasPrevious()) {
            throw new NoSuchElementException();
        }
        int i2 = this.f11316b - 1;
        this.f11316b = i2;
        return a(i2);
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.f11316b - 1;
    }

    @Override // java.util.ListIterator
    public final void set(Object obj) {
        throw new UnsupportedOperationException();
    }
}
