package androidx.core.location;

import androidx.core.location.LocationManagerCompat;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class i implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3943a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Executor f3944b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f3945c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f3946d;

    public /* synthetic */ i(Object obj, Executor executor, int i2, int i8) {
        this.f3943a = i8;
        this.f3946d = obj;
        this.f3944b = executor;
        this.f3945c = i2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f3943a) {
            case 0:
                ((LocationManagerCompat.GnssMeasurementsTransport) this.f3946d).lambda$onStatusChanged$1(this.f3944b, this.f3945c);
                break;
            case 1:
                ((LocationManagerCompat.GpsStatusTransport) this.f3946d).lambda$onGpsStatusChanged$2(this.f3944b, this.f3945c);
                break;
            default:
                ((LocationManagerCompat.PreRGnssStatusTransport) this.f3946d).lambda$onFirstFix$2(this.f3944b, this.f3945c);
                break;
        }
    }
}
