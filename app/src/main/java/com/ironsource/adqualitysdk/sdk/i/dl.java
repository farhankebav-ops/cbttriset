package com.ironsource.adqualitysdk.sdk.i;

import android.os.Process;
import android.text.TextUtils;
import com.vungle.ads.internal.protos.Sdk;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class dl {

    /* JADX INFO: renamed from: ﮐ, reason: contains not printable characters */
    private static int f1782 = 1;

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private static int f1783 = 0;

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private static long f1784 = -6404422537017804246L;

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private boolean f1785;

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private boolean f1786;

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private String f1787;

    public dl(JSONObject jSONObject) {
        this.f1785 = jSONObject.optBoolean(m2049("鹽鸐ض㱽뗢쇟䐧\uea37皁⒌\ue96c퍤佌ന", (Process.getThreadPriority(0) + 20) >> 6).intern());
        this.f1786 = jSONObject.optBoolean(m2049("䣷䢖ꁰ騼֟熿Ⰺ舑ꀭ苯夂뭅駉", (-1) - TextUtils.lastIndexOf("", '0', 0)).intern());
        this.f1787 = dy.m2174(jSONObject.optString(m2049("ꡨꠅﹻ쐴嗓⇳琥\uda33䂯\udccd", (-1) - TextUtils.lastIndexOf("", '0', 0, 0)).intern()));
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    public final boolean m2050() {
        int i2 = f1783;
        boolean z2 = this.f1786;
        int i8 = i2 + Sdk.SDKError.Reason.ASSET_FAILED_STATUS_CODE_VALUE;
        f1782 = i8 % 128;
        if (i8 % 2 != 0) {
            return z2;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    public final String m2051() {
        int i2 = f1783;
        String str = this.f1787;
        f1782 = (i2 + 51) % 128;
        return str;
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    public final boolean m2052() {
        int i2 = f1782;
        int i8 = i2 + 65;
        f1783 = i8 % 128;
        if (i8 % 2 != 0) {
            throw null;
        }
        boolean z2 = this.f1785;
        int i9 = i2 + 103;
        f1783 = i9 % 128;
        if (i9 % 2 != 0) {
            int i10 = 93 / 0;
        }
        return z2;
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private static String m2049(String str, int i2) {
        String str2;
        Object charArray = str;
        if (str != null) {
            charArray = str.toCharArray();
        }
        char[] cArr = (char[]) charArray;
        synchronized (i.f2441) {
            try {
                char[] cArrM2497 = i.m2497(f1784, cArr, i2);
                i.f2442 = 4;
                while (true) {
                    int i8 = i.f2442;
                    if (i8 < cArrM2497.length) {
                        i.f2443 = i8 - 4;
                        cArrM2497[i8] = (char) (((long) (cArrM2497[i8] ^ cArrM2497[i8 % 4])) ^ (((long) r2) * f1784));
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
