package j4;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class o4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f12352a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f12353b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f12354c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final double f12355d;
    public final Long e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final f2.i f12356f;

    /* JADX WARN: Removed duplicated region for block: B:9:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public o4(int r1, long r2, long r4, double r6, java.lang.Long r8, java.util.Set r9) {
        /*
            r0 = this;
            r0.<init>()
            r0.f12352a = r1
            r0.f12353b = r2
            r0.f12354c = r4
            r0.f12355d = r6
            r0.e = r8
            int r1 = f2.i.f11331c
            boolean r1 = r9 instanceof f2.i
            if (r1 == 0) goto L21
            boolean r1 = r9 instanceof java.util.SortedSet
            if (r1 != 0) goto L21
            r1 = r9
            f2.i r1 = (f2.i) r1
            boolean r2 = r1.f()
            if (r2 != 0) goto L21
            goto L2a
        L21:
            java.lang.Object[] r1 = r9.toArray()
            int r2 = r1.length
            f2.i r1 = f2.i.h(r2, r1)
        L2a:
            r0.f12356f = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: j4.o4.<init>(int, long, long, double, java.lang.Long, java.util.Set):void");
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof o4)) {
            return false;
        }
        o4 o4Var = (o4) obj;
        return this.f12352a == o4Var.f12352a && this.f12353b == o4Var.f12353b && this.f12354c == o4Var.f12354c && Double.compare(this.f12355d, o4Var.f12355d) == 0 && Objects.equals(this.e, o4Var.e) && Objects.equals(this.f12356f, o4Var.f12356f);
    }

    public final int hashCode() {
        return Objects.hash(Integer.valueOf(this.f12352a), Long.valueOf(this.f12353b), Long.valueOf(this.f12354c), Double.valueOf(this.f12355d), this.e, this.f12356f);
    }

    public final String toString() {
        e2.i iVarY = a.a.Y(this);
        iVarY.f("maxAttempts", String.valueOf(this.f12352a));
        iVarY.d("initialBackoffNanos", this.f12353b);
        iVarY.d("maxBackoffNanos", this.f12354c);
        iVarY.f("backoffMultiplier", String.valueOf(this.f12355d));
        iVarY.c(this.e, "perAttemptRecvTimeoutNanos");
        iVarY.c(this.f12356f, "retryableStatusCodes");
        return iVarY.toString();
    }
}
