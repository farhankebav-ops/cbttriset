package androidx.camera.camera2.internal;

import android.util.Log;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3361a;

    public /* synthetic */ a0(int i2) {
        this.f3361a = i2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f3361a) {
            case 0:
                Log.d(Camera2CapturePipeline.TAG, "enableExternalFlashAeMode disabled");
                break;
            case 1:
                Camera2CameraControlImpl.lambda$clearInteropConfig$1();
                break;
            default:
                Camera2CameraControlImpl.lambda$addInteropConfig$0();
                break;
        }
    }
}
