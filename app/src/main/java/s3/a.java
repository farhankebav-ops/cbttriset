package s3;

import com.unity3d.mediation.LevelPlayAdError;
import com.unity3d.mediation.LevelPlayAdInfo;
import com.unity3d.mediation.rewarded.LevelPlayRewardedAdListener;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public abstract /* synthetic */ class a {
    public static void a(LevelPlayRewardedAdListener levelPlayRewardedAdListener, LevelPlayAdInfo adInfo) {
        k.e(adInfo, "adInfo");
    }

    public static void b(LevelPlayRewardedAdListener levelPlayRewardedAdListener, LevelPlayAdInfo adInfo) {
        k.e(adInfo, "adInfo");
    }

    public static void c(LevelPlayRewardedAdListener levelPlayRewardedAdListener, LevelPlayAdError error, LevelPlayAdInfo adInfo) {
        k.e(error, "error");
        k.e(adInfo, "adInfo");
    }

    public static void d(LevelPlayRewardedAdListener levelPlayRewardedAdListener, LevelPlayAdInfo adInfo) {
        k.e(adInfo, "adInfo");
    }
}
