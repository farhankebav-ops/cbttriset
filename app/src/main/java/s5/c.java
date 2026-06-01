package s5;

import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import kotlin.jvm.internal.k;
import r2.q;
import r5.j;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class c extends r5.f implements RandomAccess, Serializable {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final c f13695d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object[] f13696a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f13697b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f13698c;

    static {
        c cVar = new c(0);
        cVar.f13698c = true;
        f13695d = cVar;
    }

    public c(int i2) {
        if (i2 < 0) {
            throw new IllegalArgumentException("capacity must be non-negative.");
        }
        this.f13696a = new Object[i2];
    }

    @Override // r5.f
    public final int a() {
        return this.f13697b;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(Object obj) {
        f();
        int i2 = this.f13697b;
        ((AbstractList) this).modCount++;
        g(i2, 1);
        this.f13696a[i2] = obj;
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection elements) {
        k.e(elements, "elements");
        f();
        int size = elements.size();
        d(this.f13697b, elements, size);
        return size > 0;
    }

    @Override // r5.f
    public final Object b(int i2) {
        f();
        r5.b bVar = r5.e.Companion;
        int i8 = this.f13697b;
        bVar.getClass();
        r5.b.b(i2, i8);
        return h(i2);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        f();
        i(0, this.f13697b);
    }

    public final void d(int i2, Collection collection, int i8) {
        ((AbstractList) this).modCount++;
        g(i2, i8);
        Iterator it = collection.iterator();
        for (int i9 = 0; i9 < i8; i9++) {
            this.f13696a[i2 + i9] = it.next();
        }
    }

    public final void e(int i2, Object obj) {
        ((AbstractList) this).modCount++;
        g(i2, 1);
        this.f13696a[i2] = obj;
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof List) {
            List list = (List) obj;
            Object[] objArr = this.f13696a;
            int i2 = this.f13697b;
            if (i2 == list.size()) {
                for (int i8 = 0; i8 < i2; i8++) {
                    if (k.a(objArr[i8], list.get(i8))) {
                    }
                }
                return true;
            }
        }
        return false;
    }

    public final void f() {
        if (this.f13698c) {
            throw new UnsupportedOperationException();
        }
    }

    public final void g(int i2, int i8) {
        int i9 = this.f13697b + i8;
        if (i9 < 0) {
            throw new OutOfMemoryError();
        }
        Object[] objArr = this.f13696a;
        if (i9 > objArr.length) {
            r5.b bVar = r5.e.Companion;
            int length = objArr.length;
            bVar.getClass();
            int iE = r5.b.e(length, i9);
            Object[] objArr2 = this.f13696a;
            k.e(objArr2, "<this>");
            Object[] objArrCopyOf = Arrays.copyOf(objArr2, iE);
            k.d(objArrCopyOf, "copyOf(...)");
            this.f13696a = objArrCopyOf;
        }
        Object[] objArr3 = this.f13696a;
        j.f0(objArr3, i2 + i8, objArr3, i2, this.f13697b);
        this.f13697b += i8;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i2) {
        r5.b bVar = r5.e.Companion;
        int i8 = this.f13697b;
        bVar.getClass();
        r5.b.b(i2, i8);
        return this.f13696a[i2];
    }

    public final Object h(int i2) {
        ((AbstractList) this).modCount++;
        Object[] objArr = this.f13696a;
        Object obj = objArr[i2];
        j.f0(objArr, i2, objArr, i2 + 1, this.f13697b);
        Object[] objArr2 = this.f13696a;
        int i8 = this.f13697b - 1;
        k.e(objArr2, "<this>");
        objArr2[i8] = null;
        this.f13697b--;
        return obj;
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        Object[] objArr = this.f13696a;
        int i2 = this.f13697b;
        int iHashCode = 1;
        for (int i8 = 0; i8 < i2; i8++) {
            Object obj = objArr[i8];
            iHashCode = (iHashCode * 31) + (obj != null ? obj.hashCode() : 0);
        }
        return iHashCode;
    }

    public final void i(int i2, int i8) {
        if (i8 > 0) {
            ((AbstractList) this).modCount++;
        }
        Object[] objArr = this.f13696a;
        j.f0(objArr, i2, objArr, i2 + i8, this.f13697b);
        Object[] objArr2 = this.f13696a;
        int i9 = this.f13697b;
        q.o0(i9 - i8, i9, objArr2);
        this.f13697b -= i8;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        for (int i2 = 0; i2 < this.f13697b; i2++) {
            if (k.a(this.f13696a[i2], obj)) {
                return i2;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean isEmpty() {
        return this.f13697b == 0;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public final Iterator iterator() {
        return listIterator(0);
    }

    public final int j(int i2, int i8, Collection collection, boolean z2) {
        int i9 = 0;
        int i10 = 0;
        while (i9 < i8) {
            int i11 = i2 + i9;
            if (collection.contains(this.f13696a[i11]) == z2) {
                Object[] objArr = this.f13696a;
                i9++;
                objArr[i10 + i2] = objArr[i11];
                i10++;
            } else {
                i9++;
            }
        }
        int i12 = i8 - i10;
        Object[] objArr2 = this.f13696a;
        j.f0(objArr2, i2 + i10, objArr2, i8 + i2, this.f13697b);
        Object[] objArr3 = this.f13696a;
        int i13 = this.f13697b;
        q.o0(i13 - i12, i13, objArr3);
        if (i12 > 0) {
            ((AbstractList) this).modCount++;
        }
        this.f13697b -= i12;
        return i12;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int lastIndexOf(Object obj) {
        for (int i2 = this.f13697b - 1; i2 >= 0; i2--) {
            if (k.a(this.f13696a[i2], obj)) {
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
        f();
        return j(0, this.f13697b, elements, false) > 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean retainAll(Collection elements) {
        k.e(elements, "elements");
        f();
        return j(0, this.f13697b, elements, true) > 0;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int i2, Object obj) {
        f();
        r5.b bVar = r5.e.Companion;
        int i8 = this.f13697b;
        bVar.getClass();
        r5.b.b(i2, i8);
        Object[] objArr = this.f13696a;
        Object obj2 = objArr[i2];
        objArr[i2] = obj;
        return obj2;
    }

    @Override // java.util.AbstractList, java.util.List
    public final List subList(int i2, int i8) {
        r5.b bVar = r5.e.Companion;
        int i9 = this.f13697b;
        bVar.getClass();
        r5.b.d(i2, i8, i9);
        return new b(this.f13696a, i2, i8 - i2, null, this);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final Object[] toArray(Object[] array) {
        k.e(array, "array");
        int length = array.length;
        int i2 = this.f13697b;
        if (length < i2) {
            Object[] objArrCopyOfRange = Arrays.copyOfRange(this.f13696a, 0, i2, array.getClass());
            k.d(objArrCopyOfRange, "copyOfRange(...)");
            return objArrCopyOfRange;
        }
        j.f0(this.f13696a, 0, array, 0, i2);
        int i8 = this.f13697b;
        if (i8 < array.length) {
            array[i8] = null;
        }
        return array;
    }

    @Override // java.util.AbstractCollection
    public final String toString() {
        return q.i(this.f13696a, 0, this.f13697b, this);
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator listIterator(int i2) {
        r5.b bVar = r5.e.Companion;
        int i8 = this.f13697b;
        bVar.getClass();
        r5.b.c(i2, i8);
        return new a(this, i2);
    }

    @Override // java.util.AbstractList, java.util.List
    public final boolean addAll(int i2, Collection elements) {
        k.e(elements, "elements");
        f();
        r5.b bVar = r5.e.Companion;
        int i8 = this.f13697b;
        bVar.getClass();
        r5.b.c(i2, i8);
        int size = elements.size();
        d(i2, elements, size);
        return size > 0;
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i2, Object obj) {
        f();
        r5.b bVar = r5.e.Companion;
        int i8 = this.f13697b;
        bVar.getClass();
        r5.b.c(i2, i8);
        ((AbstractList) this).modCount++;
        g(i2, 1);
        this.f13696a[i2] = obj;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final Object[] toArray() {
        return j.j0(0, this.f13697b, this.f13696a);
    }
}
