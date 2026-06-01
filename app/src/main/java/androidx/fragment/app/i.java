package androidx.fragment.app;

import androidx.fragment.app.DefaultSpecialEffectsController;
import androidx.fragment.app.SpecialEffectsController;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class i implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4020a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f4021b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ SpecialEffectsController.Operation f4022c;

    public /* synthetic */ i(Object obj, SpecialEffectsController.Operation operation, int i2) {
        this.f4020a = i2;
        this.f4021b = obj;
        this.f4022c = operation;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f4020a) {
            case 0:
                SpecialEffectsController.enqueue$lambda$4$lambda$2((SpecialEffectsController) this.f4021b, (SpecialEffectsController.FragmentStateManagerOperation) this.f4022c);
                break;
            case 1:
                SpecialEffectsController.enqueue$lambda$4$lambda$3((SpecialEffectsController) this.f4021b, (SpecialEffectsController.FragmentStateManagerOperation) this.f4022c);
                break;
            default:
                DefaultSpecialEffectsController.startTransitions$lambda$14$lambda$13((DefaultSpecialEffectsController.TransitionInfo) this.f4021b, this.f4022c);
                break;
        }
    }
}
