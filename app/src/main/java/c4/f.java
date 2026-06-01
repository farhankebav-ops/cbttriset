package c4;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.rewarded.RewardedAd;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class f extends a implements u3.a {
    public final /* synthetic */ int h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ f(Context context, u3.c cVar, b4.a aVar, com.unity3d.scar.adapter.common.d dVar, int i2) {
        super(context, cVar, aVar, dVar, 0);
        this.h = i2;
    }

    @Override // c4.a
    public final void b(AdRequest adRequest) {
        switch (this.h) {
            case 0:
                InterstitialAd.load(this.f4180c, this.f4181d.f17529c, adRequest, ((i) ((b) this.g)).f4196d);
                break;
            default:
                RewardedAd.load(this.f4180c, this.f4181d.f17529c, adRequest, ((k) ((b) this.g)).f4201d);
                break;
        }
    }

    @Override // u3.a
    public final void show(Activity activity) {
        switch (this.h) {
            case 0:
                Object obj = this.f4179b;
                if (obj == null) {
                    this.e.handleError(com.unity3d.scar.adapter.common.b.a(this.f4181d));
                } else {
                    ((InterstitialAd) obj).show(activity);
                }
                break;
            default:
                Object obj2 = this.f4179b;
                if (obj2 == null) {
                    this.e.handleError(com.unity3d.scar.adapter.common.b.a(this.f4181d));
                } else {
                    ((RewardedAd) obj2).show(activity, ((k) ((b) this.g)).e);
                }
                break;
        }
    }
}
