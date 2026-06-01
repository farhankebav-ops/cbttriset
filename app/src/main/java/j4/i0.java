package j4;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class i0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f12248a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f12249b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f12250c;

    public /* synthetic */ i0(int i2, Object obj, Object obj2) {
        this.f12248a = i2;
        this.f12249b = obj;
        this.f12250c = obj2;
    }

    private final void a() {
        g2 g2Var = (g2) this.f12249b;
        m4 m4VarG = g2Var.g(g2Var.f12211o.e, false);
        if (m4VarG == null) {
            return;
        }
        ((g2) this.f12249b).f12205b.execute(new i0(21, this, m4VarG));
    }

    /* JADX WARN: Removed duplicated region for block: B:126:0x03d4  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0416  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x009d A[Catch: all -> 0x009a, TryCatch #5 {all -> 0x009a, blocks: (B:12:0x003f, B:32:0x00cf, B:15:0x004e, B:17:0x006e, B:19:0x007a, B:24:0x0088, B:27:0x009d, B:31:0x00c3, B:30:0x00ac), top: B:300:0x003f }] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void run() throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 2406
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: j4.i0.run():void");
    }

    public i0(v0 v0Var, i4.f fVar) {
        this.f12248a = 13;
        this.f12249b = v0Var;
        r2.q.D(fVar, "savedListener");
        this.f12250c = fVar;
    }

    public i0(n2 n2Var, m2 m2Var) {
        this.f12248a = 19;
        this.f12250c = n2Var;
        this.f12249b = m2Var;
    }
}
