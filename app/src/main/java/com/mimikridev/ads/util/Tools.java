package com.mimikridev.ads.util;

import android.app.Activity;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.view.Display;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.admanager.AdManagerAdRequest;
import com.mimikridev.ads.gdpr.LegacyGDPR;
import java.nio.charset.StandardCharsets;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class Tools {
    public static String decode(String str) {
        return decodeBase64(decodeBase64(decodeBase64(str)));
    }

    public static String decodeBase64(String str) {
        return new String(Base64.decode(str.getBytes(StandardCharsets.UTF_8), 0));
    }

    public static AdRequest getAdRequest(Activity activity, Boolean bool) {
        return bool.booleanValue() ? new AdRequest.Builder().addNetworkExtrasBundle(AdMobAdapter.class, LegacyGDPR.getBundleAd(activity)).build() : new AdRequest.Builder().build();
    }

    public static AdSize getAdSize(Activity activity) {
        Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getMetrics(displayMetrics);
        return AdSize.getCurrentOrientationAnchoredAdaptiveBannerAdSize(activity, (int) (displayMetrics.widthPixels / displayMetrics.density));
    }

    public static AdSize getAdSizeMREC() {
        return AdSize.MEDIUM_RECTANGLE;
    }

    public static AdManagerAdRequest getGoogleAdManagerRequest() {
        return new AdManagerAdRequest.Builder().build();
    }

    public static String jsonDecode(String str) {
        return new String(Base64.decode(str.replace(Constant.TOKEN, "").getBytes(StandardCharsets.UTF_8), 0));
    }

    public static AdRequest getAdRequest(boolean z2) {
        if (z2) {
            return new AdRequest.Builder().addNetworkExtrasBundle(AdMobAdapter.class, androidx.camera.core.processing.util.a.c("collapsible", "bottom")).build();
        }
        return new AdRequest.Builder().build();
    }
}
