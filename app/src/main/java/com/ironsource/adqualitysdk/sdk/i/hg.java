package com.ironsource.adqualitysdk.sdk.i;

import android.os.Process;
import android.view.View;
import com.vungle.ads.internal.protos.Sdk;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class hg extends ha<View.OnClickListener> implements View.OnClickListener {

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private static int f2302 = 1;

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private static long f2303 = -7586403987514378242L;

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private static int f2304;

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private a f2305;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface a {
        /* JADX INFO: renamed from: ﾇ */
        void mo1873(hg hgVar, View view);
    }

    public hg(View.OnClickListener onClickListener, a aVar) {
        super(onClickListener);
        this.f2305 = aVar;
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private static String m2288(String str, int i2) {
        String str2;
        Object charArray = str;
        if (str != null) {
            charArray = str.toCharArray();
        }
        char[] cArr = (char[]) charArray;
        synchronized (j.f2671) {
            try {
                j.f2669 = i2;
                char[] cArr2 = new char[cArr.length];
                j.f2670 = 0;
                while (true) {
                    int i8 = j.f2670;
                    if (i8 < cArr.length) {
                        cArr2[i8] = (char) (((long) (cArr[i8] ^ (j.f2669 * i8))) ^ f2303);
                        j.f2670++;
                    } else {
                        str2 = new String(cArr2);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return str2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        f2302 = (f2304 + 45) % 128;
        try {
            this.f2305.mo1873(this, view);
        } catch (Throwable th) {
            kd.m2919(m2288("㞱欷軳≧䔋\uf8de᱿뼣튯癒ꤌ첶恄菠⚮婳\ufdebႊ됯ퟩઓ긹쇋撍", 23719 - (Process.myPid() >> 22)).intern(), m2288("㞻줓쪲챌췰컅쀭쇉쌦쐄얜읉\ud8c6\ud984\udfcdb\ude6b\udf1f킵퉁펲풚혺ퟴ\ue97a\uea10\uebbb\ued50", (Process.myPid() >> 22) + 65183).intern(), th, false);
        }
        if (mo831() != null) {
            int i2 = f2304 + Sdk.SDKError.Reason.TPAT_ERROR_VALUE;
            f2302 = i2 % 128;
            if (i2 % 2 != 0) {
                mo831().onClick(view);
            } else {
                mo831().onClick(view);
                throw null;
            }
        }
    }
}
