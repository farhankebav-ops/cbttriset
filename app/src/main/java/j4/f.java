package j4;

import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class f {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Logger f12180c = Logger.getLogger(f.class.getName());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f12181a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicLong f12182b;

    public f(long j) {
        AtomicLong atomicLong = new AtomicLong();
        this.f12182b = atomicLong;
        r2.q.y(j > 0, "value must be positive");
        this.f12181a = "keepalive time nanos";
        atomicLong.set(j);
    }
}
