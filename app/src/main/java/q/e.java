package q;

import android.app.Activity;
import android.view.animation.Animation;
import android.view.inputmethod.InputMethodManager;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class e implements Animation.AnimationListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g f13349a;

    public e(g gVar) {
        this.f13349a = gVar;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationEnd(Animation animation) {
        Activity ownerActivity;
        InputMethodManager inputMethodManager;
        g gVar = this.f13349a;
        gVar.f13350a.setVisibility(8);
        if (gVar.I && (ownerActivity = gVar.getOwnerActivity()) != null && (inputMethodManager = (InputMethodManager) ownerActivity.getSystemService("input_method")) != null && ownerActivity.getCurrentFocus() != null) {
            inputMethodManager.hideSoftInputFromWindow(ownerActivity.getCurrentFocus().getWindowToken(), 0);
        }
        gVar.f13350a.post(new a4.c(this, 20));
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationStart(Animation animation) {
    }
}
