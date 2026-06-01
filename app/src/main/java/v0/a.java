package v0;

import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final y0.a f17566a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap f17567b;

    public a(y0.a aVar, HashMap map) {
        this.f17566a = aVar;
        this.f17567b = map;
    }

    public final long a(m0.e eVar, long j, int i2) {
        long time = j - this.f17566a.getTime();
        b bVar = (b) this.f17567b.get(eVar);
        long j3 = bVar.f17568a;
        return Math.min(Math.max((long) (Math.pow(3.0d, i2 - 1) * j3 * Math.max(1.0d, Math.log(10000.0d) / Math.log((j3 > 1 ? j3 : 2L) * ((long) r12)))), time), bVar.f17569b);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.f17566a.equals(aVar.f17566a) && this.f17567b.equals(aVar.f17567b);
    }

    public final int hashCode() {
        return ((this.f17566a.hashCode() ^ 1000003) * 1000003) ^ this.f17567b.hashCode();
    }

    public final String toString() {
        return "SchedulerConfig{clock=" + this.f17566a + ", values=" + this.f17567b + "}";
    }
}
