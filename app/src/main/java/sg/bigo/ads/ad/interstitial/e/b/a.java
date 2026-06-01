package sg.bigo.ads.ad.interstitial.e.b;

import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import sg.bigo.ads.ad.b.c;
import sg.bigo.ads.ad.interstitial.e.d;
import sg.bigo.ads.ad.interstitial.e.j;
import sg.bigo.ads.api.NativeAd;
import sg.bigo.ads.common.view.RealtimeBlurLinearLayout;

/* JADX INFO: loaded from: classes6.dex */
public final class a extends RealtimeBlurLinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public d f14644a;

    public a(@NonNull Context context) {
        this(context, (byte) 0);
    }

    public static void a(List<NativeAd> list, List<NativeAd> list2, List<NativeAd> list3, @NonNull List<NativeAd> list4, int i2) {
        if (list3 == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (NativeAd nativeAd : list3) {
            if (!(nativeAd instanceof c) || ((c) nativeAd).n()) {
                arrayList.add(nativeAd);
            } else {
                arrayList2.add(nativeAd);
            }
        }
        int size = arrayList2.size();
        int i8 = 0;
        while (i8 < size) {
            Object obj = arrayList2.get(i8);
            i8++;
            NativeAd nativeAd2 = (NativeAd) obj;
            if (list.size() < i2) {
                list.add(nativeAd2);
                list4.add(nativeAd2);
            } else {
                list2.add(nativeAd2);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext() && list.size() < i2) {
            NativeAd nativeAd3 = (NativeAd) it.next();
            list.add(nativeAd3);
            list4.add(nativeAd3);
            it.remove();
        }
        list2.addAll(arrayList);
        list4.addAll(list2);
    }

    public final d getIconAdsRenderStyle() {
        return this.f14644a;
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int i2, int i8) {
        super.onMeasure(i2, i8);
        d dVar = this.f14644a;
        if ((dVar instanceof j) && dVar.b() == 4) {
            int defaultSize = (int) ((((View.getDefaultSize(Integer.MIN_VALUE, i2) - (((j) this.f14644a).f14695i * 3.0f)) / 4.0f) * 3.0f) + (r0 * 2));
            setMeasuredDimension(defaultSize, getMeasuredHeight());
            int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(defaultSize, BasicMeasure.EXACTLY);
            int childCount = getChildCount();
            for (int i9 = 0; i9 < childCount; i9++) {
                measureChildWithMargins(getChildAt(i9), iMakeMeasureSpec, 0, i8, 0);
            }
        }
    }

    private a(@NonNull Context context, byte b8) {
        this(context, (char) 0);
    }

    private a(@NonNull Context context, char c7) {
        super(context, null, 0);
    }
}
