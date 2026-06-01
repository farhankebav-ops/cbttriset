package sg.bigo.ads.ad.interstitial.c;

import android.transition.ChangeBounds;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.util.Pair;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Collection;
import java.util.List;
import sg.bigo.ads.R;
import sg.bigo.ads.ad.interstitial.multi_img.view.IconListView;
import sg.bigo.ads.common.view.RoundedFrameLayout;
import sg.bigo.ads.common.w.b;

/* JADX INFO: loaded from: classes6.dex */
public class v extends b {
    private ImageView A;
    private TextView B;
    private TextView C;
    private TextView D;
    private IconListView E;
    private RoundedFrameLayout F;
    private Button G;
    private boolean H;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private RoundedFrameLayout f14415w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private LinearLayout f14416x;
    private LinearLayout y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private RoundedFrameLayout f14417z;

    public v(@NonNull sg.bigo.ads.ad.b.c cVar, int i2, @NonNull sg.bigo.ads.api.a.m mVar, @NonNull sg.bigo.ads.ad.interstitial.multi_img.b bVar, @Nullable sg.bigo.ads.ad.interstitial.e.c cVar2) {
        super(cVar, i2, mVar, bVar, cVar2);
        this.H = false;
    }

    @Override // sg.bigo.ads.ad.interstitial.c.b
    public final void b(double d8) {
        Button button;
        int i2;
        super.b(d8);
        if (this.H) {
            return;
        }
        if (d8 <= 3.0d) {
            button = this.G;
            if (button == null) {
                return;
            } else {
                i2 = 857743652;
            }
        } else {
            button = this.G;
            if (button == null) {
                return;
            } else {
                i2 = 872415231;
            }
        }
        button.setBackgroundColor(i2);
    }

    @Override // sg.bigo.ads.ad.interstitial.c.a
    public final int h() {
        return R.layout.bigo_ad_activity_interstitial_rich_video_end_9;
    }

    public static /* synthetic */ boolean b(v vVar) {
        vVar.H = true;
        return true;
    }

    @Override // sg.bigo.ads.ad.interstitial.c.b, sg.bigo.ads.ad.interstitial.c.a
    public final void a(int i2, boolean z2, boolean z7) {
        super.a(i2, z2, z7);
        sg.bigo.ads.api.a.m mVar = this.g;
        if (mVar == null || mVar.a("endpage.ad_component_clickable_switch") == 1) {
            sg.bigo.ads.ad.b.a.a(this.f14415w, 18);
            sg.bigo.ads.ad.b.a.a(this.j, this.f14415w, 8, this.f15176f, i2);
        } else {
            sg.bigo.ads.ad.b.a.a(this.j, this.f14415w, 8, sg.bigo.ads.ad.interstitial.r.F, 0);
        }
        IconListView iconListView = this.E;
        if (iconListView != null) {
            List<IconListView.a> items = iconListView.getItems();
            for (int i8 = 0; items != null && i8 < items.size(); i8++) {
                IconListView.a aVar = items.get(i8);
                sg.bigo.ads.ad.b.a.a(aVar.f14881d, 26);
                sg.bigo.ads.ad.b.a.a(this.j, aVar.f14881d, 8, this.f15176f, i2);
                sg.bigo.ads.ad.b.a.a(aVar.g, 26);
                sg.bigo.ads.ad.b.a.a(this.j, aVar.g, 8, this.f15176f, i2);
            }
        }
    }

