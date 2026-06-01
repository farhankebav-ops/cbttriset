package com.ironsource.adqualitysdk.sdk.i;

import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import com.ironsource.adqualitysdk.sdk.ISAdQualitySegment;
import com.vungle.ads.internal.protos.Sdk;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class an {

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private static int f356 = 0;

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private static int f357 = 1;

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private static long f358 = 7438855818920780276L;

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private final ah f359;

    public an(ah ahVar) {
        this.f359 = ahVar;
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private static String m518(String str, int i2) {
        String str2;
        Object charArray = str;
        if (str != null) {
            charArray = str.toCharArray();
        }
        char[] cArr = (char[]) charArray;
        synchronized (i.f2441) {
            try {
                char[] cArrM2497 = i.m2497(f358, cArr, i2);
                i.f2442 = 4;
                while (true) {
                    int i8 = i.f2442;
                    if (i8 < cArrM2497.length) {
                        i.f2443 = i8 - 4;
                        cArrM2497[i8] = (char) (((long) (cArrM2497[i8] ^ cArrM2497[i8 % 4])) ^ (((long) r2) * f358));
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

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private static JSONObject m519(ISAdQualitySegment iSAdQualitySegment) {
        JSONObject jSONObject = new JSONObject(iSAdQualitySegment.getCustomData());
        try {
            if (!TextUtils.isEmpty(iSAdQualitySegment.getName())) {
                f357 = (f356 + Sdk.SDKError.Reason.TPAT_ERROR_VALUE) % 128;
                jSONObject.put(m518("\udc11ⴔ\udc62\uf641첇㗇딅Ⴔ", View.MeasureSpec.getSize(0)).intern(), iSAdQualitySegment.getName());
            }
            if (iSAdQualitySegment.getAge() != -1) {
                jSONObject.put(m518("裢ͺ袑쪪\ue2efथᨼ뾅", Color.blue(0)).intern(), iSAdQualitySegment.getAge());
            }
            if (!TextUtils.isEmpty(iSAdQualitySegment.getGender())) {
                jSONObject.put(m518("濢⯶澑ۄ쩥앉\uf0e1啓", ViewConfiguration.getLongPressTimeout() >> 16).intern(), iSAdQualitySegment.getGender());
            }
            if (iSAdQualitySegment.getLevel() != -1) {
                f357 = (f356 + 93) % 128;
                jSONObject.put(m518("ᷨ팰ᶛ襼㊨䫢\uf7b3刃", View.getDefaultSize(0, 0)).intern(), iSAdQualitySegment.getLevel());
            }
            if (iSAdQualitySegment.getIsPaying() != null) {
                jSONObject.put(m518("揶⸻掅\uedf7쾿\u2e7e籪\ud9cf", TextUtils.getTrimmedLength("")).intern(), iSAdQualitySegment.getIsPaying().get());
            }
            if (iSAdQualitySegment.getInAppPurchasesTotal() != -1.0d) {
                jSONObject.put(m518("뱒茎밡\uec70抓⿹몹㯶ἕ", TextUtils.lastIndexOf("", '0', 0) + 1).intern(), iSAdQualitySegment.getInAppPurchasesTotal());
            }
            if (iSAdQualitySegment.getUserCreationDate() != 0) {
                int i2 = f357 + 27;
                f356 = i2 % 128;
                jSONObject.put(i2 % 2 != 0 ? m518("듐猢뒣\uf509銣㚂\ue462䇚", ViewConfiguration.getJumpTapTimeout() - 61).intern() : m518("듐猢뒣\uf509銣㚂\ue462䇚", ViewConfiguration.getJumpTapTimeout() >> 16).intern(), iSAdQualitySegment.getUserCreationDate());
                return jSONObject;
            }
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    public final void m520(ISAdQualitySegment iSAdQualitySegment) {
        ah ahVar;
        int i2;
        int i8 = f357 + 89;
        f356 = i8 % 128;
        if (i8 % 2 != 0) {
            ahVar = this.f359;
            i2 = (ExpandableListView.getPackedPositionForChild(1, 1) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(1, 1) == 0L ? 0 : -1)) * (-1);
        } else {
            ahVar = this.f359;
            i2 = (-1) - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1));
        }
        ahVar.m458(m518("澵묛濆㿄媊ﱘ쨺\ue816튺澹琛䉸恰䫡\uec38", i2).intern(), m519(iSAdQualitySegment));
    }
}
