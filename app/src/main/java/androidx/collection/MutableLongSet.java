package androidx.collection;

import androidx.annotation.IntRange;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import r5.j;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class MutableLongSet extends LongSet {
    private int growthLimit;

    public MutableLongSet() {
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

    private final int findAbsoluteInsertIndex(long j) {
        int i2 = ((int) (j ^ (j >>> 32))) * ScatterMapKt.MurmurHashC1;
        int i8 = i2 ^ (i2 << 16);
        int i9 = i8 >>> 7;
        int i10 = i8 & 127;
        int i11 = this._capacity;
        int i12 = i9 & i11;
        int i13 = 0;
        while (true) {
            long[] jArr = this.metadata;
            int i14 = i12 >> 3;
            int i15 = (i12 & 7) << 3;
            long j3 = ((jArr[i14 + 1] << (64 - i15)) & ((-i15) >> 63)) | (jArr[i14] >>> i15);
            long j8 = i10;
            int i16 = i13;
            long j9 = j3 ^ (j8 * ScatterMapKt.BitmaskLsb);
            for (long j10 = (~j9) & (j9 - ScatterMapKt.BitmaskLsb) & (-9187201950435737472L); j10 != 0; j10 &= j10 - 1) {
                int iNumberOfTrailingZeros = ((Long.numberOfTrailingZeros(j10) >> 3) + i12) & i11;
                if (this.elements[iNumberOfTrailingZeros] == j) {
                    return iNumberOfTrailingZeros;
                }
            }
            if ((((~j3) << 6) & j3 & (-9187201950435737472L)) != 0) {
                int iFindFirstAvailableSlot = findFirstAvailableSlot(i9);
                if (this.growthLimit == 0 && ((this.metadata[iFindFirstAvailableSlot >> 3] >> ((iFindFirstAvailableSlot & 7) << 3)) & 255) != 254) {
                    adjustStorage();
                    iFindFirstAvailableSlot = findFirstAvailableSlot(i9);
                }
                this._size++;
                int i17 = this.growthLimit;
                long[] jArr2 = this.metadata;
                int i18 = iFindFirstAvailableSlot >> 3;
                long j11 = jArr2[i18];
                int i19 = (iFindFirstAvailableSlot & 7) << 3;
                this.growthLimit = i17 - (((j11 >> i19) & 255) == 128 ? 1 : 0);
                jArr2[i18] = (j11 & (~(255 << i19))) | (j8 << i19);
                int i20 = this._capacity;
                int i21 = ((iFindFirstAvailableSlot - 7) & i20) + (i20 & 7);
                int i22 = i21 >> 3;
                int i23 = (i21 & 7) << 3;
                jArr2[i22] = ((~(255 << i23)) & jArr2[i22]) | (j8 << i23);
                return iFindFirstAvailableSlot;
            }
            i13 = i16 + 8;
            i12 = (i12 + i13) & i11;
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
        this.elements = new long[iMax];
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

    private final void removeElementAt(int i2) {
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
    }

    private final void resizeStorage(int i2) {
        long[] jArr;
        MutableLongSet mutableLongSet = this;
        long[] jArr2 = mutableLongSet.metadata;
        long[] jArr3 = mutableLongSet.elements;
        int i8 = mutableLongSet._capacity;
        initializeStorage(i2);
        long[] jArr4 = mutableLongSet.elements;
        int i9 = 0;
        while (i9 < i8) {
            if (((jArr2[i9 >> 3] >> ((i9 & 7) << 3)) & 255) < 128) {
                long j = jArr3[i9];
                int i10 = ((int) ((j >>> 32) ^ j)) * ScatterMapKt.MurmurHashC1;
                int i11 = i10 ^ (i10 << 16);
                int iFindFirstAvailableSlot = mutableLongSet.findFirstAvailableSlot(i11 >>> 7);
                long j3 = i11 & 127;
                long[] jArr5 = mutableLongSet.metadata;
                int i12 = iFindFirstAvailableSlot >> 3;
                int i13 = (iFindFirstAvailableSlot & 7) << 3;
                jArr5[i12] = (jArr5[i12] & (~(255 << i13))) | (j3 << i13);
                int i14 = mutableLongSet._capacity;
                int i15 = ((iFindFirstAvailableSlot - 7) & i14) + (i14 & 7);
                int i16 = i15 >> 3;
                int i17 = (i15 & 7) << 3;
                jArr = jArr2;
                jArr5[i16] = ((~(255 << i17)) & jArr5[i16]) | (j3 << i17);
                jArr4[iFindFirstAvailableSlot] = j;
            } else {
                jArr = jArr2;
            }
            i9++;
            mutableLongSet = this;
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

    public final boolean add(long j) {
        int i2 = this._size;
        this.elements[findAbsoluteInsertIndex(j)] = j;
        return this._size != i2;
    }

    public final boolean addAll(long[] elements) {
        k.e(elements, "elements");
        int i2 = this._size;
        plusAssign(elements);
        return i2 != this._size;
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
        initializeGrowth();
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0065, code lost:
    
        if (((r4 & ((~r4) << 6)) & (-9187201950435737472L)) == 0) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0067, code lost:
    
        r10 = -1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void minusAssign(long r15) {
        /*
            r14 = this;
            r0 = 32
            long r0 = r15 >>> r0
            long r0 = r0 ^ r15
            int r0 = (int) r0
            r1 = -862048943(0xffffffffcc9e2d51, float:-8.293031E7)
            int r0 = r0 * r1
            int r1 = r0 << 16
            r0 = r0 ^ r1
            r1 = r0 & 127(0x7f, float:1.78E-43)
            int r2 = r14._capacity
            int r0 = r0 >>> 7
            r0 = r0 & r2
            r3 = 0
        L15:
            long[] r4 = r14.metadata
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
        L41:
            r10 = 0
            int r12 = (r6 > r10 ? 1 : (r6 == r10 ? 0 : -1))
            if (r12 == 0) goto L5e
            int r10 = java.lang.Long.numberOfTrailingZeros(r6)
            int r10 = r10 >> 3
            int r10 = r10 + r0
            r10 = r10 & r2
            long[] r11 = r14.elements
            r12 = r11[r10]
            int r11 = (r12 > r15 ? 1 : (r12 == r15 ? 0 : -1))
            if (r11 != 0) goto L58
            goto L68
        L58:
            r10 = 1
            long r10 = r6 - r10
            long r6 = r6 & r10
            goto L41
        L5e:
            long r6 = ~r4
            r12 = 6
            long r6 = r6 << r12
            long r4 = r4 & r6
            long r4 = r4 & r8
            int r4 = (r4 > r10 ? 1 : (r4 == r10 ? 0 : -1))
            if (r4 == 0) goto L6e
            r10 = -1
        L68:
            if (r10 < 0) goto L6d
            r14.removeElementAt(r10)
        L6d:
            return
        L6e:
            int r3 = r3 + 8
            int r0 = r0 + r3
            r0 = r0 & r2
            goto L15
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.MutableLongSet.minusAssign(long):void");
    }

    public final void plusAssign(long j) {
        this.elements[findAbsoluteInsertIndex(j)] = j;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0069, code lost:
    
        if (((r6 & ((~r6) << 6)) & (-9187201950435737472L)) == 0) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x006b, code lost:
    
        r10 = -1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean remove(long r18) {
        /*
            r17 = this;
            r0 = r17
            r1 = 32
            long r1 = r18 >>> r1
            long r1 = r18 ^ r1
            int r1 = (int) r1
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
        L19:
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
        L45:
            r14 = 0
            int r10 = (r8 > r14 ? 1 : (r8 == r14 ? 0 : -1))
            if (r10 == 0) goto L62
            int r10 = java.lang.Long.numberOfTrailingZeros(r8)
            int r10 = r10 >> 3
            int r10 = r10 + r1
            r10 = r10 & r3
            long[] r14 = r0.elements
            r15 = r14[r10]
            int r14 = (r15 > r18 ? 1 : (r15 == r18 ? 0 : -1))
            if (r14 != 0) goto L5c
            goto L6c
        L5c:
            r14 = 1
            long r14 = r8 - r14
            long r8 = r8 & r14
            goto L45
        L62:
            long r8 = ~r6
            r10 = 6
            long r8 = r8 << r10
            long r6 = r6 & r8
            long r6 = r6 & r12
            int r6 = (r6 > r14 ? 1 : (r6 == r14 ? 0 : -1))
            if (r6 == 0) goto L75
            r10 = -1
        L6c:
            if (r10 < 0) goto L6f
            r4 = r11
        L6f:
            if (r4 == 0) goto L74
            r0.removeElementAt(r10)
        L74:
            return r4
        L75:
            int r5 = r5 + 8
            int r1 = r1 + r5
            r1 = r1 & r3
            goto L19
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.MutableLongSet.remove(long):boolean");
    }

    public final boolean removeAll(long[] elements) {
        k.e(elements, "elements");
        int i2 = this._size;
        minusAssign(elements);
        return i2 != this._size;
    }

    @IntRange(from = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_LONG)
    public final int trim() {
        int i2 = this._capacity;
        int iNormalizeCapacity = ScatterMapKt.normalizeCapacity(ScatterMapKt.unloadedCapacity(this._size));
        if (iNormalizeCapacity >= i2) {
            return 0;
        }
        resizeStorage(iNormalizeCapacity);
        return i2 - this._capacity;
    }

    public /* synthetic */ MutableLongSet(int i2, int i8, f fVar) {
        this((i8 & 1) != 0 ? 6 : i2);
    }

    public MutableLongSet(int i2) {
        super(null);
        if (i2 >= 0) {
            initializeStorage(ScatterMapKt.unloadedCapacity(i2));
            return;
        }
        throw new IllegalArgumentException("Capacity must be a positive value.");
    }

    public final void plusAssign(long[] elements) {
        k.e(elements, "elements");
        for (long j : elements) {
            plusAssign(j);
        }
    }

    public final boolean addAll(LongSet elements) {
        k.e(elements, "elements");
        int i2 = this._size;
        plusAssign(elements);
        return i2 != this._size;
    }

    public final boolean removeAll(LongSet elements) {
        k.e(elements, "elements");
        int i2 = this._size;
        minusAssign(elements);
        return i2 != this._size;
    }

    public final void plusAssign(LongSet elements) {
        k.e(elements, "elements");
        long[] jArr = elements.elements;
        long[] jArr2 = elements.metadata;
        int length = jArr2.length - 2;
        if (length < 0) {
            return;
        }
        int i2 = 0;
        while (true) {
            long j = jArr2[i2];
            if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                int i8 = 8 - ((~(i2 - length)) >>> 31);
                for (int i9 = 0; i9 < i8; i9++) {
                    if ((255 & j) < 128) {
                        plusAssign(jArr[(i2 << 3) + i9]);
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

    public final void minusAssign(long[] elements) {
        k.e(elements, "elements");
        for (long j : elements) {
            minusAssign(j);
        }
    }

    public final void minusAssign(LongSet elements) {
        k.e(elements, "elements");
        long[] jArr = elements.elements;
        long[] jArr2 = elements.metadata;
        int length = jArr2.length - 2;
        if (length < 0) {
            return;
        }
        int i2 = 0;
        while (true) {
            long j = jArr2[i2];
            if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                int i8 = 8 - ((~(i2 - length)) >>> 31);
                for (int i9 = 0; i9 < i8; i9++) {
                    if ((255 & j) < 128) {
                        minusAssign(jArr[(i2 << 3) + i9]);
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
