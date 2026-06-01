package i4;

import java.util.Comparator;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class t0 implements Comparator {
    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        int i2;
        s0 s0Var = (s0) obj2;
        ((k4.i) ((s0) obj)).getClass();
        int i8 = 3;
        try {
            Class.forName("android.app.Application", false, k4.i.class.getClassLoader());
            i2 = 8;
        } catch (Exception unused) {
            i2 = 3;
        }
        ((k4.i) s0Var).getClass();
        try {
            Class.forName("android.app.Application", false, k4.i.class.getClassLoader());
            i8 = 8;
        } catch (Exception unused2) {
        }
        return i2 - i8;
    }
}
