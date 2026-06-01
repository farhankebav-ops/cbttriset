package q6;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class x1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ThreadLocal f13601a = new ThreadLocal();

    public static w0 a() {
        ThreadLocal threadLocal = f13601a;
        w0 w0Var = (w0) threadLocal.get();
        if (w0Var != null) {
            return w0Var;
        }
        g gVar = new g(Thread.currentThread());
        threadLocal.set(gVar);
        return gVar;
    }
}
