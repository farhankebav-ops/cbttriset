package androidx.webkit.internal;

import android.content.Context;
import android.net.Uri;
import android.webkit.SafeBrowsingResponse;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
@RequiresApi(27)
public class ApiHelperForOMR1 {
    private ApiHelperForOMR1() {
    }

    public static void backToSafety(@NonNull SafeBrowsingResponse safeBrowsingResponse, boolean z2) {
        safeBrowsingResponse.backToSafety(z2);
    }

    @NonNull
    public static Uri getSafeBrowsingPrivacyPolicyUrl() {
        return WebView.getSafeBrowsingPrivacyPolicyUrl();
    }

    public static void proceed(@NonNull SafeBrowsingResponse safeBrowsingResponse, boolean z2) {
        safeBrowsingResponse.proceed(z2);
    }

    public static void setSafeBrowsingWhitelist(@NonNull List<String> list, @Nullable ValueCallback<Boolean> valueCallback) {
        WebView.setSafeBrowsingWhitelist(list, valueCallback);
    }

    public static void showInterstitial(@NonNull SafeBrowsingResponse safeBrowsingResponse, boolean z2) {
        safeBrowsingResponse.showInterstitial(z2);
    }

    public static void startSafeBrowsing(@NonNull Context context, @Nullable ValueCallback<Boolean> valueCallback) {
        WebView.startSafeBrowsing(context, valueCallback);
    }
}
