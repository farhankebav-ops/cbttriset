package androidx.camera.view;

import android.graphics.SurfaceTexture;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.view.PreviewView;
import androidx.camera.view.TextureViewImplementation;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class j implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3902a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f3903b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f3904c;

    public /* synthetic */ j(int i2, Object obj, Object obj2) {
        this.f3902a = i2;
        this.f3904c = obj;
        this.f3903b = obj2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f3902a) {
            case 0:
                ((PreviewView.AnonymousClass1) this.f3904c).lambda$onSurfaceRequested$0((SurfaceRequest) this.f3903b);
                break;
            case 1:
                ((TextureViewImplementation) this.f3904c).lambda$onSurfaceRequested$0((SurfaceRequest) this.f3903b);
                break;
            case 2:
                TextureViewImplementation.AnonymousClass1.lambda$onSurfaceTextureUpdated$0((PreviewView.OnFrameUpdateListener) this.f3904c, (SurfaceTexture) this.f3903b);
                break;
            default:
                ((CameraController) this.f3904c).lambda$setCameraSelector$3((CameraSelector) this.f3903b);
                break;
        }
    }
}
