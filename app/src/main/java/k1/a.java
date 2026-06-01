package k1;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class a extends Animatable2Compat.AnimationCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f12595a;

    public a(c cVar) {
        this.f12595a = cVar;
    }

    @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat.AnimationCallback
    public final void onAnimationEnd(Drawable drawable) {
        super.onAnimationEnd(drawable);
        ColorStateList colorStateList = this.f12595a.k;
        if (colorStateList != null) {
            drawable.setTintList(colorStateList);
        }
    }

    @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat.AnimationCallback
    public final void onAnimationStart(Drawable drawable) {
        super.onAnimationStart(drawable);
        c cVar = this.f12595a;
        ColorStateList colorStateList = cVar.k;
        if (colorStateList != null) {
            drawable.setTint(colorStateList.getColorForState(cVar.f12608o, colorStateList.getDefaultColor()));
        }
    }
}
