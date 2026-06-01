package j4;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class r0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f12405a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f12406b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f12407c;

    public /* synthetic */ r0(Object obj, int i2, int i8) {
        this.f12405a = i8;
        this.f12407c = obj;
        this.f12406b = i2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f12405a) {
            case 0:
                ((o0) this.f12407c).f12344c.i(this.f12406b);
                break;
            case 1:
                ((o0) this.f12407c).f12344c.a(this.f12406b);
                break;
            default:
                ((com.google.android.material.datepicker.n) this.f12407c).h.smoothScrollToPosition(this.f12406b);
                break;
        }
    }
}
