package com.ironsource.sdk.utils;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Environment;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import com.bumptech.glide.load.Key;
import com.ironsource.B7;
import com.ironsource.C2300e4;
import com.ironsource.C2346ge;
import com.ironsource.C2531r4;
import com.ironsource.C2569t8;
import com.ironsource.Mb;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.sdk.controller.ControllerActivity;
import com.ironsource.sdk.controller.OpenUrlActivity;
import com.unity3d.ads.core.data.datasource.AndroidStaticDeviceInfoDataSource;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class SDKUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f10216a = "SDKUtils";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static String f10217b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static String f10218c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static String f10219d = null;
    private static String e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static int f10220f = 0;
    private static String g = null;
    private static Map<String, String> h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static String f10221i = "";
    private static final AtomicInteger j = new AtomicInteger(1);

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class a implements DialogInterface.OnClickListener {
        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            dialogInterface.dismiss();
        }
    }

    private static int a() {
        AtomicInteger atomicInteger;
        int i2;
        int i8;
        do {
            atomicInteger = j;
            i2 = atomicInteger.get();
            i8 = i2 + 1;
            if (i8 > 16777215) {
                i8 = 1;
            }
        } while (!atomicInteger.compareAndSet(i2, i8));
        return i2;
    }

    public static int convertDpToPx(int i2) {
        return (int) TypedValue.applyDimension(0, i2, Resources.getSystem().getDisplayMetrics());
    }

    public static int convertPxToDp(int i2) {
        return (int) TypedValue.applyDimension(1, i2, Resources.getSystem().getDisplayMetrics());
    }

    public static String decodeString(String str) {
        try {
            return URLDecoder.decode(str, Key.STRING_CHARSET_NAME);
        } catch (UnsupportedEncodingException e4) {
            C2531r4.d().a(e4);
            Logger.d(f10216a, "Failed decoding string " + e4.getMessage());
            return "";
        }
    }

    public static int dpToPx(long j3) {
        return (int) ((j3 * Resources.getSystem().getDisplayMetrics().density) + 0.5f);
    }

    public static String encodeString(String str) {
        try {
            return URLEncoder.encode(str, Key.STRING_CHARSET_NAME).replace("+", "%20");
        } catch (UnsupportedEncodingException e4) {
            C2531r4.d().a(e4);
            return "";
        }
    }

    public static byte[] encrypt(String str) {
        MessageDigest messageDigest;
        try {
            messageDigest = MessageDigest.getInstance(AndroidStaticDeviceInfoDataSource.ALGORITHM_SHA1);
        } catch (UnsupportedEncodingException e4) {
            e = e4;
            messageDigest = null;
        } catch (NoSuchAlgorithmException e8) {
            e = e8;
            messageDigest = null;
        }
        try {
            messageDigest.reset();
            messageDigest.update(str.getBytes(Key.STRING_CHARSET_NAME));
        } catch (UnsupportedEncodingException e9) {
            e = e9;
            C2531r4.d().a(e);
            IronLog.INTERNAL.error(e.toString());
        } catch (NoSuchAlgorithmException e10) {
            e = e10;
            C2531r4.d().a(e);
            IronLog.INTERNAL.error(e.toString());
        }
        if (messageDigest != null) {
            return messageDigest.digest();
        }
        return null;
    }

    public static String fetchDemandSourceId(C2346ge c2346ge) {
        return fetchDemandSourceId(c2346ge.a());
    }

    public static String flatMapToJsonAsString(Map<String, String> map) {
        JSONObject jSONObject = new JSONObject();
        if (map != null) {
            Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<String, String> next = it.next();
                try {
                    jSONObject.putOpt(next.getKey(), encodeString(next.getValue()));
                } catch (JSONException e4) {
                    C2531r4.d().a(e4);
                    Logger.i(f10216a, "flatMapToJsonAsStringfailed " + e4.toString());
                }
                it.remove();
            }
        }
        return jSONObject.toString();
    }

    public static int generateViewId() {
        return View.generateViewId();
    }

    public static int getActivityUIFlags(boolean z2) {
        return z2 ? 5894 : 1798;
    }

    public static String getAdvertiserId() {
        return f10217b;
    }

    public static String getControllerConfig() {
        return g;
    }

    public static JSONObject getControllerConfigAsJSONObject() {
        try {
            return new JSONObject(getControllerConfig());
        } catch (Exception e4) {
            C2531r4.d().a(e4);
            IronLog.INTERNAL.error(e4.toString());
            return new JSONObject();
        }
    }

    public static String getControllerUrl() {
        return !TextUtils.isEmpty(e) ? e : !TextUtils.isEmpty(f10219d) ? f10219d : "";
    }

    public static int getDebugMode() {
        return f10220f;
    }

    public static String getFileName(String str) {
        try {
            return URLEncoder.encode(str.split(File.separator)[r1.length - 1].split("\\?")[0], Key.STRING_CHARSET_NAME);
        } catch (UnsupportedEncodingException e4) {
            C2531r4.d().a(e4);
            IronLog.INTERNAL.error(e4.toString());
            return null;
        }
    }

    public static Map<String, String> getInitSDKParams() {
        return h;
    }

    public static String getLimitAdTracking() {
        return f10218c;
    }

    public static String getMD5(String str) {
        try {
            String string = new BigInteger(1, MessageDigest.getInstance("MD5").digest(str.getBytes())).toString(16);
            while (string.length() < 32) {
                string = "0" + string;
            }
            return string;
        } catch (NoSuchAlgorithmException e4) {
            C2531r4.d().a(e4);
            throw new RuntimeException(e4);
        }
    }

    public static int getMinOSVersionSupport() {
        return getControllerConfigAsJSONObject().optInt(C2300e4.d.f8326b);
    }

    public static JSONObject getNetworkConfiguration() {
        JSONObject jSONObject = new JSONObject();
        try {
            return getControllerConfigAsJSONObject().getJSONObject(C2300e4.a.f8292b);
        } catch (Exception e4) {
            C2531r4.d().a(e4);
            IronLog.INTERNAL.error(e4.toString());
            return jSONObject;
        }
    }

    public static JSONObject getOrientation(Context context) {
        B7 b7I = Mb.U().i();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("orientation", translateOrientation(b7I.z(context)));
            return jSONObject;
        } catch (Exception e4) {
            C2531r4.d().a(e4);
            IronLog.INTERNAL.error(e4.toString());
            return jSONObject;
        }
    }

    public static C2569t8.e getProductType(String str) {
        C2569t8.e eVar = C2569t8.e.RewardedVideo;
        if (str.equalsIgnoreCase(eVar.toString())) {
            return eVar;
        }
        C2569t8.e eVar2 = C2569t8.e.Interstitial;
        if (str.equalsIgnoreCase(eVar2.toString())) {
            return eVar2;
        }
        return null;
    }

    public static String getSDKVersion() {
        return "9.0.0";
    }

    public static String getTesterParameters() {
        return f10221i;
    }

    public static String getValueFromJsonObject(String str, String str2) {
        try {
            return new JSONObject(str).getString(str2);
        } catch (Exception e4) {
            C2531r4.d().a(e4);
            return null;
        }
    }

    public static boolean isApplicationVisible(Context context) {
        String packageName = context.getPackageName();
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        if (activityManager == null) {
            return false;
        }
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : activityManager.getRunningAppProcesses()) {
            if (runningAppProcessInfo.processName.equalsIgnoreCase(packageName) && runningAppProcessInfo.importance == 100) {
                return true;
            }
        }
        return false;
    }

    public static boolean isExternalStorageAvailable() {
        try {
            String externalStorageState = Environment.getExternalStorageState();
            if ("mounted".equals(externalStorageState)) {
                return true;
            }
            return "mounted_ro".equals(externalStorageState);
        } catch (Exception e4) {
            C2531r4.d().a(e4);
            return false;
        }
    }

    public static boolean isIronSourceActivity(Activity activity) {
        return (activity instanceof ControllerActivity) || (activity instanceof OpenUrlActivity);
    }

    public static void loadGoogleAdvertiserInfo(Context context) {
        B7 b7I = Mb.U().i();
        String strI = b7I.I(context);
        String strB = b7I.b(context);
        if (!TextUtils.isEmpty(strI)) {
            f10217b = strI;
        }
        if (TextUtils.isEmpty(strB)) {
            return;
        }
        f10218c = strB;
    }

    public static Map<String, String> mergeHashMaps(Map<String, String>[] mapArr) {
        HashMap map = new HashMap();
        if (mapArr != null) {
            for (Map<String, String> map2 : mapArr) {
                if (map2 != null) {
                    map.putAll(map2);
                }
            }
        }
        return map;
    }

    public static JSONObject mergeJSONObjects(JSONObject jSONObject, JSONObject jSONObject2) throws Exception {
        JSONObject jSONObject3 = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        if (jSONObject != null) {
            jSONObject3 = new JSONObject(jSONObject.toString());
        }
        if (jSONObject2 != null) {
            jSONArray = jSONObject2.names();
        }
        if (jSONArray != null) {
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                String string = jSONArray.getString(i2);
                jSONObject3.putOpt(string, jSONObject2.opt(string));
            }
        }
        return jSONObject3;
    }

    public static int pxToDp(long j3) {
        return (int) ((j3 / Resources.getSystem().getDisplayMetrics().density) + 0.5f);
    }

    public static String requireNonEmptyOrNull(String str, String str2) {
        if (str != null) {
            return str;
        }
        throw new NullPointerException(str2);
    }

    public static <T> T requireNonNull(T t3, String str) {
        if (t3 != null) {
            return t3;
        }
        throw new NullPointerException(str);
    }

    public static void setControllerConfig(String str) {
        g = str;
        Mb.O().y().a(getControllerConfigAsJSONObject());
    }

    public static void setControllerUrl(String str) {
        f10219d = str;
    }

    public static void setCustomControllerUrl(String str) {
        e = str;
    }

    public static void setDebugMode(int i2) {
        f10220f = i2;
    }

    public static void setInitSDKParams(Map<String, String> map) {
        h = map;
    }

    public static void setTesterParameters(String str) {
        f10221i = str;
    }

    public static void showNoInternetDialog(Context context) {
        new AlertDialog.Builder(context).setMessage("No Internet Connection").setPositiveButton("Ok", new a()).show();
    }

    public static String translateDeviceOrientation(int i2) {
        return i2 != 1 ? i2 != 2 ? "none" : C2300e4.h.C : C2300e4.h.D;
    }

    public static String translateOrientation(int i2) {
        return i2 != 1 ? i2 != 2 ? "none" : C2300e4.h.C : C2300e4.h.D;
    }

    public static String translateRequestedOrientation(int i2) {
        if (i2 == 0) {
            return C2300e4.h.C;
        }
        if (i2 == 1) {
            return C2300e4.h.D;
        }
        if (i2 == 11) {
            return C2300e4.h.C;
        }
        if (i2 == 12) {
            return C2300e4.h.D;
        }
        switch (i2) {
            case 6:
            case 8:
                return C2300e4.h.C;
            case 7:
            case 9:
                return C2300e4.h.D;
            default:
                return "none";
        }
    }

    public static void updateControllerConfig(String str, JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = new JSONObject(g);
            jSONObject2.put(str, jSONObject);
            g = jSONObject2.toString();
        } catch (JSONException e4) {
            C2531r4.d().a(e4);
            Logger.i(f10216a, "Unable to update controllerConfigs: " + e4.toString());
        }
    }

    public static String fetchDemandSourceId(JSONObject jSONObject) {
        String strOptString = jSONObject.optString("demandSourceId");
        return !TextUtils.isEmpty(strOptString) ? strOptString : jSONObject.optString("demandSourceName");
    }
}
