package l7;

import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class p0 extends r0 {
    @Override // l7.r0
    public final r0 timeout(long j, TimeUnit unit) {
        kotlin.jvm.internal.k.e(unit, "unit");
        return this;
    }

    @Override // l7.r0
    public final void throwIfReached() {
    }

    @Override // l7.r0
    public final r0 deadlineNanoTime(long j) {
        return this;
    }
}
