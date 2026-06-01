package androidx.collection;

import androidx.camera.core.processing.util.a;
import androidx.collection.internal.ContainerHelpersKt;
import com.ironsource.G5;
import java.util.Arrays;
import kotlin.jvm.internal.k;
import r5.j;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class SparseArrayCompatKt {
    private static final Object DELETED = new Object();

    public static final <E> void commonAppend(SparseArrayCompat<E> sparseArrayCompat, int i2, E e) {
        k.e(sparseArrayCompat, "<this>");
        int i8 = sparseArrayCompat.size;
        if (i8 != 0 && i2 <= sparseArrayCompat.keys[i8 - 1]) {
            sparseArrayCompat.put(i2, e);
            return;
        }
        if (sparseArrayCompat.garbage && i8 >= sparseArrayCompat.keys.length) {
            gc(sparseArrayCompat);
        }
        int i9 = sparseArrayCompat.size;
        if (i9 >= sparseArrayCompat.keys.length) {
            int iIdealIntArraySize = ContainerHelpersKt.idealIntArraySize(i9 + 1);
            int[] iArrCopyOf = Arrays.copyOf(sparseArrayCompat.keys, iIdealIntArraySize);
            k.d(iArrCopyOf, "copyOf(this, newSize)");
            sparseArrayCompat.keys = iArrCopyOf;
            Object[] objArrCopyOf = Arrays.copyOf(sparseArrayCompat.values, iIdealIntArraySize);
            k.d(objArrCopyOf, "copyOf(this, newSize)");
            sparseArrayCompat.values = objArrCopyOf;
        }
        sparseArrayCompat.keys[i9] = i2;
        sparseArrayCompat.values[i9] = e;
        sparseArrayCompat.size = i9 + 1;
    }

    public static final <E> void commonClear(SparseArrayCompat<E> sparseArrayCompat) {
        k.e(sparseArrayCompat, "<this>");
        int i2 = sparseArrayCompat.size;
        Object[] objArr = sparseArrayCompat.values;
        for (int i8 = 0; i8 < i2; i8++) {
            objArr[i8] = null;
        }
        sparseArrayCompat.size = 0;
        sparseArrayCompat.garbage = false;
    }

    public static final <E> boolean commonContainsKey(SparseArrayCompat<E> sparseArrayCompat, int i2) {
        k.e(sparseArrayCompat, "<this>");
        return sparseArrayCompat.indexOfKey(i2) >= 0;
    }

    public static final <E> boolean commonContainsValue(SparseArrayCompat<E> sparseArrayCompat, E e) {
        k.e(sparseArrayCompat, "<this>");
        if (sparseArrayCompat.garbage) {
            gc(sparseArrayCompat);
        }
        int i2 = sparseArrayCompat.size;
        int i8 = 0;
        while (true) {
            if (i8 >= i2) {
                i8 = -1;
                break;
            }
            if (sparseArrayCompat.values[i8] == e) {
                break;
            }
            i8++;
        }
        return i8 >= 0;
    }

    public static final <E> E commonGet(SparseArrayCompat<E> sparseArrayCompat, int i2) {
        E e;
        k.e(sparseArrayCompat, "<this>");
        int iBinarySearch = ContainerHelpersKt.binarySearch(sparseArrayCompat.keys, sparseArrayCompat.size, i2);
        if (iBinarySearch < 0 || (e = (E) sparseArrayCompat.values[iBinarySearch]) == DELETED) {
            return null;
        }
        return e;
    }

    public static final <E> int commonIndexOfKey(SparseArrayCompat<E> sparseArrayCompat, int i2) {
        k.e(sparseArrayCompat, "<this>");
        if (sparseArrayCompat.garbage) {
            gc(sparseArrayCompat);
        }
        return ContainerHelpersKt.binarySearch(sparseArrayCompat.keys, sparseArrayCompat.size, i2);
    }

    public static final <E> int commonIndexOfValue(SparseArrayCompat<E> sparseArrayCompat, E e) {
        k.e(sparseArrayCompat, "<this>");
        if (sparseArrayCompat.garbage) {
            gc(sparseArrayCompat);
        }
        int i2 = sparseArrayCompat.size;
        for (int i8 = 0; i8 < i2; i8++) {
            if (sparseArrayCompat.values[i8] == e) {
                return i8;
            }
        }
        return -1;
    }

    public static final <E> boolean commonIsEmpty(SparseArrayCompat<E> sparseArrayCompat) {
        k.e(sparseArrayCompat, "<this>");
        return sparseArrayCompat.size() == 0;
    }

    public static final <E> int commonKeyAt(SparseArrayCompat<E> sparseArrayCompat, int i2) {
        k.e(sparseArrayCompat, "<this>");
        if (sparseArrayCompat.garbage) {
            gc(sparseArrayCompat);
        }
        return sparseArrayCompat.keys[i2];
    }

    public static final <E> void commonPut(SparseArrayCompat<E> sparseArrayCompat, int i2, E e) {
        k.e(sparseArrayCompat, "<this>");
        int iBinarySearch = ContainerHelpersKt.binarySearch(sparseArrayCompat.keys, sparseArrayCompat.size, i2);
        if (iBinarySearch >= 0) {
            sparseArrayCompat.values[iBinarySearch] = e;
            return;
        }
        int i8 = ~iBinarySearch;
        if (i8 < sparseArrayCompat.size && sparseArrayCompat.values[i8] == DELETED) {
            sparseArrayCompat.keys[i8] = i2;
            sparseArrayCompat.values[i8] = e;
            return;
        }
        if (sparseArrayCompat.garbage && sparseArrayCompat.size >= sparseArrayCompat.keys.length) {
            gc(sparseArrayCompat);
            i8 = ~ContainerHelpersKt.binarySearch(sparseArrayCompat.keys, sparseArrayCompat.size, i2);
        }
        int i9 = sparseArrayCompat.size;
        if (i9 >= sparseArrayCompat.keys.length) {
            int iIdealIntArraySize = ContainerHelpersKt.idealIntArraySize(i9 + 1);
            int[] iArrCopyOf = Arrays.copyOf(sparseArrayCompat.keys, iIdealIntArraySize);
            k.d(iArrCopyOf, "copyOf(this, newSize)");
            sparseArrayCompat.keys = iArrCopyOf;
            Object[] objArrCopyOf = Arrays.copyOf(sparseArrayCompat.values, iIdealIntArraySize);
            k.d(objArrCopyOf, "copyOf(this, newSize)");
            sparseArrayCompat.values = objArrCopyOf;
        }
        int i10 = sparseArrayCompat.size;
        if (i10 - i8 != 0) {
            int[] iArr = sparseArrayCompat.keys;
            int i11 = i8 + 1;
            j.c0(i11, i8, i10, iArr, iArr);
            Object[] objArr = sparseArrayCompat.values;
            j.f0(objArr, i11, objArr, i8, sparseArrayCompat.size);
        }
        sparseArrayCompat.keys[i8] = i2;
        sparseArrayCompat.values[i8] = e;
        sparseArrayCompat.size++;
    }

    public static final <E> void commonPutAll(SparseArrayCompat<E> sparseArrayCompat, SparseArrayCompat<? extends E> other) {
        k.e(sparseArrayCompat, "<this>");
        k.e(other, "other");
        int size = other.size();
        for (int i2 = 0; i2 < size; i2++) {
            int iKeyAt = other.keyAt(i2);
            E eValueAt = other.valueAt(i2);
            int iBinarySearch = ContainerHelpersKt.binarySearch(sparseArrayCompat.keys, sparseArrayCompat.size, iKeyAt);
            if (iBinarySearch >= 0) {
                sparseArrayCompat.values[iBinarySearch] = eValueAt;
            } else {
                int i8 = ~iBinarySearch;
                if (i8 >= sparseArrayCompat.size || sparseArrayCompat.values[i8] != DELETED) {
                    if (sparseArrayCompat.garbage && sparseArrayCompat.size >= sparseArrayCompat.keys.length) {
                        gc(sparseArrayCompat);
                        i8 = ~ContainerHelpersKt.binarySearch(sparseArrayCompat.keys, sparseArrayCompat.size, iKeyAt);
                    }
                    int i9 = sparseArrayCompat.size;
                    if (i9 >= sparseArrayCompat.keys.length) {
                        int iIdealIntArraySize = ContainerHelpersKt.idealIntArraySize(i9 + 1);
                        int[] iArrCopyOf = Arrays.copyOf(sparseArrayCompat.keys, iIdealIntArraySize);
                        k.d(iArrCopyOf, "copyOf(this, newSize)");
                        sparseArrayCompat.keys = iArrCopyOf;
                        Object[] objArrCopyOf = Arrays.copyOf(sparseArrayCompat.values, iIdealIntArraySize);
                        k.d(objArrCopyOf, "copyOf(this, newSize)");
                        sparseArrayCompat.values = objArrCopyOf;
                    }
                    int i10 = sparseArrayCompat.size;
                    if (i10 - i8 != 0) {
                        int[] iArr = sparseArrayCompat.keys;
                        int i11 = i8 + 1;
                        j.c0(i11, i8, i10, iArr, iArr);
                        Object[] objArr = sparseArrayCompat.values;
                        j.f0(objArr, i11, objArr, i8, sparseArrayCompat.size);
                    }
                    sparseArrayCompat.keys[i8] = iKeyAt;
                    sparseArrayCompat.values[i8] = eValueAt;
                    sparseArrayCompat.size++;
                } else {
                    sparseArrayCompat.keys[i8] = iKeyAt;
                    sparseArrayCompat.values[i8] = eValueAt;
                }
            }
        }
    }

    public static final <E> E commonPutIfAbsent(SparseArrayCompat<E> sparseArrayCompat, int i2, E e) {
        k.e(sparseArrayCompat, "<this>");
        E e4 = (E) commonGet(sparseArrayCompat, i2);
        if (e4 == null) {
            int iBinarySearch = ContainerHelpersKt.binarySearch(sparseArrayCompat.keys, sparseArrayCompat.size, i2);
            if (iBinarySearch >= 0) {
                sparseArrayCompat.values[iBinarySearch] = e;
                return e4;
            }
            int i8 = ~iBinarySearch;
            if (i8 < sparseArrayCompat.size && sparseArrayCompat.values[i8] == DELETED) {
                sparseArrayCompat.keys[i8] = i2;
                sparseArrayCompat.values[i8] = e;
                return e4;
            }
            if (sparseArrayCompat.garbage && sparseArrayCompat.size >= sparseArrayCompat.keys.length) {
                gc(sparseArrayCompat);
                i8 = ~ContainerHelpersKt.binarySearch(sparseArrayCompat.keys, sparseArrayCompat.size, i2);
            }
            int i9 = sparseArrayCompat.size;
            if (i9 >= sparseArrayCompat.keys.length) {
                int iIdealIntArraySize = ContainerHelpersKt.idealIntArraySize(i9 + 1);
                int[] iArrCopyOf = Arrays.copyOf(sparseArrayCompat.keys, iIdealIntArraySize);
                k.d(iArrCopyOf, "copyOf(this, newSize)");
                sparseArrayCompat.keys = iArrCopyOf;
                Object[] objArrCopyOf = Arrays.copyOf(sparseArrayCompat.values, iIdealIntArraySize);
                k.d(objArrCopyOf, "copyOf(this, newSize)");
                sparseArrayCompat.values = objArrCopyOf;
            }
            int i10 = sparseArrayCompat.size;
            if (i10 - i8 != 0) {
                int[] iArr = sparseArrayCompat.keys;
                int i11 = i8 + 1;
                j.c0(i11, i8, i10, iArr, iArr);
                Object[] objArr = sparseArrayCompat.values;
                j.f0(objArr, i11, objArr, i8, sparseArrayCompat.size);
            }
            sparseArrayCompat.keys[i8] = i2;
            sparseArrayCompat.values[i8] = e;
            sparseArrayCompat.size++;
        }
        return e4;
    }

    public static final <E> void commonRemove(SparseArrayCompat<E> sparseArrayCompat, int i2) {
        k.e(sparseArrayCompat, "<this>");
        int iBinarySearch = ContainerHelpersKt.binarySearch(sparseArrayCompat.keys, sparseArrayCompat.size, i2);
        if (iBinarySearch >= 0) {
            Object[] objArr = sparseArrayCompat.values;
            Object obj = objArr[iBinarySearch];
            Object obj2 = DELETED;
            if (obj != obj2) {
                objArr[iBinarySearch] = obj2;
                sparseArrayCompat.garbage = true;
            }
        }
    }

    public static final <E> void commonRemoveAt(SparseArrayCompat<E> sparseArrayCompat, int i2) {
        k.e(sparseArrayCompat, "<this>");
        if (sparseArrayCompat.values[i2] != DELETED) {
            sparseArrayCompat.values[i2] = DELETED;
            sparseArrayCompat.garbage = true;
        }
    }

    public static final <E> void commonRemoveAtRange(SparseArrayCompat<E> sparseArrayCompat, int i2, int i8) {
        k.e(sparseArrayCompat, "<this>");
        int iMin = Math.min(i8, i2 + i8);
        while (i2 < iMin) {
            sparseArrayCompat.removeAt(i2);
            i2++;
        }
    }

    public static final <E> E commonReplace(SparseArrayCompat<E> sparseArrayCompat, int i2, E e) {
        k.e(sparseArrayCompat, "<this>");
        int iIndexOfKey = sparseArrayCompat.indexOfKey(i2);
        if (iIndexOfKey < 0) {
            return null;
        }
        Object[] objArr = sparseArrayCompat.values;
        E e4 = (E) objArr[iIndexOfKey];
        objArr[iIndexOfKey] = e;
        return e4;
    }

    public static final <E> void commonSetValueAt(SparseArrayCompat<E> sparseArrayCompat, int i2, E e) {
        k.e(sparseArrayCompat, "<this>");
        if (sparseArrayCompat.garbage) {
            gc(sparseArrayCompat);
        }
        sparseArrayCompat.values[i2] = e;
    }

    public static final <E> int commonSize(SparseArrayCompat<E> sparseArrayCompat) {
        k.e(sparseArrayCompat, "<this>");
        if (sparseArrayCompat.garbage) {
            gc(sparseArrayCompat);
        }
        return sparseArrayCompat.size;
    }

    public static final <E> String commonToString(SparseArrayCompat<E> sparseArrayCompat) {
        k.e(sparseArrayCompat, "<this>");
        if (sparseArrayCompat.size() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(sparseArrayCompat.size * 28);
        sb.append('{');
        int i2 = sparseArrayCompat.size;
        for (int i8 = 0; i8 < i2; i8++) {
            if (i8 > 0) {
                sb.append(", ");
            }
            sb.append(sparseArrayCompat.keyAt(i8));
            sb.append(G5.T);
            E eValueAt = sparseArrayCompat.valueAt(i8);
            if (eValueAt != sparseArrayCompat) {
                sb.append(eValueAt);
            } else {
                sb.append("(this Map)");
            }
        }
        return a.g('}', "buffer.toString()", sb);
    }

    public static final <E> E commonValueAt(SparseArrayCompat<E> sparseArrayCompat, int i2) {
        k.e(sparseArrayCompat, "<this>");
        if (sparseArrayCompat.garbage) {
            gc(sparseArrayCompat);
        }
        return (E) sparseArrayCompat.values[i2];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <E> void gc(SparseArrayCompat<E> sparseArrayCompat) {
        int i2 = sparseArrayCompat.size;
        int[] iArr = sparseArrayCompat.keys;
        Object[] objArr = sparseArrayCompat.values;
        int i8 = 0;
        for (int i9 = 0; i9 < i2; i9++) {
            Object obj = objArr[i9];
            if (obj != DELETED) {
                if (i9 != i8) {
                    iArr[i8] = iArr[i9];
                    objArr[i8] = obj;
                    objArr[i9] = null;
                }
                i8++;
            }
        }
        sparseArrayCompat.garbage = false;
        sparseArrayCompat.size = i8;
    }

    private static final <E, T extends E> T internalGet(SparseArrayCompat<E> sparseArrayCompat, int i2, T t3) {
        T t7;
        int iBinarySearch = ContainerHelpersKt.binarySearch(sparseArrayCompat.keys, sparseArrayCompat.size, i2);
        return (iBinarySearch < 0 || (t7 = (T) sparseArrayCompat.values[iBinarySearch]) == DELETED) ? t3 : t7;
    }

    public static final <E> E commonGet(SparseArrayCompat<E> sparseArrayCompat, int i2, E e) {
        E e4;
        k.e(sparseArrayCompat, "<this>");
        int iBinarySearch = ContainerHelpersKt.binarySearch(sparseArrayCompat.keys, sparseArrayCompat.size, i2);
        return (iBinarySearch < 0 || (e4 = (E) sparseArrayCompat.values[iBinarySearch]) == DELETED) ? e : e4;
    }

    public static final <E> boolean commonReplace(SparseArrayCompat<E> sparseArrayCompat, int i2, E e, E e4) {
        k.e(sparseArrayCompat, "<this>");
        int iIndexOfKey = sparseArrayCompat.indexOfKey(i2);
        if (iIndexOfKey < 0 || !k.a(sparseArrayCompat.values[iIndexOfKey], e)) {
            return false;
        }
        sparseArrayCompat.values[iIndexOfKey] = e4;
        return true;
    }

    public static final <E> boolean commonRemove(SparseArrayCompat<E> sparseArrayCompat, int i2, Object obj) {
        k.e(sparseArrayCompat, "<this>");
        int iIndexOfKey = sparseArrayCompat.indexOfKey(i2);
        if (iIndexOfKey < 0 || !k.a(obj, sparseArrayCompat.valueAt(iIndexOfKey))) {
            return false;
        }
        sparseArrayCompat.removeAt(iIndexOfKey);
        return true;
    }
}
