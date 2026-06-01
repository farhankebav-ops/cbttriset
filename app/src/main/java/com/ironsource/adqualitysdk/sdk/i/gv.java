package com.ironsource.adqualitysdk.sdk.i;

import android.graphics.Color;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ExpandableListView;
import com.vungle.ads.internal.protos.Sdk;
import tv.superawesome.sdk.publisher.AwesomeAds;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class gv extends gk {

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private static int f2234 = 0;

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private static int f2237 = 1;

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private static char[] f2236 = {35916, 36857, 35704, 34670, 33425, 40667, 39447, 38475, 37345, 44320, 43387, 42134, 41155, 48158, 47199, 48047, 46907, 45947, 52877, 51843, 50692, 49742, 56800, 55589, 54649, 53396, 60614, 59408, 58446, 59309, 58123, 65382, 64189, 63196, 61977, 3664, 2529, 1290, 374, 7338, 2986, 2075, 3271, 153, 1399, 6443, 7652, 4541, 5650, 10969, 11922, 9057};

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private static long f2235 = -3085624791276846153L;

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private static String m2275(char c7, int i2, int i8) {
        String str;
        synchronized (c.f1192) {
            try {
                char[] cArr = new char[i2];
                c.f1193 = 0;
                while (true) {
                    int i9 = c.f1193;
                    if (i9 < i2) {
                        cArr[i9] = (char) ((((long) f2236[i8 + i9]) ^ (((long) i9) * f2235)) ^ ((long) c7));
                        c.f1193 = i9 + 1;
                    } else {
                        str = new String(cArr);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return str;
    }

    @Override // com.ironsource.adqualitysdk.sdk.i.gk
    /* JADX INFO: renamed from: ﻐ */
    public final String mo2240() {
        int i2 = f2234 + 73;
        f2237 = i2 % 128;
        return (i2 % 2 == 0 ? m2275((char) ((KeyEvent.getMaxKeyCode() << 8) + 13892), 82 / TextUtils.getCapsMode("", 1, 1), View.MeasureSpec.getSize(1) * 73) : m2275((char) ((KeyEvent.getMaxKeyCode() >> 16) + 3033), 12 - TextUtils.getCapsMode("", 0, 0), View.MeasureSpec.getSize(0) + 40)).intern();
    }

    @Override // com.ironsource.adqualitysdk.sdk.i.gk
    /* JADX INFO: renamed from: ﻛ */
    public final Class mo2241() {
        int i2 = f2234;
        f2237 = (i2 + 21) % 128;
        f2237 = (i2 + 1) % 128;
        return AwesomeAds.class;
    }

    @Override // com.ironsource.adqualitysdk.sdk.i.gk
    /* JADX INFO: renamed from: ﾇ */
    public final bg mo2242() {
        cd cdVar = new cd(mo2240());
        int i2 = f2237 + 115;
        f2234 = i2 % 128;
        if (i2 % 2 != 0) {
            int i8 = 78 / 0;
        }
        return cdVar;
    }

    @Override // com.ironsource.adqualitysdk.sdk.i.gk
    /* JADX INFO: renamed from: ﾒ */
    public final String mo2243() {
        int i2 = f2237 + Sdk.SDKError.Reason.INVALID_METRICS_ENDPOINT_VALUE;
        f2234 = i2 % 128;
        return (i2 % 2 != 0 ? m2275((char) (TextUtils.getOffsetAfter("", 1) * 35896), 16 - Color.red(1), (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1))) : m2275((char) (TextUtils.getOffsetAfter("", 0) + 35896), 40 - Color.red(0), (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)))).intern();
    }
}
