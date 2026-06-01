package sg.bigo.ads.ad.interstitial.e;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import sg.bigo.ads.R;
import sg.bigo.ads.ad.interstitial.e.a.b;
import sg.bigo.ads.api.AdOptionsView;
import sg.bigo.ads.api.MediaView;
import sg.bigo.ads.api.NativeAd;
import sg.bigo.ads.common.view.RoundedFrameLayout;

/* JADX INFO: loaded from: classes6.dex */
public abstract class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    protected final sg.bigo.ads.ad.interstitial.e.b.a f14689a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    protected final List<NativeAd> f14690b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    protected final sg.bigo.ads.ad.interstitial.e.a.b f14691c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    protected final Context f14692d;
    protected final b.a g;
    protected final float h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final float f14694i;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected boolean f14693f = false;

    @NonNull
    protected final b e = a();

    public d(@NonNull sg.bigo.ads.ad.interstitial.e.b.a aVar, @NonNull List<NativeAd> list, @NonNull sg.bigo.ads.ad.interstitial.e.a.b bVar) {
        this.f14689a = aVar;
        this.f14690b = list;
        this.f14691c = bVar;
        this.f14692d = aVar.getContext();
        this.g = bVar.c();
        this.h = sg.bigo.ads.common.utils.e.a(r2, 1);
        this.f14694i = sg.bigo.ads.common.utils.e.a(r2, 4);
    }

    @Nullable
    public abstract List<View> a(@NonNull a aVar);

    public abstract b a();

    public final void a(int i2, int i8, int i9, int i10) {
        this.f14689a.setPadding(sg.bigo.ads.common.utils.e.a(this.f14692d, i2), sg.bigo.ads.common.utils.e.a(this.f14692d, i8), sg.bigo.ads.common.utils.e.a(this.f14692d, i9), sg.bigo.ads.common.utils.e.a(this.f14692d, i10));
    }

    public final int b() {
        return this.f14690b.size();
    }

    public final void c() {
        a(this.f14689a, (b) null);
    }

    public final void a(@NonNull View view) {
        a(view, (b) null);
    }

    public final void b(@NonNull View view) {
        view.setPadding(sg.bigo.ads.common.utils.e.a(this.f14692d, 12), sg.bigo.ads.common.utils.e.a(this.f14692d, 0), sg.bigo.ads.common.utils.e.a(this.f14692d, 12), sg.bigo.ads.common.utils.e.a(this.f14692d, 12));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void a(@NonNull View view, @Nullable b bVar) {
        if (bVar == null) {
            bVar = this.e;
        }
        if (bVar == null || view == 0) {
            return;
        }
        Drawable drawableA = bVar.a();
        if (drawableA != null) {
            view.setBackground(drawableA);
            view.setPadding(0, 0, 0, 0);
        } else if (view instanceof sg.bigo.ads.common.view.a.c) {
            ((sg.bigo.ads.common.view.a.c) view).setBlurStyle(bVar);
        }
    }

    public void a(TextView textView) {
    }

    public final void a(@NonNull a aVar, boolean z2) {
        this.f14689a.removeAllViews();
        List<View> listA = a(aVar);
        if (sg.bigo.ads.common.utils.k.a((Collection) listA)) {
            return;
        }
        for (int i2 = 0; i2 < listA.size() && i2 < this.f14690b.size(); i2++) {
            View view = listA.get(i2);
            NativeAd nativeAd = this.f14690b.get(i2);
            if (view != null && nativeAd != null) {
                ArrayList arrayList = new ArrayList();
                RoundedFrameLayout roundedFrameLayout = (RoundedFrameLayout) view.findViewById(R.id.inter_icon_ads_icon_item_layout);
                if (roundedFrameLayout != null) {
                    roundedFrameLayout.setStrokeWidth(this.h);
                    roundedFrameLayout.setStrokeColor(this.g.j);
                }
                ImageView imageView = (ImageView) view.findViewById(R.id.inter_icon_ads_item_icon);
                if (imageView != null) {
                    imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                    imageView.setTag(1);
                    arrayList.add(imageView);
                    imageView.setBackgroundColor(this.g.f14639i);
                    imageView.setImageDrawable(sg.bigo.ads.common.utils.a.a(imageView.getContext(), R.drawable.bigo_ad_icon_default));
                }
                TextView textView = (TextView) view.findViewById(R.id.inter_icon_ads_item_title);
                if (textView != null) {
                    if (z2) {
                        textView.setTextColor(this.g.f14637d);
                    }
                    textView.setText(nativeAd.getTitle());
                    textView.setTag(2);
                    arrayList.add(textView);
                }
                TextView textView2 = (TextView) view.findViewById(R.id.inter_icon_ads_item_sponsored);
                if (textView2 != null) {
                    if (z2) {
                        textView2.setTextColor(this.g.f14637d);
                    }
                    textView2.setText(nativeAd.getSponsored());
                    textView2.setTag(3);
                    a(textView2);
                    arrayList.add(textView2);
                }
                TextView textView3 = (TextView) view.findViewById(R.id.inter_icon_ads_item_desc);
                if (textView3 != null) {
                    if (z2) {
                        textView3.setTextColor(this.g.f14637d);
                    }
                    textView3.setText(nativeAd.getDescription());
                    textView3.setTag(6);
                    arrayList.add(textView3);
                }
                Button button = (Button) view.findViewById(R.id.inter_icon_ads_item_btn_cta);
                if (button != null) {
                    button.setText(nativeAd.getCallToAction());
                    button.setTag(7);
                    arrayList.add(button);
                    float f4 = this.f14694i;
                    b.a aVar2 = this.g;
                    button.setBackground(sg.bigo.ads.common.utils.d.a(f4, f4, f4, f4, aVar2.k, aVar2.l, this.h));
                }
                ViewGroup viewGroup = listA.size() == 1 ? this.f14689a : (ViewGroup) view;
                if (nativeAd instanceof sg.bigo.ads.ad.b.c) {
                    sg.bigo.ads.ad.b.c cVar = (sg.bigo.ads.ad.b.c) nativeAd;
                    cVar.I = this.f14691c.l();
                    if (this.f14693f) {
                        sg.bigo.ads.ad.b.a.a(viewGroup, viewGroup, 1, cVar, this.f14691c.l());
                    }
                }
                nativeAd.registerViewForInteraction(viewGroup, (MediaView) null, imageView, (AdOptionsView) null, arrayList);
            }
        }
    }

    public final void a(@Nullable b bVar) {
        a(this.f14689a, bVar);
    }
}
