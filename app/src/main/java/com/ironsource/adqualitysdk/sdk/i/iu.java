package com.ironsource.adqualitysdk.sdk.i;

import android.graphics.Color;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import com.vungle.ads.internal.protos.Sdk;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class iu implements Runnable {

    /* JADX INFO: renamed from: ﮐ, reason: contains not printable characters */
    private static int f2583 = 1;

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private static char f2584 = 54003;

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private static char f2585 = 51652;

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private static char f2586 = 61960;

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private static int f2587 = 0;

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private static char f2588 = 23952;

    @Override // java.lang.Runnable
    public final void run() {
        f2583 = (f2587 + Sdk.SDKError.Reason.INVALID_RI_ENDPOINT_VALUE) % 128;
        try {
            mo306();
            int i2 = f2583 + 69;
            f2587 = i2 % 128;
            if (i2 % 2 != 0) {
                int i8 = 3 / 0;
            }
        } catch (Throwable th) {
            try {
                mo719(th);
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX INFO: renamed from: ﻐ */
    public abstract void mo306() throws Exception;

    /* JADX INFO: renamed from: ﾒ */
    public void mo719(Throwable th) {
        String strIntern = m2560("풎꺘韓賱磨ƽ⥤⼓㴁\ud85d皷歫늦\ue233", 14 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1))).intern();
        StringBuilder sb = new StringBuilder();
        sb.append(m2560("睐ㄤ숆礰ፃ㭌Ᾰ맞♉䩬댂ҭ蕧옶爗ﵝ", 14 - ExpandableListView.getPackedPositionChild(0L)).intern());
        sb.append(getClass().getName());
        String string = sb.toString();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(m2560("篑騼\uf27d갱袦萦", (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 5).intern());
        sb2.append(getClass().getName());
        sb2.append(m2560("\uf0dc䄆", 1 - View.MeasureSpec.getSize(0)).intern());
        kd.m2916(strIntern, string, sb2.toString(), th);
        String strIntern2 = m2560("풎꺘韓賱磨ƽ⥤⼓㴁\ud85d皷歫늦\ue233", Color.red(0) + 14).intern();
        StringBuilder sb3 = new StringBuilder();
        sb3.append(m2560("睐ㄤ숆礰ፃ㭌Ᾰ맞♉䩬댂ҭ蕧옶爗ﵝ", TextUtils.indexOf("", "", 0) + 15).intern());
        sb3.append(getClass().getName());
        k.m2863(strIntern2, sb3.toString());
        k.m2861(m2560("풎꺘韓賱磨ƽ⥤⼓㴁\ud85d皷歫늦\ue233", (ViewConfiguration.getTouchSlop() >> 8) + 14).intern(), m2560("扳큗拓\uded6䦣呱\uf125≎", MotionEvent.axisFromString("") + 9).intern(), th);
        int i2 = f2583 + 41;
        f2587 = i2 % 128;
        if (i2 % 2 != 0) {
            throw null;
        }
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private static String m2560(String str, int i2) {
        String str2;
        Object charArray = str;
        if (str != null) {
            charArray = str.toCharArray();
        }
        char[] cArr = (char[]) charArray;
        synchronized (o.f2985) {
            try {
                char[] cArr2 = new char[cArr.length];
                o.f2986 = 0;
                char[] cArr3 = new char[2];
                while (true) {
                    int i8 = o.f2986;
                    if (i8 < cArr.length) {
                        cArr3[0] = cArr[i8];
                        cArr3[1] = cArr[i8 + 1];
                        int i9 = 58224;
                        for (int i10 = 0; i10 < 16; i10++) {
                            char c7 = cArr3[1];
                            char c8 = cArr3[0];
                            char c9 = (char) (c7 - (((c8 + i9) ^ ((c8 << 4) + f2584)) ^ ((c8 >>> 5) + f2586)));
                            cArr3[1] = c9;
                            cArr3[0] = (char) (c8 - (((c9 >>> 5) + f2588) ^ ((c9 + i9) ^ ((c9 << 4) + f2585))));
                            i9 -= 40503;
                        }
                        int i11 = o.f2986;
                        cArr2[i11] = cArr3[0];
                        cArr2[i11 + 1] = cArr3[1];
                        o.f2986 = i11 + 2;
                    } else {
                        str2 = new String(cArr2, 0, i2);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return str2;
    }
}
