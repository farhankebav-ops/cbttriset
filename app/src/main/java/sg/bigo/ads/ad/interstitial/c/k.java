package sg.bigo.ads.ad.interstitial.c;

import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import sg.bigo.ads.R;
import sg.bigo.ads.common.utils.u;
import sg.bigo.ads.common.view.RoundedImageView;

/* JADX INFO: loaded from: classes6.dex */
public class k extends a {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    protected View f14382o;
    protected RoundedImageView p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    protected TextView f14383q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    protected View f14384r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    protected RoundedImageView f14385s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    protected RoundedImageView f14386t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    protected Button f14387u;

    public k(@NonNull sg.bigo.ads.ad.b.c cVar, int i2, @NonNull sg.bigo.ads.api.a.m mVar, @Nullable sg.bigo.ads.ad.interstitial.e.c cVar2) {
        super(cVar, i2, mVar, cVar2);
    }

    @Override // sg.bigo.ads.ad.interstitial.c.a
    public final void a(double d8) {
        TextView textView;
        int i2;
        if (d8 <= 3.0d) {
            textView = this.l;
            if (textView == null) {
                return;
            } else {
                i2 = sg.bigo.ads.ad.interstitial.d.f14442b;
            }
        } else {
            textView = this.l;
            if (textView == null) {
                return;
            } else {
                i2 = sg.bigo.ads.ad.interstitial.d.f14441a;
            }
        }
        textView.setTextColor(sg.bigo.ads.common.w.b.a(i2, 0.6f));
    }

    @Override // sg.bigo.ads.ad.interstitial.c.a
    public void d(final sg.bigo.ads.ad.interstitial.r rVar) {
        ViewGroup viewGroup = this.k;
        if (viewGroup == null) {
            return;
        }
        this.f14382o = viewGroup.findViewById(R.id.inter_end_page);
        this.p = (RoundedImageView) this.k.findViewById(R.id.inter_icon);
        this.f14383q = (TextView) this.k.findViewById(R.id.inter_title);
        l().a(this.p);
        l().a(this.f14383q, null);
        this.f14384r = this.k.findViewById(R.id.inter_end_page_image_layout);
        this.f14385s = (RoundedImageView) this.k.findViewById(R.id.inter_end_page_image);
        this.f14386t = (RoundedImageView) this.k.findViewById(R.id.inter_end_page_image_background);
        float fA = sg.bigo.ads.common.utils.e.a(this.f14385s.getContext(), 8);
        this.f14385s.setCornerRadius(fA);
        this.f14386t.setCornerRadius(fA);
        this.f14386t.setBackgroundColor(654311423);
        sg.bigo.ads.common.utils.u.a(this.f14384r, new u.a() { // from class: sg.bigo.ads.ad.interstitial.c.k.1
            @Override // sg.bigo.ads.common.utils.u.a
            public final void a(@NonNull Rect rect) {
                k.this.a(rVar, rect);
            }
        });
        a(f(rVar));
    }

    @Override // sg.bigo.ads.ad.interstitial.v
    public final boolean f() {
        return true;
    }

    @Override // sg.bigo.ads.ad.interstitial.c.a
    public int h() {
        return R.layout.bigo_ad_activity_interstitial_rich_video_end_18;
    }

    @Override // sg.bigo.ads.ad.interstitial.c.a
    public final void i() {
        String strI = ((sg.bigo.ads.core.a.a) this.f15176f.f()).i();
        TextView textView = (TextView) this.k.findViewById(R.id.inter_advertiser);
        if (TextUtils.isEmpty(strI)) {
            textView.setVisibility(8);
        } else {
            textView.setText(strI);
        }
    }

    @NonNull
    public sg.bigo.ads.ad.interstitial.b l() {
        return sg.bigo.ads.ad.interstitial.b.f14276d;
    }

    public final void m() {
        if (this.f14387u == null || !j()) {
            return;
        }
        sg.bigo.ads.ad.interstitial.c.e(this.f14387u);
    }

    public void a(int i2) {
        Button button = (Button) this.k.findViewById(R.id.inter_btn_cta);
        this.f14387u = button;
        if (button != null) {
            float fA = sg.bigo.ads.common.utils.e.a(this.k.getContext(), 8);
            this.f14387u.setBackground(sg.bigo.ads.common.utils.d.a(fA, fA, fA, fA, (Rect) null, i2));
            sg.bigo.ads.ad.interstitial.d.a(this.f14387u, sg.bigo.ads.common.w.b.a(i2));
            l().a(this.f14387u);
        }
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

    @Override // sg.bigo.ads.ad.interstitial.c.a
    public void a(int i2, boolean z2, boolean z7) {
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
        if (z7) {
            sg.bigo.ads.ad.b.a.a(this.j, this.k, 4, this.f15176f, i2);
        } else {
            sg.bigo.ads.ad.b.a.a(this.j, this.k, 4, sg.bigo.ads.ad.interstitial.r.F, 0);
        }
    }

    @Override // sg.bigo.ads.ad.interstitial.c.a
    public final void a(final Runnable runnable) {
        super.a(new Runnable() { // from class: sg.bigo.ads.ad.interstitial.c.k.2
            @Override // java.lang.Runnable
            public final void run() {
                k.this.m();
                Runnable runnable2 = runnable;
                if (runnable2 != null) {
                    runnable2.run();
                }
            }
        });
    }

    public void a(sg.bigo.ads.ad.interstitial.r rVar, @NonNull Rect rect) {
        sg.bigo.ads.common.p pVarB = b(rVar);
        int iA = sg.bigo.ads.common.utils.e.a(this.f14384r.getContext(), 16);
        int iWidth = rect.width();
        int iHeight = rect.height();
        int i2 = iA * 2;
        int i8 = iWidth - i2;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f14384r.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f14385s.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.f14386t.getLayoutParams();
        sg.bigo.ads.common.p pVarA = sg.bigo.ads.common.p.a(pVarB.f15849b, pVarB.f15850c, iWidth, iHeight - i2);
        sg.bigo.ads.common.p pVarA2 = sg.bigo.ads.common.p.a(pVarB.f15849b, pVarB.f15850c, i8, iHeight);
        if (pVarA.a(pVarA2)) {
            layoutParams.width = pVarA.f15849b;
            layoutParams.height = pVarA.f15850c + i2;
            marginLayoutParams.topMargin = iA;
            marginLayoutParams.bottomMargin = iA;
            marginLayoutParams2.leftMargin = iA;
            marginLayoutParams2.rightMargin = iA;
        } else {
            layoutParams.width = pVarA2.f15849b + i2;
            layoutParams.height = pVarA2.f15850c;
            marginLayoutParams.leftMargin = iA;
            marginLayoutParams.rightMargin = iA;
            marginLayoutParams2.topMargin = iA;
            marginLayoutParams2.bottomMargin = iA;
        }
        this.f14384r.requestLayout();
        this.f14385s.requestLayout();
        this.f14386t.requestLayout();
    }
}
