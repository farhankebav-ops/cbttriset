package sg.bigo.ads.ad.interstitial.c;

import android.graphics.Rect;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import sg.bigo.ads.R;

/* JADX INFO: loaded from: classes6.dex */
public class h extends g {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    @Nullable
    private Button f14374t;

    public h(@NonNull sg.bigo.ads.ad.b.c cVar, int i2, @NonNull sg.bigo.ads.api.a.m mVar, @Nullable sg.bigo.ads.ad.interstitial.e.c cVar2) {
        super(cVar, i2, mVar, cVar2);
    }

    @Override // sg.bigo.ads.ad.interstitial.c.g
    public final void a(int i2) {
        super.a(i2);
        Button button = (Button) this.k.findViewById(R.id.inter_btn_cta_main);
        this.f14374t = button;
        if (button != null) {
            button.setVisibility(0);
            float fA = sg.bigo.ads.common.utils.e.a(this.k.getContext(), 8);
            this.f14374t.setBackground(sg.bigo.ads.common.utils.d.a(fA, fA, fA, fA, (Rect) null, -16724924));
            this.f14374t.setTextColor(sg.bigo.ads.ad.interstitial.d.f14441a);
            sg.bigo.ads.ad.interstitial.b.f14273a.a(this.f14374t);
        }
    }

    @Override // sg.bigo.ads.ad.interstitial.c.g
    public final void m() {
        super.m();
        if (this.f14374t == null || !j()) {
            return;
        }
        sg.bigo.ads.ad.interstitial.c.e(this.f14374t);
    }
}
