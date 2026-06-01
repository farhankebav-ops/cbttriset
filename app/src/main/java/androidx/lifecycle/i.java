package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import s6.x;
import t6.d1;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class i implements LifecycleEventObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4042a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f4043b;

    public /* synthetic */ i(Object obj, int i2) {
        this.f4042a = i2;
        this.f4043b = obj;
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        switch (this.f4042a) {
            case 0:
                LifecycleKt$eventFlow$1.invokeSuspend$lambda$0((x) this.f4043b, lifecycleOwner, event);
                break;
            default:
                Lifecycle._get_currentStateFlow_$lambda$0((d1) this.f4043b, lifecycleOwner, event);
                break;
        }
    }
}
