package f7;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class w {
    public static final long[] e = new long[0];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d7.g f11532a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final h7.l f11533b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f11534c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long[] f11535d;

    public w(d7.g descriptor, h7.l lVar) {
        kotlin.jvm.internal.k.e(descriptor, "descriptor");
        this.f11532a = descriptor;
        this.f11533b = lVar;
        int iD = descriptor.d();
        if (iD <= 64) {
            this.f11534c = iD != 64 ? (-1) << iD : 0L;
            this.f11535d = e;
            return;
        }
        this.f11534c = 0L;
        int i2 = (iD - 1) >>> 6;
        long[] jArr = new long[i2];
        if ((iD & 63) != 0) {
            jArr[i2 - 1] = (-1) << iD;
        }
        this.f11535d = jArr;
    }
}
