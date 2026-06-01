package j4;

import java.util.Random;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class x0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Random f12542a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f12543b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public double f12544c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public double f12545d;
    public long e;

    public final long a() {
        long j = this.e;
        double d8 = j;
        this.e = Math.min((long) (this.f12544c * d8), this.f12543b);
        double d9 = this.f12545d;
        double d10 = (-d9) * d8;
        double d11 = d9 * d8;
        r2.q.x(d11 >= d10);
        return j + ((long) ((this.f12542a.nextDouble() * (d11 - d10)) + d10));
    }
}
