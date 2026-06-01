package e1;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.google.android.material.behavior.HideBottomViewOnScrollBehavior;
import com.google.android.material.behavior.HideViewOnScrollBehavior;
import z1.j;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class c extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f11212a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f11213b;

    public /* synthetic */ c(Object obj, int i2) {
        this.f11212a = i2;
        this.f11213b = obj;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        switch (this.f11212a) {
            case 0:
                ((HideBottomViewOnScrollBehavior) this.f11213b).k = null;
                break;
            case 1:
                ((HideViewOnScrollBehavior) this.f11213b).l = null;
                break;
            default:
                j jVar = (j) this.f11213b;
                jVar.p();
                jVar.f17912r.start();
                break;
        }
    }
}
