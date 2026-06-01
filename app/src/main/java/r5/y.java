package r5;

import java.util.ListIterator;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class y implements ListIterator, f6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ListIterator f13643a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ z f13644b;

    public y(z zVar, int i2) {
        this.f13644b = zVar;
        this.f13643a = zVar.f13645a.listIterator(l.P0(zVar, i2));
    }

    @Override // java.util.ListIterator
    public final void add(Object obj) {
        ListIterator listIterator = this.f13643a;
        listIterator.add(obj);
        listIterator.previous();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final boolean hasNext() {
        return this.f13643a.hasPrevious();
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.f13643a.hasNext();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final Object next() {
        return this.f13643a.previous();
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return m.G0(this.f13644b) - this.f13643a.previousIndex();
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        return this.f13643a.next();
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return m.G0(this.f13644b) - this.f13643a.nextIndex();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final void remove() {
        this.f13643a.remove();
    }

    @Override // java.util.ListIterator
    public final void set(Object obj) {
        this.f13643a.set(obj);
    }
}
