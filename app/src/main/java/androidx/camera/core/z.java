package androidx.camera.core;

import androidx.camera.core.ForwardingImageProxy;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class z implements ForwardingImageProxy.OnImageCloseListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3760a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ImageProxy f3761b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ImageProxy f3762c;

    public /* synthetic */ z(ImageProxy imageProxy, ImageProxy imageProxy2, int i2) {
        this.f3760a = i2;
        this.f3761b = imageProxy;
        this.f3762c = imageProxy2;
    }

    @Override // androidx.camera.core.ForwardingImageProxy.OnImageCloseListener
    public final void onImageClose(ImageProxy imageProxy) {
        switch (this.f3760a) {
            case 0:
                ImageProcessingUtil.lambda$convertYUVToRGB$0(this.f3761b, this.f3762c, imageProxy);
                break;
            default:
                ImageProcessingUtil.lambda$rotateYUV$1(this.f3761b, this.f3762c, imageProxy);
                break;
        }
    }
}
