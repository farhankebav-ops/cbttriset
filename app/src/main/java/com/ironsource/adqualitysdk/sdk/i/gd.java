package com.ironsource.adqualitysdk.sdk.i;

import android.graphics.Color;
import android.os.Process;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import com.facebook.ads.AdSettings;
import com.vungle.ads.internal.protos.Sdk;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class gd extends gk {

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private static int f2143 = 1;

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private static int f2145;

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private static char[] f2146 = {'c', 46159, 26669, 7246, 53478, 33985, 14499, 60549, 41314, 21839, 2351, 48395, 29102, 9665, 55716, 36243, 16942, 63073, 43556, 24115, 4837, 50900, 31412, 11913, 58222, 38727, 19251, 11099, 40828, 17182, 14136, 64479, 45042, 5010, 51126};

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private static long f2144 = 4502814317164147744L;

    @Override // com.ironsource.adqualitysdk.sdk.i.gk
    /* JADX INFO: renamed from: ﻐ */
    public final String mo2240() {
        f2143 = (f2145 + Sdk.SDKError.Reason.INVALID_METRICS_ENDPOINT_VALUE) % 128;
        String strIntern = m2252((char) ((Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + 11068), (ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 8, (ViewConfiguration.getKeyRepeatDelay() >> 16) + 27).intern();
        int i2 = f2143 + 49;
        f2145 = i2 % 128;
        if (i2 % 2 != 0) {
            int i8 = 57 / 0;
        }
        return strIntern;
    }

    @Override // com.ironsource.adqualitysdk.sdk.i.gk
    /* JADX INFO: renamed from: ﻛ */
    public final Class mo2241() {
        int i2 = f2145 + 47;
        int i8 = i2 % 128;
        f2143 = i8;
        if (i2 % 2 == 0) {
            throw null;
        }
        f2145 = (i8 + 61) % 128;
        return AdSettings.class;
    }

    @Override // com.ironsource.adqualitysdk.sdk.i.gk
    /* JADX INFO: renamed from: ﾇ */
    public final bg mo2242() {
        bp bpVar = new bp(mo2240());
        f2145 = (f2143 + 1) % 128;
        return bpVar;
    }

    @Override // com.ironsource.adqualitysdk.sdk.i.gk
    /* JADX INFO: renamed from: ﾒ */
    public final String mo2243() {
        f2145 = (f2143 + 69) % 128;
        String strIntern = m2252((char) ExpandableListView.getPackedPositionGroup(0L), Color.rgb(0, 0, 0) + 16777243, (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) - 1).intern();
        f2143 = (f2145 + 67) % 128;
        return strIntern;
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private static String m2252(char c7, int i2, int i8) {
        String str;
        synchronized (c.f1192) {
            try {
                char[] cArr = new char[i2];
                c.f1193 = 0;
                while (true) {
                    int i9 = c.f1193;
                    if (i9 < i2) {
                        cArr[i9] = (char) ((((long) f2146[i8 + i9]) ^ (((long) i9) * f2144)) ^ ((long) c7));
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
}
