package androidx.camera.camera2.internal;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class n implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3487a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Camera2CameraImpl f3488b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ArrayList f3489c;

    public /* synthetic */ n(Camera2CameraImpl camera2CameraImpl, ArrayList arrayList, int i2) {
        this.f3487a = i2;
        this.f3488b = camera2CameraImpl;
        this.f3489c = arrayList;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f3487a) {
            case 0:
                this.f3488b.lambda$detachUseCases$17(this.f3489c);
                break;
            default:
                this.f3488b.lambda$attachUseCases$15(this.f3489c);
                break;
        }
    }
}
