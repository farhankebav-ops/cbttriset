package s5;

import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import kotlin.jvm.internal.k;
import r2.q;
import r5.j;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class b extends r5.f implements RandomAccess, Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object[] f13691a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f13692b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f13693c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final b f13694d;
    public final c e;

    public b(Object[] backing, int i2, int i8, b bVar, c root) {
        k.e(backing, "backing");
        k.e(root, "root");
        this.f13691a = backing;
        this.f13692b = i2;
        this.f13693c = i8;
        this.f13694d = bVar;
        this.e = root;
        ((AbstractList) this).modCount = ((AbstractList) root).modCount;
    }

    @Override // r5.f
    public final int a() {
        f();
        return this.f13693c;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(Object obj) {
        g();
        f();
        e(this.f13692b + this.f13693c, obj);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection elements) {
        k.e(elements, "elements");
        g();
        f();
        int size = elements.size();
        d(this.f13692b + this.f13693c, elements, size);
        return size > 0;
    }

    @Override // r5.f
    public final Object b(int i2) {
        g();
        f();
        r5.b bVar = r5.e.Companion;
        int i8 = this.f13693c;
        bVar.getClass();
        r5.b.b(i2, i8);
        return h(this.f13692b + i2);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        g();
        f();
        i(this.f13692b, this.f13693c);
    }

    public final void d(int i2, Collection collection, int i8) {
        ((AbstractList) this).modCount++;
        c cVar = this.e;
        b bVar = this.f13694d;
        if (bVar != null) {
            bVar.d(i2, collection, i8);
        } else {
            c cVar2 = c.f13695d;
            cVar.d(i2, collection, i8);
        }
        this.f13691a = cVar.f13696a;
        this.f13693c += i8;
    }

    public final void e(int i2, Object obj) {
        ((AbstractList) this).modCount++;
        c cVar = this.e;
        b bVar = this.f13694d;
        if (bVar != null) {
            bVar.e(i2, obj);
        } else {
            c cVar2 = c.f13695d;
            cVar.e(i2, obj);
        }
        this.f13691a = cVar.f13696a;
        this.f13693c++;
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        f();
        if (obj == this) {
            return true;
        }
        if (obj instanceof List) {
            List list = (List) obj;
            Object[] objArr = this.f13691a;
            int i2 = this.f13693c;
            if (i2 == list.size()) {
                for (int i8 = 0; i8 < i2; i8++) {
                    if (k.a(objArr[this.f13692b + i8], list.get(i8))) {
                    }
                }
                return true;
            }
        }
        return false;
    }

    public final void f() {
        if (((AbstractList) this.e).modCount != ((AbstractList) this).modCount) {
            throw new ConcurrentModificationException();
        }
    }

    public final void g() {
        if (this.e.f13698c) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i2) {
        f();
        r5.b bVar = r5.e.Companion;
        int i8 = this.f13693c;
        bVar.getClass();
        r5.b.b(i2, i8);
        return this.f13691a[this.f13692b + i2];
    }

    public final Object h(int i2) {
        Object objH;
        ((AbstractList) this).modCount++;
        b bVar = this.f13694d;
        if (bVar != null) {
            objH = bVar.h(i2);
        } else {
            c cVar = c.f13695d;
            objH = this.e.h(i2);
        }
        this.f13693c--;
        return objH;
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        f();
        Object[] objArr = this.f13691a;
        int i2 = this.f13693c;
        int iHashCode = 1;
        for (int i8 = 0; i8 < i2; i8++) {
            Object obj = objArr[this.f13692b + i8];
            iHashCode = (iHashCode * 31) + (obj != null ? obj.hashCode() : 0);
        }
        return iHashCode;
    }

    public final void i(int i2, int i8) {
        if (i8 > 0) {
            ((AbstractList) this).modCount++;
        }
        b bVar = this.f13694d;
        if (bVar != null) {
            bVar.i(i2, i8);
        } else {
            c cVar = c.f13695d;
            this.e.i(i2, i8);
        }
        this.f13693c -= i8;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        f();
        for (int i2 = 0; i2 < this.f13693c; i2++) {
            if (k.a(this.f13691a[this.f13692b + i2], obj)) {
                return i2;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean isEmpty() {
        f();
        return this.f13693c == 0;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public final Iterator iterator() {
        return listIterator(0);
    }

    public final int j(int i2, int i8, Collection collection, boolean z2) {
        int iJ;
        b bVar = this.f13694d;
        if (bVar != null) {
            iJ = bVar.j(i2, i8, collection, z2);
        } else {
            c cVar = c.f13695d;
            iJ = this.e.j(i2, i8, collection, z2);
        }
        if (iJ > 0) {
            ((AbstractList) this).modCount++;
        }
        this.f13693c -= iJ;
        return iJ;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int lastIndexOf(Object obj) {
        f();
        for (int i2 = this.f13693c - 1; i2 >= 0; i2--) {
            if (k.a(this.f13691a[this.f13692b + i2], obj)) {
                return i2;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator listIterator() {
        return listIterator(0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        g();
        f();
        int iIndexOf = indexOf(obj);
        if (iIndexOf >= 0) {
            b(iIndexOf);
        }
        return iIndexOf >= 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean removeAll(Collection elements) {
        k.e(elements, "elements");
        g();
        f();
        return j(this.f13692b, this.f13693c, elements, false) > 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean retainAll(Collection elements) {
        k.e(elements, "elements");
        g();
        f();
        return j(this.f13692b, this.f13693c, elements, true) > 0;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int i2, Object obj) {
        g();
        f();
        r5.b bVar = r5.e.Companion;
        int i8 = this.f13693c;
        bVar.getClass();
        r5.b.b(i2, i8);
        Object[] objArr = this.f13691a;
        int i9 = this.f13692b + i2;
        Object obj2 = objArr[i9];
        objArr[i9] = obj;
        return obj2;
    }

    @Override // java.util.AbstractList, java.util.List
    public final List subList(int i2, int i8) {
        r5.b bVar = r5.e.Companion;
        int i9 = this.f13693c;
        bVar.getClass();
        r5.b.d(i2, i8, i9);
        return new b(this.f13691a, this.f13692b + i2, i8 - i2, this, this.e);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final Object[] toArray(Object[] array) {
        k.e(array, "array");
        f();
        int length = array.length;
        int i2 = this.f13693c;
        int i8 = this.f13692b;
        if (length < i2) {
            Object[] objArrCopyOfRange = Arrays.copyOfRange(this.f13691a, i8, i2 + i8, array.getClass());
            k.d(objArrCopyOfRange, "copyOfRange(...)");
            return objArrCopyOfRange;
        }
        j.f0(this.f13691a, 0, array, i8, i2 + i8);
        int i9 = this.f13693c;
        if (i9 < array.length) {
            array[i9] = null;
        }
        return array;
    }

    @Override // java.util.AbstractCollection
    public final String toString() {
        f();
        return q.i(this.f13691a, this.f13692b, this.f13693c, this);
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator listIterator(int i2) {
        f();
        r5.b bVar = r5.e.Companion;
        int i8 = this.f13693c;
        bVar.getClass();
        r5.b.c(i2, i8);
        return new a(this, i2);
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i2, Object obj) {
        g();
        f();
        r5.b bVar = r5.e.Companion;
        int i8 = this.f13693c;
        bVar.getClass();
        r5.b.c(i2, i8);
        e(this.f13692b + i2, obj);
    }

    @Override // java.util.AbstractList, java.util.List
    public final boolean addAll(int i2, Collection elements) {
        k.e(elements, "elements");
        g();
        f();
        r5.b bVar = r5.e.Companion;
        int i8 = this.f13693c;
        bVar.getClass();
        r5.b.c(i2, i8);
        int size = elements.size();
        d(this.f13692b + i2, elements, size);
        return size > 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final Object[] toArray() {
        f();
        Object[] objArr = this.f13691a;
        int i2 = this.f13693c;
        int i8 = this.f13692b;
        return j.j0(i8, i2 + i8, objArr);
    }
}
