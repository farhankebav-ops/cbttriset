package androidx.camera.core.impl;

import androidx.camera.core.impl.AbstractCameraPresenceSource;
import androidx.camera.core.impl.LiveDataObservable;
import androidx.lifecycle.Observer;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3606a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f3607b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f3608c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f3609d;

    public /* synthetic */ a(Object obj, Object obj2, Object obj3, int i2) {
        this.f3606a = i2;
        this.f3607b = obj;
        this.f3608c = obj2;
        this.f3609d = obj3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f3606a) {
            case 0:
                AbstractCameraPresenceSource.lambda$notifyObserver$0((Throwable) this.f3607b, (AbstractCameraPresenceSource.ObserverWrapper) this.f3608c, (List) this.f3609d);
                break;
            case 1:
                ((LiveDataObservable) this.f3607b).lambda$addObserver$2((LiveDataObservable.LiveDataObserverAdapter) this.f3608c, (LiveDataObservable.LiveDataObserverAdapter) this.f3609d);
                break;
            default:
                CameraPresenceProvider.clearAllCameraStateObservers$lambda$19$lambda$18((ArrayList) this.f3607b, (Observer) this.f3608c, (String) this.f3609d);
                break;
        }
    }
}
