package androidx.camera.core.imagecapture;

import androidx.camera.core.imagecapture.CaptureNode;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3589a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f3590b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f3591c;

    public /* synthetic */ d(Object obj, int i2, int i8) {
        this.f3589a = i8;
        this.f3591c = obj;
        this.f3590b = i2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f3589a) {
            case 0:
                ((CaptureNode.AnonymousClass1) this.f3591c).lambda$onCaptureProcessProgressed$1(this.f3590b);
                break;
            default:
                ((TakePictureRequest) this.f3591c).lambda$onCaptureProcessProgressed$3(this.f3590b);
                break;
        }
    }
}
