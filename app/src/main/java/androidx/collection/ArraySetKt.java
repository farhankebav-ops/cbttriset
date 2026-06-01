package androidx.collection;

import androidx.camera.core.processing.util.a;
import androidx.collection.internal.ContainerHelpersKt;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Set;
import kotlin.jvm.internal.k;
import r5.j;
import r5.l;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class ArraySetKt {
    public static final int ARRAY_SET_BASE_SIZE = 4;

    public static final <E> void addAllInternal(ArraySet<E> arraySet, ArraySet<? extends E> array) {
        k.e(arraySet, "<this>");
        k.e(array, "array");
        int i2 = array.get_size$collection();
        arraySet.ensureCapacity(arraySet.get_size$collection() + i2);
        if (arraySet.get_size$collection() != 0) {
            for (int i8 = 0; i8 < i2; i8++) {
                arraySet.add(array.valueAt(i8));
            }
        } else if (i2 > 0) {
            j.g0(0, i2, 6, array.getHashes$collection(), arraySet.getHashes$collection());
            j.h0(array.getArray$collection(), arraySet.getArray$collection(), 0, 0, i2, 6);
            if (arraySet.get_size$collection() != 0) {
                throw new ConcurrentModificationException();
            }
            arraySet.set_size$collection(i2);
        }
    }

    public static final <E> boolean addInternal(ArraySet<E> arraySet, E e) {
        int i2;
        int iIndexOf;
        k.e(arraySet, "<this>");
        int i8 = arraySet.get_size$collection();
        if (e == null) {
            iIndexOf = indexOfNull(arraySet);
            i2 = 0;
        } else {
            int iHashCode = e.hashCode();
            i2 = iHashCode;
            iIndexOf = indexOf(arraySet, e, iHashCode);
        }
        if (iIndexOf >= 0) {
            return false;
        }
        int i9 = ~iIndexOf;
        if (i8 >= arraySet.getHashes$collection().length) {
            int i10 = 8;
            if (i8 >= 8) {
                i10 = (i8 >> 1) + i8;
            } else if (i8 < 4) {
                i10 = 4;
            }
            int[] hashes$collection = arraySet.getHashes$collection();
            Object[] array$collection = arraySet.getArray$collection();
            allocArrays(arraySet, i10);
            if (i8 != arraySet.get_size$collection()) {
                throw new ConcurrentModificationException();
            }
            if (arraySet.getHashes$collection().length != 0) {
                j.g0(0, hashes$collection.length, 6, hashes$collection, arraySet.getHashes$collection());
                j.h0(array$collection, arraySet.getArray$collection(), 0, 0, array$collection.length, 6);
            }
        }
        if (i9 < i8) {
            int i11 = i9 + 1;
            j.c0(i11, i9, i8, arraySet.getHashes$collection(), arraySet.getHashes$collection());
            j.f0(arraySet.getArray$collection(), i11, arraySet.getArray$collection(), i9, i8);
        }
        if (i8 != arraySet.get_size$collection() || i9 >= arraySet.getHashes$collection().length) {
            throw new ConcurrentModificationException();
        }
        arraySet.getHashes$collection()[i9] = i2;
        arraySet.getArray$collection()[i9] = e;
        arraySet.set_size$collection(arraySet.get_size$collection() + 1);
        return true;
    }

    public static final <E> void allocArrays(ArraySet<E> arraySet, int i2) {
        k.e(arraySet, "<this>");
        arraySet.setHashes$collection(new int[i2]);
        arraySet.setArray$collection(new Object[i2]);
    }

    public static final <T> ArraySet<T> arraySetOf() {
        return new ArraySet<>(0, 1, null);
    }

    public static final <E> int binarySearchInternal(ArraySet<E> arraySet, int i2) {
        k.e(arraySet, "<this>");
        try {
            return ContainerHelpersKt.binarySearch(arraySet.getHashes$collection(), arraySet.get_size$collection(), i2);
        } catch (IndexOutOfBoundsException unused) {
            throw new ConcurrentModificationException();
        }
    }

    public static final <E> void clearInternal(ArraySet<E> arraySet) {
        k.e(arraySet, "<this>");
        if (arraySet.get_size$collection() != 0) {
            arraySet.setHashes$collection(ContainerHelpersKt.EMPTY_INTS);
            arraySet.setArray$collection(ContainerHelpersKt.EMPTY_OBJECTS);
            arraySet.set_size$collection(0);
        }
        if (arraySet.get_size$collection() != 0) {
            throw new ConcurrentModificationException();
        }
    }

    public static final <E> boolean containsAllInternal(ArraySet<E> arraySet, Collection<? extends E> elements) {
        k.e(arraySet, "<this>");
        k.e(elements, "elements");
        Iterator<? extends E> it = elements.iterator();
        while (it.hasNext()) {
            if (!arraySet.contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    public static final <E> boolean containsInternal(ArraySet<E> arraySet, E e) {
        k.e(arraySet, "<this>");
        return arraySet.indexOf(e) >= 0;
    }

    public static final <E> void ensureCapacityInternal(ArraySet<E> arraySet, int i2) {
        k.e(arraySet, "<this>");
        int i8 = arraySet.get_size$collection();
        if (arraySet.getHashes$collection().length < i2) {
            int[] hashes$collection = arraySet.getHashes$collection();
            Object[] array$collection = arraySet.getArray$collection();
            allocArrays(arraySet, i2);
            if (arraySet.get_size$collection() > 0) {
                j.g0(0, arraySet.get_size$collection(), 6, hashes$collection, arraySet.getHashes$collection());
                j.h0(array$collection, arraySet.getArray$collection(), 0, 0, arraySet.get_size$collection(), 6);
            }
        }
        if (arraySet.get_size$collection() != i8) {
            throw new ConcurrentModificationException();
        }
    }

    public static final <E> boolean equalsInternal(ArraySet<E> arraySet, Object obj) {
        k.e(arraySet, "<this>");
        if (arraySet == obj) {
            return true;
        }
        if (!(obj instanceof Set) || arraySet.size() != ((Set) obj).size()) {
            return false;
        }
        try {
            int i2 = arraySet.get_size$collection();
            for (int i8 = 0; i8 < i2; i8++) {
                if (!((Set) obj).contains(arraySet.valueAt(i8))) {
                    return false;
                }
            }
            return true;
        } catch (ClassCastException | NullPointerException unused) {
            return false;
        }
    }

    public static final <E> int hashCodeInternal(ArraySet<E> arraySet) {
        k.e(arraySet, "<this>");
        int[] hashes$collection = arraySet.getHashes$collection();
        int i2 = arraySet.get_size$collection();
        int i8 = 0;
        for (int i9 = 0; i9 < i2; i9++) {
            i8 += hashes$collection[i9];
        }
        return i8;
    }

    public static final <E> int indexOf(ArraySet<E> arraySet, Object obj, int i2) {
        k.e(arraySet, "<this>");
        int i8 = arraySet.get_size$collection();
        if (i8 == 0) {
            return -1;
        }
        int iBinarySearchInternal = binarySearchInternal(arraySet, i2);
        if (iBinarySearchInternal < 0 || k.a(obj, arraySet.getArray$collection()[iBinarySearchInternal])) {
            return iBinarySearchInternal;
        }
        int i9 = iBinarySearchInternal + 1;
        while (i9 < i8 && arraySet.getHashes$collection()[i9] == i2) {
            if (k.a(obj, arraySet.getArray$collection()[i9])) {
                return i9;
            }
            i9++;
        }
        for (int i10 = iBinarySearchInternal - 1; i10 >= 0 && arraySet.getHashes$collection()[i10] == i2; i10--) {
            if (k.a(obj, arraySet.getArray$collection()[i10])) {
                return i10;
            }
        }
        return ~i9;
    }

    public static final <E> int indexOfInternal(ArraySet<E> arraySet, Object obj) {
        k.e(arraySet, "<this>");
        return obj == null ? indexOfNull(arraySet) : indexOf(arraySet, obj, obj.hashCode());
    }

    public static final <E> int indexOfNull(ArraySet<E> arraySet) {
        k.e(arraySet, "<this>");
        return indexOf(arraySet, null, 0);
    }

    public static final <E> boolean isEmptyInternal(ArraySet<E> arraySet) {
        k.e(arraySet, "<this>");
        return arraySet.get_size$collection() <= 0;
    }

    public static final <E> boolean removeAllInternal(ArraySet<E> arraySet, ArraySet<? extends E> array) {
        k.e(arraySet, "<this>");
        k.e(array, "array");
        int i2 = array.get_size$collection();
        int i8 = arraySet.get_size$collection();
        for (int i9 = 0; i9 < i2; i9++) {
            arraySet.remove(array.valueAt(i9));
        }
        return i8 != arraySet.get_size$collection();
    }

    public static final <E> E removeAtInternal(ArraySet<E> arraySet, int i2) {
        int i8;
        k.e(arraySet, "<this>");
        int i9 = arraySet.get_size$collection();
        E e = (E) arraySet.getArray$collection()[i2];
        if (i9 <= 1) {
            arraySet.clear();
            return e;
        }
        int i10 = i9 - 1;
        if (arraySet.getHashes$collection().length <= 8 || arraySet.get_size$collection() >= arraySet.getHashes$collection().length / 3) {
            if (i2 < i10) {
                int i11 = i2 + 1;
                j.c0(i2, i11, i9, arraySet.getHashes$collection(), arraySet.getHashes$collection());
                j.f0(arraySet.getArray$collection(), i2, arraySet.getArray$collection(), i11, i9);
            }
            arraySet.getArray$collection()[i10] = null;
        } else {
            int i12 = arraySet.get_size$collection() > 8 ? arraySet.get_size$collection() + (arraySet.get_size$collection() >> 1) : 8;
            int[] hashes$collection = arraySet.getHashes$collection();
            Object[] array$collection = arraySet.getArray$collection();
            allocArrays(arraySet, i12);
            if (i2 > 0) {
                j.g0(0, i2, 6, hashes$collection, arraySet.getHashes$collection());
                i8 = i2;
                j.h0(array$collection, arraySet.getArray$collection(), 0, 0, i8, 6);
            } else {
                i8 = i2;
            }
            if (i8 < i10) {
                int i13 = i8 + 1;
                j.c0(i8, i13, i9, hashes$collection, arraySet.getHashes$collection());
                j.f0(array$collection, i8, arraySet.getArray$collection(), i13, i9);
            }
        }
        if (i9 != arraySet.get_size$collection()) {
            throw new ConcurrentModificationException();
        }
        arraySet.set_size$collection(i10);
        return e;
    }

    public static final <E> boolean removeInternal(ArraySet<E> arraySet, E e) {
        k.e(arraySet, "<this>");
        int iIndexOf = arraySet.indexOf(e);
        if (iIndexOf < 0) {
            return false;
        }
        arraySet.removeAt(iIndexOf);
        return true;
    }

    public static final <E> boolean retainAllInternal(ArraySet<E> arraySet, Collection<? extends E> elements) {
        k.e(arraySet, "<this>");
        k.e(elements, "elements");
        boolean z2 = false;
        for (int i2 = arraySet.get_size$collection() - 1; -1 < i2; i2--) {
            if (!l.T0(elements, arraySet.getArray$collection()[i2])) {
                arraySet.removeAt(i2);
                z2 = true;
            }
        }
        return z2;
    }

    public static final <E> String toStringInternal(ArraySet<E> arraySet) {
        k.e(arraySet, "<this>");
        if (arraySet.isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(arraySet.get_size$collection() * 14);
        sb.append('{');
        int i2 = arraySet.get_size$collection();
        for (int i8 = 0; i8 < i2; i8++) {
            if (i8 > 0) {
                sb.append(", ");
            }
            E eValueAt = arraySet.valueAt(i8);
            if (eValueAt != arraySet) {
                sb.append(eValueAt);
            } else {
                sb.append("(this Set)");
            }
        }
        return a.g('}', "StringBuilder(capacity).…builderAction).toString()", sb);
    }

    public static final <E> E valueAtInternal(ArraySet<E> arraySet, int i2) {
        k.e(arraySet, "<this>");
        return (E) arraySet.getArray$collection()[i2];
    }

    public static final <T> ArraySet<T> arraySetOf(T... values) {
        k.e(values, "values");
        ArraySet<T> arraySet = new ArraySet<>(values.length);
        for (T t3 : values) {
            arraySet.add(t3);
        }
        return arraySet;
    }

    public static final <E> boolean removeAllInternal(ArraySet<E> arraySet, Collection<? extends E> elements) {
        k.e(arraySet, "<this>");
        k.e(elements, "elements");
        Iterator<? extends E> it = elements.iterator();
        boolean zRemove = false;
        while (it.hasNext()) {
            zRemove |= arraySet.remove(it.next());
        }
        return zRemove;
    }

    public static final <E> boolean addAllInternal(ArraySet<E> arraySet, Collection<? extends E> elements) {
        k.e(arraySet, "<this>");
        k.e(elements, "elements");
        arraySet.ensureCapacity(elements.size() + arraySet.get_size$collection());
        Iterator<? extends E> it = elements.iterator();
        boolean zAdd = false;
        while (it.hasNext()) {
            zAdd |= arraySet.add(it.next());
        }
        return zAdd;
    }
}
