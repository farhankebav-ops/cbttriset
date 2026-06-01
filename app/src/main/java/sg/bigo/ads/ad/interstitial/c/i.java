package sg.bigo.ads.ad.interstitial.c;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import sg.bigo.ads.R;
import sg.bigo.ads.common.utils.u;
import sg.bigo.ads.common.view.RoundedImageView;

/* JADX INFO: loaded from: classes6.dex */
public class i extends g {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private View f14375t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private RoundedImageView f14376u;

    public i(@NonNull sg.bigo.ads.ad.b.c cVar, int i2, @NonNull sg.bigo.ads.api.a.m mVar, @Nullable sg.bigo.ads.ad.interstitial.e.c cVar2) {
        super(cVar, i2, mVar, cVar2);
    }

    @Override // sg.bigo.ads.ad.interstitial.c.g, sg.bigo.ads.ad.interstitial.c.a
    public final void d(final sg.bigo.ads.ad.interstitial.r rVar) {
        super.d(rVar);
        ViewGroup viewGroup = this.k;
        if (viewGroup == null) {
            return;
        }
        this.f14375t = viewGroup.findViewById(R.id.inter_end_page_image_layout);
        this.f14376u = (RoundedImageView) this.k.findViewById(R.id.inter_end_page_image);
        sg.bigo.ads.common.utils.u.a(this.f14375t, new u.a() { // from class: sg.bigo.ads.ad.interstitial.c.i.1
            @Override // sg.bigo.ads.common.utils.u.a
            public final void a(@NonNull Rect rect) {
                int iA;
                float fA;
                int i2;
                int i8;
                sg.bigo.ads.common.p pVarB = i.this.b(rVar);
                if (pVarB.a(rect.width(), rect.height())) {
                    i8 = -1;
                    fA = 0.0f;
                    iA = 0;
                    i2 = -1;
                } else {
                    iA = sg.bigo.ads.common.utils.e.a(i.this.f14376u.getContext(), 20);
                    int i9 = iA * 2;
                    sg.bigo.ads.common.p pVarA = sg.bigo.ads.common.p.a(pVarB.f15849b, pVarB.f15850c, rect.width() - i9, rect.height() - i9);
                    int i10 = pVarA.f15849b;
                    int i11 = pVarA.f15850c;
                    fA = sg.bigo.ads.common.utils.e.a(i.this.f14376u.getContext(), 8);
                    i2 = i11;
                    i8 = i10;
                }
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) i.this.f14376u.getLayoutParams();
                marginLayoutParams.setMargins(iA, iA, iA, iA);
                marginLayoutParams.width = i8;
                marginLayoutParams.height = i2;
                i.this.f14376u.requestLayout();
                i.this.f14376u.setCornerRadius(fA);
            }
        });
        TextView textView = this.l;
        if (textView != null) {
            sg.bigo.ads.ad.interstitial.d.a(textView, -1);
        }
    }

    @Override // sg.bigo.ads.ad.interstitial.c.g, sg.bigo.ads.ad.interstitial.c.a
    public final int h() {
        return R.layout.bigo_ad_activity_interstitial_rich_video_end_16_17;
    }

    @Override // sg.bigo.ads.ad.interstitial.c.g
    public final void l() {
        View view = this.f14364o;
        if (view != null) {
            view.setBackgroundColor(-1);
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

    @Override // sg.bigo.ads.ad.interstitial.c.g, sg.bigo.ads.ad.interstitial.c.a
    public final void a(double d8) {
    }

    @Override // sg.bigo.ads.ad.interstitial.c.g, sg.bigo.ads.ad.interstitial.c.a
    public final void a(int i2, boolean z2, boolean z7) {
        sg.bigo.ads.ad.b.a.a(this.f14376u, 5);
        if (z2) {
            sg.bigo.ads.ad.b.a.a(this.j, this.f14376u, 4, this.f15176f, i2);
        } else {
            sg.bigo.ads.ad.b.a.a(this.j, this.f14376u, 4, sg.bigo.ads.ad.interstitial.r.F, 0);
        }
        sg.bigo.ads.ad.b.a.a(this.f14375t, 9);
        ViewGroup viewGroup = this.j;
        if (z7) {
            sg.bigo.ads.ad.b.a.a(viewGroup, this.f14375t, 4, this.f15176f, i2);
        } else {
            sg.bigo.ads.ad.b.a.a(viewGroup, this.f14375t, 4, sg.bigo.ads.ad.interstitial.r.F, 0);
        }
        sg.bigo.ads.api.a.m mVar = this.g;
        boolean z8 = true;
        if (mVar != null && mVar.a("endpage.ad_component_clickable_switch") != 1) {
            z8 = false;
        }
        View view = this.f14364o;
        if (view != null) {
            sg.bigo.ads.ad.b.a.a(view, 18);
            if (z8) {
                sg.bigo.ads.ad.b.a.a(this.j, this.f14364o, 8, this.f15176f, i2);
            } else {
                sg.bigo.ads.ad.b.a.a(this.j, this.f14364o, 8, sg.bigo.ads.ad.interstitial.r.F, 0);
            }
        }
    }

    @Override // sg.bigo.ads.ad.interstitial.c.g, sg.bigo.ads.ad.interstitial.c.a
    public final void a(final Runnable runnable) {
        b(new Runnable() { // from class: sg.bigo.ads.ad.interstitial.c.i.2
            @Override // java.lang.Runnable
            public final void run() {
                Runnable runnable2 = runnable;
                if (runnable2 != null) {
                    runnable2.run();
                }
                i.this.m();
            }
        });
    }
}
