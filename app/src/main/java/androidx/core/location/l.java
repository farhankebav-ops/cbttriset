package androidx.core.location;

import android.location.Location;
import androidx.core.location.LocationManagerCompat;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class l implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3953a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ LocationManagerCompat.LocationListenerTransport f3954b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f3955c;

    public /* synthetic */ l(LocationManagerCompat.LocationListenerTransport locationListenerTransport, Object obj, int i2) {
        this.f3953a = i2;
        this.f3954b = locationListenerTransport;
        this.f3955c = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f3953a) {
            case 0:
                this.f3954b.lambda$onLocationChanged$1((List) this.f3955c);
                break;
            default:
                this.f3954b.lambda$onLocationChanged$0((Location) this.f3955c);
                break;
        }
    }
}
