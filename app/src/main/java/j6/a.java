package j6;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class a extends i6.a {
    @Override // i6.d
    public final long e(long j, long j3) {
        return ThreadLocalRandom.current().nextLong(j, j3);
    }

    @Override // i6.a
    public final Random f() {
        ThreadLocalRandom threadLocalRandomCurrent = ThreadLocalRandom.current();
        k.d(threadLocalRandomCurrent, "current(...)");
        return threadLocalRandomCurrent;
    }
}
