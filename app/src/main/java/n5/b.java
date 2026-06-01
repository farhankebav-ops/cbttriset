package n5;

import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class b implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f13067a;

    public /* synthetic */ b(int i2) {
        this.f13067a = i2;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        switch (this.f13067a) {
            case 0:
                return a.f13066a;
            case 1:
                return c.f13068a;
            case 2:
                return d.f13069a;
            default:
                return e.f13070a;
        }
    }
}
