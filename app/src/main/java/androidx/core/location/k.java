package androidx.core.location;

import androidx.core.location.LocationManagerCompat;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class k implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3950a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ LocationManagerCompat.LocationListenerTransport f3951b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f3952c;

    public /* synthetic */ k(LocationManagerCompat.LocationListenerTransport locationListenerTransport, String str, int i2) {
        this.f3950a = i2;
        this.f3951b = locationListenerTransport;
        this.f3952c = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f3950a) {
            case 0:
                this.f3951b.lambda$onProviderEnabled$4(this.f3952c);
                break;
            default:
                this.f3951b.lambda$onProviderDisabled$5(this.f3952c);
                break;
        }
    }
}
