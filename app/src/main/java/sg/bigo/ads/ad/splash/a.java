package sg.bigo.ads.ad.splash;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.webkit.ValueCallback;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.motion.widget.Key;
import androidx.core.view.ViewCompat;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import sg.bigo.ads.R;
import sg.bigo.ads.ad.interstitial.s;
import sg.bigo.ads.api.SplashAd;
import sg.bigo.ads.api.a.h;
import sg.bigo.ads.api.a.i;
import sg.bigo.ads.api.a.m;
import sg.bigo.ads.api.core.o;
import sg.bigo.ads.common.n.d;
import sg.bigo.ads.common.p.f;
import sg.bigo.ads.common.p.g;
import sg.bigo.ads.common.utils.b;
import sg.bigo.ads.common.utils.e;
import sg.bigo.ads.common.utils.q;
import sg.bigo.ads.common.utils.u;

/* JADX INFO: loaded from: classes6.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f15259a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f15260b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static List<ObjectAnimator> f15261c;

    @LayoutRes
    public static int a(@NonNull m mVar) {
        return b(mVar) ? R.layout.bigo_ad_splash_style_halfscreen : R.layout.bigo_ad_splash_style_fullscreen;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(ObjectAnimator objectAnimator) {
        if (f15261c == null) {
            f15261c = new ArrayList();
        }
        f15261c.add(objectAnimator);
    }

    @NonNull
    public static SplashAd.Style c(@NonNull m mVar) {
        h hVar = i.f15457a;
        return (hVar == null ? 0 : hVar.u()) == 1 ? SplashAd.Style.HORIZONTAL : mVar.a("splash_style") == 1 ? SplashAd.Style.VERTICAL_HALFSCREEN : SplashAd.Style.VERTICAL_FULLSCREEN;
    }

    public static void a() {
        List<ObjectAnimator> list = f15261c;
        if (list != null) {
            Iterator<ObjectAnimator> it = list.iterator();
            while (it.hasNext()) {
                it.next().cancel();
            }
            f15261c.clear();
            f15261c = null;
        }
    }

    public static void b(View view) {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, Key.ROTATION, 0.0f, 10.0f);
        objectAnimatorOfFloat.setDuration(300L);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(view, Key.ROTATION, 10.0f, -10.0f);
        objectAnimatorOfFloat2.setDuration(300L);
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(view, Key.ROTATION, -10.0f, 0.0f);
        objectAnimatorOfFloat3.setDuration(300L);
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat.setDuration(500L);
        final AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(objectAnimatorOfFloat, objectAnimatorOfFloat2, objectAnimatorOfFloat3, valueAnimatorOfFloat);
        animatorSet.addListener(new b.d() { // from class: sg.bigo.ads.ad.splash.a.4
            @Override // sg.bigo.ads.common.utils.b.d, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                if (a.f15259a) {
                    animatorSet.start();
                } else {
                    animatorSet.cancel();
                }
            }
        });
        animatorSet.start();
    }

    public static /* synthetic */ void c(final ViewGroup viewGroup, int i2) {
        if (i2 == 1 || i2 == 2 || i2 == 3) {
            viewGroup = (ViewGroup) viewGroup.findViewById(R.id.bigo_ad_splash_cta_inner);
            viewGroup.setVisibility(0);
        }
        if (i2 == 0) {
            View viewA = sg.bigo.ads.common.utils.a.a(viewGroup.getContext(), R.layout.bigo_ad_splash_item_cta_bg, viewGroup, false);
            if (viewA != null) {
                viewGroup.addView(viewA);
                ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(viewA, PropertyValuesHolder.ofKeyframe("alpha", Keyframe.ofFloat(0.0f, 0.3f), Keyframe.ofFloat(0.8f, 0.0f)), PropertyValuesHolder.ofKeyframe("scaleX", Keyframe.ofFloat(0.0f, 1.0f), Keyframe.ofFloat(0.8f, 1.07f)), PropertyValuesHolder.ofKeyframe("scaleY", Keyframe.ofFloat(0.0f, 1.0f), Keyframe.ofFloat(0.8f, 1.54f)));
                b(objectAnimatorOfPropertyValuesHolder);
                objectAnimatorOfPropertyValuesHolder.setDuration(1000L);
                objectAnimatorOfPropertyValuesHolder.setInterpolator(sg.bigo.ads.common.utils.b.a(2));
                objectAnimatorOfPropertyValuesHolder.setRepeatCount(-1);
                objectAnimatorOfPropertyValuesHolder.start();
                return;
            }
            return;
        }
        if (i2 == 1) {
            View viewA2 = sg.bigo.ads.common.utils.a.a(viewGroup.getContext(), R.layout.bigo_ad_splash_item_arrow, viewGroup, false);
            if (viewA2 != null) {
                viewGroup.addView(viewA2);
                float fA = e.a(viewGroup.getContext(), 6);
                ObjectAnimator objectAnimatorOfPropertyValuesHolder2 = ObjectAnimator.ofPropertyValuesHolder(viewA2, PropertyValuesHolder.ofKeyframe("translationX", Keyframe.ofFloat(0.0f, 0.0f), Keyframe.ofFloat(0.24f, -fA), Keyframe.ofFloat(0.44f, fA), Keyframe.ofFloat(0.64f, 0.0f)));
                b(objectAnimatorOfPropertyValuesHolder2);
                objectAnimatorOfPropertyValuesHolder2.setDuration(1000L);
                objectAnimatorOfPropertyValuesHolder2.setRepeatCount(-1);
                objectAnimatorOfPropertyValuesHolder2.start();
                return;
            }
            return;
        }
        if (i2 == 2) {
            b(viewGroup);
            viewGroup.postDelayed(new Runnable() { // from class: sg.bigo.ads.ad.splash.a.8
                @Override // java.lang.Runnable
                public final void run() {
                    a.b(viewGroup);
                }
            }, 150L);
            return;
        }
        if (i2 == 3) {
            a(viewGroup, false);
            return;
        }
        if (i2 == 4) {
            b(viewGroup, false);
            return;
        }
        if (i2 != 5) {
            return;
        }
        sg.bigo.ads.common.utils.a.a(viewGroup.getContext(), R.layout.bigo_ad_splash_item_slide, viewGroup, true);
        View viewFindViewById = viewGroup.findViewById(R.id.splash_slide);
        if (viewFindViewById != null) {
            float fA2 = e.a(viewGroup.getContext(), 10);
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(viewFindViewById, "translationY", 0.0f, fA2, (-2.0f) * fA2, 0.0f, 0.0f);
            b(objectAnimatorOfFloat);
            objectAnimatorOfFloat.setDuration(1000L);
            objectAnimatorOfFloat.setRepeatCount(-1);
            objectAnimatorOfFloat.start();
        }
    }

    public static void a(int i2, @NonNull sg.bigo.ads.ad.b.c cVar, @NonNull final ViewGroup viewGroup) {
        final int iA = i2 != 2 ? i2 != 3 ? i2 != 4 ? -1 : s.a(cVar, -1) : -7829368 : ViewCompat.MEASURED_STATE_MASK;
        if (iA != -1) {
            d.b(new Runnable() { // from class: sg.bigo.ads.ad.splash.a.2
                @Override // java.lang.Runnable
                public final void run() {
                    ImageView imageView;
                    View viewFindViewWithTag = viewGroup.findViewWithTag("adview_background_main_tag");
                    if (viewFindViewWithTag instanceof ImageView) {
                        imageView = (ImageView) viewFindViewWithTag;
                    } else {
                        Context context = viewGroup.getContext();
                        if (context != null) {
                            ImageView imageView2 = new ImageView(context);
                            imageView2.setTag("adview_background_main_tag");
                            imageView2.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                            u.a(imageView2, viewGroup, null, 0);
                            imageView = imageView2;
                        } else {
                            imageView = null;
                        }
                    }
                    if (imageView != null) {
                        imageView.setBackgroundColor(iA);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(@NonNull ViewGroup viewGroup) {
        View viewA = sg.bigo.ads.common.utils.a.a(viewGroup.getContext(), R.layout.bigo_ad_splash_item_ripple, viewGroup, false);
        if (viewA != null) {
            viewGroup.addView(viewA);
            Interpolator interpolatorA = sg.bigo.ads.common.utils.b.a(2);
            ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(viewA, PropertyValuesHolder.ofFloat("alpha", 0.0f, 0.2f, 0.2f, 0.0f), PropertyValuesHolder.ofFloat("scaleX", 0.0f, 1.0f, 2.5f, 4.5f), PropertyValuesHolder.ofFloat("scaleY", 0.0f, 1.0f, 2.5f, 4.5f));
            b(objectAnimatorOfPropertyValuesHolder);
            objectAnimatorOfPropertyValuesHolder.setDuration(1000L);
            objectAnimatorOfPropertyValuesHolder.setInterpolator(interpolatorA);
            objectAnimatorOfPropertyValuesHolder.setRepeatCount(-1);
            objectAnimatorOfPropertyValuesHolder.start();
        }
    }

    public static void b(@NonNull ViewGroup viewGroup, int i2) {
        if (i2 == 2) {
            viewGroup = (ViewGroup) viewGroup.findViewById(R.id.bigo_ad_splash_cta_inner);
            viewGroup.setVisibility(0);
        }
        if (i2 == 1) {
            sg.bigo.ads.ad.interstitial.c.e(viewGroup);
            return;
        }
        if (i2 == 2) {
            a(viewGroup, true);
            return;
        }
        if (i2 == 3) {
            b(viewGroup, true);
            return;
        }
        if (i2 != 4) {
            return;
        }
        sg.bigo.ads.common.utils.a.a(viewGroup.getContext(), R.layout.bigo_ad_splash_endpage_item_slide, viewGroup, true);
        View viewFindViewById = viewGroup.findViewById(R.id.splash_slide);
        View viewFindViewById2 = viewGroup.findViewById(R.id.splash_slide_hand);
        if (viewFindViewById == null || viewFindViewById2 == null) {
            return;
        }
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(viewFindViewById2, "alpha", 0.0f, 1.0f);
        objectAnimatorOfFloat.setDuration(300L);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(viewFindViewById2, "alpha", 1.0f, 0.0f);
        objectAnimatorOfFloat2.setDuration(300L);
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(viewFindViewById2, "translationY", 100.0f, -160.0f);
        objectAnimatorOfFloat3.setDuration(300L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(objectAnimatorOfFloat2, objectAnimatorOfFloat3);
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat.setDuration(500L);
        AnimatorSet animatorSet2 = new AnimatorSet();
        animatorSet2.playSequentially(objectAnimatorOfFloat, animatorSet, valueAnimatorOfFloat);
        ObjectAnimator objectAnimatorOfFloat4 = ObjectAnimator.ofFloat(viewFindViewById, "translationY", 20.0f, 0.0f);
        objectAnimatorOfFloat4.setDuration(300L);
        ObjectAnimator objectAnimatorOfFloat5 = ObjectAnimator.ofFloat(viewFindViewById, "translationY", 0.0f, 20.0f);
        objectAnimatorOfFloat5.setDuration(300L);
        objectAnimatorOfFloat5.setInterpolator(new DecelerateInterpolator());
        AnimatorSet animatorSet3 = new AnimatorSet();
        animatorSet3.playSequentially(objectAnimatorOfFloat5, objectAnimatorOfFloat4);
        final AnimatorSet animatorSet4 = (AnimatorSet) new WeakReference(new AnimatorSet()).get();
        if (animatorSet4 != null) {
            animatorSet4.playTogether(animatorSet2, animatorSet3);
            animatorSet4.addListener(new b.d() { // from class: sg.bigo.ads.ad.splash.a.13
                @Override // sg.bigo.ads.common.utils.b.d, android.animation.Animator.AnimatorListener
                public final void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    if (a.f15260b) {
                        animatorSet4.start();
                    } else {
                        animatorSet4.cancel();
                    }
                }
            });
            animatorSet4.start();
        }
    }

    public static void a(View view) {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, Key.ROTATION, 0.0f, 25.0f);
        objectAnimatorOfFloat.setDuration(300L);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(view, Key.ROTATION, 25.0f, -25.0f);
        objectAnimatorOfFloat2.setDuration(300L);
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(view, Key.ROTATION, -25.0f, 0.0f);
        objectAnimatorOfFloat3.setDuration(300L);
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat.setDuration(500L);
        final AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(objectAnimatorOfFloat, objectAnimatorOfFloat2, objectAnimatorOfFloat3, valueAnimatorOfFloat);
        animatorSet.addListener(new b.d() { // from class: sg.bigo.ads.ad.splash.a.3
            @Override // sg.bigo.ads.common.utils.b.d, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                if (a.f15259a) {
                    animatorSet.start();
                } else {
                    animatorSet.cancel();
                }
            }
        });
        animatorSet.start();
    }

    private static void b(@NonNull ViewGroup viewGroup, boolean z2) {
        int i2 = R.layout.bigo_ad_splash_item_click_guide;
        if (z2) {
            i2 = R.layout.bigo_ad_splash_endpage_item_click_guide;
        }
        View viewA = sg.bigo.ads.common.utils.a.a(viewGroup.getContext(), i2, viewGroup, false);
        if (viewA != null) {
            viewGroup.addView(viewA);
            final View viewFindViewById = viewA.findViewById(R.id.click_gesture);
            final View viewFindViewById2 = viewA.findViewById(R.id.click_ripple);
            final RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 10.0f, 1, 0.5f, 1, 0.6f);
            rotateAnimation.setDuration(200L);
            rotateAnimation.setStartOffset(560L);
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
            alphaAnimation.setAnimationListener(new b.c() { // from class: sg.bigo.ads.ad.splash.a.10
                @Override // sg.bigo.ads.common.utils.b.c, android.view.animation.Animation.AnimationListener
                public final void onAnimationEnd(Animation animation) {
                    viewFindViewById2.setVisibility(4);
                }
            });
            rotateAnimation.setAnimationListener(new b.c() { // from class: sg.bigo.ads.ad.splash.a.11
                @Override // sg.bigo.ads.common.utils.b.c, android.view.animation.Animation.AnimationListener
                public final void onAnimationEnd(Animation animation) {
                    viewFindViewById.startAnimation(rotateAnimation2);
                }
            });
            rotateAnimation2.setAnimationListener(new b.c() { // from class: sg.bigo.ads.ad.splash.a.12
                @Override // sg.bigo.ads.common.utils.b.c, android.view.animation.Animation.AnimationListener
                public final void onAnimationEnd(Animation animation) {
                    viewFindViewById.startAnimation(rotateAnimation);
                    viewFindViewById2.setVisibility(0);
                    viewFindViewById2.startAnimation(animationSet);
                }
            });
            viewFindViewById.startAnimation(rotateAnimation);
        }
    }

    public static void a(View view, float f4) {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, "alpha", 0.0f, 1.0f);
        objectAnimatorOfFloat.setDuration(100L);
        float fA = e.a(view.getContext(), 200);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(view, "alpha", 1.0f, 0.0f);
        objectAnimatorOfFloat2.setDuration(800L);
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(view, "translationY", f4, -fA);
        objectAnimatorOfFloat3.setDuration(800L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(objectAnimatorOfFloat2, objectAnimatorOfFloat3);
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat.setDuration(500L);
        final AnimatorSet animatorSet2 = new AnimatorSet();
        animatorSet2.playSequentially(objectAnimatorOfFloat, animatorSet, valueAnimatorOfFloat);
        animatorSet2.addListener(new b.d() { // from class: sg.bigo.ads.ad.splash.a.5
            @Override // sg.bigo.ads.common.utils.b.d, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                if (a.f15259a) {
                    animatorSet2.start();
                } else {
                    animatorSet2.cancel();
                }
            }
        });
        animatorSet2.start();
    }

    public static boolean b() {
        h hVar = i.f15457a;
        return hVar != null && hVar.u() == 1;
    }

    public static /* synthetic */ void a(View view, Animator.AnimatorListener animatorListener) {
        ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("translationY", view.getHeight() * 0.6f, 0.0f));
        objectAnimatorOfPropertyValuesHolder.setDuration(400L);
        objectAnimatorOfPropertyValuesHolder.addListener(animatorListener);
        objectAnimatorOfPropertyValuesHolder.start();
    }

    public static boolean b(@NonNull m mVar) {
        h hVar = i.f15457a;
        return (hVar == null ? 0 : hVar.u()) == 0 && mVar.a("splash_style") == 1;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x005d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void a(final android.view.View r6, android.view.View r7, int r8, boolean r9, int r10, boolean r11, int r12, int r13, @androidx.annotation.Nullable sg.bigo.ads.core.adview.h r14) {
        /*
            boolean r0 = r7 instanceof android.widget.FrameLayout
            if (r0 != 0) goto L11
            boolean r0 = r7 instanceof android.widget.RelativeLayout
            if (r0 != 0) goto L11
            java.lang.String r6 = "Failed to update up or below area click due to unsupported view."
            r7 = 0
            java.lang.String r8 = "SplashAd"
            sg.bigo.ads.common.t.a.a(r7, r8, r6)
            return
        L11:
            android.view.ViewGroup r7 = (android.view.ViewGroup) r7
            android.content.Context r0 = r6.getContext()
            if (r0 != 0) goto L1b
            goto La4
        L1b:
            r1 = -1
            if (r8 <= 0) goto L65
            android.view.View r2 = new android.view.View
            r2.<init>(r0)
            int r3 = sg.bigo.ads.R.id.bigo_ad_interstitial_below_area_click
            r2.setId(r3)
            r3 = 25
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r2.setTag(r3)
            boolean r3 = r7 instanceof android.widget.FrameLayout
            if (r3 == 0) goto L44
            android.widget.FrameLayout$LayoutParams r3 = new android.widget.FrameLayout$LayoutParams
            int r4 = sg.bigo.ads.common.utils.e.a(r0, r8)
            r5 = 80
            r3.<init>(r1, r4, r5)
        L40:
            r7.addView(r2, r3)
            goto L57
        L44:
            boolean r3 = r7 instanceof android.widget.RelativeLayout
            if (r3 == 0) goto L57
            android.widget.RelativeLayout$LayoutParams r3 = new android.widget.RelativeLayout$LayoutParams
            int r4 = sg.bigo.ads.common.utils.e.a(r0, r8)
            r3.<init>(r1, r4)
            r4 = 12
            r3.addRule(r4)
            goto L40
        L57:
            if (r9 == 0) goto L5d
            sg.bigo.ads.ad.b.a.a(r6, r2, r12, r14, r13)
            goto L65
        L5d:
            sg.bigo.ads.ad.splash.a$14 r9 = new sg.bigo.ads.ad.splash.a$14
            r9.<init>()
            sg.bigo.ads.ad.b.a.a(r6, r2, r12, r9, r13)
        L65:
            if (r10 <= 0) goto La4
            android.view.View r9 = new android.view.View
            r9.<init>(r0)
            r2 = 24
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r9.setTag(r2)
            boolean r2 = r7 instanceof android.widget.FrameLayout
            if (r2 == 0) goto L86
            android.widget.FrameLayout$LayoutParams r8 = new android.widget.FrameLayout$LayoutParams
            int r10 = sg.bigo.ads.common.utils.e.a(r0, r10)
            r8.<init>(r1, r10)
            r7.addView(r9, r8)
            goto L96
        L86:
            boolean r10 = r7 instanceof android.widget.RelativeLayout
            if (r10 == 0) goto L96
            android.widget.RelativeLayout$LayoutParams r10 = new android.widget.RelativeLayout$LayoutParams
            int r8 = sg.bigo.ads.common.utils.e.a(r0, r8)
            r10.<init>(r1, r8)
            r7.addView(r9, r10)
        L96:
            if (r11 == 0) goto L9c
            sg.bigo.ads.ad.b.a.a(r6, r9, r12, r14, r13)
            return
        L9c:
            sg.bigo.ads.ad.splash.a$15 r7 = new sg.bigo.ads.ad.splash.a$15
            r7.<init>()
            sg.bigo.ads.ad.b.a.a(r6, r9, r12, r7, r13)
        La4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: sg.bigo.ads.ad.splash.a.a(android.view.View, android.view.View, int, boolean, int, boolean, int, int, sg.bigo.ads.core.adview.h):void");
    }

    public static void a(@NonNull final ViewGroup viewGroup, final int i2) {
        final View viewFindViewById = viewGroup.findViewById(R.id.bigo_ad_splash_btn_cta);
        if (viewFindViewById == null) {
            return;
        }
        viewFindViewById.setAlpha(0.0f);
        viewGroup.post(new Runnable() { // from class: sg.bigo.ads.ad.splash.a.1
            @Override // java.lang.Runnable
            public final void run() {
                a.a(viewFindViewById, new b.d() { // from class: sg.bigo.ads.ad.splash.a.1.1
                    @Override // sg.bigo.ads.common.utils.b.d, android.animation.Animator.AnimatorListener
                    public final void onAnimationEnd(Animator animator) {
                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                        a.c(viewGroup, i2);
                    }
                });
            }
        });
    }

    private static void a(@NonNull final ViewGroup viewGroup, boolean z2) {
        final View viewA = sg.bigo.ads.common.utils.a.a(viewGroup.getContext(), R.layout.bigo_ad_splash_item_flash, viewGroup, false);
        if (viewA != null) {
            ViewGroup.LayoutParams layoutParams = viewA.getLayoutParams();
            if (z2) {
                layoutParams.width = e.a(viewA.getContext(), 34);
                layoutParams.height = e.a(viewA.getContext(), 40);
            }
            viewGroup.addView(viewA);
            viewGroup.post(new Runnable() { // from class: sg.bigo.ads.ad.splash.a.9
                @Override // java.lang.Runnable
                public final void run() {
                    ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(viewA, PropertyValuesHolder.ofKeyframe("translationX", Keyframe.ofFloat(0.0f, 0.0f), Keyframe.ofFloat(0.72f, viewGroup.getMeasuredWidth())));
                    a.b(objectAnimatorOfPropertyValuesHolder);
                    objectAnimatorOfPropertyValuesHolder.setDuration(1000L);
                    objectAnimatorOfPropertyValuesHolder.setRepeatCount(-1);
                    objectAnimatorOfPropertyValuesHolder.start();
                }
            });
        }
    }

    public static void a(@NonNull TextView textView, @Nullable String str, @Nullable String str2) {
        if (!TextUtils.isEmpty(str)) {
            textView.setText(str);
        } else {
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            textView.setText(str2);
        }
    }

    public static void a(@NonNull final sg.bigo.ads.ad.b.c cVar, final ValueCallback<Bitmap> valueCallback) {
        o oVar = (o) cVar.f();
        if (!oVar.aR()) {
            String strAT = oVar.aT();
            if (q.a((CharSequence) strAT)) {
                valueCallback.onReceiveValue(null);
                return;
            } else {
                sg.bigo.ads.common.p.e.a(cVar.f14024b.e, strAT, oVar.al(), new g() { // from class: sg.bigo.ads.ad.splash.a.7
                    @Override // sg.bigo.ads.common.p.g
                    public final void a(int i2, @NonNull String str, String str2) {
                        valueCallback.onReceiveValue(null);
                    }

                    @Override // sg.bigo.ads.common.p.g
                    public final void a(@NonNull Bitmap bitmap, @NonNull f fVar) {
                        valueCallback.onReceiveValue(bitmap);
                    }
                });
                return;
            }
        }
        String strB = sg.bigo.ads.common.o.b(cVar.f14024b.e, oVar.aN());
        if (q.a((CharSequence) strB)) {
            valueCallback.onReceiveValue(null);
        } else {
            final String path = Uri.parse(strB).getPath();
            d.a(3, new Runnable() { // from class: sg.bigo.ads.ad.splash.a.6
                @Override // java.lang.Runnable
                public final void run() {
                    valueCallback.onReceiveValue(sg.bigo.ads.common.utils.d.a(Uri.parse(path).getPath(), cVar.f14024b.e));
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void a(sg.bigo.ads.ad.interstitial.AdCountDownButton r5, int r6) {
        /*
            r0 = 1
            r1 = -1
            r2 = 2
            if (r6 == r2) goto L1f
            r3 = 3
            if (r6 == r3) goto L1c
            r3 = 4
            if (r6 == r3) goto L19
            r3 = 5
            if (r6 == r3) goto L16
            r3 = 6
            if (r6 == r3) goto L13
            r3 = r1
            goto L32
        L13:
            int r3 = sg.bigo.ads.R.drawable.bigo_ad_ic_close5
            goto L32
        L16:
            int r3 = sg.bigo.ads.R.drawable.bigo_ad_ic_close4
            goto L32
        L19:
            int r3 = sg.bigo.ads.R.drawable.bigo_ad_ic_close3
            goto L32
        L1c:
            int r3 = sg.bigo.ads.R.drawable.bigo_ad_ic_close
            goto L32
        L1f:
            r5.e = r0
            android.view.View r3 = r5.g
            r4 = 8
            r3.setVisibility(r4)
            android.view.View r3 = r5.f14168f
            r3.setVisibility(r4)
            r3 = 0
            r5.setShowCloseButtonInCountdown(r3)
            goto L19
        L32:
            if (r1 == r3) goto L41
            int r1 = sg.bigo.ads.R.layout.bigo_ad_item_inter_countdown_bg
            r5.a(r1)
            r5.setCloseImageResource(r3)
            if (r6 == r2) goto L41
            r5.setShowCloseButtonInCountdown(r0)
        L41:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: sg.bigo.ads.ad.splash.a.a(sg.bigo.ads.ad.interstitial.AdCountDownButton, int):void");
    }
}
