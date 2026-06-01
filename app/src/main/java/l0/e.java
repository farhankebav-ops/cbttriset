package l0;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import androidx.camera.core.Camera;
import androidx.camera.core.CameraSelector;
import androidx.camera.lifecycle.ProcessCameraProvider;
import androidx.camera.view.PreviewView;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleOwner;
import j2.q;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Camera f12734a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public CameraSelector f12735b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public PreviewView f12736c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ProcessCameraProvider f12737d;
    public boolean e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f12738f;
    public boolean g;
    public androidx.camera.core.impl.b h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public c f12739i;

    public final void a(Context context, LifecycleOwner lifecycleOwner, PreviewView previewView) {
        this.f12736c = previewView;
        Activity activity = (Activity) context;
        c cVar = new c();
        activity.setVolumeControlStream(3);
        cVar.f12732a = activity.getApplicationContext();
        this.f12739i = cVar;
        this.f12735b = new CameraSelector.Builder().requireLensFacing(!this.f12738f ? 1 : 0).build();
        q processCameraProvider = ProcessCameraProvider.getInstance(context);
        processCameraProvider.addListener(new com.vungle.ads.b(this, processCameraProvider, lifecycleOwner, 7), ContextCompat.getMainExecutor(context));
    }

    public final void b() {
        try {
            ProcessCameraProvider processCameraProvider = this.f12737d;
            if (processCameraProvider != null) {
                processCameraProvider.unbindAll();
                this.f12737d = null;
            }
            this.f12734a = null;
            this.f12736c = null;
            this.g = false;
        } catch (Exception e) {
            Log.e("CameraXManager", "stopCamera error: " + e.getMessage());
        }
    }
}
