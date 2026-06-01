package androidx.camera.core;

import androidx.camera.core.ForwardingImageProxy;
import androidx.camera.core.ImageAnalysisNonBlockingAnalyzer;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class s implements ForwardingImageProxy.OnImageCloseListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3738a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f3739b;

    public /* synthetic */ s(Object obj, int i2) {
        this.f3738a = i2;
        this.f3739b = obj;
    }

    @Override // androidx.camera.core.ForwardingImageProxy.OnImageCloseListener
    public final void onImageClose(ImageProxy imageProxy) {
        switch (this.f3738a) {
            case 0:
                ((ImageAnalysisNonBlockingAnalyzer.CacheAnalyzingImageProxy) this.f3739b).lambda$new$1(imageProxy);
                break;
            default:
                ((SafeCloseImageReaderProxy) this.f3739b).lambda$new$0(imageProxy);
                break;
        }
    }
}
