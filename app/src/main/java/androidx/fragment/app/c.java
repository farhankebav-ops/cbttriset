package androidx.fragment.app;

import android.graphics.Rect;
import android.view.View;
import androidx.fragment.app.DefaultSpecialEffectsController;
import androidx.fragment.app.SpecialEffectsController;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4009a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f4010b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f4011c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f4012d;

    public /* synthetic */ c(Object obj, View view, Object obj2, int i2) {
        this.f4009a = i2;
        this.f4010b = obj;
        this.f4011c = view;
        this.f4012d = obj2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f4009a) {
            case 0:
                DefaultSpecialEffectsController.AnonymousClass3.onAnimationEnd$lambda$0((DefaultSpecialEffectsController) this.f4010b, (View) this.f4011c, (DefaultSpecialEffectsController.AnimationInfo) this.f4012d);
                break;
            case 1:
                DefaultSpecialEffectsController.executeOperations$lambda$2((ArrayList) this.f4011c, (SpecialEffectsController.Operation) this.f4012d, (DefaultSpecialEffectsController) this.f4010b);
                break;
            default:
                DefaultSpecialEffectsController.startTransitions$lambda$10((FragmentTransitionImpl) this.f4010b, (View) this.f4011c, (Rect) this.f4012d);
                break;
        }
    }

    public /* synthetic */ c(ArrayList arrayList, SpecialEffectsController.Operation operation, DefaultSpecialEffectsController defaultSpecialEffectsController) {
        this.f4009a = 1;
        this.f4011c = arrayList;
        this.f4012d = operation;
        this.f4010b = defaultSpecialEffectsController;
    }
}
