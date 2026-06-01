package sg.bigo.ads.ad.interstitial.c;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Collection;
import java.util.List;
import sg.bigo.ads.R;
import sg.bigo.ads.ad.interstitial.multi_img.view.IconListView;
import sg.bigo.ads.common.view.RoundedImageView;

/* JADX INFO: loaded from: classes6.dex */
public class l extends k {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private TextView f14392v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private TextView f14393w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private IconListView f14394x;

    public l(@NonNull sg.bigo.ads.ad.b.c cVar, int i2, @NonNull sg.bigo.ads.api.a.m mVar, @Nullable sg.bigo.ads.ad.interstitial.e.c cVar2) {
        super(cVar, i2, mVar, cVar2);
    }

    @Override // sg.bigo.ads.ad.interstitial.c.k
    public final void a(int i2) {
        super.a(i2);
        sg.bigo.ads.ad.interstitial.b.f14273a.a(this.f14387u);
        ViewGroup viewGroup = this.k;
        if (viewGroup != null) {
            TextView textView = (TextView) viewGroup.findViewById(R.id.inter_company);
            this.f14392v = textView;
            if (textView != null) {
                textView.setTextColor(i2);
            }
        }
    }

    @Override // sg.bigo.ads.ad.interstitial.c.k, sg.bigo.ads.ad.interstitial.c.a
    public final void d(sg.bigo.ads.ad.interstitial.r rVar) {
        IconListView iconListView;
        int i2;
        super.d(rVar);
        ViewGroup viewGroup = this.k;
        if (viewGroup == null) {
            return;
        }
        TextView textView = (TextView) viewGroup.findViewById(R.id.inter_description);
        this.f14393w = textView;
        sg.bigo.ads.ad.interstitial.b bVar = sg.bigo.ads.ad.interstitial.b.f14273a;
        bVar.a(null, textView);
        IconListView iconListView2 = (IconListView) this.k.findViewById(R.id.inter_download_msg);
        this.f14394x = iconListView2;
        iconListView2.a(((a) this).f14325i);
        if (sg.bigo.ads.common.utils.k.a((Collection) this.f14394x.getItems())) {
            iconListView = this.f14394x;
            i2 = 8;
        } else {
            iconListView = this.f14394x;
            i2 = 0;
        }
        iconListView.setVisibility(i2);
        int iA = sg.bigo.ads.common.utils.e.a(this.k.getContext(), 16);
        View view = this.f14382o;
        if (view != null) {
            float f4 = iA;
            view.setBackground(sg.bigo.ads.common.utils.d.a(f4, f4, f4, f4, (Rect) null, -1));
            bVar.b(this.f14382o);
        }
        a(rVar, this.f14386t);
    }

    @Override // sg.bigo.ads.ad.interstitial.c.k, sg.bigo.ads.ad.interstitial.c.a
    public final int h() {
        return R.layout.bigo_ad_activity_interstitial_rich_video_end_19;
    }

    @Override // sg.bigo.ads.ad.interstitial.c.k
    @NonNull
    public final sg.bigo.ads.ad.interstitial.b l() {
        return sg.bigo.ads.ad.interstitial.b.f14273a;
    }

    @Override // sg.bigo.ads.ad.interstitial.c.k, sg.bigo.ads.ad.interstitial.c.a
    public final void a(int i2, boolean z2, boolean z7) {
        sg.bigo.ads.ad.b.a.a(this.f14385s, 5);
        sg.bigo.ads.ad.b.a.a(this.f14386t, 5);
        if (z2) {
            sg.bigo.ads.ad.b.a.a(this.j, this.f14385s, 4, this.f15176f, i2);
            sg.bigo.ads.ad.b.a.a(this.j, this.f14386t, 4, this.f15176f, i2);
        } else {
            ViewGroup viewGroup = this.j;
            RoundedImageView roundedImageView = this.f14385s;
            sg.bigo.ads.core.adview.h hVar = sg.bigo.ads.ad.interstitial.r.F;
            sg.bigo.ads.ad.b.a.a(viewGroup, roundedImageView, 4, hVar, 0);
            sg.bigo.ads.ad.b.a.a(this.j, this.f14386t, 4, hVar, 0);
        }
        sg.bigo.ads.ad.b.a.a(this.k, 9);
        ViewGroup viewGroup2 = this.j;
        if (z7) {
            sg.bigo.ads.ad.b.a.a(viewGroup2, this.k, 4, this.f15176f, i2);
        } else {
            sg.bigo.ads.ad.b.a.a(viewGroup2, this.k, 4, sg.bigo.ads.ad.interstitial.r.F, 0);
        }
        sg.bigo.ads.api.a.m mVar = this.g;
        boolean z8 = true;
        if (mVar != null && mVar.a("endpage.ad_component_clickable_switch") != 1) {
            z8 = false;
        }
        View view = this.f14382o;
        if (view != null) {
            sg.bigo.ads.ad.b.a.a(view, 18);
            ViewGroup viewGroup3 = this.j;
            if (z8) {
                sg.bigo.ads.ad.b.a.a(viewGroup3, this.f14382o, 8, this.f15176f, i2);
            } else {
                sg.bigo.ads.ad.b.a.a(viewGroup3, this.f14382o, 8, sg.bigo.ads.ad.interstitial.r.F, 0);
            }
        }
        IconListView iconListView = this.f14394x;
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

    @Override // sg.bigo.ads.ad.interstitial.c.k
    public final void a(sg.bigo.ads.ad.interstitial.r rVar, @NonNull Rect rect) {
        sg.bigo.ads.common.p pVarB = b(rVar);
        int iA = sg.bigo.ads.common.utils.e.a(this.f14384r.getContext(), 16);
        int iWidth = rect.width();
        int iHeight = rect.height();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f14384r.getLayoutParams();
        int i2 = sg.bigo.ads.common.p.b(pVarB.f15849b, pVarB.f15850c, iWidth).f15850c;
        if (i2 <= iHeight) {
            layoutParams.height = i2;
        } else {
            int i8 = iA * 2;
            layoutParams.height = sg.bigo.ads.common.p.a(pVarB.f15849b, pVarB.f15850c, iWidth - i8, iHeight - i8).f15850c + i8;
            ((ViewGroup.MarginLayoutParams) this.f14385s.getLayoutParams()).setMargins(iA, iA, iA, iA);
            this.f14385s.requestLayout();
        }
        this.f14384r.requestLayout();
    }
}
