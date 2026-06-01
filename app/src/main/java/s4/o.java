package s4;

import d5.i0;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class o implements u4.b {
    public abstract u4.b a(Runnable runnable, TimeUnit timeUnit);

    public void b(i0 i0Var) {
        a(i0Var, TimeUnit.NANOSECONDS);
    }
}
