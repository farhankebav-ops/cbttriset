package com.ironsource;

import android.content.Context;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import com.ironsource.mediationsdk.logger.IronLog;

/* JADX INFO: renamed from: com.ironsource.a4, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class C2228a4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f7945a = "3g";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f7946b = "wifi";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f7947c = "none";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f7948d = "bluetooth";
    public static final String e = "ethernet";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f7949f = "vpn";
    public static final String g = "cellular";
    public static final String h = "wifiAware";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String f7950i = "lowpan";

    public static String a(Context context) {
        ConnectivityManager connectivityManager;
        StringBuilder sb = new StringBuilder();
        if (context != null && (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) != null) {
            try {
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                    String typeName = activeNetworkInfo.getTypeName();
                    int type = activeNetworkInfo.getType();
                    if (type == 0) {
                        sb.append(f7945a);
                    } else if (type == 1) {
                        sb.append(f7946b);
                    } else {
                        sb.append(typeName);
                    }
                }
            } catch (Exception e4) {
                C2531r4.d().a(e4);
                IronLog.INTERNAL.error(e4.toString());
            }
        }
        return sb.toString();
    }

    public static int b(Context context) {
        if (context == null) {
            return -1;
        }
        try {
            return context.getResources().getConfiguration().mcc;
        } catch (Exception e4) {
            C2531r4.d().a(e4);
            IronLog.INTERNAL.error(e4.toString());
            return -1;
        }
    }

    public static int c(Context context) {
        if (context == null) {
            return -1;
        }
        try {
            return context.getResources().getConfiguration().mnc;
        } catch (Exception e4) {
            C2531r4.d().a(e4);
            IronLog.INTERNAL.error(e4.toString());
            return -1;
        }
    }

    public static String d(Context context) {
        if (context == null) {
            return "";
        }
        try {
            return ((TelephonyManager) context.getSystemService("phone")).getNetworkOperator();
        } catch (Exception e4) {
            C2531r4.d().a(e4);
            IronLog.INTERNAL.error(e4.toString());
            return "";
        }
    }

    public static int e(Context context) {
        PackageManager packageManager = context.getPackageManager();
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (Build.VERSION.SDK_INT < 24 || (packageManager.checkPermission("android.permission.READ_PHONE_STATE", context.getPackageName()) != 0 && packageManager.checkPermission("android.permission.READ_BASIC_PHONE_STATE", context.getPackageName()) != 0)) {
                return -1;
            }
            return telephonyManager.getDataNetworkType();
        } catch (Exception e4) {
            C2531r4.d().a(e4);
            IronLog.INTERNAL.error(e4.toString());
            return -1;
        }
    }

    public static int f(Context context) {
        if (context == null) {
            return -1;
        }
        try {
            return ((TelephonyManager) context.getSystemService("phone")).getPhoneType();
        } catch (Exception e4) {
            C2531r4.d().a(e4);
            IronLog.INTERNAL.error(e4.toString());
            return -1;
        }
    }

    public static String g(Context context) {
        if (context == null) {
            return "";
        }
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            return telephonyManager != null ? telephonyManager.getSimOperator() : "";
        } catch (Exception e4) {
            C2531r4.d().a(e4);
            IronLog.INTERNAL.error(e4.toString());
            return "";
        }
    }

    public static boolean h(Context context) {
        ConnectivityManager connectivityManager;
        if (context == null || (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) == null) {
            return false;
        }
        try {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                if (activeNetworkInfo.isConnected()) {
                    return true;
                }
            }
            return false;
        } catch (Exception e4) {
            C2531r4.d().a(e4);
            IronLog.INTERNAL.error(e4.toString());
            return false;
        }
    }

    public static boolean i(Context context) {
        ConnectivityManager connectivityManager;
        NetworkInfo networkInfo;
        return (context == null || (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) == null || (networkInfo = connectivityManager.getNetworkInfo(0)) == null || !networkInfo.isConnected()) ? false : true;
    }

    public static boolean j(Context context) {
        ConnectivityManager connectivityManager;
        NetworkInfo networkInfo;
        return (context == null || (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) == null || (networkInfo = connectivityManager.getNetworkInfo(1)) == null || !networkInfo.isConnected()) ? false : true;
    }
}
