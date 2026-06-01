package androidx.collection;

import e6.a;
import e6.p;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import r5.j;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class MutableFloatObjectMap<V> extends FloatObjectMap<V> {
    private int growthLimit;

    public MutableFloatObjectMap() {
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

    private final int findAbsoluteInsertIndex(float f4) {
        int iFloatToIntBits = Float.floatToIntBits(f4) * ScatterMapKt.MurmurHashC1;
        int i2 = iFloatToIntBits ^ (iFloatToIntBits << 16);
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
            int i15 = i12;
            long j8 = j ^ (j3 * ScatterMapKt.BitmaskLsb);
            for (long j9 = (~j8) & (j8 - ScatterMapKt.BitmaskLsb) & (-9187201950435737472L); j9 != 0; j9 &= j9 - 1) {
                int iNumberOfTrailingZeros = ((Long.numberOfTrailingZeros(j9) >> 3) + i11) & i10;
                if (this.keys[iNumberOfTrailingZeros] == f4) {
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
                return iFindFirstAvailableSlot;
            }
            i12 = i15 + 8;
            i11 = (i11 + i12) & i10;
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
        this.keys = new float[iMax];
        this.values = new Object[iMax];
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
        long[] jArr;
        MutableFloatObjectMap<V> mutableFloatObjectMap = this;
        long[] jArr2 = mutableFloatObjectMap.metadata;
        float[] fArr = mutableFloatObjectMap.keys;
        Object[] objArr = mutableFloatObjectMap.values;
        int i8 = mutableFloatObjectMap._capacity;
        initializeStorage(i2);
        float[] fArr2 = mutableFloatObjectMap.keys;
        Object[] objArr2 = mutableFloatObjectMap.values;
        int i9 = 0;
        while (i9 < i8) {
            if (((jArr2[i9 >> 3] >> ((i9 & 7) << 3)) & 255) < 128) {
                float f4 = fArr[i9];
                int iFloatToIntBits = Float.floatToIntBits(f4) * ScatterMapKt.MurmurHashC1;
                int i10 = iFloatToIntBits ^ (iFloatToIntBits << 16);
                int iFindFirstAvailableSlot = mutableFloatObjectMap.findFirstAvailableSlot(i10 >>> 7);
                long j = i10 & 127;
                long[] jArr3 = mutableFloatObjectMap.metadata;
                int i11 = iFindFirstAvailableSlot >> 3;
                int i12 = (iFindFirstAvailableSlot & 7) << 3;
                jArr3[i11] = (jArr3[i11] & (~(255 << i12))) | (j << i12);
                int i13 = mutableFloatObjectMap._capacity;
                int i14 = ((iFindFirstAvailableSlot - 7) & i13) + (i13 & 7);
                int i15 = i14 >> 3;
                int i16 = (i14 & 7) << 3;
                jArr = jArr2;
                jArr3[i15] = ((~(255 << i16)) & jArr3[i15]) | (j << i16);
                fArr2[iFindFirstAvailableSlot] = f4;
                objArr2[iFindFirstAvailableSlot] = objArr[i9];
            } else {
                jArr = jArr2;
            }
            i9++;
            mutableFloatObjectMap = this;
            jArr2 = jArr;
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
        j.k0(null, this.values, 0, this._capacity);
        initializeGrowth();
    }

    public final V getOrPut(float f4, a defaultValue) {
        k.e(defaultValue, "defaultValue");
        V v2 = get(f4);
        if (v2 != null) {
            return v2;
        }
        V v7 = (V) defaultValue.invoke();
        set(f4, v7);
        return v7;
    }

    public final void minusAssign(float f4) {
        remove(f4);
    }

    public final void plusAssign(FloatObjectMap<V> from) {
        k.e(from, "from");
        putAll(from);
    }

    public final V put(float f4, V v2) {
        int iFindAbsoluteInsertIndex = findAbsoluteInsertIndex(f4);
        Object[] objArr = this.values;
        V v7 = (V) objArr[iFindAbsoluteInsertIndex];
        this.keys[iFindAbsoluteInsertIndex] = f4;
        objArr[iFindAbsoluteInsertIndex] = v2;
        return v7;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void putAll(FloatObjectMap<V> from) {
        k.e(from, "from");
        float[] fArr = from.keys;
        Object[] objArr = from.values;
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
                        set(fArr[i10], objArr[i10]);
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

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0063, code lost:
    
        if (((r4 & ((~r4) << 6)) & (-9187201950435737472L)) == 0) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0065, code lost:
    
        r10 = -1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final V remove(float r14) {
        /*
            r13 = this;
            int r0 = java.lang.Float.floatToIntBits(r14)
            r1 = -862048943(0xffffffffcc9e2d51, float:-8.293031E7)
            int r0 = r0 * r1
            int r1 = r0 << 16
            r0 = r0 ^ r1
            r1 = r0 & 127(0x7f, float:1.78E-43)
            int r2 = r13._capacity
            int r0 = r0 >>> 7
            r0 = r0 & r2
            r3 = 0
        L13:
            long[] r4 = r13.metadata
            int r5 = r0 >> 3
            r6 = r0 & 7
            int r6 = r6 << 3
            r7 = r4[r5]
            long r7 = r7 >>> r6
            int r5 = r5 + 1
            r9 = r4[r5]
            int r4 = 64 - r6
            long r4 = r9 << r4
            long r9 = (long) r6
            long r9 = -r9
            r6 = 63
            long r9 = r9 >> r6
            long r4 = r4 & r9
            long r4 = r4 | r7
            long r6 = (long) r1
            r8 = 72340172838076673(0x101010101010101, double:7.748604185489348E-304)
            long r6 = r6 * r8
            long r6 = r6 ^ r4
            long r8 = r6 - r8
            long r6 = ~r6
            long r6 = r6 & r8
            r8 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r6 = r6 & r8
        L3f:
            r10 = 0
            int r12 = (r6 > r10 ? 1 : (r6 == r10 ? 0 : -1))
            if (r12 == 0) goto L5c
            int r10 = java.lang.Long.numberOfTrailingZeros(r6)
            int r10 = r10 >> 3
            int r10 = r10 + r0
            r10 = r10 & r2
            float[] r11 = r13.keys
            r11 = r11[r10]
            int r11 = (r11 > r14 ? 1 : (r11 == r14 ? 0 : -1))
            if (r11 != 0) goto L56
            goto L66
        L56:
            r10 = 1
            long r10 = r6 - r10
            long r6 = r6 & r10
            goto L3f
        L5c:
            long r6 = ~r4
            r12 = 6
            long r6 = r6 << r12
            long r4 = r4 & r6
            long r4 = r4 & r8
            int r4 = (r4 > r10 ? 1 : (r4 == r10 ? 0 : -1))
            if (r4 == 0) goto L6f
            r10 = -1
        L66:
            if (r10 < 0) goto L6d
            java.lang.Object r14 = r13.removeValueAt(r10)
            return r14
        L6d:
            r14 = 0
            return r14
        L6f:
            int r3 = r3 + 8
            int r0 = r0 + r3
            r0 = r0 & r2
            goto L13
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.MutableFloatObjectMap.remove(float):java.lang.Object");
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
                        if (((Boolean) predicate.invoke(Float.valueOf(this.keys[i10]), this.values[i10])).booleanValue()) {
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

    public final V removeValueAt(int i2) {
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
        Object[] objArr = this.values;
        V v2 = (V) objArr[i2];
        objArr[i2] = null;
        return v2;
    }

    public final void set(float f4, V v2) {
        int iFindAbsoluteInsertIndex = findAbsoluteInsertIndex(f4);
        this.keys[iFindAbsoluteInsertIndex] = f4;
        this.values[iFindAbsoluteInsertIndex] = v2;
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

    public /* synthetic */ MutableFloatObjectMap(int i2, int i8, f fVar) {
        this((i8 & 1) != 0 ? 6 : i2);
    }

    public final void minusAssign(float[] keys) {
        k.e(keys, "keys");
        for (float f4 : keys) {
            remove(f4);
        }
    }

    public MutableFloatObjectMap(int i2) {
        super(null);
        if (i2 >= 0) {
            initializeStorage(ScatterMapKt.unloadedCapacity(i2));
            return;
        }
        throw new IllegalArgumentException("Capacity must be a positive value.");
    }

    public final void minusAssign(FloatSet keys) {
        k.e(keys, "keys");
        float[] fArr = keys.elements;
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
                        remove(fArr[(i2 << 3) + i9]);
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

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0066, code lost:
    
        if (((r6 & ((~r6) << 6)) & (-9187201950435737472L)) == 0) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0068, code lost:
    
        r10 = -1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean remove(float r17, V r18) {
        /*
            r16 = this;
            r0 = r16
            int r1 = java.lang.Float.floatToIntBits(r17)
            r2 = -862048943(0xffffffffcc9e2d51, float:-8.293031E7)
            int r1 = r1 * r2
            int r2 = r1 << 16
            r1 = r1 ^ r2
            r2 = r1 & 127(0x7f, float:1.78E-43)
            int r3 = r0._capacity
            int r1 = r1 >>> 7
            r1 = r1 & r3
            r4 = 0
            r5 = r4
        L16:
            long[] r6 = r0.metadata
            int r7 = r1 >> 3
            r8 = r1 & 7
            int r8 = r8 << 3
            r9 = r6[r7]
            long r9 = r9 >>> r8
            r11 = 1
            int r7 = r7 + r11
            r12 = r6[r7]
            int r6 = 64 - r8
            long r6 = r12 << r6
            long r12 = (long) r8
            long r12 = -r12
            r8 = 63
            long r12 = r12 >> r8
            long r6 = r6 & r12
            long r6 = r6 | r9
            long r8 = (long) r2
            r12 = 72340172838076673(0x101010101010101, double:7.748604185489348E-304)
            long r8 = r8 * r12
            long r8 = r8 ^ r6
            long r12 = r8 - r12
            long r8 = ~r8
            long r8 = r8 & r12
            r12 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r8 = r8 & r12
        L42:
            r14 = 0
            int r10 = (r8 > r14 ? 1 : (r8 == r14 ? 0 : -1))
            if (r10 == 0) goto L5f
            int r10 = java.lang.Long.numberOfTrailingZeros(r8)
            int r10 = r10 >> 3
            int r10 = r10 + r1
            r10 = r10 & r3
            float[] r14 = r0.keys
            r14 = r14[r10]
            int r14 = (r14 > r17 ? 1 : (r14 == r17 ? 0 : -1))
            if (r14 != 0) goto L59
            goto L69
        L59:
            r14 = 1
            long r14 = r8 - r14
            long r8 = r8 & r14
            goto L42
        L5f:
            long r8 = ~r6
            r10 = 6
            long r8 = r8 << r10
            long r6 = r6 & r8
            long r6 = r6 & r12
            int r6 = (r6 > r14 ? 1 : (r6 == r14 ? 0 : -1))
            if (r6 == 0) goto L7c
            r10 = -1
        L69:
            if (r10 < 0) goto L7b
            java.lang.Object[] r1 = r0.values
            r1 = r1[r10]
            r6 = r18
            boolean r1 = kotlin.jvm.internal.k.a(r1, r6)
            if (r1 == 0) goto L7b
            r0.removeValueAt(r10)
            return r11
        L7b:
            return r4
        L7c:
            r6 = r18
            int r5 = r5 + 8
            int r1 = r1 + r5
            r1 = r1 & r3
            goto L16
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.MutableFloatObjectMap.remove(float, java.lang.Object):boolean");
    }

    public final void minusAssign(FloatList keys) {
        k.e(keys, "keys");
        float[] fArr = keys.content;
        int i2 = keys._size;
        for (int i8 = 0; i8 < i2; i8++) {
            remove(fArr[i8]);
        }
    }
}
