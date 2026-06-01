package androidx.core.content.res;

import java.lang.reflect.Array;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
final class GrowingArrayUtils {
    private GrowingArrayUtils() {
    }

    public static <T> T[] append(T[] tArr, int i2, T t3) {
        if (i2 + 1 > tArr.length) {
            Object[] objArr = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), growSize(i2));
            System.arraycopy(tArr, 0, objArr, 0, i2);
            tArr = (T[]) objArr;
        }
        tArr[i2] = t3;
        return tArr;
    }

    public static int growSize(int i2) {
        if (i2 <= 4) {
            return 8;
        }
        return i2 * 2;
    }

    public static <T> T[] insert(T[] tArr, int i2, int i8, T t3) {
        if (i2 + 1 <= tArr.length) {
            System.arraycopy(tArr, i8, tArr, i8 + 1, i2 - i8);
            tArr[i8] = t3;
            return tArr;
        }
        T[] tArr2 = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), growSize(i2)));
        System.arraycopy(tArr, 0, tArr2, 0, i8);
        tArr2[i8] = t3;
        System.arraycopy(tArr, i8, tArr2, i8 + 1, tArr.length - i8);
        return tArr2;
    }

    public static int[] append(int[] iArr, int i2, int i8) {
        if (i2 + 1 > iArr.length) {
            int[] iArr2 = new int[growSize(i2)];
            System.arraycopy(iArr, 0, iArr2, 0, i2);
            iArr = iArr2;
        }
        iArr[i2] = i8;
        return iArr;
    }

    public static int[] insert(int[] iArr, int i2, int i8, int i9) {
        if (i2 + 1 <= iArr.length) {
            System.arraycopy(iArr, i8, iArr, i8 + 1, i2 - i8);
            iArr[i8] = i9;
            return iArr;
        }
        int[] iArr2 = new int[growSize(i2)];
        System.arraycopy(iArr, 0, iArr2, 0, i8);
        iArr2[i8] = i9;
        System.arraycopy(iArr, i8, iArr2, i8 + 1, iArr.length - i8);
        return iArr2;
    }

    public static long[] append(long[] jArr, int i2, long j) {
        if (i2 + 1 > jArr.length) {
            long[] jArr2 = new long[growSize(i2)];
            System.arraycopy(jArr, 0, jArr2, 0, i2);
            jArr = jArr2;
        }
        jArr[i2] = j;
        return jArr;
    }

    public static boolean[] append(boolean[] zArr, int i2, boolean z2) {
        if (i2 + 1 > zArr.length) {
            boolean[] zArr2 = new boolean[growSize(i2)];
            System.arraycopy(zArr, 0, zArr2, 0, i2);
            zArr = zArr2;
        }
        zArr[i2] = z2;
        return zArr;
    }

    public static long[] insert(long[] jArr, int i2, int i8, long j) {
        if (i2 + 1 <= jArr.length) {
            System.arraycopy(jArr, i8, jArr, i8 + 1, i2 - i8);
            jArr[i8] = j;
            return jArr;
        }
        long[] jArr2 = new long[growSize(i2)];
        System.arraycopy(jArr, 0, jArr2, 0, i8);
        jArr2[i8] = j;
        System.arraycopy(jArr, i8, jArr2, i8 + 1, jArr.length - i8);
        return jArr2;
    }

    public static boolean[] insert(boolean[] zArr, int i2, int i8, boolean z2) {
        if (i2 + 1 <= zArr.length) {
            System.arraycopy(zArr, i8, zArr, i8 + 1, i2 - i8);
            zArr[i8] = z2;
            return zArr;
        }
        boolean[] zArr2 = new boolean[growSize(i2)];
        System.arraycopy(zArr, 0, zArr2, 0, i8);
        zArr2[i8] = z2;
        System.arraycopy(zArr, i8, zArr2, i8 + 1, zArr.length - i8);
        return zArr2;
    }
}
