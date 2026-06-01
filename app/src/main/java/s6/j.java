package s6;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final p f13737a = new p(-1, null, null, 0);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f13738b = v6.a.j(32, 12, "kotlinx.coroutines.bufferedChannel.segmentSize");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f13739c = v6.a.j(10000, 12, "kotlinx.coroutines.bufferedChannel.expandBufferCompletionWaitIterations");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final e2.f f13740d = new e2.f("BUFFERED", 5, false);
    public static final e2.f e = new e2.f("SHOULD_BUFFER", 5, false);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final e2.f f13741f = new e2.f("S_RESUMING_BY_RCV", 5, false);
    public static final e2.f g = new e2.f("RESUMING_BY_EB", 5, false);
    public static final e2.f h = new e2.f("POISONED", 5, false);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final e2.f f13742i = new e2.f("DONE_RCV", 5, false);
    public static final e2.f j = new e2.f("INTERRUPTED_SEND", 5, false);
    public static final e2.f k = new e2.f("INTERRUPTED_RCV", 5, false);
    public static final e2.f l = new e2.f("CHANNEL_CLOSED", 5, false);
    public static final e2.f m = new e2.f("SUSPEND", 5, false);

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final e2.f f13743n = new e2.f("SUSPEND_NO_WAITER", 5, false);

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final e2.f f13744o = new e2.f("FAILED", 5, false);
    public static final e2.f p = new e2.f("NO_RECEIVE_RESULT", 5, false);

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final e2.f f13745q = new e2.f("CLOSE_HANDLER_CLOSED", 5, false);

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final e2.f f13746r = new e2.f("CLOSE_HANDLER_INVOKED", 5, false);

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final e2.f f13747s = new e2.f("NO_CLOSE_CAUSE", 5, false);

    public static final boolean a(q6.j jVar, Object obj, e6.q qVar) {
        e2.f fVarF = jVar.f(obj, qVar);
        if (fVarF == null) {
            return false;
        }
        jVar.q(fVarF);
        return true;
    }
}
