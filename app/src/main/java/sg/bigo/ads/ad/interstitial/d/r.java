package sg.bigo.ads.ad.interstitial.d;

import android.transition.ChangeBounds;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import java.util.Collection;
import java.util.List;
import sg.bigo.ads.R;
import sg.bigo.ads.ad.interstitial.d.a;
import sg.bigo.ads.ad.interstitial.multi_img.view.IconListView;
import sg.bigo.ads.common.view.RoundedFrameLayout;
import sg.bigo.ads.common.w.b;

/* JADX INFO: loaded from: classes6.dex */
public final class r extends m {
    private RoundedFrameLayout G;
    private LinearLayout H;
    private LinearLayout I;
    private RoundedFrameLayout J;
    private ImageView K;
    private TextView L;
    private TextView M;
    private TextView N;
    private IconListView O;
    private RoundedFrameLayout P;
    private Button Q;
    private boolean R;

    public r(@NonNull sg.bigo.ads.ad.b.c cVar) {
        super(cVar);
        this.R = false;
    }

    @Override // sg.bigo.ads.ad.interstitial.d.m
    public final void J() {
        super.J();
        if (this.f14452s.h) {
            sg.bigo.ads.ad.b.a.a(this.G, 18);
            sg.bigo.ads.ad.b.a.a(this.f14450q, this.G, 8, ((sg.bigo.ads.ad.interstitial.u) this).f15138c, this.f14452s.f15199i);
        } else {
            sg.bigo.ads.ad.b.a.a(this.f14450q, this.G, 8, sg.bigo.ads.ad.interstitial.r.F, 0);
        }
        IconListView iconListView = this.O;
        if (iconListView != null) {
            List<IconListView.a> items = iconListView.getItems();
            for (int i2 = 0; items != null && i2 < items.size(); i2++) {
                IconListView.a aVar = items.get(i2);
                sg.bigo.ads.ad.b.a.a(aVar.f14881d, 26);
                sg.bigo.ads.ad.b.a.a(this.f14450q, aVar.f14881d, 8, ((sg.bigo.ads.ad.interstitial.u) this).f15138c, this.f14452s.f15199i);
                sg.bigo.ads.ad.b.a.a(aVar.g, 26);
                sg.bigo.ads.ad.b.a.a(this.f14450q, aVar.g, 8, ((sg.bigo.ads.ad.interstitial.u) this).f15138c, this.f14452s.f15199i);
            }
        }
    }

