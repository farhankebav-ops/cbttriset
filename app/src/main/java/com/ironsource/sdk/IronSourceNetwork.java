package com.ironsource.sdk;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.ironsource.A8;
import com.ironsource.B8;
import com.ironsource.C2531r4;
import com.ironsource.C2586u8;
import com.ironsource.I5;
import com.ironsource.M9;
import com.ironsource.Nc;
import com.ironsource.Q9;
import com.ironsource.W9;
import com.ironsource.Z9;
import com.ironsource.sdk.controller.e;
import com.ironsource.sdk.utils.Logger;
import com.ironsource.sdk.utils.SDKUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class IronSourceNetwork {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final String f9831a = "IronSourceNetwork";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static W9 f9832b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static List<Nc> f9833c = new ArrayList();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static Z9 f9834d;

    private static void a(Context context, JSONObject jSONObject, String str, String str2, Map<String, String> map) throws Exception {
        if (jSONObject != null) {
            I5 i5A = B8.a(jSONObject);
            if (i5A.a()) {
                A8.a(i5A, B8.a(context, str, str2, map));
            }
        }
    }

    public static synchronized void addInitListener(Nc nc) {
        Z9 z9 = f9834d;
        if (z9 == null) {
            f9833c.add(nc);
        } else if (z9.b()) {
            nc.onSuccess();
        } else {
            nc.onFail(f9834d.a());
        }
    }

    public static synchronized void destroyAd(M9 m9) throws Exception {
        a();
        f9832b.b(m9);
    }

    public static synchronized e getControllerManager() {
        return f9832b.a();
    }

    public static String getVersion() {
        return SDKUtils.getSDKVersion();
    }

    public static synchronized void initSDK(Context context, String str, String str2, Map<String, String> map) {
        if (TextUtils.isEmpty(str)) {
            Logger.e(f9831a, "applicationKey is NULL");
            return;
        }
        if (f9832b == null) {
            SDKUtils.setInitSDKParams(map);
            try {
                a(context, SDKUtils.getNetworkConfiguration().optJSONObject("events"), str2, str, map);
            } catch (Exception e) {
                C2531r4.d().a(e);
                Logger.e(f9831a, "Failed to init event tracker: " + e.getMessage());
            }
            f9832b = Q9.a(context, str, str2);
        }
    }

    public static synchronized boolean isAdAvailableForInstance(M9 m9) {
        W9 w9 = f9832b;
        if (w9 == null) {
            return false;
        }
        return w9.a(m9);
    }

    public static synchronized void loadAd(M9 m9, Map<String, String> map) throws Exception {
        a();
        f9832b.a(m9, map);
    }

    public static synchronized void loadAdView(Activity activity, M9 m9, Map<String, String> map) throws Exception {
        a();
        f9832b.b(activity, m9, map);
    }

    public static void onPause(Activity activity) {
        W9 w9 = f9832b;
        if (w9 == null) {
            return;
        }
        w9.onPause(activity);
    }

    public static void onResume(Activity activity) {
        W9 w9 = f9832b;
        if (w9 == null) {
            return;
        }
        w9.onResume(activity);
    }

    public static synchronized void release(Activity activity) {
        W9 w9 = f9832b;
        if (w9 == null) {
            return;
        }
        w9.a(activity);
    }

    public static synchronized void showAd(Activity activity, M9 m9, Map<String, String> map) throws Exception {
        a();
        f9832b.a(activity, m9, map);
    }

    public static synchronized void updateInitFailed(C2586u8 c2586u8) {
        try {
            f9834d = new Z9(c2586u8);
            Iterator<Nc> it = f9833c.iterator();
            while (it.hasNext()) {
                it.next().onFail(c2586u8);
            }
            f9833c.clear();
        } catch (Throwable th) {
            throw th;
        }
    }

    public static synchronized void updateInitSucceeded() {
        try {
            f9834d = new Z9();
            Iterator<Nc> it = f9833c.iterator();
            while (it.hasNext()) {
                it.next().onSuccess();
            }
            f9833c.clear();
        } catch (Throwable th) {
            throw th;
        }
    }

    private static synchronized void a() throws Exception {
        if (f9832b == null) {
            throw new NullPointerException("Call initSDK first");
        }
    }
}
