package com.ironsource;

import android.app.Activity;
import android.content.Context;
import com.ironsource.mediationsdk.ISBannerSize;
import com.ironsource.mediationsdk.demandOnly.ISDemandOnlyBannerLayout;
import com.ironsource.mediationsdk.demandOnly.ISDemandOnlyInterstitialListener;
import com.ironsource.mediationsdk.demandOnly.ISDemandOnlyRewardedVideoListener;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public interface T4 {

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface a {
        ISDemandOnlyBannerLayout a(Activity activity, ISBannerSize iSBannerSize);

        void a(Activity activity, ISDemandOnlyBannerLayout iSDemandOnlyBannerLayout, String str);

        void e(String str);
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface b {
        void a(Activity activity, String str);

        void a(ISDemandOnlyInterstitialListener iSDemandOnlyInterstitialListener);

        void b(Activity activity, String str, String str2);

        void c(String str);

        boolean d(String str);
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface c {
        void a(Activity activity, String str, String str2);

        void a(ISDemandOnlyRewardedVideoListener iSDemandOnlyRewardedVideoListener);

        void a(String str);

        void b(Activity activity, String str);

        boolean j(String str);
    }

    String a(Context context);
}
