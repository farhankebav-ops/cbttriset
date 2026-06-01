package c1;

import android.animation.TimeInterpolator;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f4174a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f4175b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TimeInterpolator f4176c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f4177d;
    public int e;

    public final TimeInterpolator a() {
        TimeInterpolator timeInterpolator = this.f4176c;
        return timeInterpolator != null ? timeInterpolator : a.f4169b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        if (this.f4174a == cVar.f4174a && this.f4175b == cVar.f4175b && this.f4177d == cVar.f4177d && this.e == cVar.e) {
            return a().getClass().equals(cVar.a().getClass());
        }
        return false;
    }

    public final int hashCode() {
        long j = this.f4174a;
        long j3 = this.f4175b;
        return ((((a().getClass().hashCode() + (((((int) (j ^ (j >>> 32))) * 31) + ((int) ((j3 >>> 32) ^ j3))) * 31)) * 31) + this.f4177d) * 31) + this.e;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("\n");
        sb.append(c.class.getName());
        sb.append('{');
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" delay: ");
        sb.append(this.f4174a);
        sb.append(" duration: ");
        sb.append(this.f4175b);
        sb.append(" interpolator: ");
        sb.append(a().getClass());
        sb.append(" repeatCount: ");
        sb.append(this.f4177d);
        sb.append(" repeatMode: ");
        return a1.a.q(sb, "}\n", this.e);
    }
}
