package androidx.core.location;

import android.location.GnssMeasurementsEvent;
import android.location.GnssStatus;
import androidx.core.location.LocationManagerCompat;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class h implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3939a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Executor f3940b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f3941c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f3942d;

    public /* synthetic */ h(Object obj, Executor executor, Object obj2, int i2) {
        this.f3939a = i2;
        this.f3941c = obj;
        this.f3940b = executor;
        this.f3942d = obj2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f3939a) {
            case 0:
                ((LocationManagerCompat.GnssMeasurementsTransport) this.f3941c).lambda$onGnssMeasurementsReceived$0(this.f3940b, (GnssMeasurementsEvent) this.f3942d);
                break;
            case 1:
                ((LocationManagerCompat.GpsStatusTransport) this.f3941c).lambda$onGpsStatusChanged$3(this.f3940b, (GnssStatusCompat) this.f3942d);
                break;
            default:
                ((LocationManagerCompat.PreRGnssStatusTransport) this.f3941c).lambda$onSatelliteStatusChanged$3(this.f3940b, (GnssStatus) this.f3942d);
                break;
        }
    }
}
