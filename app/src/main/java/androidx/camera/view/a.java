package androidx.camera.view;

import androidx.camera.core.ImageCapture;
import androidx.camera.view.CameraController;
import androidx.camera.view.PreviewViewImplementation;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3887a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f3888b;

    public /* synthetic */ a(Object obj, int i2) {
        this.f3887a = i2;
        this.f3888b = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f3887a) {
            case 0:
                ((CameraController.FocusMeteringResultCallback) this.f3888b).resetStateAndClose();
                break;
            case 1:
                ((CameraController.AnonymousClass2) this.f3888b).lambda$accept$0();
                break;
            case 2:
                ((PreviewViewImplementation.OnSurfaceNotInUseListener) this.f3888b).onSurfaceNotInUse();
                break;
            default:
                ((ImageCapture.ScreenFlashListener) this.f3888b).onCompleted();
                break;
        }
    }
}
