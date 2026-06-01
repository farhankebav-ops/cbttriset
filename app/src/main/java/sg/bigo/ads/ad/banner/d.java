package sg.bigo.ads.ad.banner;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import sg.bigo.ads.api.BannerAd;
import sg.bigo.ads.api.InnerBannerAd;

/* JADX INFO: loaded from: classes6.dex */
public final class d {
    @Nullable
    public static BannerAd a(@NonNull sg.bigo.ads.api.core.g gVar) {
        try {
            return new i(gVar);
        } catch (Exception e) {
            sg.bigo.ads.core.d.b.a(3000, 10100, Log.getStackTraceString(e));
            return null;
        }
    }

    @Nullable
    public static InnerBannerAd b(@NonNull sg.bigo.ads.api.core.g gVar) {
        if (gVar.f15496a.w() == 3) {
            return new e(gVar);
        }
        if (gVar.f15496a.w() == 2 || gVar.f15496a.w() == 1) {
            return new sg.bigo.ads.ad.c.d(gVar);
        }
        return null;
    }
}
