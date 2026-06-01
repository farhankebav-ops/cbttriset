package androidx.collection;

import e6.a;
import e6.p;
import java.util.Iterator;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import m6.h;
import r5.j;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class MutableObjectIntMap<K> extends ObjectIntMap<K> {
    private int growthLimit;

    public MutableObjectIntMap() {
        this(0, 1, null);
    }

    private final void adjustStorage() {
        int i2 = this._capacity;
        if (i2 <= 8 || Long.compare((((long) this._size) * 32) ^ Long.MIN_VALUE, (((long) i2) * 25) ^ Long.MIN_VALUE) > 0) {
            resizeStorage(ScatterMapKt.nextCapacity(this._capacity));
        } else {
            removeDeletedMarkers();
        }
    }

    private final int findFirstAvailableSlot(int i2) {
        int i8 = this._capacity;
        int i9 = i2 & i8;
        int i10 = 0;
        while (true) {
            long[] jArr = this.metadata;
            int i11 = i9 >> 3;
            int i12 = (i9 & 7) << 3;
            long j = ((jArr[i11 + 1] << (64 - i12)) & ((-i12) >> 63)) | (jArr[i11] >>> i12);
            long j3 = j & ((~j) << 7) & (-9187201950435737472L);
            if (j3 != 0) {
                return (i9 + (Long.numberOfTrailingZeros(j3) >> 3)) & i8;
            }
            i10 += 8;
            i9 = (i9 + i10) & i8;
        }
    }

    private final int findIndex(K k) {
        int iHashCode = (k != null ? k.hashCode() : 0) * ScatterMapKt.MurmurHashC1;
        int i2 = iHashCode ^ (iHashCode << 16);
        int i8 = i2 >>> 7;
        int i9 = i2 & 127;
        int i10 = this._capacity;
        int i11 = i8 & i10;
        int i12 = 0;
        while (true) {
            long[] jArr = this.metadata;
            int i13 = i11 >> 3;
            int i14 = (i11 & 7) << 3;
            long j = ((jArr[i13 + 1] << (64 - i14)) & ((-i14) >> 63)) | (jArr[i13] >>> i14);
            long j3 = i9;
            int i15 = i9;
            long j8 = j ^ (j3 * ScatterMapKt.BitmaskLsb);
            for (long j9 = (~j8) & (j8 - ScatterMapKt.BitmaskLsb) & (-9187201950435737472L); j9 != 0; j9 &= j9 - 1) {
                int iNumberOfTrailingZeros = (i11 + (Long.numberOfTrailingZeros(j9) >> 3)) & i10;
                if (k.a(this.keys[iNumberOfTrailingZeros], k)) {
                    return iNumberOfTrailingZeros;
                }
            }
            if ((((~j) << 6) & j & (-9187201950435737472L)) != 0) {
                int iFindFirstAvailableSlot = findFirstAvailableSlot(i8);
                if (this.growthLimit == 0 && ((this.metadata[iFindFirstAvailableSlot >> 3] >> ((iFindFirstAvailableSlot & 7) << 3)) & 255) != 254) {
                    adjustStorage();
                    iFindFirstAvailableSlot = findFirstAvailableSlot(i8);
                }
                this._size++;
                int i16 = this.growthLimit;
                long[] jArr2 = this.metadata;
                int i17 = iFindFirstAvailableSlot >> 3;
                long j10 = jArr2[i17];
                int i18 = (iFindFirstAvailableSlot & 7) << 3;
                this.growthLimit = i16 - (((j10 >> i18) & 255) == 128 ? 1 : 0);
                jArr2[i17] = (j10 & (~(255 << i18))) | (j3 << i18);
                int i19 = this._capacity;
                int i20 = ((iFindFirstAvailableSlot - 7) & i19) + (i19 & 7);
                int i21 = i20 >> 3;
                int i22 = (i20 & 7) << 3;
                jArr2[i21] = ((~(255 << i22)) & jArr2[i21]) | (j3 << i22);
                return ~iFindFirstAvailableSlot;
            }
            i12 += 8;
            i11 = (i11 + i12) & i10;
            i9 = i15;
        }
    }

    private final void initializeGrowth() {
        this.growthLimit = ScatterMapKt.loadedCapacity(getCapacity()) - this._size;
    }

    private final void initializeMetadata(int i2) {
        long[] jArr;
        if (i2 == 0) {
            jArr = ScatterMapKt.EmptyGroup;
        } else {
            jArr = new long[((i2 + 15) & (-8)) >> 3];
            j.l0(jArr);
        }
        this.metadata = jArr;
        int i8 = i2 >> 3;
        long j = 255 << ((i2 & 7) << 3);
        jArr[i8] = (jArr[i8] & (~j)) | j;
        initializeGrowth();
    }

    private final void initializeStorage(int i2) {
        int iMax = i2 > 0 ? Math.max(7, ScatterMapKt.normalizeCapacity(i2)) : 0;
        this._capacity = iMax;
        initializeMetadata(iMax);
        this.keys = new Object[iMax];
        this.values = new int[iMax];
    }

    private final void removeDeletedMarkers() {
        long[] jArr = this.metadata;
        int i2 = this._capacity;
        int i8 = 0;
        for (int i9 = 0; i9 < i2; i9++) {
            int i10 = i9 >> 3;
            int i11 = (i9 & 7) << 3;
            if (((jArr[i10] >> i11) & 255) == 254) {
                long[] jArr2 = this.metadata;
                jArr2[i10] = (128 << i11) | (jArr2[i10] & (~(255 << i11)));
                int i12 = this._capacity;
                int i13 = ((i9 - 7) & i12) + (i12 & 7);
                int i14 = i13 >> 3;
                int i15 = (i13 & 7) << 3;
                jArr2[i14] = ((~(255 << i15)) & jArr2[i14]) | (128 << i15);
                i8++;
            }
        }
        this.growthLimit += i8;
    }

    private final void resizeStorage(int i2) {
        int i8;
        long[] jArr = this.metadata;
        Object[] objArr = this.keys;
        int[] iArr = this.values;
        int i9 = this._capacity;
        initializeStorage(i2);
        Object[] objArr2 = this.keys;
        int[] iArr2 = this.values;
        int i10 = 0;
        while (i10 < i9) {
            if (((jArr[i10 >> 3] >> ((i10 & 7) << 3)) & 255) < 128) {
                Object obj = objArr[i10];
                int iHashCode = (obj != null ? obj.hashCode() : 0) * ScatterMapKt.MurmurHashC1;
                int i11 = iHashCode ^ (iHashCode << 16);
                int iFindFirstAvailableSlot = findFirstAvailableSlot(i11 >>> 7);
                long j = i11 & 127;
                long[] jArr2 = this.metadata;
                int i12 = iFindFirstAvailableSlot >> 3;
                int i13 = (iFindFirstAvailableSlot & 7) << 3;
                i8 = i10;
                jArr2[i12] = (jArr2[i12] & (~(255 << i13))) | (j << i13);
                int i14 = this._capacity;
                int i15 = ((iFindFirstAvailableSlot - 7) & i14) + (i14 & 7);
                int i16 = i15 >> 3;
                int i17 = (i15 & 7) << 3;
                jArr2[i16] = (jArr2[i16] & (~(255 << i17))) | (j << i17);
                objArr2[iFindFirstAvailableSlot] = obj;
                iArr2[iFindFirstAvailableSlot] = iArr[i8];
            } else {
                i8 = i10;
            }
            i10 = i8 + 1;
        }
    }

    private final void writeMetadata(int i2, long j) {
        long[] jArr = this.metadata;
        int i8 = i2 >> 3;
        int i9 = (i2 & 7) << 3;
        jArr[i8] = (jArr[i8] & (~(255 << i9))) | (j << i9);
        int i10 = this._capacity;
        int i11 = ((i2 - 7) & i10) + (i10 & 7);
        int i12 = i11 >> 3;
        int i13 = (i11 & 7) << 3;
        jArr[i12] = (j << i13) | (jArr[i12] & (~(255 << i13)));
    }

    public final void clear() {
        this._size = 0;
        long[] jArr = this.metadata;
        if (jArr != ScatterMapKt.EmptyGroup) {
            j.l0(jArr);
            long[] jArr2 = this.metadata;
            int i2 = this._capacity;
            int i8 = i2 >> 3;
            long j = 255 << ((i2 & 7) << 3);
            jArr2[i8] = (jArr2[i8] & (~j)) | j;
        }
        j.k0(null, this.keys, 0, this._capacity);
        initializeGrowth();
    }

    public final int getOrPut(K k, a defaultValue) {
        k.e(defaultValue, "defaultValue");
        int iFindKeyIndex = findKeyIndex(k);
        if (iFindKeyIndex >= 0) {
            return this.values[iFindKeyIndex];
        }
        int iIntValue = ((Number) defaultValue.invoke()).intValue();
        set(k, iIntValue);
        return iIntValue;
    }

    public final void minusAssign(K k) {
        remove(k);
    }

    public final void plusAssign(ObjectIntMap<K> from) {
        k.e(from, "from");
        putAll(from);
    }

    public final void put(K k, int i2) {
        set(k, i2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void putAll(ObjectIntMap<K> from) {
        k.e(from, "from");
        Object[] objArr = from.keys;
        int[] iArr = from.values;
        long[] jArr = from.metadata;
        int length = jArr.length - 2;
        if (length < 0) {
            return;
        }
        int i2 = 0;
        while (true) {
            long j = jArr[i2];
            if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                int i8 = 8 - ((~(i2 - length)) >>> 31);
                for (int i9 = 0; i9 < i8; i9++) {
                    if ((255 & j) < 128) {
                        int i10 = (i2 << 3) + i9;
                        set(objArr[i10], iArr[i10]);
                    }
                    j >>= 8;
                }
                if (i8 != 8) {
                    return;
                }
            }
            if (i2 == length) {
                return;
            } else {
                i2++;
            }
        }
    }

    public final void remove(K k) {
        int iFindKeyIndex = findKeyIndex(k);
        if (iFindKeyIndex >= 0) {
            removeValueAt(iFindKeyIndex);
        }
    }

    public final void removeIf(p predicate) {
        k.e(predicate, "predicate");
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length < 0) {
            return;
        }
        int i2 = 0;
        while (true) {
            long j = jArr[i2];
            if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                int i8 = 8 - ((~(i2 - length)) >>> 31);
                for (int i9 = 0; i9 < i8; i9++) {
                    if ((255 & j) < 128) {
                        int i10 = (i2 << 3) + i9;
                        if (((Boolean) predicate.invoke(this.keys[i10], Integer.valueOf(this.values[i10]))).booleanValue()) {
                            removeValueAt(i10);
                        }
                    }
                    j >>= 8;
                }
                if (i8 != 8) {
                    return;
                }
            }
            if (i2 == length) {
                return;
            } else {
                i2++;
            }
        }
    }

    public final void removeValueAt(int i2) {
        this._size--;
        long[] jArr = this.metadata;
        int i8 = i2 >> 3;
        int i9 = (i2 & 7) << 3;
        jArr[i8] = (jArr[i8] & (~(255 << i9))) | (254 << i9);
        int i10 = this._capacity;
        int i11 = ((i2 - 7) & i10) + (i10 & 7);
        int i12 = i11 >> 3;
        int i13 = (i11 & 7) << 3;
        jArr[i12] = (jArr[i12] & (~(255 << i13))) | (254 << i13);
        this.keys[i2] = null;
    }

    public final void set(K k, int i2) {
        int iFindIndex = findIndex(k);
        if (iFindIndex < 0) {
            iFindIndex = ~iFindIndex;
        }
        this.keys[iFindIndex] = k;
        this.values[iFindIndex] = i2;
    }

    public final int trim() {
        int i2 = this._capacity;
        int iNormalizeCapacity = ScatterMapKt.normalizeCapacity(ScatterMapKt.unloadedCapacity(this._size));
        if (iNormalizeCapacity >= i2) {
            return 0;
        }
        resizeStorage(iNormalizeCapacity);
        return i2 - this._capacity;
    }

    public /* synthetic */ MutableObjectIntMap(int i2, int i8, f fVar) {
        this((i8 & 1) != 0 ? 6 : i2);
    }

    public final void minusAssign(K[] keys) {
        k.e(keys, "keys");
        for (K k : keys) {
            remove(k);
        }
    }

    public final int put(K k, int i2, int i8) {
        int iFindIndex = findIndex(k);
        if (iFindIndex < 0) {
            iFindIndex = ~iFindIndex;
        } else {
            i8 = this.values[iFindIndex];
        }
        this.keys[iFindIndex] = k;
        this.values[iFindIndex] = i2;
        return i8;
    }

    public MutableObjectIntMap(int i2) {
        super(null);
        if (i2 >= 0) {
            initializeStorage(ScatterMapKt.unloadedCapacity(i2));
            return;
        }
        throw new IllegalArgumentException("Capacity must be a positive value.");
    }

    public final boolean remove(K k, int i2) {
        int iFindKeyIndex = findKeyIndex(k);
        if (iFindKeyIndex < 0 || this.values[iFindKeyIndex] != i2) {
            return false;
        }
        removeValueAt(iFindKeyIndex);
        return true;
    }

    public final void minusAssign(Iterable<? extends K> keys) {
        k.e(keys, "keys");
        Iterator<? extends K> it = keys.iterator();
        while (it.hasNext()) {
            remove(it.next());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void minusAssign(h keys) {
        k.e(keys, "keys");
        Iterator it = keys.iterator();
        while (it.hasNext()) {
            remove(it.next());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void minusAssign(ScatterSet<K> keys) {
        k.e(keys, "keys");
        Object[] objArr = keys.elements;
        long[] jArr = keys.metadata;
        int length = jArr.length - 2;
        if (length < 0) {
            return;
        }
        int i2 = 0;
        while (true) {
            long j = jArr[i2];
            if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                int i8 = 8 - ((~(i2 - length)) >>> 31);
                for (int i9 = 0; i9 < i8; i9++) {
                    if ((255 & j) < 128) {
                        remove(objArr[(i2 << 3) + i9]);
                    }
                    j >>= 8;
                }
                if (i8 != 8) {
                    return;
                }
            }
            if (i2 == length) {
                return;
            } else {
                i2++;
            }
        }
    }
}
