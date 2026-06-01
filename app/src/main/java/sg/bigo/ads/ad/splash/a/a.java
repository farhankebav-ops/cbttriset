package sg.bigo.ads.ad.splash.a;

import android.graphics.Bitmap;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.URLUtil;
import android.webkit.ValueCallback;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import sg.bigo.ads.R;
import sg.bigo.ads.ad.interstitial.s;
import sg.bigo.ads.ad.splash.a.c;
import sg.bigo.ads.api.AdOptionsView;
import sg.bigo.ads.api.MediaView;
import sg.bigo.ads.api.a.m;
import sg.bigo.ads.api.core.c;
import sg.bigo.ads.common.utils.q;

/* JADX INFO: loaded from: classes6.dex */
public final class a implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    protected final sg.bigo.ads.ad.splash.b f15288a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final ViewGroup f15289b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f15290c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    private final m f15291d;

    @NonNull
    private final ViewGroup e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f15292f;

    public a(@NonNull ViewGroup viewGroup, @NonNull sg.bigo.ads.ad.splash.b bVar, @Nullable m mVar) {
        int i2;
        sg.bigo.ads.ad.b.c cVar;
        int i8;
        int i9;
        char c7;
        this.f15290c = c.a.f15329a;
        this.f15291d = mVar;
        this.e = viewGroup;
        this.f15288a = bVar;
        ViewGroup viewGroup2 = (ViewGroup) sg.bigo.ads.common.utils.a.a(viewGroup.getContext(), (mVar == null || mVar.a("endpage.guide_click") != 4) ? R.layout.bigo_ad_splash_endpage1 : R.layout.bigo_ad_splash_endpage1_slide, null, false);
        this.f15289b = viewGroup2;
        this.f15290c = c.a.f15331c;
        ArrayList arrayList = new ArrayList();
        final ImageView imageView = (ImageView) viewGroup2.findViewById(R.id.inter_icon);
        TextView textView = (TextView) viewGroup2.findViewById(R.id.inter_title);
        TextView textView2 = (TextView) viewGroup2.findViewById(R.id.inter_description);
        Button button = (Button) viewGroup2.findViewById(R.id.bigo_ad_splash_btn_cta);
        AdOptionsView adOptionsView = (AdOptionsView) viewGroup2.findViewById(R.id.inter_options);
        sg.bigo.ads.ad.b.c cVar2 = bVar.f15396x;
        c.d popPage = cVar2.getPopPage();
        if (textView != null) {
            i2 = 4;
            textView.setTag(2);
            sg.bigo.ads.ad.splash.a.a(textView, cVar2.getTitle(), popPage == null ? "" : popPage.b());
            arrayList.add(textView);
        } else {
            i2 = 4;
        }
        if (textView2 != null) {
            textView2.setTag(6);
            sg.bigo.ads.ad.splash.a.a(textView2, cVar2.getDescription(), popPage == null ? "" : popPage.c());
            arrayList.add(textView2);
        }
        if (button != null) {
            button.setTag(7);
            sg.bigo.ads.ad.splash.a.a(button, cVar2.getCallToAction(), "");
            arrayList.add(button);
            if (mVar != null) {
                int iA = s.a(cVar2, mVar.a("endpage.cta_color"), null);
                if (button.getBackground() instanceof GradientDrawable) {
                    ((GradientDrawable) button.getBackground()).setColor(iA);
                }
            }
        }
        if (adOptionsView != null) {
            adOptionsView.setTag(Integer.valueOf(i2));
            adOptionsView.a(cVar2.f(), ((sg.bigo.ads.core.a.a) cVar2.f()).l());
        }
        if (imageView != null) {
            String strC = ((sg.bigo.ads.core.a.a) cVar2.f()).av() != null ? ((sg.bigo.ads.core.a.a) cVar2.f()).av().c() : null;
            imageView.setTag(1);
            if (q.a((CharSequence) strC) || !URLUtil.isNetworkUrl(strC)) {
                a(imageView);
            } else {
                sg.bigo.ads.common.p.e.b(bVar.f14024b.e, null, strC, ((sg.bigo.ads.core.a.a) cVar2.f()).al(), new sg.bigo.ads.common.p.g() { // from class: sg.bigo.ads.ad.splash.a.a.1
                    @Override // sg.bigo.ads.common.p.g
                    public final void a(int i10, @NonNull String str, String str2) {
                        a.this.a(imageView);
                    }

                    @Override // sg.bigo.ads.common.p.g
                    public final void a(@NonNull Bitmap bitmap, @NonNull sg.bigo.ads.common.p.f fVar) {
                        imageView.setImageBitmap(bitmap);
                    }
                });
            }
        }
        View viewFindViewById = viewGroup2.findViewById(R.id.layout_contain_view);
        if (viewFindViewById == null || mVar == null) {
            cVar = cVar2;
            i8 = i2;
            i9 = 1;
        } else {
            int iA2 = mVar.a("endpage.click_type", 1);
            sg.bigo.ads.ad.splash.a.a(viewGroup2, viewFindViewById, mVar.a("endpage.below_area_dp"), mVar.a("endpage.below_area_clickable") == 1, mVar.a("endpage.up_area_dp"), mVar.a("endpage.up_area_clickable") == 1, 9, iA2, cVar2);
            adOptionsView = adOptionsView;
            i9 = iA2;
            cVar = cVar2;
            i8 = i2;
            if (imageView != null) {
                sg.bigo.ads.ad.b.a.a(viewGroup, imageView, i8, cVar, i9);
            }
        }
        if (mVar == null || 1 != mVar.a("endpage.other_space_clickable_switch", 1)) {
            c7 = 0;
            sg.bigo.ads.ad.b.a.a(viewGroup, viewGroup2, i8, new sg.bigo.ads.core.adview.h() { // from class: sg.bigo.ads.ad.splash.a.a.2
                @Override // sg.bigo.ads.core.adview.h
                public final void a(int i10, int i11, int i12, int i13, int i14, int i15) {
                }
            }, 0);
        } else {
            sg.bigo.ads.ad.b.a.a(viewGroup, viewGroup2, i8, cVar, i9);
            c7 = 0;
        }
        cVar.I = 9;
        View[] viewArr = new View[1];
        viewArr[c7] = viewGroup2;
        cVar.a(viewGroup, (MediaView) null, imageView, adOptionsView, (List<View>) arrayList, 9, viewArr);
    }

    @Override // sg.bigo.ads.ad.splash.a.c
    public final void a() {
    }

    @Override // sg.bigo.ads.ad.splash.a.c
    public final void c() {
        this.f15290c = c.a.f15332d;
    }

    @Override // sg.bigo.ads.ad.splash.a.c
    @NonNull
    public final int d() {
        return this.f15290c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final ImageView imageView) {
        sg.bigo.ads.ad.splash.a.a(this.f15288a.f15396x, new ValueCallback<Bitmap>() { // from class: sg.bigo.ads.ad.splash.a.a.3
            @Override // android.webkit.ValueCallback
            public final /* synthetic */ void onReceiveValue(Bitmap bitmap) {
                final Bitmap bitmap2 = bitmap;
                imageView.post(new Runnable() { // from class: sg.bigo.ads.ad.splash.a.a.3.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        imageView.setImageBitmap(bitmap2);
                    }
                });
            }
        });
    }

    @Override // sg.bigo.ads.ad.splash.a.c
    public final void a(boolean z2) {
    }

    /* JADX WARN: Type inference failed for: r9v8, types: [sg.bigo.ads.api.core.c] */
    @Override // sg.bigo.ads.ad.splash.a.c
    public final void a(boolean z2, @NonNull ViewGroup viewGroup, int i2) {
        g gVar;
        if (!this.f15292f) {
            this.f15292f = true;
            this.e.removeViewAt(1);
            this.e.addView(this.f15289b, 1, new ViewGroup.LayoutParams(-1, -1));
            this.f15289b.setVisibility(8);
        }
        this.f15290c = z2 ? c.a.f15330b : c.a.f15331c;
        this.f15289b.setVisibility(z2 ? 0 : 8);
        if (z2) {
            sg.bigo.ads.ad.splash.a.f15260b = true;
            m mVar = this.f15291d;
            int iA = mVar != null ? mVar.a("endpage.guide_click") : 0;
            ViewGroup viewGroup2 = (ViewGroup) this.f15289b.findViewById(R.id.bigo_ad_splash_btn_cta_container);
            Button button = (Button) this.f15289b.findViewById(R.id.bigo_ad_splash_btn_cta);
            if (viewGroup2 != null) {
                if (iA == 4 && button != null) {
                    button.setTextSize(2, 15.0f);
                    button.setBackground(null);
                    View viewFindViewById = this.f15289b.findViewById(R.id.splash_footer_bg);
                    if (viewFindViewById != null) {
                        viewFindViewById.setVisibility(0);
                        viewFindViewById.setTag(14);
                        sg.bigo.ads.ad.b.a.a(viewGroup, viewFindViewById, 8, this.f15288a.f15396x, 0);
                    }
                }
                sg.bigo.ads.ad.splash.a.b(viewGroup2, iA);
            }
            View viewFindViewById2 = this.f15289b.findViewById(R.id.layout_playable_loading);
            if (viewFindViewById2 != null && (gVar = this.f15288a.f15395w) != null && gVar.g != 0) {
                m mVar2 = this.f15291d;
                int i8 = (sg.bigo.ads.api.a.i.f15457a.p().a() && 2 == (mVar2 != null ? mVar2.a("endpage.ad_component_layout") : 1)) ? 1 : 0;
                viewFindViewById2.setVisibility(i8 == 0 ? 4 : 0);
                i = i8;
            }
            sg.bigo.ads.core.d.b.a((sg.bigo.ads.api.core.c) this.f15288a.f15396x.f(), i != 0 ? 4 : 1, i2);
        }
    }

    @Override // sg.bigo.ads.ad.splash.a.c
    public final void b() {
    }
}
