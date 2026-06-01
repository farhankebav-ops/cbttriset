package l7;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class x extends r0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public r0 f12907a;

    public x(r0 delegate) {
        kotlin.jvm.internal.k.e(delegate, "delegate");
        this.f12907a = delegate;
    }

    @Override // l7.r0
    public final void awaitSignal(Condition condition) throws InterruptedIOException {
        kotlin.jvm.internal.k.e(condition, "condition");
        this.f12907a.awaitSignal(condition);
    }

    @Override // l7.r0
    public final r0 clearDeadline() {
        return this.f12907a.clearDeadline();
    }

    @Override // l7.r0
    public final r0 clearTimeout() {
        return this.f12907a.clearTimeout();
    }

    @Override // l7.r0
    public final long deadlineNanoTime() {
        return this.f12907a.deadlineNanoTime();
    }

    @Override // l7.r0
    public final boolean hasDeadline() {
        return this.f12907a.hasDeadline();
    }

    @Override // l7.r0
    public final void throwIfReached() throws IOException {
        this.f12907a.throwIfReached();
    }

    @Override // l7.r0
    public final r0 timeout(long j, TimeUnit unit) {
        kotlin.jvm.internal.k.e(unit, "unit");
        return this.f12907a.timeout(j, unit);
    }

    @Override // l7.r0
    public final long timeoutNanos() {
        return this.f12907a.timeoutNanos();
    }

    @Override // l7.r0
    public final void waitUntilNotified(Object monitor) throws InterruptedIOException {
        kotlin.jvm.internal.k.e(monitor, "monitor");
        this.f12907a.waitUntilNotified(monitor);
    }

    @Override // l7.r0
    public final r0 deadlineNanoTime(long j) {
        return this.f12907a.deadlineNanoTime(j);
    }
}
