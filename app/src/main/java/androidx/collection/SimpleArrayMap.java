package androidx.collection;

import a1.a;
import androidx.collection.internal.ContainerHelpersKt;
import com.ironsource.G5;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Map;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import r5.j;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public class SimpleArrayMap<K, V> {
    private Object[] array;
    private int[] hashes;
    private int size;

    public SimpleArrayMap() {
        this(0, 1, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final <T extends V> T getOrDefaultInternal(Object obj, T t3) {
        int iIndexOfKey = indexOfKey(obj);
        return iIndexOfKey >= 0 ? (T) this.array[(iIndexOfKey << 1) + 1] : t3;
    }

    private final int indexOf(K k, int i2) {
        int i8 = this.size;
        if (i8 == 0) {
            return -1;
        }
        int iBinarySearch = ContainerHelpersKt.binarySearch(this.hashes, i8, i2);
        if (iBinarySearch < 0 || k.a(k, this.array[iBinarySearch << 1])) {
            return iBinarySearch;
        }
        int i9 = iBinarySearch + 1;
        while (i9 < i8 && this.hashes[i9] == i2) {
            if (k.a(k, this.array[i9 << 1])) {
                return i9;
            }
            i9++;
        }
        for (int i10 = iBinarySearch - 1; i10 >= 0 && this.hashes[i10] == i2; i10--) {
            if (k.a(k, this.array[i10 << 1])) {
                return i10;
            }
        }
        return ~i9;
    }

    private final int indexOfNull() {
        int i2 = this.size;
        if (i2 == 0) {
            return -1;
        }
        int iBinarySearch = ContainerHelpersKt.binarySearch(this.hashes, i2, 0);
        if (iBinarySearch < 0 || this.array[iBinarySearch << 1] == null) {
            return iBinarySearch;
        }
        int i8 = iBinarySearch + 1;
        while (i8 < i2 && this.hashes[i8] == 0) {
            if (this.array[i8 << 1] == null) {
                return i8;
            }
            i8++;
        }
        for (int i9 = iBinarySearch - 1; i9 >= 0 && this.hashes[i9] == 0; i9--) {
            if (this.array[i9 << 1] == null) {
                return i9;
            }
        }
        return ~i8;
    }

    public final int __restricted$indexOfValue(V v2) {
        int i2 = this.size * 2;
        Object[] objArr = this.array;
        if (v2 == null) {
            for (int i8 = 1; i8 < i2; i8 += 2) {
                if (objArr[i8] == null) {
                    return i8 >> 1;
                }
            }
            return -1;
        }
        for (int i9 = 1; i9 < i2; i9 += 2) {
            if (v2.equals(objArr[i9])) {
                return i9 >> 1;
            }
        }
        return -1;
    }

    public void clear() {
        if (this.size > 0) {
            this.hashes = ContainerHelpersKt.EMPTY_INTS;
            this.array = ContainerHelpersKt.EMPTY_OBJECTS;
            this.size = 0;
        }
        if (this.size > 0) {
            throw new ConcurrentModificationException();
        }
    }

    public boolean containsKey(K k) {
        return indexOfKey(k) >= 0;
    }

    public boolean containsValue(V v2) {
        return __restricted$indexOfValue(v2) >= 0;
    }

    public void ensureCapacity(int i2) {
        int i8 = this.size;
        int[] iArr = this.hashes;
        if (iArr.length < i2) {
            int[] iArrCopyOf = Arrays.copyOf(iArr, i2);
            k.d(iArrCopyOf, "copyOf(this, newSize)");
            this.hashes = iArrCopyOf;
            Object[] objArrCopyOf = Arrays.copyOf(this.array, i2 * 2);
            k.d(objArrCopyOf, "copyOf(this, newSize)");
            this.array = objArrCopyOf;
        }
        if (this.size != i8) {
            throw new ConcurrentModificationException();
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        try {
            if (obj instanceof SimpleArrayMap) {
                if (size() != ((SimpleArrayMap) obj).size()) {
                    return false;
                }
                SimpleArrayMap simpleArrayMap = (SimpleArrayMap) obj;
                int i2 = this.size;
                for (int i8 = 0; i8 < i2; i8++) {
                    K kKeyAt = keyAt(i8);
                    V vValueAt = valueAt(i8);
                    Object obj2 = simpleArrayMap.get(kKeyAt);
                    if (vValueAt == null) {
                        if (obj2 != null || !simpleArrayMap.containsKey(kKeyAt)) {
                            return false;
                        }
                    } else if (!vValueAt.equals(obj2)) {
                        return false;
                    }
                }
                return true;
            }
            if (!(obj instanceof Map) || size() != ((Map) obj).size()) {
                return false;
            }
            int i9 = this.size;
            for (int i10 = 0; i10 < i9; i10++) {
                K kKeyAt2 = keyAt(i10);
                V vValueAt2 = valueAt(i10);
                Object obj3 = ((Map) obj).get(kKeyAt2);
                if (vValueAt2 == null) {
                    if (obj3 != null || !((Map) obj).containsKey(kKeyAt2)) {
                        return false;
                    }
                } else if (!vValueAt2.equals(obj3)) {
                    return false;
                }
            }
            return true;
        } catch (ClassCastException | NullPointerException unused) {
        }
        return false;
    }

    public V get(K k) {
        int iIndexOfKey = indexOfKey(k);
        if (iIndexOfKey >= 0) {
            return (V) this.array[(iIndexOfKey << 1) + 1];
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public V getOrDefault(Object obj, V v2) {
        int iIndexOfKey = indexOfKey(obj);
        return iIndexOfKey >= 0 ? (V) this.array[(iIndexOfKey << 1) + 1] : v2;
    }

    public int hashCode() {
        int[] iArr = this.hashes;
        Object[] objArr = this.array;
        int i2 = this.size;
        int i8 = 1;
        int i9 = 0;
        int iHashCode = 0;
        while (i9 < i2) {
            Object obj = objArr[i8];
            iHashCode += (obj != null ? obj.hashCode() : 0) ^ iArr[i9];
            i9++;
            i8 += 2;
        }
        return iHashCode;
    }

    public int indexOfKey(K k) {
        return k == null ? indexOfNull() : indexOf(k, k.hashCode());
    }

    public boolean isEmpty() {
        return this.size <= 0;
    }

    public K keyAt(int i2) {
        if (i2 < 0 || i2 >= this.size) {
            throw new IllegalArgumentException(a.g(i2, "Expected index to be within 0..size()-1, but was ").toString());
        }
        return (K) this.array[i2 << 1];
    }

    public V put(K k, V v2) {
        int i2 = this.size;
        int iHashCode = k != null ? k.hashCode() : 0;
        int iIndexOf = k != null ? indexOf(k, iHashCode) : indexOfNull();
        if (iIndexOf >= 0) {
            int i8 = (iIndexOf << 1) + 1;
            Object[] objArr = this.array;
            V v7 = (V) objArr[i8];
            objArr[i8] = v2;
            return v7;
        }
        int i9 = ~iIndexOf;
        int[] iArr = this.hashes;
        if (i2 >= iArr.length) {
            int i10 = 8;
            if (i2 >= 8) {
                i10 = (i2 >> 1) + i2;
            } else if (i2 < 4) {
                i10 = 4;
            }
            int[] iArrCopyOf = Arrays.copyOf(iArr, i10);
            k.d(iArrCopyOf, "copyOf(this, newSize)");
            this.hashes = iArrCopyOf;
            Object[] objArrCopyOf = Arrays.copyOf(this.array, i10 << 1);
            k.d(objArrCopyOf, "copyOf(this, newSize)");
            this.array = objArrCopyOf;
            if (i2 != this.size) {
                throw new ConcurrentModificationException();
            }
        }
        if (i9 < i2) {
            int[] iArr2 = this.hashes;
            int i11 = i9 + 1;
            j.c0(i11, i9, i2, iArr2, iArr2);
            Object[] objArr2 = this.array;
            j.f0(objArr2, i11 << 1, objArr2, i9 << 1, this.size << 1);
        }
        int i12 = this.size;
        if (i2 == i12) {
            int[] iArr3 = this.hashes;
            if (i9 < iArr3.length) {
                iArr3[i9] = iHashCode;
                Object[] objArr3 = this.array;
                int i13 = i9 << 1;
                objArr3[i13] = k;
                objArr3[i13 + 1] = v2;
                this.size = i12 + 1;
                return null;
            }
        }
        throw new ConcurrentModificationException();
    }

    public void putAll(SimpleArrayMap<? extends K, ? extends V> map) {
        k.e(map, "map");
        int i2 = map.size;
        ensureCapacity(this.size + i2);
        if (this.size != 0) {
            for (int i8 = 0; i8 < i2; i8++) {
                put(map.keyAt(i8), map.valueAt(i8));
            }
        } else if (i2 > 0) {
            j.c0(0, 0, i2, map.hashes, this.hashes);
            j.f0(map.array, 0, this.array, 0, i2 << 1);
            this.size = i2;
        }
    }

    public V putIfAbsent(K k, V v2) {
        V v7 = get(k);
        return v7 == null ? put(k, v2) : v7;
    }

    public V remove(K k) {
        int iIndexOfKey = indexOfKey(k);
        if (iIndexOfKey >= 0) {
            return removeAt(iIndexOfKey);
        }
        return null;
    }

    public V removeAt(int i2) {
        int i8;
        if (i2 < 0 || i2 >= (i8 = this.size)) {
            throw new IllegalArgumentException(a.g(i2, "Expected index to be within 0..size()-1, but was ").toString());
        }
        Object[] objArr = this.array;
        int i9 = i2 << 1;
        V v2 = (V) objArr[i9 + 1];
        if (i8 <= 1) {
            clear();
            return v2;
        }
        int i10 = i8 - 1;
        int[] iArr = this.hashes;
        if (iArr.length <= 8 || i8 >= iArr.length / 3) {
            if (i2 < i10) {
                int i11 = i2 + 1;
                j.c0(i2, i11, i8, iArr, iArr);
                Object[] objArr2 = this.array;
                j.f0(objArr2, i9, objArr2, i11 << 1, i8 << 1);
            }
            Object[] objArr3 = this.array;
            int i12 = i10 << 1;
            objArr3[i12] = null;
            objArr3[i12 + 1] = null;
        } else {
            int i13 = i8 > 8 ? i8 + (i8 >> 1) : 8;
            int[] iArrCopyOf = Arrays.copyOf(iArr, i13);
            k.d(iArrCopyOf, "copyOf(this, newSize)");
            this.hashes = iArrCopyOf;
            Object[] objArrCopyOf = Arrays.copyOf(this.array, i13 << 1);
            k.d(objArrCopyOf, "copyOf(this, newSize)");
            this.array = objArrCopyOf;
            if (i8 != this.size) {
                throw new ConcurrentModificationException();
            }
            if (i2 > 0) {
                j.c0(0, 0, i2, iArr, this.hashes);
                j.f0(objArr, 0, this.array, 0, i9);
            }
            if (i2 < i10) {
                int i14 = i2 + 1;
                j.c0(i2, i14, i8, iArr, this.hashes);
                j.f0(objArr, i9, this.array, i14 << 1, i8 << 1);
            }
        }
        if (i8 != this.size) {
            throw new ConcurrentModificationException();
        }
        this.size = i10;
        return v2;
    }

    public V replace(K k, V v2) {
        int iIndexOfKey = indexOfKey(k);
        if (iIndexOfKey >= 0) {
            return setValueAt(iIndexOfKey, v2);
        }
        return null;
    }

    public V setValueAt(int i2, V v2) {
        if (i2 < 0 || i2 >= this.size) {
            throw new IllegalArgumentException(a.g(i2, "Expected index to be within 0..size()-1, but was ").toString());
        }
        int i8 = (i2 << 1) + 1;
        Object[] objArr = this.array;
        V v7 = (V) objArr[i8];
        objArr[i8] = v2;
        return v7;
    }

    public int size() {
        return this.size;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.size * 28);
        sb.append('{');
        int i2 = this.size;
        for (int i8 = 0; i8 < i2; i8++) {
            if (i8 > 0) {
                sb.append(", ");
            }
            K kKeyAt = keyAt(i8);
            if (kKeyAt != sb) {
                sb.append(kKeyAt);
            } else {
                sb.append("(this Map)");
            }
            sb.append(G5.T);
            V vValueAt = valueAt(i8);
            if (vValueAt != sb) {
                sb.append(vValueAt);
            } else {
                sb.append("(this Map)");
            }
        }
        return androidx.camera.core.processing.util.a.g('}', "StringBuilder(capacity).…builderAction).toString()", sb);
    }

    public V valueAt(int i2) {
        if (i2 < 0 || i2 >= this.size) {
            throw new IllegalArgumentException(a.g(i2, "Expected index to be within 0..size()-1, but was ").toString());
        }
        return (V) this.array[(i2 << 1) + 1];
    }

    public SimpleArrayMap(int i2) {
        this.hashes = i2 == 0 ? ContainerHelpersKt.EMPTY_INTS : new int[i2];
        this.array = i2 == 0 ? ContainerHelpersKt.EMPTY_OBJECTS : new Object[i2 << 1];
    }

    public boolean remove(K k, V v2) {
        int iIndexOfKey = indexOfKey(k);
        if (iIndexOfKey < 0 || !k.a(v2, valueAt(iIndexOfKey))) {
            return false;
        }
        removeAt(iIndexOfKey);
        return true;
    }

    public boolean replace(K k, V v2, V v7) {
        int iIndexOfKey = indexOfKey(k);
        if (iIndexOfKey < 0 || !k.a(v2, valueAt(iIndexOfKey))) {
            return false;
        }
        setValueAt(iIndexOfKey, v7);
        return true;
    }

    public /* synthetic */ SimpleArrayMap(int i2, int i8, f fVar) {
        this((i8 & 1) != 0 ? 0 : i2);
    }

    public SimpleArrayMap(SimpleArrayMap<? extends K, ? extends V> simpleArrayMap) {
        this(0, 1, null);
        if (simpleArrayMap != null) {
            putAll(simpleArrayMap);
        }
    }
}
