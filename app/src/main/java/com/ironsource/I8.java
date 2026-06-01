package com.ironsource;

import android.app.Activity;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public interface I8 {

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface a {
        void onNativeAdClicked();

        void onNativeAdLoadFailed(String str);

        void onNativeAdLoadSuccess(G8 g8);

        void onNativeAdShown();
    }

    void a();

    void a(Activity activity, JSONObject jSONObject);

    void a(a aVar);

    void a(J8 j8);

    a b();

    G8 c();
}
