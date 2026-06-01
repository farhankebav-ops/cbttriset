package z6;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class h {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final e2.f f18001b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final e2.f f18002c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final e2.f f18003d;
    public static final e2.f e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f18000a = v6.a.j(100, 12, "kotlinx.coroutines.semaphore.maxSpinCycles");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f18004f = v6.a.j(16, 12, "kotlinx.coroutines.semaphore.segmentSize");

    static {
        int i2 = 5;
        boolean z2 = false;
        f18001b = new e2.f("PERMIT", i2, z2);
        f18002c = new e2.f("TAKEN", i2, z2);
        f18003d = new e2.f("BROKEN", i2, z2);
        e = new e2.f("CANCELLED", i2, z2);
    }
}
