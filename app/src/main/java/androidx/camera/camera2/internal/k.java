package androidx.camera.camera2.internal;

import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.StreamSpec;
import androidx.camera.core.impl.UseCaseConfig;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class k implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3467a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Camera2CameraImpl f3468b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f3469c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ SessionConfig f3470d;
    public final /* synthetic */ UseCaseConfig e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ StreamSpec f3471f;
    public final /* synthetic */ List g;

    public /* synthetic */ k(Camera2CameraImpl camera2CameraImpl, String str, SessionConfig sessionConfig, UseCaseConfig useCaseConfig, StreamSpec streamSpec, List list, int i2) {
        this.f3467a = i2;
        this.f3468b = camera2CameraImpl;
        this.f3469c = str;
        this.f3470d = sessionConfig;
        this.e = useCaseConfig;
        this.f3471f = streamSpec;
        this.g = list;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f3467a) {
            case 0:
                this.f3468b.lambda$onUseCaseActive$7(this.f3469c, this.f3470d, this.e, this.f3471f, this.g);
                break;
            case 1:
                this.f3468b.lambda$resetUseCase$10(this.f3469c, this.f3470d, this.e, this.f3471f, this.g);
                break;
            default:
                this.f3468b.lambda$onUseCaseUpdated$9(this.f3469c, this.f3470d, this.e, this.f3471f, this.g);
                break;
        }
    }
}
