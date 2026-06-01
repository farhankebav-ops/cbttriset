package d5;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class k extends i {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f11111c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ k(s4.g gVar, int i2) {
        super(gVar);
        this.f11111c = i2;
    }

    @Override // s4.e
    public final void b(Object obj) {
        if (this.f11100b.b()) {
        }
        if (obj == null) {
            e(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            return;
        }
        if (get() != 0) {
            this.f11099a.b(obj);
            a.a.P(this, 1L);
        } else {
            switch (this.f11111c) {
                case 0:
                    break;
                default:
                    e(new v4.c("create: could not emit value due to lack of requests"));
                    break;
            }
        }
    }

    private final void i() {
    }
}
