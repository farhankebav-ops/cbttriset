package i4;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class q1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ r1 f11937a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ a4.b f11938b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ long f11939c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ s1 f11940d;

    public q1(s1 s1Var, r1 r1Var, a4.b bVar, long j) {
        this.f11940d = s1Var;
        this.f11937a = r1Var;
        this.f11938b = bVar;
        this.f11939c = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f11940d.execute(this.f11937a);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f11938b.toString());
        sb.append("(scheduled in SynchronizationContext with delay of ");
        return a1.a.p(sb, this.f11939c, ")");
    }
}
