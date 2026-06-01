package sg.bigo.ads.ad.interstitial.e;

import android.graphics.Rect;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import sg.bigo.ads.R;
import sg.bigo.ads.api.NativeAd;

/* JADX INFO: loaded from: classes6.dex */
public final class i extends d {
    public i(@NonNull sg.bigo.ads.ad.interstitial.e.b.a aVar, @NonNull List<NativeAd> list, @NonNull sg.bigo.ads.ad.interstitial.e.a.b bVar) {
        super(aVar, list, bVar);
        this.f14693f = true;
    }

    @Override // sg.bigo.ads.ad.interstitial.e.d
    @Nullable
    public final List<View> a(@NonNull a aVar) {
        int size = this.f14690b.size();
        if (size == 0) {
            return new ArrayList();
        }
        if (size == 1) {
            View viewA = sg.bigo.ads.common.utils.a.a(this.f14692d, R.layout.bigo_ad_layout_interstitial_icon_item_cta_des_style2, this.f14689a, false);
            c();
            this.f14689a.setOrientation(0);
            ArrayList arrayList = new ArrayList();
            arrayList.add(viewA);
            a(12, 0, 12, 12);
            this.f14689a.addView(viewA, new LinearLayout.LayoutParams(-1, sg.bigo.ads.common.utils.e.a(this.f14692d, 60)));
            return arrayList;
        }
        if (size == 2) {
            View viewA2 = sg.bigo.ads.common.utils.a.a(this.f14692d, R.layout.bigo_ad_layout_interstitial_icon_item_cta_des_style2, this.f14689a, false);
            View viewA3 = sg.bigo.ads.common.utils.a.a(this.f14692d, R.layout.bigo_ad_layout_interstitial_icon_item_cta_des_style2, this.f14689a, false);
            this.f14689a.setOrientation(1);
            ArrayList arrayList2 = new ArrayList();
            int iA = sg.bigo.ads.common.utils.e.a(this.f14692d, 60);
            LinearLayout linearLayout = new LinearLayout(this.f14692d);
            linearLayout.setOrientation(0);
            a(linearLayout);
            b(linearLayout);
            this.f14689a.addView(linearLayout, new LinearLayout.LayoutParams(-1, -2));
            linearLayout.addView(viewA2, new LinearLayout.LayoutParams(-1, iA));
            arrayList2.add(linearLayout);
            LinearLayout linearLayout2 = new LinearLayout(this.f14692d);
            linearLayout2.setOrientation(0);
            a(linearLayout2);
            b(linearLayout2);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.topMargin = sg.bigo.ads.common.utils.e.a(this.f14692d, 8);
            this.f14689a.addView(linearLayout2, layoutParams);
            linearLayout2.addView(viewA3, new LinearLayout.LayoutParams(-1, iA));
            arrayList2.add(linearLayout2);
            return arrayList2;
        }
        View viewA4 = sg.bigo.ads.common.utils.a.a(this.f14692d, R.layout.bigo_ad_layout_interstitial_icon_item_cta_des_style2, this.f14689a, false);
        View viewA5 = sg.bigo.ads.common.utils.a.a(this.f14692d, R.layout.bigo_ad_layout_interstitial_icon_item_cta_des_style2, this.f14689a, false);
        View viewA6 = sg.bigo.ads.common.utils.a.a(this.f14692d, R.layout.bigo_ad_layout_interstitial_icon_item_cta_des_style2, this.f14689a, false);
        this.f14689a.setOrientation(1);
        ArrayList arrayList3 = new ArrayList();
        int iA2 = sg.bigo.ads.common.utils.e.a(this.f14692d, 60);
        LinearLayout linearLayout3 = new LinearLayout(this.f14692d);
        linearLayout3.setOrientation(0);
        a(linearLayout3);
        b(linearLayout3);
        this.f14689a.addView(linearLayout3, new LinearLayout.LayoutParams(-1, -2));
        linearLayout3.addView(viewA4, new LinearLayout.LayoutParams(-1, iA2));
        arrayList3.add(linearLayout3);
        LinearLayout linearLayout4 = new LinearLayout(this.f14692d);
        linearLayout4.setOrientation(0);
        a(linearLayout4);
        b(linearLayout4);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.topMargin = sg.bigo.ads.common.utils.e.a(this.f14692d, 8);
        layoutParams2.bottomMargin = sg.bigo.ads.common.utils.e.a(this.f14692d, 8);
        this.f14689a.addView(linearLayout4, layoutParams2);
        linearLayout4.addView(viewA5, new LinearLayout.LayoutParams(-1, iA2));
        arrayList3.add(linearLayout4);
        LinearLayout linearLayout5 = new LinearLayout(this.f14692d);
        linearLayout5.setOrientation(0);
        a(linearLayout5);
        b(linearLayout5);
        this.f14689a.addView(linearLayout5, new LinearLayout.LayoutParams(-1, -2));
        linearLayout5.addView(viewA6, new LinearLayout.LayoutParams(-1, iA2));
        arrayList3.add(linearLayout5);
        return arrayList3;
    }

    @Override // sg.bigo.ads.ad.interstitial.e.d
    public final b a() {
        float fA = sg.bigo.ads.common.utils.e.a(this.f14692d, 8);
        return new b(fA, fA, fA, fA, new Rect(0, sg.bigo.ads.common.utils.e.a(this.f14692d, 10), 0, 0), this.h, null, this.g);
    }
}
