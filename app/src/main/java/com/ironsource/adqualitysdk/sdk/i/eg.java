package com.ironsource.adqualitysdk.sdk.i;

import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.widget.ExpandableListView;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class eg extends ee {

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private static int f1964 = 1;

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private static int f1965 = 57;

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private static int f1966;

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private ee f1967;

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private ee f1968;

    public eg(ee eeVar, ee eeVar2, Cdo cdo) {
        super(cdo);
        this.f1968 = eeVar;
        this.f1967 = eeVar2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0034, code lost:
    
        if (r0.equals(r5.f1968) == false) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0039, code lost:
    
        if (r5.f1968 != null) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x003b, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x003c, code lost:
    
        r0 = r4.f1967;
        r5 = r5.f1967;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0040, code lost:
    
        if (r0 == null) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0046, code lost:
    
        return r0.equals(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0047, code lost:
    
        if (r5 != null) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0049, code lost:
    
        com.ironsource.adqualitysdk.sdk.i.eg.f1966 = (com.ironsource.adqualitysdk.sdk.i.eg.f1964 + 73) % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0051, code lost:
    
        return true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean equals(java.lang.Object r5) {
        /*
            r4 = this;
            int r0 = com.ironsource.adqualitysdk.sdk.i.eg.f1966
            int r0 = r0 + 69
            int r0 = r0 % 128
            com.ironsource.adqualitysdk.sdk.i.eg.f1964 = r0
            r1 = 1
            if (r4 != r5) goto Lc
            return r1
        Lc:
            r2 = 0
            if (r5 == 0) goto L52
            int r0 = r0 + 91
            int r0 = r0 % 128
            com.ironsource.adqualitysdk.sdk.i.eg.f1966 = r0
            java.lang.Class r0 = r4.getClass()
            java.lang.Class r3 = r5.getClass()
            if (r0 == r3) goto L20
            goto L52
        L20:
            com.ironsource.adqualitysdk.sdk.i.eg r5 = (com.ironsource.adqualitysdk.sdk.i.eg) r5
            com.ironsource.adqualitysdk.sdk.i.ee r0 = r4.f1968
            if (r0 == 0) goto L37
            int r3 = com.ironsource.adqualitysdk.sdk.i.eg.f1966
            int r3 = r3 + 39
            int r3 = r3 % 128
            com.ironsource.adqualitysdk.sdk.i.eg.f1964 = r3
            com.ironsource.adqualitysdk.sdk.i.ee r3 = r5.f1968
            boolean r0 = r0.equals(r3)
            if (r0 != 0) goto L3c
            goto L3b
        L37:
            com.ironsource.adqualitysdk.sdk.i.ee r0 = r5.f1968
            if (r0 == 0) goto L3c
        L3b:
            return r2
        L3c:
            com.ironsource.adqualitysdk.sdk.i.ee r0 = r4.f1967
            com.ironsource.adqualitysdk.sdk.i.ee r5 = r5.f1967
            if (r0 == 0) goto L47
            boolean r5 = r0.equals(r5)
            return r5
        L47:
            if (r5 != 0) goto L52
            int r5 = com.ironsource.adqualitysdk.sdk.i.eg.f1964
            int r5 = r5 + 73
            int r5 = r5 % 128
            com.ironsource.adqualitysdk.sdk.i.eg.f1966 = r5
            return r1
        L52:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.adqualitysdk.sdk.i.eg.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        int i2 = f1964 + 81;
        f1966 = i2 % 128;
        if (i2 % 2 != 0) {
            throw null;
        }
        ee eeVar = this.f1968;
        int iHashCode = 0;
        int iHashCode2 = (eeVar != null ? eeVar.hashCode() : 0) * 31;
        ee eeVar2 = this.f1967;
        if (eeVar2 != null) {
            iHashCode = eeVar2.hashCode();
            f1964 = (f1966 + 89) % 128;
        }
        return iHashCode2 + iHashCode;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f1968);
        sb.append(m2193(TextUtils.indexOf("", "", 0) + 89, -ExpandableListView.getPackedPositionChild(0L), "\u0000", -ExpandableListView.getPackedPositionChild(0L), false).intern());
        sb.append(mo2195());
        sb.append(m2193(88 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)), View.MeasureSpec.getSize(0) + 1, "\u0000", Gravity.getAbsoluteGravity(0, 0) + 1, false).intern());
        sb.append(this.f1967);
        String string = sb.toString();
        f1964 = (f1966 + 47) % 128;
        return string;
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    public final ee m2194() {
        int i2 = f1966 + 91;
        f1964 = i2 % 128;
        if (i2 % 2 != 0) {
            return this.f1967;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    public abstract String mo2195();

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    public final ee m2196() {
        int i2 = (f1966 + 27) % 128;
        f1964 = i2;
        ee eeVar = this.f1968;
        int i8 = i2 + 73;
        f1966 = i8 % 128;
        if (i8 % 2 != 0) {
            int i9 = 8 / 0;
        }
        return eeVar;
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private static String m2193(int i2, int i8, String str, int i9, boolean z2) {
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
                    cArr2[i11] = (char) (cArr2[i11] - f1965);
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
