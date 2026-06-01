package androidx.camera.core.imagecapture;

import androidx.camera.core.impl.ImageReaderProxy;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class b implements ImageReaderProxy.OnImageAvailableListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3585a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ CaptureNode f3586b;

    public /* synthetic */ b(CaptureNode captureNode, int i2) {
        this.f3585a = i2;
        this.f3586b = captureNode;
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy.OnImageAvailableListener
    public final void onImageAvailable(ImageReaderProxy imageReaderProxy) {
        switch (this.f3585a) {
            case 0:
                this.f3586b.lambda$transform$1(imageReaderProxy);
                break;
            default:
                this.f3586b.lambda$setOnImageAvailableListener$2(imageReaderProxy);
                break;
        }
    }
}
