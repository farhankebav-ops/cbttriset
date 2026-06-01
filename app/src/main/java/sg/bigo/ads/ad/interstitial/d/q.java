package sg.bigo.ads.ad.interstitial.d;

import android.graphics.Bitmap;
import android.transition.ChangeBounds;
import android.transition.Fade;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import sg.bigo.ads.R;
import sg.bigo.ads.ad.interstitial.d.a;
import sg.bigo.ads.common.view.RoundedFrameLayout;
import sg.bigo.ads.common.w.b;

/* JADX INFO: loaded from: classes6.dex */
public final class q extends m {
    private RoundedFrameLayout G;
    private LinearLayout H;
    private RoundedFrameLayout I;
    private ImageView J;
    private TextView K;
    private TextView L;
    private ImageView M;
    private RoundedFrameLayout N;
    private Button O;
    private boolean P;

    public q(@NonNull sg.bigo.ads.ad.b.c cVar) {
        super(cVar);
        this.P = false;
    }

    @Override // sg.bigo.ads.ad.interstitial.d.m
    public final void J() {
        ViewGroup viewGroup;
        RoundedFrameLayout roundedFrameLayout;
        sg.bigo.ads.core.adview.h hVar;
        int i2;
        super.J();
        if (this.f14452s.h) {
            sg.bigo.ads.ad.b.a.a(this.G, 18);
            viewGroup = this.f14450q;
            roundedFrameLayout = this.G;
            hVar = ((sg.bigo.ads.ad.interstitial.u) this).f15138c;
            i2 = this.f14452s.f15199i;
        } else {
            viewGroup = this.f14450q;
            roundedFrameLayout = this.G;
            hVar = sg.bigo.ads.ad.interstitial.r.F;
            i2 = 0;
        }
        sg.bigo.ads.ad.b.a.a(viewGroup, roundedFrameLayout, 8, hVar, i2);
    }

