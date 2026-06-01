package sg.bigo.ads.ad.c;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Handler;
import android.os.Looper;
import android.transition.ChangeBounds;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.constraintlayout.motion.widget.Key;
import sg.bigo.ads.R;
import sg.bigo.ads.common.utils.b;
import sg.bigo.ads.common.utils.e;
import sg.bigo.ads.common.utils.u;

/* JADX INFO: loaded from: classes6.dex */
public final class a {

    /* JADX INFO: renamed from: sg.bigo.ads.ad.c.a$4, reason: invalid class name */
    public static class AnonymousClass4 implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f14049a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f14050b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ int[] f14051c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ ViewGroup f14052d;
        final /* synthetic */ int e;

        public AnonymousClass4(View view, View view2, int[] iArr, ViewGroup viewGroup, int i2) {
            this.f14049a = view;
            this.f14050b = view2;
            this.f14051c = iArr;
            this.f14052d = viewGroup;
            this.e = i2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (this.f14049a.getVisibility() != 0) {
                this.f14049a.setVisibility(0);
            }
            View view = this.f14050b;
            int[] iArr = this.f14051c;
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, "translationX", iArr[0], iArr[1]);
            objectAnimatorOfFloat.setDuration(1000L);
            objectAnimatorOfFloat.setInterpolator(sg.bigo.ads.common.utils.b.a(0));
            objectAnimatorOfFloat.addListener(new b.d() { // from class: sg.bigo.ads.ad.c.a.4.1
                @Override // sg.bigo.ads.common.utils.b.d, android.animation.Animator.AnimatorListener
                public final void onAnimationEnd(Animator animator) {
                    ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(AnonymousClass4.this.f14050b, Key.ROTATION, 0.0f, -20.0f, 0.0f);
                    objectAnimatorOfFloat2.setInterpolator(sg.bigo.ads.common.utils.b.a(1));
                    objectAnimatorOfFloat2.setDuration(500L);
                    objectAnimatorOfFloat2.setRepeatCount(1);
                    objectAnimatorOfFloat2.addListener(new b.d() { // from class: sg.bigo.ads.ad.c.a.4.1.1
                        @Override // sg.bigo.ads.common.utils.b.d, android.animation.Animator.AnimatorListener
                        public final void onAnimationEnd(Animator animator2) {
                            AnonymousClass4 anonymousClass4 = AnonymousClass4.this;
                            ViewGroup viewGroup = anonymousClass4.f14052d;
                            View view2 = anonymousClass4.f14049a;
                            int i2 = anonymousClass4.e - 1;
                            a.a(viewGroup, 0L, i2, anonymousClass4.f14051c);
                            if (i2 == 0) {
                                ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(view2, "alpha", view2.getAlpha(), 0.0f);
                                objectAnimatorOfFloat3.setDuration(300L);
                                objectAnimatorOfFloat3.setInterpolator(sg.bigo.ads.common.utils.b.a(1));
                                objectAnimatorOfFloat3.start();
                            }
                        }
                    });
                    objectAnimatorOfFloat2.start();
                }
            });
            ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.f14050b, "alpha", 0.0f, 1.0f);
            objectAnimatorOfFloat2.setDuration(300L);
            objectAnimatorOfFloat2.setInterpolator(sg.bigo.ads.common.utils.b.a(1));
            ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(this.f14050b, "scaleX", 0.0f, 1.0f);
            ObjectAnimator objectAnimatorOfFloat4 = ObjectAnimator.ofFloat(this.f14050b, "scaleY", 0.0f, 1.0f);
            objectAnimatorOfFloat3.setDuration(300L);
            objectAnimatorOfFloat3.setInterpolator(sg.bigo.ads.common.utils.b.a(1));
            objectAnimatorOfFloat4.setDuration(300L);
            objectAnimatorOfFloat4.setInterpolator(sg.bigo.ads.common.utils.b.a(1));
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2, objectAnimatorOfFloat3, objectAnimatorOfFloat4);
            animatorSet.start();
        }
    }

    public static void a(@NonNull final ViewGroup viewGroup, final long j, final int i2) {
        Handler handler = new Handler(Looper.getMainLooper());
        if (i2 <= 0) {
            return;
        }
        handler.post(new Runnable() { // from class: sg.bigo.ads.ad.c.a.3
            @Override // java.lang.Runnable
            public final void run() {
                ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(viewGroup, "translationX", 0.0f, -r0, 0.0f, e.a(viewGroup.getContext(), 8), 0.0f);
                objectAnimatorOfFloat.setInterpolator(sg.bigo.ads.common.utils.b.a(3));
                objectAnimatorOfFloat.setDuration(300L);
                objectAnimatorOfFloat.setRepeatMode(2);
                objectAnimatorOfFloat.setStartDelay(j);
                objectAnimatorOfFloat.addListener(new AnimatorListenerAdapter() { // from class: sg.bigo.ads.ad.c.a.3.1
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public final void onAnimationEnd(Animator animator) {
                        super.onAnimationEnd(animator);
                        a.a(viewGroup, 100L, i2 - 1);
                    }
                });
                objectAnimatorOfFloat.start();
            }
        });
    }

    public static void a(ViewGroup viewGroup, long j, int i2, int[] iArr) {
        if (i2 > 0 && iArr.length >= 2 && viewGroup != null) {
            View viewFindViewById = viewGroup.findViewById(R.id.inter_banner_click_img);
            View viewFindViewById2 = viewGroup.findViewById(R.id.inter_banner_click_guide_contain);
            if (viewFindViewById == null || viewFindViewById2 == null) {
                return;
            }
            viewGroup.postDelayed(new AnonymousClass4(viewFindViewById2, viewFindViewById, iArr, viewGroup, i2), j);
        }
    }

    public static void a(final ViewGroup viewGroup, final View view, final boolean z2) {
        Handler handler = new Handler(Looper.getMainLooper());
        if (viewGroup == null || view == null) {
            return;
        }
        handler.post(new Runnable() { // from class: sg.bigo.ads.ad.c.a.2
            @Override // java.lang.Runnable
            public final void run() {
                if (z2) {
                    TransitionSet transitionSet = new TransitionSet();
                    transitionSet.addTransition(new ChangeBounds());
                    transitionSet.setDuration(300L);
                    TransitionManager.beginDelayedTransition(viewGroup, transitionSet);
                }
                if (view.getVisibility() != 0) {
                    view.setVisibility(0);
                }
                View viewFindViewById = view.findViewById(R.id.bigo_ad_banner_placeholder_view);
                if (viewFindViewById != null) {
                    u.b(viewFindViewById);
                }
            }
        });
    }
}
