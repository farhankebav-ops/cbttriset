package q6;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class a2 extends v6.r implements Runnable {
    public final long e;

    public a2(long j, x5.c cVar) {
        super(cVar, cVar.getContext());
        this.e = j;
    }

    @Override // q6.n1
    public final String P() {
        return super.P() + "(timeMillis=" + this.e + ')';
    }

    @Override // java.lang.Runnable
    public final void run() {
        c0.o(this.f13523c);
        u(new z1("Timed out waiting for " + this.e + " ms", this));
    }
}
