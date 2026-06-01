package com.ironsource;

import android.util.Base64;
import com.bumptech.glide.load.Key;
import com.ironsource.mediationsdk.logger.IronLog;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class P6 {
    public static String a(String str) {
        try {
            return new String(Base64.decode(str, 0), Key.STRING_CHARSET_NAME);
        } catch (Exception e) {
            C2531r4.d().a(e);
            IronLog.INTERNAL.error(e.toString());
            return "";
        }
    }

    public static String b(String str) {
        return Base64.encodeToString(str.getBytes(), 10);
    }
}
