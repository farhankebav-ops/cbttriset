package com.vungle.ads.internal.platform;

import android.content.Context;
import android.hardware.SensorManager;
import android.net.ConnectivityManager;
import android.net.LinkProperties;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.ProxyInfo;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import java.util.Locale;
import kotlin.jvm.internal.k;
import n6.m;
import r2.q;
import r5.j;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class DeviceCheckUtils {
    public static final DeviceCheckUtils INSTANCE = new DeviceCheckUtils();

    private DeviceCheckUtils() {
    }

    private final boolean isEnabled(ProxyInfo proxyInfo) {
        if (proxyInfo == null) {
            return false;
        }
        String host = proxyInfo.getHost();
        return (host != null && host.length() > 0 && proxyInfo.getPort() > 0) || (proxyInfo.getPacFileUrl() != null && !k.a(proxyInfo.getPacFileUrl(), Uri.EMPTY));
    }

    public final int getSensorCount(Context context) {
        k.e(context, "context");
        Object systemService = context.getSystemService("sensor");
        k.c(systemService, "null cannot be cast to non-null type android.hardware.SensorManager");
        return ((SensorManager) systemService).getSensorList(-1).size();
    }

    public final boolean hasSystemAlertWindowPermission(Context context) {
        k.e(context, "context");
        return Settings.canDrawOverlays(context);
    }

    public final boolean isEmulator() {
        String lowerCase;
        String lowerCase2;
        String lowerCase3;
        String lowerCase4;
        String lowerCase5;
        String str = Build.FINGERPRINT;
        String lowerCase6 = "";
        if (str != null) {
            lowerCase = str.toLowerCase(Locale.ROOT);
            k.d(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        } else {
            lowerCase = "";
        }
        String str2 = Build.MODEL;
        if (str2 != null) {
            lowerCase2 = str2.toLowerCase(Locale.ROOT);
            k.d(lowerCase2, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        } else {
            lowerCase2 = "";
        }
        String str3 = Build.PRODUCT;
        if (str3 != null) {
            lowerCase3 = str3.toLowerCase(Locale.ROOT);
            k.d(lowerCase3, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        } else {
            lowerCase3 = "";
        }
        String str4 = Build.BRAND;
        if (str4 != null) {
            lowerCase4 = str4.toLowerCase(Locale.ROOT);
            k.d(lowerCase4, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        } else {
            lowerCase4 = "";
        }
        String str5 = Build.MANUFACTURER;
        if (str5 != null) {
            lowerCase5 = str5.toLowerCase(Locale.ROOT);
            k.d(lowerCase5, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        } else {
            lowerCase5 = "";
        }
        String str6 = Build.BOARD;
        if (str6 != null) {
            lowerCase6 = str6.toLowerCase(Locale.ROOT);
            k.d(lowerCase6, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        }
        String[] SUPPORTED_ABIS = Build.SUPPORTED_ABIS;
        k.d(SUPPORTED_ABIS, "SUPPORTED_ABIS");
        String lowerCase7 = j.r0(SUPPORTED_ABIS).toLowerCase(Locale.ROOT);
        k.d(lowerCase7, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        return m.q0(lowerCase, "generic", false) || m.q0(lowerCase, "emulator", false) || m.q0(lowerCase2, "google_sdk", false) || m.q0(lowerCase2, "emulator", false) || m.q0(lowerCase3, "sdk", false) || m.q0(lowerCase3, "vbox", false) || m.q0(lowerCase4, "generic", false) || m.q0(lowerCase5, "genymotion", false) || m.q0(lowerCase6, "nox", false) || m.q0(lowerCase7, "x86", false);
    }

    public final boolean isProxyEnabled(Context context) {
        Object objM;
        boolean zIsEnabled;
        k.e(context, "context");
        try {
            Object systemService = context.getSystemService("connectivity");
            k.c(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
            ConnectivityManager connectivityManager = (ConnectivityManager) systemService;
            Network activeNetwork = connectivityManager.getActiveNetwork();
            if (activeNetwork == null) {
                zIsEnabled = false;
            } else {
                LinkProperties linkProperties = connectivityManager.getLinkProperties(activeNetwork);
                zIsEnabled = isEnabled(linkProperties != null ? linkProperties.getHttpProxy() : null);
            }
            objM = Boolean.valueOf(zIsEnabled);
        } catch (Throwable th) {
            objM = q.M(th);
        }
        Object obj = Boolean.FALSE;
        if (objM instanceof q5.j) {
            objM = obj;
        }
        return ((Boolean) objM).booleanValue();
    }

    public final boolean isVpnConnected(Context context) {
        Object objM;
        k.e(context, "context");
        try {
            Object systemService = context.getSystemService("connectivity");
            k.c(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
            ConnectivityManager connectivityManager = (ConnectivityManager) systemService;
            Network[] allNetworks = connectivityManager.getAllNetworks();
            k.d(allNetworks, "cm.allNetworks");
            int length = allNetworks.length;
            boolean z2 = false;
            int i2 = 0;
            while (true) {
                if (i2 < length) {
                    NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(allNetworks[i2]);
                    if (networkCapabilities != null && networkCapabilities.hasTransport(4)) {
                        z2 = true;
                        break;
                    }
                    i2++;
                } else {
                    break;
                }
            }
            objM = Boolean.valueOf(z2);
        } catch (Throwable th) {
            objM = q.M(th);
        }
        Object obj = Boolean.FALSE;
        if (objM instanceof q5.j) {
            objM = obj;
        }
        return ((Boolean) objM).booleanValue();
    }
}
