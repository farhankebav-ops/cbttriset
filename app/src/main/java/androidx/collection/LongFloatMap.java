package androidx.collection;

import androidx.camera.core.processing.util.a;
import com.ironsource.C2300e4;
import com.ironsource.G5;
import e6.l;
import e6.p;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public abstract class LongFloatMap {
    public int _capacity;
    public int _size;
    public long[] keys;
    public long[] metadata;
    public float[] values;

    public /* synthetic */ LongFloatMap(f fVar) {
        this();
    }

    public static /* synthetic */ String joinToString$default(LongFloatMap longFloatMap, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i2, CharSequence charSequence4, int i8, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: joinToString");
        }
        if ((i8 & 1) != 0) {
            charSequence = ", ";
        }
        if ((i8 & 2) != 0) {
            charSequence2 = "";
        }
        if ((i8 & 4) != 0) {
            charSequence3 = "";
        }
        if ((i8 & 8) != 0) {
            i2 = -1;
        }
        if ((i8 & 16) != 0) {
            charSequence4 = "...";
        }
        CharSequence charSequence5 = charSequence4;
        CharSequence charSequence6 = charSequence3;
        return longFloatMap.joinToString(charSequence, charSequence2, charSequence6, i2, charSequence5);
    }

    public final boolean all(p predicate) {
        k.e(predicate, "predicate");
        long[] jArr = this.keys;
        float[] fArr = this.values;
        long[] jArr2 = this.metadata;
        int length = jArr2.length - 2;
        if (length < 0) {
            return true;
        }
        int i2 = 0;
        while (true) {
            long j = jArr2[i2];
            if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                int i8 = 8 - ((~(i2 - length)) >>> 31);
                for (int i9 = 0; i9 < i8; i9++) {
                    if ((255 & j) < 128) {
                        int i10 = (i2 << 3) + i9;
                        if (!((Boolean) predicate.invoke(Long.valueOf(jArr[i10]), Float.valueOf(fArr[i10]))).booleanValue()) {
                            return false;
                        }
                    }
                    j >>= 8;
                }
                if (i8 != 8) {
                    return true;
                }
            }
            if (i2 == length) {
                return true;
            }
            i2++;
        }
    }

    public final boolean any() {
        return this._size != 0;
    }

    public final boolean contains(long j) {
        return findKeyIndex(j) >= 0;
    }

    public final boolean containsKey(long j) {
        return findKeyIndex(j) >= 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0041  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean containsValue(float r15) {
        /*
            r14 = this;
            float[] r0 = r14.values
            long[] r1 = r14.metadata
            int r2 = r1.length
            int r2 = r2 + (-2)
            r3 = 0
            if (r2 < 0) goto L46
            r4 = r3
        Lb:
            r5 = r1[r4]
            long r7 = ~r5
            r9 = 7
            long r7 = r7 << r9
            long r7 = r7 & r5
            r9 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r7 = r7 & r9
            int r7 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r7 == 0) goto L41
            int r7 = r4 - r2
            int r7 = ~r7
            int r7 = r7 >>> 31
            r8 = 8
            int r7 = 8 - r7
            r9 = r3
        L25:
            if (r9 >= r7) goto L3f
            r10 = 255(0xff, double:1.26E-321)
            long r10 = r10 & r5
            r12 = 128(0x80, double:6.3E-322)
            int r10 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r10 >= 0) goto L3b
            int r10 = r4 << 3
            int r10 = r10 + r9
            r10 = r0[r10]
            int r10 = (r15 > r10 ? 1 : (r15 == r10 ? 0 : -1))
            if (r10 != 0) goto L3b
            r15 = 1
            return r15
        L3b:
            long r5 = r5 >> r8
            int r9 = r9 + 1
            goto L25
        L3f:
            if (r7 != r8) goto L46
        L41:
            if (r4 == r2) goto L46
            int r4 = r4 + 1
            goto Lb
        L46:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.LongFloatMap.containsValue(float):boolean");
    }

    public final int count() {
        return getSize();
    }

    public boolean equals(Object obj) {
        boolean z2;
        long[] jArr;
        boolean z7;
        long[] jArr2;
        boolean z8 = true;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LongFloatMap)) {
            return false;
        }
        LongFloatMap longFloatMap = (LongFloatMap) obj;
        if (longFloatMap.getSize() != getSize()) {
            return false;
        }
        long[] jArr3 = this.keys;
        float[] fArr = this.values;
        long[] jArr4 = this.metadata;
        int length = jArr4.length - 2;
        if (length < 0) {
            return true;
        }
        int i2 = 0;
        while (true) {
            long j = jArr4[i2];
            if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                int i8 = 8 - ((~(i2 - length)) >>> 31);
                int i9 = 0;
                while (i9 < i8) {
                    if ((255 & j) < 128) {
                        int i10 = (i2 << 3) + i9;
                        z7 = z8;
                        jArr2 = jArr3;
                        if (fArr[i10] != longFloatMap.get(jArr2[i10])) {
                            return false;
                        }
                    } else {
                        z7 = z8;
                        jArr2 = jArr3;
                    }
                    j >>= 8;
                    i9++;
                    z8 = z7;
                    jArr3 = jArr2;
                }
                z2 = z8;
                jArr = jArr3;
                if (i8 != 8) {
                    return z2;
                }
            } else {
                z2 = z8;
                jArr = jArr3;
            }
            if (i2 == length) {
                return z2;
            }
            i2++;
            z8 = z2;
            jArr3 = jArr;
        }
    }

    public final int findKeyIndex(long j) {
        int i2 = ((int) ((j >>> 32) ^ j)) * ScatterMapKt.MurmurHashC1;
        int i8 = i2 ^ (i2 << 16);
        int i9 = i8 & 127;
        int i10 = this._capacity;
        int i11 = (i8 >>> 7) & i10;
        int i12 = 0;
        while (true) {
            long[] jArr = this.metadata;
            int i13 = i11 >> 3;
            int i14 = (i11 & 7) << 3;
            long j3 = ((jArr[i13 + 1] << (64 - i14)) & ((-i14) >> 63)) | (jArr[i13] >>> i14);
            long j8 = (((long) i9) * ScatterMapKt.BitmaskLsb) ^ j3;
            for (long j9 = (~j8) & (j8 - ScatterMapKt.BitmaskLsb) & (-9187201950435737472L); j9 != 0; j9 &= j9 - 1) {
                int iNumberOfTrailingZeros = ((Long.numberOfTrailingZeros(j9) >> 3) + i11) & i10;
                if (this.keys[iNumberOfTrailingZeros] == j) {
                    return iNumberOfTrailingZeros;
                }
            }
            if ((j3 & ((~j3) << 6) & (-9187201950435737472L)) != 0) {
                return -1;
            }
            i12 += 8;
            i11 = (i11 + i12) & i10;
        }
    }

    public final void forEach(p block) {
        k.e(block, "block");
        long[] jArr = this.keys;
        float[] fArr = this.values;
        long[] jArr2 = this.metadata;
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
                        int i10 = (i2 << 3) + i9;
                        block.invoke(Long.valueOf(jArr[i10]), Float.valueOf(fArr[i10]));
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

    public final void forEachIndexed(l block) {
        k.e(block, "block");
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
                        a.v(i2 << 3, i9, block);
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

    public final void forEachKey(l block) {
        k.e(block, "block");
        long[] jArr = this.keys;
        long[] jArr2 = this.metadata;
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
                        block.invoke(Long.valueOf(jArr[(i2 << 3) + i9]));
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

    public final void forEachValue(l block) {
        k.e(block, "block");
        float[] fArr = this.values;
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
                        block.invoke(Float.valueOf(fArr[(i2 << 3) + i9]));
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

    public final float get(long j) {
        int iFindKeyIndex = findKeyIndex(j);
        if (iFindKeyIndex >= 0) {
            return this.values[iFindKeyIndex];
        }
        throw new NoSuchElementException(a.j("Cannot find value for key ", j));
    }

    public final int getCapacity() {
        return this._capacity;
    }

    public final float getOrDefault(long j, float f4) {
        int iFindKeyIndex = findKeyIndex(j);
        return iFindKeyIndex >= 0 ? this.values[iFindKeyIndex] : f4;
    }

    public final float getOrElse(long j, e6.a defaultValue) {
        k.e(defaultValue, "defaultValue");
        int iFindKeyIndex = findKeyIndex(j);
        return iFindKeyIndex < 0 ? ((Number) defaultValue.invoke()).floatValue() : this.values[iFindKeyIndex];
    }

    public final int getSize() {
        return this._size;
    }

    public int hashCode() {
        long[] jArr = this.keys;
        float[] fArr = this.values;
        long[] jArr2 = this.metadata;
        int length = jArr2.length - 2;
        if (length < 0) {
            return 0;
        }
        int i2 = 0;
        int iFloatToIntBits = 0;
        while (true) {
            long j = jArr2[i2];
            if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                int i8 = 8 - ((~(i2 - length)) >>> 31);
                for (int i9 = 0; i9 < i8; i9++) {
                    if ((255 & j) < 128) {
                        int i10 = (i2 << 3) + i9;
                        long j3 = jArr[i10];
                        iFloatToIntBits += Float.floatToIntBits(fArr[i10]) ^ ((int) (j3 ^ (j3 >>> 32)));
                    }
                    j >>= 8;
                }
                if (i8 != 8) {
                    return iFloatToIntBits;
                }
            }
            if (i2 == length) {
                return iFloatToIntBits;
            }
            i2++;
        }
    }

    public final boolean isEmpty() {
        return this._size == 0;
    }

    public final boolean isNotEmpty() {
        return this._size != 0;
    }

    public final String joinToString() {
        return joinToString$default(this, null, null, null, 0, null, 31, null);
    }

    public final boolean none() {
        return this._size == 0;
    }

    public String toString() {
        int i2;
        int i8;
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder("{");
        long[] jArr = this.keys;
        float[] fArr = this.values;
        long[] jArr2 = this.metadata;
        int length = jArr2.length - 2;
        if (length >= 0) {
            int i9 = 0;
            int i10 = 0;
            while (true) {
                long j = jArr2[i9];
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i11 = 8 - ((~(i9 - length)) >>> 31);
                    int i12 = 0;
                    while (i12 < i11) {
                        if ((255 & j) < 128) {
                            int i13 = (i9 << 3) + i12;
                            i8 = i9;
                            long j3 = jArr[i13];
                            float f4 = fArr[i13];
                            sb.append(j3);
                            sb.append(C2300e4.i.f8399b);
                            sb.append(f4);
                            i10++;
                            if (i10 < this._size) {
                                sb.append(", ");
                            }
                        } else {
                            i8 = i9;
                        }
                        j >>= 8;
                        i12++;
                        i9 = i8;
                    }
                    int i14 = i9;
                    if (i11 != 8) {
                        break;
                    }
                    i2 = i14;
                } else {
                    i2 = i9;
                }
                if (i2 == length) {
                    break;
                }
                i9 = i2 + 1;
            }
        }
        return a.g('}', "s.append('}').toString()", sb);
    }

    private LongFloatMap() {
        this.metadata = ScatterMapKt.EmptyGroup;
        this.keys = LongSetKt.getEmptyLongArray();
        this.values = FloatSetKt.getEmptyFloatArray();
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x005e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean any(e6.p r18) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            java.lang.String r2 = "predicate"
            kotlin.jvm.internal.k.e(r1, r2)
            long[] r2 = r0.keys
            float[] r3 = r0.values
            long[] r4 = r0.metadata
            int r5 = r4.length
            int r5 = r5 + (-2)
            r6 = 0
            if (r5 < 0) goto L63
            r7 = r6
        L16:
            r8 = r4[r7]
            long r10 = ~r8
            r12 = 7
            long r10 = r10 << r12
            long r10 = r10 & r8
            r12 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r10 = r10 & r12
            int r10 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r10 == 0) goto L5e
            int r10 = r7 - r5
            int r10 = ~r10
            int r10 = r10 >>> 31
            r11 = 8
            int r10 = 8 - r10
            r12 = r6
        L30:
            if (r12 >= r10) goto L5c
            r13 = 255(0xff, double:1.26E-321)
            long r13 = r13 & r8
            r15 = 128(0x80, double:6.3E-322)
            int r13 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1))
            if (r13 >= 0) goto L58
            int r13 = r7 << 3
            int r13 = r13 + r12
            r14 = r2[r13]
            r13 = r3[r13]
            java.lang.Long r14 = java.lang.Long.valueOf(r14)
            java.lang.Float r13 = java.lang.Float.valueOf(r13)
            java.lang.Object r13 = r1.invoke(r14, r13)
            java.lang.Boolean r13 = (java.lang.Boolean) r13
            boolean r13 = r13.booleanValue()
            if (r13 == 0) goto L58
            r1 = 1
            return r1
        L58:
            long r8 = r8 >> r11
            int r12 = r12 + 1
            goto L30
        L5c:
            if (r10 != r11) goto L63
        L5e:
            if (r7 == r5) goto L63
            int r7 = r7 + 1
            goto L16
        L63:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.LongFloatMap.any(e6.p):boolean");
    }

    public final int count(p predicate) {
        k.e(predicate, "predicate");
        long[] jArr = this.keys;
        float[] fArr = this.values;
        long[] jArr2 = this.metadata;
        int length = jArr2.length - 2;
        if (length < 0) {
            return 0;
        }
        int i2 = 0;
        int i8 = 0;
        while (true) {
            long j = jArr2[i2];
            if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                int i9 = 8 - ((~(i2 - length)) >>> 31);
                for (int i10 = 0; i10 < i9; i10++) {
                    if ((255 & j) < 128) {
                        int i11 = (i2 << 3) + i10;
                        if (((Boolean) predicate.invoke(Long.valueOf(jArr[i11]), Float.valueOf(fArr[i11]))).booleanValue()) {
                            i8++;
                        }
                    }
                    j >>= 8;
                }
                if (i9 != 8) {
                    return i8;
                }
            }
            if (i2 == length) {
                return i8;
            }
            i2++;
        }
    }

    public final String joinToString(CharSequence separator) {
        k.e(separator, "separator");
        return joinToString$default(this, separator, null, null, 0, null, 30, null);
    }

    public final String joinToString(CharSequence separator, CharSequence prefix) {
        k.e(separator, "separator");
        k.e(prefix, "prefix");
        return joinToString$default(this, separator, prefix, null, 0, null, 28, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0080 A[PHI: r10
  0x0080: PHI (r10v2 int) = (r10v1 int), (r10v3 int) binds: [B:6:0x0030, B:20:0x007e] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String joinToString(java.lang.CharSequence r21, java.lang.CharSequence r22, e6.p r23) {
        /*
            r20 = this;
            r0 = r20
            r1 = r21
            r2 = r23
            java.lang.String r3 = "separator"
            kotlin.jvm.internal.k.e(r1, r3)
            java.lang.String r3 = "prefix"
            java.lang.String r4 = "transform"
            r5 = r22
            java.lang.StringBuilder r3 = androidx.camera.core.processing.util.a.p(r5, r3, r2, r4, r5)
            long[] r4 = r0.keys
            float[] r5 = r0.values
            long[] r6 = r0.metadata
            int r7 = r6.length
            int r7 = r7 + (-2)
            if (r7 < 0) goto L85
            r9 = 0
            r10 = 0
        L22:
            r11 = r6[r9]
            long r13 = ~r11
            r15 = 7
            long r13 = r13 << r15
            long r13 = r13 & r11
            r15 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r13 = r13 & r15
            int r13 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1))
            if (r13 == 0) goto L80
            int r13 = r9 - r7
            int r13 = ~r13
            int r13 = r13 >>> 31
            r14 = 8
            int r13 = 8 - r13
            r15 = 0
        L3c:
            if (r15 >= r13) goto L7d
            r16 = 255(0xff, double:1.26E-321)
            long r16 = r11 & r16
            r18 = 128(0x80, double:6.3E-322)
            int r16 = (r16 > r18 ? 1 : (r16 == r18 ? 0 : -1))
            if (r16 >= 0) goto L74
            int r16 = r9 << 3
            int r16 = r16 + r15
            r17 = r4[r16]
            r16 = r5[r16]
            r8 = -1
            if (r10 != r8) goto L59
            java.lang.String r1 = "..."
            r3.append(r1)
            goto L8a
        L59:
            if (r10 == 0) goto L5e
            r3.append(r1)
        L5e:
            java.lang.Long r8 = java.lang.Long.valueOf(r17)
            r17 = r14
            java.lang.Float r14 = java.lang.Float.valueOf(r16)
            java.lang.Object r8 = r2.invoke(r8, r14)
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            r3.append(r8)
            int r10 = r10 + 1
            goto L76
        L74:
            r17 = r14
        L76:
            long r11 = r11 >> r17
            int r15 = r15 + 1
            r14 = r17
            goto L3c
        L7d:
            r8 = r14
            if (r13 != r8) goto L85
        L80:
            if (r9 == r7) goto L85
            int r9 = r9 + 1
            goto L22
        L85:
            java.lang.String r1 = ""
            r3.append(r1)
        L8a:
            java.lang.String r1 = r3.toString()
            java.lang.String r2 = "StringBuilder().apply(builderAction).toString()"
            kotlin.jvm.internal.k.d(r1, r2)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.LongFloatMap.joinToString(java.lang.CharSequence, java.lang.CharSequence, e6.p):java.lang.String");
    }

    public static /* synthetic */ String joinToString$default(LongFloatMap longFloatMap, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i2, CharSequence charSequence4, p pVar, int i8, Object obj) {
        long[] jArr;
        long[] jArr2;
        int i9;
        if (obj == null) {
            CharSequence separator = (i8 & 1) != 0 ? ", " : charSequence;
            CharSequence prefix = (i8 & 2) != 0 ? "" : charSequence2;
            CharSequence postfix = (i8 & 4) == 0 ? charSequence3 : "";
            int i10 = (i8 & 8) != 0 ? -1 : i2;
            CharSequence charSequence5 = (i8 & 16) != 0 ? "..." : charSequence4;
            k.e(separator, "separator");
            k.e(prefix, "prefix");
            k.e(postfix, "postfix");
            StringBuilder sbP = a.p(charSequence5, "truncated", pVar, "transform", prefix);
            long[] jArr3 = longFloatMap.keys;
            float[] fArr = longFloatMap.values;
            long[] jArr4 = longFloatMap.metadata;
            int length = jArr4.length - 2;
            if (length >= 0) {
                int i11 = 0;
                int i12 = 0;
                loop0: while (true) {
                    long j = jArr4[i11];
                    int i13 = i11;
                    if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                        int i14 = 8;
                        int i15 = 8 - ((~(i13 - length)) >>> 31);
                        int i16 = 0;
                        while (i16 < i15) {
                            if ((j & 255) < 128) {
                                int i17 = (i13 << 3) + i16;
                                long j3 = jArr3[i17];
                                float f4 = fArr[i17];
                                if (i12 == i10) {
                                    sbP.append(charSequence5);
                                    break loop0;
                                }
                                if (i12 != 0) {
                                    sbP.append(separator);
                                }
                                i9 = i14;
                                Long lValueOf = Long.valueOf(j3);
                                jArr2 = jArr4;
                                sbP.append((CharSequence) pVar.invoke(lValueOf, Float.valueOf(f4)));
                                i12++;
                            } else {
                                jArr2 = jArr4;
                                i9 = i14;
                            }
                            j >>= i9;
                            i16++;
                            i14 = i9;
                            jArr4 = jArr2;
                        }
                        jArr = jArr4;
                        if (i15 != i14) {
                            break;
                        }
                    } else {
                        jArr = jArr4;
                    }
                    if (i13 == length) {
                        break;
                    }
                    i11 = i13 + 1;
                    jArr4 = jArr;
                }
                sbP.append(postfix);
            } else {
                sbP.append(postfix);
            }
            String string = sbP.toString();
            k.d(string, "StringBuilder().apply(builderAction).toString()");
            return string;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: joinToString");
    }

    public static /* synthetic */ void getKeys$annotations() {
    }

    public static /* synthetic */ void getMetadata$annotations() {
    }

    public static /* synthetic */ void getValues$annotations() {
    }

    public static /* synthetic */ void get_capacity$collection$annotations() {
    }

    public static /* synthetic */ void get_size$collection$annotations() {
    }

    public final String joinToString(CharSequence separator, CharSequence prefix, CharSequence postfix) {
        k.e(separator, "separator");
        k.e(prefix, "prefix");
        k.e(postfix, "postfix");
        return joinToString$default(this, separator, prefix, postfix, 0, null, 24, null);
    }

    public final String joinToString(CharSequence separator, CharSequence prefix, CharSequence postfix, int i2) {
        k.e(separator, "separator");
        k.e(prefix, "prefix");
        k.e(postfix, "postfix");
        return joinToString$default(this, separator, prefix, postfix, i2, null, 16, null);
    }

    public final String joinToString(CharSequence charSequence, CharSequence prefix, CharSequence charSequence2, int i2, p pVar) {
        int i8;
        CharSequence separator = charSequence;
        k.e(separator, "separator");
        k.e(prefix, "prefix");
        StringBuilder sbP = a.p(charSequence2, "postfix", pVar, "transform", prefix);
        long[] jArr = this.keys;
        float[] fArr = this.values;
        long[] jArr2 = this.metadata;
        int length = jArr2.length - 2;
        if (length >= 0) {
            int i9 = 0;
            int i10 = 0;
            loop0: while (true) {
                long j = jArr2[i9];
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i11 = 8;
                    int i12 = 8 - ((~(i9 - length)) >>> 31);
                    int i13 = 0;
                    while (i13 < i12) {
                        if ((j & 255) < 128) {
                            int i14 = (i9 << 3) + i13;
                            long j3 = jArr[i14];
                            float f4 = fArr[i14];
                            i8 = i11;
                            if (i10 == i2) {
                                sbP.append((CharSequence) "...");
                                break loop0;
                            }
                            if (i10 != 0) {
                                sbP.append(separator);
                            }
                            sbP.append((CharSequence) pVar.invoke(Long.valueOf(j3), Float.valueOf(f4)));
                            i10++;
                        } else {
                            i8 = i11;
                        }
                        j >>= i8;
                        i13++;
                        separator = charSequence;
                        i11 = i8;
                    }
                    if (i12 != i11) {
                        break;
                    }
                }
                if (i9 == length) {
                    break;
                }
                i9++;
                separator = charSequence;
            }
            sbP.append(charSequence2);
        } else {
            sbP.append(charSequence2);
        }
        String string = sbP.toString();
        k.d(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public final String joinToString(CharSequence separator, CharSequence prefix, CharSequence charSequence, int i2, CharSequence charSequence2) {
        float[] fArr;
        long[] jArr;
        float[] fArr2;
        long[] jArr2;
        int i8;
        k.e(separator, "separator");
        k.e(prefix, "prefix");
        StringBuilder sbQ = a.q(charSequence, "postfix", charSequence2, "truncated", prefix);
        long[] jArr3 = this.keys;
        float[] fArr3 = this.values;
        long[] jArr4 = this.metadata;
        int length = jArr4.length - 2;
        if (length >= 0) {
            int i9 = 0;
            int i10 = 0;
            loop0: while (true) {
                long j = jArr4[i9];
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i11 = 8;
                    int i12 = 8 - ((~(i9 - length)) >>> 31);
                    int i13 = 0;
                    while (i13 < i12) {
                        if ((j & 255) < 128) {
                            int i14 = (i9 << 3) + i13;
                            fArr2 = fArr3;
                            jArr2 = jArr4;
                            long j3 = jArr3[i14];
                            i8 = i11;
                            float f4 = fArr2[i14];
                            if (i10 == i2) {
                                sbQ.append(charSequence2);
                                break loop0;
                            }
                            if (i10 != 0) {
                                sbQ.append(separator);
                            }
                            sbQ.append(j3);
                            sbQ.append(G5.T);
                            sbQ.append(f4);
                            i10++;
                        } else {
                            fArr2 = fArr3;
                            jArr2 = jArr4;
                            i8 = i11;
                        }
                        j >>= i8;
                        i13++;
                        fArr3 = fArr2;
                        jArr4 = jArr2;
                        i11 = i8;
                    }
                    fArr = fArr3;
                    jArr = jArr4;
                    if (i12 != i11) {
                        break;
                    }
                } else {
                    fArr = fArr3;
                    jArr = jArr4;
                }
                if (i9 == length) {
                    break;
                }
                i9++;
                fArr3 = fArr;
                jArr4 = jArr;
            }
            sbQ.append(charSequence);
        } else {
            sbQ.append(charSequence);
        }
        String string = sbQ.toString();
        k.d(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0091 A[PHI: r12
  0x0091: PHI (r12v2 int) = (r12v1 int), (r12v3 int) binds: [B:6:0x0042, B:19:0x008f] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String joinToString(java.lang.CharSequence r22, java.lang.CharSequence r23, java.lang.CharSequence r24, int r25, java.lang.CharSequence r26, e6.p r27) {
        /*
            r21 = this;
            r0 = r21
            r1 = r22
            r2 = r23
            r3 = r24
            r4 = r26
            r5 = r27
            java.lang.String r6 = "separator"
            kotlin.jvm.internal.k.e(r1, r6)
            java.lang.String r6 = "prefix"
            kotlin.jvm.internal.k.e(r2, r6)
            java.lang.String r6 = "postfix"
            kotlin.jvm.internal.k.e(r3, r6)
            java.lang.String r6 = "truncated"
            java.lang.String r7 = "transform"
            java.lang.StringBuilder r2 = androidx.camera.core.processing.util.a.p(r4, r6, r5, r7, r2)
            long[] r6 = r0.keys
            float[] r7 = r0.values
            long[] r8 = r0.metadata
            int r9 = r8.length
            int r9 = r9 + (-2)
            if (r9 < 0) goto L9a
            r11 = 0
            r12 = 0
        L30:
            r13 = r8[r11]
            r15 = r11
            long r10 = ~r13
            r16 = 7
            long r10 = r10 << r16
            long r10 = r10 & r13
            r16 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r10 = r10 & r16
            int r10 = (r10 > r16 ? 1 : (r10 == r16 ? 0 : -1))
            if (r10 == 0) goto L91
            int r11 = r15 - r9
            int r10 = ~r11
            int r10 = r10 >>> 31
            r11 = 8
            int r10 = 8 - r10
            r16 = r11
            r11 = 0
        L50:
            if (r11 >= r10) goto L8d
            r17 = 255(0xff, double:1.26E-321)
            long r17 = r13 & r17
            r19 = 128(0x80, double:6.3E-322)
            int r17 = (r17 > r19 ? 1 : (r17 == r19 ? 0 : -1))
            if (r17 >= 0) goto L84
            int r17 = r15 << 3
            int r17 = r17 + r11
            r18 = r6[r17]
            r17 = r7[r17]
            r0 = r25
            if (r12 != r0) goto L6c
            r2.append(r4)
            goto L9d
        L6c:
            if (r12 == 0) goto L71
            r2.append(r1)
        L71:
            java.lang.Long r0 = java.lang.Long.valueOf(r18)
            java.lang.Float r1 = java.lang.Float.valueOf(r17)
            java.lang.Object r0 = r5.invoke(r0, r1)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r2.append(r0)
            int r12 = r12 + 1
        L84:
            long r13 = r13 >> r16
            int r11 = r11 + 1
            r0 = r21
            r1 = r22
            goto L50
        L8d:
            r0 = r16
            if (r10 != r0) goto L9a
        L91:
            if (r15 == r9) goto L9a
            int r11 = r15 + 1
            r0 = r21
            r1 = r22
            goto L30
        L9a:
            r2.append(r3)
        L9d:
            java.lang.String r0 = r2.toString()
            java.lang.String r1 = "StringBuilder().apply(builderAction).toString()"
            kotlin.jvm.internal.k.d(r0, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.LongFloatMap.joinToString(java.lang.CharSequence, java.lang.CharSequence, java.lang.CharSequence, int, java.lang.CharSequence, e6.p):java.lang.String");
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x008c A[PHI: r11
  0x008c: PHI (r11v2 int) = (r11v1 int), (r11v3 int) binds: [B:6:0x003a, B:20:0x008a] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String joinToString(java.lang.CharSequence r21, java.lang.CharSequence r22, java.lang.CharSequence r23, e6.p r24) {
        /*
            r20 = this;
            r0 = r20
            r1 = r21
            r2 = r22
            r3 = r23
            r4 = r24
            java.lang.String r5 = "separator"
            kotlin.jvm.internal.k.e(r1, r5)
            java.lang.String r5 = "prefix"
            kotlin.jvm.internal.k.e(r2, r5)
            java.lang.String r5 = "postfix"
            java.lang.String r6 = "transform"
            java.lang.StringBuilder r2 = androidx.camera.core.processing.util.a.p(r3, r5, r4, r6, r2)
            long[] r5 = r0.keys
            float[] r6 = r0.values
            long[] r7 = r0.metadata
            int r8 = r7.length
            int r8 = r8 + (-2)
            if (r8 < 0) goto L93
            r10 = 0
            r11 = 0
        L29:
            r12 = r7[r10]
            long r14 = ~r12
            r16 = 7
            long r14 = r14 << r16
            long r14 = r14 & r12
            r16 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r14 = r14 & r16
            int r14 = (r14 > r16 ? 1 : (r14 == r16 ? 0 : -1))
            if (r14 == 0) goto L8c
            int r14 = r10 - r8
            int r14 = ~r14
            int r14 = r14 >>> 31
            r15 = 8
            int r14 = 8 - r14
            r9 = 0
        L46:
            if (r9 >= r14) goto L89
            r16 = 255(0xff, double:1.26E-321)
            long r16 = r12 & r16
            r18 = 128(0x80, double:6.3E-322)
            int r16 = (r16 > r18 ? 1 : (r16 == r18 ? 0 : -1))
            if (r16 >= 0) goto L7e
            int r16 = r10 << 3
            int r16 = r16 + r9
            r17 = r5[r16]
            r16 = r6[r16]
            r19 = r15
            r15 = -1
            if (r11 != r15) goto L65
            java.lang.String r1 = "..."
            r2.append(r1)
            goto L96
        L65:
            if (r11 == 0) goto L6a
            r2.append(r1)
        L6a:
            java.lang.Long r15 = java.lang.Long.valueOf(r17)
            java.lang.Float r0 = java.lang.Float.valueOf(r16)
            java.lang.Object r0 = r4.invoke(r15, r0)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r2.append(r0)
            int r11 = r11 + 1
            goto L80
        L7e:
            r19 = r15
        L80:
            long r12 = r12 >> r19
            int r9 = r9 + 1
            r0 = r20
            r15 = r19
            goto L46
        L89:
            r0 = r15
            if (r14 != r0) goto L93
        L8c:
            if (r10 == r8) goto L93
            int r10 = r10 + 1
            r0 = r20
            goto L29
        L93:
            r2.append(r3)
        L96:
            java.lang.String r0 = r2.toString()
            java.lang.String r1 = "StringBuilder().apply(builderAction).toString()"
            kotlin.jvm.internal.k.d(r0, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.LongFloatMap.joinToString(java.lang.CharSequence, java.lang.CharSequence, java.lang.CharSequence, e6.p):java.lang.String");
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0087 A[PHI: r11
  0x0087: PHI (r11v2 int) = (r11v1 int), (r11v3 int) binds: [B:6:0x0035, B:20:0x0085] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String joinToString(java.lang.CharSequence r22, e6.p r23) {
        /*
            r21 = this;
            r0 = r21
            r1 = r22
            r2 = r23
            java.lang.String r3 = "separator"
            kotlin.jvm.internal.k.e(r1, r3)
            java.lang.String r3 = "transform"
            kotlin.jvm.internal.k.e(r2, r3)
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = ""
            r3.<init>(r4)
            long[] r5 = r0.keys
            float[] r6 = r0.values
            long[] r7 = r0.metadata
            int r8 = r7.length
            int r8 = r8 + (-2)
            if (r8 < 0) goto L8e
            r10 = 0
            r11 = 0
        L24:
            r12 = r7[r10]
            long r14 = ~r12
            r16 = 7
            long r14 = r14 << r16
            long r14 = r14 & r12
            r16 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r14 = r14 & r16
            int r14 = (r14 > r16 ? 1 : (r14 == r16 ? 0 : -1))
            if (r14 == 0) goto L87
            int r14 = r10 - r8
            int r14 = ~r14
            int r14 = r14 >>> 31
            r15 = 8
            int r14 = 8 - r14
            r9 = 0
        L41:
            if (r9 >= r14) goto L84
            r17 = 255(0xff, double:1.26E-321)
            long r17 = r12 & r17
            r19 = 128(0x80, double:6.3E-322)
            int r17 = (r17 > r19 ? 1 : (r17 == r19 ? 0 : -1))
            if (r17 >= 0) goto L79
            int r17 = r10 << 3
            int r17 = r17 + r9
            r18 = r5[r17]
            r17 = r6[r17]
            r20 = r15
            r15 = -1
            if (r11 != r15) goto L60
            java.lang.String r1 = "..."
            r3.append(r1)
            goto L91
        L60:
            if (r11 == 0) goto L65
            r3.append(r1)
        L65:
            java.lang.Long r15 = java.lang.Long.valueOf(r18)
            java.lang.Float r0 = java.lang.Float.valueOf(r17)
            java.lang.Object r0 = r2.invoke(r15, r0)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r3.append(r0)
            int r11 = r11 + 1
            goto L7b
        L79:
            r20 = r15
        L7b:
            long r12 = r12 >> r20
            int r9 = r9 + 1
            r0 = r21
            r15 = r20
            goto L41
        L84:
            r0 = r15
            if (r14 != r0) goto L8e
        L87:
            if (r10 == r8) goto L8e
            int r10 = r10 + 1
            r0 = r21
            goto L24
        L8e:
            r3.append(r4)
        L91:
            java.lang.String r0 = r3.toString()
            java.lang.String r1 = "StringBuilder().apply(builderAction).toString()"
            kotlin.jvm.internal.k.d(r0, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.LongFloatMap.joinToString(java.lang.CharSequence, e6.p):java.lang.String");
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x007d A[PHI: r10
  0x007d: PHI (r10v2 int) = (r10v1 int), (r10v3 int) binds: [B:6:0x002b, B:20:0x007b] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String joinToString(e6.p r21) {
        /*
            r20 = this;
            r0 = r20
            r1 = r21
            java.lang.String r2 = "transform"
            kotlin.jvm.internal.k.e(r1, r2)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = ""
            r2.<init>(r3)
            long[] r4 = r0.keys
            float[] r5 = r0.values
            long[] r6 = r0.metadata
            int r7 = r6.length
            int r7 = r7 + (-2)
            if (r7 < 0) goto L82
            r9 = 0
            r10 = 0
        L1d:
            r11 = r6[r9]
            long r13 = ~r11
            r15 = 7
            long r13 = r13 << r15
            long r13 = r13 & r11
            r15 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r13 = r13 & r15
            int r13 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1))
            if (r13 == 0) goto L7d
            int r13 = r9 - r7
            int r13 = ~r13
            int r13 = r13 >>> 31
            r14 = 8
            int r13 = 8 - r13
            r15 = 0
        L37:
            if (r15 >= r13) goto L7a
            r16 = 255(0xff, double:1.26E-321)
            long r16 = r11 & r16
            r18 = 128(0x80, double:6.3E-322)
            int r16 = (r16 > r18 ? 1 : (r16 == r18 ? 0 : -1))
            if (r16 >= 0) goto L71
            int r16 = r9 << 3
            int r16 = r16 + r15
            r17 = r4[r16]
            r16 = r5[r16]
            r8 = -1
            if (r10 != r8) goto L54
            java.lang.String r1 = "..."
            r2.append(r1)
            goto L85
        L54:
            if (r10 == 0) goto L5b
            java.lang.String r8 = ", "
            r2.append(r8)
        L5b:
            java.lang.Long r8 = java.lang.Long.valueOf(r17)
            r17 = r14
            java.lang.Float r14 = java.lang.Float.valueOf(r16)
            java.lang.Object r8 = r1.invoke(r8, r14)
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            r2.append(r8)
            int r10 = r10 + 1
            goto L73
        L71:
            r17 = r14
        L73:
            long r11 = r11 >> r17
            int r15 = r15 + 1
            r14 = r17
            goto L37
        L7a:
            r8 = r14
            if (r13 != r8) goto L82
        L7d:
            if (r9 == r7) goto L82
            int r9 = r9 + 1
            goto L1d
        L82:
            r2.append(r3)
        L85:
            java.lang.String r1 = r2.toString()
            java.lang.String r2 = "StringBuilder().apply(builderAction).toString()"
            kotlin.jvm.internal.k.d(r1, r2)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.LongFloatMap.joinToString(e6.p):java.lang.String");
    }
}
