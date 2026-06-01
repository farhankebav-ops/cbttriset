package m6;

import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class n implements Iterator, f6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Iterator f12994a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ f f12995b;

    public n(f fVar) {
        this.f12995b = fVar;
        this.f12994a = fVar.f12979b.iterator();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f12994a.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        return this.f12995b.f12980c.invoke(this.f12994a.next());
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
