package com.ironsource.adqualitysdk.sdk.i;

import android.content.Context;
import android.text.TextUtils;
import com.ironsource.adqualitysdk.sdk.i.ie;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class ib {

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private ii f2444;

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private String f2445;

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private ie f2446;

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private Context f2447;

    public ib(Context context, String str, String str2) {
        this.f2447 = context.getApplicationContext();
        this.f2445 = str2;
        this.f2444 = new ii(this.f2447, str);
        this.f2446 = new ie(Cif.f2467, this.f2447.getPackageName(), ih.m2522(this.f2447), this.f2445);
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    public final void m2498(String str) {
        try {
            this.f2444.m2532(str);
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    public final int m2499(String str) {
        try {
            return this.f2444.m2533(str);
        } catch (Throwable unused) {
            return 0;
        }
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    public final String m2502(String str) {
        try {
            String strM2529 = this.f2444.m2529(str);
            if (strM2529 == null || TextUtils.isEmpty(strM2529)) {
                return strM2529;
            }
            try {
                return this.f2446.m2517(strM2529);
            } catch (ie.a unused) {
                return "";
            }
        } catch (Throwable unused2) {
            return null;
        }
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    public final HashMap<String, String> m2500(String str, int i2) {
        try {
            HashMap<String, String> mapM2530 = this.f2444.m2530(str, i2);
            HashMap<String, String> map = new HashMap<>();
            for (String str2 : mapM2530.keySet()) {
                String str3 = mapM2530.get(str2);
                if (str3 != null && !TextUtils.isEmpty(str3)) {
                    try {
                        map.put(str2, this.f2446.m2517(str3));
                    } catch (ie.a unused) {
                    }
                }
            }
            return map;
        } catch (Throwable unused2) {
            return null;
        }
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    public final void m2501(String str, String str2) {
        try {
            this.f2444.m2531(str, this.f2446.m2518(str2));
        } catch (Throwable unused) {
        }
    }
}
