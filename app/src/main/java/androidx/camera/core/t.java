package androidx.camera.core;

import androidx.camera.core.impl.SessionConfig;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class t implements SessionConfig.ErrorListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3750a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ UseCase f3751b;

    public /* synthetic */ t(UseCase useCase, int i2) {
        this.f3750a = i2;
        this.f3751b = useCase;
    }

    @Override // androidx.camera.core.impl.SessionConfig.ErrorListener
    public final void onError(androidx.camera.core.impl.SessionConfig sessionConfig, SessionConfig.SessionError sessionError) {
        switch (this.f3750a) {
            case 0:
                ((ImageCapture) this.f3751b).lambda$createPipeline$4(sessionConfig, sessionError);
                break;
            default:
                ((Preview) this.f3751b).lambda$addCameraSurfaceAndErrorListener$1(sessionConfig, sessionError);
                break;
        }
    }
}
