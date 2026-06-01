package r5;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class b {
    public static void a(int i2, int i8, int i9) {
        if (i2 < 0 || i8 > i9) {
            StringBuilder sbW = a1.a.w(i2, "startIndex: ", ", endIndex: ", i8, ", size: ");
            sbW.append(i9);
            throw new IndexOutOfBoundsException(sbW.toString());
        }
        if (i2 > i8) {
            throw new IllegalArgumentException(androidx.camera.core.processing.util.a.i("startIndex: ", i2, " > endIndex: ", i8));
        }
    }

    public static void b(int i2, int i8) {
        if (i2 < 0 || i2 >= i8) {
            throw new IndexOutOfBoundsException(androidx.camera.core.processing.util.a.i("index: ", i2, ", size: ", i8));
        }
    }

    public static void c(int i2, int i8) {
        if (i2 < 0 || i2 > i8) {
            throw new IndexOutOfBoundsException(androidx.camera.core.processing.util.a.i("index: ", i2, ", size: ", i8));
        }
    }

    public static void d(int i2, int i8, int i9) {
        if (i2 < 0 || i8 > i9) {
            StringBuilder sbW = a1.a.w(i2, "fromIndex: ", ", toIndex: ", i8, ", size: ");
            sbW.append(i9);
            throw new IndexOutOfBoundsException(sbW.toString());
        }
        if (i2 > i8) {
            throw new IllegalArgumentException(androidx.camera.core.processing.util.a.i("fromIndex: ", i2, " > toIndex: ", i8));
        }
    }

    public static int e(int i2, int i8) {
        int i9 = i2 + (i2 >> 1);
        if (i9 - i8 < 0) {
            i9 = i8;
        }
        return i9 - 2147483639 > 0 ? i8 > 2147483639 ? Integer.MAX_VALUE : 2147483639 : i9;
    }
}
