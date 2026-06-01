package sg.bigo.ads.ad.interstitial;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.transition.ChangeBounds;
import android.transition.Fade;
import android.transition.Slide;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.webkit.ValueCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.mlkit.common.MlKitException;
import sg.bigo.ads.common.utils.b;

/* JADX INFO: loaded from: classes6.dex */
public final class c {
    public static ValueAnimator a(int i2, int i8, long j, final ValueCallback<Integer> valueCallback, final ValueCallback<Void> valueCallback2) {
        if (j == 0) {
            valueCallback.onReceiveValue(Integer.valueOf(i8));
            valueCallback2.onReceiveValue(null);
            return null;
        }
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(i2, i8);
        valueAnimatorOfInt.setInterpolator(new LinearInterpolator());
        valueAnimatorOfInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: sg.bigo.ads.ad.interstitial.c.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                ValueCallback valueCallback3;
                Object animatedValue = valueAnimator.getAnimatedValue();
                if (!(animatedValue instanceof Integer) || (valueCallback3 = valueCallback) == null) {
                    return;
                }
                valueCallback3.onReceiveValue((Integer) animatedValue);
            }
        });
        valueAnimatorOfInt.addListener(new AnimatorListenerAdapter() { // from class: sg.bigo.ads.ad.interstitial.c.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                ValueCallback valueCallback3 = valueCallback2;
                if (valueCallback3 != null) {
                    valueCallback3.onReceiveValue(null);
                }
            }
        });
        if (j >= 0) {
            valueAnimatorOfInt.setDuration(j);
        }
        valueAnimatorOfInt.start();
        return valueAnimatorOfInt;
    }

    public static void b(@NonNull View view) {
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(200L);
        alphaAnimation.setInterpolator(sg.bigo.ads.common.utils.b.a(2));
        alphaAnimation.setFillAfter(true);
        view.startAnimation(alphaAnimation);
    }

    public static void c(@NonNull final View view) {
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(200L);
        alphaAnimation.setInterpolator(sg.bigo.ads.common.utils.b.a(1));
        alphaAnimation.setFillAfter(true);
        alphaAnimation.setAnimationListener(new b.c() { // from class: sg.bigo.ads.ad.interstitial.c.8
            @Override // sg.bigo.ads.common.utils.b.c, android.view.animation.Animation.AnimationListener
            public final void onAnimationEnd(Animation animation) {
                view.setVisibility(8);
                view.setAlpha(0.0f);
            }
        });
        view.startAnimation(alphaAnimation);
    }

    public static void d(@NonNull View view) {
        AnimationSet animationSet = new AnimationSet(true);
        Interpolator interpolatorA = sg.bigo.ads.common.utils.b.a(2);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(300L);
        alphaAnimation.setInterpolator(interpolatorA);
        animationSet.addAnimation(alphaAnimation);
        ScaleAnimation scaleAnimation = new ScaleAnimation(0.1f, 1.0f, 0.1f, 1.0f, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setDuration(300L);
        alphaAnimation.setInterpolator(interpolatorA);
        animationSet.addAnimation(scaleAnimation);
        view.startAnimation(animationSet);
    }

    public static void e(@NonNull View view) {
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.9f, 1.0f, 0.9f, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setDuration(200L);
        scaleAnimation.setInterpolator(sg.bigo.ads.common.utils.b.a(1));
        scaleAnimation.setRepeatCount(-1);
        scaleAnimation.setRepeatMode(2);
        view.startAnimation(scaleAnimation);
    }

    public static void a(@NonNull final View view) {
        b(view, new b.c() { // from class: sg.bigo.ads.ad.interstitial.c.1
            @Override // sg.bigo.ads.common.utils.b.c, android.view.animation.Animation.AnimationListener
            public final void onAnimationEnd(Animation animation) {
                view.clearAnimation();
                view.setVisibility(8);
            }
        });
    }

    public static void b(@NonNull View view, Animation.AnimationListener animationListener) {
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, 0.0f, view.getHeight());
        translateAnimation.setDuration(200L);
        translateAnimation.setInterpolator(sg.bigo.ads.common.utils.b.a(1));
        translateAnimation.setFillAfter(true);
        translateAnimation.setAnimationListener(animationListener);
        view.startAnimation(translateAnimation);
    }

    public static void c(@NonNull View view, @Nullable Animation.AnimationListener animationListener) {
        AnimationSet animationSet = new AnimationSet(true);
        Interpolator interpolatorA = sg.bigo.ads.common.utils.b.a(2);
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(200L);
        alphaAnimation.setInterpolator(interpolatorA);
        animationSet.addAnimation(alphaAnimation);
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.1f, 1.0f, 0.1f, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setDuration(300L);
        alphaAnimation.setInterpolator(interpolatorA);
        animationSet.addAnimation(scaleAnimation);
        animationSet.setAnimationListener(animationListener);
        view.startAnimation(animationSet);
    }

    public static void d(@NonNull View view, @Nullable Animation.AnimationListener animationListener) {
        AnimationSet animationSet = new AnimationSet(true);
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 1.5f, 1.0f, 1.5f, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setDuration(300L);
        scaleAnimation.setInterpolator(sg.bigo.ads.common.utils.b.a(3));
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(300L);
        animationSet.addAnimation(scaleAnimation);
        animationSet.addAnimation(alphaAnimation);
        animationSet.setFillAfter(true);
        animationSet.setAnimationListener(animationListener);
        view.startAnimation(animationSet);
    }

    public static void a(@NonNull View view, float f4) {
        AnimationSet animationSet = new AnimationSet(true);
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, f4, 0.0f);
        translateAnimation.setDuration(300L);
        translateAnimation.setInterpolator(sg.bigo.ads.common.utils.b.a(3));
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(300L);
        animationSet.addAnimation(translateAnimation);
        animationSet.addAnimation(alphaAnimation);
        animationSet.setFillAfter(true);
        view.startAnimation(animationSet);
    }

    public static void b(ViewGroup viewGroup) {
        TransitionSet transitionSet = new TransitionSet();
        transitionSet.addTransition(new ChangeBounds());
        transitionSet.setDuration(300L);
        TransitionManager.beginDelayedTransition(viewGroup, transitionSet);
    }

    public static void a(@NonNull View view, float f4, float f8, @Nullable Animation.AnimationListener animationListener) {
        AlphaAnimation alphaAnimation = new AlphaAnimation(f4, f8);
        alphaAnimation.setDuration(300L);
        alphaAnimation.setFillAfter(true);
        if (animationListener != null) {
            alphaAnimation.setAnimationListener(animationListener);
        }
        view.startAnimation(alphaAnimation);
    }

    public static void a(@NonNull View view, long j, Animation.AnimationListener animationListener) {
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, view.getHeight(), 0.0f);
        translateAnimation.setDuration(j);
        translateAnimation.setInterpolator(sg.bigo.ads.common.utils.b.a(2));
        translateAnimation.setFillAfter(true);
        translateAnimation.setAnimationListener(animationListener);
        view.startAnimation(translateAnimation);
    }

    public static void a(@NonNull View view, @NonNull View view2) {
        a(view, view2, 560);
    }

    public static void a(@NonNull final View view, @NonNull final View view2, int i2) {
        final RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 10.0f, 1, 0.5f, 1, 0.6f);
        rotateAnimation.setDuration(200L);
        if (i2 > 0) {
            rotateAnimation.setStartOffset(i2);
        }
        rotateAnimation.setFillAfter(true);
        final RotateAnimation rotateAnimation2 = new RotateAnimation(10.0f, 0.0f, 1, 0.5f, 1, 0.6f);
        rotateAnimation2.setDuration(240L);
        rotateAnimation2.setFillAfter(true);
        final AnimationSet animationSet = new AnimationSet(false);
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 5.0f, 1.0f, 5.0f, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setDuration(400L);
        scaleAnimation.setInterpolator(sg.bigo.ads.common.utils.b.a(2));
        scaleAnimation.setFillAfter(true);
        animationSet.addAnimation(scaleAnimation);
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(400L);
        scaleAnimation.setInterpolator(sg.bigo.ads.common.utils.b.a(2));
        alphaAnimation.setFillAfter(true);
        animationSet.addAnimation(alphaAnimation);
        alphaAnimation.setAnimationListener(new b.c() { // from class: sg.bigo.ads.ad.interstitial.c.14
            @Override // sg.bigo.ads.common.utils.b.c, android.view.animation.Animation.AnimationListener
            public final void onAnimationEnd(Animation animation) {
                view2.setVisibility(4);
            }
        });
        rotateAnimation.setAnimationListener(new b.c() { // from class: sg.bigo.ads.ad.interstitial.c.15
            @Override // sg.bigo.ads.common.utils.b.c, android.view.animation.Animation.AnimationListener
            public final void onAnimationEnd(Animation animation) {
                view.startAnimation(rotateAnimation2);
            }
        });
        rotateAnimation2.setAnimationListener(new b.c() { // from class: sg.bigo.ads.ad.interstitial.c.2
            @Override // sg.bigo.ads.common.utils.b.c, android.view.animation.Animation.AnimationListener
            public final void onAnimationEnd(Animation animation) {
                view.startAnimation(rotateAnimation);
                view2.setVisibility(0);
                view2.startAnimation(animationSet);
            }
        });
        view.startAnimation(rotateAnimation);
    }

    public static void a(final View view, final ViewGroup viewGroup, final Runnable runnable) {
        if (view != null && viewGroup != null) {
            view.setVisibility(8);
            view.post(new Runnable() { // from class: sg.bigo.ads.ad.interstitial.c.5

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                final /* synthetic */ int f14307a = MlKitException.LOW_LIGHT_AUTO_EXPOSURE_COMPUTATION_FAILURE;

                @Override // java.lang.Runnable
                public final void run() {
                    TransitionSet transitionSet = new TransitionSet();
                    transitionSet.addTransition(new Slide());
                    transitionSet.setDuration(this.f14307a);
                    transitionSet.addListener((Transition.TransitionListener) new sg.bigo.ads.common.h() { // from class: sg.bigo.ads.ad.interstitial.c.5.1
                        @Override // sg.bigo.ads.common.h, android.transition.Transition.TransitionListener
                        public final void onTransitionEnd(Transition transition) {
                            super.onTransitionEnd(transition);
                            Runnable runnable2 = runnable;
                            if (runnable2 != null) {
                                runnable2.run();
                            }
                        }
                    });
                    TransitionManager.beginDelayedTransition(viewGroup, transitionSet);
                    view.setVisibility(0);
                }
            });
        } else if (runnable != null) {
            runnable.run();
        }
    }

    public static void a(@NonNull View view, Animation.AnimationListener animationListener) {
        a(view, 200L, animationListener);
    }

    public static void a(final View view, boolean z2) {
        if (view == null) {
            return;
        }
        final int iA = sg.bigo.ads.common.utils.e.a(view.getContext(), 56);
        if (!z2) {
            iA = -iA;
        }
        view.post(new Runnable() { // from class: sg.bigo.ads.ad.interstitial.c.6
            @Override // java.lang.Runnable
            public final void run() {
                TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, 0.0f, iA);
                translateAnimation.setDuration(2000L);
                translateAnimation.setInterpolator(sg.bigo.ads.common.utils.b.a(3));
                translateAnimation.setRepeatCount(-1);
                translateAnimation.setRepeatMode(2);
                view.startAnimation(translateAnimation);
            }
        });
    }

    public static void a(ViewGroup viewGroup) {
        TransitionSet transitionSet = new TransitionSet();
        transitionSet.addTransition(new Fade(2));
        transitionSet.setDuration(300L);
        TransitionManager.beginDelayedTransition(viewGroup, transitionSet);
    }
}
