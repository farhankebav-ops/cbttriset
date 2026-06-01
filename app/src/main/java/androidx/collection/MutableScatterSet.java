package androidx.collection;

import androidx.annotation.IntRange;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import e6.l;
import f6.b;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import m6.h;
import r5.j;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class MutableScatterSet<E> extends ScatterSet<E> {
    private int growthLimit;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public final class MutableSetWrapper extends ScatterSet<E>.SetWrapper implements Set<E>, b {
        public MutableSetWrapper() {
            super();
        }

        @Override // androidx.collection.ScatterSet.SetWrapper, java.util.Set, java.util.Collection
        public boolean add(E e) {
            return MutableScatterSet.this.add(e);
        }

        @Override // androidx.collection.ScatterSet.SetWrapper, java.util.Set, java.util.Collection
        public boolean addAll(Collection<? extends E> elements) {
            k.e(elements, "elements");
            return MutableScatterSet.this.addAll(elements);
        }

        @Override // androidx.collection.ScatterSet.SetWrapper, java.util.Set, java.util.Collection
        public void clear() {
            MutableScatterSet.this.clear();
        }

        @Override // androidx.collection.ScatterSet.SetWrapper, java.util.Set, java.util.Collection, java.lang.Iterable
        public Iterator<E> iterator() {
            return new MutableScatterSet$MutableSetWrapper$iterator$1(MutableScatterSet.this);
        }

        @Override // androidx.collection.ScatterSet.SetWrapper, java.util.Set, java.util.Collection
        public boolean remove(Object obj) {
            return MutableScatterSet.this.remove(obj);
        }

        @Override // androidx.collection.ScatterSet.SetWrapper, java.util.Set, java.util.Collection
        public boolean removeAll(Collection<? extends Object> elements) {
            k.e(elements, "elements");
            int size = MutableScatterSet.this.getSize();
            Iterator<? extends Object> it = elements.iterator();
            while (it.hasNext()) {
                MutableScatterSet.this.minusAssign((E) it.next());
            }
            return size != MutableScatterSet.this.getSize();
        }

        @Override // androidx.collection.ScatterSet.SetWrapper, java.util.Set, java.util.Collection
        public boolean retainAll(Collection<? extends Object> elements) {
            k.e(elements, "elements");
            MutableScatterSet<E> mutableScatterSet = MutableScatterSet.this;
            long[] jArr = mutableScatterSet.metadata;
            int length = jArr.length - 2;
            if (length < 0) {
                return false;
            }
            int i2 = 0;
            boolean z2 = false;
            while (true) {
                long j = jArr[i2];
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i8 = 8 - ((~(i2 - length)) >>> 31);
                    for (int i9 = 0; i9 < i8; i9++) {
                        if ((255 & j) < 128) {
                            int i10 = (i2 << 3) + i9;
                            if (!elements.contains(mutableScatterSet.elements[i10])) {
                                mutableScatterSet.removeElementAt(i10);
                                z2 = true;
                            }
                        }
                        j >>= 8;
                    }
                    if (i8 != 8) {
                        return z2;
                    }
                }
                if (i2 == length) {
                    return z2;
                }
                i2++;
            }
        }
    }

    public MutableScatterSet() {
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

    private final int findAbsoluteInsertIndex(E e) {
        int iHashCode = (e != null ? e.hashCode() : 0) * ScatterMapKt.MurmurHashC1;
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
                if (k.a(this.elements[iNumberOfTrailingZeros], e)) {
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
            i12 += 8;
            i11 = (i11 + i12) & i10;
            i9 = i15;
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
        this.elements = new Object[iMax];
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
        Object[] objArr = this.elements;
        int i9 = this._capacity;
        initializeStorage(i2);
        Object[] objArr2 = this.elements;
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
                jArr2[i16] = ((~(255 << i17)) & jArr2[i16]) | (j << i17);
                objArr2[iFindFirstAvailableSlot] = obj;
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

    public final boolean add(E e) {
        int size = getSize();
        this.elements[findAbsoluteInsertIndex(e)] = e;
        return getSize() != size;
    }

    public final boolean addAll(E[] elements) {
        k.e(elements, "elements");
        int size = getSize();
        plusAssign((Object[]) elements);
        return size != getSize();
    }

    public final Set<E> asMutableSet() {
        return new MutableSetWrapper();
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
        j.k0(null, this.elements, 0, this._capacity);
        initializeGrowth();
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0069, code lost:
    
        if (((r4 & ((~r4) << 6)) & (-9187201950435737472L)) == 0) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x006b, code lost:
    
        r10 = -1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void minusAssign(E r14) {
        /*
            r13 = this;
            r0 = 0
            if (r14 == 0) goto L8
            int r1 = r14.hashCode()
            goto L9
        L8:
            r1 = r0
        L9:
            r2 = -862048943(0xffffffffcc9e2d51, float:-8.293031E7)
            int r1 = r1 * r2
            int r2 = r1 << 16
            r1 = r1 ^ r2
            r2 = r1 & 127(0x7f, float:1.78E-43)
            int r3 = r13._capacity
            int r1 = r1 >>> 7
        L16:
            r1 = r1 & r3
            long[] r4 = r13.metadata
            int r5 = r1 >> 3
            r6 = r1 & 7
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
            long r6 = (long) r2
            r8 = 72340172838076673(0x101010101010101, double:7.748604185489348E-304)
            long r6 = r6 * r8
            long r6 = r6 ^ r4
            long r8 = r6 - r8
            long r6 = ~r6
            long r6 = r6 & r8
            r8 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r6 = r6 & r8
        L43:
            r10 = 0
            int r12 = (r6 > r10 ? 1 : (r6 == r10 ? 0 : -1))
            if (r12 == 0) goto L62
            int r10 = java.lang.Long.numberOfTrailingZeros(r6)
            int r10 = r10 >> 3
            int r10 = r10 + r1
            r10 = r10 & r3
            java.lang.Object[] r11 = r13.elements
            r11 = r11[r10]
            boolean r11 = kotlin.jvm.internal.k.a(r11, r14)
            if (r11 == 0) goto L5c
            goto L6c
        L5c:
            r10 = 1
            long r10 = r6 - r10
            long r6 = r6 & r10
            goto L43
        L62:
            long r6 = ~r4
            r12 = 6
            long r6 = r6 << r12
            long r4 = r4 & r6
            long r4 = r4 & r8
            int r4 = (r4 > r10 ? 1 : (r4 == r10 ? 0 : -1))
            if (r4 == 0) goto L72
            r10 = -1
        L6c:
            if (r10 < 0) goto L71
            r13.removeElementAt(r10)
        L71:
            return
        L72:
            int r0 = r0 + 8
            int r1 = r1 + r0
            goto L16
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.MutableScatterSet.minusAssign(java.lang.Object):void");
    }

    public final void plusAssign(E e) {
        this.elements[findAbsoluteInsertIndex(e)] = e;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x006e, code lost:
    
        if (((r7 & ((~r7) << 6)) & (-9187201950435737472L)) == 0) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0070, code lost:
    
        r11 = -1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean remove(E r18) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            r2 = 0
            if (r1 == 0) goto Lc
            int r3 = r1.hashCode()
            goto Ld
        Lc:
            r3 = r2
        Ld:
            r4 = -862048943(0xffffffffcc9e2d51, float:-8.293031E7)
            int r3 = r3 * r4
            int r4 = r3 << 16
            r3 = r3 ^ r4
            r4 = r3 & 127(0x7f, float:1.78E-43)
            int r5 = r0._capacity
            int r3 = r3 >>> 7
            r3 = r3 & r5
            r6 = r2
        L1c:
            long[] r7 = r0.metadata
            int r8 = r3 >> 3
            r9 = r3 & 7
            int r9 = r9 << 3
            r10 = r7[r8]
            long r10 = r10 >>> r9
            r12 = 1
            int r8 = r8 + r12
            r13 = r7[r8]
            int r7 = 64 - r9
            long r7 = r13 << r7
            long r13 = (long) r9
            long r13 = -r13
            r9 = 63
            long r13 = r13 >> r9
            long r7 = r7 & r13
            long r7 = r7 | r10
            long r9 = (long) r4
            r13 = 72340172838076673(0x101010101010101, double:7.748604185489348E-304)
            long r9 = r9 * r13
            long r9 = r9 ^ r7
            long r13 = r9 - r13
            long r9 = ~r9
            long r9 = r9 & r13
            r13 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r9 = r9 & r13
        L48:
            r15 = 0
            int r11 = (r9 > r15 ? 1 : (r9 == r15 ? 0 : -1))
            if (r11 == 0) goto L67
            int r11 = java.lang.Long.numberOfTrailingZeros(r9)
            int r11 = r11 >> 3
            int r11 = r11 + r3
            r11 = r11 & r5
            java.lang.Object[] r15 = r0.elements
            r15 = r15[r11]
            boolean r15 = kotlin.jvm.internal.k.a(r15, r1)
            if (r15 == 0) goto L61
            goto L71
        L61:
            r15 = 1
            long r15 = r9 - r15
            long r9 = r9 & r15
            goto L48
        L67:
            long r9 = ~r7
            r11 = 6
            long r9 = r9 << r11
            long r7 = r7 & r9
            long r7 = r7 & r13
            int r7 = (r7 > r15 ? 1 : (r7 == r15 ? 0 : -1))
            if (r7 == 0) goto L7a
            r11 = -1
        L71:
            if (r11 < 0) goto L74
            r2 = r12
        L74:
            if (r2 == 0) goto L79
            r0.removeElementAt(r11)
        L79:
            return r2
        L7a:
            int r6 = r6 + 8
            int r3 = r3 + r6
            r3 = r3 & r5
            goto L1c
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.MutableScatterSet.remove(java.lang.Object):boolean");
    }

    public final boolean removeAll(E[] elements) {
        k.e(elements, "elements");
        int size = getSize();
        minusAssign((Object[]) elements);
        return size != getSize();
    }

    public final void removeElementAt(int i2) {
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
        this.elements[i2] = null;
    }

    public final void removeIf(l predicate) {
        k.e(predicate, "predicate");
        Object[] objArr = this.elements;
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
                        if (((Boolean) predicate.invoke(objArr[i10])).booleanValue()) {
                            removeElementAt(i10);
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

    public /* synthetic */ MutableScatterSet(int i2, int i8, f fVar) {
        this((i8 & 1) != 0 ? 6 : i2);
    }

    public MutableScatterSet(int i2) {
        super(null);
        if (i2 >= 0) {
            initializeStorage(ScatterMapKt.unloadedCapacity(i2));
            return;
        }
        throw new IllegalArgumentException("Capacity must be a positive value.");
    }

    public final void plusAssign(E[] elements) {
        k.e(elements, "elements");
        for (E e : elements) {
            plusAssign(e);
        }
    }

    public final boolean addAll(Iterable<? extends E> elements) {
        k.e(elements, "elements");
        int size = getSize();
        plusAssign((Iterable) elements);
        return size != getSize();
    }

    public final boolean removeAll(h elements) {
        k.e(elements, "elements");
        int size = getSize();
        minusAssign(elements);
        return size != getSize();
    }

    public final void plusAssign(Iterable<? extends E> elements) {
        k.e(elements, "elements");
        Iterator<? extends E> it = elements.iterator();
        while (it.hasNext()) {
            plusAssign(it.next());
        }
    }

    public final boolean addAll(h elements) {
        k.e(elements, "elements");
        int size = getSize();
        plusAssign(elements);
        return size != getSize();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void plusAssign(h elements) {
        k.e(elements, "elements");
        Iterator it = elements.iterator();
        while (it.hasNext()) {
            plusAssign(it.next());
        }
    }

    public final boolean removeAll(Iterable<? extends E> elements) {
        k.e(elements, "elements");
        int size = getSize();
        minusAssign((Iterable) elements);
        return size != getSize();
    }

    public final void minusAssign(E[] elements) {
        k.e(elements, "elements");
        for (E e : elements) {
            minusAssign(e);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void plusAssign(ScatterSet<E> elements) {
        k.e(elements, "elements");
        Object[] objArr = elements.elements;
        long[] jArr = elements.metadata;
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
                        plusAssign(objArr[(i2 << 3) + i9]);
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

    public final boolean addAll(ScatterSet<E> elements) {
        k.e(elements, "elements");
        int size = getSize();
        plusAssign((ScatterSet) elements);
        return size != getSize();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void minusAssign(h elements) {
        k.e(elements, "elements");
        Iterator it = elements.iterator();
        while (it.hasNext()) {
            minusAssign(it.next());
        }
    }

    public final boolean removeAll(ScatterSet<E> elements) {
        k.e(elements, "elements");
        int size = getSize();
        minusAssign((ScatterSet) elements);
        return size != getSize();
    }

    public final void minusAssign(Iterable<? extends E> elements) {
        k.e(elements, "elements");
        Iterator<? extends E> it = elements.iterator();
        while (it.hasNext()) {
            minusAssign(it.next());
        }
    }

    public final boolean addAll(ObjectList<E> elements) {
        k.e(elements, "elements");
        int size = getSize();
        plusAssign((ObjectList) elements);
        return size != getSize();
    }

    public final boolean removeAll(ObjectList<E> elements) {
        k.e(elements, "elements");
        int size = getSize();
        minusAssign((ObjectList) elements);
        return size != getSize();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void minusAssign(ScatterSet<E> elements) {
        k.e(elements, "elements");
        Object[] objArr = elements.elements;
        long[] jArr = elements.metadata;
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
                        minusAssign(objArr[(i2 << 3) + i9]);
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

    /* JADX WARN: Multi-variable type inference failed */
    public final void plusAssign(ObjectList<E> elements) {
        k.e(elements, "elements");
        Object[] objArr = elements.content;
        int i2 = elements._size;
        for (int i8 = 0; i8 < i2; i8++) {
            plusAssign(objArr[i8]);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void minusAssign(ObjectList<E> elements) {
        k.e(elements, "elements");
        Object[] objArr = elements.content;
        int i2 = elements._size;
        for (int i8 = 0; i8 < i2; i8++) {
            minusAssign(objArr[i8]);
        }
    }
}
