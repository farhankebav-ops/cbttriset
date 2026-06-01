package p0;

import java.util.concurrent.Executors;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class p implements r0.b {
    @Override // p5.a
    public final Object get() {
        return new r(Executors.newSingleThreadExecutor());
    }
}
