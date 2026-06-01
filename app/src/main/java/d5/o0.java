package d5;

import androidx.core.location.LocationRequestCompat;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class o0 extends AtomicLong implements o7.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final s4.g f11128a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile p0 f11129b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f11130c;

    public o0(s4.g gVar) {
        this.f11128a = gVar;
    }

    @Override // o7.b
    public final void c(long j) {
        long j3;
        if (k5.f.d(j)) {
            do {
                j3 = get();
                if (j3 == Long.MIN_VALUE || j3 == LocationRequestCompat.PASSIVE_INTERVAL) {
                    break;
                }
            } while (!compareAndSet(j3, a.a.g(j3, j)));
            p0 p0Var = this.f11129b;
            if (p0Var != null) {
                p0Var.c();
            }
        }
    }

    @Override // o7.b
    public final void cancel() {
        p0 p0Var;
        if (get() == Long.MIN_VALUE || getAndSet(Long.MIN_VALUE) == Long.MIN_VALUE || (p0Var = this.f11129b) == null) {
            return;
        }
        p0Var.g(this);
        p0Var.c();
    }
}
