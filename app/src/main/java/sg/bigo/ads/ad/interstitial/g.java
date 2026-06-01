package sg.bigo.ads.ad.interstitial;

import androidx.annotation.DrawableRes;
import sg.bigo.ads.R;

/* JADX INFO: loaded from: classes6.dex */
public enum g {
    BLACK(R.drawable.bigo_ad_ic_right_black, R.drawable.bigo_ad_ic_star_normal, R.drawable.bigo_ad_ic_star_half, R.drawable.bigo_ad_ic_star),
    WHITE(R.drawable.bigo_ad_ic_right_white, R.drawable.bigo_ad_ic_star_normal_white, R.drawable.bigo_ad_ic_star_half_white, R.drawable.bigo_ad_ic_star_white);


    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @DrawableRes
    public final int f14752c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @DrawableRes
    public final int f14753d;

    @DrawableRes
    public final int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @DrawableRes
    public final int f14754f;

    g(int i2, int i8, int i9, int i10) {
        this.f14752c = i2;
        this.f14753d = i8;
        this.e = i9;
        this.f14754f = i10;
    }
}
