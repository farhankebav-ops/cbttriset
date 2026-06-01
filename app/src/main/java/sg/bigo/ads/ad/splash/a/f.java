package sg.bigo.ads.ad.splash.a;

import android.animation.ObjectAnimator;
import android.transition.ChangeBounds;
import android.transition.Fade;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import sg.bigo.ads.R;
import sg.bigo.ads.ad.interstitial.s;
import sg.bigo.ads.api.MediaView;
import sg.bigo.ads.api.a.m;
import sg.bigo.ads.common.p;
import sg.bigo.ads.common.utils.u;
import sg.bigo.ads.common.view.RoundedFrameLayout;

/* JADX INFO: loaded from: classes6.dex */
public final class f extends b {
    final int l;
    int m;

    public f(int i2, @NonNull sg.bigo.ads.api.core.g gVar, @NonNull m mVar, @Nullable m mVar2, @NonNull sg.bigo.ads.ad.splash.b bVar) {
        super(gVar, mVar, mVar2, bVar);
        this.l = i2;
    }

    @Override // sg.bigo.ads.ad.splash.a.b
    public final void a(ViewGroup viewGroup, int i2) {
        this.m = i2;
    }

    @Override // sg.bigo.ads.ad.splash.a.b
    public final int e() {
        return 5 == this.l ? R.layout.bigo_ad_splash_style_5_card_widget : R.layout.bigo_ad_splash_style_4_cta_widget;
    }

    @Override // sg.bigo.ads.ad.splash.a.b, sg.bigo.ads.ad.splash.a.c
    public final void a(boolean z2, @NonNull final ViewGroup viewGroup, int i2) {
        super.a(z2, viewGroup, i2);
        if (z2) {
            final RoundedFrameLayout roundedFrameLayout = (RoundedFrameLayout) viewGroup.findViewById(R.id.bigo_ad_splash_media_container);
            final ViewGroup viewGroup2 = (ViewGroup) viewGroup.findViewById(R.id.bigo_ad_splash_btn_cta_container_round);
            MediaView mediaView = (MediaView) viewGroup.findViewById(R.id.bigo_ad_splash_media);
            if (viewGroup2 == null || roundedFrameLayout == null) {
                return;
            }
            final int iA = sg.bigo.ads.common.utils.e.a(viewGroup2.getContext(), 20);
            final int iA2 = sg.bigo.ads.common.utils.e.a(viewGroup2.getContext(), 12);
            final int iA3 = sg.bigo.ads.common.utils.e.a(viewGroup2.getContext(), 38);
            final int iA4 = sg.bigo.ads.common.utils.e.a(viewGroup2.getContext(), 190);
            final ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) viewGroup2.getLayoutParams();
            marginLayoutParams.width = 0;
            marginLayoutParams.height = 0;
            viewGroup2.setLayoutParams(marginLayoutParams);
            final int iC = sg.bigo.ads.common.utils.e.c(viewGroup2.getContext());
            final int i8 = viewGroup2.getContext().getResources().getDisplayMetrics().widthPixels;
            final int i9 = (iC - iA3) - iA;
            int i10 = i8 - (iA * 2);
            final p pVarA = s.a(this.h.f15396x);
            final p pVarA2 = p.a(pVarA.f15849b, pVarA.f15850c, i10, i9);
            final ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) roundedFrameLayout.getLayoutParams();
            marginLayoutParams2.width = pVarA2.f15849b;
            marginLayoutParams2.height = pVarA2.f15850c;
            roundedFrameLayout.setLayoutParams(marginLayoutParams2);
            roundedFrameLayout.setCornerRadius(iA2);
            u.c(mediaView, -1, -1);
            StringBuilder sb = new StringBuilder("videoW:");
            sb.append(pVarA.f15849b);
            sb.append("..videoH:");
            sb.append(pVarA.f15850c);
            sb.append("..oriW:");
            sb.append(pVarA2.f15849b);
            sb.append("..oriH:");
            androidx.camera.core.processing.util.a.w(pVarA2.f15850c, i10, "..rawW:", "..rawH:", sb);
            androidx.camera.core.processing.util.a.w(i9, i8, "..targeW:..scW:", "..scH:", sb);
            sb.append(iC);
            int i11 = 0;
            sg.bigo.ads.common.t.a.a(0, 3, "SplashCTA", sb.toString());
            m mVar = this.f15302c;
            int iA5 = mVar == null ? 0 : mVar.a("video_play_page.ad_component_show_time");
            if (iA5 != 0) {
                if (iA5 == 1) {
                    i11 = 1;
                } else if (iA5 == 2) {
                    i11 = 3;
                } else if (iA5 == 3) {
                    i11 = 5;
                }
            }
            viewGroup2.postDelayed(new Runnable() { // from class: sg.bigo.ads.ad.splash.a.f.1
                @Override // java.lang.Runnable
                public final void run() {
                    if (f.this.h.f14028i) {
                        return;
                    }
                    TransitionSet transitionSet = new TransitionSet();
                    transitionSet.addTransition(new ChangeBounds());
                    transitionSet.addTransition(new Fade());
                    transitionSet.addListener((Transition.TransitionListener) new sg.bigo.ads.common.h() { // from class: sg.bigo.ads.ad.splash.a.f.1.1
                        @Override // sg.bigo.ads.common.h, android.transition.Transition.TransitionListener
                        public final void onTransitionStart(Transition transition) {
                            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(viewGroup2, "alpha", 0.0f, 1.0f);
                            objectAnimatorOfFloat.setDuration(500L);
                            objectAnimatorOfFloat.start();
                        }
                    });
                    TransitionManager.beginDelayedTransition(viewGroup, transitionSet);
                    int iA6 = iA4;
                    if (5 == f.this.l) {
                        iA6 = sg.bigo.ads.common.utils.e.a(viewGroup2.getContext(), 80);
                    }
                    ViewGroup.MarginLayoutParams marginLayoutParams3 = marginLayoutParams;
                    marginLayoutParams3.width = i8 - iA;
                    marginLayoutParams3.height = iA6;
                    viewGroup2.setLayoutParams(marginLayoutParams3);
                    int i12 = i9 - iA6;
                    int i13 = pVarA2.f15850c;
                    if (i13 > i12) {
                        int i14 = (int) (((i12 * 1.0f) * r2.f15849b) / i13);
                        p pVar = pVarA;
                        p pVarA3 = p.a(pVar.f15849b, pVar.f15850c, i14, i12);
                        ViewGroup.MarginLayoutParams marginLayoutParams4 = (ViewGroup.MarginLayoutParams) roundedFrameLayout.getLayoutParams();
                        marginLayoutParams4.width = pVarA3.f15849b;
                        marginLayoutParams4.height = pVarA3.f15850c;
                        roundedFrameLayout.setLayoutParams(marginLayoutParams4);
                        roundedFrameLayout.setCornerRadius(iA2);
                    }
                    int i15 = iC;
                    int i16 = iA3;
                    int i17 = (i15 - i16) / 2;
                    marginLayoutParams2.bottomMargin = Math.abs(((((i15 - i16) - iA6) - iA) / 2) - i17);
                    roundedFrameLayout.setLayoutParams(marginLayoutParams2);
                    ViewGroup viewGroup3 = viewGroup2;
                    if (f.this.m == 0) {
                        viewGroup3 = (ViewGroup) viewGroup.findViewById(R.id.bigo_ad_splash_btn_cta_container);
                    }
                    sg.bigo.ads.ad.splash.a.a(viewGroup3, f.this.m);
                }
            }, i11 * 1000);
        }
    }
}
