package sg.bigo.ads.ad.interstitial.g;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import sg.bigo.ads.R;
import sg.bigo.ads.ad.interstitial.r;
import sg.bigo.ads.api.a.m;
import sg.bigo.ads.common.p;
import sg.bigo.ads.common.utils.e;
import sg.bigo.ads.common.utils.u;
import sg.bigo.ads.common.view.RoundedImageView;

/* JADX INFO: loaded from: classes6.dex */
public class c extends a {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    protected View f14775s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    protected TextView f14776t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    protected View f14777u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    protected RoundedImageView f14778v;

    public c(@NonNull sg.bigo.ads.ad.b.c cVar, @NonNull m mVar, @NonNull p pVar) {
        super(cVar, mVar, pVar);
    }

    @Override // sg.bigo.ads.ad.interstitial.g.a
    public void a(int i2, boolean z2, boolean z7) {
        super.a(i2, z2, z7);
        sg.bigo.ads.ad.b.a.a(this.f14778v, 5);
        RoundedImageView roundedImageView = this.f14778v;
        if (roundedImageView != null) {
            if (z2) {
                sg.bigo.ads.ad.b.a.a(this.j, roundedImageView, 10, this.f15176f, i2);
            } else {
                sg.bigo.ads.ad.b.a.a(this.j, roundedImageView, 10, r.F, 0);
            }
        }
    }

    @Override // sg.bigo.ads.ad.interstitial.g.a
    public void d(@NonNull final r rVar) {
        ViewGroup viewGroup = this.k;
        if (viewGroup == null) {
            return;
        }
        this.f14775s = viewGroup.findViewById(R.id.inter_click_guide_container);
        this.f14777u = this.k.findViewById(R.id.inter_click_guide_image_layout);
        this.f14778v = (RoundedImageView) this.k.findViewById(R.id.inter_click_guide_image_background);
        this.f14778v.setCornerRadius(e.a(this.k.getContext(), 8));
        this.f14778v.setBackgroundColor(654311423);
        u.a(this.f14777u, new u.a() { // from class: sg.bigo.ads.ad.interstitial.g.c.1
            @Override // sg.bigo.ads.common.utils.u.a
            public final void a(@NonNull Rect rect) {
                c.this.a(rVar, rect);
            }
        });
        l().a(this.f14776t, null);
    }

    @Override // sg.bigo.ads.ad.interstitial.g.a
    public final void e(@NonNull r rVar) {
        super.e(rVar);
        RoundedImageView roundedImageView = this.m;
        if (roundedImageView != null) {
            roundedImageView.setCornerRadius(e.a(roundedImageView.getContext(), 8));
        }
    }

    @Override // sg.bigo.ads.ad.interstitial.g.a
    public void f(@NonNull r rVar) {
        super.f(rVar);
        l().a(this.f14756n);
    }

    @Override // sg.bigo.ads.ad.interstitial.g.a
    public final boolean g() {
        return false;
    }

    @Override // sg.bigo.ads.ad.interstitial.g.a
    public int h() {
        return R.layout.bigo_ad_view_click_guide_2;
    }

    @Override // sg.bigo.ads.ad.interstitial.g.a
    public final void k() {
        super.k();
        l().a(this.l);
    }

    @NonNull
    public sg.bigo.ads.ad.interstitial.b l() {
        return sg.bigo.ads.ad.interstitial.b.f14276d;
    }

    public void a(@NonNull r rVar, @NonNull Rect rect) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f14756n.getLayoutParams();
        layoutParams.addRule(12, 0);
        layoutParams.addRule(3, this.f14777u.getId());
        this.f14756n.requestLayout();
        p pVarB = b(rVar);
        int iA = e.a(this.f14777u.getContext(), 16);
        int iWidth = rect.width();
        int iHeight = rect.height();
        int i2 = iA * 2;
        int i8 = iWidth - i2;
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f14777u.getLayoutParams();
        layoutParams2.addRule(2, 0);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.m.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.f14778v.getLayoutParams();
        p pVarA = p.a(pVarB.f15849b, pVarB.f15850c, iWidth, iHeight - i2);
        p pVarA2 = p.a(pVarB.f15849b, pVarB.f15850c, i8, iHeight);
        if (pVarA.a(pVarA2)) {
            layoutParams2.width = pVarA.f15849b;
            layoutParams2.height = pVarA.f15850c + i2;
            marginLayoutParams.topMargin = iA;
            marginLayoutParams.bottomMargin = iA;
            marginLayoutParams2.leftMargin = iA;
            marginLayoutParams2.rightMargin = iA;
        } else {
            layoutParams2.width = pVarA2.f15849b + i2;
            layoutParams2.height = pVarA2.f15850c;
            marginLayoutParams.leftMargin = iA;
            marginLayoutParams.rightMargin = iA;
            marginLayoutParams2.topMargin = iA;
            marginLayoutParams2.bottomMargin = iA;
        }
        this.m.requestLayout();
        this.f14778v.requestLayout();
        this.f14777u.requestLayout();
    }

    @Override // sg.bigo.ads.ad.interstitial.v
    public final boolean d() {
        sg.bigo.ads.core.a.a aVar;
        sg.bigo.ads.ad.b.c cVar = this.f15176f;
        if (cVar == null || (aVar = (sg.bigo.ads.core.a.a) cVar.f()) == null) {
            return true;
        }
        return aVar.aR();
    }
}
