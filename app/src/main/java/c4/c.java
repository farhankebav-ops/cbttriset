package c4;

import android.widget.RelativeLayout;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class c extends a {
    public RelativeLayout h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f4184i;
    public int j;
    public AdView k;

    @Override // c4.a
    public final void b(AdRequest adRequest) {
        AdView adView = this.k;
        RelativeLayout relativeLayout = this.h;
        if (relativeLayout == null || adView == null) {
            return;
        }
        relativeLayout.addView(adView);
        adView.setAdSize(new AdSize(this.f4184i, this.j));
        adView.setAdUnitId(this.f4181d.f17529c);
        adView.setAdListener(((e) ((b) this.g)).f4189d);
        adView.loadAd(adRequest);
    }
}
