package com.mimikridev.utilmanager.animation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Transformation;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class ViewAnimation {

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface AnimListener {
        void onFinish();
    }

    public static void collapse(final View view) {
        final int measuredHeight = view.getMeasuredHeight();
        Animation animation = new Animation() { // from class: com.mimikridev.utilmanager.animation.ViewAnimation.3
            @Override // android.view.animation.Animation
            public void applyTransformation(float f4, Transformation transformation) {
                if (f4 == 1.0f) {
                    view.setVisibility(8);
                    return;
                }
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                int i2 = measuredHeight;
                layoutParams.height = i2 - ((int) (i2 * f4));
                view.requestLayout();
            }

            @Override // android.view.animation.Animation
            public boolean willChangeBounds() {
                return true;
            }
        };
        animation.setDuration((int) (measuredHeight / view.getContext().getResources().getDisplayMetrics().density));
        view.startAnimation(animation);
    }

    public static void expand(View view, final AnimListener animListener) {
        Animation animationExpandAction = expandAction(view);
        animationExpandAction.setAnimationListener(new Animation.AnimationListener() { // from class: com.mimikridev.utilmanager.animation.ViewAnimation.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                animListener.onFinish();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }
        });
        view.startAnimation(animationExpandAction);
    }

    private static Animation expandAction(final View view) {
        view.measure(-1, -2);
        final int measuredHeight = view.getMeasuredHeight();
        view.getLayoutParams().height = 0;
        view.setVisibility(0);
        Animation animation = new Animation() { // from class: com.mimikridev.utilmanager.animation.ViewAnimation.2
            @Override // android.view.animation.Animation
            public void applyTransformation(float f4, Transformation transformation) {
                view.getLayoutParams().height = f4 == 1.0f ? -2 : (int) (measuredHeight * f4);
                view.requestLayout();
            }

            @Override // android.view.animation.Animation
            public boolean willChangeBounds() {
                return true;
            }
        };
        animation.setDuration((int) (measuredHeight / view.getContext().getResources().getDisplayMetrics().density));
        view.startAnimation(animation);
        return animation;
    }

    public static void fadeIn(View view) {
        fadeIn(view, null);
    }

    public static void fadeOut(View view) {
        fadeOut(view, null);
    }

    public static void fadeOutIn(View view) {
        view.setAlpha(0.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, "alpha", 0.0f, 0.5f, 1.0f);
        ObjectAnimator.ofFloat(view, "alpha", 0.0f).start();
        objectAnimatorOfFloat.setDuration(500L);
        animatorSet.play(objectAnimatorOfFloat);
        animatorSet.start();
    }

    public static void flyInDown(View view, final AnimListener animListener) {
        view.setVisibility(0);
        view.setAlpha(0.0f);
        view.setTranslationY(0.0f);
        view.setTranslationY(-view.getHeight());
        view.animate().setDuration(200L).translationY(0.0f).setListener(new AnimatorListenerAdapter() { // from class: com.mimikridev.utilmanager.animation.ViewAnimation.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                AnimListener animListener2 = animListener;
                if (animListener2 != null) {
                    animListener2.onFinish();
                }
                super.onAnimationEnd(animator);
            }
        }).alpha(1.0f).start();
    }

    public static void flyOutDown(View view, final AnimListener animListener) {
        view.setVisibility(0);
        view.setAlpha(1.0f);
        view.setTranslationY(0.0f);
        view.animate().setDuration(200L).translationY(view.getHeight()).setListener(new AnimatorListenerAdapter() { // from class: com.mimikridev.utilmanager.animation.ViewAnimation.5
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                AnimListener animListener2 = animListener;
                if (animListener2 != null) {
                    animListener2.onFinish();
                }
                super.onAnimationEnd(animator);
            }
        }).alpha(0.0f).start();
    }

    public static void hideFab(View view) {
        view.animate().translationY(view.getHeight() * 2).setDuration(300L).start();
    }

    public static void hideScale(View view) {
        fadeOut(view, null);
    }

    public static void initShowOut(View view) {
        view.setVisibility(8);
        view.setTranslationY(view.getHeight());
        view.setAlpha(0.0f);
    }

    public static boolean rotateFab(View view, boolean z2) {
        view.animate().setDuration(200L).setListener(new AnimatorListenerAdapter() { // from class: com.mimikridev.utilmanager.animation.ViewAnimation.10
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
            }
        }).rotation(z2 ? 135.0f : 0.0f);
        return z2;
    }

    public static void showFab(View view) {
        view.animate().translationY(0.0f).setDuration(300L).start();
    }

    public static void showIn(View view) {
        view.setVisibility(0);
        view.setAlpha(0.0f);
        view.setTranslationY(view.getHeight());
        view.animate().setDuration(200L).translationY(0.0f).setListener(new AnimatorListenerAdapter() { // from class: com.mimikridev.utilmanager.animation.ViewAnimation.8
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
            }
        }).alpha(1.0f).start();
    }

    public static void showOut(final View view) {
        view.setVisibility(0);
        view.setAlpha(1.0f);
        view.setTranslationY(0.0f);
        view.animate().setDuration(200L).translationY(view.getHeight()).setListener(new AnimatorListenerAdapter() { // from class: com.mimikridev.utilmanager.animation.ViewAnimation.9
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                view.setVisibility(8);
                super.onAnimationEnd(animator);
            }
        }).alpha(0.0f).start();
    }

    public static void showScale(View view) {
        showScale(view, null);
    }

    public static void fadeIn(final View view, final AnimListener animListener) {
        view.setVisibility(8);
        view.setAlpha(0.0f);
        view.animate().setDuration(200L).setListener(new AnimatorListenerAdapter() { // from class: com.mimikridev.utilmanager.animation.ViewAnimation.6
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                view.setVisibility(0);
                AnimListener animListener2 = animListener;
                if (animListener2 != null) {
                    animListener2.onFinish();
                }
                super.onAnimationEnd(animator);
            }
        }).alpha(1.0f);
    }

    public static void fadeOut(View view, final AnimListener animListener) {
        view.setAlpha(1.0f);
        view.animate().setDuration(500L).setListener(new AnimatorListenerAdapter() { // from class: com.mimikridev.utilmanager.animation.ViewAnimation.7
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                AnimListener animListener2 = animListener;
                if (animListener2 != null) {
                    animListener2.onFinish();
                }
                super.onAnimationEnd(animator);
            }
        }).alpha(0.0f);
    }

    public static void hideScale(View view, final AnimListener animListener) {
        view.animate().scaleY(0.0f).scaleX(0.0f).setDuration(200L).setListener(new AnimatorListenerAdapter() { // from class: com.mimikridev.utilmanager.animation.ViewAnimation.12
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                AnimListener animListener2 = animListener;
                if (animListener2 != null) {
                    animListener2.onFinish();
                }
                super.onAnimationEnd(animator);
            }
        }).start();
    }

    public static void showScale(View view, final AnimListener animListener) {
        view.animate().scaleY(1.0f).scaleX(1.0f).setDuration(200L).setListener(new AnimatorListenerAdapter() { // from class: com.mimikridev.utilmanager.animation.ViewAnimation.11
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                AnimListener animListener2 = animListener;
                if (animListener2 != null) {
                    animListener2.onFinish();
                }
                super.onAnimationEnd(animator);
            }
        }).start();
    }

    public static void expand(View view) {
        view.startAnimation(expandAction(view));
    }
}
