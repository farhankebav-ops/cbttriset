package z4;

import i5.o;
import r4.c;
import w1.f;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final c f17983c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final f f17984d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f17981a = new c(8);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final o f17982b = new o(1);
    public static final f e = new f(8);

    static {
        int i2 = 7;
        f17983c = new c(i2);
        f17984d = new f(i2);
    }

    public static void a(Object obj, String str) {
        if (obj == null) {
            throw new NullPointerException(str);
        }
    }

    public static void b(int i2, String str) {
        if (i2 > 0) {
            return;
        }
        throw new IllegalArgumentException(str + " > 0 required but it was " + i2);
    }
}
