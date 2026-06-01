package com.ironsource;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.ironsource.C2300e4;
import com.ironsource.mediationsdk.logger.IronLog;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.ironsource.b4, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class C2246b4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f8038a = "NETWORK_TYPE_WIFI";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f8039b = "NETWORK_TYPE_VPN";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f8040c = "NETWORK_TYPE_ETHERNET";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f8041d = "NETWORK_TYPE_UNKNOWN";
    public static final String e = "notReachable";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f8042f = "PHONE_TYPE_NONE";
    public static final String g = "NETWORK_TYPE_GPRS";
    public static final String h = "NETWORK_TYPE_EDGE";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String f8043i = "NETWORK_TYPE_UMTS";
    public static final String j = "NETWORK_TYPE_CDMA";
    public static final String k = "NETWORK_TYPE_EVDO_0";
    public static final String l = "NETWORK_TYPE_EVDO_A";
    public static final String m = "NETWORK_TYPE_1xRTT";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final String f8044n = "NETWORK_TYPE_HSDPA";

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final String f8045o = "NETWORK_TYPE_HSUPA";
    public static final String p = "NETWORK_TYPE_HSPA";

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final String f8046q = "NETWORK_TYPE_IDEN";

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final String f8047r = "NETWORK_TYPE_EVDO_B";

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final String f8048s = "NETWORK_TYPE_LTE";

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final String f8049t = "NETWORK_TYPE_EHRPD";

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final String f8050u = "NETWORK_TYPE_HSPAP";

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final String f8051v = "NETWORK_TYPE_GSM";

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final String f8052w = "NETWORK_TYPE_TD_SCDMA";

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final String f8053x = "NETWORK_TYPE_IWLAN";
    public static final String y = "NETWORK_TYPE_LTE_CA";

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final String f8054z = "NETWORK_TYPE_NR";

    public static String a(Network network, Context context) {
        if (context == null) {
            return "none";
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (network != null && connectivityManager != null) {
            try {
                NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(network);
                return networkCapabilities == null ? c(context) : networkCapabilities.hasTransport(1) ? C2228a4.f7946b : networkCapabilities.hasTransport(0) ? C2228a4.f7945a : c(context);
            } catch (Exception e4) {
                C2531r4.d().a(e4);
                IronLog.INTERNAL.error(e4.toString());
            }
        }
        return "none";
    }

    public static String b(Context context) {
        return a(a(context), context);
    }

    private static String c(Context context) {
        String strA = C2228a4.a(context);
        return TextUtils.isEmpty(strA) ? "none" : strA;
    }

    public static String d(Context context) {
        ConnectivityManager connectivityManager;
        NetworkInfo activeNetworkInfo;
        if (context != null && (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) != null) {
            Network networkA = a(connectivityManager);
            if (networkA == null) {
                return e;
            }
            try {
                NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(networkA);
                if (networkCapabilities == null) {
                    return f8041d;
                }
                if (networkCapabilities.hasTransport(1)) {
                    return f8038a;
                }
                if (networkCapabilities.hasTransport(0) && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null) {
                    return a(activeNetworkInfo.getSubtype());
                }
            } catch (Throwable th) {
                C2531r4.d().a(th);
                IronLog.INTERNAL.error("Error getting network capabilities: " + th);
            }
        }
        return f8041d;
    }

    public static boolean e(Context context) {
        return b(context, a(context)).equals("vpn");
    }

    private static String b(Context context, Network network) {
        NetworkCapabilities networkCapabilities;
        if (network != null && context != null) {
            try {
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                if (connectivityManager != null && (networkCapabilities = connectivityManager.getNetworkCapabilities(network)) != null) {
                    if (networkCapabilities.hasTransport(1)) {
                        return C2228a4.f7946b;
                    }
                    if (networkCapabilities.hasTransport(0)) {
                        return C2228a4.g;
                    }
                    if (networkCapabilities.hasTransport(4)) {
                        return "vpn";
                    }
                    if (networkCapabilities.hasTransport(3)) {
                        return C2228a4.e;
                    }
                    if (networkCapabilities.hasTransport(5)) {
                        return C2228a4.h;
                    }
                    if (networkCapabilities.hasTransport(6)) {
                        return C2228a4.f7950i;
                    }
                    if (networkCapabilities.hasTransport(2)) {
                        return C2228a4.f7948d;
                    }
                }
            } catch (Exception e4) {
                C2531r4.d().a(e4);
                IronLog.INTERNAL.error(e4.toString());
            }
        }
        return "";
    }

    public static Network a(Context context) {
        if (context == null) {
            return null;
        }
        return a((ConnectivityManager) context.getSystemService("connectivity"));
    }

    public static JSONObject a(Context context, Network network) {
        NetworkCapabilities networkCapabilities;
        if (context == null) {
            return new JSONObject();
        }
        JSONObject jSONObject = new JSONObject();
        if (network != null) {
            try {
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                if (connectivityManager != null && (networkCapabilities = connectivityManager.getNetworkCapabilities(network)) != null) {
                    jSONObject.put("networkCapabilities", networkCapabilities.toString());
                    jSONObject.put("downloadSpeed", networkCapabilities.getLinkDownstreamBandwidthKbps());
                    jSONObject.put("uploadSpeed", networkCapabilities.getLinkUpstreamBandwidthKbps());
                    jSONObject.put(C2300e4.i.f8422v, e(context));
                    return jSONObject;
                }
            } catch (Exception e4) {
                C2531r4.d().a(e4);
                IronLog.INTERNAL.error(e4.toString());
            }
        }
        return jSONObject;
    }

    private static String a(int i2) {
        switch (i2) {
            case 0:
                return f8042f;
            case 1:
                return g;
            case 2:
                return h;
            case 3:
                return f8043i;
            case 4:
                return j;
            case 5:
                return k;
            case 6:
                return l;
            case 7:
                return m;
            case 8:
                return f8044n;
            case 9:
                return f8045o;
            case 10:
                return p;
            case 11:
                return f8046q;
            case 12:
                return f8047r;
            case 13:
                return f8048s;
            case 14:
                return f8049t;
            case 15:
                return f8050u;
            case 16:
                return f8051v;
            case 17:
                return f8052w;
            case 18:
                return f8053x;
            case 19:
                return y;
            case 20:
                return f8054z;
            default:
                return f8041d;
        }
    }

    @Nullable
    private static Network a(ConnectivityManager connectivityManager) {
        try {
            return connectivityManager.getActiveNetwork();
        } catch (Throwable th) {
            C2531r4.d().a(th);
            return null;
        }
    }
}
