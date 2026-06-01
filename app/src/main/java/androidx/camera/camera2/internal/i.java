package androidx.camera.camera2.internal;

import androidx.camera.camera2.internal.CaptureSessionRepository;
import androidx.camera.core.impl.CameraCaptureCallback;
import java.util.LinkedHashSet;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class i implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3456a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f3457b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f3458c;

    public /* synthetic */ i(Object obj, int i2, int i8) {
        this.f3456a = i8;
        this.f3458c = obj;
        this.f3457b = i2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f3456a) {
            case 0:
                ((CameraCaptureCallback) this.f3458c).onCaptureCancelled(this.f3457b);
                break;
            default:
                CaptureSessionRepository.AnonymousClass1.lambda$dispatchOnError$1((LinkedHashSet) this.f3458c, this.f3457b);
                break;
        }
    }
}
