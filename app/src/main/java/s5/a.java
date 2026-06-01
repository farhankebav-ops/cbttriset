package s5;

import java.util.AbstractList;
import java.util.ConcurrentModificationException;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class a implements ListIterator, f6.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f13688b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f13690d;
    public final r5.f e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f13687a = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f13689c = -1;

    public a(c cVar, int i2) {
        this.e = cVar;
        this.f13688b = i2;
        this.f13690d = ((AbstractList) cVar).modCount;
    }

    public void a() {
        if (((AbstractList) ((b) this.e).e).modCount != this.f13690d) {
            throw new ConcurrentModificationException();
        }
    }

    @Override // java.util.ListIterator
    public final void add(Object obj) {
        switch (this.f13687a) {
            case 0:
                a();
                b bVar = (b) this.e;
                int i2 = this.f13688b;
                this.f13688b = i2 + 1;
                bVar.add(i2, obj);
                this.f13689c = -1;
                this.f13690d = ((AbstractList) bVar).modCount;
                break;
            default:
                b();
                c cVar = (c) this.e;
                int i8 = this.f13688b;
                this.f13688b = i8 + 1;
                cVar.add(i8, obj);
                this.f13689c = -1;
                this.f13690d = ((AbstractList) cVar).modCount;
                break;
        }
    }

    public void b() {
        if (((AbstractList) ((c) this.e)).modCount != this.f13690d) {
            throw new ConcurrentModificationException();
        }
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final boolean hasNext() {
        switch (this.f13687a) {
            case 0:
                if (this.f13688b < ((b) this.e).f13693c) {
                }
                break;
            default:
                if (this.f13688b < ((c) this.e).f13697b) {
                }
                break;
        }
        return false;
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        switch (this.f13687a) {
            case 0:
                if (this.f13688b > 0) {
                }
                break;
            default:
                if (this.f13688b > 0) {
                }
                break;
        }
        return false;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final Object next() {
        switch (this.f13687a) {
            case 0:
                a();
                int i2 = this.f13688b;
                b bVar = (b) this.e;
                if (i2 >= bVar.f13693c) {
                    throw new NoSuchElementException();
                }
                this.f13688b = i2 + 1;
                this.f13689c = i2;
                return bVar.f13691a[bVar.f13692b + i2];
            default:
                b();
                int i8 = this.f13688b;
                c cVar = (c) this.e;
                if (i8 >= cVar.f13697b) {
                    throw new NoSuchElementException();
                }
                this.f13688b = i8 + 1;
                this.f13689c = i8;
                return cVar.f13696a[i8];
        }
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        switch (this.f13687a) {
        }
        return this.f13688b;
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        switch (this.f13687a) {
            case 0:
                a();
                int i2 = this.f13688b;
                if (i2 <= 0) {
                    throw new NoSuchElementException();
                }
                int i8 = i2 - 1;
                this.f13688b = i8;
                this.f13689c = i8;
                b bVar = (b) this.e;
                return bVar.f13691a[bVar.f13692b + i8];
            default:
                b();
                int i9 = this.f13688b;
                if (i9 <= 0) {
                    throw new NoSuchElementException();
                }
                int i10 = i9 - 1;
                this.f13688b = i10;
                this.f13689c = i10;
                return ((c) this.e).f13696a[i10];
        }
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        int i2;
        switch (this.f13687a) {
            case 0:
                i2 = this.f13688b;
                break;
            default:
                i2 = this.f13688b;
                break;
        }
        return i2 - 1;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final void remove() {
        switch (this.f13687a) {
            case 0:
                b bVar = (b) this.e;
                a();
                int i2 = this.f13689c;
                if (i2 == -1) {
                    throw new IllegalStateException("Call next() or previous() before removing element from the iterator.");
                }
                bVar.b(i2);
                this.f13688b = this.f13689c;
                this.f13689c = -1;
                this.f13690d = ((AbstractList) bVar).modCount;
                return;
            default:
                c cVar = (c) this.e;
                b();
                int i8 = this.f13689c;
                if (i8 == -1) {
                    throw new IllegalStateException("Call next() or previous() before removing element from the iterator.");
                }
                cVar.b(i8);
                this.f13688b = this.f13689c;
                this.f13689c = -1;
                this.f13690d = ((AbstractList) cVar).modCount;
                return;
        }
    }

    @Override // java.util.ListIterator
    public final void set(Object obj) {
        switch (this.f13687a) {
            case 0:
                a();
                int i2 = this.f13689c;
                if (i2 == -1) {
                    throw new IllegalStateException("Call next() or previous() before replacing element from the iterator.");
                }
                ((b) this.e).set(i2, obj);
                return;
            default:
                b();
                int i8 = this.f13689c;
                if (i8 == -1) {
                    throw new IllegalStateException("Call next() or previous() before replacing element from the iterator.");
                }
                ((c) this.e).set(i8, obj);
                return;
        }
    }

    public a(b bVar, int i2) {
        this.e = bVar;
        this.f13688b = i2;
        this.f13690d = ((AbstractList) bVar).modCount;
    }
}
