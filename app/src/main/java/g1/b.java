package g1;

import android.animation.ValueAnimator;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.textfield.TextInputLayout;
import w1.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class b implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f11559a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f11560b;

    public /* synthetic */ b(Object obj, int i2) {
        this.f11559a = i2;
        this.f11560b = obj;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        switch (this.f11559a) {
            case 0:
                float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                k kVar = ((BottomSheetBehavior) this.f11560b).f5280i;
                if (kVar != null) {
                    kVar.q(fFloatValue);
                }
                break;
            default:
                ((TextInputLayout) this.f11560b).f5479w0.m(((Float) valueAnimator.getAnimatedValue()).floatValue());
                break;
        }
    }
}
