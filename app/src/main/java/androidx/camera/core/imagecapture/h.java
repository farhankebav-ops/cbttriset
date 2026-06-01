package androidx.camera.core.imagecapture;

import android.graphics.Bitmap;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.ImageCaptureException;
import androidx.camera.core.ImageProxy;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class h implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3599a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f3600b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f3601c;

    public /* synthetic */ h(int i2, Object obj, Object obj2) {
        this.f3599a = i2;
        this.f3600b = obj;
        this.f3601c = obj2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f3599a) {
            case 0:
                ((ProcessingRequest) this.f3600b).onProcessFailure((ImageCaptureException) this.f3601c);
                break;
            case 1:
                ((ProcessingRequest) this.f3600b).onFinalResult((ImageProxy) this.f3601c);
                break;
            case 2:
                ((ProcessingRequest) this.f3600b).onFinalResult((ImageCapture.OutputFileResults) this.f3601c);
                break;
            case 3:
                ((ProcessingRequest) this.f3600b).onPostviewBitmapAvailable((Bitmap) this.f3601c);
                break;
            case 4:
                ((TakePictureManagerImpl) this.f3600b).lambda$trackCurrentRequests$1((RequestWithCallback) this.f3601c);
                break;
            case 5:
                ((TakePictureRequest) this.f3600b).lambda$onResult$2((ImageProxy) this.f3601c);
                break;
            case 6:
                ((TakePictureRequest) this.f3600b).lambda$onPostviewBitmapAvailable$4((Bitmap) this.f3601c);
                break;
            case 7:
                ((TakePictureRequest) this.f3600b).lambda$onResult$1((ImageCapture.OutputFileResults) this.f3601c);
                break;
            default:
                ((TakePictureRequest) this.f3600b).lambda$onError$0((ImageCaptureException) this.f3601c);
                break;
        }
    }
}
