package sg.bigo.ads.ad.interstitial.c;

import android.graphics.Bitmap;
import android.transition.ChangeBounds;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import sg.bigo.ads.R;
import sg.bigo.ads.common.view.RoundedFrameLayout;
import sg.bigo.ads.common.w.b;

/* JADX INFO: loaded from: classes6.dex */
public class u extends b {
    private TextView A;
    private TextView B;
    private ImageView C;
    private RoundedFrameLayout D;
    private Button E;
    private boolean F;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private RoundedFrameLayout f14404w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private LinearLayout f14405x;
    private RoundedFrameLayout y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private ImageView f14406z;

    public u(@NonNull sg.bigo.ads.ad.b.c cVar, int i2, @NonNull sg.bigo.ads.api.a.m mVar, @NonNull sg.bigo.ads.ad.interstitial.multi_img.b bVar, @Nullable sg.bigo.ads.ad.interstitial.e.c cVar2) {
        super(cVar, i2, mVar, bVar, cVar2);
        this.F = false;
    }

    @Override // sg.bigo.ads.ad.interstitial.c.b
    public final void b(double d8) {
        Button button;
        int i2;
        super.b(d8);
        if (this.F) {
            return;
        }
        if (d8 <= 3.0d) {
            button = this.E;
            if (button == null) {
                return;
            } else {
                i2 = 857743652;
            }
        } else {
            button = this.E;
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
        return R.layout.bigo_ad_activity_interstitial_rich_video_end_8;
    }

    public static /* synthetic */ boolean b(u uVar) {
        uVar.F = true;
        return true;
    }

    @Override // sg.bigo.ads.ad.interstitial.c.b, sg.bigo.ads.ad.interstitial.c.a
    public final void a(int i2, boolean z2, boolean z7) {
        super.a(i2, z2, z7);
        sg.bigo.ads.api.a.m mVar = this.g;
        boolean z8 = true;
        if (mVar != null && mVar.a("endpage.ad_component_clickable_switch") != 1) {
            z8 = false;
        }
        sg.bigo.ads.ad.b.a.a(this.f14404w, 18);
        if (z8) {
            sg.bigo.ads.ad.b.a.a(this.j, this.f14404w, 8, this.f15176f, i2);
        } else {
            sg.bigo.ads.ad.b.a.a(this.j, this.f14404w, 8, sg.bigo.ads.ad.interstitial.r.F, 0);
        }
    }

    @Override // sg.bigo.ads.ad.interstitial.c.b
    public final void g(sg.bigo.ads.ad.interstitial.r rVar) {
        Bitmap bitmapA;
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
        this.f14404w = roundedFrameLayout;
        this.f14405x = (LinearLayout) roundedFrameLayout.findViewById(R.id.inter_media_ad_card_info_container);
        this.y = (RoundedFrameLayout) this.f14404w.findViewById(R.id.inter_rounded_icon_layout);
        this.f14406z = (ImageView) this.f14404w.findViewById(R.id.inter_icon);
        this.A = (TextView) this.f14404w.findViewById(R.id.inter_title);
        this.B = (TextView) this.f14404w.findViewById(R.id.inter_description);
        this.D = (RoundedFrameLayout) this.k.findViewById(R.id.inter_btn_cta_layout);
        this.E = (Button) this.f14404w.findViewById(R.id.inter_btn_cta);
        this.C = (ImageView) this.f14404w.findViewById(R.id.inter_star);
        RoundedFrameLayout roundedFrameLayout2 = this.f14404w;
        roundedFrameLayout2.a(roundedFrameLayout2.getCornerRadiusTopLeft(), this.f14404w.getCornerRadiusTopRight(), this.D.getCornerRadiusBottomLeft(), this.D.getCornerRadiusBottomRight());
        ImageView imageView = this.C;
        if (imageView != null && (bitmapA = sg.bigo.ads.ad.interstitial.s.a(imageView.getContext(), this.f15176f, ((a) this).f14325i, sg.bigo.ads.ad.interstitial.g.BLACK)) != null) {
            this.C.setImageBitmap(bitmapA);
        }
        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.l.getLayoutParams();
        marginLayoutParams2.topMargin = sg.bigo.ads.common.utils.e.a(this.l.getContext(), 0);
        this.l.setLayoutParams(marginLayoutParams2);
        this.f14329o.b(this.A);
        this.f14329o.b(this.B);
        this.f14329o.b(this.l);
    }

    @Override // sg.bigo.ads.ad.interstitial.c.a
    public final void a(@NonNull sg.bigo.ads.ad.interstitial.r rVar, int i2) {
        super.a(rVar, i2);
        final int iA = sg.bigo.ads.common.utils.e.a(this.k.getContext(), 12);
        final int iA2 = sg.bigo.ads.common.utils.e.a(this.k.getContext(), 16);
        final int iA3 = sg.bigo.ads.common.utils.e.a(this.k.getContext(), 20);
        final int iA4 = sg.bigo.ads.common.utils.e.a(this.k.getContext(), 72);
        int iMax = Math.max(1, i2);
        final boolean[] zArr = {false, false};
        final Pair<Integer, Boolean> pairE = e(rVar);
        this.k.postDelayed(new Runnable() { // from class: sg.bigo.ads.ad.interstitial.c.u.1
            @Override // java.lang.Runnable
            public final void run() {
                if (sg.bigo.ads.ad.c.a((sg.bigo.ads.ad.c) u.this.f15176f)) {
                    return;
                }
                u.b(u.this);
                TransitionSet transitionSet = new TransitionSet();
                transitionSet.addTransition(new ChangeBounds());
                transitionSet.addListener((Transition.TransitionListener) new sg.bigo.ads.common.h() { // from class: sg.bigo.ads.ad.interstitial.c.u.1.1
                    @Override // sg.bigo.ads.common.h, android.transition.Transition.TransitionListener
                    public final void onTransitionEnd(Transition transition) {
                        u.this.n();
                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                        zArr[0] = true;
                        RoundedFrameLayout roundedFrameLayout = u.this.D;
                        AnonymousClass1 anonymousClass12 = AnonymousClass1.this;
                        boolean[] zArr2 = zArr;
                        sg.bigo.ads.ad.interstitial.multi_img.e.a(roundedFrameLayout, zArr2[0], zArr2[1], ((Boolean) pairE.second).booleanValue());
                    }

                    @Override // sg.bigo.ads.common.h, android.transition.Transition.TransitionListener
                    public final void onTransitionStart(final Transition transition) {
                        u.this.m();
                        sg.bigo.ads.common.w.b.a(u.this.f14405x, -1, new b.a() { // from class: sg.bigo.ads.ad.interstitial.c.u.1.1.1
                            @Override // sg.bigo.ads.common.w.b.a
                            public final long a() {
                                return transition.getDuration();
                            }
                        });
                        RoundedFrameLayout roundedFrameLayout = u.this.D;
                        Button button = u.this.E;
                        int iIntValue = ((Integer) pairE.first).intValue();
                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                        sg.bigo.ads.ad.interstitial.multi_img.e.a(roundedFrameLayout, button, iIntValue, zArr, ((Boolean) pairE.second).booleanValue(), transition.getDuration());
                    }
                });
                TransitionManager.beginDelayedTransition(u.this.k, transitionSet);
                u.this.f14404w.setCornerRadius(iA);
                if (u.this.l()) {
                    ViewGroup.LayoutParams layoutParams = u.this.f14331r.getLayoutParams();
                    layoutParams.height = iA2;
                    u.this.f14331r.setLayoutParams(layoutParams);
                }
                int childCount = u.this.f14405x.getChildCount();
                for (int i8 = 0; i8 < childCount; i8++) {
                    View childAt = u.this.f14405x.getChildAt(i8);
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
                u.this.y.setCornerRadius(iA2);
                ViewGroup.LayoutParams layoutParams3 = u.this.f14406z.getLayoutParams();
                int i10 = iA4;
                layoutParams3.width = i10;
                layoutParams3.height = i10;
                u.this.f14406z.setLayoutParams(layoutParams3);
                u uVar = u.this;
                uVar.f14329o.a(uVar.A);
                u uVar2 = u.this;
                uVar2.f14329o.a(uVar2.B);
                u.this.A.setTextColor(sg.bigo.ads.ad.interstitial.d.f14442b);
                u.this.B.setTextColor(sg.bigo.ads.ad.interstitial.d.f14442b);
                u.this.C.setVisibility(0);
            }
        }, ((long) iMax) * 1000);
    }
}
