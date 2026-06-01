package sg.bigo.ads.ad.interstitial.e;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import sg.bigo.ads.R;
import sg.bigo.ads.api.NativeAd;
import sg.bigo.ads.common.view.RealtimeBlurLinearLayout;
import sg.bigo.ads.common.view.ViewFlow;

/* JADX INFO: loaded from: classes6.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final RealtimeBlurLinearLayout f14626a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final ViewFlow f14627b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final int f14628c;

    private a(RealtimeBlurLinearLayout realtimeBlurLinearLayout, int i2) {
        this.f14626a = realtimeBlurLinearLayout;
        this.f14627b = (ViewFlow) realtimeBlurLinearLayout.findViewById(R.id.inter_icon_ads_view_flow);
        this.f14628c = i2;
    }

    @NonNull
    public static a a(Context context, @NonNull sg.bigo.ads.ad.interstitial.e.a.b bVar, @NonNull List<NativeAd> list, List<NativeAd> list2) {
        int iA;
        boolean z2;
        d eVar;
        a aVar = new a((RealtimeBlurLinearLayout) sg.bigo.ads.common.utils.a.a(context, R.layout.bigo_ad_layout_interstitial_icon_view_flow, null, false), (int) bVar.k());
        aVar.f14627b.setViewStyle(3);
        aVar.f14627b.setDividerWidth(0);
        if (!bVar.a()) {
            switch (bVar.e()) {
                case 1:
                case 3:
                    aVar.f14627b.setContentMaxWidthSpace(sg.bigo.ads.common.utils.e.a(context, 20));
                    break;
                case 2:
                case 4:
                    aVar.f14627b.setContentMaxWidthSpace(0);
                    break;
                case 5:
                case 6:
                    aVar.f14627b.setContentMaxWidthSpace(sg.bigo.ads.common.utils.e.a(context, 47));
                    ((ViewGroup.MarginLayoutParams) aVar.f14627b.getLayoutParams()).bottomMargin = 0;
                    break;
            }
        } else {
            aVar.f14627b.setContentMaxWidthSpace(0);
            ((LinearLayout.LayoutParams) aVar.f14627b.getLayoutParams()).bottomMargin = 0;
        }
        list2.clear();
        while (!sg.bigo.ads.common.utils.k.a((Collection) list)) {
            sg.bigo.ads.ad.interstitial.e.b.a aVar2 = new sg.bigo.ads.ad.interstitial.e.b.a(context);
            if (!sg.bigo.ads.common.utils.k.a((Collection) list)) {
                if (bVar.a()) {
                    z2 = false;
                    iA = 1;
                } else {
                    iA = sg.bigo.ads.ad.interstitial.e.a.b.a(bVar);
                    z2 = true;
                }
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                sg.bigo.ads.ad.interstitial.e.b.a.a(arrayList, arrayList2, list, list2, iA);
                if (iA == 1) {
                    list2.addAll(arrayList2);
                    arrayList2.clear();
                }
                if (bVar.a()) {
                    eVar = new k(aVar2, arrayList, bVar);
                } else {
                    int iE = bVar.e();
                    eVar = iE != 2 ? iE != 3 ? iE != 4 ? iE != 5 ? iE != 6 ? new e(aVar2, arrayList, bVar) : new j(aVar2, arrayList, bVar) : new i(aVar2, arrayList, bVar) : new h(aVar2, arrayList, bVar) : new g(aVar2, arrayList, bVar) : new f(aVar2, arrayList, bVar);
                }
                eVar.a(aVar, z2);
                aVar2.f14644a = eVar;
                list = arrayList2;
            }
            ViewFlow.b bVar2 = new ViewFlow.b();
            ((ViewGroup.LayoutParams) bVar2).width = -1;
            ((ViewGroup.LayoutParams) bVar2).height = -2;
            bVar2.e = 48;
            bVar2.f16161d = 3;
            aVar.f14627b.addView(aVar2, bVar2);
        }
        return aVar;
    }
}