    @Override // sg.bigo.ads.ad.interstitial.c.b
    public final void g(sg.bigo.ads.ad.interstitial.r rVar) {
        super.g(rVar);
        if (l()) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f14331r.getLayoutParams();
            marginLayoutParams.topMargin = 0;
            marginLayoutParams.bottomMargin = 0;
            marginLayoutParams.height = sg.bigo.ads.common.utils.e.a(this.k.getContext(), 24);
            this.f14331r.setLayoutParams(marginLayoutParams);
            this.f14331r.setVisibility(4);
        }
        RoundedFrameLayout roundedFrameLayout = (RoundedFrameLayout) this.k.findViewById(R.id.inter_media_ad_card_layout);
        this.f14415w = roundedFrameLayout;
        this.f14416x = (LinearLayout) roundedFrameLayout.findViewById(R.id.inter_media_ad_card_container);
        this.y = (LinearLayout) this.f14415w.findViewById(R.id.inter_media_ad_card_top_layout);
        this.f14417z = (RoundedFrameLayout) this.f14415w.findViewById(R.id.inter_rounded_icon_layout);
        this.A = (ImageView) this.f14415w.findViewById(R.id.inter_icon);
        this.B = (TextView) this.f14415w.findViewById(R.id.inter_title);
        this.C = (TextView) this.f14415w.findViewById(R.id.inter_company);
        this.D = (TextView) this.f14415w.findViewById(R.id.inter_description);
        this.F = (RoundedFrameLayout) this.f14415w.findViewById(R.id.inter_btn_cta_layout);
        this.G = (Button) this.f14415w.findViewById(R.id.inter_btn_cta);
        RoundedFrameLayout roundedFrameLayout2 = this.f14415w;
        roundedFrameLayout2.a(roundedFrameLayout2.getCornerRadiusTopLeft(), this.F.getCornerRadiusTopRight(), this.f14415w.getCornerRadiusBottomLeft(), this.F.getCornerRadiusBottomRight());
        IconListView iconListView = (IconListView) this.f14415w.findViewById(R.id.inter_download_msg);
        this.E = iconListView;
        iconListView.a(((a) this).f14325i);
        this.E.setVisibility(8);
        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.l.getLayoutParams();
        marginLayoutParams2.topMargin = sg.bigo.ads.common.utils.e.a(this.l.getContext(), 0);
        this.l.setLayoutParams(marginLayoutParams2);
        this.f14329o.b(this.B);
        this.f14329o.b(this.D);
        this.f14329o.b(this.l);
    }

    @Override // sg.bigo.ads.ad.interstitial.c.a
    public final void a(@NonNull sg.bigo.ads.ad.interstitial.r rVar, int i2) {
        super.a(rVar, i2);
        final int iA = sg.bigo.ads.common.utils.e.a(this.k.getContext(), 16);
        final int iA2 = sg.bigo.ads.common.utils.e.a(this.j.getContext(), 40);
        final int iA3 = sg.bigo.ads.common.utils.e.a(this.k.getContext(), 72);
        final Pair<Integer, Boolean> pairE = e(rVar);
        if (((a) this).f14325i != null) {
            final boolean[] zArr = {false, false};
            this.k.postDelayed(new Runnable() { // from class: sg.bigo.ads.ad.interstitial.c.v.1
                @Override // java.lang.Runnable
                public final void run() {
                    if (sg.bigo.ads.ad.c.a((sg.bigo.ads.ad.c) v.this.f15176f)) {
                        return;
                    }
                    v.b(v.this);
                    TransitionSet transitionSet = new TransitionSet();
                    transitionSet.addTransition(new ChangeBounds());
                    transitionSet.addListener((Transition.TransitionListener) new sg.bigo.ads.common.h() { // from class: sg.bigo.ads.ad.interstitial.c.v.1.1
                        @Override // sg.bigo.ads.common.h, android.transition.Transition.TransitionListener
                        public final void onTransitionEnd(Transition transition) {
                            v.this.n();
                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                            zArr[0] = true;
                            RoundedFrameLayout roundedFrameLayout = v.this.F;
                            AnonymousClass1 anonymousClass12 = AnonymousClass1.this;
                            boolean[] zArr2 = zArr;
                            sg.bigo.ads.ad.interstitial.multi_img.e.a(roundedFrameLayout, zArr2[0], zArr2[1], ((Boolean) pairE.second).booleanValue());
                        }

                        @Override // sg.bigo.ads.common.h, android.transition.Transition.TransitionListener
                        public final void onTransitionStart(final Transition transition) {
                            v.this.m();
                            sg.bigo.ads.common.w.b.a(v.this.f14416x, -1, new b.a() { // from class: sg.bigo.ads.ad.interstitial.c.v.1.1.1
                                @Override // sg.bigo.ads.common.w.b.a
                                public final long a() {
                                    return transition.getDuration();
                                }
                            });
                            RoundedFrameLayout roundedFrameLayout = v.this.F;
                            Button button = v.this.G;
                            int iIntValue = ((Integer) pairE.first).intValue();
                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                            sg.bigo.ads.ad.interstitial.multi_img.e.a(roundedFrameLayout, button, iIntValue, zArr, ((Boolean) pairE.second).booleanValue(), transition.getDuration());
                        }
                    });
                    TransitionManager.beginDelayedTransition(v.this.k, transitionSet);
                    v.this.f14415w.setCornerRadius(iA);
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) v.this.y.getLayoutParams();
                    int i8 = iA;
                    marginLayoutParams.setMargins(i8, i8, i8, 0);
                    v.this.y.setLayoutParams(marginLayoutParams);
                    v.this.f14417z.setCornerRadius(iA);
                    ViewGroup.LayoutParams layoutParams = v.this.A.getLayoutParams();
                    int i9 = iA3;
                    layoutParams.width = i9;
                    layoutParams.height = i9;
                    v.this.A.setLayoutParams(layoutParams);
                    v.this.C.setVisibility(0);
                    v.this.C.setTextColor(((Integer) pairE.first).intValue());
                    v.this.D.setTextSize(2, 12.0f);
                    ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) v.this.D.getLayoutParams();
                    marginLayoutParams2.topMargin = sg.bigo.ads.common.utils.e.a(v.this.j.getContext(), 4);
                    v.this.D.setLayoutParams(marginLayoutParams2);
                    ViewGroup.MarginLayoutParams marginLayoutParams3 = (ViewGroup.MarginLayoutParams) v.this.E.getLayoutParams();
                    marginLayoutParams3.topMargin = iA;
                    v.this.E.setLayoutParams(marginLayoutParams3);
                    if (sg.bigo.ads.common.utils.k.a((Collection) v.this.E.getItems())) {
                        v.this.E.setVisibility(8);
                    } else {
                        v.this.E.setVisibility(0);
                    }
                    v.this.y.removeView(v.this.F);
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, iA2);
                    int i10 = iA;
                    layoutParams2.setMargins(i10, i10, i10, i10);
                    v.this.f14416x.addView(v.this.F, layoutParams2);
                    v vVar = v.this;
                    vVar.f14329o.a(vVar.B);
                    v vVar2 = v.this;
                    vVar2.f14329o.a(vVar2.D);
                    v.this.B.setTextColor(sg.bigo.ads.ad.interstitial.d.f14442b);
                    v.this.D.setTextColor(sg.bigo.ads.ad.interstitial.d.f14442b);
                }
            }, ((long) Math.max(1, i2)) * 1000);
        } else {
            if (this.F == null || !((Boolean) pairE.second).booleanValue()) {
                return;
            }
            sg.bigo.ads.ad.interstitial.c.e(this.F);
        }
    }
}
