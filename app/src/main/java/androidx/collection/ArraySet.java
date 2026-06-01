package androidx.collection;

import androidx.camera.core.processing.util.a;
import androidx.collection.internal.ContainerHelpersKt;
import d7.i;
import f6.b;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Set;
import kotlin.jvm.internal.d0;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import r5.j;
import r5.l;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class ArraySet<E> implements Collection<E>, Set<E>, b {
    private int _size;
    private Object[] array;
    private int[] hashes;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public final class ElementIterator extends IndexBasedArrayIterator<E> {
        public ElementIterator() {
            super(ArraySet.this.get_size$collection());
        }

        @Override // androidx.collection.IndexBasedArrayIterator
        public E elementAt(int i2) {
            return ArraySet.this.valueAt(i2);
        }

        @Override // androidx.collection.IndexBasedArrayIterator
        public void removeAt(int i2) {
            ArraySet.this.removeAt(i2);
        }
    }

    public ArraySet() {
        this(0, 1, null);
    }

    @Override // java.util.Collection, java.util.Set
    public boolean add(E e) {
        int i2;
        int iIndexOf;
        int i8 = get_size$collection();
        if (e == null) {
            iIndexOf = ArraySetKt.indexOfNull(this);
            i2 = 0;
        } else {
            int iHashCode = e.hashCode();
            i2 = iHashCode;
            iIndexOf = ArraySetKt.indexOf(this, e, iHashCode);
        }
        if (iIndexOf >= 0) {
            return false;
        }
        int i9 = ~iIndexOf;
        if (i8 >= getHashes$collection().length) {
            int i10 = 8;
            if (i8 >= 8) {
                i10 = (i8 >> 1) + i8;
            } else if (i8 < 4) {
                i10 = 4;
            }
            int[] hashes$collection = getHashes$collection();
            Object[] array$collection = getArray$collection();
            ArraySetKt.allocArrays(this, i10);
            if (i8 != get_size$collection()) {
                throw new ConcurrentModificationException();
            }
            if (getHashes$collection().length != 0) {
                j.g0(0, hashes$collection.length, 6, hashes$collection, getHashes$collection());
                j.h0(array$collection, getArray$collection(), 0, 0, array$collection.length, 6);
            }
        }
        if (i9 < i8) {
            int i11 = i9 + 1;
            j.c0(i11, i9, i8, getHashes$collection(), getHashes$collection());
            j.f0(getArray$collection(), i11, getArray$collection(), i9, i8);
        }
        if (i8 != get_size$collection() || i9 >= getHashes$collection().length) {
            throw new ConcurrentModificationException();
        }
        getHashes$collection()[i9] = i2;
        getArray$collection()[i9] = e;
        set_size$collection(get_size$collection() + 1);
        return true;
    }

    public final void addAll(ArraySet<? extends E> array) {
        k.e(array, "array");
        int i2 = array.get_size$collection();
        ensureCapacity(get_size$collection() + i2);
        if (get_size$collection() != 0) {
            for (int i8 = 0; i8 < i2; i8++) {
                add(array.valueAt(i8));
            }
        } else if (i2 > 0) {
            j.g0(0, i2, 6, array.getHashes$collection(), getHashes$collection());
            j.h0(array.getArray$collection(), getArray$collection(), 0, 0, i2, 6);
            if (get_size$collection() != 0) {
                throw new ConcurrentModificationException();
            }
            set_size$collection(i2);
        }
    }

    @Override // java.util.Collection, java.util.Set
    public void clear() {
        if (get_size$collection() != 0) {
            setHashes$collection(ContainerHelpersKt.EMPTY_INTS);
            setArray$collection(ContainerHelpersKt.EMPTY_OBJECTS);
            set_size$collection(0);
        }
        if (get_size$collection() != 0) {
            throw new ConcurrentModificationException();
        }
    }

    @Override // java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean containsAll(Collection<? extends Object> elements) {
        k.e(elements, "elements");
        Iterator<? extends Object> it = elements.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    public final void ensureCapacity(int i2) {
        int i8 = get_size$collection();
        if (getHashes$collection().length < i2) {
            int[] hashes$collection = getHashes$collection();
            Object[] array$collection = getArray$collection();
            ArraySetKt.allocArrays(this, i2);
            if (get_size$collection() > 0) {
                j.g0(0, get_size$collection(), 6, hashes$collection, getHashes$collection());
                j.h0(array$collection, getArray$collection(), 0, 0, get_size$collection(), 6);
            }
        }
        if (get_size$collection() != i8) {
            throw new ConcurrentModificationException();
        }
    }

    @Override // java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Set) || size() != ((Set) obj).size()) {
            return false;
        }
        try {
            int i2 = get_size$collection();
            for (int i8 = 0; i8 < i2; i8++) {
                if (!((Set) obj).contains(valueAt(i8))) {
                    return false;
                }
            }
            return true;
        } catch (ClassCastException | NullPointerException unused) {
            return false;
        }
    }

    public final Object[] getArray$collection() {
        return this.array;
    }

    public final int[] getHashes$collection() {
        return this.hashes;
    }

    public int getSize() {
        return this._size;
    }

    public final int get_size$collection() {
        return this._size;
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        int[] hashes$collection = getHashes$collection();
        int i2 = get_size$collection();
        int i8 = 0;
        for (int i9 = 0; i9 < i2; i9++) {
            i8 += hashes$collection[i9];
        }
        return i8;
    }

    public final int indexOf(Object obj) {
        return obj == null ? ArraySetKt.indexOfNull(this) : ArraySetKt.indexOf(this, obj, obj.hashCode());
    }

    @Override // java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return get_size$collection() <= 0;
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<E> iterator() {
        return new ElementIterator();
    }

    @Override // java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        int iIndexOf = indexOf(obj);
        if (iIndexOf < 0) {
            return false;
        }
        removeAt(iIndexOf);
        return true;
    }

    public final boolean removeAll(ArraySet<? extends E> array) {
        k.e(array, "array");
        int i2 = array.get_size$collection();
        int i8 = get_size$collection();
        for (int i9 = 0; i9 < i2; i9++) {
            remove(array.valueAt(i9));
        }
        return i8 != get_size$collection();
    }

    public final E removeAt(int i2) {
        int i8;
        int i9 = get_size$collection();
        E e = (E) getArray$collection()[i2];
        if (i9 <= 1) {
            clear();
            return e;
        }
        int i10 = i9 - 1;
        if (getHashes$collection().length <= 8 || get_size$collection() >= getHashes$collection().length / 3) {
            if (i2 < i10) {
                int i11 = i2 + 1;
                j.c0(i2, i11, i9, getHashes$collection(), getHashes$collection());
                j.f0(getArray$collection(), i2, getArray$collection(), i11, i9);
            }
            getArray$collection()[i10] = null;
        } else {
            int i12 = get_size$collection() > 8 ? get_size$collection() + (get_size$collection() >> 1) : 8;
            int[] hashes$collection = getHashes$collection();
            Object[] array$collection = getArray$collection();
            ArraySetKt.allocArrays(this, i12);
            if (i2 > 0) {
                j.g0(0, i2, 6, hashes$collection, getHashes$collection());
                i8 = i2;
                j.h0(array$collection, getArray$collection(), 0, 0, i8, 6);
            } else {
                i8 = i2;
            }
            if (i8 < i10) {
                int i13 = i8 + 1;
                j.c0(i8, i13, i9, hashes$collection, getHashes$collection());
                j.f0(array$collection, i8, getArray$collection(), i13, i9);
            }
        }
        if (i9 != get_size$collection()) {
            throw new ConcurrentModificationException();
        }
        set_size$collection(i10);
        return e;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean retainAll(Collection<? extends Object> elements) {
        k.e(elements, "elements");
        boolean z2 = false;
        for (int i2 = get_size$collection() - 1; -1 < i2; i2--) {
            if (!l.T0(elements, getArray$collection()[i2])) {
                removeAt(i2);
                z2 = true;
            }
        }
        return z2;
    }

    public final void setArray$collection(Object[] objArr) {
        k.e(objArr, "<set-?>");
        this.array = objArr;
    }

    public final void setHashes$collection(int[] iArr) {
        k.e(iArr, "<set-?>");
        this.hashes = iArr;
    }

    public final void set_size$collection(int i2) {
        this._size = i2;
    }

    @Override // java.util.Collection, java.util.Set
    public final /* bridge */ int size() {
        return getSize();
    }

    @Override // java.util.Collection, java.util.Set
    public final Object[] toArray() {
        return j.j0(0, this._size, this.array);
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(get_size$collection() * 14);
        sb.append('{');
        int i2 = get_size$collection();
        for (int i8 = 0; i8 < i2; i8++) {
            if (i8 > 0) {
                sb.append(", ");
            }
            E eValueAt = valueAt(i8);
            if (eValueAt != this) {
                sb.append(eValueAt);
            } else {
                sb.append("(this Set)");
            }
        }
        return a.g('}', "StringBuilder(capacity).…builderAction).toString()", sb);
    }

    public final E valueAt(int i2) {
        return (E) getArray$collection()[i2];
    }

    public ArraySet(int i2) {
        this.hashes = ContainerHelpersKt.EMPTY_INTS;
        this.array = ContainerHelpersKt.EMPTY_OBJECTS;
        if (i2 > 0) {
            ArraySetKt.allocArrays(this, i2);
        }
    }

    @Override // java.util.Collection, java.util.Set
    public final <T> T[] toArray(T[] array) {
        k.e(array, "array");
        T[] tArr = (T[]) ArraySetJvmUtil.resizeForToArray(array, this._size);
        j.f0(this.array, 0, tArr, 0, this._size);
        return tArr;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean removeAll(Collection<? extends Object> elements) {
        k.e(elements, "elements");
        Iterator<? extends Object> it = elements.iterator();
        boolean zRemove = false;
        while (it.hasNext()) {
            zRemove |= remove(it.next());
        }
        return zRemove;
    }

    public /* synthetic */ ArraySet(int i2, int i8, f fVar) {
        this((i8 & 1) != 0 ? 0 : i2);
    }

    public ArraySet(ArraySet<? extends E> arraySet) {
        this(0);
        if (arraySet != null) {
            addAll((ArraySet) arraySet);
        }
    }

    public ArraySet(Collection<? extends E> collection) {
        this(0);
        if (collection != null) {
            addAll(collection);
        }
    }

    @Override // java.util.Collection, java.util.Set
    public boolean addAll(Collection<? extends E> elements) {
        k.e(elements, "elements");
        ensureCapacity(elements.size() + get_size$collection());
        Iterator<? extends E> it = elements.iterator();
        boolean zAdd = false;
        while (it.hasNext()) {
            zAdd |= add(it.next());
        }
        return zAdd;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ArraySet(E[] eArr) {
        this(0);
        if (eArr != null) {
            i iVarG = d0.g(eArr);
            while (iVarG.hasNext()) {
                add(iVarG.next());
            }
        }
    }
}
