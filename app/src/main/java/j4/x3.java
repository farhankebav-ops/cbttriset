package j4;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class x3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ScheduledExecutorService f12547a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final i4.s1 f12548b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a4.c f12549c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final e2.m f12550d;
    public long e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f12551f;
    public ScheduledFuture g;

    public x3(a4.c cVar, i4.s1 s1Var, ScheduledExecutorService scheduledExecutorService, e2.m mVar) {
        this.f12549c = cVar;
        this.f12548b = s1Var;
        this.f12547a = scheduledExecutorService;
        this.f12550d = mVar;
        mVar.b();
    }
}
