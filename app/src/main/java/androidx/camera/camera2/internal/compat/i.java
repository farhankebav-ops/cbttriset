package androidx.camera.camera2.internal.compat;

import androidx.camera.camera2.internal.compat.CameraManagerCompat;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class i implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3409a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ CameraManagerCompat.AvailabilityCallbackExecutorWrapper f3410b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f3411c;

    public /* synthetic */ i(CameraManagerCompat.AvailabilityCallbackExecutorWrapper availabilityCallbackExecutorWrapper, String str, int i2) {
        this.f3409a = i2;
        this.f3410b = availabilityCallbackExecutorWrapper;
        this.f3411c = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f3409a) {
            case 0:
                this.f3410b.lambda$onCameraAvailable$1(this.f3411c);
                break;
            default:
                this.f3410b.lambda$onCameraUnavailable$2(this.f3411c);
                break;
        }
    }
}
