package j4;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class h1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f12237a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f12238b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final f2.i f12239c;

    /* JADX WARN: Removed duplicated region for block: B:9:0x001b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public h1(int r1, long r2, java.util.Set r4) {
        /*
            r0 = this;
            r0.<init>()
            r0.f12237a = r1
            r0.f12238b = r2
            int r1 = f2.i.f11331c
            boolean r1 = r4 instanceof f2.i
            if (r1 == 0) goto L1b
            boolean r1 = r4 instanceof java.util.SortedSet
            if (r1 != 0) goto L1b
            r1 = r4
            f2.i r1 = (f2.i) r1
            boolean r2 = r1.f()
            if (r2 != 0) goto L1b
            goto L24
        L1b:
            java.lang.Object[] r1 = r4.toArray()
            int r2 = r1.length
            f2.i r1 = f2.i.h(r2, r1)
        L24:
            r0.f12239c = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: j4.h1.<init>(int, long, java.util.Set):void");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || h1.class != obj.getClass()) {
            return false;
        }
        h1 h1Var = (h1) obj;
        return this.f12237a == h1Var.f12237a && this.f12238b == h1Var.f12238b && Objects.equals(this.f12239c, h1Var.f12239c);
    }

    public final int hashCode() {
        return Objects.hash(Integer.valueOf(this.f12237a), Long.valueOf(this.f12238b), this.f12239c);
    }

    public final String toString() {
        e2.i iVarY = a.a.Y(this);
        iVarY.f("maxAttempts", String.valueOf(this.f12237a));
        iVarY.d("hedgingDelayNanos", this.f12238b);
        iVarY.c(this.f12239c, "nonFatalStatusCodes");
        return iVarY.toString();
    }
}
