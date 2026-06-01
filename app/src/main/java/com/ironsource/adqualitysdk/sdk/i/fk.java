package com.ironsource.adqualitysdk.sdk.i;

import android.graphics.Color;
import android.media.AudioTrack;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import com.vungle.ads.internal.protos.Sdk;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class fk extends fr {

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private static int f2056 = 1;

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private static int f2057 = 123;

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private static int f2058;

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private fr[] f2059;

    public fk(List<fr> list) {
        fr[] frVarArr = new fr[list.size()];
        this.f2059 = frVarArr;
        list.toArray(frVarArr);
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private static String m2226(int i2, int i8, String str, int i9, boolean z2) {
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
                    cArr2[i11] = (char) (cArr2[i11] - f2057);
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

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null) {
            f2058 = (f2056 + 25) % 128;
            if (fk.class == obj.getClass()) {
                fr[] frVarArr = this.f2059;
                fr[] frVarArr2 = ((fk) obj).f2059;
                if (frVarArr != null) {
                    return frVarArr.equals(frVarArr2);
                }
                if (frVarArr2 == null) {
                    f2058 = (f2056 + 115) % 128;
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        int i2 = f2056 + 63;
        f2058 = i2 % 128;
        if (i2 % 2 != 0) {
            throw null;
        }
        fr[] frVarArr = this.f2059;
        if (frVarArr == null) {
            return 0;
        }
        int iHashCode = frVarArr.hashCode();
        f2056 = (f2058 + 29) % 128;
        return iHashCode;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(m2226(ExpandableListView.getPackedPositionType(0L) + 189, (ViewConfiguration.getJumpTapTimeout() >> 16) + 2, "9\uffc8", 1 - (ViewConfiguration.getJumpTapTimeout() >> 16), true).intern());
        for (fr frVar : this.f2059) {
            f2056 = (f2058 + 39) % 128;
            sb.append(m2226(156 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)), (ViewConfiguration.getPressedStateDuration() >> 16) + 4, "\u0000\u0000\u0000\u0000", (ViewConfiguration.getLongPressTimeout() >> 16) + 2, false).intern());
            sb.append(frVar.toString());
            sb.append(m2226((ViewConfiguration.getDoubleTapTimeout() >> 16) + Sdk.SDKError.Reason.OMSDK_JS_WRITE_FAILED_VALUE, (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)), "\u0000", 1 - (ViewConfiguration.getKeyRepeatTimeout() >> 16), true).intern());
        }
        String strZ = com.google.android.gms.ads.internal.client.a.z(sb, m2226(248 - (ViewConfiguration.getEdgeSlop() >> 16), 1 - Color.blue(0), "\u0000", View.MeasureSpec.getMode(0) + 1, false));
        int i2 = f2056 + 53;
        f2058 = i2 % 128;
        if (i2 % 2 == 0) {
            return strZ;
        }
        throw null;
    }

    @Override // com.ironsource.adqualitysdk.sdk.i.fr
    /* JADX INFO: renamed from: ﻐ */
    public final du mo2225(ds dsVar, cp cpVar) {
        du duVar = new du(null);
        ds dsVar2 = new ds(dsVar);
        fr[] frVarArr = this.f2059;
        f2058 = (f2056 + Sdk.SDKError.Reason.INVALID_METRICS_ENDPOINT_VALUE) % 128;
        for (fr frVar : frVarArr) {
            f2056 = (f2058 + 1) % 128;
            duVar = frVar.mo2225(dsVar2, cpVar);
            if (duVar.m2151() || duVar.m2154()) {
                break;
            }
            f2056 = (f2058 + Sdk.SDKError.Reason.INVALID_METRICS_ENDPOINT_VALUE) % 128;
            if (duVar.m2148()) {
                return duVar;
            }
        }
        return duVar;
    }
}
