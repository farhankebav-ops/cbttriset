package sg.bigo.ads.ad.interstitial.g;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import java.util.Collection;
import java.util.List;
import sg.bigo.ads.R;
import sg.bigo.ads.ad.interstitial.multi_img.view.IconListView;
import sg.bigo.ads.ad.interstitial.r;
import sg.bigo.ads.api.a.m;
import sg.bigo.ads.common.p;
import sg.bigo.ads.common.utils.e;
import sg.bigo.ads.common.utils.k;

/* JADX INFO: loaded from: classes6.dex */
public final class d extends c {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private TextView f14781w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private TextView f14782x;
    private IconListView y;

    public d(@NonNull sg.bigo.ads.ad.b.c cVar, @NonNull m mVar, p pVar) {
        super(cVar, mVar, pVar);
    }

    @Override // sg.bigo.ads.ad.interstitial.g.c, sg.bigo.ads.ad.interstitial.g.a
    public final void a(int i2, boolean z2, boolean z7) {
        super.a(i2, z2, z7);
        m mVar = this.g;
        boolean z8 = true;
        if (mVar != null && mVar.a("layer.ad_component_clickable_switch") != 1) {
            z8 = false;
        }
        View view = this.f14775s;
        if (view != null) {
            sg.bigo.ads.ad.b.a.a(view, 18);
            ViewGroup viewGroup = this.j;
            if (z8) {
                sg.bigo.ads.ad.b.a.a(viewGroup, this.f14775s, 8, this.f15176f, i2);
            } else {
                sg.bigo.ads.ad.b.a.a(viewGroup, this.f14775s, 8, r.F, 0);
            }
        }
        IconListView iconListView = this.y;
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

    @Override // sg.bigo.ads.ad.interstitial.g.c, sg.bigo.ads.ad.interstitial.g.a
    public final void d(@NonNull r rVar) {
        IconListView iconListView;
        int i2;
        super.d(rVar);
        ViewGroup viewGroup = this.k;
        if (viewGroup == null) {
            return;
        }
        TextView textView = (TextView) viewGroup.findViewById(R.id.inter_description);
        this.f14782x = textView;
        sg.bigo.ads.ad.interstitial.b bVar = sg.bigo.ads.ad.interstitial.b.f14273a;
        bVar.a(null, textView);
        IconListView iconListView2 = (IconListView) this.k.findViewById(R.id.inter_download_msg);
        this.y = iconListView2;
        iconListView2.a(((a) this).f14755i);
        if (k.a((Collection) this.y.getItems())) {
            iconListView = this.y;
            i2 = 8;
        } else {
            iconListView = this.y;
            i2 = 0;
        }
        iconListView.setVisibility(i2);
        int iA = e.a(this.k.getContext(), 16);
        View view = this.f14775s;
        if (view != null) {
            float f4 = iA;
            view.setBackground(sg.bigo.ads.common.utils.d.a(f4, f4, f4, f4, (Rect) null, -1));
            bVar.b(this.f14775s);
        }
        a(rVar, this.f14778v);
    }

    @Override // sg.bigo.ads.ad.interstitial.g.c, sg.bigo.ads.ad.interstitial.g.a
    public final void f(@NonNull r rVar) {
        super.f(rVar);
        ViewGroup viewGroup = this.k;
        if (viewGroup != null) {
            TextView textView = (TextView) viewGroup.findViewById(R.id.inter_company);
            this.f14781w = textView;
            if (textView != null) {
                textView.setTextColor(g(rVar));
            }
        }
    }

    @Override // sg.bigo.ads.ad.interstitial.g.c, sg.bigo.ads.ad.interstitial.g.a
    public final int h() {
        return R.layout.bigo_ad_view_click_guide_3;
    }

    @Override // sg.bigo.ads.ad.interstitial.g.c
    @NonNull
    public final sg.bigo.ads.ad.interstitial.b l() {
        return sg.bigo.ads.ad.interstitial.b.f14273a;
    }

    @Override // sg.bigo.ads.ad.interstitial.g.c
    public final void a(@NonNull r rVar, @NonNull Rect rect) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.y.getLayoutParams();
        layoutParams.addRule(3, this.f14777u.getId());
        layoutParams.addRule(2, 0);
        this.y.requestLayout();
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f14756n.getLayoutParams();
        layoutParams2.addRule(12, 0);
        layoutParams2.addRule(3, (k.a((Collection) this.y.getItems()) ? this.f14777u : this.y).getId());
        this.f14756n.requestLayout();
        p pVarB = b(rVar);
        int iA = e.a(this.f14777u.getContext(), 16);
        int iWidth = rect.width();
        int iHeight = rect.height();
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.f14777u.getLayoutParams();
        layoutParams3.addRule(2, 0);
        int i2 = p.b(pVarB.f15849b, pVarB.f15850c, iWidth).f15850c;
        if (i2 <= iHeight) {
            layoutParams3.height = i2;
        } else {
            int i8 = iA * 2;
            layoutParams3.height = p.a(pVarB.f15849b, pVarB.f15850c, iWidth - i8, iHeight - i8).f15850c + i8;
            ((ViewGroup.MarginLayoutParams) this.m.getLayoutParams()).setMargins(iA, iA, iA, iA);
            this.m.requestLayout();
        }
        this.f14777u.requestLayout();
    }
}
