package sg.bigo.ads.ad.interstitial.c;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.TranslateAnimation;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import sg.bigo.ads.R;

/* JADX INFO: loaded from: classes6.dex */
public class s extends b {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private View f14395w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private TextView f14396x;

    public s(@NonNull sg.bigo.ads.ad.b.c cVar, int i2, @NonNull sg.bigo.ads.api.a.m mVar, @NonNull sg.bigo.ads.ad.interstitial.multi_img.b bVar, @Nullable sg.bigo.ads.ad.interstitial.e.c cVar2) {
        super(cVar, i2, mVar, bVar, cVar2);
    }

    public static /* synthetic */ void b(s sVar) {
        View view = sVar.f14395w;
        if (view == null || sVar.f14396x == null) {
            return;
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int[] iArr2 = new int[2];
        sVar.f14396x.getLocationOnScreen(iArr2);
        ViewGroup.LayoutParams layoutParams = sVar.f14396x.getLayoutParams();
        layoutParams.width = (iArr[0] - iArr2[0]) - sg.bigo.ads.common.utils.e.a(sVar.k.getContext(), 28);
        sVar.f14396x.setLayoutParams(layoutParams);
        sVar.f14396x.setLayerType(1, null);
    }

    @Override // sg.bigo.ads.ad.interstitial.c.b
    public void g(sg.bigo.ads.ad.interstitial.r rVar) {
        super.g(rVar);
        this.f14395w = rVar != null ? rVar.o(R.id.inter_btn_close) : null;
        TextView textView = (TextView) this.k.findViewById(R.id.inter_title);
        this.f14396x = textView;
        this.f14329o.b(textView);
        this.f14329o.b(this.l);
        if (l()) {
            this.f14331r.setVisibility(8);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.l.getLayoutParams();
            marginLayoutParams.topMargin = sg.bigo.ads.common.utils.e.a(this.l.getContext(), 0);
            this.l.setLayoutParams(marginLayoutParams);
        }
    }

    @Override // sg.bigo.ads.ad.interstitial.c.a
    public int h() {
        return R.layout.bigo_ad_activity_interstitial_rich_video_end_6;
    }

    @Override // sg.bigo.ads.ad.interstitial.c.a
    public void a(@NonNull sg.bigo.ads.ad.interstitial.r rVar, int i2) {
        super.a(rVar, i2);
        final View viewFindViewById = this.k.findViewById(R.id.inter_media_ad_desc);
        if (viewFindViewById == null) {
            return;
        }
        viewFindViewById.setVisibility(4);
        if (i2 < 0) {
            return;
        }
        viewFindViewById.postDelayed(new Runnable() { // from class: sg.bigo.ads.ad.interstitial.c.s.1
            @Override // java.lang.Runnable
            public final void run() {
                if (sg.bigo.ads.ad.c.a((sg.bigo.ads.ad.c) s.this.f15176f)) {
                    return;
                }
                viewFindViewById.setVisibility(0);
                s.b(s.this);
                TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, -1.625f, 1, 0.0f);
                translateAnimation.setDuration(600L);
                viewFindViewById.startAnimation(translateAnimation);
            }
        }, ((long) i2) * 1000);
    }
}
