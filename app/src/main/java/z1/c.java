package z1;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class c extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f17900a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ d f17901b;

    public /* synthetic */ c(d dVar, int i2) {
        this.f17900a = i2;
        this.f17901b = dVar;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        switch (this.f17900a) {
            case 1:
                this.f17901b.f17934b.h(false);
                break;
            default:
                super.onAnimationEnd(animator);
                break;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        switch (this.f17900a) {
            case 0:
                this.f17901b.f17934b.h(true);
                break;
            default:
                super.onAnimationStart(animator);
                break;
        }
    }
}
