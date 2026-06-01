package androidx.collection.internal;

import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class ContainerHelpersKt {
    public static final int[] EMPTY_INTS = new int[0];
    public static final long[] EMPTY_LONGS = new long[0];
    public static final Object[] EMPTY_OBJECTS = new Object[0];

    public static final int binarySearch(int[] array, int i2, int i8) {
        k.e(array, "array");
        int i9 = i2 - 1;
        int i10 = 0;
        while (i10 <= i9) {
            int i11 = (i10 + i9) >>> 1;
            int i12 = array[i11];
            if (i12 < i8) {
                i10 = i11 + 1;
            } else {
                if (i12 <= i8) {
                    return i11;
                }
                i9 = i11 - 1;
            }
        }
        return ~i10;
    }

    public static final boolean equal(Object obj, Object obj2) {
        return k.a(obj, obj2);
    }

    public static final int idealByteArraySize(int i2) {
        for (int i8 = 4; i8 < 32; i8++) {
            int i9 = (1 << i8) - 12;
            if (i2 <= i9) {
                return i9;
            }
        }
        return i2;
    }

    public static final int idealIntArraySize(int i2) {
        return idealByteArraySize(i2 * 4) / 4;
    }

    public static final int idealLongArraySize(int i2) {
        return idealByteArraySize(i2 * 8) / 8;
    }

    public static final int binarySearch(long[] array, int i2, long j) {
        k.e(array, "array");
        int i8 = i2 - 1;
        int i9 = 0;
        while (i9 <= i8) {
            int i10 = (i9 + i8) >>> 1;
            long j3 = array[i10];
            if (j3 < j) {
                i9 = i10 + 1;
            } else {
                if (j3 <= j) {
                    return i10;
                }
                i8 = i10 - 1;
            }
        }
        return ~i9;
    }
}
