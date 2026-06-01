package androidx.camera.core.imagecapture;

import androidx.camera.core.imagecapture.CaptureNode;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class j implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3604a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f3605b;

    public /* synthetic */ j(Object obj, int i2) {
        this.f3604a = i2;
        this.f3605b = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f3604a) {
            case 0:
                ((TakePictureManagerImpl) this.f3605b).issueNextRequest();
                break;
            case 1:
                ((TakePictureManagerImpl) this.f3605b).lambda$trackCurrentRequests$0();
                break;
            default:
                ((CaptureNode.AnonymousClass1) this.f3605b).lambda$onCaptureStarted$0();
                break;
        }
    }
}
