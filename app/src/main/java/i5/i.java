package i5;

import java.util.concurrent.ThreadFactory;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class i extends s4.p {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final l f12009b = new l("RxNewThreadScheduler", Math.max(1, Math.min(10, Integer.getInteger("rx2.newthread-priority", 5).intValue())), false);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ThreadFactory f12010a = f12009b;

    @Override // s4.p
    public final s4.o a() {
        return new j(this.f12010a);
    }
}