    @Override // sg.bigo.ads.ad.interstitial.d.m
    public final void b(int i2) {
        super.b(i2);
        final int iA = sg.bigo.ads.common.utils.e.a(this.f14450q.getContext(), 16);
        final int iA2 = sg.bigo.ads.common.utils.e.a(this.f14450q.getContext(), 40);
        final int iA3 = sg.bigo.ads.common.utils.e.a(this.f14450q.getContext(), 72);
        final boolean zV = v();
        if (this.f14454u != null) {
            final boolean[] zArr = {false, false};
            this.f14450q.postDelayed(new Runnable() { // from class: sg.bigo.ads.ad.interstitial.d.r.1
                @Override // java.lang.Runnable
                public final void run() {
                    if (sg.bigo.ads.ad.c.a((sg.bigo.ads.ad.c) ((sg.bigo.ads.ad.interstitial.u) r.this).f15138c)) {
                        return;
                    }
                    r.b(r.this);
                    final a.C0259a c0259aU = r.this.u();
                    TransitionSet transitionSet = new TransitionSet();
                    transitionSet.addTransition(new ChangeBounds());
                    transitionSet.addListener((Transition.TransitionListener) new sg.bigo.ads.common.h() { // from class: sg.bigo.ads.ad.interstitial.d.r.1.1
                        @Override // sg.bigo.ads.common.h, android.transition.Transition.TransitionListener
                        public final void onTransitionEnd(Transition transition) {
                            r.this.H();
                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                            zArr[0] = true;
                            RoundedFrameLayout roundedFrameLayout = r.this.P;
                            AnonymousClass1 anonymousClass12 = AnonymousClass1.this;
                            boolean[] zArr2 = zArr;
                            sg.bigo.ads.ad.interstitial.multi_img.e.a(roundedFrameLayout, zArr2[0], zArr2[1], zV);
                            if (c0259aU.f14480b) {
                                r rVar = r.this;
                                rVar.a(rVar.Q, new b.a());
                            }
                        }

                        @Override // sg.bigo.ads.common.h, android.transition.Transition.TransitionListener
                        public final void onTransitionStart(final Transition transition) {
                            r.this.G();
                            sg.bigo.ads.common.w.b.a(r.this.H, -1, new b.a() { // from class: sg.bigo.ads.ad.interstitial.d.r.1.1.1
                                @Override // sg.bigo.ads.common.w.b.a
                                public final long a() {
                                    return transition.getDuration();
                                }
                            });
                            RoundedFrameLayout roundedFrameLayout = r.this.P;
                            Button button = r.this.Q;
                            int i8 = c0259aU.f14479a;
                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                            sg.bigo.ads.ad.interstitial.multi_img.e.a(roundedFrameLayout, button, i8, zArr, zV, transition.getDuration());
                        }
                    });
                    TransitionManager.beginDelayedTransition(r.this.f14451r, transitionSet);
                    r.this.G.setCornerRadius(iA);
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) r.this.I.getLayoutParams();
                    int i8 = iA;
                    marginLayoutParams.setMargins(i8, i8, i8, 0);
                    r.this.I.setLayoutParams(marginLayoutParams);
                    r.this.J.setCornerRadius(iA);
                    ViewGroup.LayoutParams layoutParams = r.this.K.getLayoutParams();
                    int i9 = iA3;
                    layoutParams.width = i9;
                    layoutParams.height = i9;
                    r.this.K.setLayoutParams(layoutParams);
                    r.this.M.setVisibility(0);
                    r.this.M.setTextColor(c0259aU.f14479a);
                    r.this.N.setTextSize(2, 12.0f);
                    ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) r.this.N.getLayoutParams();
                    marginLayoutParams2.topMargin = sg.bigo.ads.common.utils.e.a(r.this.f14450q.getContext(), 4);
                    r.this.N.setLayoutParams(marginLayoutParams2);
                    ViewGroup.MarginLayoutParams marginLayoutParams3 = (ViewGroup.MarginLayoutParams) r.this.O.getLayoutParams();
                    marginLayoutParams3.topMargin = iA;
                    r.this.O.setLayoutParams(marginLayoutParams3);
                    if (sg.bigo.ads.common.utils.k.a((Collection) r.this.O.getItems())) {
                        r.this.O.setVisibility(8);
                    } else {
                        r.this.O.setVisibility(0);
                    }
                    r.this.I.removeView(r.this.P);
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, iA2);
                    int i10 = iA;
                    layoutParams2.setMargins(i10, i10, i10, i10);
                    r.this.H.addView(r.this.P, layoutParams2);
                    r rVar = r.this;
                    rVar.f14449o.a(rVar.L);
                    r rVar2 = r.this;
                    rVar2.f14449o.a(rVar2.N);
                    r.this.L.setTextColor(sg.bigo.ads.ad.interstitial.d.f14442b);
                    r.this.N.setTextColor(sg.bigo.ads.ad.interstitial.d.f14442b);
                }
            }, ((long) Math.max(1, i2)) * 1000);
        } else {
            RoundedFrameLayout roundedFrameLayout = this.P;
            if (roundedFrameLayout == null || !zV) {
                return;
            }
            sg.bigo.ads.ad.interstitial.c.e(roundedFrameLayout);
        }
    }

    public static /* synthetic */ boolean b(r rVar) {
        rVar.R = true;
        return true;
    }

    @Override // sg.bigo.ads.ad.interstitial.d.m, sg.bigo.ads.ad.interstitial.d.a
    public final void a(double d8) {
        Button button;
        int i2;
        super.a(d8);
        if (this.R) {
            return;
        }
        if (d8 <= 3.0d) {
            button = this.Q;
            if (button == null) {
                return;
            } else {
                i2 = 857743652;
            }
        } else {
            button = this.Q;
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
        this.H = (LinearLayout) roundedFrameLayout.findViewById(R.id.inter_media_ad_card_container);
        this.I = (LinearLayout) this.G.findViewById(R.id.inter_media_ad_card_top_layout);
        this.J = (RoundedFrameLayout) this.G.findViewById(R.id.inter_rounded_icon_layout);
        this.K = (ImageView) this.G.findViewById(R.id.inter_icon);
        this.L = (TextView) this.G.findViewById(R.id.inter_title);
        this.M = (TextView) this.G.findViewById(R.id.inter_company);
        this.N = (TextView) this.G.findViewById(R.id.inter_description);
        this.P = (RoundedFrameLayout) this.G.findViewById(R.id.inter_btn_cta_layout);
        this.Q = (Button) this.G.findViewById(R.id.inter_btn_cta);
        RoundedFrameLayout roundedFrameLayout2 = this.G;
        roundedFrameLayout2.a(roundedFrameLayout2.getCornerRadiusTopLeft(), this.P.getCornerRadiusTopRight(), this.G.getCornerRadiusBottomLeft(), this.P.getCornerRadiusBottomRight());
        IconListView iconListView = (IconListView) this.G.findViewById(R.id.inter_download_msg);
        this.O = iconListView;
        iconListView.a(this.f14454u);
        this.O.setVisibility(8);
        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.f14455v.getLayoutParams();
        marginLayoutParams2.topMargin = sg.bigo.ads.common.utils.e.a(this.f14455v.getContext(), 0);
        this.f14455v.setLayoutParams(marginLayoutParams2);
        this.f14449o.b(this.L);
        this.f14449o.b(this.N);
        this.f14449o.b(this.f14455v);
    }
}
