package h7;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f11745a;

    static {
        Object objM;
        try {
            String property = System.getProperty("kotlinx.serialization.json.pool.size");
            kotlin.jvm.internal.k.d(property, "getProperty(...)");
            objM = n6.t.o0(property);
        } catch (Throwable th) {
            objM = r2.q.M(th);
        }
        if (objM instanceof q5.j) {
            objM = null;
        }
        Integer num = (Integer) objM;
        f11745a = num != null ? num.intValue() : 2097152;
    }
}
