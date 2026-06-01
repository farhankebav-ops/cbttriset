package androidx.camera.core.impl;

import androidx.camera.core.CameraPresenceListener;
import androidx.camera.core.impl.LiveDataObservable;
import androidx.camera.core.impl.Observable;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.lifecycle.Observer;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class u implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3627a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f3628b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f3629c;

    public /* synthetic */ u(int i2, Object obj, Object obj2) {
        this.f3627a = i2;
        this.f3629c = obj;
        this.f3628b = obj2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f3627a) {
            case 0:
                ((LiveDataObservable) this.f3629c).lambda$removeObserver$3((LiveDataObservable.LiveDataObserverAdapter) this.f3628b);
                break;
            case 1:
                ((LiveDataObservable.LiveDataObserverAdapter) this.f3628b).lambda$onChanged$0((LiveDataObservable.Result) this.f3629c);
                break;
            case 2:
                CameraPresenceProvider.removeCameraStateObserver$lambda$14$lambda$13((CameraInternal) this.f3629c, (Observer) this.f3628b);
                break;
            case 3:
                CameraPresenceProvider.addCameraPresenceListener$lambda$20((CameraPresenceProvider) this.f3629c, (CameraPresenceListener) this.f3628b);
                break;
            case 4:
                CameraPresenceProvider.setupCameraStateObserver$lambda$12$lambda$11((CameraInfoInternal) this.f3629c, (n) this.f3628b);
                break;
            case 5:
                ((CameraRepository) this.f3629c).lambda$deinit$1((CameraInternal) this.f3628b);
                break;
            case 6:
                ((ConstantObservable) this.f3629c).lambda$addObserver$0((Observable.Observer) this.f3628b);
                break;
            case 7:
                ((DeferrableSurface) this.f3629c).lambda$new$2((String) this.f3628b);
                break;
            default:
                ((LiveDataObservable) this.f3629c).lambda$fetchData$0((CallbackToFutureAdapter.Completer) this.f3628b);
                break;
        }
    }

    public /* synthetic */ u(LiveDataObservable.LiveDataObserverAdapter liveDataObserverAdapter, LiveDataObservable.Result result) {
        this.f3627a = 1;
        this.f3628b = liveDataObserverAdapter;
        this.f3629c = result;
    }
}
