package q6;

import java.util.concurrent.ScheduledFuture;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class h implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f13552a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f13553b;

    public /* synthetic */ h(Object obj, int i2) {
        this.f13552a = i2;
        this.f13553b = obj;
    }

    @Override // q6.i
    public final void a(Throwable th) {
        switch (this.f13552a) {
            case 0:
                ((ScheduledFuture) this.f13553b).cancel(false);
                break;
            case 1:
                ((e6.l) this.f13553b).invoke(th);
                break;
            default:
                ((o0) this.f13553b).dispose();
                break;
        }
    }

    public final String toString() {
        switch (this.f13552a) {
            case 0:
                return "CancelFutureOnCancel[" + ((ScheduledFuture) this.f13553b) + ']';
            case 1:
                return "CancelHandler.UserSupplied[" + ((e6.l) this.f13553b).getClass().getSimpleName() + '@' + c0.p(this) + ']';
            default:
                return "DisposeOnCancel[" + ((o0) this.f13553b) + ']';
        }
    }
}