    @Override // sg.bigo.ads.ad.interstitial.d.m
    public final void b(int i2) {
        super.b(i2);
        final int iA = sg.bigo.ads.common.utils.e.a(this.f14450q.getContext(), 12);
        final int iA2 = sg.bigo.ads.common.utils.e.a(this.f14450q.getContext(), 16);
        final int iA3 = sg.bigo.ads.common.utils.e.a(this.f14450q.getContext(), 20);
        final int iA4 = sg.bigo.ads.common.utils.e.a(this.f14450q.getContext(), 72);
        int iMax = Math.max(1, i2);
        final boolean[] zArr = {false, false};
        final boolean zV = v();
        this.f14450q.postDelayed(new Runnable() { // from class: sg.bigo.ads.ad.interstitial.d.q.1
            @Override // java.lang.Runnable
            public final void run() {
                if (sg.bigo.ads.ad.c.a((sg.bigo.ads.ad.c) ((sg.bigo.ads.ad.interstitial.u) q.this).f15138c)) {
                    return;
                }
                q.b(q.this);
                final a.C0259a c0259aU = q.this.u();
                TransitionSet transitionSet = new TransitionSet();
                transitionSet.addTransition(new ChangeBounds());
                transitionSet.addTransition(new Fade());
                transitionSet.addListener((Transition.TransitionListener) new sg.bigo.ads.common.h() { // from class: sg.bigo.ads.ad.interstitial.d.q.1.1
                    @Override // sg.bigo.ads.common.h, android.transition.Transition.TransitionListener
                    public final void onTransitionEnd(Transition transition) {
                        q.this.H();
                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                        zArr[0] = true;
                        RoundedFrameLayout roundedFrameLayout = q.this.N;
                        AnonymousClass1 anonymousClass12 = AnonymousClass1.this;
                        boolean[] zArr2 = zArr;
                        sg.bigo.ads.ad.interstitial.multi_img.e.a(roundedFrameLayout, zArr2[0], zArr2[1], zV);
                        if (c0259aU.f14480b) {
                            q qVar = q.this;
                            qVar.a(qVar.O, new b.a());
                        }
                    }

                    @Override // sg.bigo.ads.common.h, android.transition.Transition.TransitionListener
                    public final void onTransitionStart(final Transition transition) {
                        q.this.G();
                        sg.bigo.ads.common.w.b.a(q.this.H, -1, new b.a() { // from class: sg.bigo.ads.ad.interstitial.d.q.1.1.1
                            @Override // sg.bigo.ads.common.w.b.a
                            public final long a() {
                                return transition.getDuration();
                            }
                        });
                        RoundedFrameLayout roundedFrameLayout = q.this.N;
                        Button button = q.this.O;
                        int i8 = c0259aU.f14479a;
                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                        sg.bigo.ads.ad.interstitial.multi_img.e.a(roundedFrameLayout, button, i8, zArr, zV, transition.getDuration());
                    }
                });
                TransitionManager.beginDelayedTransition(q.this.f14451r, transitionSet);
                q.this.G.setCornerRadius(iA);
                if (q.this.C()) {
                    ViewGroup.LayoutParams layoutParams = ((m) q.this).y.getLayoutParams();
                    layoutParams.height = iA2;
                    ((m) q.this).y.setLayoutParams(layoutParams);
                }
                int childCount = q.this.H.getChildCount();
                for (int i8 = 0; i8 < childCount; i8++) {
                    View childAt = q.this.H.getChildAt(i8);
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) childAt.getLayoutParams();
                    int i9 = iA2;
                    layoutParams2.leftMargin = i9;
                    layoutParams2.rightMargin = i9;
                    if (i8 == 0) {
                        layoutParams2.topMargin = i9;
                    }
                    if (i8 == childCount - 1) {
                        layoutParams2.bottomMargin = i9;
                    }
                    if (childAt.getId() == R.id.inter_btn_cta_layout) {
                        layoutParams2.topMargin = iA3;
                    }
                    childAt.setLayoutParams(layoutParams2);
                }
                q.this.I.setCornerRadius(iA2);
                ViewGroup.LayoutParams layoutParams3 = q.this.J.getLayoutParams();
                int i10 = iA4;
                layoutParams3.width = i10;
                layoutParams3.height = i10;
                q.this.J.setLayoutParams(layoutParams3);
                q qVar = q.this;
                qVar.f14449o.a(qVar.K);
                q qVar2 = q.this;
                qVar2.f14449o.a(qVar2.L);
                q.this.K.setTextColor(sg.bigo.ads.ad.interstitial.d.f14442b);
                q.this.L.setTextColor(sg.bigo.ads.ad.interstitial.d.f14442b);
                q.this.M.setVisibility(0);
            }
        }, ((long) iMax) * 1000);
    }

    public static /* synthetic */ boolean b(q qVar) {
        qVar.P = true;
        return true;
    }

    @Override // sg.bigo.ads.ad.interstitial.d.m, sg.bigo.ads.ad.interstitial.d.a
    public final void a(double d8) {
        Button button;
        int i2;
        super.a(d8);
        if (this.P) {
            return;
        }
        if (d8 <= 3.0d) {
            button = this.O;
            if (button == null) {
                return;
            } else {
                i2 = 857743652;
            }
        } else {
            button = this.O;
            if (button == null) {
                return;
            } else {
                i2 = 872415231;
            }
        }
        button.setBackgroundColor(i2);
    }

    @Override // sg.bigo.ads.ad.interstitial.d.m
    public final void a(sg.bigo.ads.ad.interstitial.r rVar) {
        Bitmap bitmapA;
        super.a(rVar);
        if (C()) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) ((m) this).y.getLayoutParams();
            marginLayoutParams.topMargin = 0;
            marginLayoutParams.bottomMargin = 0;
            marginLayoutParams.height = sg.bigo.ads.common.utils.e.a(this.f14450q.getContext(), 24);
            ((m) this).y.setLayoutParams(marginLayoutParams);
            ((m) this).y.setVisibility(4);
        }
        RoundedFrameLayout roundedFrameLayout = (RoundedFrameLayout) this.f14450q.findViewById(R.id.inter_media_ad_card_layout);
        this.G = roundedFrameLayout;
        this.H = (LinearLayout) roundedFrameLayout.findViewById(R.id.inter_media_ad_card_info_container);
        this.I = (RoundedFrameLayout) this.G.findViewById(R.id.inter_rounded_icon_layout);
        this.J = (ImageView) this.G.findViewById(R.id.inter_icon);
        this.K = (TextView) this.G.findViewById(R.id.inter_title);
        this.L = (TextView) this.G.findViewById(R.id.inter_description);
        this.N = (RoundedFrameLayout) this.f14450q.findViewById(R.id.inter_btn_cta_layout);
        this.O = (Button) this.G.findViewById(R.id.inter_btn_cta);
        this.M = (ImageView) this.G.findViewById(R.id.inter_star);
        RoundedFrameLayout roundedFrameLayout2 = this.G;
        roundedFrameLayout2.a(roundedFrameLayout2.getCornerRadiusTopLeft(), this.G.getCornerRadiusTopRight(), this.N.getCornerRadiusBottomLeft(), this.N.getCornerRadiusBottomRight());
        ImageView imageView = this.M;
        if (imageView != null && (bitmapA = sg.bigo.ads.ad.interstitial.s.a(imageView.getContext(), ((sg.bigo.ads.ad.interstitial.u) this).f15138c, this.f14454u, sg.bigo.ads.ad.interstitial.g.BLACK)) != null) {
            this.M.setImageBitmap(bitmapA);
        }
        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.f14455v.getLayoutParams();
        marginLayoutParams2.topMargin = sg.bigo.ads.common.utils.e.a(this.f14455v.getContext(), 0);
        this.f14455v.setLayoutParams(marginLayoutParams2);
        this.f14449o.b(this.K);
        this.f14449o.b(this.L);
        this.f14449o.b(this.f14455v);
    }
}
