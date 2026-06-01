package com.ironsource.adqualitysdk.sdk.i;

import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.ViewConfiguration;
import com.vungle.ads.internal.protos.Sdk;
import io.bidmachine.BidMachine;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class gg extends gk {

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private static int f2165 = 140;

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private static int f2166 = 0;

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private static int f2167 = 1;

    @Override // com.ironsource.adqualitysdk.sdk.i.gk
    /* JADX INFO: renamed from: ﻐ */
    public final String mo2240() {
        int iIndexOf;
        int iNormalizeMetaState;
        int i2;
        int i8 = f2166 + Sdk.SDKError.Reason.INVALID_METRICS_ENDPOINT_VALUE;
        f2167 = i8 % 128;
        if (i8 % 2 == 0) {
            iIndexOf = 16000 - TextUtils.indexOf((CharSequence) "", 'A');
            iNormalizeMetaState = KeyEvent.normalizeMetaState(0) + Sdk.SDKError.Reason.PROTOBUF_SERIALIZATION_ERROR_VALUE;
            i2 = 4 >> (ViewConfiguration.getScrollFriction() > 1.0f ? 1 : (ViewConfiguration.getScrollFriction() == 1.0f ? 0 : -1));
        } else {
            iIndexOf = TextUtils.indexOf((CharSequence) "", '0') + 243;
            iNormalizeMetaState = KeyEvent.normalizeMetaState(0) + 10;
            i2 = 4 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1));
        }
        return m2257(iIndexOf, iNormalizeMetaState, "\ufffe\u0003￼\uffff\b\u0003\u0002�\ufffb\u0007", i2, true).intern();
    }

    @Override // com.ironsource.adqualitysdk.sdk.i.gk
    /* JADX INFO: renamed from: ﻛ */
    public final Class mo2241() {
        int i2 = f2166 + 63;
        f2167 = i2 % 128;
        if (i2 % 2 != 0) {
            return BidMachine.class;
        }
        throw null;
    }

    @Override // com.ironsource.adqualitysdk.sdk.i.gk
    /* JADX INFO: renamed from: ﾇ */
    public final bg mo2242() {
        bl blVar = new bl(mo2240());
        int i2 = f2166 + 111;
        f2167 = i2 % 128;
        if (i2 % 2 != 0) {
            return blVar;
        }
        throw null;
    }

    @Override // com.ironsource.adqualitysdk.sdk.i.gk
    /* JADX INFO: renamed from: ﾒ */
    public final String mo2243() {
        int i2 = f2167 + 23;
        f2166 = i2 % 128;
        return (i2 % 2 != 0 ? m2257(23697 % (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)), 47 / TextUtils.indexOf("", "", 1), "\u0005\n\u0003ￏ\u0010\n\u0006\u000f\n\t\u0004\u0002￮\u0005\n￣ￏ\u0006\u000f\n\t\u0004\u0002\u000e", 4 << (ViewConfiguration.getTouchSlop() << 77), false) : m2257((ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 234, 24 - TextUtils.indexOf("", "", 0), "\u0005\n\u0003ￏ\u0010\n\u0006\u000f\n\t\u0004\u0002￮\u0005\n￣ￏ\u0006\u000f\n\t\u0004\u0002\u000e", 6 - (ViewConfiguration.getTouchSlop() >> 8), true)).intern();
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private static String m2257(int i2, int i8, String str, int i9, boolean z2) {
        String str2;
        Object charArray = str;
        if (str != null) {
            charArray = str.toCharArray();
        }
        char[] cArr = (char[]) charArray;
        synchronized (e.f1927) {
            try {
                char[] cArr2 = new char[i8];
                e.f1926 = 0;
                while (true) {
                    int i10 = e.f1926;
                    if (i10 >= i8) {
                        break;
                    }
                    e.f1929 = cArr[i10];
                    cArr2[e.f1926] = (char) (e.f1929 + i2);
                    int i11 = e.f1926;
                    cArr2[i11] = (char) (cArr2[i11] - f2165);
                    e.f1926 = i11 + 1;
                }
                if (i9 > 0) {
                    e.f1928 = i9;
                    char[] cArr3 = new char[i8];
                    System.arraycopy(cArr2, 0, cArr3, 0, i8);
                    int i12 = e.f1928;
                    System.arraycopy(cArr3, 0, cArr2, i8 - i12, i12);
                    int i13 = e.f1928;
                    System.arraycopy(cArr3, i13, cArr2, 0, i8 - i13);
                }
                if (z2) {
                    char[] cArr4 = new char[i8];
                    e.f1926 = 0;
                    while (true) {
                        int i14 = e.f1926;
                        if (i14 >= i8) {
                            break;
                        }
                        cArr4[i14] = cArr2[(i8 - i14) - 1];
                        e.f1926 = i14 + 1;
                    }
                    cArr2 = cArr4;
                }
                str2 = new String(cArr2);
            } catch (Throwable th) {
                throw th;
            }
        }
        return str2;
    }
}
