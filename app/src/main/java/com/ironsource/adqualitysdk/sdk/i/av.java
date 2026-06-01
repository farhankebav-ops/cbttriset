package com.ironsource.adqualitysdk.sdk.i;

import android.text.TextUtils;
import com.ironsource.adqualitysdk.sdk.i.aq;
import com.vungle.ads.internal.protos.Sdk;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class av extends aq.AnonymousClass1 {

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private static int f453 = 0;

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private static long f454 = 5536355435612675339L;

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private static int f455 = 1;

    public av(ax axVar) {
        m566(axVar);
    }

    /* JADX INFO: renamed from: ﱟ, reason: contains not printable characters */
    public final boolean m639() {
        f455 = (f453 + 95) % 128;
        boolean zOptBoolean = m565().optBoolean(m638("맠♭릇컊㬑\uf4bfญ奏", 1 - TextUtils.getCapsMode("", 0, 0)).intern(), true);
        f453 = (f455 + Sdk.SDKError.Reason.JSON_ENCODE_ERROR_VALUE) % 128;
        return zOptBoolean;
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    public final int m640() {
        f455 = (f453 + 27) % 128;
        int iM733 = m564().m733();
        int i2 = f453 + 115;
        f455 = i2 % 128;
        if (i2 % 2 != 0) {
            return iM733;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    public final List<String> m641() {
        f455 = (f453 + 31) % 128;
        List<String> listM735 = m564().m735();
        f455 = (f453 + 107) % 128;
        return listM735;
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    public final boolean m642() {
        JSONObject jSONObjectM565;
        int iIndexOf;
        int i2 = f455 + 43;
        f453 = i2 % 128;
        if (i2 % 2 != 0) {
            jSONObjectM565 = m565();
            iIndexOf = TextUtils.indexOf((CharSequence) "", 'Z', 1, 1);
        } else {
            jSONObjectM565 = m565();
            iIndexOf = TextUtils.indexOf((CharSequence) "", '0', 0, 0);
        }
        return jSONObjectM565.optBoolean(m638("\u1b4dꖨᬪ鄬룔ꭌ\ue4c3뎁", -iIndexOf).intern(), true);
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    public final List<String> m643() {
        int i2 = f455 + 79;
        f453 = i2 % 128;
        if (i2 % 2 != 0) {
            m564().m736();
            throw null;
        }
        List<String> listM736 = m564().m736();
        f453 = (f455 + Sdk.SDKError.Reason.INVALID_RI_ENDPOINT_VALUE) % 128;
        return listM736;
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    public final int m644() {
        f455 = (f453 + 47) % 128;
        int iM737 = m564().m737();
        int i2 = f453 + 39;
        f455 = i2 % 128;
        if (i2 % 2 != 0) {
            return iM737;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private static String m638(String str, int i2) {
        String str2;
        Object charArray = str;
        if (str != null) {
            charArray = str.toCharArray();
        }
        char[] cArr = (char[]) charArray;
        synchronized (i.f2441) {
            try {
                char[] cArrM2497 = i.m2497(f454, cArr, i2);
                i.f2442 = 4;
                while (true) {
                    int i8 = i.f2442;
                    if (i8 < cArrM2497.length) {
                        i.f2443 = i8 - 4;
                        cArrM2497[i8] = (char) (((long) (cArrM2497[i8] ^ cArrM2497[i8 % 4])) ^ (((long) r2) * f454));
                        i.f2442 = i8 + 1;
                    } else {
                        str2 = new String(cArrM2497, 4, cArrM2497.length - 4);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return str2;
    }
}
