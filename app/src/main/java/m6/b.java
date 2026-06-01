package m6;

import java.util.Iterator;
import java.util.NoSuchElementException;
import r5.u;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class b implements Iterator, f6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f12971a = 2;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f12972b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Iterator f12973c;

    public b(Iterator iterator) {
        kotlin.jvm.internal.k.e(iterator, "iterator");
        this.f12973c = iterator;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        Iterator it;
        switch (this.f12971a) {
            case 0:
                break;
            case 1:
                return this.f12972b > 0 && this.f12973c.hasNext();
            default:
                return this.f12973c.hasNext();
        }
        while (true) {
            int i2 = this.f12972b;
            it = this.f12973c;
            if (i2 > 0 && it.hasNext()) {
                it.next();
                this.f12972b--;
            }
        }
        return it.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        Iterator it;
        switch (this.f12971a) {
            case 0:
                break;
            case 1:
                int i2 = this.f12972b;
                if (i2 == 0) {
                    throw new NoSuchElementException();
                }
                this.f12972b = i2 - 1;
                return this.f12973c.next();
            default:
                int i8 = this.f12972b;
                this.f12972b = i8 + 1;
                if (i8 >= 0) {
                    return new u(i8, this.f12973c.next());
                }
                r5.m.K0();
                throw null;
        }
        while (true) {
            int i9 = this.f12972b;
            it = this.f12973c;
            if (i9 > 0 && it.hasNext()) {
                it.next();
                this.f12972b--;
            }
        }
        return it.next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        switch (this.f12971a) {
            case 0:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            case 1:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            default:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public b(c cVar, byte b8) {
        this.f12972b = cVar.f12976c;
        this.f12973c = cVar.f12975b.iterator();
    }

    public b(c cVar) {
        this.f12973c = cVar.f12975b.iterator();
        this.f12972b = cVar.f12976c;
    }
}
