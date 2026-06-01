package com.bytedance.sdk.openadsdk.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.WebView;
import com.ironsource.Q6;
import com.ironsource.mediationsdk.metadata.a;
import com.unity3d.services.core.fid.Constants;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class lEW {
    private static final AtomicReference<Boolean> IlO = new AtomicReference<>(null);
    private static final AtomicReference<String> MY = new AtomicReference<>(null);

    /* JADX WARN: Failed to find 'out' block for switch in B:28:0x0057. Please report as an issue. */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00ca  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean Bc(android.content.Context r9) {
        /*
            Method dump skipped, instruction units count: 276
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.utils.lEW.Bc(android.content.Context):boolean");
    }

    public static String Cc(Context context) {
        try {
            AtomicReference<String> atomicReference = MY;
            String str = atomicReference.get();
            if (str != null) {
                return str;
            }
            PackageInfo packageInfoVCE = vCE(context);
            String str2 = packageInfoVCE != null ? packageInfoVCE.versionName : "";
            while (!atomicReference.compareAndSet(null, str2) && atomicReference.get() == null) {
            }
            return str2;
        } catch (Throwable unused) {
            AtomicReference<String> atomicReference2 = MY;
            while (!atomicReference2.compareAndSet(null, "") && atomicReference2.get() == null) {
            }
            return "";
        }
    }

    private static boolean DmF(Context context) {
        try {
            Class.forName("io.flutter.embedding.android.FlutterActivity");
            return true;
        } catch (ClassNotFoundException unused) {
            if (context == null) {
                return false;
            }
            try {
                return new File(context.getApplicationInfo().nativeLibraryDir + "/libflutter.so").exists();
            } catch (Throwable unused2) {
                return false;
            }
        }
    }

    public static String EO(Context context) {
        try {
            return String.valueOf(context.getApplicationInfo().targetSdkVersion);
        } catch (Throwable unused) {
            return "";
        }
    }

    private static PackageInfo EV(Context context) {
        try {
            String str = Build.VERSION.SDK_INT <= 23 ? (String) Class.forName("android.webkit.WebViewFactory").getMethod("getWebViewPackageName", null).invoke(null, null) : (String) Class.forName("android.webkit.WebViewUpdateService").getMethod("getCurrentWebViewPackageName", null).invoke(null, null);
            if (str == null) {
                return null;
            }
            return context.getPackageManager().getPackageInfo(str, 0);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void IlO(Context context) {
        if (context == null) {
            return;
        }
        try {
            if (MY()) {
                com.bytedance.sdk.openadsdk.core.EO eoIlO = com.bytedance.sdk.openadsdk.core.EO.IlO(context);
                eoIlO.IlO("w_ver", Cc(context));
                eoIlO.IlO("bp", MY(context));
                eoIlO.IlO("is_fold", Bc(context) ? 1 : 0);
                eoIlO.IlO("abi", IlO());
                eoIlO.IlO("t_ver", EO(context));
                eoIlO.IlO("aab", tV(context));
            }
        } catch (Throwable unused) {
        }
    }

    public static int MY(Context context) {
        if (lEW(context)) {
            return 1;
        }
        if (DmF(context)) {
            return 2;
        }
        return NV(context) ? 3 : 4;
    }

    private static boolean NV(Context context) {
        try {
            Class.forName("com.facebook.react.ReactActivity");
            return true;
        } catch (ClassNotFoundException unused) {
            if (context == null) {
                return false;
            }
            try {
                return new File(context.getApplicationInfo().nativeLibraryDir + "/libreactnativejni.so").exists();
            } catch (Throwable unused2) {
                return false;
            }
        }
    }

    private static boolean lEW(Context context) {
        try {
            Class.forName("com.unity3d.player.UnityPlayerActivity");
            return true;
        } catch (ClassNotFoundException unused) {
            if (context == null) {
                return false;
            }
            try {
                return new File(context.getApplicationInfo().nativeLibraryDir + "/libunity.so").exists();
            } catch (Throwable unused2) {
                return false;
            }
        }
    }

    public static int tV(Context context) {
        try {
            Class.forName("com.google.android.play.core.splitinstall.SplitInstallManager");
            return 1;
        } catch (ClassNotFoundException unused) {
            return 0;
        }
    }

    public static PackageInfo vCE(Context context) {
        try {
            if (Build.VERSION.SDK_INT >= 26) {
                return WebView.getCurrentWebViewPackage();
            }
            PackageInfo packageInfo = (PackageInfo) Class.forName("android.webkit.WebViewFactory").getMethod("getLoadedPackageInfo", null).invoke(null, null);
            return packageInfo != null ? packageInfo : EV(context);
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            return null;
        }
    }

    private static boolean tV() {
        if (EV()) {
            return true;
        }
        String[] strArr = {"sm-f9000", "sm-f9160", "sm-f9260", "sm-f9360", "sm-f9460", "sm-f9560", "sm-f7000", "sm-f7070", "sm-f7110", "sm-f7210", "sm-f7310", "sm-f7410"};
        String[] strArr2 = {"winner", "f2q", "q2q", "q4q", "q5q", "q6q", "bloomq", "bloomxq", "b2q", "b4q", "b5q", "b6q"};
        try {
            String lowerCase = Build.DEVICE.toLowerCase();
            if (!TextUtils.isEmpty(lowerCase)) {
                for (int i2 = 0; i2 < 12; i2++) {
                    if (lowerCase.contains(strArr2[i2])) {
                        return true;
                    }
                }
            }
            String lowerCase2 = Build.MODEL.toLowerCase();
            if (TextUtils.isEmpty(lowerCase2)) {
                return false;
            }
            for (int i8 = 0; i8 < 12; i8++) {
                if (lowerCase2.contains(strArr[i8])) {
                    return true;
                }
            }
            if (MY()) {
                String strIlO = com.bytedance.sdk.openadsdk.AXM.IlO.IlO("fold_config", "fold_samung", "");
                if (TextUtils.isEmpty(strIlO)) {
                    return false;
                }
                for (String str : strIlO.split(",")) {
                    if (lowerCase2.contains(str)) {
                        return true;
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    private static boolean DmF() {
        if (NV()) {
            return true;
        }
        String[] strArr = {"CPH2439", "CPH2437", "CPH2499", "CPH2519", "PEUM00", "PGU110", "PGT110", "PHN110", "PHT110"};
        try {
            String lowerCase = Build.MODEL.toLowerCase();
            if (!TextUtils.isEmpty(lowerCase)) {
                for (int i2 = 0; i2 < 9; i2++) {
                    if (lowerCase.contains(strArr[i2].toLowerCase())) {
                        return true;
                    }
                }
                if (MY()) {
                    String strEO = EO();
                    if (TextUtils.isEmpty(strEO)) {
                        return false;
                    }
                    for (String str : strEO.split(",")) {
                        if (lowerCase.contains(str.toLowerCase())) {
                            return true;
                        }
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static String EO() {
        return com.bytedance.sdk.openadsdk.AXM.IlO.IlO("fold_config", "fold_default", "");
    }

    public static boolean MY() {
        return com.bytedance.sdk.openadsdk.AXM.IlO.IlO("fold_config", a.j, 0) == 1;
    }

    private static boolean NV() {
        try {
            Class<?> cls = Class.forName("com.oplus.content.OplusFeatureConfigManager");
            Object objInvoke = cls.getDeclaredMethod("hasFeature", String.class).invoke(cls.getMethod(Constants.GET_INSTANCE, null).invoke(null, null), "oplus.hardware.type.fold");
            if (objInvoke instanceof Boolean) {
                return ((Boolean) objInvoke).booleanValue();
            }
        } catch (ClassNotFoundException e) {
            e = e;
            com.bytedance.sdk.component.utils.oeT.EO("BED", "get oppo fold properties error, msg: " + e.getMessage());
        } catch (IllegalAccessException e4) {
            e = e4;
            com.bytedance.sdk.component.utils.oeT.EO("BED", "get oppo fold properties error, msg: " + e.getMessage());
        } catch (NoSuchMethodException e8) {
            e = e8;
            com.bytedance.sdk.component.utils.oeT.EO("BED", "get oppo fold properties error, msg: " + e.getMessage());
        } catch (InvocationTargetException e9) {
            e = e9;
            com.bytedance.sdk.component.utils.oeT.EO("BED", "get oppo fold properties error, msg: " + e.getMessage());
        } catch (Throwable unused) {
        }
        return false;
    }

    private static boolean lEW() {
        try {
            return ((Integer) Class.forName("android.os.SystemProperties").getMethod("getInt", String.class, Integer.TYPE).invoke(null, "persist.sys.muiltdisplay_type", 0)).intValue() == 2;
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.oeT.EO("BED", "isXiaomiFold return false " + th.getMessage());
            return false;
        }
    }

    private static boolean Cc() {
        if (lEW()) {
            return true;
        }
        String[] strArr = {"M2011J18C", "22061218C", "2308CPXD0C", "24072PX77C", "2405CPX3DC", "2405CPX3DG"};
        try {
            String lowerCase = Build.MODEL.toLowerCase();
            if (!TextUtils.isEmpty(lowerCase)) {
                for (int i2 = 0; i2 < 6; i2++) {
                    if (lowerCase.contains(strArr[i2])) {
                        return true;
                    }
                }
                if (MY()) {
                    String strEO = EO();
                    if (TextUtils.isEmpty(strEO)) {
                        return false;
                    }
                    for (String str : strEO.split(",")) {
                        if (lowerCase.contains(str)) {
                            return true;
                        }
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    private static boolean vCE() {
        if (Bc()) {
            return true;
        }
        String[] strArr = {"V2330", "V2178A", "V2229A", "V2303A", "V2337A", "V2256A", "V2266A"};
        try {
            String lowerCase = Build.MODEL.toLowerCase();
            if (!TextUtils.isEmpty(lowerCase)) {
                for (int i2 = 0; i2 < 7; i2++) {
                    if (lowerCase.contains(strArr[i2].toLowerCase())) {
                        return true;
                    }
                }
                if (MY()) {
                    String strEO = EO();
                    if (TextUtils.isEmpty(strEO)) {
                        return false;
                    }
                    for (String str : strEO.split(",")) {
                        if (lowerCase.contains(str.toLowerCase())) {
                            return true;
                        }
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    private static boolean EV() {
        try {
            Class<?> cls = Class.forName("com.samsung.android.feature.SemFloatingFeature");
            Object objInvoke = cls.getMethod(Constants.GET_INSTANCE, null).invoke(null, null);
            Method declaredMethod = cls.getDeclaredMethod("getString", String.class);
            if ("TRUE".equalsIgnoreCase((String) declaredMethod.invoke(objInvoke, "SEC_FLOATING_FEATURE_FRAMEWORK_SUPPORT_FOLDABLE_TYPE_FOLD"))) {
                return true;
            }
            return "TRUE".equalsIgnoreCase((String) declaredMethod.invoke(objInvoke, "SEC_FLOATING_FEATURE_FRAMEWORK_SUPPORT_FOLDABLE_TYPE_FLIP"));
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            com.bytedance.sdk.component.utils.oeT.EO("PAG_BANNER", "get ss fold device error: " + e.getMessage());
            return false;
        }
    }

    public static String IlO() {
        try {
            return Build.SUPPORTED_ABIS[0];
        } catch (Exception unused) {
            return "";
        }
    }

    public static void IlO(JSONObject jSONObject, Context context) {
        if (context == null) {
            return;
        }
        try {
            if (MY()) {
                com.bytedance.sdk.openadsdk.core.EO eoIlO = com.bytedance.sdk.openadsdk.core.EO.IlO(context);
                String strMY = eoIlO.MY(Q6.f7470u, com.bytedance.sdk.openadsdk.core.DmF.MY().Bc());
                if (!TextUtils.isEmpty(strMY)) {
                    jSONObject.put(Q6.f7470u, strMY);
                }
                int iMY = eoIlO.MY("bp", MY(context));
                if (iMY != 4) {
                    jSONObject.put("bp", iMY);
                }
                String strMY2 = eoIlO.MY("t_ver", EO(context));
                if (!TextUtils.isEmpty(strMY2)) {
                    jSONObject.put("t_ver", strMY2);
                }
                jSONObject.put("is_fold", eoIlO.MY("is_fold", Bc(context) ? 1 : 0));
                jSONObject.put("aab", eoIlO.MY("aab", tV(context)));
                String strMY3 = eoIlO.MY("w_ver", Cc(context));
                if (!TextUtils.isEmpty(strMY3)) {
                    jSONObject.put("w_ver", strMY3);
                }
                String strMY4 = eoIlO.MY("abi", IlO());
                if (TextUtils.isEmpty(strMY4)) {
                    return;
                }
                jSONObject.put("abi", strMY4);
            }
        } catch (Throwable unused) {
        }
    }

    private static boolean Bc() {
        try {
            return "foldable".equals(Class.forName("android.util.FtDeviceInfo").getMethod("getDeviceType", null).invoke(null, null));
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.oeT.EO("BED", "isVIVOFoldDevice return false " + th.getMessage());
            return false;
        }
    }
}
