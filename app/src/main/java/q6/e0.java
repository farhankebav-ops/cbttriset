package q6;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class e0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h0 f13545a;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [r6.c] */
    /* JADX WARN: Type inference failed for: r0v7, types: [q6.d0] */
    /* JADX WARN: Type inference failed for: r0v8, types: [q6.h0] */
    /* JADX WARN: Type inference failed for: r0v9, types: [q6.d0] */
    static {
        String property;
        ?? r02;
        int i2 = v6.u.f17650a;
        try {
            property = System.getProperty("kotlinx.coroutines.main.delay");
        } catch (SecurityException unused) {
            property = null;
        }
        if (property != null ? Boolean.parseBoolean(property) : false) {
            x6.e eVar = m0.f13566a;
            r02 = v6.n.f17641a;
            r6.c cVar = r02.f13648c;
            if (!(r02 != 0)) {
                r02 = d0.h;
            }
        } else {
            r02 = d0.h;
        }
        f13545a = r02;
    }
}
