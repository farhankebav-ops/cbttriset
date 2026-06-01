package z5;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static u.b f17986a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f17987b = 10;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static int f17988c = 10;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static int f17989d = 10;
    public static int e = 10;

    public static final int a(int i2, int i8, int i9) {
        if (i9 > 0) {
            if (i2 < i8) {
                int i10 = i8 % i9;
                if (i10 < 0) {
                    i10 += i9;
                }
                int i11 = i2 % i9;
                if (i11 < 0) {
                    i11 += i9;
                }
                int i12 = (i10 - i11) % i9;
                if (i12 < 0) {
                    i12 += i9;
                }
                return i8 - i12;
            }
        } else {
            if (i9 >= 0) {
                throw new IllegalArgumentException("Step is zero.");
            }
            if (i2 > i8) {
                int i13 = -i9;
                int i14 = i2 % i13;
                if (i14 < 0) {
                    i14 += i13;
                }
                int i15 = i8 % i13;
                if (i15 < 0) {
                    i15 += i13;
                }
                int i16 = (i14 - i15) % i13;
                if (i16 < 0) {
                    i16 += i13;
                }
                return i16 + i8;
            }
        }
        return i8;
    }
}
