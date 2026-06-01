package sg.bigo.ads.common.aa;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import android.webkit.WebSettings;
import sg.bigo.ads.common.utils.r;

/* JADX INFO: loaded from: classes6.dex */
public final class c {
    public static int a(Context context) {
        if (context == null) {
            return 0;
        }
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return 0;
            }
            int type = activeNetworkInfo.getType();
            if (type == 1) {
                return 3;
            }
            if (type != 0) {
                return 0;
            }
            switch (activeNetworkInfo.getSubtype()) {
            }
            return 0;
        } catch (Throwable th) {
            sg.bigo.ads.common.t.a.a(0, "NetworkUtil", "exception on get network info:" + th.getMessage());
            return 0;
        }
    }

    public static boolean b(Context context) {
        if (context == null) {
            return true;
        }
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                return activeNetworkInfo.isConnected();
            }
            return false;
        } catch (Exception unused) {
            return true;
        }
    }

    public static String c(Context context) {
        String property;
        String strC = sg.bigo.ads.common.x.a.c();
        long jCurrentTimeMillis = System.currentTimeMillis();
        long jD = jCurrentTimeMillis - sg.bigo.ads.common.x.a.d();
        if (!TextUtils.isEmpty(strC) && jD > 0 && jD < r.f16037d.a(1) * 7) {
            return strC;
        }
        try {
            property = WebSettings.getDefaultUserAgent(context);
        } catch (Exception unused) {
            property = System.getProperty("http.agent");
        }
        StringBuilder sb = new StringBuilder();
        int length = property.length();
        for (int i2 = 0; i2 < length; i2++) {
            char cCharAt = property.charAt(i2);
            if (cCharAt <= 31 || cCharAt >= 127) {
                sb.append(String.format("\\u%04x", Integer.valueOf(cCharAt)));
            } else {
                sb.append(cCharAt);
            }
        }
        String string = sb.toString();
        sg.bigo.ads.common.x.a.a(string);
        sg.bigo.ads.common.x.a.b(jCurrentTimeMillis);
        return string;
    }
}
