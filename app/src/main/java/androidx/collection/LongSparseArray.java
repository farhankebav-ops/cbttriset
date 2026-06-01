package androidx.collection;

import a1.a;
import androidx.collection.internal.ContainerHelpersKt;
import com.ironsource.G5;
import java.util.Arrays;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import r5.j;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public class LongSparseArray<E> implements Cloneable {
    public /* synthetic */ boolean garbage;
    public /* synthetic */ long[] keys;
    public /* synthetic */ int size;
    public /* synthetic */ Object[] values;

    public LongSparseArray() {
        this(0, 1, null);
    }

    public void append(long j, E e) {
        int i2 = this.size;
        if (i2 != 0 && j <= this.keys[i2 - 1]) {
            put(j, e);
            return;
        }
        if (this.garbage) {
            long[] jArr = this.keys;
            if (i2 >= jArr.length) {
                Object[] objArr = this.values;
                int i8 = 0;
                for (int i9 = 0; i9 < i2; i9++) {
                    Object obj = objArr[i9];
                    if (obj != LongSparseArrayKt.DELETED) {
                        if (i9 != i8) {
                            jArr[i8] = jArr[i9];
                            objArr[i8] = obj;
                            objArr[i9] = null;
                        }
                        i8++;
                    }
                }
                this.garbage = false;
                this.size = i8;
            }
        }
        int i10 = this.size;
        if (i10 >= this.keys.length) {
            int iIdealLongArraySize = ContainerHelpersKt.idealLongArraySize(i10 + 1);
            long[] jArrCopyOf = Arrays.copyOf(this.keys, iIdealLongArraySize);
            k.d(jArrCopyOf, "copyOf(this, newSize)");
            this.keys = jArrCopyOf;
            Object[] objArrCopyOf = Arrays.copyOf(this.values, iIdealLongArraySize);
            k.d(objArrCopyOf, "copyOf(this, newSize)");
            this.values = objArrCopyOf;
        }
        this.keys[i10] = j;
        this.values[i10] = e;
        this.size = i10 + 1;
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

    public boolean containsKey(long j) {
        return indexOfKey(j) >= 0;
    }

    public boolean containsValue(E e) {
        return indexOfValue(e) >= 0;
    }

    public void delete(long j) {
        int iBinarySearch = ContainerHelpersKt.binarySearch(this.keys, this.size, j);
        if (iBinarySearch < 0 || this.values[iBinarySearch] == LongSparseArrayKt.DELETED) {
            return;
        }
        this.values[iBinarySearch] = LongSparseArrayKt.DELETED;
        this.garbage = true;
    }

    public E get(long j) {
        int iBinarySearch = ContainerHelpersKt.binarySearch(this.keys, this.size, j);
        if (iBinarySearch < 0 || this.values[iBinarySearch] == LongSparseArrayKt.DELETED) {
            return null;
        }
        return (E) this.values[iBinarySearch];
    }

    public int indexOfKey(long j) {
        if (this.garbage) {
            int i2 = this.size;
            long[] jArr = this.keys;
            Object[] objArr = this.values;
            int i8 = 0;
            for (int i9 = 0; i9 < i2; i9++) {
                Object obj = objArr[i9];
                if (obj != LongSparseArrayKt.DELETED) {
                    if (i9 != i8) {
                        jArr[i8] = jArr[i9];
                        objArr[i8] = obj;
                        objArr[i9] = null;
                    }
                    i8++;
                }
            }
            this.garbage = false;
            this.size = i8;
        }
        return ContainerHelpersKt.binarySearch(this.keys, this.size, j);
    }

    public int indexOfValue(E e) {
        if (this.garbage) {
            int i2 = this.size;
            long[] jArr = this.keys;
            Object[] objArr = this.values;
            int i8 = 0;
            for (int i9 = 0; i9 < i2; i9++) {
                Object obj = objArr[i9];
                if (obj != LongSparseArrayKt.DELETED) {
                    if (i9 != i8) {
                        jArr[i8] = jArr[i9];
                        objArr[i8] = obj;
                        objArr[i9] = null;
                    }
                    i8++;
                }
            }
            this.garbage = false;
            this.size = i8;
        }
        int i10 = this.size;
        for (int i11 = 0; i11 < i10; i11++) {
            if (this.values[i11] == e) {
                return i11;
            }
        }
        return -1;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public long keyAt(int i2) {
        int i8;
        if (i2 < 0 || i2 >= (i8 = this.size)) {
            throw new IllegalArgumentException(a.g(i2, "Expected index to be within 0..size()-1, but was ").toString());
        }
        if (this.garbage) {
            long[] jArr = this.keys;
            Object[] objArr = this.values;
            int i9 = 0;
            for (int i10 = 0; i10 < i8; i10++) {
                Object obj = objArr[i10];
                if (obj != LongSparseArrayKt.DELETED) {
                    if (i10 != i9) {
                        jArr[i9] = jArr[i10];
                        objArr[i9] = obj;
                        objArr[i10] = null;
                    }
                    i9++;
                }
            }
            this.garbage = false;
            this.size = i9;
        }
        return this.keys[i2];
    }

    public void put(long j, E e) {
        int iBinarySearch = ContainerHelpersKt.binarySearch(this.keys, this.size, j);
        if (iBinarySearch >= 0) {
            this.values[iBinarySearch] = e;
            return;
        }
        int i2 = ~iBinarySearch;
        if (i2 < this.size && this.values[i2] == LongSparseArrayKt.DELETED) {
            this.keys[i2] = j;
            this.values[i2] = e;
            return;
        }
        if (this.garbage) {
            int i8 = this.size;
            long[] jArr = this.keys;
            if (i8 >= jArr.length) {
                Object[] objArr = this.values;
                int i9 = 0;
                for (int i10 = 0; i10 < i8; i10++) {
                    Object obj = objArr[i10];
                    if (obj != LongSparseArrayKt.DELETED) {
                        if (i10 != i9) {
                            jArr[i9] = jArr[i10];
                            objArr[i9] = obj;
                            objArr[i10] = null;
                        }
                        i9++;
                    }
                }
                this.garbage = false;
                this.size = i9;
                i2 = ~ContainerHelpersKt.binarySearch(this.keys, i9, j);
            }
        }
        int i11 = this.size;
        if (i11 >= this.keys.length) {
            int iIdealLongArraySize = ContainerHelpersKt.idealLongArraySize(i11 + 1);
            long[] jArrCopyOf = Arrays.copyOf(this.keys, iIdealLongArraySize);
            k.d(jArrCopyOf, "copyOf(this, newSize)");
            this.keys = jArrCopyOf;
            Object[] objArrCopyOf = Arrays.copyOf(this.values, iIdealLongArraySize);
            k.d(objArrCopyOf, "copyOf(this, newSize)");
            this.values = objArrCopyOf;
        }
        int i12 = this.size;
        if (i12 - i2 != 0) {
            long[] jArr2 = this.keys;
            int i13 = i2 + 1;
            j.e0(jArr2, jArr2, i13, i2, i12);
            Object[] objArr2 = this.values;
            j.f0(objArr2, i13, objArr2, i2, this.size);
        }
        this.keys[i2] = j;
        this.values[i2] = e;
        this.size++;
    }

    public void putAll(LongSparseArray<? extends E> other) {
        k.e(other, "other");
        int size = other.size();
        for (int i2 = 0; i2 < size; i2++) {
            put(other.keyAt(i2), other.valueAt(i2));
        }
    }

    public E putIfAbsent(long j, E e) {
        E e4 = get(j);
        if (e4 == null) {
            put(j, e);
        }
        return e4;
    }

    public void remove(long j) {
        int iBinarySearch = ContainerHelpersKt.binarySearch(this.keys, this.size, j);
        if (iBinarySearch < 0 || this.values[iBinarySearch] == LongSparseArrayKt.DELETED) {
            return;
        }
        this.values[iBinarySearch] = LongSparseArrayKt.DELETED;
        this.garbage = true;
    }

    public void removeAt(int i2) {
        if (this.values[i2] != LongSparseArrayKt.DELETED) {
            this.values[i2] = LongSparseArrayKt.DELETED;
            this.garbage = true;
        }
    }

    public E replace(long j, E e) {
        int iIndexOfKey = indexOfKey(j);
        if (iIndexOfKey < 0) {
            return null;
        }
        Object[] objArr = this.values;
        E e4 = (E) objArr[iIndexOfKey];
        objArr[iIndexOfKey] = e;
        return e4;
    }

    public void setValueAt(int i2, E e) {
        int i8;
        if (i2 < 0 || i2 >= (i8 = this.size)) {
            throw new IllegalArgumentException(a.g(i2, "Expected index to be within 0..size()-1, but was ").toString());
        }
        if (this.garbage) {
            long[] jArr = this.keys;
            Object[] objArr = this.values;
            int i9 = 0;
            for (int i10 = 0; i10 < i8; i10++) {
                Object obj = objArr[i10];
                if (obj != LongSparseArrayKt.DELETED) {
                    if (i10 != i9) {
                        jArr[i9] = jArr[i10];
                        objArr[i9] = obj;
                        objArr[i10] = null;
                    }
                    i9++;
                }
            }
            this.garbage = false;
            this.size = i9;
        }
        this.values[i2] = e;
    }

    public int size() {
        if (this.garbage) {
            int i2 = this.size;
            long[] jArr = this.keys;
            Object[] objArr = this.values;
            int i8 = 0;
            for (int i9 = 0; i9 < i2; i9++) {
                Object obj = objArr[i9];
                if (obj != LongSparseArrayKt.DELETED) {
                    if (i9 != i8) {
                        jArr[i8] = jArr[i9];
                        objArr[i8] = obj;
                        objArr[i9] = null;
                    }
                    i8++;
                }
            }
            this.garbage = false;
            this.size = i8;
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
            if (eValueAt != sb) {
                sb.append(eValueAt);
            } else {
                sb.append("(this Map)");
            }
        }
        return androidx.camera.core.processing.util.a.g('}', "StringBuilder(capacity).…builderAction).toString()", sb);
    }

    public E valueAt(int i2) {
        int i8;
        if (i2 < 0 || i2 >= (i8 = this.size)) {
            throw new IllegalArgumentException(a.g(i2, "Expected index to be within 0..size()-1, but was ").toString());
        }
        if (this.garbage) {
            long[] jArr = this.keys;
            Object[] objArr = this.values;
            int i9 = 0;
            for (int i10 = 0; i10 < i8; i10++) {
                Object obj = objArr[i10];
                if (obj != LongSparseArrayKt.DELETED) {
                    if (i10 != i9) {
                        jArr[i9] = jArr[i10];
                        objArr[i9] = obj;
                        objArr[i10] = null;
                    }
                    i9++;
                }
            }
            this.garbage = false;
            this.size = i9;
        }
        return (E) this.values[i2];
    }

    public LongSparseArray(int i2) {
        if (i2 == 0) {
            this.keys = ContainerHelpersKt.EMPTY_LONGS;
            this.values = ContainerHelpersKt.EMPTY_OBJECTS;
        } else {
            int iIdealLongArraySize = ContainerHelpersKt.idealLongArraySize(i2);
            this.keys = new long[iIdealLongArraySize];
            this.values = new Object[iIdealLongArraySize];
        }
    }

    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public LongSparseArray<E> m30clone() throws CloneNotSupportedException {
        Object objClone = super.clone();
        k.c(objClone, "null cannot be cast to non-null type androidx.collection.LongSparseArray<E of androidx.collection.LongSparseArray>");
        LongSparseArray<E> longSparseArray = (LongSparseArray) objClone;
        longSparseArray.keys = (long[]) this.keys.clone();
        longSparseArray.values = (Object[]) this.values.clone();
        return longSparseArray;
    }

    public E get(long j, E e) {
        int iBinarySearch = ContainerHelpersKt.binarySearch(this.keys, this.size, j);
        return (iBinarySearch < 0 || this.values[iBinarySearch] == LongSparseArrayKt.DELETED) ? e : (E) this.values[iBinarySearch];
    }

    public boolean replace(long j, E e, E e4) {
        int iIndexOfKey = indexOfKey(j);
        if (iIndexOfKey < 0 || !k.a(this.values[iIndexOfKey], e)) {
            return false;
        }
        this.values[iIndexOfKey] = e4;
        return true;
    }

    public boolean remove(long j, E e) {
        int iIndexOfKey = indexOfKey(j);
        if (iIndexOfKey < 0 || !k.a(e, valueAt(iIndexOfKey))) {
            return false;
        }
        removeAt(iIndexOfKey);
        return true;
    }

    public /* synthetic */ LongSparseArray(int i2, int i8, f fVar) {
        this((i8 & 1) != 0 ? 10 : i2);
    }
}
