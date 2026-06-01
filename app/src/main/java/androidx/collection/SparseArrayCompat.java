package androidx.collection;

import androidx.camera.core.processing.util.a;
import androidx.collection.internal.ContainerHelpersKt;
import com.ironsource.G5;
import java.util.Arrays;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import r5.j;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public class SparseArrayCompat<E> implements Cloneable {
    public /* synthetic */ boolean garbage;
    public /* synthetic */ int[] keys;
    public /* synthetic */ int size;
    public /* synthetic */ Object[] values;

    public SparseArrayCompat() {
        this(0, 1, null);
    }

    public void append(int i2, E e) {
        int i8 = this.size;
        if (i8 != 0 && i2 <= this.keys[i8 - 1]) {
            put(i2, e);
            return;
        }
        if (this.garbage && i8 >= this.keys.length) {
            SparseArrayCompatKt.gc(this);
        }
        int i9 = this.size;
        if (i9 >= this.keys.length) {
            int iIdealIntArraySize = ContainerHelpersKt.idealIntArraySize(i9 + 1);
            int[] iArrCopyOf = Arrays.copyOf(this.keys, iIdealIntArraySize);
            k.d(iArrCopyOf, "copyOf(this, newSize)");
            this.keys = iArrCopyOf;
            Object[] objArrCopyOf = Arrays.copyOf(this.values, iIdealIntArraySize);
            k.d(objArrCopyOf, "copyOf(this, newSize)");
            this.values = objArrCopyOf;
        }
        this.keys[i9] = i2;
        this.values[i9] = e;
        this.size = i9 + 1;
    }

    public void clear() {
        int i2 = this.size;
        Object[] objArr = this.values;
        for (int i8 = 0; i8 < i2; i8++) {
            objArr[i8] = null;
        }
        this.size = 0;
        this.garbage = false;
    }

    public boolean containsKey(int i2) {
        return indexOfKey(i2) >= 0;
    }

    public boolean containsValue(E e) {
        if (this.garbage) {
            SparseArrayCompatKt.gc(this);
        }
        int i2 = this.size;
        int i8 = 0;
        while (true) {
            if (i8 >= i2) {
                i8 = -1;
                break;
            }
            if (this.values[i8] == e) {
                break;
            }
            i8++;
        }
        return i8 >= 0;
    }

    public void delete(int i2) {
        remove(i2);
    }

    public E get(int i2) {
        return (E) SparseArrayCompatKt.commonGet(this, i2);
    }

    public final boolean getIsEmpty() {
        return isEmpty();
    }

    public int indexOfKey(int i2) {
        if (this.garbage) {
            SparseArrayCompatKt.gc(this);
        }
        return ContainerHelpersKt.binarySearch(this.keys, this.size, i2);
    }

    public int indexOfValue(E e) {
        if (this.garbage) {
            SparseArrayCompatKt.gc(this);
        }
        int i2 = this.size;
        for (int i8 = 0; i8 < i2; i8++) {
            if (this.values[i8] == e) {
                return i8;
            }
        }
        return -1;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public int keyAt(int i2) {
        if (this.garbage) {
            SparseArrayCompatKt.gc(this);
        }
        return this.keys[i2];
    }

    public void put(int i2, E e) {
        int iBinarySearch = ContainerHelpersKt.binarySearch(this.keys, this.size, i2);
        if (iBinarySearch >= 0) {
            this.values[iBinarySearch] = e;
            return;
        }
        int i8 = ~iBinarySearch;
        if (i8 < this.size && this.values[i8] == SparseArrayCompatKt.DELETED) {
            this.keys[i8] = i2;
            this.values[i8] = e;
            return;
        }
        if (this.garbage && this.size >= this.keys.length) {
            SparseArrayCompatKt.gc(this);
            i8 = ~ContainerHelpersKt.binarySearch(this.keys, this.size, i2);
        }
        int i9 = this.size;
        if (i9 >= this.keys.length) {
            int iIdealIntArraySize = ContainerHelpersKt.idealIntArraySize(i9 + 1);
            int[] iArrCopyOf = Arrays.copyOf(this.keys, iIdealIntArraySize);
            k.d(iArrCopyOf, "copyOf(this, newSize)");
            this.keys = iArrCopyOf;
            Object[] objArrCopyOf = Arrays.copyOf(this.values, iIdealIntArraySize);
            k.d(objArrCopyOf, "copyOf(this, newSize)");
            this.values = objArrCopyOf;
        }
        int i10 = this.size;
        if (i10 - i8 != 0) {
            int[] iArr = this.keys;
            int i11 = i8 + 1;
            j.c0(i11, i8, i10, iArr, iArr);
            Object[] objArr = this.values;
            j.f0(objArr, i11, objArr, i8, this.size);
        }
        this.keys[i8] = i2;
        this.values[i8] = e;
        this.size++;
    }

    public void putAll(SparseArrayCompat<? extends E> other) {
        k.e(other, "other");
        int size = other.size();
        for (int i2 = 0; i2 < size; i2++) {
            int iKeyAt = other.keyAt(i2);
            E eValueAt = other.valueAt(i2);
            int iBinarySearch = ContainerHelpersKt.binarySearch(this.keys, this.size, iKeyAt);
            if (iBinarySearch >= 0) {
                this.values[iBinarySearch] = eValueAt;
            } else {
                int i8 = ~iBinarySearch;
                if (i8 >= this.size || this.values[i8] != SparseArrayCompatKt.DELETED) {
                    if (this.garbage && this.size >= this.keys.length) {
                        SparseArrayCompatKt.gc(this);
                        i8 = ~ContainerHelpersKt.binarySearch(this.keys, this.size, iKeyAt);
                    }
                    int i9 = this.size;
                    if (i9 >= this.keys.length) {
                        int iIdealIntArraySize = ContainerHelpersKt.idealIntArraySize(i9 + 1);
                        int[] iArrCopyOf = Arrays.copyOf(this.keys, iIdealIntArraySize);
                        k.d(iArrCopyOf, "copyOf(this, newSize)");
                        this.keys = iArrCopyOf;
                        Object[] objArrCopyOf = Arrays.copyOf(this.values, iIdealIntArraySize);
                        k.d(objArrCopyOf, "copyOf(this, newSize)");
                        this.values = objArrCopyOf;
                    }
                    int i10 = this.size;
                    if (i10 - i8 != 0) {
                        int[] iArr = this.keys;
                        int i11 = i8 + 1;
                        j.c0(i11, i8, i10, iArr, iArr);
                        Object[] objArr = this.values;
                        j.f0(objArr, i11, objArr, i8, this.size);
                    }
                    this.keys[i8] = iKeyAt;
                    this.values[i8] = eValueAt;
                    this.size++;
                } else {
                    this.keys[i8] = iKeyAt;
                    this.values[i8] = eValueAt;
                }
            }
        }
    }

    public E putIfAbsent(int i2, E e) {
        E e4 = (E) SparseArrayCompatKt.commonGet(this, i2);
        if (e4 == null) {
            int iBinarySearch = ContainerHelpersKt.binarySearch(this.keys, this.size, i2);
            if (iBinarySearch >= 0) {
                this.values[iBinarySearch] = e;
                return e4;
            }
            int i8 = ~iBinarySearch;
            if (i8 < this.size && this.values[i8] == SparseArrayCompatKt.DELETED) {
                this.keys[i8] = i2;
                this.values[i8] = e;
                return e4;
            }
            if (this.garbage && this.size >= this.keys.length) {
                SparseArrayCompatKt.gc(this);
                i8 = ~ContainerHelpersKt.binarySearch(this.keys, this.size, i2);
            }
            int i9 = this.size;
            if (i9 >= this.keys.length) {
                int iIdealIntArraySize = ContainerHelpersKt.idealIntArraySize(i9 + 1);
                int[] iArrCopyOf = Arrays.copyOf(this.keys, iIdealIntArraySize);
                k.d(iArrCopyOf, "copyOf(this, newSize)");
                this.keys = iArrCopyOf;
                Object[] objArrCopyOf = Arrays.copyOf(this.values, iIdealIntArraySize);
                k.d(objArrCopyOf, "copyOf(this, newSize)");
                this.values = objArrCopyOf;
            }
            int i10 = this.size;
            if (i10 - i8 != 0) {
                int[] iArr = this.keys;
                int i11 = i8 + 1;
                j.c0(i11, i8, i10, iArr, iArr);
                Object[] objArr = this.values;
                j.f0(objArr, i11, objArr, i8, this.size);
            }
            this.keys[i8] = i2;
            this.values[i8] = e;
            this.size++;
        }
        return e4;
    }

    public void remove(int i2) {
        SparseArrayCompatKt.commonRemove(this, i2);
    }

    public void removeAt(int i2) {
        if (this.values[i2] != SparseArrayCompatKt.DELETED) {
            this.values[i2] = SparseArrayCompatKt.DELETED;
            this.garbage = true;
        }
    }

    public void removeAtRange(int i2, int i8) {
        int iMin = Math.min(i8, i2 + i8);
        while (i2 < iMin) {
            removeAt(i2);
            i2++;
        }
    }

    public E replace(int i2, E e) {
        int iIndexOfKey = indexOfKey(i2);
        if (iIndexOfKey < 0) {
            return null;
        }
        Object[] objArr = this.values;
        E e4 = (E) objArr[iIndexOfKey];
        objArr[iIndexOfKey] = e;
        return e4;
    }

    public void setValueAt(int i2, E e) {
        if (this.garbage) {
            SparseArrayCompatKt.gc(this);
        }
        this.values[i2] = e;
    }

    public int size() {
        if (this.garbage) {
            SparseArrayCompatKt.gc(this);
        }
        return this.size;
    }

    public String toString() {
        if (size() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.size * 28);
        sb.append('{');
        int i2 = this.size;
        for (int i8 = 0; i8 < i2; i8++) {
            if (i8 > 0) {
                sb.append(", ");
            }
            sb.append(keyAt(i8));
            sb.append(G5.T);
            E eValueAt = valueAt(i8);
            if (eValueAt != this) {
                sb.append(eValueAt);
            } else {
                sb.append("(this Map)");
            }
        }
        return a.g('}', "buffer.toString()", sb);
    }

    public E valueAt(int i2) {
        if (this.garbage) {
            SparseArrayCompatKt.gc(this);
        }
        return (E) this.values[i2];
    }

    public SparseArrayCompat(int i2) {
        if (i2 == 0) {
            this.keys = ContainerHelpersKt.EMPTY_INTS;
            this.values = ContainerHelpersKt.EMPTY_OBJECTS;
        } else {
            int iIdealIntArraySize = ContainerHelpersKt.idealIntArraySize(i2);
            this.keys = new int[iIdealIntArraySize];
            this.values = new Object[iIdealIntArraySize];
        }
    }

    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public SparseArrayCompat<E> m31clone() throws CloneNotSupportedException {
        Object objClone = super.clone();
        k.c(objClone, "null cannot be cast to non-null type androidx.collection.SparseArrayCompat<E of androidx.collection.SparseArrayCompat>");
        SparseArrayCompat<E> sparseArrayCompat = (SparseArrayCompat) objClone;
        sparseArrayCompat.keys = (int[]) this.keys.clone();
        sparseArrayCompat.values = (Object[]) this.values.clone();
        return sparseArrayCompat;
    }

    public E get(int i2, E e) {
        return (E) SparseArrayCompatKt.commonGet(this, i2, e);
    }

    public boolean remove(int i2, Object obj) {
        int iIndexOfKey = indexOfKey(i2);
        if (iIndexOfKey < 0 || !k.a(obj, valueAt(iIndexOfKey))) {
            return false;
        }
        removeAt(iIndexOfKey);
        return true;
    }

    public boolean replace(int i2, E e, E e4) {
        int iIndexOfKey = indexOfKey(i2);
        if (iIndexOfKey < 0 || !k.a(this.values[iIndexOfKey], e)) {
            return false;
        }
        this.values[iIndexOfKey] = e4;
        return true;
    }

    public /* synthetic */ SparseArrayCompat(int i2, int i8, f fVar) {
        this((i8 & 1) != 0 ? 10 : i2);
    }
}
