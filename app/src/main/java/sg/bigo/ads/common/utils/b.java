package sg.bigo.ads.common.utils;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.transition.ChangeBounds;
import android.transition.TransitionValues;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import sg.bigo.ads.common.utils.AnimationUtils;

/* JADX INFO: loaded from: classes6.dex */
public final class b {

    @RequiresApi(api = 19)
    public static class a extends ChangeBounds implements ValueAnimator.AnimatorUpdateListener {
        public void a(TransitionValues transitionValues, TransitionValues transitionValues2) {
        }

        @Override // android.transition.ChangeBounds, android.transition.Transition
        public final Animator createAnimator(ViewGroup viewGroup, TransitionValues transitionValues, TransitionValues transitionValues2) {
            try {
                a(transitionValues, transitionValues2);
            } catch (Exception unused) {
            }
            Animator animatorCreateAnimator = super.createAnimator(viewGroup, transitionValues, transitionValues2);
            if (animatorCreateAnimator instanceof ValueAnimator) {
                ((ValueAnimator) animatorCreateAnimator).addUpdateListener(this);
            }
            return animatorCreateAnimator;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (valueAnimator instanceof ObjectAnimator) {
                ObjectAnimator objectAnimator = (ObjectAnimator) valueAnimator;
                a(objectAnimator.getTarget(), objectAnimator.getAnimatedValue());
            }
        }

        public void a(Object obj, Object obj2) {
        }
    }

    /* JADX INFO: renamed from: sg.bigo.ads.common.utils.b$b, reason: collision with other inner class name */
    public static class InterpolatorC0297b implements Interpolator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f15996a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final float f15997b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final float f15998c;

        public InterpolatorC0297b(long j, long j3, long j8) {
            long j9 = j + j3;
            long j10 = j8 + j9;
            this.f15996a = j10;
            this.f15997b = (j3 * 1.0f) / j10;
            this.f15998c = (j9 * 1.0f) / j10;
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f4) {
            float f8 = this.f15997b;
            if (f4 < f8) {
                return 0.0f;
            }
            float f9 = this.f15998c;
            if (f4 > f9) {
                return 1.0f;
            }
            return (f4 - f8) / (f9 - f8);
        }
    }

    @NonNull
    public static Interpolator a(@AnimationUtils.AnimationEffect int i2) {
        return i2 != 1 ? i2 != 2 ? i2 != 3 ? new LinearInterpolator() : new AccelerateDecelerateInterpolator() : new DecelerateInterpolator(1.5f) : new AccelerateInterpolator(1.5f);
    }

    public static void a(final View view) {
        if (view == null) {
            return;
        }
        final int iA = e.a(view.getContext(), 40);
        view.setVisibility(4);
        view.post(new Runnable() { // from class: sg.bigo.ads.common.utils.b.1
            @Override // java.lang.Runnable
            public final void run() {
                TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, view.getTranslationY() + iA, view.getTranslationY());
                translateAnimation.setDuration(300L);
                translateAnimation.setInterpolator(b.a(2));
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(300L);
                alphaAnimation.setInterpolator(b.a(2));
                AnimationSet animationSet = new AnimationSet(false);
                animationSet.addAnimation(alphaAnimation);
                animationSet.addAnimation(translateAnimation);
                animationSet.setAnimationListener(new c() { // from class: sg.bigo.ads.common.utils.b.1.1
                    @Override // sg.bigo.ads.common.utils.b.c, android.view.animation.Animation.AnimationListener
                    public final void onAnimationStart(Animation animation) {
                        view.setVisibility(0);
                    }
                });
                view.startAnimation(animationSet);
            }
        });
    }

    public static class c implements Animation.AnimationListener {
        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    public static class d implements Animator.AnimatorListener {
        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }
}
