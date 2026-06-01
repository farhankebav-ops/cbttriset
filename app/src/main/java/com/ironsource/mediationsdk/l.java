package com.ironsource.mediationsdk;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.ironsource.C2371i3;
import com.ironsource.C2531r4;
import com.ironsource.C5;
import com.ironsource.D5;
import com.ironsource.E3;
import com.ironsource.H9;
import com.ironsource.Y7;
import com.ironsource.environment.ContextProvider;
import com.ironsource.environment.thread.IronSourceThreadManager;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.unity3d.mediation.adapters.levelplay.LevelPlayBaseAdapter;
import com.vungle.ads.internal.protos.Sdk;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f9204a = "BANNER";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f9205b = "LARGE";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f9206c = "RECTANGLE";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f9207d = "LEADERBOARD";
    public static final String e = "SMART";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f9208f = "CUSTOM";
    public static final String g = "MEDIUM_RECTANGLE";
    public static final String h = "bannerAdSize";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f9209i = 0;
    public static final int j = 1;
    public static final int k = 2;
    public static final int l = 3;
    public static final int m = 4;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f9210n = 5;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f9211o = 6;
    public static final int p = -1;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final String f9212q = "Adaptive=true";

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface a {
        void a(Map<String, Object> map, List<String> list, StringBuilder sb);
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface b {
        void a();

        void a(String str);
    }

    public static void a(q qVar, C2371i3 c2371i3, b bVar) {
        String strConcat;
        if (c(qVar)) {
            strConcat = null;
        } else {
            strConcat = "can't load banner - ".concat(qVar == null ? "banner is null" : "banner is destroyed");
        }
        if (c2371i3 == null || TextUtils.isEmpty(c2371i3.c())) {
            strConcat = "can't load banner - ".concat(c2371i3 == null ? "placement is null" : "placement name is empty");
        }
        if (TextUtils.isEmpty(strConcat)) {
            bVar.a();
        } else {
            IronLog.INTERNAL.error(strConcat);
            bVar.a(strConcat);
        }
    }

    public static boolean c(q qVar) {
        return (qVar == null || qVar.b()) ? false : true;
    }

    public static ISBannerSize b() {
        if (AdapterUtils.isLargeScreen(ContextProvider.getInstance().getApplicationContext())) {
            a(e, 728, 90);
        }
        return a(e, Sdk.SDKError.Reason.WEBVIEW_ERROR_VALUE, 50);
    }

    public static int b(int i2) {
        if (!r.m().O()) {
            IronLog.API.error("The mediation must be successfully initiated before calling this API");
            return -1;
        }
        return a(i2);
    }

    public static void b(q qVar) {
        ISBannerSize size;
        if (qVar == null || (size = qVar.getSize()) == null || !size.isSmart()) {
            return;
        }
        ISBannerSize iSBannerSizeB = b();
        o.f9265a.a(iSBannerSizeB, size.e);
        iSBannerSizeB.setAdaptive(size.isAdaptive());
        qVar.setBannerSize(iSBannerSizeB);
    }

    public static void a(q qVar, b bVar) {
        if (qVar != null && !qVar.b()) {
            bVar.a();
        } else {
            bVar.a("can't destroy banner - ".concat(qVar == null ? "banner is null" : "banner is destroyed"));
        }
    }

    public static long a(long j3, long j8) {
        return j8 - (new Date().getTime() - j3);
    }

    public static ISBannerSize a(String str, int i2, int i8) {
        return new ISBannerSize(str, i2, i8);
    }

    public static ISBannerSize a() {
        return new ISBannerSize(f9207d, 728, 90);
    }

    public static void a(q qVar) {
        if (qVar != null) {
            qVar.a();
        }
    }

    public static void a(q qVar, View view, FrameLayout.LayoutParams layoutParams, E3 e32) {
        if (qVar == null || view == null || layoutParams == null) {
            return;
        }
        Context applicationContext = ContextProvider.getInstance().getApplicationContext();
        IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new androidx.camera.core.processing.concurrent.c(qVar, view, qVar.getSize(), applicationContext, layoutParams, e32, 1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(q qVar, View view, ISBannerSize iSBannerSize, Context context, FrameLayout.LayoutParams layoutParams, E3 e32) {
        try {
            qVar.removeAllViews();
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(view);
            }
            if (iSBannerSize != null) {
                if (iSBannerSize.isAdaptive()) {
                    a(qVar, view, context, iSBannerSize);
                } else {
                    qVar.addView(view, 0, layoutParams);
                }
            }
            if (e32 != null) {
                e32.a();
            }
        } catch (Exception e4) {
            C2531r4.d().a(e4);
            IronLog.INTERNAL.error("Error while binding a banner - " + Log.getStackTraceString(e4));
        }
    }

    public static void a(q qVar, View view, FrameLayout.LayoutParams layoutParams) {
        a(qVar, view, layoutParams, (E3) null);
    }

    private static void a(q qVar, View view, Context context, ISBannerSize iSBannerSize) {
        int iDpToPixels = AdapterUtils.dpToPixels(context, iSBannerSize.e.d());
        int iDpToPixels2 = AdapterUtils.dpToPixels(context, iSBannerSize.e.c());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(iDpToPixels, iDpToPixels2);
        RelativeLayout relativeLayout = new RelativeLayout(context);
        relativeLayout.setLayoutParams(layoutParams);
        relativeLayout.setGravity(17);
        relativeLayout.addView(view, 0);
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) qVar.getLayoutParams();
        if (layoutParams2 == null) {
            layoutParams2 = new FrameLayout.LayoutParams(iDpToPixels, iDpToPixels2);
        }
        layoutParams2.height = iDpToPixels2;
        layoutParams2.width = iDpToPixels;
        layoutParams2.gravity = 17;
        qVar.setLayoutParams(layoutParams2);
        IronLog.INTERNAL.verbose("containerParams height - " + iSBannerSize.e.c() + " width - " + iSBannerSize.e.d());
        qVar.addView(relativeLayout, 0, layoutParams2);
    }

    public static int a(int i2) {
        int iA = -1;
        try {
            iA = a(a(c.b()), i2);
            a(i2, iA);
            IronLog.API.verbose("Maximal height - " + iA + " for width - " + i2);
            return iA;
        } catch (Exception e4) {
            C2531r4.d().a(e4);
            IronLog.INTERNAL.error("Failed to get adaptive height: " + e4.getMessage());
            return iA;
        }
    }

    private static Map<String, Object> a(c cVar) {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        concurrentHashMap.putAll(cVar.a());
        concurrentHashMap.putAll(cVar.c());
        return concurrentHashMap;
    }

    private static int a(Map<String, Object> map, int i2) {
        int iMax = -1;
        for (Object obj : map.values()) {
            try {
                iMax = Math.max(iMax, a(obj, i2));
            } catch (Throwable th) {
                a(obj, th);
            }
        }
        return iMax;
    }

    private static int a(Object obj, int i2) {
        if (obj instanceof AbstractAdapter) {
            return ((AbstractAdapter) obj).getAdaptiveHeight(i2);
        }
        if (obj instanceof LevelPlayBaseAdapter) {
            return ((LevelPlayBaseAdapter) obj).getAdaptiveHeight(i2);
        }
        return -1;
    }

    private static void a(Object obj, Throwable th) {
        String simpleName = obj != null ? obj.getClass().getSimpleName() : "unknown";
        C2531r4.d().a(th);
        IronLog ironLog = IronLog.INTERNAL;
        StringBuilder sbY = a1.a.y("Exception while calling getAdaptiveHeight for adapter - ", simpleName, ": ");
        sbY.append(th.getMessage());
        ironLog.error(sbY.toString());
    }

    private static void a(int i2, int i8) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(IronSourceConstants.EVENTS_PROVIDER, "Mediation");
            if (i8 == -1) {
                jSONObject.put(IronSourceConstants.EVENTS_ERROR_CODE, 2);
                jSONObject.put("reason", "No networks found supporting adaptive banners");
            } else {
                jSONObject.put(IronSourceConstants.EVENTS_EXT1, "w:" + i2 + ",h:" + i8);
            }
            H9.i().a(new C5(D5.BN_GET_MAXIMAL_ADAPTIVE_HEIGHT, jSONObject));
        } catch (Exception e4) {
            C2531r4.d().a(e4);
            IronLog.INTERNAL.error(e4.toString());
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static void a(Map<String, Object> map, ISBannerSize iSBannerSize) {
        if (iSBannerSize != null) {
            try {
                String description = iSBannerSize.getDescription();
                switch (description.hashCode()) {
                    case -387072689:
                        if (description.equals(f9206c)) {
                            map.put(h, 3);
                        }
                        break;
                    case 72205083:
                        if (description.equals(f9205b)) {
                            map.put(h, 2);
                        }
                        break;
                    case 79011241:
                        if (description.equals(e)) {
                            map.put(h, 5);
                        }
                        break;
                    case 446888797:
                        if (description.equals(f9207d)) {
                            map.put(h, 4);
                        }
                        break;
                    case 1951953708:
                        if (description.equals(f9204a)) {
                            map.put(h, 1);
                        }
                        break;
                    case 1999208305:
                        if (description.equals("CUSTOM")) {
                            map.put(h, 6);
                            map.put("custom_banner_size", iSBannerSize.getWidth() + "x" + iSBannerSize.getHeight());
                        }
                        break;
                }
                if (iSBannerSize.isAdaptive()) {
                    String strA = a(iSBannerSize);
                    if (map.containsKey(IronSourceConstants.EVENTS_EXT1)) {
                        strA = map.get(IronSourceConstants.EVENTS_EXT1) + " , " + a(iSBannerSize);
                    }
                    map.put(IronSourceConstants.EVENTS_EXT1, strA);
                }
            } catch (Exception e4) {
                C2531r4.d().a(e4);
                IronLog.INTERNAL.error(Log.getStackTraceString(e4));
            }
        }
    }

    public static String a(ISBannerSize iSBannerSize) {
        return "Adaptive=true, size: " + iSBannerSize.e.d() + "x" + iSBannerSize.e.c() + "; fallback: " + iSBannerSize.getDescription() + ", size: " + iSBannerSize.getWidth() + "x" + iSBannerSize.getHeight() + ";";
    }

    public static boolean a(Y7 y7, int i2, int i8) {
        if (y7 != null && y7.d() > 0 && y7.c() > 0) {
            if (y7.d() >= i2 && y7.c() >= i8) {
                return true;
            }
            IronLog.API.warning("Container size too small: Banner may not display correctly.");
            return true;
        }
        IronLog.API.warning("Container size is invalid: Default banner size will be used.");
        return false;
    }
}
