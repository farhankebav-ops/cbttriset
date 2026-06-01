package androidx.core.location;

import androidx.core.location.LocationManagerCompat;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class o implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3962a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ LocationManagerCompat.PreRGnssStatusTransport f3963b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Executor f3964c;

    public /* synthetic */ o(LocationManagerCompat.PreRGnssStatusTransport preRGnssStatusTransport, Executor executor, int i2) {
        this.f3962a = i2;
        this.f3963b = preRGnssStatusTransport;
        this.f3964c = executor;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f3962a) {
            case 0:
                this.f3963b.lambda$onStopped$1(this.f3964c);
                break;
            default:
                this.f3963b.lambda$onStarted$0(this.f3964c);
                break;
        }
    }
}
