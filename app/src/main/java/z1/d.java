package z1;

import android.animation.AnimatorSet;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;
import android.widget.EditText;
import com.cbt.exam.browser.R;
import com.google.android.material.internal.CheckableImageButton;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class d extends o {
    public final int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f17902f;
    public final TimeInterpolator g;
    public final TimeInterpolator h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public EditText f17903i;
    public final com.cbt.exam.browser.activity.o j;
    public final a k;
    public AnimatorSet l;
    public ValueAnimator m;

    public d(n nVar) {
        super(nVar);
        this.j = new com.cbt.exam.browser.activity.o(this, 3);
        this.k = new a(this, 0);
        this.e = a.a.S(nVar.getContext(), R.attr.motionDurationShort3, 100);
        this.f17902f = a.a.S(nVar.getContext(), R.attr.motionDurationShort3, 150);
        this.g = a.a.T(nVar.getContext(), R.attr.motionEasingLinearInterpolator, c1.a.f4168a);
        this.h = a.a.T(nVar.getContext(), R.attr.motionEasingEmphasizedInterpolator, c1.a.f4171d);
    }

    @Override // z1.o
    public final void a() {
        if (this.f17934b.p != null) {
            return;
        }
        s(t());
    }

    @Override // z1.o
    public final int c() {
        return R.string.clear_text_end_icon_content_description;
    }

    @Override // z1.o
    public final int d() {
        return R.drawable.mtrl_ic_cancel;
    }

    @Override // z1.o
    public final View.OnFocusChangeListener e() {
        return this.k;
    }

    @Override // z1.o
    public final View.OnClickListener f() {
        return this.j;
    }

    @Override // z1.o
    public final View.OnFocusChangeListener g() {
        return this.k;
    }

    @Override // z1.o
    public final void l(EditText editText) {
        this.f17903i = editText;
        this.f17933a.setEndIconVisible(t());
    }

    @Override // z1.o
    public final void o(boolean z2) {
        if (this.f17934b.p == null) {
            return;
        }
        s(z2);
    }

    @Override // z1.o
    public final void q() {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.8f, 1.0f);
        valueAnimatorOfFloat.setInterpolator(this.h);
        valueAnimatorOfFloat.setDuration(this.f17902f);
        final int i2 = 1;
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) { // from class: z1.b

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ d f17899b;

            {
                this.f17899b = this;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                switch (i2) {
                    case 0:
                        d dVar = this.f17899b;
                        dVar.getClass();
                        dVar.f17936d.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                        break;
                    default:
                        d dVar2 = this.f17899b;
                        dVar2.getClass();
                        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        CheckableImageButton checkableImageButton = dVar2.f17936d;
                        checkableImageButton.setScaleX(fFloatValue);
                        checkableImageButton.setScaleY(fFloatValue);
                        break;
                }
            }
        });
        ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat(0.0f, 1.0f);
        TimeInterpolator timeInterpolator = this.g;
        valueAnimatorOfFloat2.setInterpolator(timeInterpolator);
        int i8 = this.e;
        valueAnimatorOfFloat2.setDuration(i8);
        final int i9 = 0;
        valueAnimatorOfFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) { // from class: z1.b

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ d f17899b;

            {
                this.f17899b = this;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                switch (i9) {
                    case 0:
                        d dVar = this.f17899b;
                        dVar.getClass();
                        dVar.f17936d.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                        break;
                    default:
                        d dVar2 = this.f17899b;
                        dVar2.getClass();
                        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        CheckableImageButton checkableImageButton = dVar2.f17936d;
                        checkableImageButton.setScaleX(fFloatValue);
                        checkableImageButton.setScaleY(fFloatValue);
                        break;
                }
            }
        });
        AnimatorSet animatorSet = new AnimatorSet();
        this.l = animatorSet;
        animatorSet.playTogether(valueAnimatorOfFloat, valueAnimatorOfFloat2);
        this.l.addListener(new c(this, i9));
        ValueAnimator valueAnimatorOfFloat3 = ValueAnimator.ofFloat(1.0f, 0.0f);
        valueAnimatorOfFloat3.setInterpolator(timeInterpolator);
        valueAnimatorOfFloat3.setDuration(i8);
        valueAnimatorOfFloat3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) { // from class: z1.b

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ d f17899b;

            {
                this.f17899b = this;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                switch (i9) {
                    case 0:
                        d dVar = this.f17899b;
                        dVar.getClass();
                        dVar.f17936d.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                        break;
                    default:
                        d dVar2 = this.f17899b;
                        dVar2.getClass();
                        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        CheckableImageButton checkableImageButton = dVar2.f17936d;
                        checkableImageButton.setScaleX(fFloatValue);
                        checkableImageButton.setScaleY(fFloatValue);
                        break;
                }
            }
        });
        this.m = valueAnimatorOfFloat3;
        valueAnimatorOfFloat3.addListener(new c(this, i2));
    }

    @Override // z1.o
    public final void r() {
        EditText editText = this.f17903i;
        if (editText != null) {
            editText.post(new com.vungle.ads.internal.omsdk.a(this, 15));
        }
    }

    public final void s(boolean z2) {
        boolean z7 = this.f17934b.d() == z2;
        if (z2 && !this.l.isRunning()) {
            this.m.cancel();
            this.l.start();
            if (z7) {
                this.l.end();
                return;
            }
            return;
        }
        if (z2) {
            return;
        }
        this.l.cancel();
        this.m.start();
        if (z7) {
            this.m.end();
        }
    }

    public final boolean t() {
        EditText editText = this.f17903i;
        if (editText != null) {
            return (editText.hasFocus() || this.f17936d.hasFocus()) && this.f17903i.getText().length() > 0;
        }
        return false;
    }
}
